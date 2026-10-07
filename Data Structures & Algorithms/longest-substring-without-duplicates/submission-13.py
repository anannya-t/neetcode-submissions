class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        res = 0

        seen = set()

        for r in range(len(s)):
            while s[r] in seen:
                seen.remove(s[l])
                l += 1
            seen.add(s[r])
            length = r - l + 1
            res = max(res, length)
        return res

        