/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        right(root,list,0);
        return list;
    }
    void right(TreeNode root,ArrayList<Integer> list,int currdepth){
        if(root==null){
            return;
        }
        if(currdepth==list.size()){
            list.add(root.val);
        }
        right(root.right,list,currdepth+1);
        right(root.left,list,currdepth+1);
    }
}