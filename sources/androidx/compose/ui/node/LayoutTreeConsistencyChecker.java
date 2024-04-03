package androidx.compose.ui.node;

import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\r*\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "postponedMeasureRequests", "", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSet;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutTreeConsistencyChecker {
    @NotNull
    private final List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests;
    @NotNull
    private final DepthSortedSet relayoutNodes;
    @NotNull
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(@NotNull LayoutNode layoutNode, @NotNull DepthSortedSet depthSortedSet, @NotNull List<MeasureAndLayoutDelegate.PostponedRequest> list) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        Intrinsics.checkNotNullParameter(depthSortedSet, "relayoutNodes");
        Intrinsics.checkNotNullParameter(list, "postponedMeasureRequests");
        this.root = layoutNode;
        this.relayoutNodes = depthSortedSet;
        this.postponedMeasureRequests = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3 != false) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode r12) {
        /*
            r11 = this;
            androidx.compose.ui.node.LayoutNode r0 = r12.getParent$ui_release()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = r0.getLayoutState$ui_release()
            goto L_0x000d
        L_0x000c:
            r2 = r1
        L_0x000d:
            boolean r3 = r12.isPlaced()
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x002b
            int r3 = r12.getPlaceOrder$ui_release()
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r6) goto L_0x00a5
            if (r0 == 0) goto L_0x0028
            boolean r3 = r0.isPlaced()
            if (r3 != r5) goto L_0x0028
            r3 = r5
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            if (r3 == 0) goto L_0x00a5
        L_0x002b:
            boolean r3 = r12.getMeasurePending$ui_release()
            if (r3 == 0) goto L_0x005e
            java.util.List<androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest> r3 = r11.postponedMeasureRequests
            int r6 = r3.size()
            r7 = r4
        L_0x0038:
            if (r7 >= r6) goto L_0x005a
            java.lang.Object r8 = r3.get(r7)
            r9 = r8
            androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest r9 = (androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest) r9
            androidx.compose.ui.node.LayoutNode r10 = r9.getNode()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x0053
            boolean r9 = r9.isLookahead()
            if (r9 != 0) goto L_0x0053
            r9 = r5
            goto L_0x0054
        L_0x0053:
            r9 = r4
        L_0x0054:
            if (r9 == 0) goto L_0x0057
            goto L_0x005b
        L_0x0057:
            int r7 = r7 + 1
            goto L_0x0038
        L_0x005a:
            r8 = r1
        L_0x005b:
            if (r8 == 0) goto L_0x005e
            return r5
        L_0x005e:
            boolean r3 = r12.getMeasurePending$ui_release()
            if (r3 == 0) goto L_0x007f
            androidx.compose.ui.node.DepthSortedSet r1 = r11.relayoutNodes
            boolean r12 = r1.contains(r12)
            if (r12 != 0) goto L_0x007d
            if (r0 == 0) goto L_0x0076
            boolean r12 = r0.getMeasurePending$ui_release()
            if (r12 != r5) goto L_0x0076
            r12 = r5
            goto L_0x0077
        L_0x0076:
            r12 = r4
        L_0x0077:
            if (r12 != 0) goto L_0x007d
            androidx.compose.ui.node.LayoutNode$LayoutState r12 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r2 != r12) goto L_0x007e
        L_0x007d:
            r4 = r5
        L_0x007e:
            return r4
        L_0x007f:
            boolean r3 = r12.getLayoutPending$ui_release()
            if (r3 == 0) goto L_0x00a5
            androidx.compose.ui.node.DepthSortedSet r1 = r11.relayoutNodes
            boolean r12 = r1.contains(r12)
            if (r12 != 0) goto L_0x00a3
            if (r0 == 0) goto L_0x00a3
            boolean r12 = r0.getMeasurePending$ui_release()
            if (r12 != 0) goto L_0x00a3
            boolean r12 = r0.getLayoutPending$ui_release()
            if (r12 != 0) goto L_0x00a3
            androidx.compose.ui.node.LayoutNode$LayoutState r12 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r2 == r12) goto L_0x00a3
            androidx.compose.ui.node.LayoutNode$LayoutState r12 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r2 != r12) goto L_0x00a4
        L_0x00a3:
            r4 = r5
        L_0x00a4:
            return r4
        L_0x00a5:
            java.lang.Boolean r3 = r12.isPlacedInLookahead()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x0160
            boolean r3 = r12.getLookaheadMeasurePending$ui_release()
            if (r3 == 0) goto L_0x00e4
            java.util.List<androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest> r3 = r11.postponedMeasureRequests
            int r6 = r3.size()
            r7 = r4
        L_0x00be:
            if (r7 >= r6) goto L_0x00e1
            java.lang.Object r8 = r3.get(r7)
            r9 = r8
            androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest r9 = (androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest) r9
            androidx.compose.ui.node.LayoutNode r10 = r9.getNode()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x00d9
            boolean r9 = r9.isLookahead()
            if (r9 == 0) goto L_0x00d9
            r9 = r5
            goto L_0x00da
        L_0x00d9:
            r9 = r4
        L_0x00da:
            if (r9 == 0) goto L_0x00de
            r1 = r8
            goto L_0x00e1
        L_0x00de:
            int r7 = r7 + 1
            goto L_0x00be
        L_0x00e1:
            if (r1 == 0) goto L_0x00e4
            return r5
        L_0x00e4:
            boolean r1 = r12.getLookaheadMeasurePending$ui_release()
            if (r1 == 0) goto L_0x0123
            androidx.compose.ui.node.DepthSortedSet r1 = r11.relayoutNodes
            boolean r1 = r1.contains(r12)
            if (r1 != 0) goto L_0x0121
            if (r0 == 0) goto L_0x00fc
            boolean r1 = r0.getLookaheadMeasurePending$ui_release()
            if (r1 != r5) goto L_0x00fc
            r1 = r5
            goto L_0x00fd
        L_0x00fc:
            r1 = r4
        L_0x00fd:
            if (r1 != 0) goto L_0x0121
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r2 == r1) goto L_0x0121
            if (r0 == 0) goto L_0x010d
            boolean r0 = r0.getMeasurePending$ui_release()
            if (r0 != r5) goto L_0x010d
            r0 = r5
            goto L_0x010e
        L_0x010d:
            r0 = r4
        L_0x010e:
            if (r0 == 0) goto L_0x0122
            androidx.compose.ui.layout.LookaheadScope r0 = r12.getMLookaheadScope$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.node.LayoutNode r0 = r0.getRoot()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0122
        L_0x0121:
            r4 = r5
        L_0x0122:
            return r4
        L_0x0123:
            boolean r1 = r12.getLookaheadLayoutPending$ui_release()
            if (r1 == 0) goto L_0x0160
            androidx.compose.ui.node.DepthSortedSet r1 = r11.relayoutNodes
            boolean r1 = r1.contains(r12)
            if (r1 != 0) goto L_0x015e
            if (r0 == 0) goto L_0x015e
            boolean r1 = r0.getLookaheadMeasurePending$ui_release()
            if (r1 != 0) goto L_0x015e
            boolean r1 = r0.getLookaheadLayoutPending$ui_release()
            if (r1 != 0) goto L_0x015e
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r2 == r1) goto L_0x015e
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
            if (r2 == r1) goto L_0x015e
            boolean r0 = r0.getLayoutPending$ui_release()
            if (r0 == 0) goto L_0x015f
            androidx.compose.ui.layout.LookaheadScope r0 = r12.getMLookaheadScope$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.node.LayoutNode r0 = r0.getRoot()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x015f
        L_0x015e:
            r4 = r5
        L_0x015f:
            return r4
        L_0x0160:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutTreeConsistencyChecker.consistentLayoutState(androidx.compose.ui.node.LayoutNode):boolean");
    }

    private final boolean isTreeConsistent(LayoutNode layoutNode) {
        if (!consistentLayoutState(layoutNode)) {
            return false;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!isTreeConsistent(children$ui_release.get(i11))) {
                return false;
            }
        }
        return true;
    }

    private final String logTree() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        logTree$printSubTree(this, sb2, this.root, 0);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
        return sb3;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker layoutTreeConsistencyChecker, StringBuilder sb2, LayoutNode layoutNode, int i11) {
        boolean z11;
        String nodeToString = layoutTreeConsistencyChecker.nodeToString(layoutNode);
        if (nodeToString.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            for (int i12 = 0; i12 < i11; i12++) {
                sb2.append("..");
            }
            sb2.append(nodeToString);
            Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
            sb2.append(10);
            Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
            i11++;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i13 = 0; i13 < size; i13++) {
            logTree$printSubTree(layoutTreeConsistencyChecker, sb2, children$ui_release.get(i13), i11);
        }
    }

    private final String nodeToString(LayoutNode layoutNode) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(layoutNode);
        StringBuilder sb3 = new StringBuilder();
        sb3.append('[');
        sb3.append(layoutNode.getLayoutState$ui_release());
        sb3.append(AbstractJsonLexerKt.END_LIST);
        sb2.append(sb3.toString());
        if (!layoutNode.isPlaced()) {
            sb2.append("[!isPlaced]");
        }
        sb2.append("[measuredByParent=" + layoutNode.getMeasuredByParent$ui_release() + AbstractJsonLexerKt.END_LIST);
        if (!consistentLayoutState(layoutNode)) {
            sb2.append("[INCONSISTENT]");
        }
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb4;
    }

    public final void assertConsistent() {
        if (!isTreeConsistent(this.root)) {
            System.out.println(logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }
}
