package controller;

import model.Person;
import view.function.child.AlterPer;
import view.function.child.DialNumber;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PerControl {

    static Person head = null;//第一个结点
    static Person temp = null;//当前结点

    public static String writedata(){
        Person per = head;
        String info = "";
        while(per != null){
            info += per.getId() + "&" + per.getName() + "&" + per.getNumber()
                    + "&" + per.getSort() + "&" + per.getEmail() + "\n";
            per = per.next;
        }
        return info;
    }

    public static ArrayList<String> check(String sort){
        Person per = head;//用来遍历整个链表
        ArrayList<String> arr = new ArrayList<>();//返回的结果
        String info = "";//返回的信息
        if(sort.equals("办公类")){
            while(per != null){
                if(per.getSort().equals("办公类")){
                    info = per.getName() + "    " + per.getNumber();
                    arr.add(info);
                }
                per = per.next;
            }
        }
        if(sort.equals("个人类")){
            while(per != null){
                if(per.getSort().equals("个人类")){
                    info = per.getName() + "    " + per.getNumber();
                    arr.add(info);
                }
                per = per.next;
            }
        }
        if(sort.equals("商务类")){
            while(per != null){
                if(per.getSort().equals("商务类")){
                    info = per.getName() + "    " + per.getNumber();
                    arr.add(info);
                }
                per = per.next;
            }
        }
        return arr;
    }

    public static int add(String name, String number, String sort, String email){
        Person per = head;//判断是否重复
        while(per != null){
            if(per.getName().equals(name) && per.getNumber().equals(number)){
                return 3;
            }
            per = per.next;
        }
        if(Person.index == 0){
            temp = new Person(Person.index+1, name, number, sort, email);
            head = temp;
            temp.next = null;
        }else{
            temp.next = new Person(Person.index+1, name, number, sort, email);
            temp = temp.next;
            temp.next = null;
        }
        if(Person.index <= 15){
            Person.index++;//索引加1
            return 1;//添加成功
        }else{//此时index为16
            return 2;//添加失败，原因为存储空间不足
        }
    }

    public static ArrayList<String> dial(){//兼顾拨号，修改，删除功能的遍历查询
        Person per = head;//用来遍历整个链表
        ArrayList<String> arr = new ArrayList<>();//返回的结果
        String info = "";//返回的信息
        while(per != null){
            info = per.getName();
            arr.add(info);
            per = per.next;
        }
        return arr;
    }
    public static void childDial(ActionEvent e){
        Person per = head;//用来遍历整个链表
        while(per != null){
            if(per.getName().equals(e.getActionCommand())){
                new DialNumber(per.getName() + "#" + per.getNumber());
            }
            per = per.next;
        }
    }

    public static void alter(Person per, String name, String number, String sort, String email){
        per.setName(name);
        per.setNumber(number);
        per.setSort(sort);
        per.setEmail(email);
    }
    public static void childAlter(ActionEvent e){//接收由Alter传来的数据，传递给AlterPer
        Person per = head;//用来遍历整个链表
        while(per != null){
            if(per.getName().equals(e.getActionCommand())){
                new AlterPer(per);
            }
            per = per.next;
        }
    }

    public static void delete(ActionEvent e){
        Person per = head;
        Person pre = null;
        if(per.getName().equals(e.getActionCommand())){
            head = per.next;
        }else{
            while(per.next != null){
                pre = per;
                per = per.next;
                if(per.getName().equals(e.getActionCommand())){
                    pre.next = per.next;
                    while(per.next != null){//依次更新编号
                        per.next.setId(per.next.getId()-1);
                        per.next = per.next.next;
                    }
                }
            }
        }
    }
}
