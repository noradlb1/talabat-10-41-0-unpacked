package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a2\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a2\u0010\u0012\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000f\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a6\u0010\u0014\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0015*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000f\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a%\u0010\u0017\u001a\u00020\u0018*\u00020\u00072\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0007H\u0001\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u0007H\u0001\u001aG\u0010 \u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a,\u0010 \u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002\u001aG\u0010%\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010$\u001a,\u0010%\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002\u001aG\u0010'\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010$\u001a,\u0010'\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002\u001aG\u0010)\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u001a,\u0010)\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002\u001aG\u0010+\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010$\u001a,\u0010+\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\bø\u0001\u0002\u001aG\u0010-\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00060\"H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010$\u001a,\u0010-\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\"H\bø\u0001\u0002\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006/"}, d2 = {"addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "has", "", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "localChild", "T", "localChild-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "mask", "", "localParent", "localParent-64DMado", "nearestAncestor", "", "nearestAncestor-64DMado", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "block", "Lkotlin/Function1;", "visitAncestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "visitLocalChildren", "visitLocalChildren-6rFNWt0", "visitLocalParents", "visitLocalParents-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DelegatableNodeKt {
    /* access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node) {
        MutableVector<LayoutNode> mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i11 = size - 1;
            Object[] content = mutableVector2.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                mutableVector.add(((LayoutNode) content[i11]).getNodes$ui_release().getHead$ui_release());
                i11--;
            } while (i11 >= 0);
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: has-64DMado  reason: not valid java name */
    public static final boolean m4584has64DMado(@NotNull DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$has");
        if ((delegatableNode.getNode().getAggregateChildKindSet$ui_release() & i11) != 0) {
            return true;
        }
        return false;
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier.Node localChild(@NotNull DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & i11) == 0) {
            return null;
        }
        while (child$ui_release != null) {
            if ((child$ui_release.getKindSet$ui_release() & i11) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: localChild-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4585localChild64DMado(DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$localChild");
        T localChild = localChild(delegatableNode, i11);
        Intrinsics.reifiedOperationMarker(2, "T");
        return localChild;
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier.Node localParent(@NotNull DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i11) != 0) {
                return parent$ui_release;
            }
        }
        return null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: localParent-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4586localParent64DMado(DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$localParent");
        T localParent = localParent(delegatableNode, i11);
        Intrinsics.reifiedOperationMarker(2, "T");
        return localParent;
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier.Node nearestAncestor(@NotNull DelegatableNode delegatableNode, int i11) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i11) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & i11) != 0) {
                            return parent$ui_release;
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
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: nearestAncestor-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4587nearestAncestor64DMado(DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$nearestAncestor");
        T nearestAncestor = nearestAncestor(delegatableNode, i11);
        Intrinsics.reifiedOperationMarker(2, "T");
        return nearestAncestor;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* renamed from: requireCoordinator-64DMado  reason: not valid java name */
    public static final NodeCoordinator m4588requireCoordinator64DMado(@NotNull DelegatableNode delegatableNode, int i11) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$requireCoordinator");
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() != delegatableNode || !NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(i11)) {
            return coordinator$ui_release;
        }
        NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final LayoutNode requireLayoutNode(@NotNull DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        return coordinator$ui_release.getLayoutNode();
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Owner requireOwner(@NotNull DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Owner owner$ui_release = requireLayoutNode(delegatableNode).getOwner$ui_release();
        Intrinsics.checkNotNull(owner$ui_release);
        return owner$ui_release;
    }

    @ExperimentalComposeUiApi
    public static final void visitAncestors(@NotNull DelegatableNode delegatableNode, int i11, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i11) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & i11) != 0) {
                            function1.invoke(parent$ui_release);
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
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitAncestors-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4589visitAncestors6rFNWt0(DelegatableNode delegatableNode, int i11, Function1<? super T, Unit> function1) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitAncestors");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i11) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & i11) != 0) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(parent$ui_release);
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
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    public static final void visitChildren(@NotNull DelegatableNode delegatableNode, int i11, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i11) == 0) {
                    addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & i11) != 0) {
                            function1.invoke(node);
                            break;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4590visitChildren6rFNWt0(DelegatableNode delegatableNode, int i11, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitChildren");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i11) == 0) {
                    addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & i11) != 0) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(node);
                            break;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    public static final void visitLocalChildren(@NotNull DelegatableNode delegatableNode, int i11, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = delegatableNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & i11) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & i11) != 0) {
                        function1.invoke(child$ui_release);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitLocalChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4591visitLocalChildren6rFNWt0(DelegatableNode delegatableNode, int i11, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitLocalChildren");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = delegatableNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & i11) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & i11) != 0) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        function1.invoke(child$ui_release);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    public static final void visitLocalParents(@NotNull DelegatableNode delegatableNode, int i11, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & i11) != 0) {
                    function1.invoke(parent$ui_release);
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitLocalParents-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4592visitLocalParents6rFNWt0(DelegatableNode delegatableNode, int i11, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitLocalParents");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & i11) != 0) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    function1.invoke(parent$ui_release);
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    public static final void visitSubtree(@NotNull DelegatableNode delegatableNode, int i11, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            NestedVectorStack nestedVectorStack = new NestedVectorStack();
            while (requireLayoutNode != null) {
                if (child$ui_release == null) {
                    child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
                }
                if ((child$ui_release.getAggregateChildKindSet$ui_release() & i11) != 0) {
                    while (child$ui_release != null) {
                        if ((child$ui_release.getKindSet$ui_release() & i11) != 0) {
                            function1.invoke(child$ui_release);
                        }
                        child$ui_release = child$ui_release.getChild$ui_release();
                    }
                    child$ui_release = null;
                }
                nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
                if (nestedVectorStack.isNotEmpty()) {
                    requireLayoutNode = (LayoutNode) nestedVectorStack.pop();
                } else {
                    requireLayoutNode = null;
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitSubtree-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4593visitSubtree6rFNWt0(DelegatableNode delegatableNode, int i11, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitSubtree");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            NestedVectorStack nestedVectorStack = new NestedVectorStack();
            while (requireLayoutNode != null) {
                if (child$ui_release == null) {
                    child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
                }
                if ((child$ui_release.getAggregateChildKindSet$ui_release() & i11) != 0) {
                    while (child$ui_release != null) {
                        if ((child$ui_release.getKindSet$ui_release() & i11) != 0) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            function1.invoke(child$ui_release);
                        }
                        child$ui_release = child$ui_release.getChild$ui_release();
                    }
                    child$ui_release = null;
                }
                nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
                if (nestedVectorStack.isNotEmpty()) {
                    requireLayoutNode = (LayoutNode) nestedVectorStack.pop();
                } else {
                    requireLayoutNode = null;
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    public static final void visitSubtreeIf(@NotNull DelegatableNode delegatableNode, int i11, @NotNull Function1<? super Modifier.Node, Boolean> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i11) != 0) {
                    Modifier.Node node2 = node;
                    while (true) {
                        if (node2 != null) {
                            if ((node2.getKindSet$ui_release() & i11) != 0 && !function1.invoke(node2).booleanValue()) {
                                break;
                            }
                            node2 = node2.getChild$ui_release();
                        } else {
                            break;
                        }
                    }
                }
                addLayoutNodeChildren(mutableVector, node);
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitSubtreeIf-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4594visitSubtreeIf6rFNWt0(DelegatableNode delegatableNode, int i11, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitSubtreeIf");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i11) != 0) {
                    Modifier.Node node2 = node;
                    while (true) {
                        if (node2 == null) {
                            break;
                        }
                        if ((node2.getKindSet$ui_release() & i11) != 0) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (!function1.invoke(node2).booleanValue()) {
                                break;
                            }
                        }
                        node2 = node2.getChild$ui_release();
                    }
                }
                addLayoutNodeChildren(mutableVector, node);
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
