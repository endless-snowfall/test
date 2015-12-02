package jp.co.indeed.construction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class GraphSolution {

    @RequiredArgsConstructor
    static class Island {

        @NonNull Integer label;
        Set<Bridge> bridges = new HashSet<>();

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

    @ToString()
    @AllArgsConstructor
    static class Bridge {

        Island islandA;
        Island islandB;
        int constructionDate;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int Q = sc.nextInt();

            Map<Integer, Island> islands = initializeIslands(N);

            for (int date = 1; date <= Q; date++) {
                String query = sc.next();
                int A = sc.nextInt();
                int B = sc.nextInt();

                if ("build".equals(query)) {
                    buildBridge(islands, A, B, date);
                    continue;
                }

                Map<Bridge, Set<Bridge>> possiblePaths = getPossiblePaths(islands, A, B);
                if (possiblePaths.isEmpty()) {
                    System.out.println("NO");
                    continue;
                }

                Bridge newestOldBridge = getNewestBridge(possiblePaths.keySet());
                System.out.println("YES " + newestOldBridge.constructionDate);
                demolishBridge(islands, newestOldBridge);
            }
        }
    }

    private static Map<Integer, Island> initializeIslands(int N) {
        Map<Integer, Island> result = new HashMap<>();
        IntStream.rangeClosed(1, N).forEach(i -> result.put(i, new Island(i)));
        return result;
    }

    public static void buildBridge(Map<Integer, Island> islands, int A, int B, int date) {
        Island islandA = islands.get(A);
        Island islandB = islands.get(B);
        Bridge newBridge = new Bridge(islandA, islandB, date);
        islandA.bridges.add(newBridge);
        islandB.bridges.add(newBridge);
    }

    public static void demolishBridge(Map<Integer, Island> islands, Bridge bridge) {
        islands.get(bridge.islandA.label).bridges.remove(bridge);
        islands.get(bridge.islandB.label).bridges.remove(bridge);
    }

    public static Map<Bridge, Set<Bridge>> getPossiblePaths(Map<Integer, Island> islands, int A, int B) {
        Island start = islands.get(A);
        Island end = islands.get(B);
        Set<Set<Bridge>> paths = new HashSet<>();

        helper(start, start, end, paths, new LinkedList<>(), new HashSet<>());

        Map<Bridge, Set<Bridge>> result = new HashMap<>();
        for (Set<Bridge> path : paths) {
            Bridge oldestBridge = getOldestBridge(path);
            result.put(oldestBridge, path);
        }

        return result;
    }

    private static void helper(
        Island current,
        Island start,
        Island end,
        Set<Set<Bridge>> result,
        LinkedList<Bridge> currentPath,
        Set<Island> visited)
    {
        if (visited.contains(current)) {
            return;
        }

        if (current == end) {
            // outputPath(currentPath, start, end);
            result.add(new HashSet<>(currentPath));
            return;
        }

        visited.add(current);

        for (Bridge bridge : current.bridges) {
            currentPath.add(bridge);
            Island nextCurrent = (bridge.islandA.label == current.label) ? bridge.islandB : bridge.islandA;
            helper(nextCurrent, start, end, result, currentPath, visited);
            currentPath.removeLast();
        }

        visited.remove(current);
    }

    private static Bridge getOldestBridge(Set<Bridge> bridges) {
        Bridge result = null;
        for (Bridge bridge : bridges) {
            if (result == null || result.constructionDate > bridge.constructionDate) {
                result = bridge;
            }
        }
        return result;
    }

    private static Bridge getNewestBridge(Set<Bridge> bridges) {
        Bridge result = null;
        for (Bridge bridge : bridges) {
            if (result == null || result.constructionDate < bridge.constructionDate) {
                result = bridge;
            }
        }
        return result;
    }

    private static void outputPath(List<Bridge> bridges, Island start, Island end) {
        StringBuilder resultBuilder = new StringBuilder();
        Set<Island> seen = new HashSet<>();

        if (bridges.size() == 1) {
            System.out.println(start.label + " -> " + end.label);
            return;
        }

        String delimiter = "";
        for (Bridge bridge : bridges) {
            resultBuilder.append(delimiter);
            delimiter = " -> ";
            if (bridge.islandA == start || bridge.islandA == end) {
                seen.add(bridge.islandA);
                resultBuilder.append(bridge.islandA.label);
            } else if (bridge.islandB == start || bridge.islandB == end) {
                seen.add(bridge.islandB);
                resultBuilder.append(bridge.islandB.label);
            } else if (seen.contains(bridge.islandA)) {
                seen.add(bridge.islandB);
                resultBuilder.append(bridge.islandB.label);
            } else {
                seen.add(bridge.islandA);
                resultBuilder.append(bridge.islandA.label);
            }
        }

        System.out.println(resultBuilder.toString());
    }
}
