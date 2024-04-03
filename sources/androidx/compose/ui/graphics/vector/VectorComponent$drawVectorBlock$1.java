package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComponent$drawVectorBlock$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VectorComponent f9696g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorComponent$drawVectorBlock$1(VectorComponent vectorComponent) {
        super(1);
        this.f9696g = vectorComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$null");
        this.f9696g.getRoot().draw(drawScope);
    }
}
