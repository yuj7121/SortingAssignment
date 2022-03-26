/* Names: Andrew Jamieson, Nicole Poroshenko, Yujin Bae
   Date: March , 2022
   Teacher: Ms. Krasteva
   Program Description: this program will sort countries in a given file
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;

public class SortingCountries {

   ArrayList<String> list = new ArrayList<String>(); //decalres the variable for an arraylsit to store the list from the file
   ArrayList<Integer> pop = new ArrayList<Integer>();  //declares the variable for an arraylist of all populations

   public SortingCountries() {     //default constructor
   }  //end of constructor
   
   /**
   * this method will open a file based on the file name given
   * by the user and load the data into the arraylist list
   * and store the country names, capitals, and areas into the arraylist countires
   * and store populatoins into the arraylist pop
   * @param name This parameter is the name of the file
   */
   private void readFile(String name){
      try{
         Scanner file = new Scanner(new File(name)); //creates a new scanner object
         //puts all data in the file into the arraylist
         while (file.hasNext())  //as long as the file has next line
         {
            String nextWord = file.nextLine();  //stores what's on the file to this temporary string
            list.add(nextWord); //adds that to the arraylist
         }
      } catch (Exception ex){
      }//end of try catch block
      
      //this for loop takes only the population and store it into the arraylist pop 
      for (int i = 0; i < list.size(); i++){
         String temp;  //declares this multiuse temporary variable
         temp = list.get(i); //for now, temp is the whole line
         int population = 0;  //this variable will store the population of the current country

         //find the index of the last space in the string and remove everything before it
         for (int j = temp.length()-1; j>0; j--){
            if (temp.substring(j-1, j).equals(" ")){
               temp = temp.substring(j);  //now temp is only the population
               j=0;  //this will end the loop
            }//end of if
         }//end of inner for loop
         
         //take out commas ands spaces from the string temp
         for (int j = 0; j<temp.length(); j++){
            if (temp.substring(j, j+1).equals(",")||temp.substring(j, j+1).equals(" ")){
               temp = temp.substring(0, j) + temp.substring(j+1, temp.length());
            }//end of if
         }//end of for
         
         //convert temp to an interger and store it in population
         try{
            population = Integer.parseInt(temp);
         } catch(Exception e){
         }//end of try catch block
         
         //adds the int population to the arraylist pop
         pop.add(population);
      }//end of the outer for loop
      
   }//end of readfile method
      
   /**
   * this method will sort the list by country names alphabetically
   * and it will store the sorteddata into a file
   */
   private void countries(){
      
   }//end of countries method
   
   /**
   * this method will sort the list by populations from biggest to smallest
   * and it will store the sorted data into a file
   */
   private void pop(){
      //this variable will be the new sorted array
      ArrayList<String> sorted = new ArrayList<String>(list.size());
      
      //add everthing in list to sorted
      for (String str : list){
         sorted.add(str);
      }//end of for
      
      //sort using selection sort
      for (int i=pop.size()-1; i>=0; i--){
         int min = i;
         for (int j = i-1; j>=0; j--){
            if (pop.get(j)<pop.get(min)){
               min = j;
            }//end of if
         }//end of inner for loop
         pop.remove(min);     //remove the max value from pop
         String temp = sorted.remove(min);   //remove the max value from sorted and store into a temporary string
         
         //format the temporary string
         for (int k = temp.length()-1; k>0; k--){  //find the last space in temp
            if (temp.substring(k-1, k).equals(" ")){
               temp = temp.substring(0, k) + "\t\t\t" + temp.substring(k);  //now temp is only the population
               k=0;  //this will end the loop
               System.out.println(temp);
            }//end of if
         }//end of inner for loop
         
                        System.out.println(temp);

         sorted.add(i, temp);//add temp to its proper place in sorted
      }//end of outer for loop
      //save the sorted arraylist to a file named sortedByPopulation.txt
      save(sorted, "sortedByPopulation.txt");
   }//end of pop method
   
   /**
   * This method will save all the data in the arraylist into a file
   * @param arr This paramter is the arraylist we want to save
   * @param index This paramter is the name of the file we want to make  
   */
   private void save(ArrayList<String> arr, String name){
      //tries to open the file
      try{
         FileWriter f = new FileWriter (new File(name));
         for (String str: arr){
            f.write(str + "\n");
         }  //end of for each string in arr
         f.close();
      } catch (Exception e){
      }  //end of try catch block
   }

      
   /**
   * this is the main emthod which will create an SortingCountries object
   * and run the methods to execute the soritng
   */
   public static void main (String[] args) {
      SortingCountries s = new SortingCountries();
      
      s.readFile("Countries-Population.txt");
      s.countries();
      s.pop();

   }//end of main method

}//end of class
