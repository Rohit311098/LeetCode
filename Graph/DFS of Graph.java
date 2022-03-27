1. Using Recursive call Stack

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> result=new ArrayList<>();
        
        boolean visited[]=new boolean[v];
        
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
             dfs(i,adj,visited,result);
        }
        return result;
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean[] visited, ArrayList<Integer> result)
    {
        result.add(src);
        visited[src]=true;
        
        for(Integer i:adj.get(src))
        {
            if(!visited[i])
            {
                dfs(i,adj,visited,result);
            }
        }
        
    }
    
}

2. Using Iterative Method at Prepcoding Portal
public static class Pair
   {
       int src;
       String path;
       
       Pair(int src,String path)
       {
           this.src=src;
           this.path=path;
       }
   }
   public static void iterative(int src,ArrayList<Edge>[] graph)
   {
       boolean visited[]=new boolean[graph.length];
       Stack<Pair> stk=new Stack<>();
       stk.push(new Pair(src,src+""));
       
       while(stk.size()>0)
       {
           Pair top=stk.pop();
           
           if(visited[top.src]==true)
           {
               continue;
           }
           
           visited[top.src]=true;
           
           System.out.println(top.src+"@"+top.path);
           
           for(Edge e:graph[top.src])
           {
               if(visited[e.nbr]==false)
               {
                   stk.push(new Pair(e.nbr,top.path+e.nbr));
               }
           }
       }
   }
