package br.com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBookApiApplication.class, args);
	}

}
