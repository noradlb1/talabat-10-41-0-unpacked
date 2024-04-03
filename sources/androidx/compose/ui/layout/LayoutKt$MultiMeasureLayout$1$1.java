package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutKt$MultiMeasureLayout$1$1 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final LayoutKt$MultiMeasureLayout$1$1 INSTANCE = new LayoutKt$MultiMeasureLayout$1$1();

    public LayoutKt$MultiMeasureLayout$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$init");
        layoutNode.setCanMultiMeasure$ui_release(true);
    }
}
