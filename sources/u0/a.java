package u0;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    @Stable
    public static int a(Density density, long j11) {
        return MathKt__MathJVMKt.roundToInt(density.m5446toPxR2X_6o(j11));
    }

    @Stable
    public static int b(Density density, float f11) {
        float r02 = density.m5447toPx0680j_4(f11);
        if (Float.isInfinite(r02)) {
            return Integer.MAX_VALUE;
        }
        return MathKt__MathJVMKt.roundToInt(r02);
    }

    @Stable
    public static float c(Density density, long j11) {
        if (TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j11), TextUnitType.Companion.m5692getSpUIouoOA())) {
            return Dp.m5478constructorimpl(TextUnit.m5659getValueimpl(j11) * density.getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Stable
    public static float d(Density density, float f11) {
        return Dp.m5478constructorimpl(f11 / density.getDensity());
    }

    @Stable
    public static float e(Density density, int i11) {
        return Dp.m5478constructorimpl(((float) i11) / density.getDensity());
    }

    @Stable
    public static long f(Density density, long j11) {
        boolean z11;
        if (j11 != Size.Companion.m2753getUnspecifiedNHjbRc()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return DpKt.m5500DpSizeYgX7TsA(density.m5443toDpu2uoSUM(Size.m2745getWidthimpl(j11)), density.m5443toDpu2uoSUM(Size.m2742getHeightimpl(j11)));
        }
        return DpSize.Companion.m5585getUnspecifiedMYxV2XQ();
    }

    @Stable
    public static float g(Density density, long j11) {
        if (TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j11), TextUnitType.Companion.m5692getSpUIouoOA())) {
            return TextUnit.m5659getValueimpl(j11) * density.getFontScale() * density.getDensity();
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Stable
    public static float h(Density density, float f11) {
        return f11 * density.getDensity();
    }

    @NotNull
    @Stable
    public static Rect i(Density density, @NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return new Rect(density.m5447toPx0680j_4(dpRect.m5561getLeftD9Ej5fM()), density.m5447toPx0680j_4(dpRect.m5563getTopD9Ej5fM()), density.m5447toPx0680j_4(dpRect.m5562getRightD9Ej5fM()), density.m5447toPx0680j_4(dpRect.m5560getBottomD9Ej5fM()));
    }

    @Stable
    public static long j(Density density, long j11) {
        boolean z11;
        if (j11 != DpSize.Companion.m5585getUnspecifiedMYxV2XQ()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return SizeKt.Size(density.m5447toPx0680j_4(DpSize.m5576getWidthD9Ej5fM(j11)), density.m5447toPx0680j_4(DpSize.m5574getHeightD9Ej5fM(j11)));
        }
        return Size.Companion.m2753getUnspecifiedNHjbRc();
    }

    @Stable
    public static long k(Density density, float f11) {
        return TextUnitKt.getSp(f11 / density.getFontScale());
    }

    @Stable
    public static long l(Density density, float f11) {
        return TextUnitKt.getSp(f11 / (density.getFontScale() * density.getDensity()));
    }

    @Stable
    public static long m(Density density, int i11) {
        return TextUnitKt.getSp(((float) i11) / (density.getFontScale() * density.getDensity()));
    }
}
