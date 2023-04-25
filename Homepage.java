import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

// ************************************************************************************************************************
class readwrite{
    Scanner sc = new Scanner(System.in);
    void read(String filename){
        System.out.println("************** DATA IN THE FILE IS THIS  ***************");
        try {

            // Create a FileReader object to read data from the file
            FileReader reader = new FileReader(filename);

            // Create a buffer to hold the data read from the file
            char[] buffer = new char[5000];

            // Read data from the file and store it in the buffer
            int length = reader.read(buffer);

            // Convert the data in the buffer to a string0
            String data = new String(buffer, 0, length);

            // Print the data read from the file
            System.out.println(data);

            // Close the reader object
            reader.close();
            
           
        } catch (IOException e) {
            System.out.println("AN EXCEPTION");
        }
    }

    void write(String filename){

        try {
            // Create a FileWriter object with append mode set to true
            FileWriter writer = new FileWriter(filename, true);

            System.out.println("Enter name of BUSINESS");
            String n = sc.next();
            System.out.println("Enter the CATEGORY");
            String c = sc.next();
            System.out.println("Enter the DESCRIPTION");
            String dec = sc.next();
            System.out.println("Enter the ADDRESS");
            String address = sc.next();
            System.out.println("Enter the MOBILE NO");
            String mobile = sc.next();
            System.out.println("Enter the EMAIL ID");
            String email = sc.next();
            System.out.println("********* DATA SAVED SUCESSFULLY **********");
            


            // Write data to the file
            writer.write(n+"\t\t\t"+c+"\t\t\t"+dec+"\t\t\t"+address+"\t\t\t"+mobile+"\t\t\t"+ email+"\n");

            // Close the writer object to save the changes
            writer.close();
            System.out.println("Enter '*' to Add new Features in Same City");
            System.out.println("Enter '$' to Add new Features in New City ");
            System.out.println("Enter '#' to LOGOUT ");
            String x =sc.next();
           
            if(x.equals("*")){
                System.out.println("***************** YOU CAN ADD NEW DETAILS NOW *****************");
                write(filename);
            }
            else if(x.equals("#")){
               
                Home obj = new Home();
                obj.calluser();
            }
            else if(x.equals("$")){
                System.out.println("***************** YOU CAN CHANGE YOUR CITY NOW *****************");
                adding();
            }
            else{
                System.out.println("************ WRONG ENTRY ***********");
            }


            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    void adding(){
        System.out.println("Type 'ADD' to add features in New City");
        System.out.println("Type 'VIEW' to view features of Cities");
        System.out.println("Type 'USERS' to see USER details");
        String opt = sc.next();
        if(opt.equals("ADD")){
                System.out.println(".......ENTER YOUR LOCATION TO ADD DETAILS........");
                System.out.println("Type 'AMR' to add features of Amritsar");
                System.out.println("Type 'GOA' to add features of Goa");
                System.out.println("Type 'LOC' to add features of Lucknow");
                System.out.println("Type 'MBI' to add features of Mumbai");
                System.out.println("Type 'HYD' to add features of Hyderabad");
                String aloc = sc.next();
        
                switch (aloc){
                    case "HYD":
                    System.out.println("you can add details of hyderabad ");
                    write("hyderabad.txt");
                    
                    break;
                    case "AMR":
                    System.out.println("you can add details of Amritsar ");
                    write("Amritsar.txt");
                    
                    break;
                    case "GOA":
                    System.out.println("you can add details Goa ");
                    write("Goa.txt");
                    
                    break;
                    case "LOC":
                    System.out.println("you can add details of Lucknow ");
                    write("Lucknow.txt");
                    
                    break;
                    case "MBI":
                    System.out.println("you can add details of Mumbai ");
                    write("Mumbai.txt");
                    break;
                    default:
                    System.out.println("****************** INVALID ENTRY ******************");
                    System.out.println("****************** TRY AGAIN ******************");
                    adding();
            }
        }
        else if(opt.equals("VIEW")){
            append1();
        
        }
        else if(opt.equals("USERS")){
            read("newregisters.txt");
            System.out.println();
            System.out.println("***************************************************** DATA DISPLAYED SUCESSFULLY *************************************************");
            System.out.println();
            adding();
        }
        
        else{
            System.out.println("****************** INVALID ENTRY ******************");
            System.out.println("****************** TRY AGAIN ******************");
            adding();
        }

    }


    void reading(){
        
            System.out.println(".......ENTER YOUR LOCATION TO KNOW DETAILS........");
            System.out.println("Type 'AMR' to Know Details of Amritsar");
            System.out.println("Type 'GOA' to Know Details of Goa");
            System.out.println("Type 'LOC' to Know Details of Lucknow");
            System.out.println("Type 'MBI' to Know Details of Mumbai");
            System.out.println("Type 'HYD' to Know Details of Hyderabad");
            String aloc = sc.next();
    
            switch (aloc){
                case "HYD":
                System.out.println("you can read details of hyderabad ");
                read("hyderabad.txt");
                
                break;
                case "AMR":
                System.out.println("you can read details of Amritsar ");
                read("Amritsar.txt");
                
                break;
                case "GOA":
                System.out.println("you can read details Goa ");
                read("Goa.txt");
                
                break;
                case "LOC":
                System.out.println("you can read details of Lucknow ");
                read("Lucknow.txt");
                
                break;
                case "MBI":
                System.out.println("you can add details of Mumbai ");
                read("Mumbai.txt");
                break;
                default:
                System.out.println("****************** INVALID ENTRY ******************");
                System.out.println("****************** TRY AGAIN ******************");
                reading();
        }
    }
    public static boolean checkCredentials(String filePath, String loginUsername, String loginPassword) {
        File file = new File(filePath);
        try {
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] splitLine = line.split(", ");
                String username = splitLine[0];
                String password = splitLine[1];

                if (username.equals(loginUsername) && password.equals(loginPassword)) {
                    read.close();
                    return true;
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean writeCredentials(String filePath, String username, String password) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(username + ", " + password + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    void append1(){
        try{
        
      // The file to which you want to append all the other files
      File outputFile = new File("alldata.txt");
      FileOutputStream fos = new FileOutputStream(outputFile);
      PrintWriter pw = new PrintWriter(fos);
      
      // The list of files to be appended
      File[] filesToAppend = { new File("Hyderabad.txt"), new File("Mumbai.txt"), new File("Lucknow.txt"), new File("Goa.txt"), new File("Amritsar.txt") };
      
      // Iterate through each file and append it to the output file
      for (File file : filesToAppend) {
         BufferedReader br = new BufferedReader(new FileReader(file));
         String line = br.readLine();
         while (line != null) {
            pw.println(line);
            line = br.readLine();
         }
         br.close();
      }
      pw.close();
      fos.close();
      read("alldata.txt");
      System.out.println();
      System.out.println("***************************************************** DATA DISPLAYED SUCESSFULLY *************************************************");
      System.out.println();
      adding();
    }
      catch(IOException e){
        System.out.println("DATA NOT FOUND");
      }
   }

   void newregister( String filename,String n,String p,String g,String m,String em,String lo){
    try{
        FileWriter writer = new FileWriter(filename, true);
        writer.write(n+"\t\t\t"+p+"\t\t\t"+g+"\t\t\t"+m+"\t\t\t"+em+"\t\t\t"+ lo+"\n");

            // Close the writer object to save the changes
            writer.close();
    }
    catch(IOException e){
        System.out.println("AN EXCEPTION OCCOURED");
    }

   }
    }


// ************************************************************************************************************************************************************************************************************************************************
 

class Home{
void calluser(){
   Scanner sc  = new Scanner(System.in);
   System.out.println();
   System.out.println("************************** WELLCOME TO SMARTCITY MANAGEMENT SYSTEM **************************");
   System.out.println(); 
   System.out.println("ENTER '2' TO LOGIN AS A ADMIN ");
   System.out.println("ENTER '3' TO LOGIN AS A USER ");
    int num = sc.nextInt();
    if(num == 2){
        Admin obj1 = new Admin();
        obj1.display2();
    }
    else if ( num == 3){
        User obj1 = new User();
        obj1.display3();
    }
    else{
        System.out.println("Invalid Entry");
    }   
}
}


// ************************************************************************************************************************************************************************************************************************************************
class Admin extends readwrite{
    void display2(){
    
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("******************** ADMIN LOGIN ********************");
        System.out.println();
            System.out.println("ENTER ADMIN USERNAME");
            String username = sc.next();
    
       
            System.out.println("ENTER ADMIN PASSWORD");
            String password = sc.next();

            if("chethan".equals(username) && "12345".equals(password)){
                System.out.println("*************** LOGIN SUCCESFULL ******************");
                adding();
             }
             else if("pramodh".equals(username) && "12345".equals(password)){
                System.out.println("*************** LOGIN SUCCESFULL ******************");
               adding();    
                   }
             else if("sanjay".equals(username) && "12345".equals(password)){
                System.out.println("*************** LOGIN SUCCESFULL ******************");
                adding();        
                }
           
             else{
                System.out.println("**************** Invalid Credentials ****************");
                System.out.println("**************** TRY AGAIN ****************");
                display2();
             }
            
    
            }
        }


// ************************************************************************************************************************************************************************************************************************************************

class User extends readwrite{
    void display3(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("******************** USER LOGIN ********************");
        System.out.println();
        System.out.println("ENTER '!' FOR LOGIN");
        System.out.println("ENTER '%' FOR NEW REGISTRATION");
        String str = sc.next();
        
        switch(str){
            case "!" :
            System.out.println("ENTER USERNAME");
            String username = sc.next();
    
       
            System.out.println("ENTER PASSWORD");
            String password = sc.next();
            String filePath = "userdetails.txt";

            if (checkCredentials(filePath,username,password)){ 
                System.out.println("*************** LOGIN SUCCESFULL ******************");
                reading();
                System.out.println();
                System.out.println("***************************************************** DATA DISPLAYED SUCESSFULLY *************************************************");
                System.out.println();
                System.out.println("Enter '$' to Change the City ");
                System.out.println("Enter '#' to LOGOUT ");
                String x =sc.next();
               
                if(x.equals("$")){
                    reading();
                }
                else if(x.equals("#")){
                    System.out.println("*************** LOGOUT SUCCESFULL ******************");
                    Home obj = new Home();
                    obj.calluser();
                }
               
                else{
                    System.out.println("************ WRONG ENTRY ***********");
                }
            }
            else{
                System.out.println("**************** Invalid Credentials Try Again ****************");
                
                display3();

            }
            break;
            case "%":

            System.out.println("ENTER USERNAME");
            String username1 = sc.next();
            System.out.println("ENTER PASSWORD");
            String password1 = sc.next();
            System.out.println("ENTER GENDER");
            String gender = sc.next();
            System.out.println("ENTER MOBILE NO");
            String mobile = sc.next();
            System.out.println("ENTER EMAIL ID");
            String email = sc.next();
            System.out.println("ENTER LOCATION");
            String location = sc.next();
            newregister("newregisters.txt", username1, password1, gender, mobile, email, location);

            String filePath1 = "userdetails.txt";
            if (writeCredentials(filePath1, username1, password1)){
                System.out.println(" *************** Registration Successful! ***************");
                System.out.println(" *************** PLEASE LOGIN AGAIN ***************");
                display3();
            }
            else{
                System.out.println(" *************** Registration Failed! ***************");
                System.out.println(" *************** Try Again ***************");
                display3();

            }

            break;

        } }}


// ************************************************************************************************************************************************************************************************************************************************

public class Homepage{
    public static void main(String[] arg){
        Scanner sc  = new Scanner(System.in);
        System.out.println();
        System.out.println("************************** WELLCOME TO SMARTCITY MANAGEMENT SYSTEM **************************");
        System.out.println();    
            System.out.println("ENTER '1' FOR OPENING HOME PORTAL");
            System.out.println("ENTER '2' TO LOGIN AS A ADMIN ");
            System.out.println("ENTER '3' TO LOGIN AS A USER ");
            System.out.println("Type Here.......");
            int x = sc.nextInt();
            Home obj1 = new Home();    
            Admin obj2 = new Admin();
            User obj3 = new User(); 
            
            if(x == 1){
                
                obj1.calluser();

            }

            else if(x == 2){
              
                obj2.display2();
            }

            else if(x == 3){
                
                obj3.display3();
            }

            else{
                System.out.println("INVALID INPUT");
            }
        }

    } 