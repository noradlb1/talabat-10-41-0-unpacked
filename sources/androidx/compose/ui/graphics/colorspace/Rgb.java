package androidx.compose.ui.graphics.colorspace;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u0000 H2\u00020\u0001:\u0001HB?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nBW\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B/\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001aB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001bB?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cB\u001f\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u001fBs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010!J\u0013\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u001e\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0016J\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0006\u0010C\u001a\u00020\u0005J\u000e\u0010C\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010D\u001a\u00020\u0005J\u000e\u0010D\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010E\u001a\u00020\u0017H\u0016J\u001e\u0010F\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010+R\u0014\u0010,\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0013\u0010 \u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u001e\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006I"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", "other", "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Rgb extends ColorSpace {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final Function1<Double, Double> DoubleIdentity = Rgb$Companion$DoubleIdentity$1.INSTANCE;
    @NotNull
    private final Function1<Double, Double> eotf;
    @NotNull
    private final Function1<Double, Double> eotfOrig;
    @NotNull
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    /* access modifiers changed from: private */
    public final float max;
    /* access modifiers changed from: private */
    public final float min;
    @NotNull
    private final Function1<Double, Double> oetf;
    @NotNull
    private final Function1<Double, Double> oetfOrig;
    @NotNull
    private final float[] primaries;
    @Nullable
    private final TransferParameters transferParameters;
    @NotNull
    private final float[] transform;
    @NotNull
    private final WhitePoint whitePoint;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002JX\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Lkotlin/Function1;", "", "area", "", "primaries", "", "compare", "", "point", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float area(float[] fArr) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            float f17 = ((((((f11 * f14) + (f12 * f15)) + (f13 * f16)) - (f14 * f15)) - (f12 * f13)) - (f11 * f16)) * 0.5f;
            if (f17 < 0.0f) {
                return -f17;
            }
            return f17;
        }

        private final boolean compare(double d11, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
            if (Math.abs(function1.invoke(Double.valueOf(d11)).doubleValue() - function12.invoke(Double.valueOf(d11)).doubleValue()) <= 0.001d) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] fArr) {
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 1.0f, 1.0f});
            float f11 = mul3x3Float3[0];
            float f12 = mul3x3Float3[1];
            float f13 = f11 + f12 + mul3x3Float3[2];
            return new WhitePoint(f11 / f13, f12 / f13);
        }

        /* access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] fArr, WhitePoint whitePoint) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            float x11 = whitePoint.getX();
            float y11 = whitePoint.getY();
            float f17 = (float) 1;
            float f18 = (f17 - f11) / f12;
            float f19 = f11 / f12;
            float f21 = (f13 / f14) - f19;
            float f22 = (x11 / y11) - f19;
            float f23 = ((f17 - f13) / f14) - f18;
            float f24 = (f15 / f16) - f19;
            float f25 = (((((f17 - x11) / y11) - f18) * f21) - (f22 * f23)) / (((((f17 - f15) / f16) - f18) * f21) - (f23 * f24));
            float f26 = (f22 - (f24 * f25)) / f21;
            float f27 = (1.0f - f26) - f25;
            float f28 = f27 / f12;
            float f29 = f26 / f14;
            float f31 = f25 / f16;
            return new float[]{f28 * f11, f27, f28 * ((1.0f - f11) - f12), f29 * f13, f26, f29 * ((1.0f - f13) - f14), f31 * f15, f25, f31 * ((1.0f - f15) - f16)};
        }

        private final boolean contains(float[] fArr, float[] fArr2) {
            float f11 = fArr[0] - fArr2[0];
            float f12 = fArr[1] - fArr2[1];
            float[] fArr3 = {f11, f12, fArr[2] - fArr2[2], fArr[3] - fArr2[3], fArr[4] - fArr2[4], fArr[5] - fArr2[5]};
            if (cross(f11, f12, fArr2[0] - fArr2[4], fArr2[1] - fArr2[5]) < 0.0f || cross(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) < 0.0f || cross(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) < 0.0f || cross(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) < 0.0f || cross(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) < 0.0f || cross(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) < 0.0f) {
                return false;
            }
            return true;
        }

        private final float cross(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        /* access modifiers changed from: private */
        public final boolean isSrgb(float[] fArr, WhitePoint whitePoint, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12, float f11, float f12, int i11) {
            boolean z11;
            boolean z12;
            if (i11 == 0) {
                return true;
            }
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            if (!ColorSpaceKt.compare(fArr, colorSpaces.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65())) {
                return false;
            }
            if (f11 == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return false;
            }
            if (f12 == 1.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            Rgb srgb = colorSpaces.getSrgb();
            for (double d11 = 0.0d; d11 <= 1.0d; d11 += 0.00392156862745098d) {
                if (!compare(d11, function1, srgb.getOetfOrig$ui_graphics_release()) || !compare(d11, function12, srgb.getEotfOrig$ui_graphics_release())) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final boolean isWideGamut(float[] fArr, float f11, float f12) {
            float area = area(fArr);
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            if ((area / area(colorSpaces.getNtsc1953Primaries$ui_graphics_release()) <= 0.9f || !contains(fArr, colorSpaces.getSrgbPrimaries$ui_graphics_release())) && (f11 >= 0.0f || f12 <= 1.0f)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final float[] xyPrimaries(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f11 = fArr[0];
                float f12 = fArr[1];
                float f13 = f11 + f12 + fArr[2];
                fArr2[0] = f11 / f13;
                fArr2[1] = f12 / f13;
                float f14 = fArr[3];
                float f15 = fArr[4];
                float f16 = f14 + f15 + fArr[5];
                fArr2[2] = f14 / f16;
                fArr2[3] = f15 / f16;
                float f17 = fArr[6];
                float f18 = fArr[7];
                float f19 = f17 + f18 + fArr[8];
                fArr2[4] = f17 / f19;
                fArr2[5] = f18 / f19;
            } else {
                float[] unused = ArraysKt___ArraysJvmKt.copyInto$default(fArr, fArr2, 0, 0, 6, 6, (Object) null);
            }
            return fArr2;
        }

        @NotNull
        public final float[] computePrimaries$ui_graphics_release(@NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "toXYZ");
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 0.0f, 0.0f});
            float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 1.0f, 0.0f});
            float[] mul3x3Float33 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 0.0f, 1.0f});
            float f11 = mul3x3Float3[0];
            float f12 = mul3x3Float3[1];
            float f13 = f11 + f12 + mul3x3Float3[2];
            float f14 = mul3x3Float32[0] + mul3x3Float32[1] + mul3x3Float32[2];
            float f15 = mul3x3Float33[0] + mul3x3Float33[1] + mul3x3Float33[2];
            return new float[]{f11 / f13, f12 / f13, mul3x3Float32[0] / f14, mul3x3Float32[1] / f14, mul3x3Float33[0] / f15, mul3x3Float33[1] / f15};
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull float[] r17, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r18, @org.jetbrains.annotations.Nullable float[] r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r21, float r22, float r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.colorspace.TransferParameters r24, int r25) {
        /*
            r15 = this;
            r6 = r15
            r7 = r17
            r9 = r18
            r8 = r19
            r10 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            java.lang.String r0 = "name"
            r1 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "primaries"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "whitePoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "oetf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "eotf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.compose.ui.graphics.colorspace.ColorModel$Companion r0 = androidx.compose.ui.graphics.colorspace.ColorModel.Companion
            long r2 = r0.m3315getRgbxdoWZVw()
            r5 = 0
            r0 = r15
            r4 = r25
            r0.<init>(r1, r2, r4, r5)
            r6.whitePoint = r9
            r6.min = r12
            r6.max = r13
            r0 = r24
            r6.transferParameters = r0
            r6.oetfOrig = r10
            androidx.compose.ui.graphics.colorspace.Rgb$oetf$1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            r0.<init>(r15)
            r6.oetf = r0
            r6.eotfOrig = r11
            androidx.compose.ui.graphics.colorspace.Rgb$eotf$1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            r0.<init>(r15)
            r6.eotf = r0
            int r0 = r7.length
            r1 = 6
            r2 = 9
            if (r0 == r1) goto L_0x0065
            int r0 = r7.length
            if (r0 != r2) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ"
            r0.<init>(r1)
            throw r0
        L_0x0065:
            int r0 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ba
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r1 = r0.xyPrimaries(r7)
            r6.primaries = r1
            if (r8 != 0) goto L_0x007a
            float[] r2 = r0.computeXYZMatrix(r1, r9)
            r6.transform = r2
            goto L_0x007f
        L_0x007a:
            int r3 = r8.length
            if (r3 != r2) goto L_0x00a2
            r6.transform = r8
        L_0x007f:
            float[] r2 = r6.transform
            float[] r2 = androidx.compose.ui.graphics.colorspace.ColorSpaceKt.inverse3x3(r2)
            r6.inverseTransform = r2
            boolean r2 = r0.isWideGamut(r1, r12, r13)
            r6.isWideGamut = r2
            r7 = r0
            r8 = r1
            r9 = r18
            r10 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r14 = r25
            boolean r0 = r7.isSrgb(r8, r9, r10, r11, r12, r13, r14)
            r6.isSrgb = r0
            return
        L_0x00a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Transform must have 9 entries! Has "
            r1.append(r2)
            int r2 = r8.length
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid range: min="
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = ", max="
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = "; min must be strictly < max"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, float, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Rgb.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass())) || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual((Object) this.whitePoint, (Object) rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual((Object) transferParameters2, (Object) rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) this.oetfOrig, (Object) rgb.oetfOrig)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.eotfOrig, (Object) rgb.eotfOrig);
    }

    @NotNull
    public final float[] fromLinear(float f11, float f12, float f13) {
        return fromLinear(new float[]{f11, f12, f13});
    }

    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, fArr);
        fArr[0] = (float) this.oetf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.oetf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.oetf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return fArr;
    }

    @NotNull
    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    @NotNull
    public final Function1<Double, Double> getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    @NotNull
    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    public float getMaxValue(int i11) {
        return this.max;
    }

    public float getMinValue(int i11) {
        return this.min;
    }

    @NotNull
    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    @NotNull
    public final Function1<Double, Double> getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    @NotNull
    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    @Nullable
    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    @NotNull
    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    @NotNull
    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public int hashCode() {
        boolean z11;
        int i11;
        int i12;
        int hashCode = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f11 = this.min;
        boolean z12 = true;
        int i13 = 0;
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i11 = Float.floatToIntBits(f11);
        } else {
            i11 = 0;
        }
        int i14 = (hashCode + i11) * 31;
        float f12 = this.max;
        if (f12 != 0.0f) {
            z12 = false;
        }
        if (!z12) {
            i12 = Float.floatToIntBits(f12);
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            i13 = transferParameters2.hashCode();
        }
        int i16 = i15 + i13;
        if (this.transferParameters == null) {
            return (((i16 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode();
        }
        return i16;
    }

    public boolean isSrgb() {
        return this.isSrgb;
    }

    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    @NotNull
    public final float[] toLinear(float f11, float f12, float f13) {
        return toLinear(new float[]{f11, f12, f13});
    }

    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = (float) this.eotf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.eotf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.eotf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return ColorSpaceKt.mul3x3Float3(this.transform, fArr);
    }

    @NotNull
    public final float[] fromLinear(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = (float) this.oetf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.oetf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.oetf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return fArr;
    }

    @NotNull
    public final float[] getInverseTransform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "inverseTransform");
        return ArraysKt___ArraysJvmKt.copyInto$default(this.inverseTransform, fArr, 0, 0, 0, 14, (Object) null);
    }

    @NotNull
    public final float[] getPrimaries(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        return ArraysKt___ArraysJvmKt.copyInto$default(this.primaries, fArr, 0, 0, 0, 14, (Object) null);
    }

    @NotNull
    public final float[] getTransform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "transform");
        return ArraysKt___ArraysJvmKt.copyInto$default(this.transform, fArr, 0, 0, 0, 14, (Object) null);
    }

    @NotNull
    public final float[] toLinear(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = (float) this.eotf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.eotf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.eotf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return fArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.NotNull float[] r15, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r16, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r17) {
        /*
            r13 = this;
            r0 = r15
            java.lang.String r1 = "name"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "oetf"
            r7 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "eotf"
            r8 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r1 = Companion
            float[] r4 = r1.computePrimaries$ui_graphics_release(r15)
            androidx.compose.ui.graphics.colorspace.WhitePoint r5 = r1.computeWhitePoint(r15)
            r6 = 0
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r12 = -1
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull float[] r14, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r15, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r16, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r17, float r18, float r19) {
        /*
            r12 = this;
            java.lang.String r0 = "name"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "primaries"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "whitePoint"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "oetf"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "eotf"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r5 = 0
            r10 = 0
            r11 = -1
            r1 = r12
            r8 = r18
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, float):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull float[] r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.TransferParameters r10) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r9)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = r0.computeWhitePoint(r9)
            r6 = -1
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.TransferParameters):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String str, @NotNull float[] fArr, @NotNull WhitePoint whitePoint2, @NotNull TransferParameters transferParameters2) {
        this(str, fArr, whitePoint2, transferParameters2, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
        Intrinsics.checkNotNullParameter(transferParameters2, "function");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.NotNull float[] r15, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r16, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.TransferParameters r17, int r18) {
        /*
            r13 = this;
            r9 = r17
            java.lang.String r0 = "name"
            r1 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "primaries"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "whitePoint"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r4 = 0
            double r5 = r17.getE()
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r0 != 0) goto L_0x0029
            r0 = r5
            goto L_0x002a
        L_0x0029:
            r0 = r6
        L_0x002a:
            if (r0 == 0) goto L_0x003f
            double r10 = r17.getF()
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0036
            r0 = r5
            goto L_0x0037
        L_0x0036:
            r0 = r6
        L_0x0037:
            if (r0 == 0) goto L_0x003f
            androidx.compose.ui.graphics.colorspace.Rgb$1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$1
            r0.<init>(r9)
            goto L_0x0044
        L_0x003f:
            androidx.compose.ui.graphics.colorspace.Rgb$2 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$2
            r0.<init>(r9)
        L_0x0044:
            r10 = r0
            double r11 = r17.getE()
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x004f
            r0 = r5
            goto L_0x0050
        L_0x004f:
            r0 = r6
        L_0x0050:
            if (r0 == 0) goto L_0x0064
            double r11 = r17.getF()
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r5 = r6
        L_0x005c:
            if (r5 == 0) goto L_0x0064
            androidx.compose.ui.graphics.colorspace.Rgb$3 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$3
            r0.<init>(r9)
            goto L_0x0069
        L_0x0064:
            androidx.compose.ui.graphics.colorspace.Rgb$4 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$4
            r0.<init>(r9)
        L_0x0069:
            r6 = r0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r10
            r9 = r17
            r10 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull float[] r12, double r13) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r12)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = r0.computeWhitePoint(r12)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = -1
            r1 = r10
            r2 = r11
            r5 = r13
            r1.<init>((java.lang.String) r2, (float[]) r3, (androidx.compose.ui.graphics.colorspace.WhitePoint) r4, (double) r5, (float) r7, (float) r8, (int) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], double):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String str, @NotNull float[] fArr, @NotNull WhitePoint whitePoint2, double d11) {
        this(str, fArr, whitePoint2, d11, 0.0f, 1.0f, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.NotNull float[] r25, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r26, double r27, float r29, float r30, int r31) {
        /*
            r23 = this;
            r1 = r27
            java.lang.String r0 = "name"
            r15 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "primaries"
            r13 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "whitePoint"
            r14 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r17 = 0
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0023
            r5 = r3
            goto L_0x0024
        L_0x0023:
            r5 = r4
        L_0x0024:
            if (r5 == 0) goto L_0x0029
            kotlin.jvm.functions.Function1<java.lang.Double, java.lang.Double> r5 = DoubleIdentity
            goto L_0x002e
        L_0x0029:
            androidx.compose.ui.graphics.colorspace.Rgb$5 r5 = new androidx.compose.ui.graphics.colorspace.Rgb$5
            r5.<init>(r1)
        L_0x002e:
            r18 = r5
            if (r0 != 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r3 = r4
        L_0x0034:
            if (r3 == 0) goto L_0x0039
            kotlin.jvm.functions.Function1<java.lang.Double, java.lang.Double> r0 = DoubleIdentity
            goto L_0x003e
        L_0x0039:
            androidx.compose.ui.graphics.colorspace.Rgb$6 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$6
            r0.<init>(r1)
        L_0x003e:
            r19 = r0
            androidx.compose.ui.graphics.colorspace.TransferParameters r20 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r0 = r20
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r21 = 0
            r13 = r21
            r16 = 96
            r15 = r16
            r16 = 0
            r1 = r27
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r29
            r9 = r30
            r10 = r20
            r11 = r31
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull Rgb rgb, @NotNull float[] fArr, @NotNull WhitePoint whitePoint2) {
        this(rgb.getName(), rgb.primaries, whitePoint2, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
        Intrinsics.checkNotNullParameter(rgb, "colorSpace");
        Intrinsics.checkNotNullParameter(fArr, "transform");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
    }
}
