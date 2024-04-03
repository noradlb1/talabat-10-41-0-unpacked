package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a<\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a2\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\b\u001a-\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a!\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010+\u001a\u00020,*\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006:"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ColorKt {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0148  */
    @androidx.compose.runtime.Stable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long Color(float r9, float r10, float r11, float r12, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.ColorSpace r13) {
        /*
            java.lang.String r0 = "colorSpace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 0
            float r1 = r13.getMinValue(r0)
            float r2 = r13.getMaxValue(r0)
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            r3 = 1
            if (r2 > 0) goto L_0x0019
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 > 0) goto L_0x0019
            r1 = r3
            goto L_0x001a
        L_0x0019:
            r1 = r0
        L_0x001a:
            r2 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r1 == 0) goto L_0x0059
            float r1 = r13.getMinValue(r3)
            float r5 = r13.getMaxValue(r3)
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0031
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0031
            r1 = r3
            goto L_0x0032
        L_0x0031:
            r1 = r0
        L_0x0032:
            if (r1 == 0) goto L_0x0059
            r1 = 2
            float r5 = r13.getMinValue(r1)
            float r1 = r13.getMaxValue(r1)
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0047
            int r1 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r1 > 0) goto L_0x0047
            r1 = r3
            goto L_0x0048
        L_0x0047:
            r1 = r0
        L_0x0048:
            if (r1 == 0) goto L_0x0059
            int r1 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r1 > 0) goto L_0x0054
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0054
            r1 = r3
            goto L_0x0055
        L_0x0054:
            r1 = r0
        L_0x0055:
            if (r1 == 0) goto L_0x0059
            r1 = r3
            goto L_0x005a
        L_0x0059:
            r1 = r0
        L_0x005a:
            if (r1 == 0) goto L_0x0148
            boolean r1 = r13.isSrgb()
            r5 = 32
            r6 = 16
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r1 == 0) goto L_0x0097
            r13 = 1132396544(0x437f0000, float:255.0)
            float r12 = r12 * r13
            float r12 = r12 + r7
            int r12 = (int) r12
            int r12 = r12 << 24
            float r9 = r9 * r13
            float r9 = r9 + r7
            int r9 = (int) r9
            int r9 = r9 << r6
            r9 = r9 | r12
            float r10 = r10 * r13
            float r10 = r10 + r7
            int r10 = (int) r10
            int r10 = r10 << 8
            r9 = r9 | r10
            float r11 = r11 * r13
            float r11 = r11 + r7
            int r10 = (int) r11
            r9 = r9 | r10
            long r9 = (long) r9
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            r11 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r9 = r9 & r11
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r9 = r9 << r5
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r9 = androidx.compose.ui.graphics.Color.m2915constructorimpl(r9)
            return r9
        L_0x0097:
            int r1 = r13.getComponentCount()
            r8 = 3
            if (r1 != r8) goto L_0x00a0
            r1 = r3
            goto L_0x00a1
        L_0x00a0:
            r1 = r0
        L_0x00a1:
            if (r1 == 0) goto L_0x013c
            int r13 = r13.getId$ui_graphics_release()
            r1 = -1
            if (r13 == r1) goto L_0x00ab
            r0 = r3
        L_0x00ab:
            if (r0 == 0) goto L_0x0130
            short r9 = androidx.compose.ui.graphics.Float16.m3013constructorimpl((float) r9)
            short r10 = androidx.compose.ui.graphics.Float16.m3013constructorimpl((float) r10)
            short r11 = androidx.compose.ui.graphics.Float16.m3013constructorimpl((float) r11)
            float r12 = java.lang.Math.min(r12, r2)
            float r12 = java.lang.Math.max(r4, r12)
            r0 = 1149222912(0x447fc000, float:1023.0)
            float r12 = r12 * r0
            float r12 = r12 + r7
            int r12 = (int) r12
            long r0 = (long) r9
            long r0 = kotlin.ULong.m6501constructorimpl(r0)
            r2 = 65535(0xffff, double:3.23786E-319)
            long r0 = r0 & r2
            long r0 = kotlin.ULong.m6501constructorimpl(r0)
            r9 = 48
            long r0 = r0 << r9
            long r0 = kotlin.ULong.m6501constructorimpl(r0)
            long r9 = (long) r10
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r9 = r9 & r2
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r9 = r9 << r5
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r9 = r9 | r0
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r0 = (long) r11
            long r0 = kotlin.ULong.m6501constructorimpl(r0)
            long r0 = r0 & r2
            long r0 = kotlin.ULong.m6501constructorimpl(r0)
            long r0 = r0 << r6
            long r0 = kotlin.ULong.m6501constructorimpl(r0)
            long r9 = r9 | r0
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r11 = (long) r12
            long r11 = kotlin.ULong.m6501constructorimpl(r11)
            r0 = 1023(0x3ff, double:5.054E-321)
            long r11 = r11 & r0
            long r11 = kotlin.ULong.m6501constructorimpl(r11)
            r0 = 6
            long r11 = r11 << r0
            long r11 = kotlin.ULong.m6501constructorimpl(r11)
            long r9 = r9 | r11
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r11 = (long) r13
            long r11 = kotlin.ULong.m6501constructorimpl(r11)
            r0 = 63
            long r11 = r11 & r0
            long r11 = kotlin.ULong.m6501constructorimpl(r11)
            long r9 = r9 | r11
            long r9 = kotlin.ULong.m6501constructorimpl(r9)
            long r9 = androidx.compose.ui.graphics.Color.m2915constructorimpl(r9)
            return r9
        L_0x0130:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unknown color space, please use a color space in ColorSpaces"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x013c:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Color only works with ColorSpaces with 3 components"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0148:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "red = "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = ", green = "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = ", blue = "
            r0.append(r9)
            r0.append(r11)
            java.lang.String r9 = ", alpha = "
            r0.append(r9)
            r0.append(r12)
            java.lang.String r9 = " outside the range for "
            r0.append(r9)
            r0.append(r13)
            java.lang.String r9 = r0.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long Color$default(float f11, float f12, float f13, float f14, ColorSpace colorSpace, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            f14 = 1.0f;
        }
        if ((i11 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f11, f12, f13, f14, colorSpace);
    }

    private static final float compositeComponent(float f11, float f12, float f13, float f14, float f15) {
        if (f15 == 0.0f) {
            return 0.0f;
        }
        return ((f11 * f13) + ((f12 * f14) * (1.0f - f13))) / f15;
    }

    @Stable
    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m2965compositeOverOWjLjI(long j11, long j12) {
        boolean z11;
        float f11;
        boolean z12;
        float f12;
        long r12 = Color.m2916convertvNxB06k(j11, Color.m2923getColorSpaceimpl(j12));
        float r02 = Color.m2921getAlphaimpl(j12);
        float r13 = Color.m2921getAlphaimpl(r12);
        float f13 = 1.0f - r13;
        float f14 = (r02 * f13) + r13;
        float r42 = Color.m2925getRedimpl(r12);
        float r52 = Color.m2925getRedimpl(j12);
        float f15 = 0.0f;
        int i11 = (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1));
        boolean z13 = true;
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f11 = 0.0f;
        } else {
            f11 = ((r42 * r13) + ((r52 * r02) * f13)) / f14;
        }
        float r53 = Color.m2924getGreenimpl(r12);
        float r102 = Color.m2924getGreenimpl(j12);
        if (i11 == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            f12 = 0.0f;
        } else {
            f12 = ((r53 * r13) + ((r102 * r02) * f13)) / f14;
        }
        float r122 = Color.m2922getBlueimpl(r12);
        float r132 = Color.m2922getBlueimpl(j12);
        if (i11 != 0) {
            z13 = false;
        }
        if (!z13) {
            f15 = ((r122 * r13) + ((r132 * r02) * f13)) / f14;
        }
        return Color(f11, f12, f15, f14, Color.m2923getColorSpaceimpl(j12));
    }

    /* access modifiers changed from: private */
    /* renamed from: getComponents-8_81llA  reason: not valid java name */
    public static final float[] m2966getComponents8_81llA(long j11) {
        return new float[]{Color.m2925getRedimpl(j11), Color.m2924getGreenimpl(j11), Color.m2922getBlueimpl(j11), Color.m2921getAlphaimpl(j11)};
    }

    /* renamed from: isSpecified-8_81llA  reason: not valid java name */
    public static final boolean m2967isSpecified8_81llA(long j11) {
        return j11 != Color.Companion.m2955getUnspecified0d7_KjU();
    }

    @Stable
    /* renamed from: isSpecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m2968isSpecified8_81llA$annotations(long j11) {
    }

    /* renamed from: isUnspecified-8_81llA  reason: not valid java name */
    public static final boolean m2969isUnspecified8_81llA(long j11) {
        return j11 == Color.Companion.m2955getUnspecified0d7_KjU();
    }

    @Stable
    /* renamed from: isUnspecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m2970isUnspecified8_81llA$annotations(long j11) {
    }

    @Stable
    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m2971lerpjxsXWHM(long j11, long j12, float f11) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long r82 = Color.m2916convertvNxB06k(j11, oklab);
        long r12 = Color.m2916convertvNxB06k(j12, oklab);
        float r32 = Color.m2921getAlphaimpl(r82);
        float r42 = Color.m2925getRedimpl(r82);
        float r52 = Color.m2924getGreenimpl(r82);
        float r83 = Color.m2922getBlueimpl(r82);
        float r92 = Color.m2921getAlphaimpl(r12);
        float r62 = Color.m2925getRedimpl(r12);
        float r72 = Color.m2924getGreenimpl(r12);
        float r13 = Color.m2922getBlueimpl(r12);
        return Color.m2916convertvNxB06k(Color(MathHelpersKt.lerp(r42, r62, f11), MathHelpersKt.lerp(r52, r72, f11), MathHelpersKt.lerp(r83, r13, f11), MathHelpersKt.lerp(r32, r92, f11), oklab), Color.m2923getColorSpaceimpl(j12));
    }

    @Stable
    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m2972luminance8_81llA(long j11) {
        ColorSpace r02 = Color.m2923getColorSpaceimpl(j11);
        if (ColorModel.m3308equalsimpl0(r02.m3317getModelxdoWZVw(), ColorModel.Companion.m3315getRgbxdoWZVw())) {
            Intrinsics.checkNotNull(r02, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Function1<Double, Double> eotf = ((Rgb) r02).getEotf();
            return saturate((float) ((eotf.invoke(Double.valueOf((double) Color.m2925getRedimpl(j11))).doubleValue() * 0.2126d) + (eotf.invoke(Double.valueOf((double) Color.m2924getGreenimpl(j11))).doubleValue() * 0.7152d) + (eotf.invoke(Double.valueOf((double) Color.m2922getBlueimpl(j11))).doubleValue() * 0.0722d)));
        }
        throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.m3311toStringimpl(r02.m3317getModelxdoWZVw())).toString());
    }

    private static final float saturate(float f11) {
        float f12 = 0.0f;
        if (f11 > 0.0f) {
            f12 = 1.0f;
            if (f11 < 1.0f) {
                return f11;
            }
        }
        return f12;
    }

    /* renamed from: takeOrElse-DxMtmZc  reason: not valid java name */
    public static final long m2973takeOrElseDxMtmZc(long j11, @NotNull Function0<Color> function0) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (j11 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return j11;
        }
        return function0.invoke().m2929unboximpl();
    }

    @Stable
    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m2974toArgb8_81llA(long j11) {
        ColorSpace r02 = Color.m2923getColorSpaceimpl(j11);
        if (r02.isSrgb()) {
            return (int) ULong.m6501constructorimpl(j11 >>> 32);
        }
        float[] r32 = m2966getComponents8_81llA(j11);
        ColorSpaceKt.m3319connectYBCOT_4$default(r02, (ColorSpace) null, 0, 3, (Object) null).transform(r32);
        return ((int) ((r32[2] * 255.0f) + 0.5f)) | (((int) ((r32[3] * 255.0f) + 0.5f)) << 24) | (((int) ((r32[0] * 255.0f) + 0.5f)) << 16) | (((int) ((r32[1] * 255.0f) + 0.5f)) << 8);
    }

    public static /* synthetic */ long Color$default(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 8) != 0) {
            i14 = 255;
        }
        return Color(i11, i12, i13, i14);
    }

    @Stable
    public static final long Color(int i11) {
        return Color.m2915constructorimpl(ULong.m6501constructorimpl(ULong.m6501constructorimpl((long) i11) << 32));
    }

    @Stable
    public static final long Color(long j11) {
        return Color.m2915constructorimpl(ULong.m6501constructorimpl(ULong.m6501constructorimpl(ULong.m6501constructorimpl(j11) & 4294967295L) << 32));
    }

    @Stable
    public static final long Color(int i11, int i12, int i13, int i14) {
        return Color(((i11 & 255) << 16) | ((i14 & 255) << 24) | ((i12 & 255) << 8) | (i13 & 255));
    }
}
