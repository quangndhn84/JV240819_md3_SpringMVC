package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.entity.Book;
import ra.com.repository.BookRepository;
import ra.com.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBooks = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_book()}");
            ResultSet rs = callSt.executeQuery();
            listBooks = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setStatus(rs.getBoolean("book_status"));
                listBooks.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBooks;
    }

    @Override
    public Book findById(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_book_by_id(?)}");
            callSt.setInt(1, bookId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setStatus(rs.getBoolean("book_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean save(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_book(?,?,?)}");
            callSt.setString(1, book.getBookName());
            callSt.setFloat(2, book.getPrice());
            callSt.setBoolean(3, book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?)}");
            callSt.setInt(1,book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setFloat(3, book.getPrice());
            callSt.setBoolean(4, book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setInt(1,bookId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
