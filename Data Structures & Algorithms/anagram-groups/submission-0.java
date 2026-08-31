class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        // ["act","pots","tops","cat","stop","hat"]
        // "act" -> "act", "cat"
        // "opst" -> "pots", "tops", "stop"
        // "aht" -> "hat"

        Map<String, List<String>> anagramPairs = new HashMap<>();

        for(String str : strs)
        {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            List<String> pairs = anagramPairs.getOrDefault(key, new ArrayList<>());
            pairs.add(str);
            anagramPairs.put(key, pairs);
        }

        List<List<String>> group = new ArrayList<>();
        
        for(List<String> pair : anagramPairs.values())
        {
            group.add(pair);
        }

        return group;

        // TC = O(n * n logn)
        // SC = O(n)

    }
}
