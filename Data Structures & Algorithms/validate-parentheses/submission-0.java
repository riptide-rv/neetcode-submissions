class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Deque<Character> dq = new ArrayDeque<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        int i = 0;
        while ( i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                if ((dq.size() == 0) || (map.get(s.charAt(i)) != dq.pop()))  return false;
            } else {
                dq.push(s.charAt(i));
            }
            System.out.println(dq);
            i++;
        }

        if(dq.size() != 0) return false;
        return true;
        
    }
}
