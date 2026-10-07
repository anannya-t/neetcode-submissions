class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for (String s : strs) {
            res += Integer.toString(s.length()) + "#" + s;
        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<String>();

        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j+1, j+1+length);
            res.add(word);
            i = j+1+length;
            
        }
        return res;
    }
}
