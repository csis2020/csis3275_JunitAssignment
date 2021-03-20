/**
 *  CSIS 3275
 *  Hye Kyung Ko  (300323007)
 */
package helix;

import java.security.Signature;

public class MatrixHelixMorph {


    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        //return null; //MODIFY THIS METHOD

        int i = 0;
        int sizeX;
        int sizeY;
        int[][] outMatrix;

        if(inMatrix == null)
            return null;

        if(inMatrix.length == 0){
            return null;
        }


        sizeX = inMatrix.length;
        sizeY = inMatrix[0].length;
        outMatrix = new int[sizeX][sizeY];

        String current_direction;
        int x_increment;
        int y_increment;
        int height;
        int width;
        int moveSize;

        for (i = 0; i < sizeY; i++) {
            outMatrix[0][i] = inMatrix[0][i];
        }

        int totalSize = sizeX * sizeY;
        int x = 0;
        int y = sizeY-1;
        int count = 0;

        //initialize  ----------for DOWN direction ----------------------------------------
        current_direction = "DOWN";
        x_increment = 1;
        y_increment = 0;
        height = sizeX-1;
        width = sizeY;
        moveSize = height; //in case of DOWN, UP : (sizeX -1),  in case of LEFT, RIGHT : (sizeY -1)
        //initialize  ----------for DOWN direction ----------------------------------------

        for (i = sizeY; i < totalSize; i++) {
            count++;
            x += x_increment;
            y += y_increment;

            outMatrix[x][y] = inMatrix[i / sizeY][i % sizeY];

            if (count == moveSize) {

                switch(current_direction){
                    case "DOWN": // Prepare for LEFT direction
                        x_increment = 0;
                        y_increment = -1;
                        width = width-1; ;
                        current_direction = "LEFT";
                        moveSize = width;
                        break;
                    case "LEFT":    // Prepare for UP direction
                        x_increment = -1;
                        y_increment = 0 ;
                        height = height-1;
                        current_direction = "UP";
                        moveSize = height;
                        break;
                    case "UP":  //Prepare for RIGHT direction
                        x_increment = 0;
                        y_increment = 1;
                        width = width-1;
                        current_direction = "RIGHT";
                        moveSize = width;
                        break;
                    case "RIGHT":   //Prepare for DOWN direction

                        x_increment = 1;
                        y_increment = 0;
                        height = height-1;
                        current_direction = "DOWN";
                        moveSize = height;
                        break;
                    default:
                        System.out.println("_DEFAULT_");
                        break;
                }

                //initialize
                count = 0;
            }
        }

        return outMatrix;
    }


}