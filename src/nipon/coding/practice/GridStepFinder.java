package nipon.coding.practice;

import nipon.coding.model.Point;

/**
 * Problem:
 * https://www.geeksforgeeks.org/minimum-steps-needed-to-cover-a-sequence-of-points-on-an-infinite-grid/
 *
 * @author nipon
 */
public class GridStepFinder {

    public static void main(String[] args) {
        Point[] points = new Point[4];
        points[0] = new Point(4, 6);
        points[1] = new Point(1, 2);
        points[2] = new Point(4, 5);
        points[3] = new Point(10, 12);

        test(points);

        points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(1, 2);

        test(points);
    }

    public static void test(Point[] points) {

        GridStepFinder gridStepFinder = new GridStepFinder();
        System.out.println("steps:" + gridStepFinder.findShortestPathSteps(points));
    }

    public int findShortestPathSteps(Point[] points) {
        int steps = 0;
        for (int i = 0; i < points.length - 1; i++) {
            steps += calculateShortestPaht(points[i], points[i + 1]);
        }

        return steps;
    }

    private int calculateShortestPaht(Point p1, Point p2) {

        int dx = Math.abs(p1.getX() - p2.getX());
        int dy = Math.abs(p1.getY() - p2.getY());

        return Math.max(dx, dy);
    }
}
