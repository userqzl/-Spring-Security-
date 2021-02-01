package cn.qzlin.book_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "cn.qzlin.dao")
@SpringBootApplication(scanBasePackages = "cn.qzlin")
public class BookDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookDemoApplication.class, args);
    }

}
