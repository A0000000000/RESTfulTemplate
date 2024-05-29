package cn.maoyanluo.resttemplate.controller;


import cn.maoyanluo.resttemplate.bean.Response;
import cn.maoyanluo.resttemplate.bean.User;
import cn.maoyanluo.resttemplate.service.UserService;
import cn.maoyanluo.resttemplate.tools.JWTTools;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Response<Integer> register(@RequestBody User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null || "".equals(user.getUsername()) || "".equals(user.getPassword())) {
            return Response.failed("用户名或密码不能为空.");
        }
        int result = userService.register(user);
        if (result == -1) {
            return Response.failed("用户名已存在.");
        }
        return Response.success(result);
    }


    @PostMapping("/login")
    public Response<String> login(@RequestBody User user) {
        int result = userService.login(user);
        if (result < 0) {
            return Response.failed("用户名或密码错误.");
        }
        return Response.success(JWTTools.genJWT(result, user));
    }

}
