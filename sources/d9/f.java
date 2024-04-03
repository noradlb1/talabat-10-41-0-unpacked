package d9;

import com.google.common.base.Function;
import com.google.common.graph.Network;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Network f47079b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f47080c;

    public /* synthetic */ f(Network network, Object obj) {
        this.f47079b = network;
        this.f47080c = obj;
    }

    public final Object apply(Object obj) {
        return this.f47079b.incidentNodes(obj).adjacentNode(this.f47080c);
    }
}
