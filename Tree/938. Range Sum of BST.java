1. Using Auxillary Stack
class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
         if(root==null)
        {
            return 0;
        }
        rangeSumBST(root.left,low,high);
        if(root.val>=low && root.val<=high)
        {
            sum+=root.val;
        }
        rangeSumBST(root.right,low,high);
        
        return sum;
        
    }
}

2. Using Stack
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root==null)
        {
            return 0;
        }
        
        int count=0;
        
        Stack<TreeNode> stk=new Stack<>();
        stk.push(root);
        
        while(stk.size()>0)
        {
            TreeNode top=stk.pop();
            
            if(top.val>=low && top.val<=high)
            {
               count+=top.val;   
            }
            
            if(top.left!=null && top.val>low)
            {
                stk.push(top.left);
            }
            
            if(top.right!=null && top.val<high)
            {
                stk.push(top.right);
            }
        }
        
        return count;
        
    }
}
