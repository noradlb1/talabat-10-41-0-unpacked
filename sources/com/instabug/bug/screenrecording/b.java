package com.instabug.bug.screenrecording;

import android.net.Uri;
import com.instabug.bug.n;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.ScreenRecordingEvent;
import io.reactivex.functions.Consumer;

class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f45719b;

    public b(c cVar) {
        this.f45719b = cVar;
    }

    /* renamed from: a */
    public void accept(ScreenRecordingEvent screenRecordingEvent) {
        if (screenRecordingEvent.getStatus() == 1) {
            n.e().a(screenRecordingEvent.getVideoDuration());
            return;
        }
        if (screenRecordingEvent.getStatus() != 2) {
            if (screenRecordingEvent.getStatus() == 0) {
                InternalScreenRecordHelper.getInstance().release();
            } else {
                if (screenRecordingEvent.getStatus() == 4) {
                    InternalScreenRecordHelper.getInstance().release();
                    this.f45719b.b((Uri) null);
                } else if (screenRecordingEvent.getStatus() == 3) {
                    InternalScreenRecordHelper.getInstance().release();
                } else {
                    return;
                }
                this.f45719b.clear();
            }
        }
        this.f45719b.b(screenRecordingEvent.getVideoUri());
        this.f45719b.clear();
    }
}
