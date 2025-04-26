package br.com.library.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OpenLibraryAPI", url = "${open-library.url}")
public interface OpenLibraryClient {

    @GetMapping("people/mekBot/books/want-to-read.json")
    OpenLibraryResponse getAllBooks();
}
