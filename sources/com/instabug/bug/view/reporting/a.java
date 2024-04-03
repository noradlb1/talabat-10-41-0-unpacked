package com.instabug.bug.view.reporting;

import android.net.Uri;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.view.n;
import com.instabug.library.InstabugState;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.internal.video.ScreenRecordingEvent;
import io.reactivex.functions.Consumer;

class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f45873b;

    public a(b bVar, n nVar) {
        this.f45873b = nVar;
    }

    /* renamed from: a */
    public void accept(InstabugState instabugState) {
        if (instabugState == InstabugState.DISABLED) {
            BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
            if (bugPlugin != null) {
                bugPlugin.setState(0);
            }
            ScreenRecordingEventBus.getInstance().post(new ScreenRecordingEvent(3, (Uri) null));
            this.f45873b.A();
        }
    }
}
