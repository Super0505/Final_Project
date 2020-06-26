/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.finalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class Search_S {

  String s_id;
  BufferedReader reader;
  private ArrayList<String> data = new ArrayList<String>();
  private String line;

  public Search_S(String s_id, BufferedReader reader) {
    this.s_id = s_id;
    this.reader = reader;
  }
  while ((line = reader.readLine()) != null) {
     String key = line.split(",")[0];
    if (key.equals(s_id)) {
      data.add(line);
    }
  }
  for (String ll : data

  
    ) {
      System.out.println(ll);
  }

}
