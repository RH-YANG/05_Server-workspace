<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>* JSP(Java Server Page)</h2>
	<p>
	JSP란, HTML내에서 자바코드를 쓸 수 있는 "자바언어"로
	Servlet(자바코드내)에서 응답화면(HTML)을 구현했던 복잡함을 보다 간단하게 해결 가능
	Servlet에서는 요청처리(비즈니스로직, Controller역할)에만 집중하고
	응답화면(프레젠테이션 로직, View역할)을 만들어내는 건 JSP에서 집중하게끔 분리 할 수 있음.
	
	스크립틀릿 : 	  
	- JSP에서 자바코드를 기술하기 위한 제일 기본적인 표현법
	표현식(출력식) : 
	- 자바에서의 값(변수 또는 메소드 호출)을 화면상에 출력하기 위해 사용
	선언문 : 
	- 멤버변수 또는 메소드 선언하기 위해 사용
	</p>
	
	<hr>
	
	<h2>JSP Element 표현법 - JSP 스크립팅 원소 Scripting Element</h2>
	<a href="views/01_scriptingElement.jsp">View detail</a>

	
	<br>
	<a href="views/02_pageDirective.jsp">page 지시어</a>
	
	<br>
	<a href="views/03_includeDirective.jsp">include 지시어</a>
	
	<br>
	taglib 지시어
	
	<hr>
	<h2>피자주문페이지(jsp) 
	--주문요청--> 주문요청을 받아서 처리해주는 Servlet 
	--> 피자결제페이지(응답jsp)</h2>
	
	<a href="views/pizzaOrderForm.jsp">피자 주문 페이지</a>
	

</body>
</html>