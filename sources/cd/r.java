package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class r implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f50910a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50911b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f50912c;

    public /* synthetic */ r(c cVar, String str, float f11) {
        this.f50910a = cVar;
        this.f50911b = str;
        this.f50912c = f11;
    }

    public final Object run() {
        return c.a(this.f50910a, this.f50911b, this.f50912c);
    }
}
