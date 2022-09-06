class Solution {
    public static int maxWidthOfVerticalArea(int[][] points) {
        int ans = 0;
        int n = points.length;
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = (points[i][0]);
        }

        Arrays.sort(arr);

        for (int i=0; i<n-1; i++){
            int j = i+1;
            ans = Math.max(ans, arr[j]-arr[i]);
        }

        return ans;
    }
}