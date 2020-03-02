package com.smd.learning.repository;

import com.smd.learning.entity.Book;
import com.smd.learning.entity.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
    org.springframework.data.domain.Page<Page> findByBookId(Long bookId, Pageable pageable);
    List<Page> findByBookId(Long bookId);

}
