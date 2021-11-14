package com.springBootExamples.controller;

import com.springBootExamples.entity.Book;
import com.springBootExamples.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize, @RequestParam Integer currentPage) {
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return bookRepository.findAll(pageable);
    }
    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable) {

        //totaElements count query (not good for performance)
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable) {
        // good for performance
        // Is there more to look at it (twitter facebook etc.)
        return bookRepository.findAll(pageable);
    }
}
