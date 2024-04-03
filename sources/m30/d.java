package m30;

import j$.util.function.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f26877a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26878b;

    public /* synthetic */ d(Function function, String str) {
        this.f26877a = function;
        this.f26878b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return e.b(this.f26877a, this.f26878b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
