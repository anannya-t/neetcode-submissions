class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();

        if (digits.isEmpty()) return res;
        res.add("");
        
        String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };

        char[] chars = digits.toCharArray();

        for (char digit: chars) {
            List<String> tmp = new ArrayList<>();
            for (String cur : res) {
                // convert digit to a number
                int index = digit - '0';
                for (char c : digitToChar[index].toCharArray()) {
                    tmp.add(cur + c);
                }
            }
            res = tmp;
        }

        return res;
    }
}
