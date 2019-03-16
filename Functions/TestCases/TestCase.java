import functions.MatrixModification;
import org.junit.Test;
import org.junit.Assert;

public class TestCase {
    @Test
    public void testcase1(){
        MatrixModification test=new MatrixModification();
        int[][] Matrix={{0,0,1,2},{3,4,5,6},{1,2,3,0}};
        test.setMatrix(Matrix);
        int[][] expectedOutput={{0,0,0,0},{0,0,5,0},{0,0,0,0}};
        test.modifyMatrix();
        int[][] actualOutput=test.getMatrix() ;
         Assert.assertArrayEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase2(){
        MatrixModification test=new MatrixModification();
        int[][] inputMatrix={{1,0,3},{2,6,1},{7,0,1}};
        test.setMatrix(inputMatrix);
        int[][] expectedOutput={{0,0,0},{2,0,1},{0,0,0}};
        test.modifyMatrix();
        int[][] actualOutput=test.getMatrix() ;
        Assert.assertEquals(actualOutput,expectedOutput);
    }

    @Test
    public void testcase3(){
        MatrixModification test=new MatrixModification();
        int[][] inputMatrix={{0,1,2,3,4,5}};
        test.setMatrix(inputMatrix);
        int[][] expectedOutput={{0,0,0,0,0,0}};
        test.modifyMatrix();
        int[][] actualOutput=test.getMatrix() ;
        Assert.assertEquals(actualOutput,expectedOutput);
    }

    @Test
    public void testcase4(){
        MatrixModification test=new MatrixModification();
        int[][] inputMatrix={{0},{1},{2},{3},{4},{5}};
        test.setMatrix(inputMatrix);
        int[][] expectedOutput={{0},{0},{0},{0},{0},{0}};
        test.modifyMatrix();
        int[][] actualOutput=test.getMatrix() ;
        Assert.assertEquals(actualOutput,expectedOutput);
    }
    @Test
    public void testcase5(){
        MatrixModification test=new MatrixModification();
        int[][] inputMatrix={{1,2,3},{4,5,6},{7,8,9}};
        test.setMatrix(inputMatrix);
        int[][] expectedOutput={{1,2,3},{4,5,6},{7,8,9}};
        test.modifyMatrix();
        int[][] actualOutput=test.getMatrix() ;
        Assert.assertEquals(actualOutput,expectedOutput);
    }

}
