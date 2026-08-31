class Solution
{
    public boolean isAnagram(String s, String t)
    {
        // Approach 1: Strings -> Char array -> sort -> Strings -> equals
        
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        s = new String(a);
        t = new String(b);

        return s.equals(t);

        // TC = O(2n + 2n logn + 2n + n) = O(n logn)
        // SC = O(2n)
    }
}
