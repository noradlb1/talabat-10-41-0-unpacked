package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NodeCoordinator$updateLayerParameters$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<GraphicsLayerScope, Unit> f9972g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeCoordinator$updateLayerParameters$1(Function1<? super GraphicsLayerScope, Unit> function1) {
        super(0);
        this.f9972g = function1;
    }

    public final void invoke() {
        this.f9972g.invoke(NodeCoordinator.graphicsLayerScope);
    }
}
