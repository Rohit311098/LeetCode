1. Directly we areer doing optimised because brute force is very easy to code
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      TreeNode successor=null;

      while(root!=null)
      {
          if(root.val>p.val)
          {
              successor=root;
              root=root.left;
          }
          else
          {
              root=root.right;
          }
      }  

      return successor;
       
    }
}
