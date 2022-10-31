class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n= nums2.length;
        int i=0, j=0, k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i<m && j<n){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else{
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}