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
