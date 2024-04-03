package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 G2\u00020\u0001:\u0001GB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u001b\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\b\u001e\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\b'\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b-\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b/\u0010+J+\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000eH\n¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001e\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\bF\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "set", "v", "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class Matrix {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    @NotNull
    private final float[] values;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/Matrix$Companion;", "", "()V", "Perspective0", "", "Perspective1", "Perspective2", "ScaleX", "ScaleY", "ScaleZ", "SkewX", "SkewY", "TranslateX", "TranslateY", "TranslateZ", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Matrix m3098boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m3099constructorimpl(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m3100constructorimpl$default(float[] fArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i11 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m3099constructorimpl(fArr);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3101equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual((Object) fArr, (Object) ((Matrix) obj).m3121unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3102equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual((Object) fArr, (Object) fArr2);
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m3103getimpl(float[] fArr, int i11, int i12) {
        return fArr[(i11 * 4) + i12];
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3104hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: invert-impl  reason: not valid java name */
    public static final void m3105invertimpl(float[] fArr) {
        boolean z11;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[3];
        float f15 = fArr[4];
        float f16 = fArr[5];
        float f17 = fArr[6];
        float f18 = fArr[7];
        float f19 = fArr[8];
        float f21 = fArr[9];
        float f22 = fArr[10];
        float f23 = fArr[11];
        float f24 = fArr[12];
        float f25 = fArr[13];
        float f26 = fArr[14];
        float f27 = fArr[15];
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
        if (!z11) {
            float f43 = 1.0f / f42;
            fArr[0] = (((f16 * f41) - (f17 * f39)) + (f18 * f38)) * f43;
            fArr[1] = ((((-f12) * f41) + (f13 * f39)) - (f14 * f38)) * f43;
            fArr[2] = (((f25 * f34) - (f26 * f33)) + (f27 * f32)) * f43;
            fArr[3] = ((((-f21) * f34) + (f22 * f33)) - (f23 * f32)) * f43;
            float f44 = -f15;
            fArr[4] = (((f44 * f41) + (f17 * f37)) - (f18 * f36)) * f43;
            fArr[5] = (((f41 * f11) - (f13 * f37)) + (f14 * f36)) * f43;
            float f45 = -f24;
            fArr[6] = (((f45 * f34) + (f26 * f31)) - (f27 * f29)) * f43;
            fArr[7] = (((f34 * f19) - (f22 * f31)) + (f23 * f29)) * f43;
            fArr[8] = (((f15 * f39) - (f16 * f37)) + (f18 * f35)) * f43;
            fArr[9] = ((((-f11) * f39) + (f37 * f12)) - (f14 * f35)) * f43;
            fArr[10] = (((f24 * f33) - (f25 * f31)) + (f27 * f28)) * f43;
            fArr[11] = ((((-f19) * f33) + (f31 * f21)) - (f23 * f28)) * f43;
            fArr[12] = (((f44 * f38) + (f16 * f36)) - (f17 * f35)) * f43;
            fArr[13] = (((f11 * f38) - (f12 * f36)) + (f13 * f35)) * f43;
            fArr[14] = (((f45 * f32) + (f25 * f29)) - (f26 * f28)) * f43;
            fArr[15] = (((f19 * f32) - (f21 * f29)) + (f22 * f28)) * f43;
        }
    }

    /* renamed from: map-MK-Hz9U  reason: not valid java name */
    public static final long m3106mapMKHz9U(float[] fArr, long j11) {
        boolean z11;
        float r02 = Offset.m2676getXimpl(j11);
        float r52 = Offset.m2677getYimpl(j11);
        float f11 = ((float) 1) / (((fArr[3] * r02) + (fArr[7] * r52)) + fArr[15]);
        if (Float.isInfinite(f11) || Float.isNaN(f11)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            f11 = 0.0f;
        }
        return OffsetKt.Offset(((fArr[0] * r02) + (fArr[4] * r52) + fArr[12]) * f11, f11 * ((fArr[1] * r02) + (fArr[5] * r52) + fArr[13]));
    }

    @NotNull
    /* renamed from: map-impl  reason: not valid java name */
    public static final Rect m3107mapimpl(float[] fArr, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long r02 = m3106mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long r22 = m3106mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long r42 = m3106mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long r11 = m3106mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m2676getXimpl(r02), Offset.m2676getXimpl(r22)), Math.min(Offset.m2676getXimpl(r42), Offset.m2676getXimpl(r11))), Math.min(Math.min(Offset.m2677getYimpl(r02), Offset.m2677getYimpl(r22)), Math.min(Offset.m2677getYimpl(r42), Offset.m2677getYimpl(r11))), Math.max(Math.max(Offset.m2676getXimpl(r02), Offset.m2676getXimpl(r22)), Math.max(Offset.m2676getXimpl(r42), Offset.m2676getXimpl(r11))), Math.max(Math.max(Offset.m2677getYimpl(r02), Offset.m2677getYimpl(r22)), Math.max(Offset.m2677getYimpl(r42), Offset.m2677getYimpl(r11))));
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m3109resetimpl(float[] fArr) {
        int i11 = 0;
        while (i11 < 4) {
            int i12 = 0;
            while (i12 < 4) {
                fArr[(i12 * 4) + i11] = i11 == i12 ? 1.0f : 0.0f;
                i12++;
            }
            i11++;
        }
    }

    /* renamed from: rotateX-impl  reason: not valid java name */
    public static final void m3110rotateXimpl(float[] fArr, float f11) {
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[5];
        float f15 = fArr[6];
        float f16 = fArr[9];
        float f17 = fArr[10];
        float f18 = fArr[13];
        float f19 = fArr[14];
        fArr[1] = (f12 * cos) - (f13 * sin);
        fArr[2] = (f12 * sin) + (f13 * cos);
        fArr[5] = (f14 * cos) - (f15 * sin);
        fArr[6] = (f14 * sin) + (f15 * cos);
        fArr[9] = (f16 * cos) - (f17 * sin);
        fArr[10] = (f16 * sin) + (f17 * cos);
        fArr[13] = (f18 * cos) - (f19 * sin);
        fArr[14] = (f18 * sin) + (f19 * cos);
    }

    /* renamed from: rotateY-impl  reason: not valid java name */
    public static final void m3111rotateYimpl(float[] fArr, float f11) {
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        float f12 = fArr[0];
        float f13 = fArr[2];
        float f14 = fArr[4];
        float f15 = fArr[6];
        float f16 = fArr[8];
        float f17 = fArr[10];
        float f18 = fArr[12];
        float f19 = fArr[14];
        fArr[0] = (f12 * cos) + (f13 * sin);
        fArr[2] = ((-f12) * sin) + (f13 * cos);
        fArr[4] = (f14 * cos) + (f15 * sin);
        fArr[6] = ((-f14) * sin) + (f15 * cos);
        fArr[8] = (f16 * cos) + (f17 * sin);
        fArr[10] = ((-f16) * sin) + (f17 * cos);
        fArr[12] = (f18 * cos) + (f19 * sin);
        fArr[14] = ((-f18) * sin) + (f19 * cos);
    }

    /* renamed from: rotateZ-impl  reason: not valid java name */
    public static final void m3112rotateZimpl(float[] fArr, float f11) {
        double d11 = (((double) f11) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        float f12 = fArr[0];
        float f13 = fArr[4];
        float f14 = -sin;
        float f15 = fArr[1];
        float f16 = fArr[5];
        float f17 = fArr[2];
        float f18 = fArr[6];
        float f19 = fArr[3];
        float f21 = fArr[7];
        fArr[0] = (cos * f12) + (sin * f13);
        fArr[1] = (cos * f15) + (sin * f16);
        fArr[2] = (cos * f17) + (sin * f18);
        fArr[3] = (cos * f19) + (sin * f21);
        fArr[4] = (f12 * f14) + (f13 * cos);
        fArr[5] = (f15 * f14) + (f16 * cos);
        fArr[6] = (f17 * f14) + (f18 * cos);
        fArr[7] = (f14 * f19) + (cos * f21);
    }

    /* renamed from: scale-impl  reason: not valid java name */
    public static final void m3113scaleimpl(float[] fArr, float f11, float f12, float f13) {
        fArr[0] = fArr[0] * f11;
        fArr[1] = fArr[1] * f11;
        fArr[2] = fArr[2] * f11;
        fArr[3] = fArr[3] * f11;
        fArr[4] = fArr[4] * f12;
        fArr[5] = fArr[5] * f12;
        fArr[6] = fArr[6] * f12;
        fArr[7] = fArr[7] * f12;
        fArr[8] = fArr[8] * f13;
        fArr[9] = fArr[9] * f13;
        fArr[10] = fArr[10] * f13;
        fArr[11] = fArr[11] * f13;
    }

    /* renamed from: scale-impl$default  reason: not valid java name */
    public static /* synthetic */ void m3114scaleimpl$default(float[] fArr, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f13 = 1.0f;
        }
        m3113scaleimpl(fArr, f11, f12, f13);
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m3115setimpl(float[] fArr, int i11, int i12, float f11) {
        fArr[(i11 * 4) + i12] = f11;
    }

    /* renamed from: setFrom-58bKbWc  reason: not valid java name */
    public static final void m3116setFrom58bKbWc(float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr2, "matrix");
        for (int i11 = 0; i11 < 16; i11++) {
            fArr[i11] = fArr2[i11];
        }
    }

    /* renamed from: timesAssign-58bKbWc  reason: not valid java name */
    public static final void m3117timesAssign58bKbWc(float[] fArr, @NotNull float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        Intrinsics.checkNotNullParameter(fArr4, "m");
        float r32 = MatrixKt.m3123dotp89u6pk(fArr3, 0, fArr4, 0);
        float r52 = MatrixKt.m3123dotp89u6pk(fArr3, 0, fArr4, 1);
        float r72 = MatrixKt.m3123dotp89u6pk(fArr3, 0, fArr4, 2);
        float r92 = MatrixKt.m3123dotp89u6pk(fArr3, 0, fArr4, 3);
        float r102 = MatrixKt.m3123dotp89u6pk(fArr3, 1, fArr4, 0);
        float r11 = MatrixKt.m3123dotp89u6pk(fArr3, 1, fArr4, 1);
        float r12 = MatrixKt.m3123dotp89u6pk(fArr3, 1, fArr4, 2);
        float r13 = MatrixKt.m3123dotp89u6pk(fArr3, 1, fArr4, 3);
        float r14 = MatrixKt.m3123dotp89u6pk(fArr3, 2, fArr4, 0);
        float r15 = MatrixKt.m3123dotp89u6pk(fArr3, 2, fArr4, 1);
        float r16 = MatrixKt.m3123dotp89u6pk(fArr3, 2, fArr4, 2);
        float r17 = MatrixKt.m3123dotp89u6pk(fArr3, 2, fArr4, 3);
        float r18 = MatrixKt.m3123dotp89u6pk(fArr3, 3, fArr4, 0);
        float r19 = MatrixKt.m3123dotp89u6pk(fArr3, 3, fArr4, 1);
        float r202 = MatrixKt.m3123dotp89u6pk(fArr3, 3, fArr4, 2);
        float r110 = MatrixKt.m3123dotp89u6pk(fArr3, 3, fArr4, 3);
        fArr3[0] = r32;
        fArr3[1] = r52;
        fArr3[2] = r72;
        fArr3[3] = r92;
        fArr3[4] = r102;
        fArr3[5] = r11;
        fArr3[6] = r12;
        fArr3[7] = r13;
        fArr3[8] = r14;
        fArr3[9] = r15;
        fArr3[10] = r16;
        fArr3[11] = r17;
        fArr3[12] = r18;
        fArr3[13] = r19;
        fArr3[14] = r202;
        fArr3[15] = r110;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3118toStringimpl(float[] fArr) {
        return StringsKt__IndentKt.trimIndent("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* renamed from: translate-impl  reason: not valid java name */
    public static final void m3119translateimpl(float[] fArr, float f11, float f12, float f13) {
        float f14 = (fArr[0] * f11) + (fArr[4] * f12) + (fArr[8] * f13) + fArr[12];
        float f15 = (fArr[1] * f11) + (fArr[5] * f12) + (fArr[9] * f13) + fArr[13];
        float f16 = (fArr[2] * f11) + (fArr[6] * f12) + (fArr[10] * f13) + fArr[14];
        fArr[12] = f14;
        fArr[13] = f15;
        fArr[14] = f16;
        fArr[15] = (fArr[3] * f11) + (fArr[7] * f12) + (fArr[11] * f13) + fArr[15];
    }

    /* renamed from: translate-impl$default  reason: not valid java name */
    public static /* synthetic */ void m3120translateimpl$default(float[] fArr, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f13 = 0.0f;
        }
        m3119translateimpl(fArr, f11, f12, f13);
    }

    public boolean equals(Object obj) {
        return m3101equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m3104hashCodeimpl(this.values);
    }

    @NotNull
    public String toString() {
        return m3118toStringimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m3121unboximpl() {
        return this.values;
    }

    /* renamed from: map-impl  reason: not valid java name */
    public static final void m3108mapimpl(float[] fArr, @NotNull MutableRect mutableRect) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        long r02 = m3106mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getTop()));
        long r22 = m3106mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getBottom()));
        long r42 = m3106mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getTop()));
        long r62 = m3106mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getBottom()));
        mutableRect.setLeft(Math.min(Math.min(Offset.m2676getXimpl(r02), Offset.m2676getXimpl(r22)), Math.min(Offset.m2676getXimpl(r42), Offset.m2676getXimpl(r62))));
        mutableRect.setTop(Math.min(Math.min(Offset.m2677getYimpl(r02), Offset.m2677getYimpl(r22)), Math.min(Offset.m2677getYimpl(r42), Offset.m2677getYimpl(r62))));
        mutableRect.setRight(Math.max(Math.max(Offset.m2676getXimpl(r02), Offset.m2676getXimpl(r22)), Math.max(Offset.m2676getXimpl(r42), Offset.m2676getXimpl(r62))));
        mutableRect.setBottom(Math.max(Math.max(Offset.m2677getYimpl(r02), Offset.m2677getYimpl(r22)), Math.max(Offset.m2677getYimpl(r42), Offset.m2677getYimpl(r62))));
    }
}
