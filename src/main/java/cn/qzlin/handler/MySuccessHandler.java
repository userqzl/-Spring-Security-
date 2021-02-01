package cn.qzlin.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
public class MySuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Content-Type","application/json;charset=utf-8");
        Map<String,String> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","登录成功");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(JSONObject.toJSONBytes(map));
        outputStream.flush();
        outputStream.close();
    }
}
