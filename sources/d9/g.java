package d9;

import com.google.common.base.Function;
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraph;

public final /* synthetic */ class g implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ValueGraph f47081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f47082c;

    public /* synthetic */ g(ValueGraph valueGraph, Object obj) {
        this.f47081b = valueGraph;
        this.f47082c = obj;
    }

    public final Object apply(Object obj) {
        return ImmutableValueGraph.lambda$connectionsOf$0(this.f47081b, this.f47082c, obj);
    }
}
