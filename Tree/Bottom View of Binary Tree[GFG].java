class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public TreeMap<Integer,Pair> bottomview;
    public class Pair
    {
        int row;
        int data;
        
        Pair(int row,int data)
        {
            this.row=row;
            this.data=data;
        }
    }
     public void DFS(Node root,int row,int col)
    {
        if(root==null)
        {
            return;
        }
        
        if(bottomview.containsKey(col)==false)
        {
            bottomview.put(col,new Pair(row,root.data));
        }
        else  if(bottomview.get(col).row<=row)
        {
            bottomview.get(col).row=row;
            bottomview.get(col).data=root.data;
                
        }
        
        DFS(root.left,row+1,col-1);
        DFS(root.right,row+1,col+1);
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
         ArrayList<Integer> result=new ArrayList<Integer>();
        
        bottomview=new TreeMap<>();
        DFS(root,0,0);
        for(Integer i:bottomview.keySet())
        {
            result.add(bottomview.get(i).data);
        }
        
        return result;
    }
}
