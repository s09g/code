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


class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flatten = new ArrayList<>();
        for (List<Interval> s : schedule) {
            flatten.addAll(s);
        }
        Collections.sort(flatten, Comparator.comparing(i -> i.start));

        LinkedList<Interval> list = new LinkedList<>();
        for (Interval i : flatten) {
            if (!list.isEmpty() && i.start <= list.getLast().end ) {
                list.getLast().end = Math.max(i.end, list.getLast().end);
            } else {
                list.add(i);
            }
        }
        List<Interval> ans = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            int start = list.get(i - 1).end;
            int end = list.get(i).start;
            ans.add(new Interval(start, end));
        }
        return ans;
    }
}