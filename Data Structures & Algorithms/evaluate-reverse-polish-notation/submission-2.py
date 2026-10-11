class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # push number onto stack
        # operator: pop two numbers, apply, push result back

        stack = []

        for c in tokens:
            if c == "+":
                arg1 = stack.pop()
                arg2 = stack.pop()
                val = arg1 + arg2
                stack.append(val)
            elif c == "-":
                arg1 = stack.pop()
                arg2 = stack.pop()
                val = arg2 - arg1
                stack.append(val)
            elif c == "*":
                arg1 = stack.pop()
                arg2 = stack.pop()
                val = arg1 * arg2
                stack.append(val)
            elif c == "/":
                arg1 = stack.pop()
                arg2 = stack.pop()
                val = int(float(arg2) / arg1)
                stack.append(val)
            else:
                stack.append(int(c))
        return stack[0]
