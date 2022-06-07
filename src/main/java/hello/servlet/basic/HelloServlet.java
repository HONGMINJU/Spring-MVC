package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 2. /hello로 들어오면 해당 서블릿이 호출 됨
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // 1. 서블릿은 항상 HttpServlet을 상속받아야함

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3. 서블릿이 호출되면 service 메서드가 자동으로 호출됨

        // 4. req, resp 출력하기
        System.out.println("req = " + req); // 출력 : req = org.apache.catalina.connector.RequestFacade@2d9a07bd
        System.out.println("resp = " + resp); // 출력 : resp = org.apache.catalina.connector.ResponseFacade@68eddf0a

        // 5. Querystring으로 받은 값 출력하기 (localhost:8080/hell0?username=kim)
        System.out.println("req.getParameter(\"username\") = " + req.getParameter("username")); // 출력 : req.getParameter("username") = kim

        // 6. 반환값 설정하기
        resp.setContentType("text/plain"); // String 반환
        resp.setCharacterEncoding("utf-8");
        // response body에 값 입력
        resp.getWriter().write("Hello " + req.getParameter("username"));
    }
}
