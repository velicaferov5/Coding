package main.java.exercises;

import java.util.List;

public class General {

    /*
     * Complete the 'getClosestHotel' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY world
     *  2. INTEGER x
     *  3. INTEGER y
     */

    public static int getClosestHotel(List<List<Integer>> world, int x, int y) {
        int closestId = 0;
        double closestDist = Double.MAX_VALUE;
        int worldSize = world.size();
        for (int colIndex = 0; colIndex < worldSize; colIndex++) {
            List<Integer> row = world.get(colIndex);
            int rowSize = row.size();
            for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
                int value = row.get(rowIndex);
                if (value > 0) {
                    double dist = getEuclidDistance(row.get(rowIndex), colIndex, x, y);
                    if (dist < closestDist) {
                        closestDist = dist;
                        closestId = value;
                    }
                }
            }
        }
        return closestId;
    }

    private static double getEuclidDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
