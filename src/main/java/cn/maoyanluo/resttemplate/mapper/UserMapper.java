package cn.maoyanluo.resttemplate.mapper;

import cn.maoyanluo.resttemplate.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username, password) values (#{user.username}, #{user.password})")
    int insertNewUser(@Param("user") User user);

    @Select("select id, username, password from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);

}
