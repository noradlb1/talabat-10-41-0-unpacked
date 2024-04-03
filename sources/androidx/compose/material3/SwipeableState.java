package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import o.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalMaterial3Api
@Stable
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0011\u0018\u0000 x*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001xBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ'\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010aJ+\u0010b\u001a\u00020^2\u0006\u0010O\u001a\u00028\u00002\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ!\u0010f\u001a\u00020^2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\bhJ\u0015\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u0006H\u0000¢\u0006\u0002\bkJ\u001b\u0010l\u001a\u00020^2\u0006\u0010m\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ;\u0010p\u001a\u00020^2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H@ø\u0001\u0000¢\u0006\u0004\br\u0010sJ\u0019\u0010t\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010oJ\u001b\u0010u\u001a\u00020^2\u0006\u0010O\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\bv\u0010wR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR+\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u00068@X\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R+\u0010-\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001103X\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u00107R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060<8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060<8F¢\u0006\u0006\u001a\u0004\bA\u0010>R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D8@X\u0004¢\u0006\f\u0012\u0004\bE\u0010&\u001a\u0004\bF\u0010GR/\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\u0010\u001a\u0004\u0018\u00010H8@@@X\u0002¢\u0006\u0012\n\u0004\bN\u0010\u0018\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010O\u001a\u00028\u00008@X\u0004¢\u0006\f\u0012\u0004\bP\u0010&\u001a\u0004\bQ\u0010 RO\u0010S\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R8@@@X\u0002¢\u0006\u0012\n\u0004\bX\u0010\u0018\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR+\u0010Y\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u0018\u001a\u0004\bZ\u0010(\"\u0004\b[\u00107\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, d2 = {"Landroidx/compose/material3/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableState;", "<set-?>", "", "anchors", "getAnchors$material3_release", "()Ljava/util/Map;", "setAnchors$material3_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material3_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getConfirmStateChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection$material3_release$annotations", "()V", "getDirection$material3_release", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material3_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$material3_release", "setMaxBound$material3_release", "(F)V", "minBound", "getMinBound$material3_release", "setMinBound$material3_release", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "offsetState", "overflow", "getOverflow", "overflowState", "progress", "Landroidx/compose/material3/SwipeProgress;", "getProgress$material3_release$annotations", "getProgress$material3_release", "()Landroidx/compose/material3/SwipeProgress;", "Landroidx/compose/material3/ResistanceConfig;", "resistance", "getResistance$material3_release", "()Landroidx/compose/material3/ResistanceConfig;", "setResistance$material3_release", "(Landroidx/compose/material3/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue$material3_release$annotations", "getTargetValue$material3_release", "Lkotlin/Function2;", "thresholds", "getThresholds$material3_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material3_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$material3_release", "setVelocityThreshold$material3_release", "velocityThreshold$delegate", "animateInternalToOffset", "", "target", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "animateTo$material3_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$material3_release", "performDrag", "delta", "performDrag$material3_release", "performFling", "velocity", "performFling$material3_release", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$material3_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "snapTo$material3_release", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SwipeableState<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public final MutableState<Float> absoluteOffset;
    @NotNull
    private final MutableState anchors$delegate;
    @NotNull
    private final AnimationSpec<Float> animationSpec;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableState<Float> animationTarget;
    @NotNull
    private final Function1<T, Boolean> confirmStateChange;
    @NotNull
    private final MutableState currentValue$delegate;
    @NotNull
    private final DraggableState draggableState;
    @NotNull
    private final MutableState isAnimationRunning$delegate;
    @NotNull
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableState<Float> offsetState;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableState<Float> overflowState;
    @NotNull
    private final MutableState resistance$delegate;
    @NotNull
    private final MutableState thresholds$delegate;
    @NotNull
    private final MutableState velocityThreshold$delegate;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/material3/SwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> Saver<SwipeableState<T>, T> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super T, Boolean> function1) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            return SaverKt.Saver(SwipeableState$Companion$Saver$1.INSTANCE, new SwipeableState$Companion$Saver$2(animationSpec, function1));
        }
    }

    public SwipeableState(T t11, @NotNull AnimationSpec<Float> animationSpec2, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        this.animationSpec = animationSpec2;
        this.confirmStateChange = function1;
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t11, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isAnimationRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        Float valueOf = Float.valueOf(0.0f);
        this.offsetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.overflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.absoluteOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt__MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new SwipeableState$special$$inlined$filter$1(SnapshotStateKt.snapshotFlow(new SwipeableState$latestNonEmptyAnchorsFlow$1(this))), 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SwipeableState$thresholds$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.velocityThreshold$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.resistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggableState = DraggableKt.DraggableState(new SwipeableState$draggableState$1(this));
    }

    /* access modifiers changed from: private */
    public final Object animateInternalToOffset(float f11, AnimationSpec<Float> animationSpec2, Continuation<? super Unit> continuation) {
        Object a11 = a.a(this.draggableState, (MutatePriority) null, new SwipeableState$animateInternalToOffset$2(this, f11, animationSpec2, (Continuation<? super SwipeableState$animateInternalToOffset$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material3_release$default(SwipeableState swipeableState, Object obj, AnimationSpec<Float> animationSpec2, Continuation continuation, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                animationSpec2 = swipeableState.animationSpec;
            }
            return swipeableState.animateTo$material3_release(obj, animationSpec2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getDirection$material3_release$annotations() {
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getProgress$material3_release$annotations() {
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getTargetValue$material3_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final void setAnimationRunning(boolean z11) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    public final void setCurrentValue(T t11) {
        this.currentValue$delegate.setValue(t11);
    }

    /* access modifiers changed from: private */
    public final Object snapInternalToOffset(float f11, Continuation<? super Unit> continuation) {
        Object a11 = a.a(this.draggableState, (MutatePriority) null, new SwipeableState$snapInternalToOffset$2(f11, this, (Continuation<? super SwipeableState$snapInternalToOffset$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    @Nullable
    @ExperimentalMaterial3Api
    public final Object animateTo$material3_release(T t11, @NotNull AnimationSpec<Float> animationSpec2, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$animateTo$2(t11, this, animationSpec2), continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void ensureInit$material3_release(@NotNull Map<Float, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "newAnchors");
        if (getAnchors$material3_release().isEmpty()) {
            Float access$getOffset = SwipeableKt.getOffset(map, getCurrentValue());
            if (access$getOffset != null) {
                this.offsetState.setValue(access$getOffset);
                this.absoluteOffset.setValue(access$getOffset);
                return;
            }
            throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
        }
    }

    @NotNull
    public final Map<Float, T> getAnchors$material3_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    @NotNull
    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    @NotNull
    public final Function1<T, Boolean> getConfirmStateChange$material3_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final float getDirection$material3_release() {
        Float access$getOffset = SwipeableKt.getOffset(getAnchors$material3_release(), getCurrentValue());
        if (access$getOffset == null) {
            return 0.0f;
        }
        return Math.signum(getOffset().getValue().floatValue() - access$getOffset.floatValue());
    }

    @NotNull
    public final DraggableState getDraggableState$material3_release() {
        return this.draggableState;
    }

    public final float getMaxBound$material3_release() {
        return this.maxBound;
    }

    public final float getMinBound$material3_release() {
        return this.minBound;
    }

    @NotNull
    public final State<Float> getOffset() {
        return this.offsetState;
    }

    @NotNull
    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    @NotNull
    public final SwipeProgress<T> getProgress$material3_release() {
        Object obj;
        Object obj2;
        float f11;
        Pair pair;
        List access$findBounds = SwipeableKt.findBounds(getOffset().getValue().floatValue(), getAnchors$material3_release().keySet());
        int size = access$findBounds.size();
        if (size == 0) {
            Object currentValue = getCurrentValue();
            obj = getCurrentValue();
            obj2 = currentValue;
            f11 = 1.0f;
        } else if (size != 1) {
            if (getDirection$material3_release() > 0.0f) {
                pair = TuplesKt.to(access$findBounds.get(0), access$findBounds.get(1));
            } else {
                pair = TuplesKt.to(access$findBounds.get(1), access$findBounds.get(0));
            }
            float floatValue = ((Number) pair.component1()).floatValue();
            float floatValue2 = ((Number) pair.component2()).floatValue();
            obj2 = MapsKt__MapsKt.getValue(getAnchors$material3_release(), Float.valueOf(floatValue));
            obj = MapsKt__MapsKt.getValue(getAnchors$material3_release(), Float.valueOf(floatValue2));
            f11 = (getOffset().getValue().floatValue() - floatValue) / (floatValue2 - floatValue);
        } else {
            Object value = MapsKt__MapsKt.getValue(getAnchors$material3_release(), access$findBounds.get(0));
            obj = MapsKt__MapsKt.getValue(getAnchors$material3_release(), access$findBounds.get(0));
            f11 = 1.0f;
            obj2 = value;
        }
        return new SwipeProgress<>(obj2, obj, f11);
    }

    @Nullable
    public final ResistanceConfig getResistance$material3_release() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final T getTargetValue$material3_release() {
        float f11;
        float f12;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            f11 = value.floatValue();
        } else {
            float floatValue = getOffset().getValue().floatValue();
            Float access$getOffset = SwipeableKt.getOffset(getAnchors$material3_release(), getCurrentValue());
            if (access$getOffset != null) {
                f12 = access$getOffset.floatValue();
            } else {
                f12 = getOffset().getValue().floatValue();
            }
            f11 = SwipeableKt.computeTarget(floatValue, f12, getAnchors$material3_release().keySet(), getThresholds$material3_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t11 = getAnchors$material3_release().get(Float.valueOf(f11));
        if (t11 == null) {
            return getCurrentValue();
        }
        return t11;
    }

    @NotNull
    public final Function2<Float, Float, Float> getThresholds$material3_release() {
        return (Function2) this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material3_release() {
        return ((Number) this.velocityThreshold$delegate.getValue()).floatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final float performDrag$material3_release(float f11) {
        float coerceIn = RangesKt___RangesKt.coerceIn(this.absoluteOffset.getValue().floatValue() + f11, this.minBound, this.maxBound) - this.absoluteOffset.getValue().floatValue();
        if (Math.abs(coerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(coerceIn);
        }
        return coerceIn;
    }

    @Nullable
    public final Object performFling$material3_release(float f11, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$performFling$2(this, f11), continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:17|18|19|79|80|(1:82)(4:83|84|87|88)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x01ff */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x020d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processNewAnchors$material3_release(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r10, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.SwipeableState$processNewAnchors$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.material3.SwipeableState$processNewAnchors$1 r0 = (androidx.compose.material3.SwipeableState$processNewAnchors$1) r0
            int r1 = r0.f8461m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8461m = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.SwipeableState$processNewAnchors$1 r0 = new androidx.compose.material3.SwipeableState$processNewAnchors$1
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f8459k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8461m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005c
            if (r2 == r5) goto L_0x0058
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            float r10 = r0.f8458j
            java.lang.Object r11 = r0.f8457i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r0 = r0.f8456h
            androidx.compose.material3.SwipeableState r0 = (androidx.compose.material3.SwipeableState) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x003a }
            goto L_0x020f
        L_0x003a:
            r12 = move-exception
            goto L_0x023d
        L_0x003d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0045:
            float r10 = r0.f8458j
            java.lang.Object r11 = r0.f8457i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r2 = r0.f8456h
            androidx.compose.material3.SwipeableState r2 = (androidx.compose.material3.SwipeableState) r2
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x01ff }
            goto L_0x01cd
        L_0x0054:
            r12 = move-exception
            r0 = r2
            goto L_0x023d
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x009e
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L_0x00ad
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.minOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r9.minBound = r10
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.maxOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r9.maxBound = r10
            java.lang.Object r10 = r9.getCurrentValue()
            java.lang.Float r10 = androidx.compose.material3.SwipeableKt.getOffset(r11, r10)
            if (r10 == 0) goto L_0x00a1
            float r10 = r10.floatValue()
            r0.f8461m = r5
            java.lang.Object r10 = r9.snapInternalToOffset(r10, r0)
            if (r10 != r1) goto L_0x009e
            return r1
        L_0x009e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00a1:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "The initial value must have an associated anchor."
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x00ad:
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r10)
            if (r12 != 0) goto L_0x026b
            r12 = -8388608(0xffffffffff800000, float:-Infinity)
            r9.minBound = r12
            r12 = 2139095040(0x7f800000, float:Infinity)
            r9.maxBound = r12
            androidx.compose.runtime.MutableState<java.lang.Float> r12 = r9.animationTarget
            java.lang.Object r12 = r12.getValue()
            java.lang.Float r12 = (java.lang.Float) r12
            r2 = 0
            if (r12 == 0) goto L_0x012d
            java.lang.Object r10 = r10.get(r12)
            java.lang.Float r10 = androidx.compose.material3.SwipeableKt.getOffset(r11, r10)
            if (r10 == 0) goto L_0x00d6
            float r10 = r10.floatValue()
            goto L_0x01bb
        L_0x00d6:
            java.util.Set r10 = r11.keySet()
            java.util.Iterator r5 = r10.iterator()
            boolean r10 = r5.hasNext()
            if (r10 != 0) goto L_0x00e5
            goto L_0x0122
        L_0x00e5:
            java.lang.Object r2 = r5.next()
            boolean r10 = r5.hasNext()
            if (r10 != 0) goto L_0x00f0
            goto L_0x0122
        L_0x00f0:
            r10 = r2
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            float r6 = r12.floatValue()
            float r10 = r10 - r6
            float r10 = java.lang.Math.abs(r10)
        L_0x0100:
            java.lang.Object r6 = r5.next()
            r7 = r6
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r8 = r12.floatValue()
            float r7 = r7 - r8
            float r7 = java.lang.Math.abs(r7)
            int r8 = java.lang.Float.compare(r10, r7)
            if (r8 <= 0) goto L_0x011c
            r2 = r6
            r10 = r7
        L_0x011c:
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x0100
        L_0x0122:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            float r10 = r2.floatValue()
            goto L_0x01bb
        L_0x012d:
            androidx.compose.runtime.State r12 = r9.getOffset()
            java.lang.Object r12 = r12.getValue()
            java.lang.Object r10 = r10.get(r12)
            java.lang.Object r12 = r9.getCurrentValue()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0147
            java.lang.Object r10 = r9.getCurrentValue()
        L_0x0147:
            java.lang.Float r10 = androidx.compose.material3.SwipeableKt.getOffset(r11, r10)
            if (r10 == 0) goto L_0x0152
            float r10 = r10.floatValue()
            goto L_0x01bb
        L_0x0152:
            java.util.Set r10 = r11.keySet()
            java.util.Iterator r10 = r10.iterator()
            boolean r12 = r10.hasNext()
            if (r12 != 0) goto L_0x0161
            goto L_0x01b2
        L_0x0161:
            java.lang.Object r2 = r10.next()
            boolean r12 = r10.hasNext()
            if (r12 != 0) goto L_0x016c
            goto L_0x01b2
        L_0x016c:
            r12 = r2
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.runtime.State r5 = r9.getOffset()
            java.lang.Object r5 = r5.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r12 = r12 - r5
            float r12 = java.lang.Math.abs(r12)
        L_0x0186:
            java.lang.Object r5 = r10.next()
            r6 = r5
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.runtime.State r7 = r9.getOffset()
            java.lang.Object r7 = r7.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r6 = r6 - r7
            float r6 = java.lang.Math.abs(r6)
            int r7 = java.lang.Float.compare(r12, r6)
            if (r7 <= 0) goto L_0x01ac
            r2 = r5
            r12 = r6
        L_0x01ac:
            boolean r5 = r10.hasNext()
            if (r5 != 0) goto L_0x0186
        L_0x01b2:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            float r10 = r2.floatValue()
        L_0x01bb:
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r12 = r9.animationSpec     // Catch:{ CancellationException -> 0x01fe, all -> 0x01fb }
            r0.f8456h = r9     // Catch:{ CancellationException -> 0x01fe, all -> 0x01fb }
            r0.f8457i = r11     // Catch:{ CancellationException -> 0x01fe, all -> 0x01fb }
            r0.f8458j = r10     // Catch:{ CancellationException -> 0x01fe, all -> 0x01fb }
            r0.f8461m = r4     // Catch:{ CancellationException -> 0x01fe, all -> 0x01fb }
            java.lang.Object r12 = r9.animateInternalToOffset(r10, r12, r0)     // Catch:{ CancellationException -> 0x01fe, all -> 0x01fb }
            if (r12 != r1) goto L_0x01cc
            return r1
        L_0x01cc:
            r2 = r9
        L_0x01cd:
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            java.lang.Object r10 = kotlin.collections.MapsKt__MapsKt.getValue(r11, r10)
            r2.setCurrentValue(r10)
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.minOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r2.minBound = r10
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.maxOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r2.maxBound = r10
            goto L_0x026b
        L_0x01fb:
            r12 = move-exception
            r0 = r9
            goto L_0x023d
        L_0x01fe:
            r2 = r9
        L_0x01ff:
            r0.f8456h = r2     // Catch:{ all -> 0x0054 }
            r0.f8457i = r11     // Catch:{ all -> 0x0054 }
            r0.f8458j = r10     // Catch:{ all -> 0x0054 }
            r0.f8461m = r3     // Catch:{ all -> 0x0054 }
            java.lang.Object r12 = r2.snapInternalToOffset(r10, r0)     // Catch:{ all -> 0x0054 }
            if (r12 != r1) goto L_0x020e
            return r1
        L_0x020e:
            r0 = r2
        L_0x020f:
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            java.lang.Object r10 = kotlin.collections.MapsKt__MapsKt.getValue(r11, r10)
            r0.setCurrentValue(r10)
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.minOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r0.minBound = r10
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.maxOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r0.maxBound = r10
            goto L_0x026b
        L_0x023d:
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            java.lang.Object r10 = kotlin.collections.MapsKt__MapsKt.getValue(r11, r10)
            r0.setCurrentValue(r10)
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.minOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r0.minBound = r10
            java.util.Set r10 = r11.keySet()
            java.lang.Float r10 = kotlin.collections.CollectionsKt.maxOrNull((java.lang.Iterable) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r0.maxBound = r10
            throw r12
        L_0x026b:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableState.processNewAnchors$material3_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setAnchors$material3_release(@NotNull Map<Float, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final void setMaxBound$material3_release(float f11) {
        this.maxBound = f11;
    }

    public final void setMinBound$material3_release(float f11) {
        this.minBound = f11;
    }

    public final void setResistance$material3_release(@Nullable ResistanceConfig resistanceConfig) {
        this.resistance$delegate.setValue(resistanceConfig);
    }

    public final void setThresholds$material3_release(@NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.thresholds$delegate.setValue(function2);
    }

    public final void setVelocityThreshold$material3_release(float f11) {
        this.velocityThreshold$delegate.setValue(Float.valueOf(f11));
    }

    @Nullable
    @ExperimentalMaterial3Api
    public final Object snapTo$material3_release(T t11, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$snapTo$2(t11, this), continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec2, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i11 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec$material3_release() : animationSpec2, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }
}
