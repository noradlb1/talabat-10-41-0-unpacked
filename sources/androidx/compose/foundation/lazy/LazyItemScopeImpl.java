package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\u00020\f*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017ø\u0001\u0000J\u0014\u0010\u0010\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0014\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "()V", "maxHeightState", "Landroidx/compose/runtime/MutableState;", "", "maxWidthState", "setMaxSize", "", "width", "height", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "fillParentMaxHeight", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyItemScopeImpl implements LazyItemScope {
    @NotNull
    private MutableState<Integer> maxHeightState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.MAX_VALUE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private MutableState<Integer> maxWidthState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.MAX_VALUE, (SnapshotMutationPolicy) null, 2, (Object) null);

    @NotNull
    @ExperimentalFoundationApi
    public Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LazyItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1(finiteAnimationSpec);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AnimateItemPlacementModifier(finiteAnimationSpec, function1));
    }

    @NotNull
    public Modifier fillParentMaxHeight(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        MutableState<Integer> mutableState = this.maxHeightState;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LazyItemScopeImpl$fillParentMaxHeight$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ParentSizeModifier(f11, function1, (State) null, mutableState, 4, (DefaultConstructorMarker) null));
    }

    @NotNull
    public Modifier fillParentMaxSize(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        MutableState<Integer> mutableState = this.maxWidthState;
        MutableState<Integer> mutableState2 = this.maxHeightState;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LazyItemScopeImpl$fillParentMaxSize$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ParentSizeModifier(f11, function1, mutableState, mutableState2));
    }

    @NotNull
    public Modifier fillParentMaxWidth(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        MutableState<Integer> mutableState = this.maxWidthState;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LazyItemScopeImpl$fillParentMaxWidth$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ParentSizeModifier(f11, function1, mutableState, (State) null, 8, (DefaultConstructorMarker) null));
    }

    public final void setMaxSize(int i11, int i12) {
        this.maxWidthState.setValue(Integer.valueOf(i11));
        this.maxHeightState.setValue(Integer.valueOf(i12));
    }
}
