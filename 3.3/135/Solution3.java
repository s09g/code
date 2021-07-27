class Solution {
    public int candy(int[] ratings) {
        if(ratings.length < 2)
            return ratings.length;

        int end = 0, sum = 0;
        while(end < ratings.length) {
            if(end + 1 < ratings.length && ratings[end] == ratings[end+1]) {
                sum++;
                end++;
                continue;
            }

            int start = end;
            while (end + 1 < ratings.length && ratings[end] < ratings[end+1])
                end++;

            int peak = end;
            while(end + 1 < ratings.length && ratings[end] > ratings[end+1])
                end++;

            if(start == end) {
                sum++;
                break;
            }

            int left = peak - start;
            int right = end - peak;
            sum += accumulate(left) + accumulate(right) + Math.max(left, right);
        }
        return sum;
    }

    int accumulate(int num) {
        return (1 + num) * num / 2;
    }
}