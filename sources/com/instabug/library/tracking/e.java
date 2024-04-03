package com.instabug.library.tracking;

import android.app.Activity;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.e0;
import com.instabug.library.internal.utils.memory.a;
import com.instabug.library.r0;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f51922b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f51923c;

    public e(g gVar, Activity activity) {
        this.f51923c = gVar;
        this.f51922b = activity;
    }

    public void run() {
        if (SettingsManager.getInstance().isInBackground()) {
            if (DeviceStateProvider.getFreeStorage() < 50) {
                Instabug.pauseSdk();
                InstabugSDKLogger.e("IBG-Core", "Instabug was disabled temporary because of low disk storage '< 50MB' and it will be resumed next session one there is available disk storage");
                boolean unused = this.f51923c.f51927d = true;
                return;
            }
            if (a.a()) {
                e0.c().a(Feature.INSTABUG, Feature.State.ENABLED);
                Instabug.resumeSdk();
                a.a(false);
            }
            r0.e().k();
            SettingsManager.getInstance().setInBackground(false);
        }
        PoolProvider.postMainThreadTask(new d(this));
    }
}
