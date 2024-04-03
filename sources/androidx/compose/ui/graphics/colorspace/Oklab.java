package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Oklab extends ColorSpace {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final float[] InverseM1;
    @NotNull
    private static final float[] InverseM2;
    @NotNull
    private static final float[] M1;
    @NotNull
    private static final float[] M2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab$Companion;", "", "()V", "InverseM1", "", "InverseM2", "M1", "M2", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        float[] transform$ui_graphics_release = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] mul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        M1 = mul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(mul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Oklab(@NotNull String str, int i11) {
        super(str, ColorModel.Companion.m3314getLabxdoWZVw(), i11, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        ColorSpaceKt.mul3x3Float3(M1, fArr);
        double d11 = (double) 0.33333334f;
        fArr[0] = Math.signum(fArr[0]) * ((float) Math.pow((double) Math.abs(fArr[0]), d11));
        fArr[1] = Math.signum(fArr[1]) * ((float) Math.pow((double) Math.abs(fArr[1]), d11));
        fArr[2] = Math.signum(fArr[2]) * ((float) Math.pow((double) Math.abs(fArr[2]), d11));
        ColorSpaceKt.mul3x3Float3(M2, fArr);
        return fArr;
    }

    public float getMaxValue(int i11) {
        return i11 == 0 ? 1.0f : 0.5f;
    }

    public float getMinValue(int i11) {
        return i11 == 0 ? 0.0f : -0.5f;
    }

    public boolean isWideGamut() {
        return true;
    }

    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = RangesKt___RangesKt.coerceIn(fArr[0], 0.0f, 1.0f);
        fArr[1] = RangesKt___RangesKt.coerceIn(fArr[1], -0.5f, 0.5f);
        fArr[2] = RangesKt___RangesKt.coerceIn(fArr[2], -0.5f, 0.5f);
        ColorSpaceKt.mul3x3Float3(InverseM2, fArr);
        float f11 = fArr[0];
        fArr[0] = f11 * f11 * f11;
        float f12 = fArr[1];
        fArr[1] = f12 * f12 * f12;
        float f13 = fArr[2];
        fArr[2] = f13 * f13 * f13;
        ColorSpaceKt.mul3x3Float3(InverseM1, fArr);
        return fArr;
    }
}
