1. Brute Force- TC-O(N+M)  SC-O(N+M)
  
class Tree
{
    public static int getcount(Node root)
    {
        Node curr,rightmost;
        int count=0;
        
        if(root==null)
        {
            return count;
        }
        
        curr=root;
        while(curr!=null)
        {
            
            if(curr.left!=null)
            {
                 rightmost=curr.left;
                
                while(rightmost.right!=null && rightmost.right!=curr)
                {
                    rightmost=rightmost.right;
                }
                
                if(rightmost.right==null)
                {
                    rightmost.right=curr;
                    curr=curr.left;
                    
                }
                else
                {
                    count++;
                    rightmost.right=null;
                    curr=curr.right;
                    
                }
            }
            else
            {
                count++;
                curr=curr.right;
            }
        }
        
        return count;
        
    }
    public static float findMedian(Node root)
    {
        
        int count=getcount(root);
        
        int currcount=0;
        Node prev=null;
        
        Node curr=root;
        while(curr!=null)
        {
            
            if(curr.left!=null)
            {
                 rightmost=curr.left;
                
                while(rightmost.right!=null && rightmost.right!=curr)
                {
                    rightmost=rightmost.right;
                }
                
                if(rightmost.right==null)
                {
                    rightmost.right=curr;
                    prev=curr;
                    curr=curr.left;
                    
                }
                else
                {
                    count++;
                    rightmost.right=null;
                    prev=curr;
                    curr=curr.right;
                    
                }
            }
            else
            {
                count++;
                
                if()
                
                prev=curr;
                curr=curr.right;
            }
        }
        
        
        
    }
}

2. Optimised Approach-  SC-O(Logn+logm)
