package cn.maoyanluo.resttemplate.intercept;

import cn.maoyanluo.resttemplate.bean.Response;
import cn.maoyanluo.resttemplate.bean.User;
import cn.maoyanluo.resttemplate.tools.JWTTools;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginStatusIntercept implements HandlerInterceptor {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            response.getOutputStream().println(mapper.writeValueAsString(Response.failed("token is null.")));
            response.getOutputStream().close();
            return false;
        }
        User user = JWTTools.parseJWT(token);
        if (user == null) {
            response.getOutputStream().println(mapper.writeValueAsString(Response.failed("login expire.")));
            response.getOutputStream().close();
            return false;
        }
        JWTTools.tl.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        JWTTools.tl.remove();
    }
}
