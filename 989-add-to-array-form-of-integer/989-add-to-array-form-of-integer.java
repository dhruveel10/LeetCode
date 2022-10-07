class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
     /*int carry = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        for(int i = num.length - 1; i >= 0 || k != 0; i--){
            int digit = k%10;
            int sum = carry + num[i] + digit;

            if(sum <= 9){
                ans.addFirst(sum);
                carry = sum/10;
            }
            else if(i == 0 && sum > 9){
                ans.addFirst(sum);
                carry = sum/10;
            }
            else{
                ans.addFirst(sum%10);
                carry = sum/10;
            }
            k = k/10;
        }
        return ans;
    */
        List<Integer> ans = new ArrayList<>();
        
        for(int i = num.length - 1; i >= 0; i--){
            int sum = num[i] + k;
            ans.add(sum % 10);
            k = sum/10;
        }    

        while(k > 0){
            ans.add(k % 10);
            k = k/10;
        }

        Collections.reverse(ans);
        return ans;
        
    }
}