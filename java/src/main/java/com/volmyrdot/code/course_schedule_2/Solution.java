package com.volmyrdot.code.course_schedule_2;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
 * if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 * So the correct course order is [0,1].
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * <p>
 * Example 3:
 * <p>
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 * <a href="https://leetcode.com/problems/course-schedule-ii/">210. Course Schedule II</a>
 */
class Solution {
    enum NodeState {
        UNVISITED,
        PROCESSING,
        VISITED
    }

    // The adjacency list
    private Map<Integer, List<Integer>> adjList;
    private Map<Integer, NodeState> nodeStates;
    private boolean cycled;
    private List<Integer> topologicalOrder;

    // Using Depth First Search
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (cycled) break;
            if (nodeStates.get(i) == NodeState.UNVISITED) {
                dfs(i);
            }
        }


        if (cycled) {
            return new int[0];
        } else {
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
            return order;
        }
    }

    private void dfs(int node) {
        nodeStates.put(node, NodeState.PROCESSING);

        if (cycled) {
            return;
        }

        for (int n : adjList.getOrDefault(node, new ArrayList<>())) {
            if (nodeStates.get(n) == NodeState.UNVISITED) {
                dfs(n);
            } else if (nodeStates.get(n) == NodeState.PROCESSING) {
                cycled = true;
            }
        }
        nodeStates.put(node, NodeState.VISITED);
        topologicalOrder.add(node);
    }

    private void init(int numCourses, int[][] prerequisites) {
        cycled = false;
        adjList = new HashMap<>();
        nodeStates = new HashMap<>();
        topologicalOrder = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nodeStates.put(i, NodeState.UNVISITED);
        }

        // Create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = adjList.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            adjList.put(prerequisite[1], list);
        }
    }
}

