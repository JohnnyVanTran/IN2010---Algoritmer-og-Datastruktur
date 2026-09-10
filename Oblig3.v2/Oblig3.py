import queue

class Actor:
    def __init__(self, nmID, name):
        self.nmID = nmID
        self.name = name
        self.actorMovies = set()

class Movies:
    def __init__(self, ttID, tittle, rating):
        self.ttID = ttID
        self.tittle = tittle
        self.rating = rating
        self.castList = set()

class Program:
    def __init__(self):
        self.moviesDict = {}
        self.actorDict = {}
    #oppgave 1
    def readFile(self):
        #leser film liste
        moviesFile = open("movies.tsv", "r")
        actorFile = open("actors.tsv", "r")
        for movie in moviesFile:
            movieInfo = movie.strip().split("\t")
            self.moviesDict[movieInfo[0]] = Movies(movieInfo[0], movieInfo[1], movieInfo[2])

        for actor in actorFile:
            actorInfo = actor.strip().split("\t")
            a = Actor(actorInfo[0], actorInfo[1])

            for i in range(2, len(actorInfo)):
                if actorInfo[i] not in self.moviesDict: continue
                    #henter film fra dict og legger til skuespiller i filmen
                tempMovie = self.moviesDict[actorInfo[i]]
                tempMovie.castList.add(a)
                a.actorMovies.add(tempMovie)
            self.actorDict[a.nmID] = a
    
    #teller kanter
    def countEdges(self):
        ant = 0
        for movie in self.moviesDict.values():
            #kan se på en film som en komplett graf kan derfor telle kanter ved å
            #telle kanter med len(cast) * (len(cast) - 1) / 2 
            ant += (len(movie.castList) * (len(movie.castList) - 1)) // 2
        return ant
    
    #bfs: returner en liste med riktig output
    #oppgave 2
    def bfs(self, actorID1, actorID2):
        a = self.actorDict[actorID1]
        b = self.actorDict[actorID2]
        visited = set()
        visitedMovie = set()
        aQueue = list()
        aQueue.append(a)
        parentDict = {}
        parentDict[a] = None

        while len(aQueue) > 0:
            temp = aQueue.pop(0)
            visited.add(temp)

            for movie in temp.actorMovies:
                #sjekker om vi har vært i en film tidligere. 
                #Har vi vært der vet vi at b ikke er der
                if movie in visitedMovie: continue

                for tempAct in movie.castList:
                    if tempAct in visited: continue
                    if tempAct == b:
                        parentDict[tempAct] = [temp, movie]
                        break
                    parentDict[tempAct] = [temp, movie]
                    aQueue.append(tempAct)
                if b not in parentDict.keys():
                    #passer på at jeg ikke sjekker samme film en gang til
                    visitedMovie.add(movie)
                    continue
                break

            if b not in parentDict.keys(): continue
            break

        if b not in parentDict.keys():
            print("Fant ikke sti fra ( " + a.name + " ) til ( " + b.name + " )")
            return
        
        self.printOut(parentDict, b)
    def printOut(self, path, endActor):
        output = ""
        temp = endActor
        while True:
            if path[temp] == None: break
            output = "\n===( "+ path[temp][1].tittle + " )===>"+ temp.name + output
            temp = path[temp][0]
        output = temp.name + output
        print(output)

    #oppgave 3
    def dijk(self, actorID1, actorID2):
        pri = queue.PriorityQueue()
        dist = {}
        dist[self.actorDict[actorID1]] = (0.0, None, None)
        pri.put((0.0, self.actorDict[actorID1]))

        while not pri.empty():
            temp = pri.get()
            for movie in temp[1].actorMovies:
                for tempAct in movie.castList:
                    if tempAct not in dist.keys():
                        #lager distanse
                        c = dist[temp[1]][0] + float(movie.rating)
                        if tempAct == self.actorDict[actorID2]:
                            dist[tempAct] = (c, movie, temp[1])
                            return dist  
                        dist[tempAct] = (c, movie, temp[1])
                        pri.put((c, tempAct))
                        continue
                    c = dist[temp[1]][0] + float(movie.rating)
                    if c < dist[tempAct]:
                        dist[tempAct] = (c, movie, temp[1]) 
                        pri.put((c, tempAct))
    
    def printOutDijk(self, path, endActor):
        output = ""
        temp = endActor
        while True:
            if path[temp][2] == None: break
            output = "\n===( "+ path[temp][1].tittle + " (" + path[temp][1].rating + ") )===>"+ temp.name + output
            temp = path[temp][2]
        output = temp.name + output
        print(output)




p = Program()
p.readFile()
print(len(p.actorDict) + len(p.moviesDict))
print(p.countEdges())
p.bfs("nm2255973", "nm0000460")
print("\n")
p.bfs("nm0424060", "nm8076281")
print("\n")
p.bfs("nm4689420", "nm0000365")
print("\n")
p.bfs("nm0000288", "nm2143282")
print("\n")
p.bfs("nm0637259", "nm0931324")

p.dijk("nm2255973", "nm0000460")
print("\n")
p.dijk("nm0424060", "nm8076281")
print("\n")
p.dijk("nm4689420", "nm0000365")
print("\n")
p.dijk("nm0000288", "nm2143282")
print("\n")
p.dijk("nm0637259", "nm0931324")
