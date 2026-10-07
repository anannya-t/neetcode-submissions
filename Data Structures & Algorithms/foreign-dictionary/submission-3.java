class Solution {
    Map<Character, Set<Character>> adj;
    List<Character> res;
    Map<Character, Boolean> visited;

    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!adj.containsKey(c)) {
                    adj.put(c, new HashSet<>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen)
            .equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }

        }

        res = new ArrayList<>();
            visited = new HashMap<>();

            for (char c : adj.keySet()) {
                if (dfs(c)) {
                    return "";
                }
            }

            // res will be built

            Collections.reverse(res);

            String string = "";

            for (char c : res) {
                string += Character.toString(c);
            }
        return string;
    }

    public boolean dfs(char c) {

        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);

        // visit all neightbors
        for (char ch: adj.get(c)) {
            if (dfs(ch)) {
                return true;
            }
        }

        visited.put(c, false);
        res.add(c);
        return false;
    }
}
