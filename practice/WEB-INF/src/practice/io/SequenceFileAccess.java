package practice.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequenceFileAccess {
    private final String SEQUENCE_PATH = "D:\\eclipse\\git\\practice\\practice\\data\\sequence.txt";
    
    /**
     * シークエンスファイルの内容(シークエンス番号)を取得
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    public int readSequence() throws IOException, NumberFormatException {
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        
        try {
            fi = new FileInputStream(SEQUENCE_PATH);
            is = new InputStreamReader(fi);
            br = new BufferedReader(is);
            
            String sequenceStr = br.readLine();
            int sequence = Integer.parseInt(sequenceStr);
            return sequence;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            br.close();
        }
    }
    
    /**
     * シークエンスファイルに書き込み
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    public void writeSequence(String wirteStr) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(SEQUENCE_PATH);
            fw.write(wirteStr);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            fw.close();
        }
    }
}
