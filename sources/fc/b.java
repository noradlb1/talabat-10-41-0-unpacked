package fc;

import com.instabug.crash.CrashPlugin;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CrashPlugin f47089b;

    public /* synthetic */ b(CrashPlugin crashPlugin) {
        this.f47089b = crashPlugin;
    }

    public final void run() {
        this.f47089b.subscribeOnSDKEvents();
    }
}
