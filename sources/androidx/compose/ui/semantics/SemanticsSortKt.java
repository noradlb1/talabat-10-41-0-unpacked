package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.NodeLocationHolder;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\"\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0000¨\u0006\f"}, d2 = {"findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LayoutNode;", "findNodeByPredicateTraversal", "predicate", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappersSortedByBounds", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "list", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SemanticsSortKt {
    @NotNull
    public static final NodeCoordinator findCoordinatorToGetBounds(@NotNull LayoutNode layoutNode) {
        Modifier.Node node;
        NodeCoordinator coordinator$ui_release;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        SemanticsModifierNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        }
        if (outerMergingSemantics == null || (node = outerMergingSemantics.getNode()) == null || (coordinator$ui_release = node.getCoordinator$ui_release()) == null) {
            return layoutNode.getInnerCoordinator$ui_release();
        }
        return coordinator$ui_release;
    }

    @Nullable
    public static final LayoutNode findNodeByPredicateTraversal(@NotNull LayoutNode layoutNode, @NotNull Function1<? super LayoutNode, Boolean> function1) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (function1.invoke(layoutNode).booleanValue()) {
            return layoutNode;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i11 = 0; i11 < size; i11++) {
            LayoutNode findNodeByPredicateTraversal = findNodeByPredicateTraversal(children$ui_release.get(i11), function1);
            if (findNodeByPredicateTraversal != null) {
                return findNodeByPredicateTraversal;
            }
        }
        return null;
    }

    @NotNull
    public static final List<SemanticsModifierNode> findOneLayerOfSemanticsWrappersSortedByBounds(@NotNull LayoutNode layoutNode, @NotNull List<SemanticsModifierNode> list) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        if (!layoutNode.isAttached()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i11 = 0; i11 < size; i11++) {
            LayoutNode layoutNode2 = children$ui_release.get(i11);
            if (layoutNode2.isAttached()) {
                arrayList.add(new NodeLocationHolder(layoutNode, layoutNode2));
            }
        }
        List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(arrayList);
        ArrayList arrayList2 = new ArrayList(findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size());
        int size2 = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size();
        for (int i12 = 0; i12 < size2; i12++) {
            arrayList2.add(findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.get(i12).getNode$ui_release());
        }
        int size3 = arrayList2.size();
        for (int i13 = 0; i13 < size3; i13++) {
            LayoutNode layoutNode3 = (LayoutNode) arrayList2.get(i13);
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode3);
            if (outerSemantics != null) {
                list.add(outerSemantics);
            } else {
                findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode3, list);
            }
        }
        return list;
    }

    public static /* synthetic */ List findOneLayerOfSemanticsWrappersSortedByBounds$default(LayoutNode layoutNode, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode, list);
    }

    private static final List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(List<NodeLocationHolder> list) {
        try {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Stripe);
            List<NodeLocationHolder> mutableList = CollectionsKt___CollectionsKt.toMutableList(list);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            return mutableList;
        } catch (IllegalArgumentException unused) {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Location);
            List<NodeLocationHolder> mutableList2 = CollectionsKt___CollectionsKt.toMutableList(list);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList2);
            return mutableList2;
        }
    }
}
