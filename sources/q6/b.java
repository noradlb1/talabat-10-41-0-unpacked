package q6;

import com.facebook.appevents.internal.ActivityLifecycleTracker;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f34642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34643c;

    public /* synthetic */ b(long j11, String str) {
        this.f34642b = j11;
        this.f34643c = str;
    }

    public final void run() {
        ActivityLifecycleTracker.m8917onActivityPaused$lambda6(this.f34642b, this.f34643c);
    }
}
