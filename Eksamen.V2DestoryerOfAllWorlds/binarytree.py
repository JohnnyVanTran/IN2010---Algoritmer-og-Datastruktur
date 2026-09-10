class node:
    def __init__(self, value):
        self.element = value
        self.right = None
        self.left = None
        self.height = 0
def printTree(x):
    if x != None:
        print(x.element)
        printTree(x.left)
        printTree(x.right)
class binTree:
    def __init__(self):
        self.root = None
    def findMin(self, x):
        if x.left == None:
            return x
        return self.findMin(x.left)
    def insert(self, x, value):
        if self.root == None:
            self.root = node(value)
        if x == None:
            return node(value)
        if x.element >= value:
            x.left = self.insert(x.left, value)
            return x
        x.right = self.insert(x.right, value)
        return x
    def remove(self, x, value):
        if x == None:
            return None
        if x.element < value:
            x.left = self.remove(x.left, value)
            return x
        if x.element > value:
            x.right = self.remove(x.right, value)
            return x
        if x.right == None:
            return x.left
        if x.left == None:
            return x.right
        u = self.findMin(x.right)
        x.element = u.element
        x.right = self.remove(x.right, u.element)
        return x
    def printTree(self, x):
        if x != None:
            print(x.element)
            self.printTree(x.left)
            self.printTree(x.right)

class AVLtree:
    def __init__(self):
        self.root = None
    def findMin(self, x):
        if x.left == None:
            return x
        return self.findMin(x.left)
    def leftRotate(self, x):
        y = x.right
        temp = y.left
        x.right = temp
        y.left = x
        self.setHeight(x)
        self.setHeight(y)
        return y
    def rightRotate(self, x):
        y = x.left
        temp = y.right
        x.left = temp
        y.right = x
        self.setHeight(x)
        self.setHeight(y)
        return y
    def Height(self, x):
        if x == None:
            return -1
        return x.height
    def setHeight(self, x):
        if x != None:
            x.height = 1 + max(self.Height(x.left), self.Height(x.right))
    def balanceFactor(self, x):
        if x == None:
            return 0
        return self.Height(x.left) - self.Height(x.right)
    def Balance(self, x):
        if self.balanceFactor(x) < -1:
            if self.balanceFactor(x.right) > 0:
                x.right = self.rightRotate(x)
            return self.leftRotate(x)
        if self.balanceFactor(x) > 1:
            if self.balanceFactor(x.left) < 0:
                x.left = self.leftRotate(x.left)
            return self.rightRotate(x)
        return x
    def insert(self, x, value):
        if self.root == None:
            self.root = node(value)
        if x == None:
            x = node(value)
        elif x.element > value:
            x.left = self.insert(x.left, value)
        elif x.element < value:
            x.right = self.insert(x.right, value)
            
        self.setHeight(x)
        if x == self.root:
            self.root = self.Balance(x)
            if value == 8:
                self.printTree(self.root)
            return
        return self.Balance(x)
    def remove(self, x, value):
        if x == None:
            return None
        if x.element > value:
            x.left = self.remove(x.left, value)
        elif x.element < value:
            x.right = self.remove(x.right, value)
        elif x.left == None:
            x = x.right
        elif x.right == None:
            x = x.left
        else:
            u = self.findMin(x.right)
            x.element = u.element
            x.right = self.remove(x.right, u.element)
        self.setHeight(x)
        return self.Balance(x)

class minHeap:
    def __init__(self):
        self.heapList = []
    def parentOf(self, index):
        return int((index - 1) / 2)
    def rightOf(self, index):
        return int(2 * index + 2)
    def leftOf(self, index):
        return int(2 * index + 1)
    def insert(self, x):
        n = len(self.heapList)
        self.heapList.append(x)
        i = n
        while i > 0 and self.heapList[i] < self.heapList[self.parentOf(i)]:
            temp = self.heapList[i]
            self.heapList[i] = self.heapList[self.parentOf(i)]
            self.heapList[self.parentOf(i)] = temp
            i = self.parentOf(i)
    def remove(self):
        x = self.heapList[0]
        self.heapList[0] = self.heapList.pop()
        i = 0
        while self.rightOf(i) < len(self.heapList) - 1:
            j = None
            if self.heapList[self.leftOf(i)] <= self.heapList[self.rightOf(i)]:
                j = self.leftOf(i)
            else:
                j = self.rightOf(i)
            if self.heapList[j] > self.heapList[i]:
                break
            temp = self.heapList[i]
            self.heapList[i] = self.heapList[j]
            self.heapList[j] = temp
            i = j
        if self.leftOf(i) < len(self.heapList) - 1 and self.heapList[self.leftOf(i)] <= self.heapList[i]:
            temp = self.heapList[i]
            self.heapList[i] = self.heapList[self.leftOf(i)]
            self.heapList[self.leftOf(i)] = temp
        return x
heap = minHeap()
heap.insert(6)
heap.insert(1)
heap.insert(8)
heap.insert(2)
heap.insert(3)
heap.insert(9)
heap.insert(7)
print(heap.heapList)
print(heap.remove())
print(heap.remove())
print(heap.heapList)
