# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def valid(node, minimum, maximum):
            if node is None:
                return True
            if (minimum < node.val < maximum):
                return (valid(node.left, minimum, node.val) 
                and valid(node.right, node.val, maximum))
            return False
        
        return valid(root, float("-inf"), float("inf"))