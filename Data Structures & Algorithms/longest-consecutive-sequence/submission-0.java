class Solution
{
    public int longestConsecutive(int[] nums)
    {
        // [100,4,200,1,3,2]
        // set of nums

        Set<Integer> set = new HashSet<>();

        for(int num : nums)
        {
            set.add(num);
        }

        int n = nums.length;
        int maxLen = 0;

        for(int i = 0; i < n; i++)
        {
            int num = nums[i];

            if(set.contains(num) && !set.contains(num - 1))
            {
                int len = 0;
                int curr = num;

                while(set.contains(curr))
                {
                    len++;
                    set.remove(curr);
                    curr = curr + 1;
                }

                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;

        // TC = O(n)
        // SC = O(n)
    }
}