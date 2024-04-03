package androidx.compose.ui.node;

import androidx.compose.ui.node.Owner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/node/BackwardsCompatNode$initializeModifier$4", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onLayoutComplete", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BackwardsCompatNode$initializeModifier$4 implements Owner.OnLayoutCompletedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BackwardsCompatNode f9907b;

    public BackwardsCompatNode$initializeModifier$4(BackwardsCompatNode backwardsCompatNode) {
        this.f9907b = backwardsCompatNode;
    }

    public void onLayoutComplete() {
        if (this.f9907b.lastOnPlacedCoordinates == null) {
            BackwardsCompatNode backwardsCompatNode = this.f9907b;
            backwardsCompatNode.onPlaced(DelegatableNodeKt.m4588requireCoordinator64DMado(backwardsCompatNode, Nodes.INSTANCE.m4762getLayoutAwareOLwlOKw()));
        }
    }
}
