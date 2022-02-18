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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allpaths=new ArrayList<>();
        helper(root,allpaths,"");
        return allpaths;
    }
    
    public static void helper(TreeNode root,List<String> allpaths,String currpath)
    {
        if(root==null)
        {
            return;
        }
        
        if(root.left==null && root.right==null)
        {
            
            allpaths.add(currpath+root.val);
            return;
        }
        
        currpath+=root.val;
        helper(root.left,allpaths,currpath+"->");
        
        helper(root.right,allpaths,currpath+"->");
    }
}
