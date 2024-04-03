package sb;

import com.instabug.apm.lifecycle.f;
import com.instabug.library.model.common.Session;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f47241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Session f47242c;

    public /* synthetic */ b(f fVar, Session session) {
        this.f47241b = fVar;
        this.f47242c = session;
    }

    public final void run() {
        f.a(this.f47241b, this.f47242c);
    }
}
