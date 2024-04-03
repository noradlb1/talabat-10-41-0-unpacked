package p30;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueId f28145a;

    public /* synthetic */ b(UniqueId uniqueId) {
        this.f28145a = uniqueId;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestDescriptor) obj).findByUniqueId(this.f28145a);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
