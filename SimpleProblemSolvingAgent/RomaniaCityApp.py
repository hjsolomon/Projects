import string
from SimpleProblemSolvingAgent import *


def main():
    # User input
    finished = False
    print("Here are all the possible Romania cities that can be traveled:")
    nodes = romania_map.nodes()
    nodes.sort()
    print(nodes)
    nodes = [''.join(c for c in s if c not in string.punctuation) for s in nodes]

    while not finished:
        validCity1 = False
        validCity2 = False
        while not validCity1 or not validCity2:
            validCity1 = False
            validCity2 = False
            city1 = input("Please enter the origin city: ").translate(str.maketrans('', '', string.punctuation))
            while not validCity1:
                for i in nodes:
                    if i == city1:
                        validCity1 = True

                if not validCity1:
                    city1 = input("Could not find " + city1 + ", please try again: ").translate(str.maketrans('', '', string.punctuation))

            city2 = input("Please enter the destination city: ").translate(str.maketrans('', '', string.punctuation))
            while not validCity2:
                for i in nodes:
                    if i == city2:
                        if city2 != city1:
                            validCity2 = True

                if city1 == city2:
                    print("The same city can't be both origin and destination, please try again.")
                    validCity2 = False
                    break
                if not validCity2:
                    city2 = input("Could not find " + city2 + ", please try again: ").translate(str.maketrans('', '', string.punctuation))

        agent = GraphProblem(city1, city2, romania_map)
        hill_climbing(agent)
        print("Greedy Best First Search Path:", best_first_graph_search(agent, agent.h)[0])
        print("Total Cost:", best_first_graph_search(agent, agent.h)[1])
        print("A* Search Path: ", astar_search(agent, agent.h)[0])
        print("Total Cost:", astar_search(agent, agent.h)[1])

        prompt = input("Would you like to find the best path between other two cities? If so, type 'yes' ").translate(str.maketrans('', '', string.punctuation))

        if prompt.lower() == "yes":
            finished = False
        else:
            finished = True
            print("Thank You For Using Our App")


if __name__ == "__main__":
    main()
