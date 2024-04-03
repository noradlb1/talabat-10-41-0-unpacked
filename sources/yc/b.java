package yc;

import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.diagnostics.nonfatals.c;

public final /* synthetic */ class b implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StackTraceElement f34841a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Throwable f34842b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34843c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f34844d;

    public /* synthetic */ b(StackTraceElement stackTraceElement, Throwable th2, String str, int i11) {
        this.f34841a = stackTraceElement;
        this.f34842b = th2;
        this.f34843c = str;
        this.f34844d = i11;
    }

    public final void run() {
        c.a(this.f34841a, this.f34842b, this.f34843c, this.f34844d);
    }
}
