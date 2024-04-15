package com.study.boardserver.aop;

import com.study.boardserver.util.SessionUtil;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
@Log4j2
public class LoginCheckAspect {
    @Around("@annotation(com.study.boardserver.aop.LoginCheck) && @ annotation(loginCheck)")
    public Object adminLoginCheck(ProceedingJoinPoint proceedingJoinPoint, LoginCheck loginCheck) throws Throwable {
        HttpSession session = (HttpSession) ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        String id = null;
        int idIndex = 0;

        String userType = loginCheck.type().toString();
        switch (userType) {
            case "ADMIN": {
                id = SessionUtil.getLoginAdminId((HttpSession) session);
                break;
            }

            case "USER": {
                id = SessionUtil.getLoginMemberId((HttpSession) session);
                break;
            }
        }
        if (id == null) {
            log.error(proceedingJoinPoint.toString() + "accountName" + id);

            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "로그인한 ID값을 확인해주세요 ."){};
        }

        // 실제 컨트롤러 단에 넘어가는 것
        Object[] modifiedArgs = proceedingJoinPoint.getArgs();

        if (proceedingJoinPoint != null) {
            modifiedArgs[idIndex] = id;
        }

        return proceedingJoinPoint.proceed(modifiedArgs);


    }
}
