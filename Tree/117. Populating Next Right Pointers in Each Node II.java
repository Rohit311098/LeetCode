1. Using Extra Space

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        {
            return null;
        }
         Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0)
        {
            int count=queue.size(); 
            for(int i=0;i<count;i++)
            {
                Node curr=queue.remove();
                if(i<count-1)
                {
                    curr.next=queue.peek();
                } 
                if(curr.left!=null)
                {
                    queue.add(curr.left);
                }
                
                if(curr.right!=null)
                {
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}


2. Follow UP- Using Constant Space

class Solution {
   
    public Node connect(Node root) {
        
        if(root==null)
        {
            return null;
        }
        
        Node curr=root;
        while(curr!=null)
        {
             Node head=null,tail=null;
            while(curr!=null)
            {
                if(curr.left!=null)
                {
                    if(head==null)
                    {
                        head=tail=curr.left;
                    }
                    else
                    {
                        tail.next=curr.left;
                        tail=tail.next;
                    }
                }
                if(curr.right!=null)
                {
                    if(head==null)
                    {
                        head=tail=curr.right;
                    }
                    else
                    {
                        tail.next=curr.right;
                        tail=tail.next;
                    }
                }
                curr=curr.next;
          }
            curr=head; 
        }
        return root;
    }
}
