package hot100and150.堆;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;
    public MedianFinder(){
        queMin=new PriorityQueue<>((a,b)->(b-a));
        queMax=new PriorityQueue<>((a,b)->(a-b));
    }
    public void addNum(int num){
        if(queMin.isEmpty()||num<=queMin.peek()){
            queMin.offer(num);
            if(queMax.size()+1<queMin.size()){
                queMax.offer(queMin.poll());
            }
        }else {
            queMax.offer(num);
            if(queMax.size()>queMin.size()){
                queMin.offer(queMax.poll());
            }
        }
    }
    public double findMedian(){
        if(queMin.size()>queMax.size()){
            return queMin.peek();
        }
        return (queMax.peek()+queMin.peek())/2.0;
    }
}
