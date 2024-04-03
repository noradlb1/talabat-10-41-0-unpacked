package com.airbnb.lottie.compose;

import androidx.compose.animation.core.InfiniteAnimationPolicyKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J]\u0010A\u001a\u00020B2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\u0006\u0010:\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0019\u0010I\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020!2\u0006\u0010L\u001a\u00020,H\u0002J3\u0010M\u001a\u00020B2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!2\u0006\u0010N\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010OR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048V@RX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f8V@RX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u0019\u0010\u001bR+\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8V@RX\u0002¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b\u001d\u0010\u001b\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020!8V@RX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020!8V@RX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R+\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8V@RX\u0002¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R+\u00105\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00148V@RX\u0002¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u00108R+\u0010:\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00148V@RX\u0002¢\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u00108R\u0014\u0010>\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatableImpl;", "Lcom/airbnb/lottie/compose/LottieAnimatable;", "()V", "<set-?>", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "getClipSpec", "()Lcom/airbnb/lottie/compose/LottieClipSpec;", "setClipSpec", "(Lcom/airbnb/lottie/compose/LottieClipSpec;)V", "clipSpec$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/airbnb/lottie/LottieComposition;", "composition", "getComposition", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition", "(Lcom/airbnb/lottie/LottieComposition;)V", "composition$delegate", "endProgress", "", "getEndProgress", "()F", "endProgress$delegate", "Landroidx/compose/runtime/State;", "isAtEnd", "", "()Z", "isAtEnd$delegate", "isPlaying", "setPlaying", "(Z)V", "isPlaying$delegate", "", "iteration", "getIteration", "()I", "setIteration", "(I)V", "iteration$delegate", "iterations", "getIterations", "setIterations", "iterations$delegate", "", "lastFrameNanos", "getLastFrameNanos", "()J", "setLastFrameNanos", "(J)V", "lastFrameNanos$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "progress", "getProgress", "setProgress", "(F)V", "progress$delegate", "speed", "getSpeed", "setSpeed", "speed$delegate", "value", "getValue", "()Ljava/lang/Float;", "animate", "", "initialProgress", "continueFromPreviousAnimate", "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimationsDisabled", "(Lcom/airbnb/lottie/LottieComposition;IIFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFrame", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFrame", "frameNanos", "snapTo", "resetLastFrameNanos", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Stable
final class LottieAnimatableImpl implements LottieAnimatable {
    @NotNull
    private final MutableState clipSpec$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState composition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final State endProgress$delegate = SnapshotStateKt.derivedStateOf(new LottieAnimatableImpl$endProgress$2(this));
    @NotNull
    private final State isAtEnd$delegate = SnapshotStateKt.derivedStateOf(new LottieAnimatableImpl$isAtEnd$2(this));
    @NotNull
    private final MutableState isPlaying$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState iteration$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState iterations$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState lastFrameNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.MIN_VALUE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutatorMutex mutex = new MutatorMutex();
    @NotNull
    private final MutableState progress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState speed$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);

    /* access modifiers changed from: private */
    public final Object doFrame(int i11, Continuation<? super Boolean> continuation) {
        if (i11 == Integer.MAX_VALUE) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new LottieAnimatableImpl$doFrame$2(this, i11), continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new LottieAnimatableImpl$doFrame$3(this, i11), continuation);
    }

    /* access modifiers changed from: private */
    public final float getEndProgress() {
        return ((Number) this.endProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final boolean onFrame(int i11, long j11) {
        long j12;
        float f11;
        float f12;
        float f13;
        float f14;
        LottieComposition composition = getComposition();
        if (composition == null) {
            return true;
        }
        if (getLastFrameNanos() == Long.MIN_VALUE) {
            j12 = 0;
        } else {
            j12 = j11 - getLastFrameNanos();
        }
        setLastFrameNanos(j11);
        LottieClipSpec clipSpec = getClipSpec();
        if (clipSpec == null) {
            f11 = 0.0f;
        } else {
            f11 = clipSpec.getMinProgress$lottie_compose_release(composition);
        }
        LottieClipSpec clipSpec2 = getClipSpec();
        if (clipSpec2 == null) {
            f12 = 1.0f;
        } else {
            f12 = clipSpec2.getMaxProgress$lottie_compose_release(composition);
        }
        float duration = (((float) (j12 / ((long) 1000000))) / composition.getDuration()) * getSpeed();
        if (getSpeed() < 0.0f) {
            f13 = f11 - (getProgress() + duration);
        } else {
            f13 = (getProgress() + duration) - f12;
        }
        if (f13 < 0.0f) {
            setProgress(RangesKt___RangesKt.coerceIn(getProgress(), f11, f12) + duration);
        } else {
            float f15 = f12 - f11;
            int i12 = ((int) (f13 / f15)) + 1;
            if (getIteration() + i12 > i11) {
                setProgress(getEndProgress());
                setIteration(i11);
                return false;
            }
            setIteration(getIteration() + i12);
            float f16 = f13 - (((float) (i12 - 1)) * f15);
            if (getSpeed() < 0.0f) {
                f14 = f12 - f16;
            } else {
                f14 = f11 + f16;
            }
            setProgress(f14);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setClipSpec(LottieClipSpec lottieClipSpec) {
        this.clipSpec$delegate.setValue(lottieClipSpec);
    }

    /* access modifiers changed from: private */
    public void setComposition(LottieComposition lottieComposition) {
        this.composition$delegate.setValue(lottieComposition);
    }

    /* access modifiers changed from: private */
    public void setIteration(int i11) {
        this.iteration$delegate.setValue(Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    public void setIterations(int i11) {
        this.iterations$delegate.setValue(Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    public void setLastFrameNanos(long j11) {
        this.lastFrameNanos$delegate.setValue(Long.valueOf(j11));
    }

    /* access modifiers changed from: private */
    public void setPlaying(boolean z11) {
        this.isPlaying$delegate.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    public void setProgress(float f11) {
        this.progress$delegate.setValue(Float.valueOf(f11));
    }

    /* access modifiers changed from: private */
    public void setSpeed(float f11) {
        this.speed$delegate.setValue(Float.valueOf(f11));
    }

    @Nullable
    public Object animate(@Nullable LottieComposition lottieComposition, int i11, int i12, float f11, @Nullable LottieClipSpec lottieClipSpec, float f12, boolean z11, @NotNull LottieCancellationBehavior lottieCancellationBehavior, boolean z12, @NotNull Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutex, (MutatePriority) null, new LottieAnimatableImpl$animate$2(this, i11, i12, f11, lottieClipSpec, lottieComposition, f12, z11, lottieCancellationBehavior, (Continuation<? super LottieAnimatableImpl$animate$2>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    @Nullable
    public LottieClipSpec getClipSpec() {
        return (LottieClipSpec) this.clipSpec$delegate.getValue();
    }

    @Nullable
    public LottieComposition getComposition() {
        return (LottieComposition) this.composition$delegate.getValue();
    }

    public int getIteration() {
        return ((Number) this.iteration$delegate.getValue()).intValue();
    }

    public int getIterations() {
        return ((Number) this.iterations$delegate.getValue()).intValue();
    }

    public long getLastFrameNanos() {
        return ((Number) this.lastFrameNanos$delegate.getValue()).longValue();
    }

    public float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public float getSpeed() {
        return ((Number) this.speed$delegate.getValue()).floatValue();
    }

    public boolean isAtEnd() {
        return ((Boolean) this.isAtEnd$delegate.getValue()).booleanValue();
    }

    public boolean isPlaying() {
        return ((Boolean) this.isPlaying$delegate.getValue()).booleanValue();
    }

    @Nullable
    public Object snapTo(@Nullable LottieComposition lottieComposition, float f11, int i11, boolean z11, @NotNull Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutex, (MutatePriority) null, new LottieAnimatableImpl$snapTo$2(this, lottieComposition, f11, i11, z11, (Continuation<? super LottieAnimatableImpl$snapTo$2>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    @NotNull
    public Float getValue() {
        return Float.valueOf(getProgress());
    }
}
