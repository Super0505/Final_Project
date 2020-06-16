/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author super
 */
public class MainClass {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      File csv = new File("D:\\資料庫系統\\專題\\期末\\DB_students.csv"); // CSV資料檔案
      BufferedReader br = new BufferedReader(new FileReader(csv));// 要閱讀的最後一行
      while (br.ready()) {
        String line = br.readLine();// 資料元素分為一行
        StringTokenizer st = new StringTokenizer(line, ",");
        while (st.hasMoreTokens()) {// 每個元素都顯示在一個製表符分隔的線
          System.out.print(st.nextToken() + ",");
        }
        System.out.println();
      }
      br.close();
    } catch (FileNotFoundException e) {// File物件的建立過程中的異常捕獲
      e.printStackTrace();
    } catch (IOException e) {// BufferedReader在關閉物件捕捉異常
      e.printStackTrace();
    }
  }
}
