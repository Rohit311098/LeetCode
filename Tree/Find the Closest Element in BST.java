class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int K) 
    { 
       if(root==null)
       {
           return K;
       }
       
        int closest=Integer.MAX_VALUE;
       while(root!=null)
       {
           
        closest=Math.min(closest,Math.abs(root.data-K));
        if(root.data<K)
        {
            root=root.right;
        }
        else
             root=root.left;
       }
       
       return closest;
    } 
}         
