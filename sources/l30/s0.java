package l30;

import java.util.concurrent.Callable;

public final /* synthetic */ class s0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26500c;

    public /* synthetic */ s0(Class cls, String str) {
        this.f26499b = cls;
        this.f26500c = str;
    }

    public final Object call() {
        return this.f26499b.getDeclaredField(this.f26500c);
    }
}
