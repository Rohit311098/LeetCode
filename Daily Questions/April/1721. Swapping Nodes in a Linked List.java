1. TC-O(2N)   SC-O(1)
  class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int count=1;
        ListNode temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        temp=head;
        ListNode first=null,second=null;
        int start=1;
        while(temp!=null)
        {
            if(start==k)
            {
                first=temp;
            }
            if(start==count-k)
            {
                second=temp;
            }
            temp=temp.next;
            start++;
        }
        int t=first.val;
        first.val=second.val;
        second.val=t;
        return head;
    }
}
