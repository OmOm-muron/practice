package practice.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.diary.Diary;
import practice.util.DiaryUtil;

public class UpdateDiaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        
        // 更新対象のIDを取得
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
        
        req.setAttribute("pageName", "更新");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/update-diary.jsp");
        rd.forward(req, rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        
        // 一行日記の要素を取得
        String diaryid = req.getParameter("diaryid");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        // String date = req.getParameter("date");
        Date date = new Date();
        
        try {
            int id = Integer.parseInt(diaryid);
            // 日付をStringに変換
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = dateFormat.format(date);
            
            // 一行日記インスタンスを生成
            Diary diary = new Diary();
            diary.setId(id);
            diary.setTitle(title);
            // diary.setDate(date);
            diary.setDate(dateStr);
            diary.setContent(content);
            
            // 一行日記を更新
            DiaryUtil.updateDiary(diary);
            
            // メッセージをリクエストにバインド
            req.setAttribute("message", "一行日記を1件更新しました。");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        
        req.setAttribute("pageName", "更新");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/complete.jsp");
        rd.forward(req, rsp);
    }
}
