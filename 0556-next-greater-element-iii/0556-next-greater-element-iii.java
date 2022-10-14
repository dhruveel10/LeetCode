class Solution {
        //556. Next Greater Element III - https://youtu.be/fOeD3CW2c7c (only for logic)
    public int nextGreaterElement(int n) {
        String s = Integer.toString(n);
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = (int) (s.charAt(i) - '0');
        }
        
        int pivot = arr.length - 2; // pivot = finding the number arr[left] < arr[right]
        while(pivot >= 0 && arr[pivot] >= arr[pivot + 1]) {
            pivot --;
        }

        if(pivot == -1) return -1;  //if no pivot is found then it is not possible to create a new no, so -1
        
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > arr[pivot]) {   //finding the next greater element to swap pivot with
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }
        
        Arrays.sort(arr, pivot + 1, arr.length);
        
        long res = 0;
        for(int i = 0; i < arr.length; i++) {
            res *= 10;
            res += arr[i];
        }
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}