package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.a;

public final /* synthetic */ class h implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f50885a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50886b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f50887c;

    public /* synthetic */ h(a aVar, String str, long j11) {
        this.f50885a = aVar;
        this.f50886b = str;
        this.f50887c = j11;
    }

    public final Object run() {
        return a.a(this.f50885a, this.f50886b, this.f50887c);
    }
}
