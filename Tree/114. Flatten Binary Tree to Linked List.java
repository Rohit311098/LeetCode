1. Using Recursion  TC-O(N)  SC-O(N)( recursion stack )
  
  class Solution {
    public void flatten(TreeNode root) {
        
        if(root==null)
        {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left!=null)
        {
            //Root k right ko store kar lo
            TreeNode rootkaright=root.right;
            
            //root k right ko root ka left bana do
            root.right=root.left;
            
            root.left=null;
            //wahi root ka left wala traverse karte raho vo jo abhi root ka right ban chuka hai
            while(root.right!=null)
            {
                root=root.right;
            }
            root.right=rootkaright;
            
        }
    }
}


2.
  
  

2. Using Khud ki stack   TC-O(N)   SC-O(N) 
  
class Solution {
    
    public class Pair
    {
        TreeNode node;
        char state;
        
        Pair(TreeNode node)
        {
            this.node=node;
            state='l';
        }
    }
    public void flatten(TreeNode root) {
        
        if(root==null)
        {
            return;
        }
        
        Stack<Pair> stk=new Stack<>();
        
        stk.push(new Pair(root));
        
        while(stk.size()!=0)
        {
            Pair top=stk.peek();
            
            if(top.state=='l')
            {
                if(top.node.left!=null)
                {
                    top.state='i';
                    stk.push(new Pair(top.node.left));
                }
                else
                {
                    top.state='i';
                }
            }
            else if(top.state=='i')
            {
                 if(top.node.right!=null)
                {
                    top.state='r';
                    stk.push(new Pair(top.node.right));
                }
                else
                {
                    top.state='r';
                }
            }
            else if(top.state=='r')
            {
                if(top.node.left!=null)
                {
                    //Top k right ko store kar lo
                    TreeNode rootkaright=top.node.right;
                    
                    //Top k right ko root ka left bana do
                    top.node.right=top.node.left;
                    
                    top.node.left=null;
                    //wahi root ka left wala traverse karte raho vo jo abhi root ka right ban chuka hai
                    while(top.node.right!=null)
                    {
                        top.node=top.node.right;
                    }
                    top.node.right=rootkaright;
                }
                stk.pop();
            }
        }
        
    }
}





3. Using Morris traversal -> TC-O(N)   SC-O(1)
  class Solution {
    public void flatten(TreeNode root) {
        
        if(root==null)
        {
            return;
        }
        
        TreeNode curr=root;
        
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode rootkleftkaright=curr.left;
                
                while(rootkleftkaright.right!=null)
                {
                    rootkleftkaright=rootkleftkaright.right;
                }
                
                rootkleftkaright.right=curr.right;
                
                curr.right=curr.left;
                curr.left=null;
            }
            
            curr=curr.right;
        }
        
        
    }
}
  


