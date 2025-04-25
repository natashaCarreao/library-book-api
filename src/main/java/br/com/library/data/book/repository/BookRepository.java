package br.com.library.data.book.repository;

import br.com.library.data.book.document.BookDocument;
import br.com.library.data.book.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends ElasticsearchRepository<BookDocument, UUID> {
}
