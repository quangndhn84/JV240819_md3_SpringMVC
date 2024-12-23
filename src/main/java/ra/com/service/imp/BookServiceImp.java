package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.entity.Book;
import ra.com.repository.BookRepository;
import ra.com.service.BookService;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    //Để gọi sang Repository (DI- Dependecy Injection) - Tiêm BookRepository
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public boolean save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public boolean delete(int bookId) {
        return bookRepository.delete(bookId);
    }
}
