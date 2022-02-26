class Solution
{
    ArrayList<Integer> leftview;
	ArrayList<Integer> leafnode;
	ArrayList<Integer> rightview;
    public void dfs(Node root,int level)
    {
        if(root==null)
        {
            return;
        }
        
        if(root.left==null && root.right==null)
        {
            leafnode.add(root.data);
        }
        
        if(leftview.size()<=level && (root.left!=null || root.right!=null))
        {
            leftview.add(root.data);
        }
        
        if(rightview.size()>level && (root.left!=null || root.right!=null))
        {
            rightview.set(level,root.data);
        }
        else
        {
            if(root.left!=null || root.right!=null)
                 rightview.add(root.data);
        }
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
	ArrayList <Integer> boundary(Node node)
	{
	     ArrayList<Integer> result=new ArrayList<>();
	    if(node==null)
	    {
	        return new ArrayList<>();
	    }
	   
	   if(node.left==null && node.right==null)
	   {
	       return new ArrayList<>(node.data);
	   }
	    
	   leftview=new ArrayList<>();
	   leafnode=new ArrayList<>();
	   rightview=new ArrayList<>();
	    
	    dfs(node,0);
	    
	    Collections.reverse(rightview);
	    
	    rightview.remove(rightview.size()-1);
	    
	    System.out.println(leftview);
	    
	    System.out.println(leafnode);
	    
	    System.out.println(rightview);
	    for(Integer i:leftview)
	    {
	        result.add(i);
	    }
	    
	    for(Integer i:leafnode)
	    {
	        result.add(i);
	    }
	    
	    for(Integer i:rightview)
	    {
	        result.add(i);
	    }
	    return result;
	}
}
