package com.sample.finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {

  public static void main(String[] args) throws Exception {
    File csv = new File("DB_students.csv"); // CSV資料檔案
    BufferedReader reader = new BufferedReader(new FileReader(csv));// 要閱讀的最後一行
    Map<String, List<String>> map = new TreeMap<String, List<String>>();
    String line = reader.readLine();//read header
    while ((line = reader.readLine()) != null) {
      String key = line.split(",")[0];
      List<String> str = map.get(key);
      if (str == null) {
        str = new LinkedList<String>();
        map.put(key, str);
      }
      str.add(line);
    }

    FileWriter fw = new FileWriter("project.txt");
    //System.out.println("student_id,course_id\n");
    for (List<String> list : map.values()) {
      int length = 0;
      for (String val : list) {
        length = val.length();
        fw.write(val);
        fw.write("\n");
//        System.out.println(val);
//        System.out.println("\n");
      }
      for (int i = 0; i < 6; i++) {
        fw.write(".".repeat(length));
        fw.write("\n");
      }

    }
    reader.close();
    fw.close();
    Scanner scanner = new Scanner(System.in);
    System.out.println("1 is add\n2 is remove\n3 is search s_list\n4 is search c_member\n5 exit");
    int num = scanner.nextInt();
    switch (num) {
      case 1:
        System.out.print("Enter a s_id:");
        String s_id = scanner.next();
        System.out.print("Enter a c_id:");
        String c_id = scanner.next();
      case 2:
        System.out.print("Enter a s_id:");
        String s_id1 = scanner.next();
        System.out.print("Enter a c_id:");
        String c_id1 = scanner.next();
      case 3:
        System.out.print("Enter a s_id:");
        String s_id2 = scanner.next();
        search_S(s_id2, reader);
      case 4:
        System.out.print("Enter a c_id:");
        String c_id2 = scanner.next();
        search_C(c_id2, reader);
      case 5:
        break;
    }
  }
  
