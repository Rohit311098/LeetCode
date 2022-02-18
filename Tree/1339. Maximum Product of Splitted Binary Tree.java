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
   
    public static int getsum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        int leftsum=getsum(root.left);
        int rightsum=getsum(root.right);
        root.val=root.val+leftsum+rightsum;
        return root.val;
    }
    
    public static long maxproduct=0;
    public static long totalsum=0;
    public static void helper(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        //Farak nhi padta preorder mai karo ya postorder mai
        helper(root.left);
        helper(root.right);
        
        //Yaad rakhna hum current node ki both edges means left and right edge dono abhi break karke dekh rahe hai and jo bhi maximum  hoga vo le lege 
        
        //Agar hum current node and uske left node ki edge break kare toh product kya aayega yeh calcualte kar rahe hai
        long leftsum=(root.left==null)? 0l:root.left.val;
        long leftproduct=leftsum*(totalsum-leftsum);
        
        //Agar hum current node and uske right node ki edge break kare toh product kya aayega yeh calcualte kar rahe hai
        long rightsum=(root.right==null)?0:root.right.val;
        long rightproduct=rightsum*(totalsum-rightsum);
        
        maxproduct=Math.max(maxproduct,Math.max(leftproduct,rightproduct));
    }
    public int maxProduct(TreeNode root) {
        
        maxproduct=0;
        totalsum=getsum(root);
        helper(root);
        return (int)(maxproduct%1000000007l);
    }
}
