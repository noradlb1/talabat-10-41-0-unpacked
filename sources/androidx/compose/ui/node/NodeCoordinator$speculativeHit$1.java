package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NodeCoordinator$speculativeHit$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NodeCoordinator f9964g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f9965h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NodeCoordinator.HitTestSource<T> f9966i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f9967j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ HitTestResult<T> f9968k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f9969l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f9970m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f9971n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeCoordinator$speculativeHit$1(NodeCoordinator nodeCoordinator, T t11, NodeCoordinator.HitTestSource<T> hitTestSource, long j11, HitTestResult<T> hitTestResult, boolean z11, boolean z12, float f11) {
        super(0);
        this.f9964g = nodeCoordinator;
        this.f9965h = t11;
        this.f9966i = hitTestSource;
        this.f9967j = j11;
        this.f9968k = hitTestResult;
        this.f9969l = z11;
        this.f9970m = z12;
        this.f9971n = f11;
    }

    public final void invoke() {
        this.f9964g.m4716speculativeHitJHbHoSQ((DelegatableNode) NodeCoordinatorKt.m4743nextUncheckedUntilhw7D004(this.f9965h, this.f9966i.m4741entityTypeOLwlOKw(), Nodes.INSTANCE.m4761getLayoutOLwlOKw()), this.f9966i, this.f9967j, this.f9968k, this.f9969l, this.f9970m, this.f9971n);
    }
}
