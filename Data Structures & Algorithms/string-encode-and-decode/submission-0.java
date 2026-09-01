class Solution
{
    public String encode(List<String> strs)
    {
        StringBuilder encoded = new StringBuilder();

        for(String str : strs)
        {
            encoded.append(str.length()).append("#").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str)
    {
        int i = 0;
        int j = 0;
        List<String> strs = new ArrayList<>();

        while(i < str.length())
        {
            j = i;

            // Get the length of the string, it can be any number of digits
            while(str.charAt(j) != '#')
            {
                j++;
            }

            int len = Integer.valueOf(str.substring(i, j));

            j++;

            String s = str.substring(j, j + len);
            strs.add(s);

            i = j + len;
        }

        return strs;
    }
}
