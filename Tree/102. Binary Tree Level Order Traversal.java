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
    public List<List<Integer>> levelOrder(TreeNode root) {
         
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
        {
            return result;
        }
        
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        List<Integer> currlevel=new ArrayList<>();
        while(queue.size()>0)
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                
                TreeNode ele=queue.remove();
               currlevel.add(ele.val);
               
                if(ele.left!=null)
                {
                    queue.add(ele.left);
                }
                
                if(ele.right!=null)
                {
                    queue.add(ele.right);
                }
            }
            
            result.add(currlevel);
            currlevel=new ArrayList<>();
        }
        return result;
        
    }
}
