package javaCodes;

import org.testng.annotations.Test;

public class PrimeNumber {
    public static void main(String[] args) {
       int n =7, temp=0;

       for(int i=2;i<n;i++) {
           if (n % i == 0) {
               temp = temp+1;
           }
       }
           if (temp == 0) {
               System.out.println("number is prime :"+n);
           } else {
               System.out.println("number is not prime :"+n);
           }
    }
}
