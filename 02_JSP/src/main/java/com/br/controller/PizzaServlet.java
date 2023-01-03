package com.br.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청시 전달값 뽑기 및 데이터 가공처리(파싱 등) => 변수 및 객체에 기록
		//     만일 post방식요청일 경우 전달값 뽑기 전 인코딩처리
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		
		// 2) 요청처리(=> Service => Dao => sql문 실행)
		
		// 총결제금액 계산하기
		int price = 0; 
		
		switch(pizza) {
		case "콤비네이션피자" : price += 5000; break;
		case "치즈피자" : price += 6000; break;
		case "포테이토 피자" : 
		case "고구마피자" : price += 7000; break;
		case "불고기피자" : price += 8000; break;
		}
		
		if(toppings != null) {
			for(int i=0; i<toppings.length; i++) {
				switch(toppings[i]) {
				case "고구마무스" :
				case "콘크림무스" : price += 1500; break;
				case "파인애플 토핑" :
				case "치즈토핑" : price += 2000; break;
				case "치즈바이트" : 
				case "치즈크러스트" : price += 3000; break;
				}
			}
		}
		
		if(sides != null) {
			for(int i=0; i<sides.length; i++) {
				switch(sides[i]) {
				case "콜라" : case "사이다" : price += 2000; break;
				case "갈릭소스" : case "핫소스" :
				case "피클" : case "파마산치즈가루" : price += 500; break;
				}
			}
		}
		
		// 3) 반환받은 결과를 가지고 사용자가 보게 될 응답페이지 만들기 
		//    혹은 jsp로 위임
		//    응답데이터가 있을 경우 request의 attribute에 담아서 위임
		request.setAttribute("price", price);
		request.setAttribute("userName", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		request.setAttribute("payment", payment);
		
		RequestDispatcher view = request.getRequestDispatcher("views/pizzaPayment.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
