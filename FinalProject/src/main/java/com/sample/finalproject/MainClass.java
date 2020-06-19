package com.sample.finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

  public static void main(String[] args) throws Exception {
    File csv = new File("D:\\資料庫系統\\專題\\期末\\DB_students.csv"); // CSV資料檔案
    BufferedReader reader = new BufferedReader(new FileReader(csv));// 要閱讀的最後一行
    Map<String, List<String>> map = new TreeMap<String, List<String>>();
    String line = reader.readLine();//read header
    while ((line = reader.readLine()) != null) {
      String key = line.split(",")[0];
      List<String> l = map.get(key);
      if (l == null) {
        l = new LinkedList<String>();
        map.put(key, l);
      }
      l.add(line);
    }

    System.out.println("student_id,course_id\n");
    for (List<String> list : map.values()) {
      for (String val : list) {
        System.out.println(val);
        System.out.println("\n");
      }
    }
    reader.close();
  }

//  private static String getField(String line) {
//    return line.split(",")[0];// extract value you want to sort on
//  }
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sample.finalproject;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
///**
// *
// * @author super
// */
//public class MainClass {
//
//  /**
//   * @param args the command line arguments
//   */
//  public static void main(String[] args) {
//    try {
//      File csv = new File("D:\\資料庫系統\\專題\\期末\\DB_students.csv"); // CSV資料檔案
//      BufferedReader br = new BufferedReader(new FileReader(csv));// 要閱讀的最後一行
//      while (br.ready()) {
//        String line = br.readLine();// 資料元素分為一行
//        StringTokenizer st = new StringTokenizer(line, ",");
//        String stnt = st.nextToken();//找學號
//        String stdid = stnt.substring(1);
//        int std = Integer.parseInt(stdid);//學號數字部分轉int
//        while (st.hasMoreTokens()) {// 每個元素都顯示在一個製表符分隔的線
//          System.out.print(st.nextToken() + ",");
//        }
//        System.out.println();
//      }
//      br.close();
//    } catch (FileNotFoundException e) {// File物件的建立過程中的異常捕獲
//      e.printStackTrace();
//    } catch (IOException e) {// BufferedReader在關閉物件捕捉異常
//      e.printStackTrace();
//    }
//  }
//}
