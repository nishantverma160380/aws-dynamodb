/*
 * Copyright 2014 dmakariev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.makariev.dynamodb.forum.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.makariev.dynamodb.forum.BatchAggregate;
import com.makariev.dynamodb.forum.Book;
import com.makariev.dynamodb.forum.CatalogItem;
import java.util.List;
import org.deltaset.meta.annotation.DsLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dmakariev
 */
@Service
public class BookRepository {

    private final BaseDynamoDBRepository<Book> repository;

    @Autowired
    public BookRepository(DynamoDBMapper mapper) {
        this.repository = new BaseDynamoDBRepository(mapper, Book.class);
    }
    
    public Book newItem(){
        return new Book();
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public void save(Book item) {
        repository.save(item);
    }

    public Book loadById(@DsLabel("book id") int id) {
        return repository.loadById(id);
    }

    public void warnDelete(Book item) {
        repository.delete(item);
    }

}
