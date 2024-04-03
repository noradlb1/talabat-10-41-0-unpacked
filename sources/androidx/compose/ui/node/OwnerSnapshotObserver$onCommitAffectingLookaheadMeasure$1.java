package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1 INSTANCE = new OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1();

    public OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (layoutNode.isValid()) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, false, 1, (Object) null);
        }
    }
}
