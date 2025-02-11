package hot100and150.双指针;

/**
 * @author hxg
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @date 2025/2/11 13:36
 */
public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int ptrS=0,ptrT=0;
        while(ptrS<s.length()){
            while(ptrT<t.length()&&t.charAt(ptrT)!=s.charAt(ptrS)){
                ptrT++;
            }
            if(ptrT==t.length()){
                return false;
            }
            ptrS++;
            ptrT++;
        }
        return true;
    }
}
