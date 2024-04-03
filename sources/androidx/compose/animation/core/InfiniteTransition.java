package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J!\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005R\u00020\u0000H\u0000¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J!\u0010\u001c\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005R\u00020\u0000H\u0000¢\u0006\u0002\b\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010 R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005R\u00020\u00000\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/animation/core/InfiniteTransition;", "", "()V", "animations", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "getAnimations$animation_core_release", "()Landroidx/compose/runtime/collection/MutableVector;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "refreshChildNeeded", "getRefreshChildNeeded", "setRefreshChildNeeded", "refreshChildNeeded$delegate", "startTimeNanos", "", "addAnimation", "", "animation", "addAnimation$animation_core_release", "onFrame", "playTimeNanos", "removeAnimation", "removeAnimation$animation_core_release", "run", "run$animation_core_release", "(Landroidx/compose/runtime/Composer;I)V", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InfiniteTransition {
    public static final int $stable = 8;
    @NotNull
    private final MutableVector<TransitionAnimationState<?, ?>> animations = new MutableVector<>(new TransitionAnimationState[16], 0);
    @NotNull
    private final MutableState isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState refreshChildNeeded$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public long startTimeNanos = Long.MIN_VALUE;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B7\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020!J\u0006\u00106\u001a\u000204J\u0006\u00107\u001a\u000204J)\u00108\u001a\u0002042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u00109R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001c\u0010\u0006\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R+\u0010.\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u00008V@PX\u0002¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019¨\u0006:"}, d2 = {"Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;)V", "animation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getInitialValue", "()Ljava/lang/Object;", "setInitialValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isFinished", "", "()Z", "setFinished", "(Z)V", "playTimeNanosOffset", "", "getPlayTimeNanosOffset", "()J", "setPlayTimeNanosOffset", "(J)V", "startOnTheNextFrame", "getStartOnTheNextFrame", "setStartOnTheNextFrame", "getTargetValue", "setTargetValue", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "<set-?>", "value", "getValue", "setValue$animation_core_release", "value$delegate", "Landroidx/compose/runtime/MutableState;", "onPlayTimeChanged", "", "playTimeNanos", "reset", "skipToEnd", "updateValues", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;)V", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        @NotNull
        private TargetBasedAnimation<T, V> animation;
        @NotNull
        private AnimationSpec<T> animationSpec;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InfiniteTransition f1325b;
        private T initialValue;
        private boolean isFinished;
        private long playTimeNanosOffset;
        private boolean startOnTheNextFrame;
        private T targetValue;
        @NotNull
        private final TwoWayConverter<T, V> typeConverter;
        @NotNull
        private final MutableState value$delegate;

        public TransitionAnimationState(InfiniteTransition infiniteTransition, T t11, @NotNull T t12, @NotNull TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec2) {
            Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
            this.f1325b = infiniteTransition;
            this.initialValue = t11;
            this.targetValue = t12;
            this.typeConverter = twoWayConverter;
            this.animationSpec = animationSpec2;
            this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t11, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.animation = new TargetBasedAnimation((AnimationSpec) this.animationSpec, (TwoWayConverter) twoWayConverter, (Object) this.initialValue, (Object) this.targetValue, (AnimationVector) null, 16, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final TargetBasedAnimation<T, V> getAnimation() {
            return this.animation;
        }

        @NotNull
        public final AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final T getInitialValue() {
            return this.initialValue;
        }

        public final long getPlayTimeNanosOffset() {
            return this.playTimeNanosOffset;
        }

        public final boolean getStartOnTheNextFrame() {
            return this.startOnTheNextFrame;
        }

        public final T getTargetValue() {
            return this.targetValue;
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public T getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public final void onPlayTimeChanged(long j11) {
            this.f1325b.setRefreshChildNeeded(false);
            if (this.startOnTheNextFrame) {
                this.startOnTheNextFrame = false;
                this.playTimeNanosOffset = j11;
            }
            long j12 = j11 - this.playTimeNanosOffset;
            setValue$animation_core_release(this.animation.getValueFromNanos(j12));
            this.isFinished = this.animation.isFinishedFromNanos(j12);
        }

        public final void reset() {
            this.startOnTheNextFrame = true;
        }

        public final void setAnimation(@NotNull TargetBasedAnimation<T, V> targetBasedAnimation) {
            Intrinsics.checkNotNullParameter(targetBasedAnimation, "<set-?>");
            this.animation = targetBasedAnimation;
        }

        public final void setAnimationSpec(@NotNull AnimationSpec<T> animationSpec2) {
            Intrinsics.checkNotNullParameter(animationSpec2, "<set-?>");
            this.animationSpec = animationSpec2;
        }

        public final void setFinished(boolean z11) {
            this.isFinished = z11;
        }

        public final void setInitialValue(T t11) {
            this.initialValue = t11;
        }

        public final void setPlayTimeNanosOffset(long j11) {
            this.playTimeNanosOffset = j11;
        }

        public final void setStartOnTheNextFrame(boolean z11) {
            this.startOnTheNextFrame = z11;
        }

        public final void setTargetValue(T t11) {
            this.targetValue = t11;
        }

        public void setValue$animation_core_release(T t11) {
            this.value$delegate.setValue(t11);
        }

        public final void skipToEnd() {
            setValue$animation_core_release(this.animation.getTargetValue());
            this.startOnTheNextFrame = true;
        }

        public final void updateValues(T t11, T t12, @NotNull AnimationSpec<T> animationSpec2) {
            Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
            this.initialValue = t11;
            this.targetValue = t12;
            this.animationSpec = animationSpec2;
            this.animation = new TargetBasedAnimation((AnimationSpec) animationSpec2, (TwoWayConverter) this.typeConverter, (Object) t11, (Object) t12, (AnimationVector) null, 16, (DefaultConstructorMarker) null);
            this.f1325b.setRefreshChildNeeded(true);
            this.isFinished = false;
            this.startOnTheNextFrame = true;
        }
    }

    private final boolean getRefreshChildNeeded() {
        return ((Boolean) this.refreshChildNeeded$delegate.getValue()).booleanValue();
    }

    private final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void onFrame(long j11) {
        boolean z11;
        MutableVector<TransitionAnimationState<?, ?>> mutableVector = this.animations;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            z11 = true;
            int i11 = 0;
            do {
                TransitionAnimationState transitionAnimationState = (TransitionAnimationState) content[i11];
                if (!transitionAnimationState.isFinished()) {
                    transitionAnimationState.onPlayTimeChanged(j11);
                }
                if (!transitionAnimationState.isFinished()) {
                    z11 = false;
                }
                i11++;
            } while (i11 < size);
        } else {
            z11 = true;
        }
        setRunning(!z11);
    }

    /* access modifiers changed from: private */
    public final void setRefreshChildNeeded(boolean z11) {
        this.refreshChildNeeded$delegate.setValue(Boolean.valueOf(z11));
    }

    private final void setRunning(boolean z11) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void addAnimation$animation_core_release(@NotNull TransitionAnimationState<?, ?> transitionAnimationState) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, Param.ANIMATION);
        this.animations.add(transitionAnimationState);
        setRefreshChildNeeded(true);
    }

    @NotNull
    public final MutableVector<TransitionAnimationState<?, ?>> getAnimations$animation_core_release() {
        return this.animations;
    }

    public final void removeAnimation$animation_core_release(@NotNull TransitionAnimationState<?, ?> transitionAnimationState) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, Param.ANIMATION);
        this.animations.remove(transitionAnimationState);
    }

    @Composable
    public final void run$animation_core_release(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-318043801);
        if (isRunning() || getRefreshChildNeeded()) {
            EffectsKt.LaunchedEffect((Object) this, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new InfiniteTransition$run$1(this, (Continuation<? super InfiniteTransition$run$1>) null), startRestartGroup, 8);
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InfiniteTransition$run$2(this, i11));
        }
    }
}
