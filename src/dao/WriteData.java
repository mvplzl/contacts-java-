package dao;

import controller.PerControl;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by lzl on 15-6-4.
 */
public class WriteData {
    public WriteData(){
        try{
            File f = new File("src/contacts.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            String info = PerControl.writedata();
            pw.print(info);
            pw.close();
        }catch (Exception e){
            System.out.print("写入文件异常");
        }
    }
}
