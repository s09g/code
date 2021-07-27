class Solution {
    public int strStr(String s1, String s2) {
        if (s2.length() == 0)   return 0;
        if (s2.length() > s1.length())    return -1;

        int base = 26, mod = 9997;
        int bound = 1, fingerprint = 0, hash = 0;
        for (int i = 0; i < s2.length(); i++) {
            fingerprint = (fingerprint * base + s2.charAt(i) - 'a') % mod;
            hash = (hash * base + s1.charAt(i) - 'a')  % mod;
            bound = bound * base  % mod;
        }
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            if (hash == fingerprint && check(s1, i, s2))    return i;
            if (i == s1.length() - s2.length())     break;
            hash = (hash * base + s1.charAt(i + s2.length()) - 'a') % mod;
            hash = (hash + mod - (s1.charAt(i) - 'a') * bound % mod) % mod;
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