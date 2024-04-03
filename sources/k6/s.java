package k6;

import com.facebook.GraphRequest;
import com.facebook.RequestProgress;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.Callback f34520b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f34521c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f34522d;

    public /* synthetic */ s(GraphRequest.Callback callback, long j11, long j12) {
        this.f34520b = callback;
        this.f34521c = j11;
        this.f34522d = j12;
    }

    public final void run() {
        RequestProgress.m8875reportProgress$lambda0(this.f34520b, this.f34521c, this.f34522d);
    }
}
