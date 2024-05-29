package cn.maoyanluo.resttemplate.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TemplateMapper {


    @Select("select * from ${tableName}")
    List<Map<String, Object>> getAll(@Param("tableName") String tableName);

    @Select("select * from ${tableName} where id = #{id}")
    Map<String, Object> getById(@Param("tableName") String tableName, @Param("id") int id);

    int insert(@Param("tableName") String tableName, @Param("params") HashMap<String, Object> map);

    int updateById(@Param("tableName") String tableName, @Param("id") int id, @Param("params") HashMap<String, Object> map);

    @Delete("delete from ${tableName} where id = #{id}")
    int deleteById(@Param("tableName") String tableName, @Param("id") int id);

}
