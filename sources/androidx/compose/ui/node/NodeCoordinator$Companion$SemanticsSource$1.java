package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001JC\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"androidx/compose/ui/node/NodeCoordinator$Companion$SemanticsSource$1", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NodeCoordinator$Companion$SemanticsSource$1 implements NodeCoordinator.HitTestSource<SemanticsModifierNode> {
    /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
    public void m4738childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j11, @NotNull HitTestResult<SemanticsModifierNode> hitTestResult, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        layoutNode.m4622hitTestSemanticsM_7yMNQ$ui_release(j11, hitTestResult, z11, z12);
    }

    /* renamed from: entityType-OLwlOKw  reason: not valid java name */
    public int m4739entityTypeOLwlOKw() {
        return Nodes.INSTANCE.m4766getSemanticsOLwlOKw();
    }

    public boolean interceptOutOfBoundsChildEvents(@NotNull SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "node");
        return false;
    }

    public boolean shouldHitTestChildren(@NotNull LayoutNode layoutNode) {
        SemanticsConfiguration collapsedSemanticsConfiguration;
        Intrinsics.checkNotNullParameter(layoutNode, "parentLayoutNode");
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        boolean z11 = false;
        if (!(outerSemantics == null || (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) == null || !collapsedSemanticsConfiguration.isClearingSemantics())) {
            z11 = true;
        }
        return !z11;
    }
}
