package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a&\u0010\r\u001a\u00020\b*\u00020\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"%\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028@X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI$annotations", "(I)V", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "calculateNodeKindSetFrom", "", "element", "Landroidx/compose/ui/Modifier$Element;", "node", "Landroidx/compose/ui/Modifier$Node;", "or", "other", "or-64DMado", "(II)I", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NodeKindKt {
    public static final int calculateNodeKindSetFrom(@NotNull Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        Nodes nodes = Nodes.INSTANCE;
        int r12 = nodes.m4757getAnyOLwlOKw();
        if (element instanceof LayoutModifier) {
            r12 = m4755or64DMado(r12, nodes.m4761getLayoutOLwlOKw());
        }
        if (element instanceof IntermediateLayoutModifier) {
            r12 = m4755or64DMado(r12, nodes.m4760getIntermediateMeasureOLwlOKw());
        }
        if (element instanceof DrawModifier) {
            r12 = m4755or64DMado(r12, nodes.m4758getDrawOLwlOKw());
        }
        if (element instanceof SemanticsModifier) {
            r12 = m4755or64DMado(r12, nodes.m4766getSemanticsOLwlOKw());
        }
        if (element instanceof PointerInputModifier) {
            r12 = m4755or64DMado(r12, nodes.m4765getPointerInputOLwlOKw());
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider) || (element instanceof FocusOrderModifier)) {
            r12 = m4755or64DMado(r12, nodes.m4763getLocalsOLwlOKw());
        }
        if (element instanceof OnGloballyPositionedModifier) {
            r12 = m4755or64DMado(r12, nodes.m4759getGlobalPositionAwareOLwlOKw());
        }
        if (element instanceof ParentDataModifier) {
            r12 = m4755or64DMado(r12, nodes.m4764getParentDataOLwlOKw());
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier) || (element instanceof LookaheadOnPlacedModifier)) ? m4755or64DMado(r12, nodes.m4762getLayoutAwareOLwlOKw()) : r12;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI  reason: not valid java name */
    public static final boolean m4753getIncludeSelfInTraversalH91voCI(int i11) {
        return (i11 & Nodes.INSTANCE.m4762getLayoutAwareOLwlOKw()) != 0;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI$annotations  reason: not valid java name */
    public static /* synthetic */ void m4754getIncludeSelfInTraversalH91voCI$annotations(int i11) {
    }

    /* renamed from: or-64DMado  reason: not valid java name */
    public static final int m4755or64DMado(int i11, int i12) {
        return i11 | i12;
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Nodes nodes = Nodes.INSTANCE;
        int r12 = nodes.m4757getAnyOLwlOKw();
        if (node instanceof LayoutModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4761getLayoutOLwlOKw());
        }
        if (node instanceof DrawModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4758getDrawOLwlOKw());
        }
        if (node instanceof SemanticsModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4766getSemanticsOLwlOKw());
        }
        if (node instanceof PointerInputModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4765getPointerInputOLwlOKw());
        }
        if (node instanceof ModifierLocalNode) {
            r12 = m4755or64DMado(r12, nodes.m4763getLocalsOLwlOKw());
        }
        if (node instanceof ParentDataModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4764getParentDataOLwlOKw());
        }
        if (node instanceof LayoutAwareModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4762getLayoutAwareOLwlOKw());
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            r12 = m4755or64DMado(r12, nodes.m4759getGlobalPositionAwareOLwlOKw());
        }
        return node instanceof IntermediateLayoutModifierNode ? m4755or64DMado(r12, nodes.m4760getIntermediateMeasureOLwlOKw()) : r12;
    }
}
