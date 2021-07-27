class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (check(haystack, i, needle)) return i;
        }
        return -1;
    }

    private boolean check(String haystack, int idx, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(idx + i) != needle.charAt(i))   return false;
        }
        return true;
    }
}