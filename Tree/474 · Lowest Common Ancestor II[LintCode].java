1. Approach 1 Using HashSet
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here

        HashSet<ParentTreeNode> set=new HashSet();

        ParentTreeNode temp=A;
        while(temp!=null)
        {
            set.add(temp);

            temp=temp.parent;
        }  

        ParentTreeNode ans=null;

        while(B!=null)
        {
            if(set.contains(B))
            {
                ans=B;
                break; 

            }

            B=B.parent;
        }

        return ans;
    }
}
