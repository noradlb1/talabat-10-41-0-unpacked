package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "Landroidx/compose/ui/node/PointerInputModifierNode;", "addHitPath-KNwqfcY", "(JLjava/util/List;)V", "dispatchChanges", "", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeDetachedPointerInputFilters", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HitPathTracker {
    @NotNull
    private final NodeParent root = new NodeParent();
    @NotNull
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "rootCoordinates");
        this.rootCoordinates = layoutCoordinates;
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: addHitPath-KNwqfcY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4237addHitPathKNwqfcY(long r12, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.ui.node.PointerInputModifierNode> r14) {
        /*
            r11 = this;
            java.lang.String r0 = "pointerInputNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            androidx.compose.ui.input.pointer.NodeParent r0 = r11.root
            int r1 = r14.size()
            r2 = 1
            r3 = 0
            r4 = r3
        L_0x000e:
            if (r4 >= r1) goto L_0x007f
            java.lang.Object r5 = r14.get(r4)
            androidx.compose.ui.node.PointerInputModifierNode r5 = (androidx.compose.ui.node.PointerInputModifierNode) r5
            if (r2 == 0) goto L_0x0064
            androidx.compose.runtime.collection.MutableVector r6 = r0.getChildren()
            int r7 = r6.getSize()
            if (r7 <= 0) goto L_0x0040
            java.lang.Object[] r6 = r6.getContent()
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r8)
            r8 = r3
        L_0x002c:
            r9 = r6[r8]
            r10 = r9
            androidx.compose.ui.input.pointer.Node r10 = (androidx.compose.ui.input.pointer.Node) r10
            androidx.compose.ui.node.PointerInputModifierNode r10 = r10.getPointerInputNode()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r5)
            if (r10 == 0) goto L_0x003c
            goto L_0x0041
        L_0x003c:
            int r8 = r8 + 1
            if (r8 < r7) goto L_0x002c
        L_0x0040:
            r9 = 0
        L_0x0041:
            androidx.compose.ui.input.pointer.Node r9 = (androidx.compose.ui.input.pointer.Node) r9
            if (r9 == 0) goto L_0x0063
            r9.markIsIn()
            androidx.compose.runtime.collection.MutableVector r0 = r9.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r5 = androidx.compose.ui.input.pointer.PointerId.m4288boximpl(r12)
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L_0x0061
            androidx.compose.runtime.collection.MutableVector r0 = r9.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r5 = androidx.compose.ui.input.pointer.PointerId.m4288boximpl(r12)
            r0.add(r5)
        L_0x0061:
            r0 = r9
            goto L_0x007c
        L_0x0063:
            r2 = r3
        L_0x0064:
            androidx.compose.ui.input.pointer.Node r6 = new androidx.compose.ui.input.pointer.Node
            r6.<init>(r5)
            androidx.compose.runtime.collection.MutableVector r5 = r6.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r7 = androidx.compose.ui.input.pointer.PointerId.m4288boximpl(r12)
            r5.add(r7)
            androidx.compose.runtime.collection.MutableVector r0 = r0.getChildren()
            r0.add(r6)
            r0 = r6
        L_0x007c:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m4237addHitPathKNwqfcY(long, java.util.List):void");
    }

    public final boolean dispatchChanges(@NotNull InternalPointerEvent internalPointerEvent, boolean z11) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        if (!this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z11)) {
            return false;
        }
        boolean dispatchMainEventPass = this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z11);
        if (this.root.dispatchFinalEventPass(internalPointerEvent) || dispatchMainEventPass) {
            return true;
        }
        return false;
    }

    @NotNull
    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}
