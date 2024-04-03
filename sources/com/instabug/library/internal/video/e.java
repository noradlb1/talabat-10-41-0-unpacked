package com.instabug.library.internal.video;

import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.settings.SettingsManager;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenRecordingService.Action f51222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ScreenRecordingService.f f51223c;

    public e(ScreenRecordingService.f fVar, ScreenRecordingService.Action action) {
        this.f51223c = fVar;
        this.f51222b = action;
    }

    public void run() {
        if (SettingsManager.getInstance().isScreenCurrentlyRecorded()) {
            SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
            if (ScreenRecordingService.this.f51130c != null) {
                ScreenRecordingService.this.f51130c.d(new d(this));
            }
        }
    }
}
