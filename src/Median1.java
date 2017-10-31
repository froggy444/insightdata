

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Median1 {
    static class Median{
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        void addNum(int num){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if(maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        double getMedian(){
            if(maxHeap.size() == minHeap.size()){
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }
            else{
                return (double) maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        int n = 5;
        Median m = new Median();
        for(int a_i=0; a_i < n; a_i++){
            int current = list.get(a_i);
            m.addNum(current);
            System.out.println(m.getMedian());
        }
    }

    public List<Long> calculateMedian(List<Long> amountList, int runningCount) {
        List<Long> list=new ArrayList<>();
        Median m = new Median();
        for (int i = 0; i < runningCount; i++) {
            long current = amountList.get(i);
            m.addNum((int)(current));
            long median = Math.round(m.getMedian());
            list.add(median);

        }
        return list;
    }
}
