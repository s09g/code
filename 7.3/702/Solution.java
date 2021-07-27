interface ArrayReader {
    public int get(int index);
}

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while (reader.get(end) < target)
            end *= 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}