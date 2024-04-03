package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.util.MathHelpersKt;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010#\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010&\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0006\u0010'\u001a\u00020\u0019J\u001f\u0010(\u001a\u00020\u0019*\u00020)2\u0006\u0010*\u001a\u00020+ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010 R\u0019\u0010!\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "Landroidx/compose/ui/unit/Dp;", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "F", "startRadius", "Ljava/lang/Float;", "targetCenter", "targetRadius", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RippleAnimation {
    /* access modifiers changed from: private */
    @NotNull
    public final Animatable<Float, AnimationVector1D> animatedAlpha;
    /* access modifiers changed from: private */
    @NotNull
    public final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    /* access modifiers changed from: private */
    @NotNull
    public final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;
    @NotNull
    private final MutableState finishRequested$delegate;
    @NotNull
    private final CompletableDeferred<Unit> finishSignalDeferred;
    @NotNull
    private final MutableState finishedFadingIn$delegate;
    @Nullable
    private Offset origin;
    private final float radius;
    @Nullable
    private Float startRadius;
    @Nullable
    private Offset targetCenter;
    @Nullable
    private Float targetRadius;

    private RippleAnimation(Offset offset, float f11, boolean z11) {
        this.origin = offset;
        this.radius = f11;
        this.bounded = z11;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred((Job) null);
        Boolean bool = Boolean.FALSE;
        this.finishedFadingIn$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.finishRequested$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ RippleAnimation(Offset offset, float f11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f11, z11);
    }

    /* access modifiers changed from: private */
    public final Object fadeIn(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeIn$2(this, (Continuation<? super RippleAnimation$fadeIn$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object fadeOut(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeOut$2(this, (Continuation<? super RippleAnimation$fadeOut$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested$delegate.getValue()).booleanValue();
    }

    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn$delegate.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z11) {
        this.finishRequested$delegate.setValue(Boolean.valueOf(z11));
    }

    private final void setFinishedFadingIn(boolean z11) {
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animate(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation$animate$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation$animate$1) r0
            int r1 = r0.f6229k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f6229k = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f6227i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f6229k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x003f
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0072
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0037:
            java.lang.Object r2 = r0.f6226h
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0066
        L_0x003f:
            java.lang.Object r2 = r0.f6226h
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0056
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f6226h = r6
            r0.f6229k = r5
            java.lang.Object r7 = r6.fadeIn(r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r6
        L_0x0056:
            r2.setFinishedFadingIn(r5)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r7 = r2.finishSignalDeferred
            r0.f6226h = r2
            r0.f6229k = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r7 = 0
            r0.f6226h = r7
            r0.f6229k = r3
            java.lang.Object r7 = r2.fadeOut(r0)
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0072:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: draw-4WTKRHQ  reason: not valid java name */
    public final void m1478draw4WTKRHQ(@NotNull DrawScope drawScope, long j11) {
        float f11;
        Float f12;
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$draw");
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1480getRippleStartRadiusuvyYCjk(drawScope.m3425getSizeNHjbRc()));
        }
        if (this.targetRadius == null) {
            if (Float.isNaN(this.radius)) {
                f12 = Float.valueOf(RippleAnimationKt.m1479getRippleEndRadiuscSwnlzA(drawScope2, this.bounded, drawScope.m3425getSizeNHjbRc()));
            } else {
                f12 = Float.valueOf(drawScope2.m5447toPx0680j_4(this.radius));
            }
            this.targetRadius = f12;
        }
        if (this.origin == null) {
            this.origin = Offset.m2665boximpl(drawScope.m3424getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m2665boximpl(OffsetKt.Offset(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) / 2.0f, Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) / 2.0f));
        }
        if (!getFinishRequested() || getFinishedFadingIn()) {
            f11 = this.animatedAlpha.getValue().floatValue();
        } else {
            f11 = 1.0f;
        }
        Float f13 = this.startRadius;
        Intrinsics.checkNotNull(f13);
        float floatValue = f13.floatValue();
        Float f14 = this.targetRadius;
        Intrinsics.checkNotNull(f14);
        float lerp = MathHelpersKt.lerp(floatValue, f14.floatValue(), this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float r32 = Offset.m2676getXimpl(offset.m2686unboximpl());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float lerp2 = MathHelpersKt.lerp(r32, Offset.m2676getXimpl(offset2.m2686unboximpl()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float r52 = Offset.m2677getYimpl(offset3.m2686unboximpl());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long Offset = OffsetKt.Offset(lerp2, MathHelpersKt.lerp(r52, Offset.m2677getYimpl(offset4.m2686unboximpl()), this.animatedCenterPercent.getValue().floatValue()));
        long r22 = Color.m2918copywmQWz5c$default(j11, Color.m2921getAlphaimpl(j11) * f11, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (this.bounded) {
            float r11 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc());
            float r12 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
            int r13 = ClipOp.Companion.m2908getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long r72 = drawContext.m3403getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m3475clipRectN_I0leg(0.0f, 0.0f, r11, r12, r13);
            b.x(drawScope, r22, lerp, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            drawContext.getCanvas().restore();
            drawContext.m3404setSizeuvyYCjk(r72);
            return;
        }
        b.x(drawScope, r22, lerp, Offset, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }
}
