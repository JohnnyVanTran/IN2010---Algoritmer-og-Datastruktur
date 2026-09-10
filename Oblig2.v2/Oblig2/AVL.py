class Node:
    def __init__(self, element):
        self.left = None
        self.right = None
        self.element = element

class AVL:
    def __init__(self):
        self.root = None
        self.str = 0
    #returnerer høyden til en node
    def height(self, node):
        if node == None:
            return -1
        return 1 + max(self.height(node.left), self.height(node.right))
    #setter høyden til en node
    def setHeight(self, node):
        if node == None:
            return None
        node.height = self.height(node)
    #rotasjoner
    def leftRot(self, node):
        center = node.right
        t1 = center.left
        center.left = node
        node.right = t1
        self.setHeight(center)
        self.setHeight(node)
        return center

    def rightRot(self, node):
        center = node.left
        t1 = center.right
        center.right = node
        node.left = t1
        self.setHeight(center)
        self.setHeight(node)
        return center
    #sjekker om den er høyre eller venstre tung
    def balanceFactor(self, node):
        if node == None:
            return 0
        return self.height(node.left) - self.height(node.right)
    
    def balance(self, node):
        if self.balanceFactor(node) < -1:
            if self.balanceFactor(node.right) > 0:
                node.right = self.rightRot(node.right)
            return self.leftRot(node)
        if self.balanceFactor(node) > 1:
            if self.balanceFactor(node.left) < 0:
                node.left = self.leftRot(node.left)
            return self.rightRot(node)
        return node
    def findMin(self, node):
        if node.left == None:
            return node
        return self.findMin(node.left)

    def contains(self, node, x):
        if node == None:
            print(False)
            return
        if node.element == x:
            print(True)
            return
        if node.element < x:
            self.contains(node.right, x)
        if node.element > x:
            self.contains(node.left, x)

    def insert(self, node, x):
        if self.root == None:
            self.str += 1
            self.root = Node(x)
        elif node == None:
            self.str += 1
            node = Node(x)
        elif node.element == x:
            return node
        elif node.element < x:
            node.right = self.insert(node.right, x)
        elif node.element > x:
            node.left = self.insert(node.left, x)
        self.setHeight(node)
        if node == self.root:
            self.root = self.balance(node)
            return
        return self.balance(node)

    def remove(self, node, x):
        if node == None:
            return None
        if node.element < x:
            node.right = self.remove(node.right, x)
        elif node.element > x:
            node.left = self.remove(node.left, x)
        #returner andre siden hvis den er null
        elif node.left == None:
            self.str -= 1
            node = node.right
        elif node.right == None:
            self.str -= 1
            node = node.left
        else:
            self.str -= 1
            smallest = self.findMin(node)
            node.element = smallest.element
            node.right = self.remove(node.right, node.element)
        self.setHeight(node)
        return self.balance(node)

    def size(self):
        print(self.str)

def main():
    tree = AVL()
    itr = int(input())
    for i in range(itr):
        cmd = input().split()
        if cmd[0] == "insert":
            tree.insert(tree.root, int(cmd[1]))
            if tree.root == None:
                print("root er null")
        if cmd[0] == "remove":
            tree.remove(tree.root, int(cmd[1]))
        if cmd[0] == "contains":
            tree.contains(tree.root, int(cmd[1]))
        if cmd[0] == "size":
            tree.size()

main()