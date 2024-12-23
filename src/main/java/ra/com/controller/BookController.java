package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.entity.Book;
import ra.com.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/bookController")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public String findAllBook(Model model) {
        List<Book> listBooks = bookService.findAll();
        model.addAttribute("listBooks", listBooks);
        return "books";
    }

    @GetMapping("/initCreate")
    public String initCreateBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "newBook";
    }

    @PostMapping("/create")
    public String createBook(Book book) {
        boolean result = bookService.save(book);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdateBook(Model model, int bookId) {
        Book book = bookService.findById(bookId);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("/update")
    public String updateBook(Book book) {
        boolean result = bookService.update(book);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String deleteBook(int bookId) {
        boolean result = bookService.delete(bookId);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
