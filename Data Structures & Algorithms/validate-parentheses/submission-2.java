class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> parentheses = new Stack<>();
        Map<Character, Character> closeToStart = new HashMap<>();
        closeToStart.put('}', '{');
        closeToStart.put(')', '(');
        closeToStart.put(']', '[');
        for(Character c : s.toCharArray())
        {
            if(closeToStart.containsKey(c))
            {
                if(!parentheses.isEmpty() && parentheses.peek() == closeToStart.get(c))
                {
                    parentheses.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                parentheses.push(c);
            }
        }
        return parentheses.isEmpty();
    }
}
