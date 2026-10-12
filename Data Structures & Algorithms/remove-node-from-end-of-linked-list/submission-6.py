# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        N = 0
        curr = head

        while curr:
            N += 1
            curr = curr.next

        remove = N - n
        if remove == 0:
            return head.next

        curr = head
        i = 0

        while curr:
            if (i + 1) == remove:
                final = curr.next.next
                curr.next = final
                break
            i += 1
            curr = curr.next

        return head