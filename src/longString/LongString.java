package longString;
import java.util.HashMap;
import java.util.Map;
/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 */
public class LongString {
    public static int getLongString(String str){
        if(str.equals("")){
            return 0;
        }
        Map<String,Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        int start = 0;
        String s[] = str.split("");
        for(int i = 0; i <= s.length - 1; i++){
            if(!map.containsKey(s[i])){
                map.put(s[i], i);
                curr = i - start + 1;
                max = max > curr ? max : curr;
            }else {
                int n = start;
                start = map.get(s[i]) + 1;
                for(int a = n; a <= start - 1; a++){
                    map.remove(s[a]);
                }
                map.put(s[i] ,i);
                curr = i - start + 1;
                max = max > curr ? max : curr;
            }
        }
        return max;
    }
    public static void main(String args[]){
            String s = "abcabcbb";
        System.out.println(getLongString(s));
    }
}
