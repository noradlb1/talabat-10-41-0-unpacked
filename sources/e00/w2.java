package e00;

import io.flutter.plugins.webviewflutter.InstanceManager;

public final /* synthetic */ class w2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstanceManager f13996b;

    public /* synthetic */ w2(InstanceManager instanceManager) {
        this.f13996b = instanceManager;
    }

    public final void run() {
        this.f13996b.releaseAllFinalizedInstances();
    }
}
