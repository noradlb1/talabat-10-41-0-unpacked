package l30;

import j$.util.function.Supplier;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26477a;

    public /* synthetic */ h(Class cls) {
        this.f26477a = cls;
    }

    public final Object get() {
        return AnnotationUtils.lambda$findRepeatableAnnotations$0(this.f26477a);
    }
}
