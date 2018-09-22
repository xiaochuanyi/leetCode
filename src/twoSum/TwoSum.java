package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class TwoSum {
    public static int[] SumIndex(int arr[],int target){
        if(arr.length < 2){
            return null;
        }
        //用于存储返回结果的索引
        int resultIndex[] = new int[2];
        //用于储存数组中的所有数和指针，key为数组值，value为索引
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i <= arr.length - 1 ; i++){
            Integer curr = map.get(target - arr[i]);
            //用于判断数组中是否有值满足两个数和的条件
            if(curr != null){
                resultIndex[0] = i;
                resultIndex[1] = map.get(target - arr[i]);
                return resultIndex;
            }else {
                //每循环一次就将数组中的数和索引放入map中
                map.put(arr[i],i);
            }
        }
        return  null;
    }
}
