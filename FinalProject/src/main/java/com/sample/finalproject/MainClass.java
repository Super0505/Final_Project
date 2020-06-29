package com.sample.finalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {

  public static void main(String[] args) throws Exception {
    int length = 0;
    BufferedReader reader = new BufferedReader(new FileReader("DB_students.csv"));
    Map<String, List<String>> map = new TreeMap<String, List<String>>();
    String line = reader.readLine();
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
      for (String val : list) {
        length = val.length();
        fw.write(val);
        fw.write("\n");
      }
      for (int i = 0; i < 6; i++) {
        fw.write(".".repeat(length - 5) + "," + ".".repeat(4));
        fw.write("\n");
      }
    }
    reader.close();
    fw.close();
    Changer cc = new Changer();
    Searcher ss = new Searcher();
    Scanner scanner = new Scanner(System.in);
    RandomAccessFile bf = new RandomAccessFile("project.txt", "rw");
    boolean boo = true;
    while (boo == true) {
      System.out.println("1. Add\n2. Remove\n3. Search Couerses by S_ID\n4. Search Students by C_ID\n5. Exit");
      int num = scanner.nextInt();
      switch (num) {
        case 1:
          System.out.print("Enter a s_id:");
          String s_id = scanner.next();
          System.out.print("Enter a c_id:");
          String c_id = scanner.next();
          System.out.println("Add...");
          cc.addCourse(s_id, c_id, bf);
          break;
        case 2:
          System.out.print("Enter a s_id:");
          String s_id1 = scanner.next();
          System.out.print("Enter a c_id:");
          String c_id1 = scanner.next();
          System.out.println("Delete...");
          cc.deleteCourse(s_id1, c_id1, bf);
          break;
        case 3:
          System.out.print("Enter a s_id:");
          String s_id2 = scanner.next();
          System.out.println("Search...");
          ss.search_S(s_id2, bf);
          break;
        case 4:
          System.out.print("Enter a c_id:");
          String c_id2 = scanner.next();
          System.out.println("Search...");
          ss.search_C(c_id2, bf);
          break;
        case 5:
          boo = false;
          break;
      }
    }
  }
}

class Changer {

  Changer() {

  }

  public Boolean addCourse(String s_id, String c_id, RandomAccessFile reader) throws IOException {
    String line;
    String match = s_id + "," + c_id;
    boolean find = false;
    reader.seek(0);
    long size = -1;
    while ((line = reader.readLine()) != null) {
      if (s_id.equalsIgnoreCase(line.split(",")[0])) {
        if (line.equalsIgnoreCase(match)) {
          System.out.println("你不會影分身，不能衝堂");
          return false;
        } else {
          find = true;
          size = reader.getFilePointer();
        }
      }
    }
    if (find) {
      reader.seek(size);
      reader.writeBytes(s_id + "," + c_id);
    }
    return true;
  }

  public void deleteCourse(String s_id, String c_id, RandomAccessFile reader) throws IOException {
    String line;
    reader.seek(0);
    while ((line = reader.readLine()) != null) {
      String key = line.split(",")[0];
      if (key.equalsIgnoreCase(s_id)) {
        String value = line.split(",")[1];
        if (value.equalsIgnoreCase(c_id)) {
          reader.seek(reader.getFilePointer() - line.length() - 1);
          reader.writeBytes(".".repeat(key.length()) + "," + ".".repeat(4));
        }
      }
    }
  }
}

class Searcher {

  Searcher() {

  }

  public void search_S(String s_id, RandomAccessFile reader) throws IOException {
    String line;
    reader.seek(0);
    while ((line = reader.readLine()) != null) {
      if (s_id.equalsIgnoreCase(line.split(",")[0])) {
        System.out.println(line);
      }
    }
  }

  public void search_C(String c_id, RandomAccessFile reader) throws IOException {
    String line;
    reader.seek(0);
    int total = 0;
    while ((line = reader.readLine()) != null) {
      if (c_id.equalsIgnoreCase(line.split(",")[1])) {
        System.out.println(line.split(",")[0]);
        total++;
      }
    }
    System.out.println("人數: " + total + "人");
  }
}
