1. First Approach do inorder traversal and simply store in an array and return k-1 index;

TC-O(N)   SC-O(N)

  Yeh wali approach easy hai easily code hp jaayegi
  
2. Optimised Approach-> K ko global lene wala method

class Solution {
    int globalk=0;
    public int kthSmallest(TreeNode root, int k) { 
        globalk=k;
        return inorder(root);
    }
    
    public int inorder(TreeNode root)
    {
        if(root==null)
        {
            return -1;
        }
        
        int leftans=inorder(root.left);
        if(leftans!=-1)
        {
            return leftans;
        }
        globalk--;
        if(globalk==0)
        {
            return root.val;
        }
        
        return inorder(root.right);
    }
}
