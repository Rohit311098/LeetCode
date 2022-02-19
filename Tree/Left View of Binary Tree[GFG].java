1. Using Level Order Technique(BFS)
  
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
     
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> leftview=new ArrayList<>();
        
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        
        while(q.size()>0)
        {
            int count=q.size();
            
            for(int i=0;i<count;i++)
            {
                Node curr=q.remove();
                
                if(i==0)
                {
                    leftview.add(curr.data);
                }
                
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        
        return leftview;
      
    }
}


2. Using DFS Approach


  
