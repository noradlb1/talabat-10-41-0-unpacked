package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u000b*\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "isIdentity", "", "isIdentity-58bKbWc", "([F)Z", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MatrixKt {
    /* access modifiers changed from: private */
    /* renamed from: dot-p89u6pk  reason: not valid java name */
    public static final float m3123dotp89u6pk(float[] fArr, int i11, float[] fArr2, int i12) {
        int i13 = i11 * 4;
        return (fArr[i13 + 0] * fArr2[0 + i12]) + (fArr[i13 + 1] * fArr2[4 + i12]) + (fArr[i13 + 2] * fArr2[8 + i12]) + (fArr[i13 + 3] * fArr2[12 + i12]);
    }

    /* renamed from: isIdentity-58bKbWc  reason: not valid java name */
    public static final boolean m3124isIdentity58bKbWc(@NotNull float[] fArr) {
        float f11;
        boolean z11;
        Intrinsics.checkNotNullParameter(fArr, "$this$isIdentity");
        for (int i11 = 0; i11 < 4; i11++) {
            for (int i12 = 0; i12 < 4; i12++) {
                if (i11 == i12) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.0f;
                }
                if (fArr[(i11 * 4) + i12] == f11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    return false;
                }
            }
        }
        return true;
    }
}
