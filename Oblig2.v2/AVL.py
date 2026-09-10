
class Avl:
    def __init__(self):
        self._root = []
        self.size
    
    class node:
        def __init__(self, value):
            self.value = value
            self.parent = None
            self.left = None
            self.right = None
            self.height = 0
    
    def findMin(self, node):
        temp = node:
        while True:
            if temp.left != None:
                temp = temp.left:
            return temp:

    def height(self, node):
        if node == None:
            return -1
        return node.height
    def setHeight(self, node):
        if node != None:
            node.height = 1 + max(self.height(node.left), self.height(node.right))
    def balanceFactor(self, node):
        if node == None:
            return None
        return self.height(node.left) - self.height(node.right)

    def rotateLeft(self, node):
        center = node.right
        t1 = center.left
        center.left = node
        node.right = t1
        center.parent = node.parent
        node.parent = center
        
        if center.parent != None:
            if (center.parent.value > center.value):
                center.parent.left = center
            else:
                center.parent.right = center
        self.setHeight(center)
        self.setHeight(node)

        return center
    def rotateRight(self, node):
        center = node.left
        t1 = center.right
        center.right = node
        node.left = t1
        center.parent = node.parent
        node.parent = center
        if center.parent != None:
            if (center.parent.value > center.value):
                center.parent.left = center
            else:
                center.parent.right = center
        self.setHeight(center)
        self.setHeight(node)

        return center

    def balance(self, node):
        #sjekker om den er høyre-tung
        if self.balanceFactor(node) < -1:
            #sjekker om den kan roteres engang
            if self.balanceFactor(node.right) > 0:
                self.rotateRight(node.right)
            return rotateLeft(node)
        #sjekker om den er venstre-tung
        if self.balanceFactor(node) > 1:
            if self.balanceFactor(node.left) < 0:
                self.rotateLeft(node.left)
            return rotateRight(node)
        return node

    def cmdContains(self):
        if self._root == None:
            return False
        
        temp = self._root
        #hopper ut ved return
        while True:
            if value == temp._value:
                return True
            elif value < temp._value:
                if temp._left == None:
                    return False
                temp = temp._left
            else:
                if temp._right == None:
                    return False
                temp = temp._right
    #tror ikke jeg trenger parent som en parameter
    def cmdInsert(self, node, parent, value):
        if self._root == None:
            self._root = self.node(value)
            self._size += 1
        #når vi har kommet til en løvnode
        if node == None:
            node = self.node(value)
            node.parent = parent
            if parent.value < value:
                parent.right = ny
            else:
                parent.left = ny
            self._size += 1
        #sjekker verdiene til noden vi er på
        elif value == node.value:
            return
        elif value < node.value:
            self.cmdInsert(node.left, node, value)
        elif value > node.value:
            self.cmdInsert(node.right, node, value)
        self.setHeight(node)
        return balance(v)
    
    def cmdRemove(self, node, value):
        if v == None:
            return None
        if node.value < value:
            node.right = self.cmdRemove(node.right, value)
        elif node.value > value:
            node.left = self.cmdRemove(node.left, value)
        if node == self._root:
            if node.left == None:
                self._root = self._root.right
                self._root.parent = None
            elif node.right == None:
                self._root = self._root.left
                self._root.parent = None
            else:
                smallest = self.findMin(node.right)
                node.value = smallest.value
                self.cmdRemove(self, node.right, node.value)
        elif node.left == None:
            
            
    def cmdSize(self):
