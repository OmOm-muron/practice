package practice.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import practice.diary.Diary;
import practice.io.CSVFileAccess;

public class DiaryUtil {
    static private final int INDEX_ID = 0;
    static private final int INDEX_TITLE = 1;
    static private final int INDEX_DATE = 2;
    static private final int INDEX_CONTENT = 3;
    
    /**
     * 一行日記を全て取得
     * @return
     * @throws IOException
     * @throws NumberFormatException
     * @throws ParseException
     */
    public static List<Diary> getDiaryList() throws IOException, NumberFormatException {
        List<Diary> listDiary = new ArrayList<Diary>();
        CSVFileAccess csvFA = new CSVFileAccess();
        
        try {
            // CSVファイルの全行を読み込む
            int lineCount = csvFA.getLineCount();
            for(int i = 1; i <= lineCount; i++) {
                // 1行のデータをカンマ区切りで配列化
                String lineStr = csvFA.readLine(i);
                if (lineStr.isEmpty()) {
                    continue;
                }
                String[] diaryElements = lineStr.split(",");
                
                // 一行日記の要素を取り出し
                int id = Integer.parseInt(diaryElements[INDEX_ID]);
                String title = diaryElements[INDEX_TITLE];
                String date = diaryElements[INDEX_DATE];
                String content = diaryElements[INDEX_CONTENT];
                
                // Diaryインスタンスを作成
                Diary diary = new Diary();
                diary.setId(id);
                diary.setTitle(title);
                diary.setDate(date);
                diary.setContent(content);
                
                // Listに追加
                listDiary.add(diary);
            }
            return listDiary;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * 一行日記を1件取得
     * @param targetLine idと同義
     * @return
     * @throws IOException
     * @throws NumberFormatException
     * @throws ParseException
     */
    public static Diary getDiary(int targetLine) throws IOException, NumberFormatException {
        CSVFileAccess csvFA = new CSVFileAccess();
        
        try {
            // 1行のデータをカンマ区切りで配列化
            String lineStr = csvFA.readLine(targetLine);
            String[] diaryElements = lineStr.split(",");
            
            // 一行日記の要素を取り出し
            int id = Integer.parseInt(diaryElements[INDEX_ID]);
            String title = diaryElements[INDEX_TITLE];
            String date = diaryElements[INDEX_DATE];
            String content = diaryElements[INDEX_CONTENT];
            
            // Diaryインスタンスを作成
            Diary diary = new Diary();
            diary.setId(id);
            diary.setTitle(title);
            diary.setDate(date);
            diary.setContent(content);
            
            return diary;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * 一行日記を書き込み
     * @param diary
     * @throws IOException
     */
    public static void addDiary(Diary diary) throws IOException {
        CSVFileAccess csvFA = new CSVFileAccess();
        
        // 一行日記の要素を取り出し
        int diaryid = diary.getId();
        String title = diary.getTitle();
        String date = diary.getDate();
        String content = diary.getContent();
        
        // IDをStringに変換
        String id = String.valueOf(diaryid);
        
        // CSVに書き込む文字列
        String addStr = id + "," + title + "," + date + "," + content + "\n";
        
        try {
            csvFA.addLine(addStr);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * 一行日記を更新
     * @param diary
     * @throws IOException
     */
    public static void updateDiary(Diary diary) throws IOException {
        CSVFileAccess csvFA = new CSVFileAccess();
        
        // 一行日記の要素を取り出し
        int diaryid = diary.getId();
        String title = diary.getTitle();
        String date = diary.getDate();
        String content = diary.getContent();
        
        // IDをStringに変換
        String id = String.valueOf(diaryid);
        
        // 更新後の文字列
        String afterStr = id + "," + title + "," + date + "," + content;
        
        try {
            csvFA.editLine(diaryid, afterStr);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * 一行日記を削除
     * @param diary
     * @throws IOException
     */
    public static void deleteDiary(Diary diary) throws IOException {
        CSVFileAccess csvFA = new CSVFileAccess();
        
        // 一行日記のIDを取り出し
        int diaryid = diary.getId();
        
        // IDをStringに変換
        String id = String.valueOf(diaryid);
        
        // 削除後の文字列
        String afterStr = id + "," + " " + "," + " " + "," + " ";
        
        try {
            csvFA.editLine(diaryid, afterStr);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
