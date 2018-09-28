package factorialnum;

import java.util.Scanner;

/**
 * 求n！尾部o的个数
 * f(n!) =  ( n / 5 ) + f((n / 5)!)
 * 公式博客
 * https://www.cnblogs.com/hutonm/p/5624996.html
 */
public class factorial {
    public static int factorial(int a){
        int num = 0;
        while (a != 0){
            num += a / 5;
            a = a / 5;
        }
        return  num;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(factorial(a));
    }
}
