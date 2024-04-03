package ob;

import com.instabug.apm.handler.uitrace.k;
import com.instabug.apm.model.e;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f47207b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f47208c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f47209d;

    public /* synthetic */ l(k kVar, Class cls, e eVar) {
        this.f47207b = kVar;
        this.f47208c = cls;
        this.f47209d = eVar;
    }

    public final void run() {
        this.f47207b.c(this.f47208c, this.f47209d);
    }
}
