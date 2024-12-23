package ra.com.repository;

import ra.com.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findById(int bookId);

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(int bookId);
}
