package hot100and150.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hxg
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @date 2025/2/16 11:07
 */
public class 有效的括号 {
    public boolean isValid(String s) {

        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack=new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else {
                if(!stack.isEmpty()&&map.get(c).equals(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
