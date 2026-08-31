class Solution
{
    public boolean isAnagram(String s, String t)
    {
        // // Approach 1: Strings -> Char array -> sort -> Strings -> equals
        
        // char[] a = s.toCharArray();
        // char[] b = t.toCharArray();

        // Arrays.sort(a);
        // Arrays.sort(b);

        // s = new String(a);
        // t = new String(b);

        // return s.equals(t);

        // TC = O(2n + 2n logn + 2n + n) = O(n logn)
        // SC = O(2n)

        // Approach 2: hash array -> 0 -> 1 hash -> 1 -> 0 -> iterate hash and return res if all are 0.

        int[] hash = new int[128];

        for(char c : s.toCharArray())
        {
            hash[c]++;
        }

        for(char c : t.toCharArray())
        {
            hash[c]--;
        }

        for(int num : hash)
        {
            if(num != 0)
            {
                return false;
            }
        }

        return true;

        // TC = O(n)
        // SC = O(128)
    }
}
