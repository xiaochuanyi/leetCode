package sort;

/**
 * 快排算法
 */
public class quickSort {
    public static void quickSort(int arr[]){
        if(arr.length < 2 || arr == null){
            return;
        }
        quick(arr,0,arr.length - 1);
    }
    public static void quick(int arr[], int l, int r){
        if (l < r){
            int curr = (int)(Math.random() * (r - l + 1)) + l;
            swap(arr,r,curr);
            int help[] = partition(arr, l, r);
            quick(arr, l, help[0]);
            quick(arr, help[1], r);
        }
    }
    public static int[] partition(int arr[], int l, int r){
        int index = l - 1;//左边界指针
        int more = r;//右边界指针,l为当前数指针
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++index,l++);//当前数小于比较数，左边界扩大一位，当前数向前一位
            }else if(arr[l] > arr[r]){
                swap(arr,l,--more);//当前数大于比较数，把当前数和右边界左的那个数交换，即把右边界扩大一位。l不动，因为l目前为和当前数交换的那个数
            }else {
                l++;//相等的情况，当前数l向前一位
            }
        }
        swap(arr,more,r);//交换完成之后，因为比较数一直没有动，所以要把它和more交换
        return new int[] {index, more};
    }
    public static void swap(int arr[],int a,int b){
        if(arr[a] != arr[b]){
            arr[a] = arr[a] ^ arr[b];
            arr[b] = arr[a] ^ arr[b];
            arr[a] = arr[a] ^ arr[b];
        }
    }
    public static void main(String args[]){
        int a[] = {5,6,7,4,3,2,9,8,0};
        quickSort(a);
        for (int i:a) {
            System.out.println(i);
        }
    }
}
