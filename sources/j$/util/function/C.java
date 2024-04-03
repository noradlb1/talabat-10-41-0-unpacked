package j$.util.function;

import j$.util.function.Function;

public final /* synthetic */ class C implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28787a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f28788b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f28789c;

    public /* synthetic */ C(Function function, Function function2, int i11) {
        this.f28787a = i11;
        this.f28788b = function;
        this.f28789c = function2;
    }

    public final /* synthetic */ Function andThen(Function function) {
        switch (this.f28787a) {
            case 0:
                return Function.CC.$default$andThen(this, function);
            default:
                return Function.CC.$default$andThen(this, function);
        }
    }

    public final Object apply(Object obj) {
        int i11 = this.f28787a;
        Function function = this.f28789c;
        Function function2 = this.f28788b;
        switch (i11) {
            case 0:
                return function.apply(function2.apply(obj));
            default:
                return function2.apply(function.apply(obj));
        }
    }

    public final /* synthetic */ Function compose(Function function) {
        switch (this.f28787a) {
            case 0:
                return Function.CC.$default$compose(this, function);
            default:
                return Function.CC.$default$compose(this, function);
        }
    }
}
