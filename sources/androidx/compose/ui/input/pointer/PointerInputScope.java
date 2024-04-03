package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import i0.f;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u0010X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "<anonymous parameter 0>", "", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents$annotations", "()V", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PointerInputScope extends Density {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
        public static long m4330getExtendedTouchPaddingNHjbRc(@NotNull PointerInputScope pointerInputScope) {
            return f.a(pointerInputScope);
        }

        @Deprecated
        public static boolean getInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope) {
            return f.b(pointerInputScope);
        }

        public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m4331roundToPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j11) {
            return a.a(pointerInputScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m4332roundToPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f11) {
            return a.b(pointerInputScope, f11);
        }

        @Deprecated
        public static void setInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope, boolean z11) {
            f.c(pointerInputScope, z11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m4333toDpGaN1DYA(@NotNull PointerInputScope pointerInputScope, long j11) {
            return a.c(pointerInputScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4334toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, float f11) {
            return a.d(pointerInputScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m4336toDpSizekrfVVM(@NotNull PointerInputScope pointerInputScope, long j11) {
            return a.f(pointerInputScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m4337toPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j11) {
            return a.g(pointerInputScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m4338toPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f11) {
            return a.h(pointerInputScope, f11);
        }

        @NotNull
        @Stable
        @Deprecated
        public static Rect toRect(@NotNull PointerInputScope pointerInputScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return a.i(pointerInputScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m4339toSizeXkaWNTQ(@NotNull PointerInputScope pointerInputScope, long j11) {
            return a.j(pointerInputScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m4340toSp0xMU5do(@NotNull PointerInputScope pointerInputScope, float f11) {
            return a.k(pointerInputScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4341toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, float f11) {
            return a.l(pointerInputScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4335toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, int i11) {
            return a.e(pointerInputScope, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4342toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, int i11) {
            return a.m(pointerInputScope, i11);
        }
    }

    @Nullable
    <R> Object awaitPointerEventScope(@NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation);

    /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
    long m4328getExtendedTouchPaddingNHjbRc();

    boolean getInterceptOutOfBoundsChildEvents();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long m4329getSizeYbymL2g();

    @NotNull
    ViewConfiguration getViewConfiguration();

    void setInterceptOutOfBoundsChildEvents(boolean z11);
}
