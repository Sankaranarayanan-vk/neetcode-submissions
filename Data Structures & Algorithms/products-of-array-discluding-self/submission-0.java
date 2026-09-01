class Solution
{
    public int[] productExceptSelf(int[] nums)
    {
        // int n = nums.length;
        // int[] output = new int[n];

        // for(int i = 0; i < n; i++)
        // {
        //     int product = 1;

        //     for(int j = 0; j < n; j++)
        //     {
        //         if(nums[i] != nums[j])
        //         {
        //             product = product * nums[j];
        //         }
        //     }

        //     output[i] = product;
        // }

        // return output;

        // // TC = O(n^2)
        // // SC = O(n)

        // [1,2,4,6]

        // [1,1,2,8]
        // [48,24,6,1]

        // [48,24,12,8]

        int n = nums.length;
        int[] output = new int[n];

        int product = 1;

        for(int i = 0; i < n; i++)
        {
            output[i] = product;
            product = product * nums[i];
        }

        product = 1;

        for(int i = n - 1; i >= 0; i--)
        {
            output[i] = output[i] * product;
            product = product * nums[i];
        }

        return output;

        // TC = O(n)
        // SC = O(n)
    }
}  
