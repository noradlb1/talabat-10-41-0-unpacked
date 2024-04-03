package androidx.compose.ui.graphics.drawscope;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import f0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ContentDrawScope extends DrawScope {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m3388drawImageAZ2fEMs(@NotNull ContentDrawScope contentDrawScope, @NotNull ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11, int i12) {
            Intrinsics.checkNotNullParameter(imageBitmap, "image");
            Intrinsics.checkNotNullParameter(drawStyle, "style");
            b.a(contentDrawScope, imageBitmap, j11, j12, j13, j14, f11, drawStyle, colorFilter, i11, i12);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m3389getCenterF1C5BW0(@NotNull ContentDrawScope contentDrawScope) {
            return b.b(contentDrawScope);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m3390getSizeNHjbRc(@NotNull ContentDrawScope contentDrawScope) {
            return b.c(contentDrawScope);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m3391roundToPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j11) {
            return a.a(contentDrawScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m3392roundToPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f11) {
            return a.b(contentDrawScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m3393toDpGaN1DYA(@NotNull ContentDrawScope contentDrawScope, long j11) {
            return a.c(contentDrawScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3394toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, float f11) {
            return a.d(contentDrawScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m3396toDpSizekrfVVM(@NotNull ContentDrawScope contentDrawScope, long j11) {
            return a.f(contentDrawScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m3397toPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j11) {
            return a.g(contentDrawScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m3398toPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f11) {
            return a.h(contentDrawScope, f11);
        }

        @NotNull
        @Stable
        @Deprecated
        public static Rect toRect(@NotNull ContentDrawScope contentDrawScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return a.i(contentDrawScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m3399toSizeXkaWNTQ(@NotNull ContentDrawScope contentDrawScope, long j11) {
            return a.j(contentDrawScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m3400toSp0xMU5do(@NotNull ContentDrawScope contentDrawScope, float f11) {
            return a.k(contentDrawScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3401toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, float f11) {
            return a.l(contentDrawScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3395toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, int i11) {
            return a.e(contentDrawScope, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3402toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, int i11) {
            return a.m(contentDrawScope, i11);
        }
    }

    void drawContent();
}
