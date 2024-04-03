package m30;

import j$.util.function.Function;
import j$.util.function.Predicate;
import org.junit.platform.engine.Filter;
import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.e;

public final /* synthetic */ class j implements Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Filter f26880a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f26881b;

    public /* synthetic */ j(Filter filter, Function function) {
        this.f26880a = filter;
        this.f26881b = function;
    }

    public final FilterResult apply(Object obj) {
        return this.f26880a.apply(this.f26881b.apply(obj));
    }

    public /* synthetic */ Predicate toPredicate() {
        return e.a(this);
    }
}
