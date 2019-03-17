package functions;

import java.util.Scanner;
import java.util.logging.Logger;

public class MatrixModification {
    private static final Logger log = Logger.getLogger(MatrixModification.class.getName());

    static int numOfRows, numOfColumns,row, column, rowFlag=0, columnFlag=0;
    static int[][] Matrix = new int[numOfRows][numOfColumns];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        try{
            getInputMatrix();
            modifyMatrix();
            printModifiedMatrix();
        }

        catch (InvalidInputSizeException e) {
            log.warning("Exception caught");
        }

        finally {
            if(sc!=null)
                sc.close();
        }

    }

    /*
     *It returns modified matrix to TestCase.java
     */
    public int[][] getMatrix() {
        return Matrix;
    }

    /*
     *It gets the input from TestCase.java
     */
    public void setMatrix(int[][] Matrix) {
        numOfRows=Matrix.length;
        numOfColumns=Matrix[0].length;
        this.Matrix = Matrix;
    }

    /*
     *It gets input from the user.
     * Input information like number of rows, number of columns and elements of the matrix.
     */
    public static void getInputMatrix() throws InvalidInputSizeException {
        log.info("Enter number of rows and columns respectively for the input Matrix");
        numOfRows = sc.nextInt();
        numOfColumns = sc.nextInt();
        IsValidInput();
        Matrix = new int[numOfRows][numOfColumns];
        log.info("Enter Elements into Matrix row wise");
        for (row = 0; row < numOfRows; row++) {
            for (column = 0; column < numOfColumns; column++) {
                Matrix[row][column] = sc.nextInt();
            }
        }
    }

    /*
     *It checks if the input size is less than zero.
     *If true then throws an InvalidInputSizeException.
     */
    public static void IsValidInput()throws InvalidInputSizeException{
         if(numOfRows <= 0 || numOfColumns <= 0){
            throw new InvalidInputSizeException();
        }
    }

    /*
     *It holds sequence of operations that are performed to modify Matrix.
     */
    public static void modifyMatrix(){
        setRowFlag();
        setColumnFlag();
        setFirstRowElements();
        setFirstColumnElements();
        setRowElementsToZero();
        setColumnElementsToZero();
        modifyFirstRowElements();
        modifyFirstColumnElements();
    }

    /*
     *Function "setRowFlag" is used to set rowFlag to one if any of the first row elements is zero.
     */
    static void setRowFlag(){
        for(column =0;column < numOfColumns;column++){
         if(Matrix[0][column] == 0){
             rowFlag = 1;
             break;
          }
        }
    }

    /*
     *Function "setColumnFlag" is used to set columnFlag to one if any of the first column elements is zero.
     */
    static void setColumnFlag(){
        for(row =0;row < numOfRows;row++){
            if(Matrix[row][0] == 0) {
                columnFlag = 1;
                break;
            }
        }
    }

    /*
     *Function "setFirstRowElements" is used to set first row elements to zero if any of the elements in that corresponding column is zero.
     */
    static void setFirstRowElements() {
        for (row = 1; row < numOfRows; row++) {
            for (column = 1; column < numOfColumns; column++) {
                if(Matrix[row][column] == 0) {
                    Matrix[row][0] = 0;
                   break;
                }
            }
        }
    }

    /*
     *Function "setFirstColumnElements" is used to set first column elements to zero if any of the elements in that corresponding row is zero.
     */
    static void setFirstColumnElements(){
        for (column = 1; column < numOfColumns; column++) {
            for (row = 1; row < numOfRows; row++) {
                if(Matrix[row][column] == 0) {
                   Matrix[0][column] = 0;
                    break;
                }
            }
        }
    }

    /*
     *Function "setRowElementsToZero" set all row elements that contains at least one element as zero to zeros.
     */
    static void setRowElementsToZero() {
        for (row = 1; row < numOfRows; row++) {
            if (Matrix[row][0] == 0) {
                for (column = 1; column < numOfColumns; column++) {
                    Matrix[row][column] = 0;
                }
            }
        }
    }

    /*
     *Function "setColumnElementsToZero" set all column elements that contains at least one element as zero to zeros.
     */
    static void setColumnElementsToZero() {
        for (column = 1; column < numOfColumns; column++) {
            if (Matrix[0][column] == 0) {
                for (row = 1; row < numOfRows; row++) {
                    Matrix[row][column] = 0;
                }
            }
        }
    }

    /*
     *Function "modifyFirstRowElements" set first row elements to zero if rowFlag is 1.
     */
    static void modifyFirstRowElements(){
        if(rowFlag == 1){
            for(column =0;column < numOfColumns; column++){
                Matrix[0][column] = 0;
            }
        }
    }

    /*
     *Function "modifyFirstColumnElements" set first column elements to zero if columnFlag is 1.
     */
    static void modifyFirstColumnElements(){
        if(columnFlag == 1){
            for(row =0;row < numOfRows;row++){
                Matrix[row][0] = 0;
            }
        }
    }

    /*
     *Function "printModifiedMatrix" prints modified matrix as output.
     */
    static void printModifiedMatrix() {
        log.info("-:The Final Matrix is as follows:-");
        for (row = 0; row < numOfRows; row++) {
            for (column = 0; column < numOfColumns; column++) {
                System.out.print(Matrix[row][column]+" ");
            }
            System.out.println();
        }
    }

}


class InvalidInputSizeException extends Exception{
    private static final Logger log = Logger.getLogger(InvalidInputSizeException.class.getName());
    InvalidInputSizeException()
    {
        log.warning("Size of Matrix should be greater than zero");
    }
}

//Auxiliary Space Complexity = O[1]
//Time Complexity = o[n^2]
//No Extra Buffer is used which affects space complexity.