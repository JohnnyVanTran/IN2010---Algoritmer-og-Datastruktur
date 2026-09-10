
class Tree:
    def __init__(self):
        self._size = 0
        self._root = None
    #node klassen min
    class node:
        def __init__(self, value):
            self._value = value
            self._parent = None
            self._left = None
            self._right = None
    #contains
    def cmdContains(self, value):
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
    
    def cmdInsert(self, value):
        if self._root == None:
            self._root = self.node(value)
            self._size += 1
            return
        
        temp = self._root
        while True:
            if value == temp._value:
                return
            elif value < temp._value:
                if temp._left == None:
                    nynode = self.node(value)
                    nynode._parent = temp
                    temp._left = nynode
                    self._size += 1
                    return
                temp = temp._left
            else:
                if temp._right == None:
                    nynode = self.node(value)
                    nynode._parent = temp
                    temp._right = nynode
                    self._size += 1
                    return
                temp = temp._right
    
    def cmdRemove(self, value):
        #de gjør veldig mye likt. tror jeg kan halvere eller skrive dette på en mye bedre måte. Akkurat nå gir jeg faen
        if self._root == None:
            return
        
        temp = self._root
        #hopper ut ved return
        while True:
            if value == temp._value:
                if temp == self._root:
                    if (temp._left != None and temp._right != None):
                        temp2 = temp._right
                        while True:
                            if temp2._left != None:
                                temp2 = temp2._left
                            else:
                                break
                        if temp2._right != None:
                            temp2._right._parent = temp2._parent
                            temp2._parent._left = temp2._right
                        temp2._left = temp._left
                        temp2._right = temp._right
                        temp2._left._parent = temp2
                        temp2._right._parent = temp2
                        break
                    if temp._left != None:
                        temp = temp._left
                        temp._parent = None
                        self._root = temp
                        break
                    elif temp._left != None:
                        temp = temp._right
                        temp._parent = None
                        self._root = temp
                        break
                    else:
                        self._root = None
                        break
                if value < temp._parent._value:
                    #sjekker forskjellige senarioer
                    if (temp._left != None and temp._right != None):
                        temp2 = temp._right
                        #finner det minste elementet på høresiden til noden vi er på
                        while True:
                            if temp2._left != None:
                                temp2 = temp2._left
                            else:
                                break
                        if temp2._right != None:
                            if temp2._parent != temp:
                                temp2._parent._left = temp2._right
                                temp2._right._parent = temp2._parent #fikser forelder
                            else:
                                temp._left._parent = temp2
                                temp2._parent = temp._parent
                                temp2._left = temp._left
                                temp._parent._left = temp2
                                break
                        else :
                            temp2._parent._left = None
                        #setter seg selv som forelder
                        temp2._left = temp._left
                        temp2._left._parent = temp2
                        temp2._right = temp._right
                        temp2._right._parent = temp2
                        temp2._parent = temp._parent
                        temp2._parent._left = temp2
                        break
                    #sjekker hvis bare vensttre er None
                    elif temp._left != None:
                        temp._parent._left = temp._left
                        temp._left._parent = temp._parent
                        break
                    #sjekker hvis høyre er None
                    elif temp._right != None:
                        temp._parent._left = temp._right
                        temp._right._parent = temp._parent
                        break
                    else:
                        temp._parent._left = None
                        temp._parent = None
                        break
                #hvis vi ikke er på venstre side er vi på høyre
                else:
                    #sjekker forskjellige senarioer
                    if (temp._left != None and temp._right != None):
                        temp2 = temp._right
                        #finner det minste elementet på høresiden til noden vi er på
                        while True:
                            if temp2._left != None:
                                temp2 = temp2._left
                            else:
                                break
                        if temp2._right != None:
                            if temp2._parent != temp:
                                temp2._parent._left = temp2._right
                                temp2._right._parent = temp2._parent #fikser forelder
                            else:
                                temp._left._parent = temp2
                                temp2._parent = temp._parent
                                temp2._left = temp._left
                                temp._parent._right = temp2
                                break
                        else :
                            temp2._parent._left = None
                        #setter seg selv som forelder
                        temp2._left = temp._left
                        temp2._left._parent = temp2
                        temp2._right = temp._right
                        temp2._right._parent = temp2
                        temp2._parent = temp._parent
                        temp2._parent._right = temp2
                        break
                    #sjekker hvis bare vensttre er None
                    elif temp._left != None:
                        temp._parent._right = temp._left
                        temp._left._parent = temp._parent
                        break
                    #sjekker hvis høyre er None
                    elif temp._right != None:
                        temp._parent._right = temp._right
                        temp._right._parent = temp._parent
                        break
                    else:
                        temp._parent._right = None
                        temp._parent = None
                        break
            elif value < temp._value:
                if temp._left == None:
                    return
                temp = temp._left
            else:
                if temp._right == None:
                    return
                temp = temp._right
        self._size -= 1
    
    def cmdSize(self):
        return self._size





def hovedprogram():
    binaryTree = Tree()

    antInput = int(input())
    for i in range(antInput):
        cmd = input().split(" ")
        if (cmd[0] == "contains"):
            print(binaryTree.cmdContains(cmd[1]))
        elif (cmd[0] == "insert"):
            binaryTree.cmdInsert(cmd[1])
        elif (cmd[0] == "remove"):
            binaryTree.cmdRemove(cmd[1])
        elif (cmd[0] == "size"):
            print(binaryTree.cmdSize())
hovedprogram()
