package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.Measurable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0007H\u0002¨\u0006\b"}, d2 = {"updateChildMeasurables", "", "Landroidx/compose/ui/node/LayoutNode;", "destination", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/layout/Measurable;", "transform", "Lkotlin/Function1;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegateKt {
    /* access modifiers changed from: private */
    public static final void updateChildMeasurables(LayoutNode layoutNode, MutableVector<Measurable> mutableVector, Function1<? super LayoutNode, ? extends Measurable> function1) {
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            Object[] content = mutableVector2.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i11];
                if (mutableVector.getSize() <= i11) {
                    mutableVector.add(function1.invoke(layoutNode2));
                } else {
                    mutableVector.set(i11, function1.invoke(layoutNode2));
                }
                i11++;
            } while (i11 < size);
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
    }
}
