package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class t implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f50914a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50915b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f50916c;

    public /* synthetic */ t(c cVar, String str, int i11) {
        this.f50914a = cVar;
        this.f50915b = str;
        this.f50916c = i11;
    }

    public final Object run() {
        return c.a(this.f50914a, this.f50915b, this.f50916c);
    }
}
