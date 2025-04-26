package com.atguigu.lease.common.utils;

import com.atguigu.lease.common.exception.LeaseException;
import com.atguigu.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: smionf
 * @Date: 2024/01/25/11:17
 * @Description:
 */
public class JwtUtil {

    private static long tokenExpiration = 60 * 60 * 1000L;
    private static SecretKey tokenSignKey = Keys.hmacShaKeyFor("M0PKKI6pYGVWWfDZw90a0lTpGYX1d4AQ".getBytes());

    public static String createToken(Long userId, String username) {
        String token = Jwts.builder().
                setSubject("USER_INFO").
                setExpiration(new Date(System.currentTimeMillis() + tokenExpiration)).
                claim("userId", userId).
                claim("username", username).
                signWith(tokenSignKey).
                compressWith(CompressionCodecs.GZIP).
                compact();
        return token;
    }

    /**
     * 解析JWT令牌，并返回Claims对象
     *
     * @param token JWT令牌字符串
     * @return 解析后的Claims对象
     * @throws LeaseException 如果令牌过期或无效，则抛出LeaseException异常
     */
    public static Claims parseToken(String token) {
        try {
            // 解析JWT令牌
            Jws<Claims> claimsJws = Jwts.parserBuilder().
                    setSigningKey(tokenSignKey).  // 设置签名密钥
                    build().parseClaimsJws(token); // 构建解析器并解析JWT令牌
            return claimsJws.getBody();  // 返回解析后的Claims对象

        } catch (ExpiredJwtException e) {
            // 捕获令牌过期异常
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);  // 抛出LeaseException异常，表示令牌过期
        } catch (JwtException e) {
            // 捕获JWT异常
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);  // 抛出LeaseException异常，表示令牌无效
        }
    }

}
