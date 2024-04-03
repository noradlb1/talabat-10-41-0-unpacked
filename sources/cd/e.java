package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.a;

public final /* synthetic */ class e implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50876a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f50877b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50878c;

    public /* synthetic */ e(String str, a aVar, String str2) {
        this.f50876a = str;
        this.f50877b = aVar;
        this.f50878c = str2;
    }

    public final Object run() {
        return a.a(this.f50876a, this.f50877b, this.f50878c);
    }
}
