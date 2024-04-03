package androidx.compose.ui.input.pointer.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0003J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/util/Matrix;", "", "rows", "", "cols", "(II)V", "elements", "", "Landroidx/compose/ui/input/pointer/util/Vector;", "[Landroidx/compose/ui/input/pointer/util/Vector;", "get", "", "row", "col", "getRow", "set", "", "value", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class Matrix {
    @NotNull
    private final Vector[] elements;

    public Matrix(int i11, int i12) {
        Vector[] vectorArr = new Vector[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            vectorArr[i13] = new Vector(i12);
        }
        this.elements = vectorArr;
    }

    public final float get(int i11, int i12) {
        return this.elements[i11].get(i12);
    }

    @NotNull
    public final Vector getRow(int i11) {
        return this.elements[i11];
    }

    public final void set(int i11, int i12, float f11) {
        this.elements[i11].set(i12, f11);
    }
}
