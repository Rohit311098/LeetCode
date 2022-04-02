class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,PriorityQueue<String>> adj=new HashMap<>();
        
        for(int i=0;i<tickets.size();i++)
        {
            String src=tickets.get(i).get(0);
            String dest=tickets.get(i).get(1);
            
            if(adj.containsKey(src))
            {
                adj.get(src).add(dest);
            }
            else
            {
                adj.put(src,new PriorityQueue<>());
                adj.get(src).add(dest);
            }
        }
        
        String src="JFK";
        
        List<String> result=new ArrayList<>();
        
        while(true)
        {
            result.add(src);
            
            if(adj.get(src).size()==0)
            {
                break;
            }
            src=adj.get(src).remove();
        }
        
        return result;
    }
}
