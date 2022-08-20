from collections import defaultdict
from enum import Enum


class NodeState(Enum):
    UNVISITED = 1
    PROCESSING = 2
    VISITED = 3


class Solution:

    def find_order(self, num_courses, prerequisites):
        """
        :type num_courses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """

        def dfs(node):
            nonlocal cycled

            # Don't recurse further if we found a cycle already
            if cycled:
                return

            # Start the recursion
            node_states[node] = NodeState.PROCESSING

            if node in adj_list:
                for neighbor in adj_list[node]:
                    if node_states[neighbor] == NodeState.UNVISITED:
                        dfs(neighbor)
                    elif node_states[neighbor] == NodeState.PROCESSING:
                        # An edge to a PROCESSING vertex represents a cycle
                        cycled = True

            # Recursion ends. We mark it as VISITED
            node_states[node] = NodeState.VISITED
            topological_sorted_order.append(node)

        # Create the adjacency list representation of the graph
        adj_list = defaultdict(list)
        # A pair [a, b] in the input represents edge from b --> a
        for dest, src in prerequisites:
            adj_list[src].append(dest)

        topological_sorted_order = []
        cycled = False
        # By default, all vertices are UNVISITED
        node_states = {k: NodeState.UNVISITED for k in range(num_courses)}

        for vertex in range(num_courses):
            # If the node is unprocessed, then call dfs on it.
            if node_states.get(vertex) == NodeState.UNVISITED:
                dfs(vertex)

        return topological_sorted_order[::-1] if not cycled else []
