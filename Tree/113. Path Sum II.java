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
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) {
        
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currpath=new ArrayList<>();
        helper(root,targetsum,result,currpath);
        return result;
    }
    
    public static void helper(TreeNode root, int targetsum,List<List<Integer>> result,List<Integer> curr)
    {
        if(root==null) return;
        
        //Adding current node into our current path
        curr.add(root.val);
        if(root.left==null && root.right==null)
        {
            //checking if our targe is achieved or not
            if(targetsum==root.val)
            {
                //Making copy of our currentpath because it get changed when we backtrack
                List<Integer> copy=new ArrayList<>();
                for(Integer i:curr)
                {
                    copy.add(i);
                }
                
                //Adding into all paths list
                result.add(copy);
            }
            
            //Removing leaf node for exploring more paths
            curr.remove(curr.size()-1);
            return;
        }
        
        helper(root.left,targetsum-root.val,result,curr);
        
        helper(root.right,targetsum-root.val,result,curr);
        
        //Removing last element because we have to backtrack our path for finding more nodes
        curr.remove(curr.size()-1);
    }
}
