package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u0.a;

@Immutable
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Density {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Stable
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m5452roundToPxR2X_6o(@NotNull Density density, long j11) {
            return a.a(density, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m5453roundToPx0680j_4(@NotNull Density density, float f11) {
            return a.b(density, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m5454toDpGaN1DYA(@NotNull Density density, long j11) {
            return a.c(density, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5456toDpu2uoSUM(@NotNull Density density, int i11) {
            return a.e(density, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m5457toDpSizekrfVVM(@NotNull Density density, long j11) {
            return a.f(density, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m5458toPxR2X_6o(@NotNull Density density, long j11) {
            return a.g(density, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m5459toPx0680j_4(@NotNull Density density, float f11) {
            return a.h(density, f11);
        }

        @NotNull
        @Stable
        @Deprecated
        public static Rect toRect(@NotNull Density density, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return a.i(density, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m5460toSizeXkaWNTQ(@NotNull Density density, long j11) {
            return a.j(density, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m5461toSp0xMU5do(@NotNull Density density, float f11) {
            return a.k(density, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5463toSpkPz2Gy4(@NotNull Density density, int i11) {
            return a.m(density, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5455toDpu2uoSUM(@NotNull Density density, float f11) {
            return a.d(density, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5462toSpkPz2Gy4(@NotNull Density density, float f11) {
            return a.l(density, f11);
        }
    }

    float getDensity();

    float getFontScale();

    @Stable
    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    int m5440roundToPxR2X_6o(long j11);

    @Stable
    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    int m5441roundToPx0680j_4(float f11);

    @Stable
    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m5442toDpGaN1DYA(long j11);

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m5443toDpu2uoSUM(float f11);

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m5444toDpu2uoSUM(int i11);

    @Stable
    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m5445toDpSizekrfVVM(long j11);

    @Stable
    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    float m5446toPxR2X_6o(long j11);

    @Stable
    /* renamed from: toPx-0680j_4  reason: not valid java name */
    float m5447toPx0680j_4(float f11);

    @NotNull
    @Stable
    Rect toRect(@NotNull DpRect dpRect);

    @Stable
    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m5448toSizeXkaWNTQ(long j11);

    @Stable
    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m5449toSp0xMU5do(float f11);

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m5450toSpkPz2Gy4(float f11);

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m5451toSpkPz2Gy4(int i11);
}
