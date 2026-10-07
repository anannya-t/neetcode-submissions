class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        lowestPrice = prices[0]

        for price in prices:
            lowestPrice = min(lowestPrice, price)
            profit = price - lowestPrice
            res = max(res, profit)
        
        return res