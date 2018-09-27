package test;

/**
 * 一个矩阵，从左上角走到右上角的方法。每次只能往下或者右
 */
public class Matrix{

    public static int getsum(int p, int q) {
        if(p == 1 || q == 1){
            return 1;
        }
        return getsum(p - 1, q) + getsum(p, q - 1);
    }

    public static void main(String[] args) {
        int num = getsum(3, 3);
        System.out.println(num);
    }
}


