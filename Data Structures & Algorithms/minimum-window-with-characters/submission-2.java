class Solution 
{
    public String minWindow(String s, String t) 
    {
        // Optimal

        int[] hash = new int[256];
        int len = Integer.MAX_VALUE;
        int startInd = -1;
        int count = 0;
        int left = 0;
        int right = 0;

        for(char c : t.toCharArray())
        {
            hash[c]++;
        }

        while(right < s.length())
        {
            char c = s.charAt(right);

            if(hash[c] > 0)
            {
                count++;
            }

            hash[c]--;

            while(count == t.length())
            {
                if(len > right - left + 1)
                {
                    len = right - left + 1;
                    startInd = left;
                }

                hash[s.charAt(left)]++;

                if(hash[s.charAt(left)] > 0)
                {
                    count--;
                }

                left++;
            }

            right++;
        }
        
        return startInd == - 1 ? "" : s.substring(startInd, startInd + len);

        // TC = O(n)
        // SC = O(256)

        // // Brute
        // int len = Integer.MAX_VALUE;
        // int startInd = -1;

        // for(int i = 0; i < s.length(); i++)
        // {
        //     int[] hash = new int[256];
        //     int count = 0;

        //     for(int j = 0; j < t.length(); j++)
        //     {
        //         hash[t.charAt(j)]++;
        //     }

        //     for(int j = i; j < s.length(); j++)
        //     {
        //         char c = s.charAt(j);

        //         if(hash[c] > 0)
        //         {
        //             count++;
        //         }

        //         hash[c]--;

        //         if(count == t.length())
        //         {
        //             if(len > j - i + 1)
        //             {
        //                 len = j - i + 1;
        //                 startInd = i;
        //             }
        //             break;
        //         }
        //     }
        // }

        // return startInd == -1 ? "" : s.substring(startInd, startInd + len);

        // // TC = O(n^2)
        // // SC = O(256)
    }
}