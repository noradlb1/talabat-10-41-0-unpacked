package androidx.compose.ui.input.pointer.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0006\u0010\u000f\u001a\u00020\u0007J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0000H\u0002R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/pointer/util/Vector;", "", "length", "", "(I)V", "elements", "", "", "getElements", "()[Ljava/lang/Float;", "[Ljava/lang/Float;", "getLength", "()I", "get", "i", "norm", "set", "", "value", "times", "a", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class Vector {
    @NotNull
    private final Float[] elements;
    private final int length;

    public Vector(int i11) {
        this.length = i11;
        Float[] fArr = new Float[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            fArr[i12] = Float.valueOf(0.0f);
        }
        this.elements = fArr;
    }

    public final float get(int i11) {
        return this.elements[i11].floatValue();
    }

    @NotNull
    public final Float[] getElements() {
        return this.elements;
    }

    public final int getLength() {
        return this.length;
    }

    public final float norm() {
        return (float) Math.sqrt((double) times(this));
    }

    public final void set(int i11, float f11) {
        this.elements[i11] = Float.valueOf(f11);
    }

    public final float times(@NotNull Vector vector) {
        Intrinsics.checkNotNullParameter(vector, "a");
        int i11 = this.length;
        float f11 = 0.0f;
        for (int i12 = 0; i12 < i11; i12++) {
            f11 += get(i12) * vector.get(i12);
        }
        return f11;
    }
}
