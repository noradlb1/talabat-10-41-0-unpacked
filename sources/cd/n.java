package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class n implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f50900a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50901b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f50902c;

    public /* synthetic */ n(c cVar, String str, boolean z11) {
        this.f50900a = cVar;
        this.f50901b = str;
        this.f50902c = z11;
    }

    public final Object run() {
        return c.a(this.f50900a, this.f50901b, this.f50902c);
    }
}
