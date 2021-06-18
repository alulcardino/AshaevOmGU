import org.jetbrains.annotations.NotNull;
import java.util.Comparator;

public class MtxComparator implements Comparator<IMatrix> {

    public int compare(@NotNull IMatrix m1, @NotNull IMatrix m2) {
        return Double.compare(m1.determinant(), m2.determinant());
    }
}