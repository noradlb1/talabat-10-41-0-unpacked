package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/runtime/CompositionContext;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutState$setCompositionContext$1 extends Lambda implements Function2<LayoutNode, CompositionContext, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcomposeLayoutState f9892g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutState$setCompositionContext$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.f9892g = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (CompositionContext) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull CompositionContext compositionContext) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
        Intrinsics.checkNotNullParameter(compositionContext, "it");
        this.f9892g.getState().setCompositionContext(compositionContext);
    }
}
