from Graph import *
from GraphProblem import *


# Simple Problem-Solving Agent Class
class SimpleProblemSolvingAgentProgram:

    def __init__(self, initial_state):
        """State is an abstract representation of the state
        of the world, and seq is the list of actions required
        to get to a particular state from the initial state(root)."""
        self.state = initial_state
        self.seq = []


# Greedy Breadth First Search Function
def best_first_graph_search(problem, f):
    f = memoize(f, 'f')
    node = Node(problem.initial)
    frontier = PriorityQueue('min', f)
    frontier.append(node)
    exploredNodes = set()
    finalPath = []
    while frontier:
        node = frontier.pop()
        if problem.goal_test(node.state):
            finalPath.append(node.state)
            return finalPath, node.path_cost

        exploredNodes.add(node.state)
        finalPath.append(node.state)
        for child in node.expand(problem):
            if child.state not in exploredNodes and child not in frontier:
                frontier.append(child)
            elif child in frontier:
                if f(child) < frontier[child]:
                    del frontier[child]
                    frontier.append(child)


# A Star Search Function
def astar_search(problem, h):
    h = memoize(h or problem.h, 'h')
    return best_first_graph_search(problem, lambda n: n.path_cost + h(n))


# Hill Climbing Search Function
def hill_climbing(problem):
    current = Node(problem.initial)
    finalPath = []
    while True:
        neighbors = current.expand(problem)
        if not neighbors:
            break
        finalPath.append(current.state)
        neighbor = argmax_random_tie(neighbors, key=lambda node: problem.value(node.state))
        if problem.value(neighbor.state) <= problem.value(current.state):
            break
        current = neighbor

    print("Hill Climbing Path:", finalPath)
    print("Total Cost:", current.path_cost)





def UndirectedGraph(graph_dict=None):
    """Build a Graph where every edge (including future ones) goes both ways."""
    return Graph(graph_dict=graph_dict, directed=False)


# Romania map graph definition
romania_map = UndirectedGraph(dict(
    Arad=dict(Zerind=75, Sibiu=140, Timisoara=118),
    Bucharest=dict(Urziceni=85, Pitesti=101, Giurgiu=90, Fagaras=211),
    Craiova=dict(Drobeta=120, Rimnicu=146, Pitesti=138),
    Drobeta=dict(Mehadia=75),
    Eforie=dict(Hirsova=86),
    Fagaras=dict(Sibiu=99),
    Hirsova=dict(Urziceni=98),
    Iasi=dict(Vaslui=92, Neamt=87),
    Lugoj=dict(Timisoara=111, Mehadia=70),
    Oradea=dict(Zerind=71, Sibiu=151),
    Pitesti=dict(Rimnicu=97),
    Rimnicu=dict(Sibiu=80),
    Urziceni=dict(Vaslui=142)))

# Romania map coordinates
romania_map.locations = dict(
    Arad=(91, 492), Bucharest=(400, 327), Craiova=(253, 288),
    Drobeta=(165, 299), Eforie=(562, 293), Fagaras=(305, 449),
    Giurgiu=(375, 270), Hirsova=(534, 350), Iasi=(473, 506),
    Lugoj=(165, 379), Mehadia=(168, 339), Neamt=(406, 537),
    Oradea=(131, 571), Pitesti=(320, 368), Rimnicu=(233, 410),
    Sibiu=(207, 457), Timisoara=(94, 410), Urziceni=(456, 350),
    Vaslui=(509, 444), Zerind=(108, 531))


def main():
    agent = GraphProblem('Arad', 'Bucharest', romania_map)
    hill_climbing(agent)
    print("Greedy Best First Search Path:", best_first_graph_search(agent, agent.h)[0])
    print("Total Cost:", best_first_graph_search(agent, agent.h)[1])
    print("A* Search Path: ", astar_search(agent, agent.h)[0])
    print("Total Cost:", astar_search(agent, agent.h)[1])


if __name__ == "__main__":
    main()
