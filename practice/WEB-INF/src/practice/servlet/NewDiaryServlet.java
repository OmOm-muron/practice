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
import practice.io.SequenceFileAccess;
import practice.util.DiaryUtil;

public class NewDiaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("pageName", "新規");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/new-diary.jsp");
        rd.forward(req, rsp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        
        SequenceFileAccess sequenceFA = new SequenceFileAccess();
        
        // 一行日記の要素を取得
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Date date = new Date();
        
        if (title.isEmpty() || content.isEmpty()) {
            // 未入力の場合はエラーとする
            // 入力された情報を再度リクエストにバインド
            Diary diary = new Diary();
            diary.setTitle(title);
            diary.setContent(content);
            // リクエストにバインド
            req.setAttribute("diary", diary);
            req.setAttribute("pageName", "新規");
            req.setAttribute("errorMessage", "タイトルと内容は両方入力してください。");
            // 再度新規登録画面に戻る
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/new-diary.jsp");
            rd.forward(req, rsp);
            
            return;
        }
        
        try {
            // 次のIDを取得
            int id = sequenceFA.readSequence();
            id++;
            
            // 日付をStringに変換
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = dateFormat.format(date);
            
            // 一行日記インスタンスを生成
            Diary diary = new Diary();
            diary.setId(id);
            diary.setTitle(title);
            diary.setDate(dateStr);
            diary.setContent(content);
            
            // 一行日記を書き込み
            DiaryUtil.addDiary(diary);
            // シークエンスを更新
            sequenceFA.writeSequence(String.valueOf(id));
            
            // メッセージをリクエストにバインド
            req.setAttribute("message", "一行日記を1件登録しました。");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        
        req.setAttribute("pageName", "新規");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/complete.jsp");
        rd.forward(req, rsp);
    }
}
