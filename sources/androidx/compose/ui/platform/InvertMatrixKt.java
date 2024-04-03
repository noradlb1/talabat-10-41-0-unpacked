package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InvertMatrixKt {
    /* renamed from: invertTo-JiSxe2E  reason: not valid java name */
    public static final boolean m4841invertToJiSxe2E(@NotNull float[] fArr, @NotNull float[] fArr2) {
        boolean z11;
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        Intrinsics.checkNotNullParameter(fArr3, "$this$invertTo");
        Intrinsics.checkNotNullParameter(fArr4, "other");
        float f11 = fArr3[0];
        float f12 = fArr3[1];
        float f13 = fArr3[2];
        float f14 = fArr3[3];
        float f15 = fArr3[4];
        float f16 = fArr3[5];
        float f17 = fArr3[6];
        float f18 = fArr3[7];
        float f19 = fArr3[8];
        float f21 = fArr3[9];
        float f22 = fArr3[10];
        float f23 = fArr3[11];
        float f24 = fArr3[12];
        float f25 = fArr3[13];
        float f26 = fArr3[14];
        float f27 = fArr3[15];
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (f11 * f17) - (f13 * f15);
        float f31 = (f11 * f18) - (f14 * f15);
        float f32 = (f12 * f17) - (f13 * f16);
        float f33 = (f12 * f18) - (f14 * f16);
        float f34 = (f13 * f18) - (f14 * f17);
        float f35 = (f19 * f25) - (f21 * f24);
        float f36 = (f19 * f26) - (f22 * f24);
        float f37 = (f19 * f27) - (f23 * f24);
        float f38 = (f21 * f26) - (f22 * f25);
        float f39 = (f21 * f27) - (f23 * f25);
        float f41 = (f22 * f27) - (f23 * f26);
        float f42 = (((((f28 * f41) - (f29 * f39)) + (f31 * f38)) + (f32 * f37)) - (f33 * f36)) + (f34 * f35);
        if (f42 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        float f43 = 1.0f / f42;
        fArr4[0] = (((f16 * f41) - (f17 * f39)) + (f18 * f38)) * f43;
        fArr4[1] = ((((-f12) * f41) + (f13 * f39)) - (f14 * f38)) * f43;
        fArr4[2] = (((f25 * f34) - (f26 * f33)) + (f27 * f32)) * f43;
        fArr4[3] = ((((-f21) * f34) + (f22 * f33)) - (f23 * f32)) * f43;
        float f44 = -f15;
        fArr4[4] = (((f44 * f41) + (f17 * f37)) - (f18 * f36)) * f43;
        fArr4[5] = (((f41 * f11) - (f13 * f37)) + (f14 * f36)) * f43;
        float f45 = -f24;
        fArr4[6] = (((f45 * f34) + (f26 * f31)) - (f27 * f29)) * f43;
        fArr4[7] = (((f34 * f19) - (f22 * f31)) + (f23 * f29)) * f43;
        fArr4[8] = (((f15 * f39) - (f16 * f37)) + (f18 * f35)) * f43;
        fArr4[9] = ((((-f11) * f39) + (f37 * f12)) - (f14 * f35)) * f43;
        fArr4[10] = (((f24 * f33) - (f25 * f31)) + (f27 * f28)) * f43;
        fArr4[11] = ((((-f19) * f33) + (f31 * f21)) - (f23 * f28)) * f43;
        fArr4[12] = (((f44 * f38) + (f16 * f36)) - (f17 * f35)) * f43;
        fArr4[13] = (((f11 * f38) - (f12 * f36)) + (f13 * f35)) * f43;
        fArr4[14] = (((f45 * f32) + (f25 * f29)) - (f26 * f28)) * f43;
        fArr4[15] = (((f19 * f32) - (f21 * f29)) + (f22 * f28)) * f43;
        return true;
    }
}
