package l6;

import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushReason;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlushReason f34548b;

    public /* synthetic */ e(FlushReason flushReason) {
        this.f34548b = flushReason;
    }

    public final void run() {
        AppEventQueue.m8882flush$lambda2(this.f34548b);
    }
}
