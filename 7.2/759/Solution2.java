import java.util.*;

// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

class Node {
    Interval interval;
    int eid, idx;

    public Node(Interval interval, int eid, int idx) {
        this.interval = interval;
        this.eid = eid;
        this.idx = idx;
    }
}


class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);
        for (int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new Node(schedule.get(i).get(0), i, 0));
        }

        int lastEnd = minHeap.peek().interval.end;
        while (!minHeap.isEmpty()) {
            Node curt = minHeap.poll();
            if (curt.interval.start > lastEnd) {
                ans.add(new Interval(lastEnd, curt.interval.start));
            }
            lastEnd = Math.max(lastEnd, curt.interval.end);

            List<Interval> freeTime = schedule.get(curt.eid);
            if (curt.idx + 1 < freeTime.size()) {
                minHeap.offer(new Node(freeTime.get(curt.idx + 1), curt.eid, curt.idx + 1));
            }
        }
        return ans;
    }
}