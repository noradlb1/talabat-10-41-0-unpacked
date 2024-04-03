package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 extends Lambda implements Function1<LayoutNode, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<TestModifierUpdater, Unit> f9896g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(Function1<? super TestModifierUpdater, Unit> function1) {
        super(1);
        this.f9896g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$init");
        this.f9896g.invoke(new TestModifierUpdater(layoutNode));
    }
}
