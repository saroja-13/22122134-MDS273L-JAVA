package Lab7;
import java.io.*;
import java.util.*;


public class lab7 {
    private static Object reader;

    public static void main(String[] args) {
        
    
    File file = new File ("Iris.CSV");
    try{
        if(file .exists()){
            System.out.println("file exists");
        }

        else{
            System.out.println("file not exists");
        }
        Scanner read =new Scanner(file);
        while(read.hasNextLine()){
            System.out.println(read.nextLine());
        }
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    
}
}
