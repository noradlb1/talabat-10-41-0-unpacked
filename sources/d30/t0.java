package d30;

import j$.util.function.Supplier;
import java.lang.reflect.AnnotatedElement;

public final /* synthetic */ class t0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f61918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnnotatedElement f61919b;

    public /* synthetic */ t0(String str, AnnotatedElement annotatedElement) {
        this.f61918a = str;
        this.f61919b = annotatedElement;
    }

    public final Object get() {
        return String.format("Configuration error: invalid tag syntax in @Tag(\"%s\") declaration on [%s]. Tag will be ignored.", new Object[]{this.f61918a, this.f61919b});
    }
}
