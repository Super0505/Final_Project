package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import com.sample.finalproject.MainClass;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class finder {

  public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("lll");
            
    Finder a = new Finder();
    
  }
}
public class list_C {
    public void print() {
      Scanner scanner = new Scanner(System.in);
      finder fin = new finder();
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
          fin.search_S(s_id2);
        case 4:
          System.out.print("Enter a c_id:");
          String c_id2 = scanner.next();
          fin.search_C(c_id2);
        case 5:
          break;
      }
    }
  }

  public class Finder {
    
    Finder() throws FileNotFoundException {
      File csv = new File("project.txt");
      this.reader = new RandomAccessFile(csv,"rw");
      this.data = new ArrayList<String>();
      this.seek_data = new ArrayList<Long>();
    }

    Finder(RandomAccessFile reader) {
      this.reader = reader;
      this.data = new ArrayList<String>();
      this.seek_data = new ArrayList<Long>();
    }

    public boolean search_S(String std) throws IOException {
      this.data.clear();
      String line;
      while ((line = this.reader.readLine()) != null) {
        String key = line.split(",")[0];
        if (key == std) {
          this.data.add(line);
          this.seek_data.add(this.reader.getFilePointer());
        }
      }
      if (this.data.size() == 0) {
        return false;
      } else {
        return true;
      }
    }

    public boolean search_C(String code) throws IOException {
      this.data.clear();
      String line;
      while ((line = reader.readLine()) != null) {
        String key = line.split(",")[1];
        if (key == code) {
          this.data.add(line);
          this.seek_data.add(this.reader.getFilePointer());
        }
      }
      if (this.data.size() == 0) {
        return false;
      } else {
        return true;
      }
    }

    public void show() {
      if (this.data.size() == 0) {
        System.out.println("0");
      } else {
        for (String ll : data) {
          System.out.println(ll);
        }
      }
    }
    
    public void show_Pointer() {
      if (this.seek_data.size() == 0) {
        System.out.println("0");
      } else {
        for (Long ll : this.seek_data) {
          System.out.println(ll);
        }
      }
    }
    public ArrayList<String> getter() {
      return this.data;
    }

    public boolean Is_empty() {
      return data.size() == 0;
    }
    public RandomAccessFile reader;
    private ArrayList<String> data;
    private ArrayList<Long> seek_data;
  }
