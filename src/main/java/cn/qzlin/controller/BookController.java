package cn.qzlin.controller;

import cn.qzlin.enity.Book;
import cn.qzlin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: qzl
 * @created: 2021/02/01 11:29
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 查询所有图书
     * @return
     */
    @RequestMapping("/allBooks")
    public List<Book> allBooks(){
        return bookService.allBooks();
    }

    @RequestMapping("/addBook")
    public Map addBook(String bookName,Integer counts){
        Map<String,String> res = new HashMap<>();
        try{
            bookService.addBook(bookName,counts);
            res.put("code","200");
            res.put("msg","添加成功");
        }catch (Exception e){
            res.put("code","400");
            res.put("msg","添加失败");
        }
        return res;
    }
}
