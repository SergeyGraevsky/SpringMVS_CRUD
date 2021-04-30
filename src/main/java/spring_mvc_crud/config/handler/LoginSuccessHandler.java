package spring_mvc_crud.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

//отвечает за определение места назначения, в которое направляется пользователь после выхода из системы.
// LoginSuccessHandler - хэндлер, содержащий в себе алгоритм действий при успешной аутентификации.
// Например, тут мы можем отправить пользователя с ролью админа на админку после логина,
// а с ролью юзер на главную страницу сайта и т.п.
// Spring Security использует объект Authentication, пользователя авторизованной сессии.


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> stringSetRoles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (stringSetRoles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
        } else if (stringSetRoles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/hello");
        } else {
            httpServletResponse.sendRedirect("/");
        }
    }
}
