1. Using Extra space (BFS Approach)
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
        
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        List<Integer> rightview=new ArrayList<>();
        
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        
        while(q.size()>0)
        {
            int count=q.size();
            
            for(int i=0;i<count;i++)
            {
                TreeNode curr=q.remove();
                
                if(i==count-1)
                {
                    rightview.add(curr.val);
                }
                
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        
        return rightview;
        
    }
}



2. Using DFS

class Solution {
    
    public void helper(TreeNode root,List<Integer> rightview,int level)
    {
        if(root==null)
        {
            return;
        }
        
        if(rightview.size()>level)
        {
            rightview.set(level,root.val);
        }
        else
        {
            rightview.add(root.val);
        }
        
        helper(root.left,rightview,level+1);
        helper(root.right,rightview,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        List<Integer> rightview=new ArrayList<>();
        
        helper(root,rightview,0);
        
        return rightview;
        
    }
}
