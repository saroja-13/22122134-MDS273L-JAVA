<<<<<<< HEAD
import java.util.*;
import java.util.Arrays;


public class lab3 {
    static int meanfun(int[] arr){
        int sum=0;

        for (int i=0;i<arr.length;i++){
            sum+= arr[i];
        }
        int mean = (int)(sum/arr.length);
        return mean;
    }

    static int medianfun(int[] arr,int n){
        Arrays.sort(arr);
        System.out.println("Sorted array is :");
        System.out.println(" ");
        for (int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
        if(n%2!=0)
            return arr[n/2];
        return(arr[(n-1)/2]+arr[n/2])/2;        

    }
    static int modefun(int[] arr, int n){
        int maxValue=0 ,maxCount=0;
        int i,j;
        int count =0;
        for (i=0;i<n;i++){
            for (j=0;j<n;j++){
            if (arr[j] == arr[i])
            ++count;
            }
        }

        if(count>maxCount){
            maxCount=count;
            maxValue=arr[i];
        }
        return maxValue;
    }

    public static void main(String[] args){
        int mean;
        int median;
        int mode;

        Scanner scan =new Scanner (System.in);
        System.out.println("enter the length of an array:");
        
        int num=Integer.parseInt(scan.nextLine());
        int[] arr =new int[num];
        int n= arr.length;

        for(int i=0;i<n;i++){
            System.out.println("ENter the values of the array:");
            arr[i] =Integer.parseInt(scan.nextLine());
        }

        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");

        }


        System.out.println(" ");
        System.out.println(" ");
        System.out.println("option to perform");
        System.out.println("1.Mean ");
        System.out.println("2.Median");
        System.out.println("3.Mode");
        int option;
        option =Integer.parseInt(scan.nextLine());
        switch(option){
            case 1:
            mean =meanfun(arr);
            System.out.println("mean is:"+mean);
            break;
            case 2:
            median = medianfun(arr,n);
            System.out.println("median is :"+median);
            break;
            case 3:
            mode =modefun(arr,n);
            System.out.println("mode is:"+mode);
            break;
        
        }

    }

=======
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
public class lab3{
    
>>>>>>> 1540586a33c28cc6f4c390a0b936f81642dbda7b
}