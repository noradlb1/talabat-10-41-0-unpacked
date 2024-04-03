package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<GraphicsLayerScope, Unit> f9932g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate f9933h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f9934i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f9935j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1(Function1<? super GraphicsLayerScope, Unit> function1, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j11, float f11) {
        super(0);
        this.f9932g = function1;
        this.f9933h = layoutNodeLayoutDelegate;
        this.f9934i = j11;
        this.f9935j = f11;
    }

    public final void invoke() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        Function1<GraphicsLayerScope, Unit> function1 = this.f9932g;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.f9933h;
        long j11 = this.f9934i;
        float f11 = this.f9935j;
        if (function1 == null) {
            companion.m4533place70tqf50(layoutNodeLayoutDelegate.getOuterCoordinator(), j11, f11);
        } else {
            companion.m4538placeWithLayeraW9wM(layoutNodeLayoutDelegate.getOuterCoordinator(), j11, f11, function1);
        }
    }
}
