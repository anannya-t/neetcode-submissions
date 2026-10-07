class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 26 character frequency array to a group of words
        res = defaultdict(list)
        for string in strs:
            freq = [0] * 26
            for char in string:
                freq[ord(char) - ord('a')] += 1
            res[tuple(freq)].append(string)
        return list(res.values())
            