from Problem import *
from utils import *
from Node import *


class GraphProblem(Problem):
    """The problem of searching a graph from one node to another."""

    def __init__(self, initial, goal, graph):
        super().__init__(initial, goal)
        self.graph = graph

    def actions(self, A):
        """The actions at a graph node are just its neighbors."""
        return list(self.graph.get(A).keys())

    def result(self, state, action):
        """The result of going to a neighbor is just that neighbor."""
        return action

    def path_cost(self, cost_so_far, A, action, B):
        return cost_so_far + (self.graph.get(A, B) or np.inf)

    def find_min_edge(self):
        """Find minimum value of edges."""
        m = np.inf
        for d in self.graph.graph_dict.values():
            local_min = min(d.values())
            m = min(m, local_min)

        return m

    def value(self, state):
        """Calculate the value of a state (node) in the graph."""
        locations = getattr(self.graph, 'locations', None)
        if locations and state in locations:
            distance_to_goal = distance(locations[state], locations[self.goal])
            return -distance_to_goal
        else:
            return 0

    def h(self, node):
        """h function is straight-line distance from a node's state to goal."""
        locations = getattr(self.graph, 'locations', None)
        if locations:
            if type(node) is str:
                return int(distance(locations[node], locations[self.goal]))

            return int(distance(locations[node.state], locations[self.goal]))
        else:
            return np.inf
