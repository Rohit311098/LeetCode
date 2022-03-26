1. Reverse inorder chala lo and same globalk ko decrease karete raha karo
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    int globalk=0;
    public int kthLargest(Node root,int k)
    {
        globalk=k;
        
        return reverseinorder(root);
    }
    
    public int reverseinorder(Node root)
    {
        if(root==null)
        {
            return -1;
        }
        
        int ans=reverseinorder(root.right);
        if(ans!=-1)
        {
            return ans;
        }
        
        globalk--;
        
        if(globalk==0)
        {
            return root.data;
        }
        
        return reverseinorder(root.left);
    }
}
