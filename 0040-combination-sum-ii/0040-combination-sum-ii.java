class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int k) {
    
        List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(a);
		
		findCombinations(a, 0, k, new ArrayList<Integer>(), ans);
		
		return ans;
	}
	
	public void findCombinations(int[] a, int index, int target, 
	                       ArrayList<Integer> current, List<List<Integer>> ans){
	    
	    //base case
	    if(target == 0){
	        ans.add(new ArrayList<>(current));
	        return;
	    }
	    
	    if(target < 0)
	        return;
	        
	    for(int i = index; i < a.length; i++){
	        if(i == index || a[i] != a[i-1]){
	            current.add(a[i]);
	            findCombinations(a, i+1, target - a[i], current, ans);
	            current.remove(current.size() -1 );
	        }
	    }
	}
}