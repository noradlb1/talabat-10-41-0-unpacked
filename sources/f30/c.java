package f30;

import j$.util.function.Function;
import j$.util.function.Supplier;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f62039a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f62040b;

    public /* synthetic */ c(Function function, Object obj) {
        this.f62039a = function;
        this.f62040b = obj;
    }

    public final Object get() {
        return this.f62039a.apply(this.f62040b);
    }
}
