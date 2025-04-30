package br.com.library.book.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CacheService implements ICacheService {

    private  static final Logger log = LoggerFactory.getLogger(CacheService.class);

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheService(RedisTemplate<String,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private final ObjectMapper mapper = new ObjectMapper();


    public List<Object> getValues() throws Exception{
        Set<String> keys = redisTemplate.keys("books::*");
        List<Object> values = new ArrayList<>();

        if (keys.isEmpty()) {
            log.info("Not found books in cache");
            return values;
        } else {
            for (String keyCache : keys) {
                redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer(new ObjectMapper()));
                var valuesInCache = redisTemplate.opsForValue().get(keyCache);

                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                var valuesStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(valuesInCache);

                if (valuesStr.startsWith("{\n" +
                        "  \"@class\" : \"br.com.library.book.dto.BookDTO\",")){

                    var bookDTO = mapper.readValue(valuesStr, Object.class);
                    values.add(bookDTO);
                }else {
                    values = mapper.readValue(valuesStr, new TypeReference<>() {  });
                    values.removeFirst();
                }
            }

            log.info("Books found in the cache");
        }
        return values;
    }
}
