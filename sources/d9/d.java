package d9;

import com.google.common.base.Function;
import com.google.common.graph.Network;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Network f47077b;

    public /* synthetic */ d(Network network) {
        this.f47077b = network;
    }

    public final Object apply(Object obj) {
        return this.f47077b.incidentNodes(obj).source();
    }
}
