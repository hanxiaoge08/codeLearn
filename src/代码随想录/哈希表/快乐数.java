package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hxg
 * @description: 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * @date 2024/9/28 21:11
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> rec = new HashSet<>();
        while (!rec.contains(n) && n != 1) {
            rec.add(n);
            int newN = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                newN += d * d;

            }

            n = newN;
        }
        return n == 1;
    }
    public boolean isHappy1(int n){
        int slow=n;
        int fast=getNext(n);
        while(fast!=1&&slow!=fast){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        return fast==1;

    }
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
