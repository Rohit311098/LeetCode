/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    public boolean helper(ListNode head, TreeNode root)
    {
         //Agar LL null ho jaaye toh true because mil chuki hai
        if(head==null) return true;
        
        //Agar tree null ho jaaye toh false because ll is still left
        if(root==null) return false;
        
        if(root.val==head.val)
        {   
            if(helper(head.next,root.left)==true)
            {
                return true;
            }
            
            if(helper(head.next,root.right)==true)
            {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        //Agar LL null ho jaaye toh true because mil chuki hai
        if(head==null) return true;
        
        //Agar tree null ho jaaye toh false because ll is still left
        if(root==null) return false;
        
        //Check karege current node head node ban sakta hai kya using helper function and then left and right subtree per traverse karege using issubPath same function and then phir se next node k liye check karege using same helper function
        
        return helper(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
        
    }
}
