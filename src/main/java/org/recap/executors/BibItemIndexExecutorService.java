package org.recap.executors;

import org.apache.camel.ProducerTemplate;
import org.recap.repository.jpa.BibliographicDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * Created by chenchulakshmig on 21/6/16.
 */
@Service
public class BibItemIndexExecutorService extends IndexExecutorService {

    @Autowired
    BibliographicDetailsRepository bibliographicDetailsRepository;

    @Autowired
    ProducerTemplate producerTemplate;

    @Override
    public Callable getCallable(String coreName, int pageNum, int docsPerPage, Integer owningInstitutionId) {
        return new BibItemIndexCallable(solrUrl, coreName, pageNum, docsPerPage, bibliographicDetailsRepository, owningInstitutionId, producerTemplate);
    }

    @Override
    protected Integer getTotalDocCount(Integer owningInstitutionId) {
        Long count = owningInstitutionId == null ? bibliographicDetailsRepository.count() : bibliographicDetailsRepository.countByOwningInstitutionId(owningInstitutionId);
        return count.intValue();
    }

    @Override
    protected String getResourceURL() {
        return bibResourceURL;
    }

    public void setBibliographicDetailsRepository(BibliographicDetailsRepository bibliographicDetailsRepository) {
        this.bibliographicDetailsRepository = bibliographicDetailsRepository;
    }
}
