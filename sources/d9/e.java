package d9;

import com.google.common.base.Function;
import com.google.common.graph.Network;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Network f47078b;

    public /* synthetic */ e(Network network) {
        this.f47078b = network;
    }

    public final Object apply(Object obj) {
        return this.f47078b.incidentNodes(obj).target();
    }
}
