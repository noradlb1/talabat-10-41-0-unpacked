package s;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;

public final /* synthetic */ class c {
    @Stable
    public static float a(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j11) {
        if (TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j11), TextUnitType.Companion.m5692getSpUIouoOA())) {
            return Dp.m5478constructorimpl(TextUnit.m5659getValueimpl(j11) * lazyLayoutMeasureScope.getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Stable
    public static float b(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f11) {
        return Dp.m5478constructorimpl(f11 / lazyLayoutMeasureScope.getDensity());
    }

    @Stable
    public static float c(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i11) {
        return Dp.m5478constructorimpl(((float) i11) / lazyLayoutMeasureScope.getDensity());
    }

    @Stable
    public static long d(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j11) {
        boolean z11;
        if (j11 != Size.Companion.m2753getUnspecifiedNHjbRc()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return DpKt.m5500DpSizeYgX7TsA(lazyLayoutMeasureScope.m740toDpu2uoSUM(Size.m2745getWidthimpl(j11)), lazyLayoutMeasureScope.m740toDpu2uoSUM(Size.m2742getHeightimpl(j11)));
        }
        return DpSize.Companion.m5585getUnspecifiedMYxV2XQ();
    }

    @Stable
    public static long e(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j11) {
        boolean z11;
        if (j11 != DpSize.Companion.m5585getUnspecifiedMYxV2XQ()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return SizeKt.Size(lazyLayoutMeasureScope.m5447toPx0680j_4(DpSize.m5576getWidthD9Ej5fM(j11)), lazyLayoutMeasureScope.m5447toPx0680j_4(DpSize.m5574getHeightD9Ej5fM(j11)));
        }
        return Size.Companion.m2753getUnspecifiedNHjbRc();
    }

    @Stable
    public static long f(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f11) {
        return TextUnitKt.getSp(f11 / lazyLayoutMeasureScope.getFontScale());
    }

    @Stable
    public static long g(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f11) {
        return TextUnitKt.getSp(f11 / (lazyLayoutMeasureScope.getFontScale() * lazyLayoutMeasureScope.getDensity()));
    }

    @Stable
    public static long h(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i11) {
        return TextUnitKt.getSp(((float) i11) / (lazyLayoutMeasureScope.getFontScale() * lazyLayoutMeasureScope.getDensity()));
    }
}
