package cn.edu.bupt.booksystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    @TableId(type= IdType.AUTO)
    private Integer id; // ID，自增主键
    private String title; // 书名
    private String author; // 作者
}
