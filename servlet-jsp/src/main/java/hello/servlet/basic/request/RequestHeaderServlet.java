package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
    }

    // 1. start line 정보 출력
    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        // /request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();

        /**
         *        <출력 결과>
         * --- REQUEST-LINE - start ---
         * request.getMethod() = GET
         * request.getProtocol() = HTTP/1.1
         * request.getScheme() = http
         * request.getRequestURL() = http://localhost:8080/request-header
         * request.getRequestURI() = /request-header
         * request.getQueryString() = username=minju
         * request.isSecure() = false
         * --- REQUEST-LINE - end ---
         */
    }

    // 2. Header 모든 정보 출력
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");
    /*
      // 옛날 방식으로 헤더 정보 조회
      Enumeration<String> headerNames = request.getHeaderNames();
      while (headerNames.hasMoreElements()) {
          String headerName = headerNames.nextElement();
          System.out.println(headerName + ": " + request.getHeader(headerName));
      }
    */
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
        System.out.println();

        /**
         *        <출력 결과>
         * --- Headers - start ---
         * host : localhost:8080
         * connection : keep-alive
         * cache-control : max-age=0
         * sec-ch-ua : " Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102"
         * sec-ch-ua-mobile : ?0
         * sec-ch-ua-platform : "macOS"
         * upgrade-insecure-requests : 1
         * user-agent : Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36
         * accept : text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng;q = 0.8, application / signed - exchange;v = b3;q = 0.9
         * sec - fetch - site :none
         * sec - fetch - mode :navigate
         * sec - fetch - user : ?1
         * sec - fetch - dest :document
         * accept - encoding :gzip, deflate, br
         * accept - language :ko - KR, ko;q = 0.9, en - US;q = 0.8, en;q = 0.7
         * ---Headers - end-- -
         */
    }

    // 3. Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }
}
