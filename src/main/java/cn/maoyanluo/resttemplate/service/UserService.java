package cn.maoyanluo.resttemplate.service;

import cn.maoyanluo.resttemplate.bean.User;
import cn.maoyanluo.resttemplate.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int register(User user) {
        User u = userMapper.findUserByUsername(user.getUsername());
        if (u != null && u.getId() != null) {
            return -1;
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        return userMapper.insertNewUser(user);
    }

    public int login(User user) {
        User u = userMapper.findUserByUsername(user.getUsername());
        if (u == null || u.getId() == null) {
            return -1;
        }
        if (u.getPassword() != null && u.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)))) {
            return u.getId();
        }
        return -2;
    }

}
