package br.com.library.book.repository;

import br.com.library.infra.model.document.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("book_repository")
public interface BookRepository extends ElasticsearchRepository<BookDocument, UUID> {

    Iterable<BookDocument> findByGenre(String genre);

    Iterable<BookDocument> findByAuthorsName(String name);

}
