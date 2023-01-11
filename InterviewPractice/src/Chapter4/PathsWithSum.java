package Chapter4;

import DataStructures.BinaryNode;

import java.util.ArrayList;

public class PathsWithSum {
    public static int numPaths(BinaryNode root, int sum) {
        ArrayList<Integer> allPaths = numPathsHelper(root);
        int matching = 0;
        for(int i = 0; i < allPaths.size(); i++) {
            if(allPaths.get(i) == sum) {
                matching++;
            }
        }
        return matching;
    }

    public static ArrayList<Integer> numPathsHelper(BinaryNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> allPossibleSums = new ArrayList<>();
        ArrayList<Integer> leftSums = numPathsHelper(root.left);
        ArrayList<Integer> rightSums = numPathsHelper(root.right);
        for(int i = 0; i < leftSums.size(); i++) {
            allPossibleSums.add(leftSums.get(i));
            allPossibleSums.add(leftSums.get(i) + root.item);
        }
        for(int i = 0; i < rightSums.size(); i++) {
            allPossibleSums.add(rightSums.get(i));
            allPossibleSums.add(rightSums.get(i) + root.item);
        }
        allPossibleSums.add(0);
        allPossibleSums.add(root.item);

        return allPossibleSums;
    }
}
