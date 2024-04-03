package zc;

import com.instabug.library.diagnostics.sdkEvents.g;
import java.util.Collection;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f34859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Collection f34860c;

    public /* synthetic */ b(g gVar, Collection collection) {
        this.f34859b = gVar;
        this.f34860c = collection;
    }

    public final void run() {
        g.a(this.f34859b, this.f34860c);
    }
}
