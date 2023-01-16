package MiscQuestions;

import java.util.ArrayList;
import java.util.List;

public class trainOptimization {
    public static List<Long> minimumCost(List<Integer> red, List<Integer> blue, int blueCost) {

        ArrayList<Long> minCosts = new ArrayList<Long>(red.size() + 1);
        //small note - it's good to initialize the minCosts array since we know
        //its length. Otherwise we could end up wasting extra memory due to
        //the way arrayLists resize

        minCosts.add((long) 0);
        //covers the starting city, which is always 0.

        long redTrackCost = 0;
        long blueTrackCost = blueCost;
        //The key here is that if we know the minimum cost to get to city i on both
        //the red line and the blue line, we will be able to calculate the same
        //minimum costs but to city i+1
        //We need to keep track of both due to edge cases where we have sudden
        //spikes in cost. i.e. red = [1, 100000], blue = [1, 1], blueCost = 100.


        for(int i = 0; i < red.size(); i++) {
            long redTrackCopy = redTrackCost;

            //There are only two ways to get to city i+1 on a red track and two
            //ways to get to city i+1 on a blue track.
            //To get there on a red track, you need to either start on the red
            //track and continue, or start on the blue track, switch to red
            //(which is free), and continue on the red track.
            //To get there on a blue track, either start on blue and continue,
            //or start on red, pay to switch to blue, and continue.
            //This means we can just find the minimum of the two choices every
            //and save them as the optimal ways to get to city i+1.

            redTrackCost = Math.min(redTrackCost + red.get(i), blueTrackCost + red.get(i));
            blueTrackCost = Math.min(blueTrackCost + blue.get(i), redTrackCopy + blueCost + blue.get(i));

            //Whichever the smaller of the two is the more optimal way to get to
            //city i+1.
            minCosts.add(Math.min(redTrackCost, blueTrackCost));
        }

        //runtime of this function is O(N), where N is the length of red and blue.

        return minCosts;
    }
}
