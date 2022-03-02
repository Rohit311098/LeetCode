class Solution {
    public boolean isValidSerialization(String preorder) {
        
        if(preorder.equals("#")==true)
        {
            return true;
        }
        
        String[] tokens=preorder.split(",");
        
        Stack<Character> stk=new Stack<>();
        
        boolean root=false;
        
        for(String token:tokens)
        {
            if(token.equals("#")==true)
            {
                if(stk.size()==0)
            {
                return false;
            }
                Character top=stk.pop();
                if(top=='l')
                {
                    top='r';
                    stk.push(top);
                }
            }
            else
            {
                
                if(stk.size()==0)
                {
                    if(root==true)
                    {
                        return false;
                    }
                    else
                    {
                        root=true;
                    }
                }
                else 
                {
                    Character top=stk.pop();
                     if(top=='l')
                    {
                        top='r';
                        stk.push(top);
                    }
                }
                stk.push('l');
            }
        }
        
        
        if(stk.size()!=0)
        {
            return false;
        }
        
        return true;
    }
}
