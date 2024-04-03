package q6;

import com.facebook.appevents.internal.ActivityLifecycleTracker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f34640b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34641c;

    public /* synthetic */ a(long j11, String str) {
        this.f34640b = j11;
        this.f34641c = str;
    }

    public final void run() {
        ActivityLifecycleTracker.m8918onActivityPaused$lambda6$lambda4(this.f34640b, this.f34641c);
    }
}
