package academic.main.config.interceptor;

import academic.main.common.RequestUserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        log.info("request : {}, response : {}, handler : {}", request, response, handler);

        RequestUserInfo requestUserInfo = RequestUserInfo.of(request.getHeader("name"));

        request.setAttribute("requestUser", requestUserInfo);

        // logging

        return true;
    }
}
