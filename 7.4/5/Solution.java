class Solution {
    public String longestPalindrome(String s) {
        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = find(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
            len = find(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
        }
        return s.substring(start, start + longest);
    }

    private int find(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) != s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}