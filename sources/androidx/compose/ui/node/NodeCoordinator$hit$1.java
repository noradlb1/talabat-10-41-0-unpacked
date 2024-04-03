package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NodeCoordinator$hit$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NodeCoordinator f9946g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f9947h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NodeCoordinator.HitTestSource<T> f9948i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f9949j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ HitTestResult<T> f9950k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f9951l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f9952m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeCoordinator$hit$1(NodeCoordinator nodeCoordinator, T t11, NodeCoordinator.HitTestSource<T> hitTestSource, long j11, HitTestResult<T> hitTestResult, boolean z11, boolean z12) {
        super(0);
        this.f9946g = nodeCoordinator;
        this.f9947h = t11;
        this.f9948i = hitTestSource;
        this.f9949j = j11;
        this.f9950k = hitTestResult;
        this.f9951l = z11;
        this.f9952m = z12;
    }

    public final void invoke() {
        this.f9946g.m4713hit1hIXUjU((DelegatableNode) NodeCoordinatorKt.m4743nextUncheckedUntilhw7D004(this.f9947h, this.f9948i.m4741entityTypeOLwlOKw(), Nodes.INSTANCE.m4761getLayoutOLwlOKw()), this.f9948i, this.f9949j, this.f9950k, this.f9951l, this.f9952m);
    }
}
