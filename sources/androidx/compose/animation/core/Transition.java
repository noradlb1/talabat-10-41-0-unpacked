package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import m.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Stable
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004hijkB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B!\b\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ'\u0010I\u001a\u00020\u00192\u0018\u0010J\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bKJ\u0019\u0010L\u001a\u00020\u00192\n\u0010M\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bNJ\u0017\u0010O\u001a\u00020P2\u0006\u0010;\u001a\u00028\u0000H\u0001¢\u0006\u0004\bQ\u0010RJ\b\u0010S\u001a\u00020PH\u0002J\u001d\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020WH\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020PH\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020P2\u0006\u0010U\u001a\u00020&H\u0000¢\u0006\u0002\b\\J'\u0010]\u001a\u00020P2\u0018\u0010^\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030_R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\b`J'\u0010]\u001a\u00020P2\u0018\u0010J\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\b`J\u0019\u0010a\u001a\u00020\u00192\n\u0010M\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bbJ'\u0010c\u001a\u00020P2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010;\u001a\u00028\u00002\u0006\u0010+\u001a\u00020&H\u0007¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020P2\u0006\u0010;\u001a\u00028\u0000H\u0001¢\u0006\u0004\bg\u0010RR&\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008F@@X\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR1\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198F@@X\u0002¢\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R1\u0010+\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020&8F@FX\u0002¢\u0006\u0018\n\u0004\b/\u0010\"\u0012\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R7\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u0000008F@BX\u0002¢\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u00107\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020&8B@BX\u0002¢\u0006\u0012\n\u0004\b:\u0010\"\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R+\u0010;\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00008F@@X\u0002¢\u0006\u0012\n\u0004\b>\u0010\"\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R\u001b\u0010?\u001a\u00020&8FX\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b@\u0010(R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000f8F¢\u0006\u0006\u001a\u0004\bD\u0010\u0011R+\u0010E\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00198@@@X\u0002¢\u0006\u0012\n\u0004\bH\u0010\"\u001a\u0004\bF\u0010\u001a\"\u0004\bG\u0010 ¨\u0006l"}, d2 = {"Landroidx/compose/animation/core/Transition;", "S", "", "initialState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "_transitions", "animations", "", "getAnimations", "()Ljava/util/List;", "value", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "(Ljava/lang/Object;)V", "isRunning", "", "()Z", "<set-?>", "isSeeking", "isSeeking$annotations", "()V", "setSeeking$animation_core_release", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "", "getLastSeekedTimeNanos$animation_core_release", "()J", "setLastSeekedTimeNanos$animation_core_release", "(J)V", "playTimeNanos", "getPlayTimeNanos$annotations", "getPlayTimeNanos", "setPlayTimeNanos", "playTimeNanos$delegate", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos", "setStartTimeNanos", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "transitions", "getTransitions", "updateChildrenNeeded", "getUpdateChildrenNeeded$animation_core_release", "setUpdateChildrenNeeded$animation_core_release", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "onChildAnimationUpdated", "onFrame", "frameTimeNanos", "durationScale", "", "onFrame$animation_core_release", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Transition<S> {
    /* access modifiers changed from: private */
    @NotNull
    public final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;
    /* access modifiers changed from: private */
    @NotNull
    public final SnapshotStateList<Transition<?>> _transitions;
    @NotNull
    private final MutableState isSeeking$delegate;
    @Nullable
    private final String label;
    private long lastSeekedTimeNanos;
    @NotNull
    private final MutableState playTimeNanos$delegate;
    @NotNull
    private final MutableState segment$delegate;
    @NotNull
    private final MutableState startTimeNanos$delegate;
    @NotNull
    private final MutableState targetState$delegate;
    @NotNull
    private final State totalDurationNanos$delegate;
    @NotNull
    private final MutableTransitionState<S> transitionState;
    @NotNull
    private final MutableState updateChildrenNeeded$delegate;

    @InternalAnimationApi
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001#B#\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJT\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162#\u0010\u0017\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a0\u0018¢\u0006\u0002\b\u001b2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u00010\u0018J\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"RB\u0010\n\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "data", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class DeferredAnimation<T, V extends AnimationVector> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Transition<S> f1401a;
        @Nullable
        private Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> data;
        @NotNull
        private final String label;
        @NotNull
        private final TwoWayConverter<T, V> typeConverter;

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bk\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTargetValueByState", "()Lkotlin/jvm/functions/Function1;", "setTargetValueByState", "(Lkotlin/jvm/functions/Function1;)V", "getTransitionSpec", "setTransitionSpec", "value", "getValue", "()Ljava/lang/Object;", "updateAnimationStates", "", "segment", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            @NotNull
            private final Transition<S>.TransitionAnimationState<T, V> animation;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Transition<S>.DeferredAnimation<T, V> f1402b;
            @NotNull
            private Function1<? super S, ? extends T> targetValueByState;
            @NotNull
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(@NotNull DeferredAnimation deferredAnimation, @NotNull Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, @NotNull Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, Function1<? super S, ? extends T> function12) {
                Intrinsics.checkNotNullParameter(transitionAnimationState, Param.ANIMATION);
                Intrinsics.checkNotNullParameter(function1, "transitionSpec");
                Intrinsics.checkNotNullParameter(function12, "targetValueByState");
                this.f1402b = deferredAnimation;
                this.animation = transitionAnimationState;
                this.transitionSpec = function1;
                this.targetValueByState = function12;
            }

            @NotNull
            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            @NotNull
            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            @NotNull
            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            public T getValue() {
                updateAnimationStates(this.f1402b.f1401a.getSegment());
                return this.animation.getValue();
            }

            public final void setTargetValueByState(@NotNull Function1<? super S, ? extends T> function1) {
                Intrinsics.checkNotNullParameter(function1, "<set-?>");
                this.targetValueByState = function1;
            }

            public final void setTransitionSpec(@NotNull Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
                Intrinsics.checkNotNullParameter(function1, "<set-?>");
                this.transitionSpec = function1;
            }

            public final void updateAnimationStates(@NotNull Segment<S> segment) {
                Intrinsics.checkNotNullParameter(segment, "segment");
                Object invoke = this.targetValueByState.invoke(segment.getTargetState());
                if (this.f1402b.f1401a.isSeeking()) {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), invoke, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
                    return;
                }
                this.animation.updateTargetValue$animation_core_release(invoke, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
            }
        }

        public DeferredAnimation(@NotNull Transition transition, @NotNull TwoWayConverter<T, V> twoWayConverter, String str) {
            Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(str, "label");
            this.f1401a = transition;
            this.typeConverter = twoWayConverter;
            this.label = str;
        }

        @NotNull
        public final State<T> animate(@NotNull Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, @NotNull Function1<? super S, ? extends T> function12) {
            Intrinsics.checkNotNullParameter(function1, "transitionSpec");
            Intrinsics.checkNotNullParameter(function12, "targetValueByState");
            Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> deferredAnimationData = this.data;
            if (deferredAnimationData == null) {
                Transition<S> transition = this.f1401a;
                deferredAnimationData = new DeferredAnimationData<>(this, new TransitionAnimationState(transition, function12.invoke(transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, function12.invoke(this.f1401a.getCurrentState())), this.typeConverter, this.label), function1, function12);
                Transition<S> transition2 = this.f1401a;
                this.data = deferredAnimationData;
                transition2.addAnimation$animation_core_release(deferredAnimationData.getAnimation());
            }
            Transition<S> transition3 = this.f1401a;
            deferredAnimationData.setTargetValueByState(function12);
            deferredAnimationData.setTransitionSpec(function1);
            deferredAnimationData.updateAnimationStates(transition3.getSegment());
            return deferredAnimationData;
        }

        @Nullable
        public final Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            return this.data;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core_release(@Nullable Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            this.data = deferredAnimationData;
        }

        public final void setupSeeking$animation_core_release() {
            Transition<S>.DeferredAnimation<T, V>.DeferredAnimationData<T, V> deferredAnimationData = this.data;
            if (deferredAnimationData != null) {
                Transition<S> transition = this.f1401a;
                deferredAnimationData.getAnimation().updateInitialAndTargetValue$animation_core_release(deferredAnimationData.getTargetValueByState().invoke(transition.getSegment().getInitialState()), deferredAnimationData.getTargetValueByState().invoke(transition.getSegment().getTargetState()), deferredAnimationData.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Segment<S> {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static <S> boolean isTransitioningTo(@NotNull Segment<S> segment, S s11, S s12) {
                return c.a(segment, s11, s12);
            }
        }

        S getInitialState();

        S getTargetState();

        boolean isTransitioningTo(S s11, S s12);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        public SegmentImpl(S s11, S s12) {
            this.initialState = s11;
            this.targetState = s12;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                if (!Intrinsics.areEqual(getInitialState(), segment.getInitialState()) || !Intrinsics.areEqual(getTargetState(), segment.getTargetState())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public S getInitialState() {
            return this.initialState;
        }

        public S getTargetState() {
            return this.targetState;
        }

        public int hashCode() {
            Object initialState2 = getInitialState();
            int i11 = 0;
            int hashCode = (initialState2 != null ? initialState2.hashCode() : 0) * 31;
            Object targetState2 = getTargetState();
            if (targetState2 != null) {
                i11 = targetState2.hashCode();
            }
            return hashCode + i11;
        }

        public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
            return c.a(this, obj, obj2);
        }
    }

    @Stable
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B3\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020BH\u0000¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001dH\u0000¢\u0006\u0002\bJJ!\u0010K\u001a\u00020B2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010L\u001a\u00020!H\u0002¢\u0006\u0002\u0010MJ-\u0010N\u001a\u00020B2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u00103\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bO\u0010PJ%\u0010Q\u001a\u00020B2\u0006\u00103\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bR\u0010SRC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8F@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158F@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R+\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020!8@@@X\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R+\u0010*\u001a\u00020!2\u0006\u0010\f\u001a\u00020!8B@BX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0014\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R+\u0010.\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001d8B@BX\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u00101R+\u00103\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018B@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R+\u0010;\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018V@PX\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0014\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u0010\u0010?\u001a\u00028\u0002X\u000e¢\u0006\u0004\n\u0002\u0010@¨\u0006T"}, d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "getLabel", "()Ljava/lang/String;", "needsReset", "getNeedsReset", "setNeedsReset", "needsReset$delegate", "offsetTimeNanos", "getOffsetTimeNanos", "setOffsetTimeNanos", "(J)V", "offsetTimeNanos$delegate", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "onPlayTimeChanged", "", "playTimeNanos", "durationScale", "", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "seekTo", "seekTo$animation_core_release", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        @NotNull
        private final MutableState animation$delegate;
        @NotNull
        private final MutableState animationSpec$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null), (SnapshotMutationPolicy) null, 2, (Object) null);

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Transition<S> f1403b;
        @NotNull
        private final FiniteAnimationSpec<T> interruptionSpec;
        @NotNull
        private final MutableState isFinished$delegate;
        @NotNull
        private final String label;
        @NotNull
        private final MutableState needsReset$delegate;
        @NotNull
        private final MutableState offsetTimeNanos$delegate;
        @NotNull
        private final MutableState targetValue$delegate;
        @NotNull
        private final TwoWayConverter<T, V> typeConverter;
        @NotNull
        private final MutableState value$delegate;
        @NotNull
        private V velocityVector;

        public TransitionAnimationState(Transition transition, @NotNull T t11, @NotNull V v11, @NotNull TwoWayConverter<T, V> twoWayConverter, String str) {
            Object obj;
            Intrinsics.checkNotNullParameter(v11, "initialVelocityVector");
            Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(str, "label");
            this.f1403b = transition;
            this.typeConverter = twoWayConverter;
            this.label = str;
            this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t11, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.animation$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), twoWayConverter, t11, getTargetValue(), v11), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.isFinished$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.offsetTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.needsReset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t11, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.velocityVector = v11;
            Float f11 = (Float) VisibilityThresholdsKt.getVisibilityThresholdMap().get(twoWayConverter);
            if (f11 != null) {
                float floatValue = f11.floatValue();
                AnimationVector animationVector = (AnimationVector) twoWayConverter.getConvertToVector().invoke(t11);
                int size$animation_core_release = animationVector.getSize$animation_core_release();
                for (int i11 = 0; i11 < size$animation_core_release; i11++) {
                    animationVector.set$animation_core_release(i11, floatValue);
                }
                obj = this.typeConverter.getConvertFromVector().invoke(animationVector);
            } else {
                obj = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, obj, 3, (Object) null);
        }

        public static /* synthetic */ void a(TransitionAnimationState transitionAnimationState, Object obj, boolean z11, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            transitionAnimationState.updateAnimation(obj, z11);
        }

        private final boolean getNeedsReset() {
            return ((Boolean) this.needsReset$delegate.getValue()).booleanValue();
        }

        private final long getOffsetTimeNanos() {
            return ((Number) this.offsetTimeNanos$delegate.getValue()).longValue();
        }

        private final T getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            this.animation$delegate.setValue(targetBasedAnimation);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
        }

        private final void setNeedsReset(boolean z11) {
            this.needsReset$delegate.setValue(Boolean.valueOf(z11));
        }

        private final void setOffsetTimeNanos(long j11) {
            this.offsetTimeNanos$delegate.setValue(Long.valueOf(j11));
        }

        private final void setTargetValue(T t11) {
            this.targetValue$delegate.setValue(t11);
        }

        private final void updateAnimation(T t11, boolean z11) {
            FiniteAnimationSpec<T> finiteAnimationSpec;
            if (!z11) {
                finiteAnimationSpec = getAnimationSpec();
            } else if (getAnimationSpec() instanceof SpringSpec) {
                finiteAnimationSpec = getAnimationSpec();
            } else {
                finiteAnimationSpec = this.interruptionSpec;
            }
            setAnimation(new TargetBasedAnimation(finiteAnimationSpec, this.typeConverter, t11, getTargetValue(), this.velocityVector));
            this.f1403b.onChildAnimationUpdated();
        }

        @NotNull
        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        @NotNull
        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        public final long getDurationNanos$animation_core_release() {
            return getAnimation().getDurationNanos();
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public T getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        public final void onPlayTimeChanged$animation_core_release(long j11, float f11) {
            boolean z11;
            long j12;
            if (f11 == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                j12 = getAnimation().getDurationNanos();
            } else {
                j12 = (long) (((float) (j11 - getOffsetTimeNanos())) / f11);
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(j12));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(j12);
            if (getAnimation().isFinishedFromNanos(j12)) {
                setFinished$animation_core_release(true);
                setOffsetTimeNanos(0);
            }
        }

        public final void resetAnimation$animation_core_release() {
            setNeedsReset(true);
        }

        public final void seekTo$animation_core_release(long j11) {
            setValue$animation_core_release(getAnimation().getValueFromNanos(j11));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(j11);
        }

        public final void setFinished$animation_core_release(boolean z11) {
            this.isFinished$delegate.setValue(Boolean.valueOf(z11));
        }

        public void setValue$animation_core_release(T t11) {
            this.value$delegate.setValue(t11);
        }

        public final void updateInitialAndTargetValue$animation_core_release(T t11, T t12, @NotNull FiniteAnimationSpec<T> finiteAnimationSpec) {
            Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
            setTargetValue(t12);
            setAnimationSpec(finiteAnimationSpec);
            if (!Intrinsics.areEqual(getAnimation().getInitialValue(), (Object) t11) || !Intrinsics.areEqual(getAnimation().getTargetValue(), (Object) t12)) {
                a(this, t11, false, 2, (Object) null);
            }
        }

        public final void updateTargetValue$animation_core_release(T t11, @NotNull FiniteAnimationSpec<T> finiteAnimationSpec) {
            Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
            if (!Intrinsics.areEqual(getTargetValue(), (Object) t11) || getNeedsReset()) {
                setTargetValue(t11);
                setAnimationSpec(finiteAnimationSpec);
                a(this, (Object) null, !isFinished$animation_core_release(), 1, (Object) null);
                setFinished$animation_core_release(false);
                setOffsetTimeNanos(this.f1403b.getPlayTimeNanos());
                setNeedsReset(false);
            }
        }
    }

    @PublishedApi
    public Transition(@NotNull MutableTransitionState<S> mutableTransitionState, @Nullable String str) {
        Intrinsics.checkNotNullParameter(mutableTransitionState, "transitionState");
        this.transitionState = mutableTransitionState;
        this.label = str;
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.segment$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.playTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.startTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.MIN_VALUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.updateChildrenNeeded$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new Transition$totalDurationNanos$2(this));
    }

    @InternalAnimationApi
    public static /* synthetic */ void getPlayTimeNanos$annotations() {
    }

    private final long getStartTimeNanos() {
        return ((Number) this.startTimeNanos$delegate.getValue()).longValue();
    }

    @InternalAnimationApi
    public static /* synthetic */ void isSeeking$annotations() {
    }

    /* access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded$animation_core_release(true);
        if (isSeeking()) {
            long j11 = 0;
            for (TransitionAnimationState next : this._animations) {
                j11 = Math.max(j11, next.getDurationNanos$animation_core_release());
                next.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded$animation_core_release(false);
        }
    }

    private final void setSegment(Segment<S> segment) {
        this.segment$delegate.setValue(segment);
    }

    private final void setStartTimeNanos(long j11) {
        this.startTimeNanos$delegate.setValue(Long.valueOf(j11));
    }

    public final boolean addAnimation$animation_core_release(@NotNull Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, Param.ANIMATION);
        return this._animations.add(transitionAnimationState);
    }

    public final boolean addTransition$animation_core_release(@NotNull Transition<?> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        return this._transitions.add(transition);
    }

    @Composable
    public final void animateTo$animation_core_release(S s11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-1493585151);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) s11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (!isSeeking()) {
            updateTarget$animation_core_release(s11, startRestartGroup, (i12 & 14) | (i12 & 112));
            if (!Intrinsics.areEqual((Object) s11, getCurrentState()) || isRunning() || getUpdateChildrenNeeded$animation_core_release()) {
                int i15 = (i12 >> 3) & 14;
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed = startRestartGroup.changed((Object) this);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Transition$animateTo$1$1(this, (Continuation<? super Transition$animateTo$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect((Object) this, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, startRestartGroup, i15);
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Transition$animateTo$2(this, s11, i11));
        }
    }

    @NotNull
    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core_release() {
        return this.lastSeekedTimeNanos;
    }

    public final long getPlayTimeNanos() {
        return ((Number) this.playTimeNanos$delegate.getValue()).longValue();
    }

    @NotNull
    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final S getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    @NotNull
    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public final boolean getUpdateChildrenNeeded$animation_core_release() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    public final boolean isRunning() {
        return getStartTimeNanos() != Long.MIN_VALUE;
    }

    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void onFrame$animation_core_release(long j11, float f11) {
        if (getStartTimeNanos() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(j11);
        }
        setUpdateChildrenNeeded$animation_core_release(false);
        setPlayTimeNanos(j11 - getStartTimeNanos());
        boolean z11 = true;
        for (TransitionAnimationState next : this._animations) {
            if (!next.isFinished$animation_core_release()) {
                next.onPlayTimeChanged$animation_core_release(getPlayTimeNanos(), f11);
            }
            if (!next.isFinished$animation_core_release()) {
                z11 = false;
            }
        }
        for (Transition next2 : this._transitions) {
            if (!Intrinsics.areEqual(next2.getTargetState(), next2.getCurrentState())) {
                next2.onFrame$animation_core_release(getPlayTimeNanos(), f11);
            }
            if (!Intrinsics.areEqual(next2.getTargetState(), next2.getCurrentState())) {
                z11 = false;
            }
        }
        if (z11) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos(Long.MIN_VALUE);
        setCurrentState$animation_core_release(getTargetState());
        setPlayTimeNanos(0);
        this.transitionState.setRunning$animation_core_release(false);
    }

    public final void onTransitionStart$animation_core_release(long j11) {
        setStartTimeNanos(j11);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void removeAnimation$animation_core_release(@NotNull Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, Param.ANIMATION);
        this._animations.remove((Object) transitionAnimationState);
    }

    public final boolean removeTransition$animation_core_release(@NotNull Transition<?> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        return this._transitions.remove((Object) transition);
    }

    @JvmName(name = "seek")
    public final void seek(S s11, S s12, long j11) {
        setStartTimeNanos(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), (Object) s11) || !Intrinsics.areEqual(getTargetState(), (Object) s12)) {
            setCurrentState$animation_core_release(s11);
            setTargetState$animation_core_release(s12);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(s11, s12));
        }
        for (Transition next : this._transitions) {
            if (next.isSeeking()) {
                next.seek(next.getCurrentState(), next.getTargetState(), j11);
            }
        }
        for (Transition<S>.TransitionAnimationState<?, ?> seekTo$animation_core_release : this._animations) {
            seekTo$animation_core_release.seekTo$animation_core_release(j11);
        }
        this.lastSeekedTimeNanos = j11;
    }

    public final void setCurrentState$animation_core_release(S s11) {
        this.transitionState.setCurrentState$animation_core_release(s11);
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long j11) {
        this.lastSeekedTimeNanos = j11;
    }

    public final void setPlayTimeNanos(long j11) {
        this.playTimeNanos$delegate.setValue(Long.valueOf(j11));
    }

    public final void setSeeking$animation_core_release(boolean z11) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setTargetState$animation_core_release(S s11) {
        this.targetState$delegate.setValue(s11);
    }

    public final void setUpdateChildrenNeeded$animation_core_release(boolean z11) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(z11));
    }

    @Composable
    public final void updateTarget$animation_core_release(S s11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-583974681);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) s11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (!isSeeking() && !Intrinsics.areEqual(getTargetState(), (Object) s11)) {
            setSegment(new SegmentImpl(getTargetState(), s11));
            setCurrentState$animation_core_release(getTargetState());
            setTargetState$animation_core_release(s11);
            if (!isRunning()) {
                setUpdateChildrenNeeded$animation_core_release(true);
            }
            for (Transition<S>.TransitionAnimationState<?, ?> resetAnimation$animation_core_release : this._animations) {
                resetAnimation$animation_core_release.resetAnimation$animation_core_release();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Transition$updateTarget$2(this, s11, i11));
        }
    }

    public final void removeAnimation$animation_core_release(@NotNull Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        TransitionAnimationState<?, ?> animation;
        Intrinsics.checkNotNullParameter(deferredAnimation, "deferredAnimation");
        DeferredAnimation.DeferredAnimationData<?, ?> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release != null && (animation = data$animation_core_release.getAnimation()) != null) {
            removeAnimation$animation_core_release((Transition<S>.TransitionAnimationState<?, ?>) animation);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Transition(MutableTransitionState mutableTransitionState, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableTransitionState, (i11 & 2) != 0 ? null : str);
    }

    public Transition(S s11, @Nullable String str) {
        this(new MutableTransitionState(s11), str);
    }
}
