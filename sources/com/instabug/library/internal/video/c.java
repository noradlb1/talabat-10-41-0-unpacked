package com.instabug.library.internal.video;

import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.internal.video.customencoding.q;

class c implements q.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenRecordingEvent f51148a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenRecordingService.e f51149b;

    public c(ScreenRecordingService.e eVar, ScreenRecordingEvent screenRecordingEvent) {
        this.f51149b = eVar;
        this.f51148a = screenRecordingEvent;
    }

    public void a(long j11) {
    }

    public void a(Throwable th2) {
        if (this.f51148a.getStatus() == 1 && ScreenRecordingService.this.f51130c != null) {
            ScreenRecordingService.this.f51130c.e();
        }
    }

    public void onStart() {
    }
}
