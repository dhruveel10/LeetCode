class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // Initialize the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list
        for (List<Integer> pair : pairs) {
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }
        
        boolean[] visited = new boolean[s.length()];
        char[] result = new char[s.length()]; // To store the result string
        
        // Iterate over each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                // List to store the indices of the connected components
                List<Integer> indices = new ArrayList<>();
                // List to store the characters in the connected components
                List<Character> characters = new ArrayList<>();
                
                // Perform DFS to find all connected nodes
                dfs(i, adj, visited, s, indices, characters);
                
                // Sort the indices and characters
                Collections.sort(indices);
                Collections.sort(characters);
                
                // Place the sorted characters in their correct positions
                for (int j = 0; j < indices.size(); j++) {
                    result[indices.get(j)] = characters.get(j);
                }
            }
        }
        
        // Convert the result array back to a string and return it
        return new String(result);
    }
    
    // DFS function to find all connected nodes and their corresponding characters
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
