class Solution {
    List<Character> res = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();
    Map<Character, Boolean> visited = new HashMap<>();

    public String foreignDictionary(String[] words) {

        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];

            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).
            equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    /*if (!map.containsKey(w1.charAt(j))) {
                        map.put(w1.charAt(j), new ArrayList<>());
                    }*/
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        visited = new HashMap<>();
        for (char c : map.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        // make res into a string
        Collections.reverse(res);

        String alpha = "";

        for (char c : res) {
            alpha += Character.toString(c);
        }

        return alpha;

    }

    public boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);

        for (char next : map.get(c)) {
            if (dfs(next)) {
                return true;
            }
        }

        visited.put(c, false);
        res.add(c);
        return false;
    }
}
