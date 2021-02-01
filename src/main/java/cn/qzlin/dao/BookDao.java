package cn.qzlin.dao;

import cn.qzlin.enity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    /**
     * 查找所有图书
     * @return
     */
    @Select("SELECT * FROM t_book;")
    List<Book> allBooks();

    /**
     * 添加图书
     * @param book_name
     * @param counts
     */
    @Insert("INSERT INTO t_book(book_name,counts) VALUES(#{book_name},#{counts});")
    void addBook(@Param("book_name") String book_name,@Param("counts") Integer counts);
}
