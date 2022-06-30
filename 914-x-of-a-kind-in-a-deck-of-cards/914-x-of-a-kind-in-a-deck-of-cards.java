class Solution {
    //https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/discuss/759833/Java-Simple-solution-with-description
    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < deck.length; i++) 
            map.put(deck[i], map.getOrDefault(deck[i], 0)+1);
        
        int lowest = Integer.MAX_VALUE;
        for(int i:map.keySet())
            lowest = Math.min(lowest, map.get(i));

        for(int i = lowest; i >= 2; i--){
            boolean lcd = true;

            for(int j:map.keySet())
                if(map.get(j) % i != 0)
                    lcd = false;
            
            if(lcd == true)
                return true;
        }

        return false;
    }
}