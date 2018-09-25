package sort;

/**
 * 归并
 */
public class merge {
    public static void mergeSort(int arr[]){
        if(arr == null || arr.length < 2){
            return;
        }
        merge(arr, 0, arr.length -1);
    }
    //递归函数
    public static void merge(int arr[], int l, int r){
        if(l < r){
            int mid = (l +r)/2;
            merge(arr, l, mid);
            merge(arr, mid + 1, r);
            mergesort(arr, l , mid, r);
        }
    }
    public static void mergesort(int arr[], int l, int mid, int r){
        int help[] = new int[r - l + 1];
        int i = 0;//排序后数组指针
        int p = l;//前半数组指针
        int q = mid + 1;//后半数组指针
        while(p <= mid && q <= r){//外排
            if(arr[p] < arr[q]){
                help[i++] = arr[p++];
            }else if(arr[p] > arr[q]){
                help[i++] = arr[q++];
            }else {
                help[i++] = arr[p++];
                help[i++] = arr[q++];
            }
        }
        //外排完成之后两个小数组可能有一个没走完
        while(p <= mid){
            help[i++] = arr[p++];
        }
        while (q <= r){
                help[i++] = arr[q++];
        }
        //两个小数组排完之后，将help数组放回原本的数组中
        for(int n = 0; n < help.length; n++){
            arr[n + l] = help[n];
        }
    }

    public static void main(String[] args) {
        int a[] = {2,5,6,7,8,3,6,4,7};
        mergeSort(a);
        for (int i:a) {
            System.out.println(i);
        }
    }
}
