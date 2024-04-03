package k0;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.Nodes;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class b {
    public static Object a(ModifierLocalNode modifierLocalNode, @NotNull ModifierLocal modifierLocal) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        if (modifierLocalNode.getNode().isAttached()) {
            int r02 = Nodes.INSTANCE.m4763getLocalsOLwlOKw();
            if (modifierLocalNode.getNode().isAttached()) {
                Modifier.Node parent$ui_release = modifierLocalNode.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(modifierLocalNode);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r02) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & r02) != 0 && (parent$ui_release instanceof ModifierLocalNode)) {
                                ModifierLocalNode modifierLocalNode2 = (ModifierLocalNode) parent$ui_release;
                                if (modifierLocalNode2.getProvidedValues().contains$ui_release(modifierLocal)) {
                                    return modifierLocalNode2.getProvidedValues().get$ui_release(modifierLocal);
                                }
                            }
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    if (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) {
                        parent$ui_release = null;
                    } else {
                        parent$ui_release = nodes$ui_release.getTail$ui_release();
                    }
                }
                return modifierLocal.getDefaultFactory$ui_release().invoke();
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public static ModifierLocalMap b(ModifierLocalNode modifierLocalNode) {
        return EmptyMap.INSTANCE;
    }

    public static void c(ModifierLocalNode modifierLocalNode, @NotNull ModifierLocal modifierLocal, Object obj) {
        boolean z11;
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        if (modifierLocalNode.getProvidedValues() != EmptyMap.INSTANCE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap".toString());
        } else if (modifierLocalNode.getProvidedValues().contains$ui_release(modifierLocal)) {
            modifierLocalNode.getProvidedValues().set$ui_release(modifierLocal, obj);
        } else {
            throw new IllegalArgumentException(("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + modifierLocal + " was not found.").toString());
        }
    }
}
