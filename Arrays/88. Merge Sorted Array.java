Approach: Using Extra Array and just traversal and compare
TC-O(N+M)  SC-O(N+M)
  
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums2.length==0)
        {
          return;
        }

        if(nums1.length==0)
        {
          for(int i=0;i<n;i++)
          {
            nums1[i]=nums2[i];
          }

          return;
        }
        
        int[] result=new int[m+n];
        int i=0,j=0,k=0;

        while(i<m && j<n)
        {
           if(nums1[i]>nums2[j])
           {
              result[k++]=nums2[j++];
           }
           else
           {
             result[k++]=nums1[i++];
           }
        }

        while(i<m)
        {
          result[k++]=nums1[i++];
        }
        while(j<n)
        {
          result[k++]=nums2[j++];
        }
        
        i=0;
        for(int x:result)
        {
           nums1[i++]=x;
        }
    }
}
