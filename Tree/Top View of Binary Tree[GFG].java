/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    public static TreeMap<Integer,Pair> top;
    public static class Pair
    {
        int row;
        int data;
        
        Pair(int row,int data)
        {
            this.row=row;
            this.data=data;
        }
    }
     public static void DFS(Node root,int row,int col)
    {
        if(root==null)
        {
            return;
        }
        
        if(top.containsKey(col)==false)
        {
            top.put(col,new Pair(row,root.data));
        }
        else  if(top.get(col).row>row)
        {
            top.get(col).row=row;
            top.get(col).data=root.data;
                
        }
        
        DFS(root.left,row+1,col-1);
        DFS(root.right,row+1,col+1);
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        top=new TreeMap<>();
        DFS(root,0,0);
        for(Integer i:top.keySet())
        {
            result.add(top.get(i).data);
        }
        
        return result;
        
    }
}
