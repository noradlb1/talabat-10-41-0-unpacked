package zc;

import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.diagnostics.sdkEvents.e;

public final /* synthetic */ class a implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f34855a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f34857c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StackTraceElement[] f34858d;

    public /* synthetic */ a(String str, int i11, e eVar, StackTraceElement[] stackTraceElementArr) {
        this.f34855a = str;
        this.f34856b = i11;
        this.f34857c = eVar;
        this.f34858d = stackTraceElementArr;
    }

    public final void run() {
        e.a(this.f34855a, this.f34856b, this.f34857c, this.f34858d);
    }
}
