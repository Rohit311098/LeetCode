class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        boolean visited[]=new boolean[n];
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int src=edges[i][0];
            int nbr=edges[i][1];
            graph[src].add(nbr);
            graph[nbr].add(src);
        }
        return dfs(n,graph,source,destination,visited);
    }
    
    public boolean dfs(int n,ArrayList<Integer>[] graph, int src, int dest,boolean visited[])
    {   
        if(src==dest)
        {
            return true;
        }
        
        visited[src]=true;
        
        for(Integer i:graph[src])
        {
            if(visited[i]==false)
            {
                boolean result=dfs(n,graph,i,dest,visited);
                
                if(result==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
