class Solution {
    
    public static int maxdia;
    public int diameterOfBinaryTree(TreeNode root) {
        
        maxdia=Integer.MIN_VALUE;
        
        helper(root);
        
        return maxdia;
    }
    
    public static int helper(TreeNode root)
    {
        if(root==null)
        {
            return -1;
        }
        
        
        //Left se height se aao
        int lh=helper(root.left);
        
        //Right se height le aao
        int rh=helper(root.right);
        
        
        //Abhi wali node k liye dia kya hai calculate kar lo
        int currdia=lh+rh+2;
        
        
        //Maxdia mai ab tak ka maximum dia store kar lo
        maxdia=Math.max(currdia,maxdia);
        
        
        //Return toh hum log height hi ka rahe hai
        return Math.max(lh,rh)+1;
    }
}
