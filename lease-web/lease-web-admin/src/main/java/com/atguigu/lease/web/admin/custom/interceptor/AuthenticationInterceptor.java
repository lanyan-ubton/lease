package com.atguigu.lease.web.admin.custom.interceptor;
import com.atguigu.lease.context.LoginUserContext;

import com.atguigu.lease.common.exception.LeaseException;
import com.atguigu.lease.common.result.ResultCodeEnum;
import com.atguigu.lease.common.utils.JwtUtil;
import com.atguigu.lease.common.utils.ThreadLocalUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import java.util.Map;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: smionf
 * @Date: 2024/01/25/11:31
 * @Description:
 */
@Component
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader("access_token");
            log.info("验证token: {}", token);

            if (StringUtils.isBlank(token)){
                log.warn("请求头缺少access_token");
                throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
            }

            String realToken = token.substring(7);
            Map<String, Object> claims = JwtUtil.parseToken(realToken);


            String username = (String) claims.get("username");
            ThreadLocalUtils.put(username);
            log.info("用户{}认证通过", username);

            return true;
        } catch (Exception e) {
            log.error("认证拦截器异常: ", e);
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserContext.clear();
    }
}