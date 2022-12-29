package com.br.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get방식으로 요청시 해당 doGet메소드가 자동으로 호출됨.
		//System.out.println("실행?");
		/*
		 * 첫번째 매개변수 request에는 요청과 관련된 내용들 담겨있음
		 * (요청전송방식, 요청자의 ip주소, 요청시 전달된 값 등등)
		 * 두번째 매개변수 response는 요청처리 후 응답할 때 사용되는 객체
		 * 요청처리를 위해서 전달된 값 뽑기
		 * >> request의 parameter영역 안에 존재(키=밸류 세트로 담겨있음)
		 * request의 parameter 영역으로 전달된 데이터 뽑는 메소드 
		 * >>request.getParameter("키") : String타입으로 반환
		 * >>request.getParameterValues("키")  :  String[ ] 로 반환 (배열)
		 */
		
		String name = request.getParameter("name"); // "홍길동" | ""
		String gender = request.getParameter("gender"); // "M" | "F" | null
		int age = Integer.parseInt(request.getParameter("age")); // "20" => 20 | "" => 
		String city = request.getParameter("city"); // 옵션값들 뽑힘
		double height = Double.parseDouble(request.getParameter("height"));
		
		//체크박스와 같은 복수개의 밸류값들을 뽑고자 할때
		String[] foods = request.getParameterValues("food"); // null 넘어올수 있다.
		
		System.out.println("name : "+name);
		System.out.println("gender : "+gender);
		System.out.println("age : "+age);
		System.out.println("city: "+city);
		System.out.println("height : "+height);
		
		if(foods==null) {
			System.out.println("foods : 없음");
		}else {
			System.out.println("foods : "+String.join("/", foods));
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
