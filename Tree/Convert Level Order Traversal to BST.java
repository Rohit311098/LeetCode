class GFG 
{
    public static class Pair
    {
        Node parent;
        int leftrange;
        int rightrange;
        
        Pair()
        {
            parent=null;
            leftrange=Integer.MIN_VALUE;
            rightrange=Integer.MAX_VALUE;
        }
        Pair(Node parent,int leftrange,int rightrange)
        {
            this.parent=parent;
            this.leftrange=leftrange;
            this.rightrange=rightrange;
        }
    }
    public Node constructBST(int[] arr)
    {
        int n=arr.length;
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair());
        int idx=0;
        Node root=null;
        while(queue.size()>0 && idx<n)
        {
            Pair p=queue.remove();
            
           
            
            if(arr[idx]<p.leftrange || arr[idx]>p.rightrange)
            {
                continue;
            }
            
            Node newnode=new Node(arr[idx]);
            if(p.parent==null)
            {
                root=newnode;
            }
            else 
            {
                if(arr[idx]<p.parent.data)
                {
                    p.parent.left=newnode;   
                }
                else
                {
                    p.parent.right=newnode;
                    
                }
            }
            queue.add(new Pair(newnode,p.leftrange,newnode.data));
            queue.add(new Pair(newnode,newnode.data,p.rightrange));
            
            idx++;
        }
        
        return root;
    }
}
