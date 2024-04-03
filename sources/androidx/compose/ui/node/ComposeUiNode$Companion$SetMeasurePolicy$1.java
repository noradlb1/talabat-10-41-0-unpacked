package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "Landroidx/compose/ui/layout/MeasurePolicy;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposeUiNode$Companion$SetMeasurePolicy$1 extends Lambda implements Function2<ComposeUiNode, MeasurePolicy, Unit> {
    public static final ComposeUiNode$Companion$SetMeasurePolicy$1 INSTANCE = new ComposeUiNode$Companion$SetMeasurePolicy$1();

    public ComposeUiNode$Companion$SetMeasurePolicy$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (MeasurePolicy) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ComposeUiNode composeUiNode, @NotNull MeasurePolicy measurePolicy) {
        Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
        Intrinsics.checkNotNullParameter(measurePolicy, "it");
        composeUiNode.setMeasurePolicy(measurePolicy);
    }
}
