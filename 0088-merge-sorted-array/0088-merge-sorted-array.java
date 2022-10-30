class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    /*        System.arraycopy(nums2,0,nums1, m, n);

            for(int j=m+n-1; j>=0; j--){
                for(int i = 0; i<j; i++) {
                    if (nums1[i] > nums1[i + 1]) {
                        if (i == i+1)
                            return;

                        int temp = nums1[i];
                        nums1[i] = nums1[i+1];
                        nums1[i+1] = temp;
                    }
                }
            }
    */
        
            int p1 = m-1, p2 = n-1, i=m+n-1;
            while(p2>=0){
                if(p1>=0 && (nums1[p1]>nums2[p2])) //p1 condition because of m = 0, p1 will be -1 and ArrayIndexOutOfBound
                    nums1[i--] = nums1[p1--];
                else
                    nums1[i--] = nums2[p2--];
            }
    
    
    }
}