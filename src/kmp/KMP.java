package kmp;

/**
 * 给出一个文本，给出一个模式串，求模式串在文本中的起始位置
 */
public class KMP {
    /**
    *获得next数组，next数组存放的是模式串每一个位置的相同最长前缀和最长后缀
     * next数组第一个数默认为-1.其他位置数代表当前模式串的位置前方的字符串的相同最大前缀后缀的数量
     * 如abac 在next[3]的位置为1。代表c之前的字符串aba的相同最大前缀后缀的数量为1
     */

    public static int[] getNext(String str){
        if(str.length() < 2){
            return new int[] {-1};
        }
        char p[] = str.toCharArray();
        int next[] = new int[str.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < str.length() - 1){
            if(k == -1 || p[j] == p[k]){
                next[++j] = ++k;
            }else {
                k = next[k];
            }
        }
        return next;
    }
    public static int kmp(String str,String s){
        int strLength = str.length();//文本长度
        int sLength = s.length();//模式串长度
        char strArray[] = str.toCharArray();//文本数组
        char sArray[] = s.toCharArray();//模式串数组
        int next[] = getNext(s);
        int i = 0;//文本指针
        int j = 0;//模式串指针
        int curr;
        while(i <= strLength - 1 && j <= sLength - 1){//当模式串走到底或者文本走到底 就代表匹配结束
            if(strArray[i] == sArray[j]){
                i++;
                j++;
            }else {
                curr = next[j];
                if(curr == -1){
                    i++;
                    j = 0;
                }else {
                    j = next[j];
                }
            }
        }
        if(j == sLength){//成功匹配
            return i - sLength;
        }else {//没有匹配数据
            return -1;
        }
    }
    public static void main(String args[]){
        String s = "abacde";
      /*  int next[] = getNext("BC");
        for (int i: next) {
            System.out.println(i);
        }*/
        System.out.println(kmp(s, "cde"));
    }
}
