package wc;

import com.instabug.library.diagnostics.customtraces.b;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f34779b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StackTraceElement[] f34780c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f34781d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f34782e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f34783f;

    public /* synthetic */ d(b bVar, StackTraceElement[] stackTraceElementArr, long j11, long j12, String str) {
        this.f34779b = bVar;
        this.f34780c = stackTraceElementArr;
        this.f34781d = j11;
        this.f34782e = j12;
        this.f34783f = str;
    }

    public final void run() {
        b.a(this.f34779b, this.f34780c, this.f34781d, this.f34782e, this.f34783f);
    }
}
