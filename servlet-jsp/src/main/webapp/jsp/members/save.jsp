<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
  // request, response는 자동으로 사용가능
  // jsp도 servlet으로 변환되기 떄문에 가능
  MemberRepository memberRepository = MemberRepository.getInstance();
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  Member savedMember = memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=<%=savedMember.getId()%></li>
  <li>username=<%=savedMember.getUsername()%></li>
  <li>age=<%=savedMember.getAge()%></li>
</ul>
<a href = "/index.html">메인</a>
</body>
</html>
