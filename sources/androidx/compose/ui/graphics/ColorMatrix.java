package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJP\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f26\u0010&\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\t0'H\b¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J(\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000fH\n¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b9\u00107J\u0015\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b;\u00107J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u00107J-\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u00101J\u0010\u0010I\u001a\u00020JHÖ\u0001¢\u0006\u0004\bK\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "dot", "", "m1", "row", "", "m2", "column", "dot-Me4OoYI", "([F[FI[FI)F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "set", "src", "set-jHG-Opc", "([F[F)V", "v", "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", "sat", "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class ColorMatrix {
    @NotNull
    private final float[] values;

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m2975boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m2976constructorimpl(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m2977constructorimpl$default(float[] fArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i11 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m2976constructorimpl(fArr);
    }

    /* renamed from: convertRgbToYuv-impl  reason: not valid java name */
    public static final void m2978convertRgbToYuvimpl(float[] fArr) {
        m2985resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl  reason: not valid java name */
    public static final void m2979convertYuvToRgbimpl(float[] fArr) {
        m2985resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* renamed from: dot-Me4OoYI  reason: not valid java name */
    private static final float m2980dotMe4OoYI(float[] fArr, float[] fArr2, int i11, float[] fArr3, int i12) {
        int i13 = i11 * 5;
        return (fArr2[i13 + 0] * fArr3[0 + i12]) + (fArr2[i13 + 1] * fArr3[5 + i12]) + (fArr2[i13 + 2] * fArr3[10 + i12]) + (fArr2[i13 + 3] * fArr3[15 + i12]);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2981equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual((Object) fArr, (Object) ((ColorMatrix) obj).m2996unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2982equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual((Object) fArr, (Object) fArr2);
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m2983getimpl(float[] fArr, int i11, int i12) {
        return fArr[(i11 * 5) + i12];
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2984hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m2985resetimpl(float[] fArr) {
        ArraysKt___ArraysJvmKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* renamed from: rotateInternal-impl  reason: not valid java name */
    private static final void m2986rotateInternalimpl(float[] fArr, float f11, Function2<? super Float, ? super Float, Unit> function2) {
        m2985resetimpl(fArr);
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        function2.invoke(Float.valueOf((float) Math.cos(d11)), Float.valueOf((float) Math.sin(d11)));
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m2987setimpl(float[] fArr, int i11, int i12, float f11) {
        fArr[(i11 * 5) + i12] = f11;
    }

    /* renamed from: set-jHG-Opc  reason: not valid java name */
    public static final void m2988setjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr2, "src");
        float[] unused = ArraysKt___ArraysJvmKt.copyInto$default(fArr2, fArr, 0, 0, 0, 14, (Object) null);
    }

    /* renamed from: setToRotateBlue-impl  reason: not valid java name */
    public static final void m2989setToRotateBlueimpl(float[] fArr, float f11) {
        m2985resetimpl(fArr);
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        fArr[6] = cos;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[5] = -sin;
    }

    /* renamed from: setToRotateGreen-impl  reason: not valid java name */
    public static final void m2990setToRotateGreenimpl(float[] fArr, float f11) {
        m2985resetimpl(fArr);
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        fArr[12] = cos;
        fArr[0] = cos;
        fArr[2] = -sin;
        fArr[10] = sin;
    }

    /* renamed from: setToRotateRed-impl  reason: not valid java name */
    public static final void m2991setToRotateRedimpl(float[] fArr, float f11) {
        m2985resetimpl(fArr);
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        fArr[12] = cos;
        fArr[6] = cos;
        fArr[7] = sin;
        fArr[11] = -sin;
    }

    /* renamed from: setToSaturation-impl  reason: not valid java name */
    public static final void m2992setToSaturationimpl(float[] fArr, float f11) {
        m2985resetimpl(fArr);
        float f12 = ((float) 1) - f11;
        float f13 = 0.213f * f12;
        float f14 = 0.715f * f12;
        float f15 = f12 * 0.072f;
        fArr[0] = f13 + f11;
        fArr[1] = f14;
        fArr[2] = f15;
        fArr[5] = f13;
        fArr[6] = f14 + f11;
        fArr[7] = f15;
        fArr[10] = f13;
        fArr[11] = f14;
        fArr[12] = f15 + f11;
    }

    /* renamed from: setToScale-impl  reason: not valid java name */
    public static final void m2993setToScaleimpl(float[] fArr, float f11, float f12, float f13, float f14) {
        m2985resetimpl(fArr);
        fArr[0] = f11;
        fArr[6] = f12;
        fArr[12] = f13;
        fArr[18] = f14;
    }

    /* renamed from: timesAssign-jHG-Opc  reason: not valid java name */
    public static final void m2994timesAssignjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        Intrinsics.checkNotNullParameter(fArr4, "colorMatrix");
        float r32 = m2980dotMe4OoYI(fArr3, fArr3, 0, fArr4, 0);
        float r52 = m2980dotMe4OoYI(fArr3, fArr3, 0, fArr4, 1);
        float r72 = m2980dotMe4OoYI(fArr3, fArr3, 0, fArr4, 2);
        float r92 = m2980dotMe4OoYI(fArr3, fArr3, 0, fArr4, 3);
        float f11 = (fArr3[0] * fArr4[4]) + (fArr3[1] * fArr4[9]) + (fArr3[2] * fArr4[14]) + (fArr3[3] * fArr4[19]) + fArr3[4];
        float r12 = m2980dotMe4OoYI(fArr3, fArr3, 1, fArr4, 0);
        float r16 = m2980dotMe4OoYI(fArr3, fArr3, 1, fArr4, 1);
        float r17 = m2980dotMe4OoYI(fArr3, fArr3, 1, fArr4, 2);
        float r18 = m2980dotMe4OoYI(fArr3, fArr3, 1, fArr4, 3);
        float f12 = (fArr3[5] * fArr4[4]) + (fArr3[6] * fArr4[9]) + (fArr3[7] * fArr4[14]) + (fArr3[8] * fArr4[19]) + fArr3[9];
        float r24 = m2980dotMe4OoYI(fArr3, fArr3, 2, fArr4, 0);
        float r25 = m2980dotMe4OoYI(fArr3, fArr3, 2, fArr4, 1);
        float r26 = m2980dotMe4OoYI(fArr3, fArr3, 2, fArr4, 2);
        float r27 = m2980dotMe4OoYI(fArr3, fArr3, 2, fArr4, 3);
        float f13 = (fArr3[10] * fArr4[4]) + (fArr3[11] * fArr4[9]) + (fArr3[12] * fArr4[14]) + (fArr3[13] * fArr4[19]) + fArr3[14];
        float r33 = m2980dotMe4OoYI(fArr3, fArr3, 3, fArr4, 0);
        float r34 = m2980dotMe4OoYI(fArr3, fArr3, 3, fArr4, 1);
        float r35 = m2980dotMe4OoYI(fArr3, fArr3, 3, fArr4, 2);
        float r36 = m2980dotMe4OoYI(fArr3, fArr3, 3, fArr4, 3);
        fArr3[0] = r32;
        fArr3[1] = r52;
        fArr3[2] = r72;
        fArr3[3] = r92;
        fArr3[4] = f11;
        fArr3[5] = r12;
        fArr3[6] = r16;
        fArr3[7] = r17;
        fArr3[8] = r18;
        fArr3[9] = f12;
        fArr3[10] = r24;
        fArr3[11] = r25;
        fArr3[12] = r26;
        fArr3[13] = r27;
        fArr3[14] = f13;
        fArr3[15] = r33;
        fArr3[16] = r34;
        fArr3[17] = r35;
        fArr3[18] = r36;
        fArr3[19] = (fArr3[15] * fArr4[4]) + (fArr3[16] * fArr4[9]) + (fArr3[17] * fArr4[14]) + (fArr3[18] * fArr4[19]) + fArr3[19];
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2995toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m2981equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m2984hashCodeimpl(this.values);
    }

    public String toString() {
        return m2995toStringimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m2996unboximpl() {
        return this.values;
    }
}
