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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
         List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
        {
            return result;
        }
        Stack<TreeNode> stk1=new Stack<>();
        Stack<TreeNode> stk2=new Stack<>();
        
        int level=1;
        
        stk1.push(root);
        
       
        while(stk1.size()>0 || stk2.size()>0)
        {
             List<Integer> currlevel=new ArrayList<>();
            if(level%2==1)
            {
                //odd level mai first stack se second stack mai daalege
                while(stk1.size()>0)
                {
                    TreeNode ele=stk1.pop();
                    currlevel.add(ele.val);
                    
                    if(ele.left!=null)
                    {
                        stk2.push(ele.left);
                    }
                    
                    if(ele.right!=null)
                    {
                        stk2.push(ele.right);
                    }
                }
            }
             else
            {
                //odd level mai first stack se second stack mai daalege
                while(stk2.size()>0)
                {
                    TreeNode ele=stk2.pop();
                    currlevel.add(ele.val);
                    
                    if(ele.right!=null)
                    {
                        stk1.push(ele.right);
                    }
                    if(ele.left!=null)
                    {
                        stk1.push(ele.left);
                    }
                } 
            }
            
            System.out.println(currlevel);
            result.add(currlevel);
            level++;
        }
        
        return result;
        
        
    }
}
