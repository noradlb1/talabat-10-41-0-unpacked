package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NodeCoordinator$hitNear$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NodeCoordinator f9953g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f9954h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NodeCoordinator.HitTestSource<T> f9955i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f9956j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ HitTestResult<T> f9957k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f9958l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f9959m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f9960n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeCoordinator$hitNear$1(NodeCoordinator nodeCoordinator, T t11, NodeCoordinator.HitTestSource<T> hitTestSource, long j11, HitTestResult<T> hitTestResult, boolean z11, boolean z12, float f11) {
        super(0);
        this.f9953g = nodeCoordinator;
        this.f9954h = t11;
        this.f9955i = hitTestSource;
        this.f9956j = j11;
        this.f9957k = hitTestResult;
        this.f9958l = z11;
        this.f9959m = z12;
        this.f9960n = f11;
    }

    public final void invoke() {
        this.f9953g.m4714hitNearJHbHoSQ((DelegatableNode) NodeCoordinatorKt.m4743nextUncheckedUntilhw7D004(this.f9954h, this.f9955i.m4741entityTypeOLwlOKw(), Nodes.INSTANCE.m4761getLayoutOLwlOKw()), this.f9955i, this.f9956j, this.f9957k, this.f9958l, this.f9959m, this.f9960n);
    }
}
