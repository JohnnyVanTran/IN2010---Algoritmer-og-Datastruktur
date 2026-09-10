class Node:
    def __init__(self, element):
        self.left = None
        self.right = None
        self.element = element
        self.height = None

class Binary:
    def __init__(self):
        self.root = None
        self.str = 0
    
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
            return
        if node == None:
            self.str += 1
            return Node(x)
        if node.element == x:
            return
        if node.element < x:
            node.right = self.insert(node.right, x)
        if node.element > x:
            node.left = self.insert(node.left, x)
    def remove(self, node, x):
        if self.root == None or node == None:
            return
        if node.element < x:
            node.right = self.remove(node.right)
        if node.element > x:
            node.left = self.remove(node.left)
        #returner andre siden hvis den er null
        if node.left == None:
            self.str -= 1
            return node.right
        if node.right == None:
            self.str -= 1
            return node.left

        smallest = self.findMin(node)
        node.element = smallest.element
        node.right = self.remove(node.right, node.element)
        return node
    def size(self):
        print(self.str)

def main():
    tree = AVL()
    itr = int(input())
    for i in range(itr):
        cmd = input().split()
        if cmd[0] == "insert":
            tree.insert(tree.root, int(cmd[1]))
        if cmd[0] == "remove":
            tree.remove(tree.root, int(cmd[1]))
        if cmd[0] == "contains":
            tree.contains(tree.root, int(cmd[1]))
        if cmd[0] == "size":
            tree.size()

main()

