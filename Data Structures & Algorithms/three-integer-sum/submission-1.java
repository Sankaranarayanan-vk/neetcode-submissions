class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        //  [-1,0,1,2,-1,-4]

        // 3 loops

        // [-1,0,1,2,-1,-4]


        // O(N^2)

       //  nums=[-2,0,1,1,2]
       // [-2 0 1 1 2]

       // nums=[-1,0,1,2,-1,-4,-2,-3,3,0,4]
       // nums=[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
       // [-2,0,2],[-2,0,2]]




        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n - 2; i++)
        {
            if(i > 0 && nums[i-1] == nums[i])
            {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            int num = nums[i];

            while(j < k)
            {
                int sum = num + nums[j] + nums[k];

                if(sum == 0)
                {
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    System.out.println(List.of(nums[i], nums[j], nums[k]));

                    while(j < k && j < n - 1 && nums[j-1] == nums[j])
                    {
                        j++;
                    }

                    while(j < k && k < n - 1 && nums[k] == nums[k+1])
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

        // TC 
    }
}
