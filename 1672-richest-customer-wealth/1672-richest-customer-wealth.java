class Solution {
    public int maximumWealth(int[][] accounts) {
	var maxWealth = 0;
	for (var customer : accounts)
		maxWealth = Math.max(maxWealth, Arrays.stream(customer).sum());
	return maxWealth;
}
}