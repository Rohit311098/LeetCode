class Solution {
    public boolean binarysearch(int[] arr,int left,int right,int target)
    {
        if(left>right)
        {
            return false;
        }
        
        int mid=left+(right-left)/2;
        
        if(arr[mid]==target)
        {
            return true;
        }
        else if(arr[mid]>target)
        {
            return binarysearch(arr,left,mid-1,target);
        }
            return binarysearch(arr,mid+1,right,target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            int left=matrix[i][0];
            int right=matrix[i][m-1];
            
            if(left<=target && target<=right)
            {
                return binarysearch(matrix[i],0,m-1,target);
            }
        }
        
        return false;
        
    }
}
