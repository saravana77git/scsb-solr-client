package org.recap;

import org.apache.solr.client.solrj.SolrClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.recap.admin.SolrAdmin;
import org.recap.repository.jpa.*;
import org.recap.repository.solr.main.BibSolrCrudRepository;
import org.recap.repository.solr.main.BibSolrDocumentRepository;
import org.recap.repository.solr.main.HoldingsSolrCrudRepository;
import org.recap.repository.solr.main.ItemCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
@Transactional
@Rollback()
public class BaseTestCase {

    @Autowired
    public SolrAdmin solrAdmin;

    @Autowired
    public SolrClient solrAdminClient;

    @Autowired
    public BibSolrCrudRepository bibSolrCrudRepository;

    @Autowired
    public HoldingsSolrCrudRepository holdingsSolrCrudRepository;

    @Autowired
    public BibliographicDetailsRepository bibliographicDetailsRepository;

    @Autowired
    public ItemDetailsRepository itemDetailsRepository;

    @Autowired
    public HoldingsDetailsRepository holdingDetailRepository;

    @Autowired
    public ItemStatusDetailsRepository itemStatusDetailsRepository;

    @Autowired
    public InstitutionDetailsRepository institutionDetailRepository;

    @Autowired
    public CollectionGroupDetailsRepository collectionGroupDetailRepository;

    @Autowired
    public ItemCrudRepository itemCrudRepository;

    @Autowired
    BibSolrDocumentRepository bibSolrDocumentRepository;

    @Autowired
    public SolrTemplate solrTemplate;

    @Value("${bib.rest.url}")
    public String bibResourceURL;

    @Value(("${item.rest.url}"))
    public String itemResourceURL;

    @Test
    public void loadContexts() {
        System.out.println();
    }
}
