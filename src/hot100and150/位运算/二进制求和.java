package hot100and150.位运算;

/**
 * @author 12293
 * @description: 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * @date 2025/2/28 14:31
 */
public class 二进制求和 {
    public String addBinary(String a, String b) {
        StringBuilder ans=new StringBuilder();
        int ca=0;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            int sum=ca;
            sum+=i>=0?a.charAt(i)-'0':0;
            sum+=j>=0?b.charAt(j)-'0':0;
            ans.append(sum%2);
            ca=sum/2;
        }
        ans.append(ca==1?ca:"");
        return ans.reverse().toString();
    }
}
