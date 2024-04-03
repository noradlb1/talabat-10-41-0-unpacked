package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.instabug.library.model.State;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(30)
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J1\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010\rH@ø\u0001\u0001¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J)\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b3\u00104J-\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J%\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    /* access modifiers changed from: private */
    @Nullable
    public WindowInsetsAnimationController animationController;
    /* access modifiers changed from: private */
    @Nullable
    public Job animationJob;
    @NotNull
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    /* access modifiers changed from: private */
    @Nullable
    public CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    @NotNull
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    @NotNull
    private final SideCalculator sideCalculator;
    @NotNull
    private final View view;
    @NotNull
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(@NotNull AndroidWindowInsets androidWindowInsets, @NotNull View view2, @NotNull SideCalculator sideCalculator2, @NotNull Density density2) {
        Intrinsics.checkNotNullParameter(androidWindowInsets, "windowInsets");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(sideCalculator2, "sideCalculator");
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        this.windowInsets = androidWindowInsets;
        this.view = view2;
        this.sideCalculator = sideCalculator2;
        this.density = density2;
    }

    /* access modifiers changed from: private */
    public final void adjustInsets(float f11) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            Insets a11 = windowInsetsAnimationController.getCurrentInsets();
            Intrinsics.checkNotNullExpressionValue(a11, "it.currentInsets");
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(a11, MathKt__MathJVMKt.roundToInt(f11)), 1.0f, 0.0f);
        }
    }

    private final void animationEnded() {
        boolean z11;
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if (windowInsetsAnimationController2 == null || !windowInsetsAnimationController2.isReady()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE);
        }
        this.continuation = null;
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* renamed from: fling-huYlsQE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m580flinghuYlsQE(long r27, float r29, boolean r30, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r29
            r2 = r30
            r3 = r31
            boolean r4 = r3 instanceof androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1) r4
            int r5 = r4.f2602n
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f2602n = r5
            goto L_0x0020
        L_0x001b:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r4 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f2600l
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.f2602n
            r7 = 3
            r8 = 2
            r10 = 0
            r11 = 0
            r12 = 1
            if (r6 == 0) goto L_0x0063
            if (r6 == r12) goto L_0x0057
            if (r6 == r8) goto L_0x0048
            if (r6 != r7) goto L_0x0040
            long r1 = r4.f2598j
            java.lang.Object r4 = r4.f2596h
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0157
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            long r1 = r4.f2598j
            java.lang.Object r5 = r4.f2597i
            kotlin.jvm.internal.Ref$FloatRef r5 = (kotlin.jvm.internal.Ref.FloatRef) r5
            java.lang.Object r4 = r4.f2596h
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0193
        L_0x0057:
            float r1 = r4.f2599k
            long r13 = r4.f2598j
            java.lang.Object r2 = r4.f2596h
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r2 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r2
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00a7
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r3)
            kotlinx.coroutines.Job r3 = r0.animationJob
            if (r3 == 0) goto L_0x006d
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r3, (java.util.concurrent.CancellationException) r10, (int) r12, (java.lang.Object) r10)
        L_0x006d:
            r0.animationJob = r10
            r0.partialConsumption = r11
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0077
            r3 = r12
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            if (r3 == 0) goto L_0x007c
            if (r2 == 0) goto L_0x0088
        L_0x007c:
            android.view.WindowInsetsAnimationController r3 = r0.animationController
            if (r3 != 0) goto L_0x0093
            androidx.compose.foundation.layout.AndroidWindowInsets r3 = r0.windowInsets
            boolean r3 = r3.isVisible()
            if (r3 != r2) goto L_0x0093
        L_0x0088:
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m5714getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m5694boximpl(r1)
            return r1
        L_0x0093:
            r4.f2596h = r0
            r2 = r27
            r4.f2598j = r2
            r4.f2599k = r1
            r4.f2602n = r12
            java.lang.Object r6 = r0.getAnimationController(r4)
            if (r6 != r5) goto L_0x00a4
            return r5
        L_0x00a4:
            r13 = r2
            r3 = r6
            r2 = r0
        L_0x00a7:
            android.view.WindowInsetsAnimationController r3 = (android.view.WindowInsetsAnimationController) r3
            if (r3 != 0) goto L_0x00b6
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m5714getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m5694boximpl(r1)
            return r1
        L_0x00b6:
            androidx.compose.foundation.layout.SideCalculator r6 = r2.sideCalculator
            android.graphics.Insets r15 = r3.getHiddenStateInsets()
            java.lang.String r9 = "animationController.hiddenStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r9)
            int r6 = r6.valueOf(r15)
            androidx.compose.foundation.layout.SideCalculator r9 = r2.sideCalculator
            android.graphics.Insets r15 = r3.getShownStateInsets()
            java.lang.String r12 = "animationController.shownStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r12)
            int r9 = r9.valueOf(r15)
            android.graphics.Insets r12 = r3.getCurrentInsets()
            java.lang.String r15 = "animationController.currentInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            androidx.compose.foundation.layout.SideCalculator r15 = r2.sideCalculator
            int r12 = r15.valueOf(r12)
            int r15 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r15 > 0) goto L_0x00e9
            if (r12 == r6) goto L_0x00ef
        L_0x00e9:
            int r15 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r15 < 0) goto L_0x0104
            if (r12 != r9) goto L_0x0104
        L_0x00ef:
            if (r12 != r9) goto L_0x00f3
            r9 = 1
            goto L_0x00f4
        L_0x00f3:
            r9 = 0
        L_0x00f4:
            r3.finish(r9)
            r2.animationController = r10
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m5714getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m5694boximpl(r1)
            return r1
        L_0x0104:
            androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec r10 = new androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec
            androidx.compose.ui.unit.Density r15 = r2.density
            r10.<init>(r15)
            float r15 = (float) r12
            float r17 = r10.flingDistance(r1)
            float r15 = r15 + r17
            float r8 = (float) r6
            float r17 = r15 - r8
            int r11 = r9 - r6
            float r11 = (float) r11
            float r17 = r17 / r11
            r11 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x0123
            r24 = 1
            goto L_0x0125
        L_0x0123:
            r24 = 0
        L_0x0125:
            if (r24 == 0) goto L_0x012a
            r18 = r9
            goto L_0x012c
        L_0x012a:
            r18 = r6
        L_0x012c:
            float r11 = (float) r9
            int r11 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r11 > 0) goto L_0x0163
            int r8 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0136
            goto L_0x0163
        L_0x0136:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3 r6 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3
            r22 = 0
            r15 = r6
            r16 = r2
            r17 = r12
            r19 = r1
            r20 = r3
            r21 = r24
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            r4.f2596h = r2
            r4.f2598j = r13
            r4.f2602n = r7
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r4)
            if (r1 != r5) goto L_0x0155
            return r5
        L_0x0155:
            r4 = r2
            r1 = r13
        L_0x0157:
            androidx.compose.foundation.layout.SideCalculator r3 = r4.sideCalculator
            r4 = 0
            long r1 = r3.m532consumedVelocityQWom1Mo(r1, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m5694boximpl(r1)
            return r1
        L_0x0163:
            kotlin.jvm.internal.Ref$FloatRef r7 = new kotlin.jvm.internal.Ref$FloatRef
            r7.<init>()
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2 r8 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2
            r25 = 0
            r15 = r8
            r16 = r2
            r17 = r12
            r18 = r1
            r19 = r10
            r20 = r6
            r21 = r9
            r22 = r7
            r23 = r3
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r4.f2596h = r2
            r4.f2597i = r7
            r4.f2598j = r13
            r1 = 2
            r4.f2602n = r1
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r8, r4)
            if (r1 != r5) goto L_0x0190
            return r5
        L_0x0190:
            r4 = r2
            r5 = r7
            r1 = r13
        L_0x0193:
            androidx.compose.foundation.layout.SideCalculator r3 = r4.sideCalculator
            float r4 = r5.element
            long r1 = r3.m532consumedVelocityQWom1Mo(r1, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m5694boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m580flinghuYlsQE(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> continuation2) {
        Object obj = this.animationController;
        if (obj == null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation2), 1);
            cancellableContinuationImpl.initCancellability();
            this.continuation = cancellableContinuationImpl;
            requestAnimationController();
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation2);
            }
        }
        return obj;
    }

    /* access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController a11 = this.view.getWindowInsetsController();
            if (a11 != null) {
                a11.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1, (Interpolator) null, this.cancellationSignal, this);
            }
        }
    }

    /* renamed from: scroll-8S9VItk  reason: not valid java name */
    private final long m581scroll8S9VItk(long j11, float f11) {
        boolean z11;
        int i11;
        Job job = this.animationJob;
        boolean z12 = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            boolean isVisible = this.windowInsets.isVisible();
            int i12 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
            if (i12 <= 0) {
                z12 = false;
            }
            if (!(isVisible == z12 && windowInsetsAnimationController == null)) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.m531consumedOffsetsMKHz9U(j11);
                }
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets a11 = windowInsetsAnimationController.getHiddenStateInsets();
                Intrinsics.checkNotNullExpressionValue(a11, "animationController.hiddenStateInsets");
                int valueOf = sideCalculator2.valueOf(a11);
                SideCalculator sideCalculator3 = this.sideCalculator;
                Insets a12 = windowInsetsAnimationController.getShownStateInsets();
                Intrinsics.checkNotNullExpressionValue(a12, "animationController.shownStateInsets");
                int valueOf2 = sideCalculator3.valueOf(a12);
                Insets a13 = windowInsetsAnimationController.getCurrentInsets();
                Intrinsics.checkNotNullExpressionValue(a13, "animationController.currentInsets");
                int valueOf3 = this.sideCalculator.valueOf(a13);
                if (i12 > 0) {
                    i11 = valueOf2;
                } else {
                    i11 = valueOf;
                }
                if (valueOf3 == i11) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m2692getZeroF1C5BW0();
                }
                float f12 = ((float) valueOf3) + f11 + this.partialConsumption;
                int coerceIn = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(f12), valueOf, valueOf2);
                this.partialConsumption = f12 - ((float) MathKt__MathJVMKt.roundToInt(f12));
                if (coerceIn != valueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(a13, coerceIn), 1.0f, 0.0f);
                }
                return this.sideCalculator.m531consumedOffsetsMKHz9U(j11);
            }
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$dispose$1.INSTANCE);
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!Intrinsics.areEqual((Object) windowInsetsAnimationController.getCurrentInsets(), (Object) windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @NotNull
    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    public void onFinished(@NotNull WindowInsetsAnimationController windowInsetsAnimationController) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationController, "controller");
        animationEnded();
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m582onPostFlingRZ2iAVY(long j11, long j12, @NotNull Continuation<? super Velocity> continuation2) {
        return m580flinghuYlsQE(j12, this.sideCalculator.showMotion(Velocity.m5703getXimpl(j12), Velocity.m5704getYimpl(j12)), true, continuation2);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m583onPostScrollDzOQY0M(long j11, long j12, int i11) {
        return m581scroll8S9VItk(j12, this.sideCalculator.showMotion(Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12)));
    }

    @Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m584onPreFlingQWom1Mo(long j11, @NotNull Continuation<? super Velocity> continuation2) {
        return m580flinghuYlsQE(j11, this.sideCalculator.hideMotion(Velocity.m5703getXimpl(j11), Velocity.m5704getYimpl(j11)), false, continuation2);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m585onPreScrollOzD1aCk(long j11, int i11) {
        return m581scroll8S9VItk(j11, this.sideCalculator.hideMotion(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11)));
    }

    public void onReady(@NotNull WindowInsetsAnimationController windowInsetsAnimationController, int i11) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationController, "controller");
        this.animationController = windowInsetsAnimationController;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(windowInsetsAnimationController, WindowInsetsNestedScrollConnection$onReady$1.INSTANCE);
        }
        this.continuation = null;
    }
}
