//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        int sum = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<n-3; i++){
                if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                    for(int j=i+1; j<n-2; j++){
                        if(j == i+1 ||(j > i+1 && nums[j] != nums[j-1])){
                            int low = j+1;
                            int high = n-1;
                            
                            while(low < high){                    
                                sum = nums[i] + nums[j] + nums[low] + nums[high];

                                if (sum == target) {
                                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                                    ArrayList<Integer> quad = new ArrayList<>(list);
                                    ans.add(quad);
                                    while(low < high && nums[low] == nums[low+1]) low++;
                                    while(low < high && nums[high] == nums[high-1]) high--;
                                    
                                    low++;
                                    high--;
                                }
                                else if (sum > target) {
                                    high--;
                                }
                                else {
                                    low++;
                                }
                            }
                        }
                    
                    }
                }    
            
        }
                
        return ans;
        
    }
}