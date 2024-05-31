package cn.edu.bupt.booksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("cn.edu.bupt.booksystem.mapper")
@SpringBootApplication
public class BookSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSystemApplication.class, args);
    }

}
