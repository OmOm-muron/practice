package practice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.diary.Diary;
import practice.util.DiaryUtil;

public class ListDiaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        
        try {
            // 一行日記を全て取得してリクエストにバインド
            List<Diary> listDiary = DiaryUtil.getDiaryList();
            req.setAttribute("diaryList", listDiary);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/list-diary.jsp");
        rd.forward(req, rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        doGet(req, rsp);
    }
}
