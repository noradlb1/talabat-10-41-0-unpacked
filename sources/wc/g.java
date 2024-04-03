package wc;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.diagnostics.customtraces.b;

public final /* synthetic */ class g implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f34789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StackTraceElement[] f34790b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34791c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f34792d;

    public /* synthetic */ g(b bVar, StackTraceElement[] stackTraceElementArr, String str, long j11) {
        this.f34789a = bVar;
        this.f34790b = stackTraceElementArr;
        this.f34791c = str;
        this.f34792d = j11;
    }

    public final Object run() {
        return b.a(this.f34789a, this.f34790b, this.f34791c, this.f34792d);
    }
}
