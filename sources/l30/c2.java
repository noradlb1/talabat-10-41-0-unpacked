package l30;

import java.util.concurrent.Callable;

public final /* synthetic */ class c2 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26466b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26467c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Class[] f26468d;

    public /* synthetic */ c2(Class cls, String str, Class[] clsArr) {
        this.f26466b = cls;
        this.f26467c = str;
        this.f26468d = clsArr;
    }

    public final Object call() {
        return this.f26466b.getMethod(this.f26467c, this.f26468d);
    }
}
