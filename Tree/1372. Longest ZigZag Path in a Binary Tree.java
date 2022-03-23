class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        if(root==null)return 0;
        getlen(root.left,0,1);
        getlen(root.right,1,1);
        return max;
    }
    
    public void getlen(TreeNode root,int dir,int len)
    {
        if(root==null)
        {
            return;
        }
        
        max=Math.max(max,len);
        
        // If dir==0 means it is coming from left side
        if(dir==0)
        {
            // if more left present then make len=1
            getlen(root.left,0,1);
            
            //If we have right also then add 1 into our current len
            getlen(root.right,1,len+1);
        }
        else
        {
            // If dir==1 means coming from right side
            
            // if we goes to left side means zig zag working fine hence add 1 in len
             getlen(root.left,0,len+1);
            
            // If we goes more right side then zig zag break hence we make len=1
            getlen(root.right,1,1);
            
        }
    }
   
}
