# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        cur = root

        if root is None:
            return TreeNode(val)

        if val < cur.val:
            if cur.left is None:
                cur.left = TreeNode(val)
            else:
                self.insertIntoBST(cur.left, val)

        if val > cur.val:
            if cur.right is None:
                cur.right = TreeNode(val)
            else:
                self.insertIntoBST(cur.right, val)

        return root
        
