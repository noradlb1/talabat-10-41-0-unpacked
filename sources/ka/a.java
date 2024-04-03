package ka;

import android.content.Context;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionManager f50648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f50649c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PerfSession f50650d;

    public /* synthetic */ a(SessionManager sessionManager, Context context, PerfSession perfSession) {
        this.f50648b = sessionManager;
        this.f50649c = context;
        this.f50650d = perfSession;
    }

    public final void run() {
        this.f50648b.lambda$setApplicationContext$0(this.f50649c, this.f50650d);
    }
}
