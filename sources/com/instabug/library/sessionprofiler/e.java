package com.instabug.library.sessionprofiler;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.e0;
import com.instabug.library.sessionprofiler.model.timeline.b;
import com.instabug.library.sessionprofiler.model.timeline.c;
import com.instabug.library.sessionprofiler.model.timeline.d;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public class e {

    /* renamed from: c  reason: collision with root package name */
    private static e f51863c;

    /* renamed from: a  reason: collision with root package name */
    private com.instabug.library.sessionprofiler.model.timeline.e f51864a = new com.instabug.library.sessionprofiler.model.timeline.e();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Disposable f51865b;

    private e() {
        e();
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f51863c == null) {
                f51863c = new e();
            }
            eVar = f51863c;
        }
        return eVar;
    }

    private void e() {
        SessionStateEventBus.getInstance().subscribe(new a(this));
    }

    public void c() {
        if (b()) {
            d();
            this.f51865b = Observable.interval(500, TimeUnit.MILLISECONDS).map(new d(this)).subscribe(new b(this), new c(this));
        }
    }

    public void d() {
        Disposable disposable = this.f51865b;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private boolean b() {
        return e0.c().b((Object) Feature.SESSION_PROFILER) == Feature.State.ENABLED;
    }

    /* access modifiers changed from: private */
    public void a(long j11) {
        try {
            Context applicationContext = Instabug.getApplicationContext();
            if (j11 % ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS == 0) {
                if (applicationContext != null) {
                    this.f51864a.a((float) DeviceStateProvider.getBatteryLevel(applicationContext), !"Unplugged".equals(DeviceStateProvider.getBatteryState(applicationContext)));
                } else {
                    InstabugSDKLogger.e("IBG-Core", "could attach battery state (Null app context)");
                }
                if (applicationContext != null) {
                    this.f51864a.a(new d(DeviceStateProvider.getScreenOrientation(applicationContext)));
                } else {
                    InstabugSDKLogger.e("IBG-Core", "could attach screen orientation (Null app context)");
                }
                if (applicationContext != null) {
                    this.f51864a.a(b.b(applicationContext));
                } else {
                    InstabugSDKLogger.e("IBG-Core", "could attach network state (Null app context)");
                }
            }
            if (applicationContext != null) {
                this.f51864a.a(new c(DeviceStateProvider.getUsedMemory(applicationContext), DeviceStateProvider.getTotalMemory(applicationContext)));
            } else {
                InstabugSDKLogger.e("IBG-Core", "could attach used memory (Null app context)");
            }
            this.f51864a.b(new c(DeviceStateProvider.getUsedStorage()));
            this.f51864a.c();
        } catch (OutOfMemoryError e11) {
            IBGDiagnostics.reportNonFatal(e11, "Couldn't capture session profiler. Device is low on memory ");
        }
    }

    public com.instabug.library.sessionprofiler.model.timeline.e a(float f11) {
        return this.f51864a.a(f11);
    }
}
