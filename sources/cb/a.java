package cb;

import com.huawei.location.lite.common.http.SubmitEx;
import com.huawei.location.lite.common.http.callback.IHttpCallback;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubmitEx f47297b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IHttpCallback f47298c;

    public /* synthetic */ a(SubmitEx submitEx, IHttpCallback iHttpCallback) {
        this.f47297b = submitEx;
        this.f47298c = iHttpCallback;
    }

    public final void run() {
        this.f47297b.lambda$enqueue$0(this.f47298c);
    }
}
