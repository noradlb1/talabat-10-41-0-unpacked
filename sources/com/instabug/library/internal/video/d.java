package com.instabug.library.internal.video;

import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.internal.video.customencoding.q;
import com.instabug.library.settings.SettingsManager;

class d implements q.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f51221a;

    public d(e eVar) {
        this.f51221a = eVar;
    }

    public void a(long j11) {
    }

    public void a(Throwable th2) {
        if (ScreenRecordingService.this.f51130c == null) {
            ScreenRecordingService.this.stopForeground(true);
            ScreenRecordingService.this.stopSelf();
            return;
        }
        int i11 = ScreenRecordingService.h.f51143a[this.f51221a.f51222b.ordinal()];
        if (i11 == 1) {
            ScreenRecordingService.this.f51130c.g();
        } else if (i11 == 2) {
            ScreenRecordingService.this.f51130c.e();
        } else if (i11 == 3) {
            ScreenRecordingService.this.f51130c.c(SettingsManager.getInstance().autoScreenRecordingMaxDuration());
        }
    }

    public void onStart() {
    }
}
