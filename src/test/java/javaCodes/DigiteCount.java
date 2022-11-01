package javaCodes;

public class DigiteCount {
    public static void main(String[] args) {
        int n = 12345,count=0;
        while(n!=0){
            n=n/10;
            ++count;
        }

    }
}
