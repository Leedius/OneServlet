

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// * : 에스테리스크 -> 전체(all)
//.do로 끝나는 요청 다 받겠다.
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//매개변수 요청, 응답
		doProcess(request, response);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		doProcess(request, response);
		
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//어떤 페이지에서 요청이 왓는지 확인
		String requestURI = request.getRequestURI();
		//requestURI = /OneServlet/firstToSecond.do (페이지 이동1을 클릭했을때)
		
		String contextPath = request.getContextPath();
		//contextPath = /OneServlet (페이지 이동1을 클릭했을때)
		
		String command = requestURI.substring(contextPath.length());
		//command = /firstToSecond.do (첫번째 페이지를 클릭했을때)
		
		
		//응답 페이지
		String page = "";
		
		
		//first.jsp에서 들어 왔을 때
		if(command.equals("/firstToSecond.do")) {
			//if문 실행
			//second.jsp페이지 이동
			page = "second.jsp";
		}
		
		//second.jsp에서 들어 왔을 때
		if(command.equals("/secondToThird.do")) {
			//if문 실행
			//third.jsp로 페이지 이동
			page = "third.jsp";
		}
		
		//페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
	
	

}
