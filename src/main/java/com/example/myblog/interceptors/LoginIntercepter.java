package com.example.myblog.interceptors;

import com.example.myblog.utils.JwtUtil;
import com.example.myblog.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            // 允许 OPTIONS 请求通过
            return true;
        }
        String token = request.getHeader("Authorization");

        // 检查是否为空或者格式不正确
        if (token == null || !token.startsWith("Bearer ")) {
            response.setStatus(401);  // 如果没有 Token 或者格式错误，返回 401
            return false;
        }

        try {
            String jwtToken = token.substring(7); // 获取 Bearer 后的 Token
            Map<String, Object> claims = JwtUtil.parseToken(jwtToken);  // 解析 Token
            // 把业务数据存到 ThreadLocal 中
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);  // Token 解析失败，返回 401
            return false;
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清除数据
        ThreadLocalUtil.remove();
    }
}
