class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        for(int i=0; i<l.length; i++){
            int low = l[i], high = r[i];
            int[] arr = new int[high - low + 1];

            for(int j = 0, k = low; j<arr.length && k<=high; j++, k++)
                arr[j] = nums[k];

            Arrays.sort(arr);
            boolean count = true;
        
            for(int j = 1; j<arr.length-1; j++){
                if(arr[j]-arr[j-1] != arr[j+1]-arr[j])
                    count = false;
            }
            answer.add(count);
        }

        return answer;
    }
}