package com.example.microservice.infra.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.microservice.infra.config.JwtConfig;
import com.example.microservice.infra.constant.JwtVerifyEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author 钟玖林
 * @Date 2020/12/9 21:34
 * @Version 1.0
 */
@Slf4j
public class JwtUtil {
    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token, JwtConfig jwtConfig) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            log.info("jwt验证通过");
            return true;
        } catch (TokenExpiredException tokenExpiredException) {
            throw new Exception(JwtVerifyEnum.EXPIRED.getMessage());
        } catch (SignatureVerificationException signatureVerificationException) {
            log.info("token验证失败");
            throw new Exception(JwtVerifyEnum.SIGNATURE_VERIFICATION.getMessage());
        } catch (JWTDecodeException jwtDecodeException) {
            log.info("token解析失败");
            throw new Exception(JwtVerifyEnum.DECODE_ERROR.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception(JwtVerifyEnum.NOT_LOGIN.getMessage());
        }
    }

    /**
     * 生成签名,N-min后过期
     *
     * @param username 用户名
     * @return 加密的token
     */
    public static String sign(String username, JwtConfig jwtConfig) {
        Date date = new Date(System.currentTimeMillis() + jwtConfig.getExpire());
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());
        // 附带username信息
        return JWT.create().withClaim("username", username)
                .withExpiresAt(date).sign(algorithm);
    }
}



