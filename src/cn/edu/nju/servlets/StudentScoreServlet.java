package cn.edu.nju.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nju.service.StudentScoreService;
import cn.edu.nju.serviceImpl.StudentScoreServiceImpl;

/**
 * Servlet implementation class StudentScoreServlet
 */
@WebServlet("/StudentScoreServlet")
public class StudentScoreServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private StudentScoreService scoreService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreServlet() {
        super();
        scoreService = new StudentScoreServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		scoreService.getStudentScoreById(id, response.getOutputStream());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
