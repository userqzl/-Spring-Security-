package cn.qzlin.service;

import cn.qzlin.dao.BookDao;
import cn.qzlin.enity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 图书服务类
 * @author: qzl
 * @created: 2021/02/01 11:35
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 查询所有图书
     *
     * @return
     */
    public List<Book> allBooks() {
        return bookDao.allBooks();
    }

    /**
     * 添加图书
     * @param bookName
     * @param counts
     */
    public void addBook(String bookName, Integer counts){
        bookDao.addBook(bookName,counts);
    }
}
