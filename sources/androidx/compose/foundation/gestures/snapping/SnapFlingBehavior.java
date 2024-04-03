package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u001d\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u0006*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ%\u0010\u001f\u001a\u00020 *\u00020\u001b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\fX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "approachAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "shortSnapVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "velocityThreshold", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", "offset", "velocity", "longSnap", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "runApproach", "Landroidx/compose/foundation/gestures/snapping/ApproachStepResult;", "initialTargetOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
public final class SnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    @NotNull
    private final DecayAnimationSpec<Float> approachAnimationSpec;
    @NotNull
    private final Density density;
    private final float shortSnapVelocityThreshold;
    @NotNull
    private final AnimationSpec<Float> snapAnimationSpec;
    @NotNull
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;
    private final float velocityThreshold;

    private SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider2, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Density density2, float f11) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider2;
        this.approachAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
        this.density = density2;
        this.shortSnapVelocityThreshold = f11;
        this.velocityThreshold = density2.m5447toPx0680j_4(f11);
    }

    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider2, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec, Density density2, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapLayoutInfoProvider2, decayAnimationSpec, animationSpec, density2, f11);
    }

    private final boolean isDecayApproachPossible(float f11, float f12) {
        float calculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(this.approachAnimationSpec, 0.0f, f12);
        float snapStepSize = this.snapLayoutInfoProvider.snapStepSize(this.density);
        if (Math.abs(calculateTargetValue) <= snapStepSize || Math.abs(calculateTargetValue) - snapStepSize <= Math.abs(f11)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object longSnap(androidx.compose.foundation.gestures.ScrollScope r8, float r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1) r0
            int r1 = r0.f2379l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2379l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1
            r0.<init>(r7, r10)
        L_0x0018:
            r6 = r0
            java.lang.Object r10 = r6.f2377j
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f2379l
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0041
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007f
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r6.f2376i
            androidx.compose.foundation.gestures.ScrollScope r8 = (androidx.compose.foundation.gestures.ScrollScope) r8
            java.lang.Object r9 = r6.f2375h
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r9 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0063
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r10 = r7.snapLayoutInfoProvider
            androidx.compose.ui.unit.Density r1 = r7.density
            float r10 = r10.calculateApproachOffset(r1, r9)
            float r10 = java.lang.Math.abs(r10)
            float r1 = java.lang.Math.signum(r9)
            float r10 = r10 * r1
            r6.f2375h = r7
            r6.f2376i = r8
            r6.f2379l = r3
            java.lang.Object r10 = r7.runApproach(r8, r10, r9, r6)
            if (r10 != r0) goto L_0x0062
            return r0
        L_0x0062:
            r9 = r7
        L_0x0063:
            r1 = r8
            androidx.compose.foundation.gestures.snapping.ApproachStepResult r10 = (androidx.compose.foundation.gestures.snapping.ApproachStepResult) r10
            float r3 = r10.component1()
            androidx.compose.animation.core.AnimationState r4 = r10.component2()
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r5 = r9.snapAnimationSpec
            r8 = 0
            r6.f2375h = r8
            r6.f2376i = r8
            r6.f2379l = r2
            r2 = r3
            java.lang.Object r8 = androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateSnap(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x007f
            return r0
        L_0x007f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.longSnap(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object runApproach(ScrollScope scrollScope, float f11, float f12, Continuation<? super ApproachStepResult> continuation) {
        ApproachAnimation approachAnimation;
        if (isDecayApproachPossible(f11, f12)) {
            approachAnimation = new DecayApproachAnimation(this.approachAnimationSpec, this.snapLayoutInfoProvider, this.density);
        } else {
            approachAnimation = new SnapApproachAnimation(this.snapAnimationSpec, this.snapLayoutInfoProvider, this.density);
        }
        return SnapFlingBehaviorKt.approach(scrollScope, f11, f12, approachAnimation, this.snapLayoutInfoProvider, this.density, continuation);
    }

    /* access modifiers changed from: private */
    public final Object shortSnap(ScrollScope scrollScope, float f11, Continuation<? super Unit> continuation) {
        float findClosestOffset = SnapFlingBehaviorKt.findClosestOffset(0.0f, this.snapLayoutInfoProvider, this.density);
        Object access$animateSnap = SnapFlingBehaviorKt.animateSnap(scrollScope, findClosestOffset, findClosestOffset, AnimationStateKt.AnimationState$default(0.0f, f11, 0, 0, false, 28, (Object) null), this.snapAnimationSpec, continuation);
        if (access$animateSnap == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return access$animateSnap;
        }
        return Unit.INSTANCE;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
        if (!Intrinsics.areEqual((Object) snapFlingBehavior.snapAnimationSpec, (Object) this.snapAnimationSpec) || !Intrinsics.areEqual((Object) snapFlingBehavior.approachAnimationSpec, (Object) this.approachAnimationSpec) || !Intrinsics.areEqual((Object) snapFlingBehavior.snapLayoutInfoProvider, (Object) this.snapLayoutInfoProvider) || !Intrinsics.areEqual((Object) snapFlingBehavior.density, (Object) this.density) || !Dp.m5483equalsimpl0(snapFlingBehavior.shortSnapVelocityThreshold, this.shortSnapVelocityThreshold)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((0 + this.snapAnimationSpec.hashCode()) * 31) + this.approachAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode()) * 31) + this.density.hashCode()) * 31) + Dp.m5484hashCodeimpl(this.shortSnapVelocityThreshold);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object performFling(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollScope r6, float r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Float> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1) r0
            int r1 = r0.f2382j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2382j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f2380h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2382j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 == r4) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            float r8 = java.lang.Math.abs(r7)
            float r2 = r5.velocityThreshold
            float r2 = java.lang.Math.abs(r2)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 > 0) goto L_0x004f
            r0.f2382j = r4
            java.lang.Object r6 = r5.shortSnap(r6, r7, r0)
            if (r6 != r1) goto L_0x0058
            return r1
        L_0x004f:
            r0.f2382j = r3
            java.lang.Object r6 = r5.longSnap(r6, r7, r0)
            if (r6 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r6 = 0
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider2, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec, Density density2, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapLayoutInfoProvider2, decayAnimationSpec, animationSpec, density2, (i11 & 16) != 0 ? SnapFlingBehaviorKt.getMinFlingVelocityDp() : f11, (DefaultConstructorMarker) null);
    }
}
