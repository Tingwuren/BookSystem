package cn.edu.bupt.booksystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    @TableId(type= IdType.AUTO)
    private Long id; // ID，自增主键
    private String name; // 书籍名字
    private double price; // 书籍价格
    private String type; // 书籍种类
    private String image; // 书籍图片
}
