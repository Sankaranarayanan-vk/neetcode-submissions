class Solution
{
    public boolean hasDuplicate(int[] nums)
    {
        // 1, 2, 3, 3
        
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i - 1] == nums[i])
            {
                return true;
            }
        }

        return false;

        // TC = O(n log n)
        // SC = O(1)
    }
}