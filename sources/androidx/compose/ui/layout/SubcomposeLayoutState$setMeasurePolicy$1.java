package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutState$setMeasurePolicy$1 extends Lambda implements Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcomposeLayoutState f9893g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutState$setMeasurePolicy$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.f9893g = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>) (Function2) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
        Intrinsics.checkNotNullParameter(function2, "it");
        layoutNode.setMeasurePolicy(this.f9893g.getState().createMeasurePolicy(function2));
    }
}
