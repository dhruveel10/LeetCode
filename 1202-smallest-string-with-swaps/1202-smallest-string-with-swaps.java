class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> pair : pairs) {
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }
        
        boolean[] visited = new boolean[s.length()];
        char[] result = new char[s.length()]; 
        
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                List<Integer> indices = new ArrayList<>();
                List<Character> characters = new ArrayList<>();
                
                dfs(i, adj, visited, s, indices, characters);
                
                Collections.sort(indices);
                Collections.sort(characters);
                
                for (int j = 0; j < indices.size(); j++) {
                    result[indices.get(j)] = characters.get(j);
                }
            }
        }
        
        return new String(result);
    }
    
    private void dfs(int i, List<List<Integer>> adj, boolean[] visited, String s, List<Integer> indices, List<Character> characters) {
        visited[i] = true;
        indices.add(i);
        characters.add(s.charAt(i));
        
        for (int neighbor : adj.get(i)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, s, indices, characters);
            }
        }
    }
}
