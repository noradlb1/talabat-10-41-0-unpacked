package com.instabug.bug.view.reporting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.instabug.library.util.InstabugSDKLogger;

class n extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f45906a;

    public n(x xVar) {
        this.f45906a = xVar;
    }

    public void onReceive(Context context, Intent intent) {
        InstabugSDKLogger.v("IBG-BR", "Refreshing Attachments");
        if (this.f45906a.getActivity() != null && this.f45906a.C != null) {
            ((h0) this.f45906a.C).k();
        }
    }
}
