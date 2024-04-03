package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003H\bJ\u0006\u0010\u0018\u001a\u00020\u0007J\"\u0010\u0019\u001a\u00020\u00132\u0014\b\u0004\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u001bH\bø\u0001\u0000J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/DepthSortedSet;", "", "extraAssertions", "", "(Z)V", "DepthComparator", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "mapOfOriginalDepth", "", "", "getMapOfOriginalDepth", "()Ljava/util/Map;", "mapOfOriginalDepth$delegate", "Lkotlin/Lazy;", "set", "Landroidx/compose/ui/node/TreeSet;", "add", "", "node", "contains", "isEmpty", "isNotEmpty", "pop", "popEach", "block", "Lkotlin/Function1;", "remove", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DepthSortedSet {
    @NotNull
    private final Comparator<LayoutNode> DepthComparator;
    private final boolean extraAssertions;
    @NotNull
    private final Lazy mapOfOriginalDepth$delegate;
    @NotNull
    private final TreeSet<LayoutNode> set;

    public DepthSortedSet() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public DepthSortedSet(boolean z11) {
        this.extraAssertions = z11;
        this.mapOfOriginalDepth$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, DepthSortedSet$mapOfOriginalDepth$2.INSTANCE);
        DepthSortedSet$DepthComparator$1 depthSortedSet$DepthComparator$1 = new DepthSortedSet$DepthComparator$1();
        this.DepthComparator = depthSortedSet$DepthComparator$1;
        this.set = new TreeSet<>(depthSortedSet$DepthComparator$1);
    }

    private final Map<LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth$delegate.getValue();
    }

    public final void add(@NotNull LayoutNode layoutNode) {
        boolean z11;
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        if (layoutNode.isAttached()) {
            if (this.extraAssertions) {
                Integer num = getMapOfOriginalDepth().get(layoutNode);
                if (num == null) {
                    getMapOfOriginalDepth().put(layoutNode, Integer.valueOf(layoutNode.getDepth$ui_release()));
                } else {
                    if (num.intValue() == layoutNode.getDepth$ui_release()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            this.set.add(layoutNode);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean contains(@NotNull LayoutNode layoutNode) {
        boolean z11;
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        boolean contains = this.set.contains(layoutNode);
        if (this.extraAssertions) {
            if (contains == getMapOfOriginalDepth().containsKey(layoutNode)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return contains;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    @NotNull
    public final LayoutNode pop() {
        LayoutNode first = this.set.first();
        Intrinsics.checkNotNullExpressionValue(first, "node");
        remove(first);
        return first;
    }

    public final void popEach(@NotNull Function1<? super LayoutNode, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        while (!isEmpty()) {
            function1.invoke(pop());
        }
    }

    public final boolean remove(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        if (layoutNode.isAttached()) {
            boolean remove = this.set.remove(layoutNode);
            if (this.extraAssertions) {
                Integer remove2 = getMapOfOriginalDepth().remove(layoutNode);
                boolean z11 = true;
                if (remove) {
                    int depth$ui_release = layoutNode.getDepth$ui_release();
                    if (remove2 == null || remove2.intValue() != depth$ui_release) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (remove2 != null) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            return remove;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public String toString() {
        String obj = this.set.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "set.toString()");
        return obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DepthSortedSet(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }
}
