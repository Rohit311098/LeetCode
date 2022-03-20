public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        {
            return  "#";
        }
        
        String curr=root.val+",";
        
        curr+=serialize(root.left)+","+serialize(root.right);
        
        return curr;
        
    }

    // Decodes your encoded data to tree.
     public class Pair
    {
        TreeNode node;
        char state='l';
        
        Pair(TreeNode node)
        {
            this.node=node;
        }
    }
    public TreeNode deserialize(String data) {
         if(data.equals("#")==true)
        {
            return null;
        }
        
        String[] tokens=data.split(",");
        
        TreeNode root=new TreeNode(Integer.parseInt(tokens[0]));
        
        Stack<Pair> stk=new Stack<>();
        for(String token:tokens)
        {
            
            if(token.equals("#")==true)
            {
                if(stk.peek().state=='l')
                {
                    stk.peek().state='r';
                }
                else
                {
                    stk.pop();
                }
                
            }
            else
            {
                
                TreeNode curr=new TreeNode(Integer.parseInt(token));
                
                if(stk.size()==0)
                {
                    root=curr;
                }
                else
                {
                    
                    Pair p=stk.peek();
                    if(p.state=='l')
                    {
                        p.node.left=curr;
                        p.state='r';
                    }
                    else if(p.state=='r')
                    {
                        p.node.right=curr;
                        stk.pop();
                    }
                }
                stk.push(new Pair(curr));
            }
        }
        return root;
        
    }
}
