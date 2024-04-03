package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class u implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f50917a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50918b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50919c;

    public /* synthetic */ u(c cVar, String str, String str2) {
        this.f50917a = cVar;
        this.f50918b = str;
        this.f50919c = str2;
    }

    public final Object run() {
        return c.a(this.f50917a, this.f50918b, this.f50919c);
    }
}
