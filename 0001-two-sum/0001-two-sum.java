class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int arr[] = new int[2];
        for(int i = 0 ;i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);//in case if conditions fails,this line will append (key, value) in hashtable 
        }
        return arr;
    }
}
//ALTERNATE METHOD - naive
/*            for (int i = 0;i<nums.length;i++){
                for(int j= i+1; j< nums.length;j++){
                    if(nums[i]+nums[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
        return null;      
    }
}
*/

