package zc;

import com.instabug.library.diagnostics.sdkEvents.g;
import java.util.List;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f34864b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f34865c;

    public /* synthetic */ e(g gVar, List list) {
        this.f34864b = gVar;
        this.f34865c = list;
    }

    public final void run() {
        g.a(this.f34864b, this.f34865c);
    }
}
