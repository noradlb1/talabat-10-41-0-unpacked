package d9;

import com.google.common.base.Function;
import com.google.common.graph.Network;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Network f47075b;

    public /* synthetic */ a(Network network) {
        this.f47075b = network;
    }

    public final Object apply(Object obj) {
        return this.f47075b.incidentNodes(obj);
    }
}
