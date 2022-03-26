1. Directly we areer doing optimised because brute force is very easy to code
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */

     TreeNode successor=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
       
       if(root==null)
       {
           return null;
       }

       if(root.val>p.val)
       {
           successor=root;
           inorderSuccessor(root.left,p);
       }
       else
       {
           inorderSuccessor(root.right,p);
       }

       return successor;
    }
}
