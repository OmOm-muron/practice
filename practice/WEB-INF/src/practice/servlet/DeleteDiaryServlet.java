package practice.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.diary.Diary;
import practice.util.DiaryUtil;

public class DeleteDiaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        
        // 削除対象のIDを取得
        String diaryid = req.getParameter("diaryid");
        int id = Integer.parseInt(diaryid);
        
        try {
            // 一行日記をリクエストにバインド
            Diary diary = DiaryUtil.getDiary(id);
            req.setAttribute("diary", diary);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        
        req.setAttribute("pageName", "削除");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/delete-diary.jsp");
        rd.forward(req, rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        
        // 一行日記のIDを取得
        String diaryid = req.getParameter("diaryid");
        
        try {
            int id = Integer.parseInt(diaryid);
            
            // 一行日記インスタンスを生成
            Diary diary = new Diary();
            diary.setId(id);
            
            // 一行日記を更新
            DiaryUtil.deleteDiary(diary);
            
            // メッセージをリクエストにバインド
            req.setAttribute("message", "一行日記を1件削除しました。");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        
        req.setAttribute("pageName", "削除");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/complete.jsp");
        rd.forward(req, rsp);
    }
}
