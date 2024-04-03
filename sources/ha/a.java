package ha;

import android.content.Context;
import com.google.firebase.perf.config.DeviceCacheManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceCacheManager f50637b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f50638c;

    public /* synthetic */ a(DeviceCacheManager deviceCacheManager, Context context) {
        this.f50637b = deviceCacheManager;
        this.f50638c = context;
    }

    public final void run() {
        this.f50637b.lambda$setContext$0(this.f50638c);
    }
}
