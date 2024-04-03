package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class m implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f50897a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50898b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f50899c;

    public /* synthetic */ m(c cVar, String str, long j11) {
        this.f50897a = cVar;
        this.f50898b = str;
        this.f50899c = j11;
    }

    public final Object run() {
        return c.a(this.f50897a, this.f50898b, this.f50899c);
    }
}
