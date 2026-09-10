

class Teque:
    def __init__(self):
        self._front = []
        self._back = []

    def push_back(self, element):
        if self._front == None:
            self._front.append(element)
        elif self._back == None:
            self._back.append(element)
        elif (len(self._front) - len(self._back)) == -1:
            self._front.append(self._back.pop(0))
            self._back.append(element)
        else:
            self._back.append(element)

    def push_front(self, element):
        if self._front == None:
            self._front.append(element)
        elif (len(self._front) - len(self._back)) == 1:
            self._back.insert(0, self._front.pop(len(self._front) - 1))
            self._front.insert(0, element)
        else:
            self._front.insert(0, element)
    
    def push_middle(self, element):
        if (len(self._front) - len(self._back)) == 1:
            self._back.insert(0, element)
        else:
            self._front.append(element)

    def get(self, index):
        if (index < len(self._front)):
            return self._front[index]
        else:
            return self._back[index - (len(self._front))]
        
def main():
    my_teque = Teque()
    ant_input = int(input())
    for i in range(ant_input):
        command = input().split()
        if command[0] == "push_front":
            my_teque.push_front(command[1])
        elif command[0] == "push_middle":
            my_teque.push_middle(command[1])
        elif command[0] == "push_back":
            my_teque.push_back(command[1])
        elif command[0] == "get":
            print(my_teque.get(int(command[1])))

main()
