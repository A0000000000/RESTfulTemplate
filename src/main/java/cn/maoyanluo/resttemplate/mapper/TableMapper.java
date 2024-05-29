package cn.maoyanluo.resttemplate.mapper;

import cn.maoyanluo.resttemplate.bean.Column;
import cn.maoyanluo.resttemplate.bean.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TableMapper {

    int createTable(@Param("table")Table table);


    @Insert("insert into table_list (table_name) values (#{name})")
    int insertTableItem(@Param("name") String name);


    int insertTableColumn(@Param("id") int id, @Param("columns") List<Column> columns);


}
