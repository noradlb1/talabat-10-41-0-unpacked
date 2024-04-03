package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PressGestureScope extends Density {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m315roundToPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j11) {
            return a.a(pressGestureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m316roundToPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f11) {
            return a.b(pressGestureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m317toDpGaN1DYA(@NotNull PressGestureScope pressGestureScope, long j11) {
            return a.c(pressGestureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m318toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, float f11) {
            return a.d(pressGestureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m320toDpSizekrfVVM(@NotNull PressGestureScope pressGestureScope, long j11) {
            return a.f(pressGestureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m321toPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j11) {
            return a.g(pressGestureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m322toPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f11) {
            return a.h(pressGestureScope, f11);
        }

        @NotNull
        @Stable
        @Deprecated
        public static Rect toRect(@NotNull PressGestureScope pressGestureScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return a.i(pressGestureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m323toSizeXkaWNTQ(@NotNull PressGestureScope pressGestureScope, long j11) {
            return a.j(pressGestureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m324toSp0xMU5do(@NotNull PressGestureScope pressGestureScope, float f11) {
            return a.k(pressGestureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m325toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, float f11) {
            return a.l(pressGestureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m319toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, int i11) {
            return a.e(pressGestureScope, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m326toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, int i11) {
            return a.m(pressGestureScope, i11);
        }
    }

    @Nullable
    Object awaitRelease(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object tryAwaitRelease(@NotNull Continuation<? super Boolean> continuation);
}
