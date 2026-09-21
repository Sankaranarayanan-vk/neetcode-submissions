class Solution
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++)
        {
            int j = i + 1;
            int k = n - 1;

            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)
                {
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1])
                    {
                        j++;
                    }

                    while(j < k && nums[k] == nums[k + 1])
                    {
                        k--;
                    }

                }
                else if(sum > 0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }

        return output;

        // TC = O(n^2 + n logn)
        // SC = O(1)
    }
}