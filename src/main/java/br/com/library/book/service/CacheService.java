package br.com.library.book.service;

import br.com.library.data.sync.dto.BookDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CacheService implements ICacheService {

    private  static final Logger log = LoggerFactory.getLogger(BooksService.class);
    private final StringRedisTemplate redisTemplate;

    @Autowired
    public CacheService(StringRedisTemplate redisTemplate, CacheManager cacheManager) {
        this.redisTemplate = redisTemplate;
        this.cacheManager = cacheManager;
    }

    ObjectMapper maper = new ObjectMapper();

    private final CacheManager cacheManager;

    public Object getValue() throws Exception{
        Cache cache = cacheManager.getCache("books");
        List<String> recentItems = cache.get("books", List.class);

        /*Set<String> chaves = redisTemplate.keys("*"); // Obter todas as chaves (ou usar um padrão, como "cache:*")
        Object _valor = new Object();
        if (!chaves.isEmpty()) {
            for (String chave : chaves) {
                var valor = redisTemplate.opsForValue().get(chave); // Obter o valor
                var list = maper.readValue(valor, new TypeReference<ArrayList<BookDTO>>(){});


                System.out.println("Chave: " + chave + ", Valor: " + list.getFirst());
            }
        } else {
            System.out.println("O cache está vazio.");
        }*/
        return new Object();
    }
}
