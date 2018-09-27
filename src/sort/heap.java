package sort;

public class heap {
    public static void heap(int arr[]){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i <= arr.length - 1; i++){
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while(size > 0){
            heapfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }
    public static void heapInsert(int arr[], int index){
        while(arr[index] < arr[(index - 1) / 2]){
            swap(arr, index, (index -1) / 2);
            index = (index - 1)/2;
        }
    }
    public static void heapfy(int arr[], int index, int size){
        int left = index * 2 + 1;//当前位置的左孩子
        //如果当前位置的左孩子还未到堆的边界，就继续往下比较，用以获得一个新的堆
        while (left < size) {
            int mingest = left + 1 < size && arr[left + 1] < arr[left] ? left + 1 : left;//当前节点的左孩子和右孩子较大的那个孩子的位置
            mingest = arr[index] < arr[mingest] ? index : mingest;//largest为当前子堆最大的那个位置
            if(mingest == index){//如果没变，说明不需要调整堆
                break;
            }else {//否则交换位置,继续往下沉
                swap(arr, mingest, index);
                index = mingest;
                left = index * 2 + 1;
            }
        }
    }
    public static void swap(int arr[],int a,int b){
        if(arr[a] != arr[b]){
            arr[a] = arr[a] ^ arr[b];
            arr[b] = arr[a] ^ arr[b];
            arr[a] = arr[a] ^ arr[b];
        }
    }

    public static void main(String[] args) {
        int a[] = {2,5,6,7,8,3,6,4,7};
        heap(a);
        for (int i:a) {
         System.out.println(i);
         Object object = new Object();
         object.equals(new Object());
         object.hashCode();
        }
    }
}
