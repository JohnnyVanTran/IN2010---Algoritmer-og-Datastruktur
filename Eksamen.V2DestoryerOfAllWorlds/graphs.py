def dfsIt(G, s, visited):
    stack = stack cointing s
    while stack not empty:
        u = stack.pop()
        if u not in visited:
            visited.add(u)
            for (u, v) in E:
                stack.push(v)
def bfs(G, s, visited):
    queue = queue contining s
    visited.add(s)
    while queue not empty:
        u = queue.deque
        for (u, v) in E:
            if u nor in visited:
                visited.add(u)
                queue.enque(v)
def topsort(G):
    stack = empty stack
    output = list
    for u in V:
        if u ingrad 0:
            stack.push(u)
    
    while stack not empty:
        u = stack.pop()
        output.append(u)
        for (u, v) in E:
            remove incoming edge from u
            if v indegree is 0:
                stack.push(v)
    if len(output) < len(V):
        error "inneholder sykel"
    return output

def dfsTopsort(G):
    output = stack
    visited = set()

    for u in V:
        if u not in visited:
            dfsVisit(G, u, visited, stack)
    return stack

def Dijkstra(G, s):
    dist = map
    q = queue
    dist[s] = 0
    while q not empty:
        u = q.Removemin()
        for (u, v) in E:
            c = dist[u] + weight(u, v)
            if c < dist[v]:
                dist[v] = c
                insert(queue, v, c)
    return dist

def bellmanford(G, s):
    dist = map
    for v in V:
        dist[v] = uendelig
    dist[s] = 0

    for _ in range(len(V) - 1):
        for (u, v) in E:
            c = dist[u] + weight((u, v))
            if c < dist[v]:
                dist[v] = c
    for (u, v) in E:
        c = dist[u] + weight((u, v))
        if c < dist[v]:
            error "inneholder negativ sykel"
    return dist

def DAGsp(G, s):
    dist = empty map
    dist[s] = 0
    for u in topsort(G):
        for (u, v) in E:
            c = dist[u] + weight((u, v))
            if c < dist[v]:
                dist[v] = c

def Prims(G):
    q = empty pq
    parents = map
    insert(q, (null, s)) with prio 0 for vilkårlig node s i V
    while q not empty:
        (p, u) = Removemin(q)
        if u not in parents:
            parents[u] = p 
            for (u, v) in E:
                Insert(q, (u, v)) with prio weight(u, v)
    return parents