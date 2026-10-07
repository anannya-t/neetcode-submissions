class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();

        int start = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(right));

            int length = right - start + 1;
            res = Math.max(res, length);
        }

        return res;
    }
}
