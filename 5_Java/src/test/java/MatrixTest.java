import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    Matrix zero = new Matrix(new double[][]{{0, 0}, {0, 0}});
    Matrix std = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    DiagMatrix diag = new DiagMatrix(1, 2, 3, 4, 5);
    UpTriangleMatrix triangle = new UpTriangleMatrix(new double[][]{{1, 2, 3}, {0, 4, 5}, {0, 0, 6}});


    // --- sizeTest --- ///

    @Test
    public void sizeStd() {
        assertEquals(3, std.size());
    }

    @Test
    public void sizeDiag() {
        assertEquals(5, diag.size());
    }

    @Test
    public void sizeTriangle() {
        assertEquals(3, triangle.size());
    }


    // --- getElemTest --- //

    @Test
    public void getElemStd() {
        assertEquals(3, std.getElem(0, 2), 1E-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getElemStdFail() {
        std.getElem(0, 3);
    }


    @Test
    public void getElemDiagOn() {
        assertEquals(3, diag.getElem(2, 2), 1E-9);
    }

    @Test
    public void getElemDiagOut() {
        assertEquals(0, diag.getElem(2, 1), 1E-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getElemDiagFail() {
        diag.getElem(0, 5);
    }


    @Test
    public void getElemTriangleOn() {
        assertEquals(3, triangle.getElem(0, 2), 1E-9);
    }

    @Test
    public void getElemTriangleOut() {
        assertEquals(0, triangle.getElem(2, 1), 1E-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getElemTriangleFail() {
        triangle.getElem(0, 3);
    }


    // --- setElemTest --- //

    @Test
    public void setElemStd() {
        std.setElem(1, 2, 666);
        assertEquals(666, std.getElem(1, 2), 1E-9);
        std.setElem(1, 2, 6);
    }

    @Test
    public void setElemDiag() {
        diag.setElem(4, 4, 666);
        assertEquals(666, diag.getElem(4, 4), 1E-9);
        diag.setElem(4, 4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setElemDiagFail() {
        diag.setElem(2, 0, 666);
    }

    @Test
    public void setElemTriangle() {
        triangle.setElem(0, 2, 666);
        assertEquals(666, triangle.getElem(0, 2), 1E-9);
        triangle.setElem(0, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setElemTriangleFail() {
        triangle.setElem(1, 0, 666);
    }


    // --- determinantTest --- //

    @Test
    public void determinantStd() {
        assertEquals(0, std.determinant(), 1E-9);
        assertEquals(0, zero.determinant(), 1E-9);
    }

    @Test
    public void determinantDiag() {
        assertEquals(120, diag.determinant(), 1E-9);
    }

    @Test
    public void determinantTriangle() {
        assertEquals(24, triangle.determinant(), 1E-9);
    }


    // --- MatrixServiceTest --- //

    @Test
    public void arrangeMatricesTest() {
        IMatrix[] sortedMtx = new IMatrix[]{zero, std, diag, triangle};
        MatrixService.arrangeMatrices(sortedMtx);
        assertArrayEquals(new IMatrix[]{std, zero, triangle, diag}, sortedMtx);
    }
}