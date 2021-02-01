package cn.qzlin.enity;

/**
 * @description: 图书实体类
 * @author: qzl
 * @created: 2021/02/01 10:55
 */

public class Book {
    private Integer id;
    private String book_name;
    private Integer counts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}
