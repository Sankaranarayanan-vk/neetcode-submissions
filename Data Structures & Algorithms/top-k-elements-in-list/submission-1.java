class Solution
{
    public int[] topKFrequent(int[] nums, int k)
    {
        // [1,2,2,3,3,3], k = 2
        // 3 -> 3, 2 -> 2, 1 -> 1

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num , 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : map.keySet())
        {
            pq.offer(num);

            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        int[] topK = new int[k];

        for(int i = 0; i < k; i++)
        {
            topK[i] = pq.poll();
        }

        return topK;

        // TC = O(n + klogk)
        // SC = O(n)
    }
}
