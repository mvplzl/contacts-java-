package dao;

import controller.PerControl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by lzl on 15-6-4.
 */
public class ReadData {
    public ReadData(){
        try{
            File f = new File("src/contacts.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String info = br.readLine();
                String id = info.split("&")[0];
                String name = info.split("&")[1];
                String number = info.split("&")[2];
                String sort = info.split("&")[3];
                String email = info.split("&")[4];
                PerControl.add(name, number, sort, email);
            }
        }catch (Exception e){
            System.out.println("读取文件异常");
        }
    }
}
