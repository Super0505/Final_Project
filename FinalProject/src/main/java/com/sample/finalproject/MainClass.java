package com.sample.finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader("DB_students.csv"));// 要閱讀的最後一行
    Map<String, List<String>> map = new TreeMap<String, List<String>>();
    String line = reader.readLine();// read header
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
    // System.out.println("student_id,course_id\n");
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

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("1. Add\n2. Remove\n3. Search Couerses by S_ID\n4 Search Students by C_ID\n5 Exit");
      int num = scanner.nextInt();
      switch (num) {
        case 1:
          System.out.print("Enter a s_id:");
          String s_id = scanner.next();
          System.out.print("Enter a c_id:");
          String c_id = scanner.next();
          addCourse(s_id, c_id, reader);
          continue;
        case 2:
          System.out.print("Enter a s_id:");
          String s_id1 = scanner.next();
          System.out.print("Enter a c_id:");
          String c_id1 = scanner.next();
          deleteCourse(s_id1, c_id1, reader);
          continue;
        case 3:
          System.out.print("Enter a s_id:");
          String s_id2 = scanner.next();
          Search_S ss = new Search_S(s_id2, reader);
          continue;
        case 4:
          System.out.print("Enter a c_id:");
          String c_id2 = scanner.next();
          search_C(c_id2, reader);
          continue;
        case 5:
          break;
      }
    }
//    reader.close();
//    fw.close();
  }

  private static void addCourse(String s_id, String c_id, BufferedReader reader) {
  }

  private static void deleteCourse(String s_id, String c_id, BufferedReader reader) {

  }

//  private  void search_S(String s_id, BufferedReader reader) throws IOException {
//    ArrayList<String> data = new ArrayList<String>();
//    String line;
//    while ((line = reader.readLine()) != null) {
//      String key = line.split(",")[0];
//      if (key.equals(s_id)) {
//        data.add(line);
//      }
//    }
//    for (String ll : data) {
//      System.out.println(ll);
//    }
//
//  }

  public void search_C(String c_id, BufferedReader reader) throws IOException {
    ArrayList<String> data = new ArrayList<String>();
    String line;
    while ((line = reader.readLine()) != null) {
      String key = line.split(",")[1];
      if (key.equals(c_id)) {
        data.add(line);
      }
    }
    for (String ll : data) {
      System.out.println(ll);
    }
    System.out.println("人數: " + data.size());

  }

}
