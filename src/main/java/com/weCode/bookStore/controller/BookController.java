package com.weCode.bookStore.controller;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Api(value = "Book Api", tags = "Book Api", produces = "application/json")
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "get list of books", response = BookDto[].class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieve list of books"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to retrieve"),
            @ApiResponse(code = 404, message = "Not found resource")
    })
    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);

    }
}
