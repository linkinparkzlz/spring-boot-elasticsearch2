package com.example.springbootelasticsearch2.repository;

import com.example.springbootelasticsearch2.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.MappingElasticsearchEntityInformation;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public class BookElasticsearchRepository extends AbstractElasticsearchRepository<Book, String> {

    @Autowired
    public BookElasticsearchRepository(ElasticsearchOperations elasticsearchOperations) {

        super(createElasticsearchEntityInformation(), elasticsearchOperations);
        super.setEntityClass(Book.class);

    }

    private static ElasticsearchEntityInformation<Book, String> createElasticsearchEntityInformation() {

        TypeInformation<Book> typeInformation = ClassTypeInformation.from(Book.class);

        ElasticsearchPersistentEntity<Book> entity = new SimpleElasticsearchPersistentEntity<>(typeInformation);

        ElasticsearchEntityInformation<Book, String> information = new MappingElasticsearchEntityInformation<Book, String>(entity);

        return information;

    }


    @Override
    protected String stringIdRepresentation(String s) {
        return s;
    }


}











































