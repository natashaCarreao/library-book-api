package br.com.library.data.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "OpenLibraryAPI", url = "${open-library.url}")
public interface OpenLibraryClient {

    @GetMapping("people/mekBot/books/want-to-read.json")
    OpenLibraryResponse getAllBooks();
}
