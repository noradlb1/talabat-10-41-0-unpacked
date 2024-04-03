package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Lab extends ColorSpace {
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float D = 0.20689656f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab$Companion;", "", "()V", "A", "", "B", "C", "D", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Lab(@NotNull String str, int i11) {
        super(str, ColorModel.Companion.m3314getLabxdoWZVw(), i11, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        float f11;
        float f12;
        float f13;
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(fArr2, "v");
        float f14 = fArr2[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f15 = f14 / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f16 = fArr2[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f17 = fArr2[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        if (f15 > A) {
            f11 = (float) Math.pow((double) f15, (double) 0.33333334f);
        } else {
            f11 = (f15 * B) + C;
        }
        if (f16 > A) {
            f12 = (float) Math.pow((double) f16, (double) 0.33333334f);
        } else {
            f12 = (f16 * B) + C;
        }
        if (f17 > A) {
            f13 = (float) Math.pow((double) f17, (double) 0.33333334f);
        } else {
            f13 = (f17 * B) + C;
        }
        fArr2[0] = RangesKt___RangesKt.coerceIn((116.0f * f12) - 16.0f, 0.0f, 100.0f);
        fArr2[1] = RangesKt___RangesKt.coerceIn((f11 - f12) * 500.0f, -128.0f, 128.0f);
        fArr2[2] = RangesKt___RangesKt.coerceIn((f12 - f13) * 200.0f, -128.0f, 128.0f);
        return fArr2;
    }

    public float getMaxValue(int i11) {
        return i11 == 0 ? 100.0f : 128.0f;
    }

    public float getMinValue(int i11) {
        return i11 == 0 ? 0.0f : -128.0f;
    }

    public boolean isWideGamut() {
        return true;
    }

    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        float f11;
        float f12;
        float f13;
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = RangesKt___RangesKt.coerceIn(fArr[0], 0.0f, 100.0f);
        fArr[1] = RangesKt___RangesKt.coerceIn(fArr[1], -128.0f, 128.0f);
        float coerceIn = RangesKt___RangesKt.coerceIn(fArr[2], -128.0f, 128.0f);
        fArr[2] = coerceIn;
        float f14 = (fArr[0] + 16.0f) / 116.0f;
        float f15 = (fArr[1] * 0.002f) + f14;
        float f16 = f14 - (coerceIn * 0.005f);
        if (f15 > D) {
            f11 = f15 * f15 * f15;
        } else {
            f11 = (f15 - C) * 0.12841855f;
        }
        if (f14 > D) {
            f12 = f14 * f14 * f14;
        } else {
            f12 = (f14 - C) * 0.12841855f;
        }
        if (f16 > D) {
            f13 = f16 * f16 * f16;
        } else {
            f13 = (f16 - C) * 0.12841855f;
        }
        Illuminant illuminant = Illuminant.INSTANCE;
        fArr[0] = f11 * illuminant.getD50Xyz$ui_graphics_release()[0];
        fArr[1] = f12 * illuminant.getD50Xyz$ui_graphics_release()[1];
        fArr[2] = f13 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return fArr;
    }
}
