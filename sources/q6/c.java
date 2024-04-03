package q6;

import android.content.Context;
import com.facebook.appevents.internal.ActivityLifecycleTracker;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f34644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34645c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f34646d;

    public /* synthetic */ c(long j11, String str, Context context) {
        this.f34644b = j11;
        this.f34645c = str;
        this.f34646d = context;
    }

    public final void run() {
        ActivityLifecycleTracker.m8919onActivityResumed$lambda2(this.f34644b, this.f34645c, this.f34646d);
    }
}
