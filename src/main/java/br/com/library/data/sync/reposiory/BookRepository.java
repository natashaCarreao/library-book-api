package br.com.library.data.sync.reposiory;

import br.com.library.infra.model.document.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository("data_sync_repository")
public interface BookRepository extends ElasticsearchRepository<BookDocument, UUID> {
}
