import java.util.*;

public class MinimumMeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Priority queue to store end times of meetings
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        // Iterate through all intervals
        for (int[] interval : intervals) {
            // If the room is free (earliest meeting has ended), remove it
            if (!endTimes.isEmpty() && endTimes.peek() <= interval[0]) {
                endTimes.poll();
            }

            // Add the current meeting's end time
            endTimes.add(interval[1]);
        }

        // The size of the heap indicates the number of meeting rooms required
        return endTimes.size();
    }

    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum meeting rooms required: " + minMeetingRooms(meetings));
    }
}
