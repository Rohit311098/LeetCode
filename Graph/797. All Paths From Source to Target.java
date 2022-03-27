class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        boolean[] visited=new boolean[graph.length];
        List<List<Integer>> allpath=new ArrayList<>();
        List<Integer> currpath=new ArrayList<>();
        dfs(0,graph,currpath,allpath,visited);
        return allpath;
    }
    
    public void dfs(int src,int[][] graph,List<Integer> currpath,List<List<Integer>> allpath,boolean[] visited)
    {
        currpath.add(src);
        if(src==graph.length-1)
        {
            allpath.add(new ArrayList(currpath));
            return;
        }
        
        visited[src]=true;
        
        for(Integer i: graph[src])
        {
            dfs(i,graph,currpath,allpath,visited);
            currpath.remove(currpath.size()-1);
        }
    }
}
