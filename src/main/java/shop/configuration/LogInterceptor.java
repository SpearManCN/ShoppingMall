package shop.configuration;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse
            response, Object handler)throws Exception{
        // 사용자 정보가 없으면 /home으로 리다이렉트
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/home");
            return false; // 요청을 중단
        }
        // 사용자 정보가 있으면 계속 진행
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 컨트롤러 메서드가 실행된 후에 수행되는 로직
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 뷰 렌더링까지 완료된 후에 수행되는 로직
    }
}
