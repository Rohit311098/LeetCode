1. Using Marker or Dummy Node
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
        {
            return result;
        }
        
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        Node marker=new Node(-1);
        
        queue.add(marker);
        
        List<Integer> currlevel=new ArrayList<>();
        while(queue.size()>0)
        {
            Node ele=queue.remove();
            if(ele==marker)
            {
                if(queue.size()==0)
                {
                    result.add(currlevel);
                    continue;
                }
                else
                {
                    result.add(currlevel);
                    currlevel=new ArrayList<>();
                    queue.add(marker);
                }
            }
            else
            {
               currlevel.add(ele.val);
                for(Node child:ele.children)
                {
                    queue.add(child);
                }
            } 
        }
        return result;
    }
}



2. Using a variable size

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
        {
            return result;
        }
        
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        List<Integer> currlevel=new ArrayList<>();
        while(queue.size()>0)
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                
                Node ele=queue.remove();
               currlevel.add(ele.val);
                for(Node child:ele.children)
                {
                    queue.add(child);
                }
            }
            
            result.add(currlevel);
            currlevel=new ArrayList<>();
        }
        return result;
    }
}
