package cn.edu.bupt.booksystem.controller;

import cn.edu.bupt.booksystem.entity.Book;
import cn.edu.bupt.booksystem.exception.NotFoundException;
import cn.edu.bupt.booksystem.mapper.BookMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "books", description = "图书管理相关接口")
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookMapper bookMapper;

    @Operation(summary = "获取图书列表", description = "获取图书列表")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "per_page", defaultValue = "10") int perPage) {
        int offset = (page - 1) * perPage;
        int limit = perPage;
        return bookMapper.selectBooks(limit, offset);
    }

    @Operation(summary = "添加图书", description = "添加图书")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> addBook(@RequestBody Book book) {
        book.setId(null); // 确保 id 为空
        bookMapper.insert(book);
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Success");
        return response;
    }

    @Operation(summary = "获取图书", description = "获取图书")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value = "books", key = "#id")
    public Book getBook(@PathVariable int id) {
        Book book = bookMapper.selectById(id);
        if (book == null) {
            throw new NotFoundException("Book not found");
        }
        return book;
    }

    @Operation(summary = "更新图书", description = "更新图书")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        if (bookMapper.updateById(book) <= 0) {
            throw new NotFoundException("Book not found");
        }
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Success");
        return response;
    }

    @Operation(summary = "删除图书", description = "删除图书")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> deleteBook(@PathVariable int id) {
        if (bookMapper.deleteById(id) <= 0) {
            throw new NotFoundException("Book not found");
        }
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Success");
        return response;
    }
}
