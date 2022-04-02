class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor)
        {
            return image;
        }
        
        helper(image,sr,sc,newColor,image[sr][sc]);
        
        return image;
    }
    
    public void helper(int[][] image,int sr,int sc,int newColor,int oldcolor)
    {
        if(sr<0 ||  sr>=image.length || sc<0 || sc>=image[0].length || oldcolor!=image[sr][sc])
        {
            return;
        }
        
        image[sr][sc]=newColor;
        
        //Upward direction
        helper(image,sr-1,sc,newColor,oldcolor);
        
        
        //Downward Direction
        helper(image,sr+1,sc,newColor,oldcolor);
        
        //Left Direction
        helper(image,sr,sc-1,newColor,oldcolor);
        
        //Right Direction
        helper(image,sr,sc+1,newColor,oldcolor);
    }
}
