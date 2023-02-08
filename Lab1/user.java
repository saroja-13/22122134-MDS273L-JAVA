import java.util.Scanner;
import java.util.concurrent.locks.Condition;

import javax.lang.model.util.ElementScanner14;
class user{
public static void main(String[] args){
    Scanner name =new Scanner(System.in);
    Scanner age =new Scanner(System.in);
    Scanner Class =new Scanner(System.in);
    Scanner gender=new Scanner(System.in);
    
    System.out.println("enter a name:");
    String a=name.nextLine();
    System.out.println("enter age:");
    int b=age.nextInt();
    System.out.println("enter class:");
    String c=Class.nextLine();
    System.out.println("Enter gender:");
    char d=gender.next().charAt(0);
    
    System.out.println("*****************************");
    System.out.println(" name :"+a);
    System.out.println(" age:"+b);
    System.out.println(" class:"+c);
    System.out.println(" gender:"+d);
   
    if (d=='f'){
        System.out.println(" FEMALE");
    }
    else if (d=='m'){
        System.out.println(" MALE");
    }
    
    Scanner state =new Scanner(System.in); 
        
        System.out.print(" enter state:");
        String s =state.nextLine();
        
    switch(s){
        case "Andhra pradesh":
        case "Telengana":
        case "Kerala":{
        System.out.println(" Student belongs to south part of india");
        break;
        }
        case "Delhi":{
        System.out.println(" Student belongs to north part of india");
        break;
        }
        case "Arunachalpradesh":
        case "Bihar":{
        System.out.println(" Student belongs to east part of india");
        break;
        }
        case "Goa": 
        case "Gujarat":{
        System.out.println(" Student belongs to west part of india");
        break;
        }
    }

    System.out.println("*****************************");
    
    
    
    

}
}