package com.instabug.chat.screenrecording;

import android.net.Uri;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.ScreenRecordingEvent;
import io.reactivex.functions.Consumer;

class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f46145b;

    public a(c cVar) {
        this.f46145b = cVar;
    }

    /* renamed from: a */
    public void accept(ScreenRecordingEvent screenRecordingEvent) {
        if (screenRecordingEvent.getStatus() == 2) {
            this.f46145b.a(screenRecordingEvent.getVideoUri());
        } else {
            if (screenRecordingEvent.getStatus() == 0) {
                this.f46145b.a(screenRecordingEvent.getVideoUri());
            } else if (screenRecordingEvent.getStatus() == 4) {
                this.f46145b.a((Uri) null);
            } else {
                return;
            }
            InternalScreenRecordHelper.getInstance().release();
        }
        this.f46145b.clear();
    }
}
