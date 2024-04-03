package kb;

import com.instabug.anr.d;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f47128b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SDKCoreEvent f47129c;

    public /* synthetic */ c(d dVar, SDKCoreEvent sDKCoreEvent) {
        this.f47128b = dVar;
        this.f47129c = sDKCoreEvent;
    }

    public final void run() {
        d.a(this.f47128b, this.f47129c);
    }
}
