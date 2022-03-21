1. Brute Force TC-O(N)    SC-O(N) Extra Space HashSet
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

2. TC-O(H)  SC-O(1)   Distance wale method se karege

public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        
        int d1=0,d2=0;

        ParentTreeNode temp1=A;
        while(temp1!=null)
        {
            d1++;
            temp1=temp1.parent;
        }

        ParentTreeNode temp2=B;
        while(temp2!=null)
        {
            d2++;
            temp2=temp2.parent;
        }

        if(d1==d2)
        {
            return A.parent;
        }
        else if(d1>d2)
        {
            temp1=A;
            temp2=B;
            while(d1!=d2)
            {
                temp1=temp1.parent;
                d1--;
            }
        }
        else
        {
            temp1=A;
            temp2=B;
            while(d1!=d2)
            {
                temp2=temp2.parent;
                d2--;
            }
        }

        while(temp1!=null && temp2!=null)
        {
            if(temp1==temp2)
            {
                break;
            }

            temp1=temp1.parent;
            temp2=temp2.parent;
        }

        return temp1;
    }
}
    
