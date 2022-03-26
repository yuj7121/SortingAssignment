/* Names: Nicole Poroshenko, Andrew Jamieson, Yujin Bae
   Date: Due March 25 2022
   Teacher: Ms. Krasteva - ICS 4U0
   Program Description: This program is designed to complete assignment "Array/List Sort Evaluation". It takes a list of names and grades
                        from the file A7-1.txt and assign them to arrays. Then, the data is sorted into columns in alphabetical order of
                        student names. Next, the mark data of each student is sorted numerically from largest to smallest. All organized
                        data is not only outputted to a console, but also to a new file.
*/

// import all packages and file writers
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SortingStudents{
   private String[] studentName = new String[35]; // new String array of size 35 titled studentName to hold student names
   private int[] studentGrade = new int[35]; // new int array of size 35 titled studentGrade to hold student grades
   
   public SortingStudents(){ // constructor method: reads from files and assigns data to each array
      try { // create try block
         Scanner textFile = new Scanner(new File("A7-1.txt")); // create textFile scanner to read text file with all data
         for (int index = 0; index < 35; index++){ // run loop starting at index 0, ending index 35, and incrementing by 1 each time
            studentName[index] = textFile.nextLine(); // assign name data at index in loop to studentName at this index by reading the file
            studentGrade[index] = Integer.parseInt(textFile.nextLine()); // assign grade data at index in loop to studentGrade at this index by reading the file
         } 
         textFile.close(); // close the text file
      }
      catch (IOException e){ // catch any exceptions
         System.out.println("Error has occured. Please check the .txt file."); // print error message
      }
   } // end constructor
   
   public void alphaNameSort(){ // method used to sort and output names of students and their corresponding grades in alphabetical order (using insertion sort)
      for (int check = 1; check < studentName.length; check++){ // run loop with variable check starting at 1, going to length of array (35) and incrementing by 1 each time
         String compare1 = studentName[check]; // initialize String compare1 to name at index of check in studentName array
         int compare2 = studentGrade[check]; // initialize String compare2 to grade at index of check in studentGrade array
         int previousLine = check-1; // initialize integer previousLine as line before check
         
         while (previousLine >= 0 && compare1.compareTo(studentName[previousLine])<0){ // while in bounds and studentName at check index is alphabetically higher than studentName at earlier index...
            studentName[previousLine + 1] = studentName[previousLine]; // set studentName at line above previous line to studentName at the previous line
            studentGrade[previousLine + 1] = studentGrade[previousLine]; // set studentGrade at line above previous line to studentGrade at the previous line
            previousLine--; // decrement previousLine by 1
         }
         
         studentName[previousLine + 1] = compare1; // studentName at value above previous line is now compare1 value for future loop
         studentGrade[previousLine + 1] = compare2; // studentGrade at value above previous line is now compare2 value for future loop
      }
      
      System.out.println("\n- STUDENTS SORTED BY NAME IN ALPHABETICAL ORDER -"); // print title
      System.out.println("\nStudent Name     Student Grade (%)"); // print categories
      for (int i = 0; i < studentName.length; i++){ // run loop starting at index 0, ending index 35 (array length), and incrementing by 1 each time
         System.out.printf("%-14s", studentName[i]); // print student name at index
         System.out.printf("%-9s", "|"); // make column line seperator
         System.out.println(studentGrade[i]); // print student grade at index
      }
   } // end method
   
   public void namesSortedToFile(){ // method used to output sorted names data to new file
      try { // create try block
         FileWriter writer = new FileWriter("namesSorted.txt"); // create new FileWriter titled writer to read from "namesSorted.txt"
         BufferedWriter bw = new BufferedWriter(writer); // create new BufferedWriter titled bw to read from 'writer'
         for (int i = 0; i < studentName.length; i++){ // run loop starting at index 0, ending index 35 (array length), and incrementing by 1 each time
            bw.write(studentName[i]); // write student name at index to file
            bw.newLine();  // go to next line
            int grade = studentGrade[i]; // initialize variable grade to hold the value at index i in studentGrade array
            bw.write(Integer.toString(grade)); // write student grade in String from to file
            bw.newLine(); // go to next line
         } // end loop
         bw.close(); // close file      
       }
       catch(Exception e){} // catch Exception e
    }  // end method  
   
   public void numberGradeSort(){ // method used to sort and output names of students and their corresponding grades in descending numerical order (using insertion sort)
      for (int check = 1; check < studentName.length; check++){ // run loop with variable check starting at 1, going to length of array (35) and incrementing by 1 each time
         String compare1 = studentName[check]; // initialize String compare1 to name at index of check in studentName array
         int compare2 = studentGrade[check]; // initialize String compare2 to grade at index of check in studentGrade array
         int previousLine = check-1; // initialize integer previousLine as line before check
         
         while (previousLine >= 0 && compare2 > studentGrade[previousLine]){ // while in bounds and studentGrade at check index is larger than earlier index...
            studentName[previousLine + 1] = studentName[previousLine]; // set studentName at line above previous line to studentName at the previous line
            studentGrade[previousLine + 1] = studentGrade[previousLine];// set studentGrade at line above previous line to studentGrade at the previous line
            previousLine--; // decrement previousLine by 1
         }
         
         studentName[previousLine + 1] = compare1; // studentName at value above previous line is now compare1 value for future loop
         studentGrade[previousLine + 1] = compare2;// studentGrade at value above previous line is now compare2 value for future loop
      }
      
      System.out.println("\n- STUDENTS SORTED BY GRADES IN DESCENDING ORDER -"); // print title
      System.out.println("\nStudent Name     Student Grade (%)");// print categories
      for (int i = 0; i < studentGrade.length; i++){ // run loop starting at index 0, ending index 35 (array length), and incrementing by 1 each time
         System.out.printf("%-14s", studentName[i]); // print student name at index
         System.out.printf("%-9s", "|"); // make column line seperator
         System.out.println(studentGrade[i]); // print student grade at index
      }
   } // end method
   
   public void gradesSortedToFile(){ // method used to output sorted grades data to new file
      try { // create try block
         FileWriter writer = new FileWriter("gradesSorted.txt"); // create new FileWriter titled writer to read from "namesSorted.txt"
         BufferedWriter bw = new BufferedWriter(writer); // create new BufferedWriter titled bw to read from 'writer'
         for (int i = 0; i < studentName.length; i++){ // run loop starting at index 0, ending index 35 (array length), and incrementing by 1 each time
            bw.write(studentName[i]); // write student name at index to file
            bw.newLine(); // go to next line
            int grade = studentGrade[i]; // initialize variable grade to hold the value at index i in studentGrade array
            bw.write(Integer.toString(grade)); // write student grade in String from to file
            bw.newLine(); // go to next line
         }// end loop
         bw.close();   // close file    
       }
       catch(Exception e){} // catch Exception e  
    }  // end method       
      
   public static void main (String[] args){ // main method
      SortingStudents a = new SortingStudents(); // create new instance of SortingStudents class titled 'a'
      a.alphaNameSort(); // call alphaNameSort method
      a.namesSortedToFile(); // call namesSortedToFile method
      a.numberGradeSort(); // call numberGradeSort method
      a.gradesSortedToFile(); // call gradesSortedToFile method
   }// end method
  
} // end program