package practice.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DB代わりに使うCSVへのアクセスを行う
 */

public class CSVFileAccess {
    private final String CSV_PATH = "C:\\Users\\banba\\git\\practice\\practice\\data\\diary.csv";
    
    /**
     * CSVファイルの行数を取得<br>
     * @return 行数(1～)
     * @throws IOException
     */
    public int getLineCount() throws IOException {
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        
        try {
            fi = new FileInputStream(CSV_PATH);
            is = new InputStreamReader(fi);
            br = new BufferedReader(is);
            
            int lineCount = 0;
            
            while (br.readLine() != null) {
                // CSVの1行を読み込む
                
                // 読み込んだ行のカウントをインクリメント
                lineCount++;
            }
            
            return lineCount;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            br.close();
        }
    }
    
    /**
     * CSVから指定したN番目の文字列を取得
     * @param targetLine
     * @return
     * @throws IOException
     */
    public String readLine(int targetLine) throws IOException {
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        
        try {
            fi = new FileInputStream(CSV_PATH);
            is = new InputStreamReader(fi);
            br = new BufferedReader(is);
            
            int lineCount = 0;
            String line;
            
            while ((line = br.readLine()) != null) {
                // CSVの1行を読み込む
                
                // 読み込んだ行のカウントをインクリメント
                lineCount++;
                
                if (lineCount == targetLine) {
                    // 指定された行番号であれば返す
                    return line;
                }
            }
            
            // 指定行のデータを取得できなければ空文字を返す
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            br.close();
        }
    }
    
    /**
     * CSVに行を追加
     * @param addStr
     * @throws IOException
     */
    public void addLine(String addStr) throws IOException {
        FileWriter fw = null;
        try {
            // 追記モード
            fw = new FileWriter(CSV_PATH, true);
            fw.write(addStr);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            fw.close();
        }
    }
    
    public void editLine(int targetLine, String afterStr) throws IOException {
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        FileWriter fw = null;
        StringBuffer sb = new StringBuffer();
        
        try {
            fi = new FileInputStream(CSV_PATH);
            is = new InputStreamReader(fi);
            br = new BufferedReader(is);
            
            int lineCount = 0;
            String line;
            
            while ((line = br.readLine()) != null) {
                // CSVの1行を読み込む
                // 読み込んだ行のカウントをインクリメント
                lineCount++;
                
                if (lineCount == targetLine) {
                    // 指定された行番号であれば内容を書き換える
                    sb.append(afterStr + "\n");
                    continue;
                }
                // StringBufferに追加
                sb.append(line + "\n");
            }
            br.close();
            
            // 対象行を除去した文字列を書き込み
            fw = new FileWriter(CSV_PATH);
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            br.close();
            fw.close();
        }
    }
}
