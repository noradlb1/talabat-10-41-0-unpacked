package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.a;

public final /* synthetic */ class f implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f50879a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f50881c;

    public /* synthetic */ f(a aVar, String str, float f11) {
        this.f50879a = aVar;
        this.f50880b = str;
        this.f50881c = f11;
    }

    public final Object run() {
        return a.a(this.f50879a, this.f50880b, this.f50881c);
    }
}
