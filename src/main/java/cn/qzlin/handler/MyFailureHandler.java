package cn.qzlin.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: qzl
 * @created: 2021/02/01 11:12
 */
@Component
public class MyFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("Content-Type","application/json;charset=utf-8");
        Map<String,String> res = new HashMap<>();
        res.put("code","401");
        if (e instanceof UsernameNotFoundException){
            res.put("msg","用户不存在！");
        }else if(e instanceof BadCredentialsException){
            res.put("msg","用户名或密码错误，登录失败");
        }else{
            res.put("msg","登录失败");
        }
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(JSONObject.toJSONBytes(res));
        outputStream.flush();
        outputStream.close();
    }
}
