class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs) {
            char[] arr = s.toCharArray();

            Arrays.sort(arr);

            String sorted = new String(arr);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }

            map.get(sorted).add(s);


        }

        return new ArrayList<>(map.values());
    }
}
