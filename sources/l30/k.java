package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26483b;

    public /* synthetic */ k(Class cls, Class cls2) {
        this.f26482a = cls;
        this.f26483b = cls2;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return AnnotationUtils.lambda$findRepeatableAnnotations$1(this.f26482a, this.f26483b, (Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
