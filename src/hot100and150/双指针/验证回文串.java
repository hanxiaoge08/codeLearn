package hot100and150.双指针;

/**
 * @author hxg
 * @description: 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * @date 2025/2/11 13:23
 */
public class 验证回文串 {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<right){
            //也可以使用Character.isLetterOrDigit判断
            while(left<right&&!isValid(s.charAt(left))){
                left++;
            }
            while(left<right&&!isValid(s.charAt(right))){
                right--;
            }
            if(left<right){
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }


        }
        return true;
    }
    public boolean isValid(char s){
        return (s >= '0' && s <= '9') || (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
    }
}
