package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.Connector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0000\u001a\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020!H\u0007\u001a+\u0010\"\u001a\u00020#*\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u001e2\b\b\u0002\u0010%\u001a\u00020&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"absRcpResponse", "", "x", "a", "b", "c", "d", "g", "absResponse", "chromaticAdaptation", "", "matrix", "srcWhitePoint", "dstWhitePoint", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Diag", "mul3x3Float3", "rcpResponse", "e", "f", "response", "adapt", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "whitePoint", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "connect", "Landroidx/compose/ui/graphics/colorspace/Connector;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "connect-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ColorSpaceKt {
    public static final double absRcpResponse(double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d11;
        return Math.copySign(rcpResponse(d17 < 0.0d ? -d17 : d17, d12, d13, d14, d15, d16), d17);
    }

    public static final double absResponse(double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d11;
        return Math.copySign(response(d17 < 0.0d ? -d17 : d17, d12, d13, d14, d15, d16), d17);
    }

    @NotNull
    @JvmOverloads
    public static final ColorSpace adapt(@NotNull ColorSpace colorSpace, @NotNull WhitePoint whitePoint) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
        return adapt$default(colorSpace, whitePoint, (Adaptation) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final ColorSpace adapt(@NotNull ColorSpace colorSpace, @NotNull WhitePoint whitePoint, @NotNull Adaptation adaptation) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
        Intrinsics.checkNotNullParameter(adaptation, "adaptation");
        if (!ColorModel.m3308equalsimpl0(colorSpace.m3317getModelxdoWZVw(), ColorModel.Companion.m3315getRgbxdoWZVw())) {
            return colorSpace;
        }
        Rgb rgb = (Rgb) colorSpace;
        if (compare(rgb.getWhitePoint(), whitePoint)) {
            return colorSpace;
        }
        return new Rgb(rgb, mul3x3(chromaticAdaptation(adaptation.getTransform$ui_graphics_release(), rgb.getWhitePoint().toXyz$ui_graphics_release(), whitePoint.toXyz$ui_graphics_release()), rgb.getTransform$ui_graphics_release()), whitePoint);
    }

    public static /* synthetic */ ColorSpace adapt$default(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            adaptation = Adaptation.Companion.getBradford();
        }
        return adapt(colorSpace, whitePoint, adaptation);
    }

    @NotNull
    public static final float[] chromaticAdaptation(@NotNull float[] fArr, @NotNull float[] fArr2, @NotNull float[] fArr3) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Intrinsics.checkNotNullParameter(fArr2, "srcWhitePoint");
        Intrinsics.checkNotNullParameter(fArr3, "dstWhitePoint");
        float[] mul3x3Float3 = mul3x3Float3(fArr, fArr2);
        float[] mul3x3Float32 = mul3x3Float3(fArr, fArr3);
        return mul3x3(inverse3x3(fArr), mul3x3Diag(new float[]{mul3x3Float32[0] / mul3x3Float3[0], mul3x3Float32[1] / mul3x3Float3[1], mul3x3Float32[2] / mul3x3Float3[2]}, fArr));
    }

    public static final boolean compare(@NotNull TransferParameters transferParameters, @Nullable TransferParameters transferParameters2) {
        Intrinsics.checkNotNullParameter(transferParameters, "a");
        return transferParameters2 != null && Math.abs(transferParameters.getA() - transferParameters2.getA()) < 0.001d && Math.abs(transferParameters.getB() - transferParameters2.getB()) < 0.001d && Math.abs(transferParameters.getC() - transferParameters2.getC()) < 0.001d && Math.abs(transferParameters.getD() - transferParameters2.getD()) < 0.002d && Math.abs(transferParameters.getE() - transferParameters2.getE()) < 0.001d && Math.abs(transferParameters.getF() - transferParameters2.getF()) < 0.001d && Math.abs(transferParameters.getGamma() - transferParameters2.getGamma()) < 0.001d;
    }

    @NotNull
    /* renamed from: connect-YBCOT_4  reason: not valid java name */
    public static final Connector m3318connectYBCOT_4(@NotNull ColorSpace colorSpace, @NotNull ColorSpace colorSpace2, int i11) {
        Intrinsics.checkNotNullParameter(colorSpace, "$this$connect");
        Intrinsics.checkNotNullParameter(colorSpace2, "destination");
        if (colorSpace == colorSpace2) {
            return Connector.Companion.identity$ui_graphics_release(colorSpace);
        }
        long r02 = colorSpace.m3317getModelxdoWZVw();
        ColorModel.Companion companion = ColorModel.Companion;
        if (!ColorModel.m3308equalsimpl0(r02, companion.m3315getRgbxdoWZVw()) || !ColorModel.m3308equalsimpl0(colorSpace2.m3317getModelxdoWZVw(), companion.m3315getRgbxdoWZVw())) {
            return new Connector(colorSpace, colorSpace2, i11, (DefaultConstructorMarker) null);
        }
        return new Connector.RgbConnector((Rgb) colorSpace, (Rgb) colorSpace2, i11, (DefaultConstructorMarker) null);
    }

    /* renamed from: connect-YBCOT_4$default  reason: not valid java name */
    public static /* synthetic */ Connector m3319connectYBCOT_4$default(ColorSpace colorSpace, ColorSpace colorSpace2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            colorSpace2 = ColorSpaces.INSTANCE.getSrgb();
        }
        if ((i12 & 2) != 0) {
            i11 = RenderIntent.Companion.m3332getPerceptualuksYyKA();
        }
        return m3318connectYBCOT_4(colorSpace, colorSpace2, i11);
    }

    @NotNull
    public static final float[] inverse3x3(@NotNull float[] fArr) {
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(fArr2, "m");
        float f11 = fArr2[0];
        float f12 = fArr2[3];
        float f13 = fArr2[6];
        float f14 = fArr2[1];
        float f15 = fArr2[4];
        float f16 = fArr2[7];
        float f17 = fArr2[2];
        float f18 = fArr2[5];
        float f19 = fArr2[8];
        float f21 = (f15 * f19) - (f16 * f18);
        float f22 = (f16 * f17) - (f14 * f19);
        float f23 = (f14 * f18) - (f15 * f17);
        float f24 = (f11 * f21) + (f12 * f22) + (f13 * f23);
        float[] fArr3 = new float[fArr2.length];
        fArr3[0] = f21 / f24;
        fArr3[1] = f22 / f24;
        fArr3[2] = f23 / f24;
        fArr3[3] = ((f13 * f18) - (f12 * f19)) / f24;
        fArr3[4] = ((f19 * f11) - (f13 * f17)) / f24;
        fArr3[5] = ((f17 * f12) - (f18 * f11)) / f24;
        fArr3[6] = ((f12 * f16) - (f13 * f15)) / f24;
        fArr3[7] = ((f13 * f14) - (f16 * f11)) / f24;
        fArr3[8] = ((f11 * f15) - (f12 * f14)) / f24;
        return fArr3;
    }

    @NotNull
    public static final float[] mul3x3(@NotNull float[] fArr, @NotNull float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        Intrinsics.checkNotNullParameter(fArr3, "lhs");
        Intrinsics.checkNotNullParameter(fArr4, "rhs");
        float f11 = fArr3[3];
        float f12 = fArr4[1];
        float f13 = fArr3[6];
        float f14 = fArr4[2];
        float f15 = fArr3[1];
        float f16 = fArr4[0];
        float f17 = fArr3[4];
        float f18 = fArr3[7];
        float f19 = fArr3[5];
        float f21 = fArr3[8];
        float f22 = fArr3[0];
        float f23 = fArr4[4];
        float f24 = (fArr4[3] * f22) + (f11 * f23);
        float f25 = fArr4[5];
        float f26 = fArr3[1];
        float f27 = fArr4[3];
        float f28 = fArr3[2];
        float f29 = f22 * fArr4[6];
        float f31 = fArr3[3];
        float f32 = fArr4[7];
        float f33 = f29 + (f31 * f32);
        float f34 = fArr4[8];
        float f35 = fArr4[6];
        return new float[]{(fArr3[0] * fArr4[0]) + (f11 * f12) + (f13 * f14), (f15 * f16) + (f12 * f17) + (f18 * f14), (fArr3[2] * f16) + (fArr4[1] * f19) + (f14 * f21), f24 + (f13 * f25), (f26 * f27) + (f17 * f23) + (f18 * f25), (f27 * f28) + (f19 * fArr4[4]) + (f25 * f21), f33 + (f13 * f34), (f26 * f35) + (fArr3[4] * f32) + (f18 * f34), (f28 * f35) + (fArr3[5] * fArr4[7]) + (f21 * f34)};
    }

    @NotNull
    public static final float[] mul3x3Diag(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "lhs");
        Intrinsics.checkNotNullParameter(fArr2, "rhs");
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        return new float[]{fArr[0] * fArr2[0], fArr[1] * fArr2[1], fArr[2] * fArr2[2], fArr2[3] * f11, fArr2[4] * f12, fArr2[5] * f13, f11 * fArr2[6], f12 * fArr2[7], f13 * fArr2[8]};
    }

    @NotNull
    public static final float[] mul3x3Float3(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "lhs");
        Intrinsics.checkNotNullParameter(fArr2, "rhs");
        float f11 = fArr2[0];
        float f12 = fArr2[1];
        float f13 = fArr2[2];
        fArr2[0] = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f13);
        fArr2[1] = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f13);
        fArr2[2] = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f13);
        return fArr2;
    }

    public static final double rcpResponse(double d11, double d12, double d13, double d14, double d15, double d16) {
        return d11 >= d15 * d14 ? (Math.pow(d11, 1.0d / d16) - d13) / d12 : d11 / d14;
    }

    public static final double response(double d11, double d12, double d13, double d14, double d15, double d16) {
        return d11 >= d15 ? Math.pow((d12 * d11) + d13, d16) : d11 * d14;
    }

    public static final double rcpResponse(double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        return d11 >= d15 * d14 ? (Math.pow(d11 - d16, 1.0d / d18) - d13) / d12 : (d11 - d17) / d14;
    }

    public static final double response(double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        return d11 >= d15 ? Math.pow((d12 * d11) + d13, d18) + d16 : (d14 * d11) + d17;
    }

    public static final boolean compare(@NotNull WhitePoint whitePoint, @NotNull WhitePoint whitePoint2) {
        Intrinsics.checkNotNullParameter(whitePoint, "a");
        Intrinsics.checkNotNullParameter(whitePoint2, "b");
        if (whitePoint == whitePoint2) {
            return true;
        }
        return Math.abs(whitePoint.getX() - whitePoint2.getX()) < 0.001f && Math.abs(whitePoint.getY() - whitePoint2.getY()) < 0.001f;
    }

    public static final boolean compare(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "a");
        Intrinsics.checkNotNullParameter(fArr2, "b");
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (Float.compare(fArr[i11], fArr2[i11]) != 0 && Math.abs(fArr[i11] - fArr2[i11]) > 0.001f) {
                return false;
            }
        }
        return true;
    }
}
