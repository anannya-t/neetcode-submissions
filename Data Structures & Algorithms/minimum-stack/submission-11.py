class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        # store min AT EACH POINT when new element is added, so length of stack and minstack is always the same
        self.stack.append(val)
        val = min(val, self.minStack[-1]) if self.minStack else val
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
