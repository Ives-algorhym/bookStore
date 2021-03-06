package com.weCode.bookStore.repository;

import com.weCode.bookStore.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:inserInitialBookRecordForTest.sql"})
    void shouldBeAbleToFetchAllTheBooksInDB(){
        Iterable<Book> all = bookRepository.findAll();
        Long totalBookCount = StreamSupport.stream(all.spliterator(),false).count();
       // Assertions.assertEquals(totalBookCount,2);

    }
    @Test
    @Sql(scripts = {"classpath:inserInitialBookRecordForTest.sql"})
    void shouldReturnOneBookWhenTitleTestTitle(){
        List<Book> tkigai_test = bookRepository.findBookByTitle("tkigai test");
        Assertions.assertEquals(tkigai_test.size(),1);

    }
}
