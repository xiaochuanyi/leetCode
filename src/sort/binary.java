package sort;

/**
 * 二分查找
 */
public class binary {
    public static int binary(int arr[], int a) {
        if (arr.length < 1 || arr == null) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r){
            mid = (l + r) / 2;
            if(a == arr[mid]){
                return mid;
            }else if(a > arr[mid]){
                l = mid + 1;
            }else if(a < arr[mid]){
                r = mid - 1;
            }
        }
        return -1;
    }
}
