package hello.servlet.web.servletMVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // getRequestDispatcher : controller에서 view로 넘어갈 때 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 다른 서블릿이나 JSP로 이동할 수 있게 하는 기능
        dispatcher.forward(request, response);

    }
}
