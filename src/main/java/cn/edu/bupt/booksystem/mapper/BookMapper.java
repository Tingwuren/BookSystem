package cn.edu.bupt.booksystem.mapper;

import cn.edu.bupt.booksystem.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper extends BaseMapper<Book> {
    @Select("SELECT * FROM book LIMIT #{limit} OFFSET #{offset}")
    List<Book> selectBooks(@Param("limit") int limit, @Param("offset") int offset);
}
