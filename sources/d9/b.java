package d9;

import com.google.common.base.Function;
import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.ValueGraph;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ValueGraph f47076b;

    public /* synthetic */ b(ValueGraph valueGraph) {
        this.f47076b = valueGraph;
    }

    public final Object apply(Object obj) {
        return AbstractValueGraph.lambda$edgeValueMap$0(this.f47076b, (EndpointPair) obj);
    }
}
