package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0017J-\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u001dJ-\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u001fJ-\u0010 \u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b!JC\u0010\"\u001a\u00020\u0005\"\b\b\u0000\u0010#*\u00020$2\u0006\u0010\u0014\u001a\u0002H#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\u0005H\u0000¢\u0006\u0002\b+R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/compose/ui/node/OwnerSnapshotObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onCommitAffectingLayout", "Landroidx/compose/ui/node/LayoutNode;", "onCommitAffectingLayoutModifier", "onCommitAffectingLayoutModifierInLookahead", "onCommitAffectingLookaheadLayout", "onCommitAffectingLookaheadMeasure", "onCommitAffectingMeasure", "clear", "target", "clear$ui_release", "clearInvalidObservations", "clearInvalidObservations$ui_release", "observeLayoutModifierSnapshotReads", "node", "affectsLookahead", "", "block", "observeLayoutModifierSnapshotReads$ui_release", "observeLayoutSnapshotReads", "observeLayoutSnapshotReads$ui_release", "observeMeasureSnapshotReads", "observeMeasureSnapshotReads$ui_release", "observeReads", "T", "Landroidx/compose/ui/node/OwnerScope;", "onChanged", "observeReads$ui_release", "(Landroidx/compose/ui/node/OwnerScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "startObserving", "startObserving$ui_release", "stopObserving", "stopObserving$ui_release", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OwnerSnapshotObserver {
    @NotNull
    private final SnapshotStateObserver observer;
    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1.INSTANCE;
    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLayoutModifierInLookahead = OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1.INSTANCE;
    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLookaheadLayout = OwnerSnapshotObserver$onCommitAffectingLookaheadLayout$1.INSTANCE;
    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLookaheadMeasure = OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1.INSTANCE;
    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingMeasure$1.INSTANCE;

    public OwnerSnapshotObserver(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChangedExecutor");
        this.observer = new SnapshotStateObserver(function1);
    }

    public static /* synthetic */ void observeLayoutModifierSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        ownerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode, z11, function0);
    }

    public static /* synthetic */ void observeLayoutSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        ownerSnapshotObserver.observeLayoutSnapshotReads$ui_release(layoutNode, z11, function0);
    }

    public static /* synthetic */ void observeMeasureSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        ownerSnapshotObserver.observeMeasureSnapshotReads$ui_release(layoutNode, z11, function0);
    }

    public final void clear$ui_release(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "target");
        this.observer.clear(obj);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf(OwnerSnapshotObserver$clearInvalidObservations$1.INSTANCE);
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(@NotNull LayoutNode layoutNode, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!z11 || layoutNode.getMLookaheadScope$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifier, function0);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifierInLookahead, function0);
        }
    }

    public final void observeLayoutSnapshotReads$ui_release(@NotNull LayoutNode layoutNode, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!z11 || layoutNode.getMLookaheadScope$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayout, function0);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLookaheadLayout, function0);
        }
    }

    public final void observeMeasureSnapshotReads$ui_release(@NotNull LayoutNode layoutNode, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!z11 || layoutNode.getMLookaheadScope$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingMeasure, function0);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLookaheadMeasure, function0);
        }
    }

    public final <T extends OwnerScope> void observeReads$ui_release(@NotNull T t11, @NotNull Function1<? super T, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(t11, "target");
        Intrinsics.checkNotNullParameter(function1, "onChanged");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.observer.observeReads(t11, function1, function0);
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
