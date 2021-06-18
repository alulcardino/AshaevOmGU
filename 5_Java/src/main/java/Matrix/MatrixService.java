import java.util.Arrays;

public class MatrixService {
    public static void arrangeMatrices(IMatrix... arrMtx) {
        Arrays.sort(arrMtx, new MtxComparator());
    }
}