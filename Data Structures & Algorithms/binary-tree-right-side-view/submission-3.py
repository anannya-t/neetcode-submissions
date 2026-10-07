# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q = deque()
        q.append(root)

        while q:
            qLen = len(q)

            for i in range(qLen):
                node = q.popleft()
                if node and i == qLen - 1:
                    res.append(node.val)
                if node and node.left:
                    q.append(node.left)
                if node and node.right:
                    q.append(node.right)
            
        return res
