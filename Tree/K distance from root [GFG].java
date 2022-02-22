/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
     // Recursive function to print right view of a binary tree.
     public void helper(Node root,int k,ArrayList<Integer> result)
     {
         if(root==null)
         {
             return ;
         }
         if(k==0)
         {
             result.add(root.data);
             return;
         }
         helper(root.left,k-1,result);
         helper(root.right,k-1,result);
     }
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          if(root==null)
          {
              return new ArrayList<>();
          }
          
          ArrayList<Integer> result=new ArrayList<>();
          helper(root,k,result);
          return result;
     }
}
