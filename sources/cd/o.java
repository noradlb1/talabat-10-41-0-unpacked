package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.c;
import java.util.Set;

public final /* synthetic */ class o implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f50903a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50904b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Set f50905c;

    public /* synthetic */ o(c cVar, String str, Set set) {
        this.f50903a = cVar;
        this.f50904b = str;
        this.f50905c = set;
    }

    public final Object run() {
        return c.a(this.f50903a, this.f50904b, this.f50905c);
    }
}
