// Job Sequencing (IB)
https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    public static class Mycomparator implements Comparator<Job>
    {
        public int compare(Job obj1,Job obj2)
        {
            if(obj1.profit!=obj2.profit)
            {
                return obj2.profit-obj1.profit;
            }
            return obj2.deadline-obj1.deadline;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,new Mycomparator());
        int maxdeadline=0;
        for(int i=0;i<n;i++)
        {
            maxdeadline=Math.max(arr[i].deadline,maxdeadline);
        }
        boolean[] slots=new boolean[maxdeadline];
        int maxprofit=0;
        int jobsallocated=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=arr[i].deadline-1;j>=0;j--)
            {
               if(slots[j]==false)
               {
                   slots[j]=true;
                   jobsallocated++;
                   maxprofit+=arr[i].profit;
                   break;
               }
            }
        }
        return new int[]{jobsallocated,maxprofit};
    }
}
