package com.instabug.library.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.instabug.library.util.InstabugSDKLogger;

public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private C0004a f34174a;

    /* renamed from: com.instabug.library.broadcast.a$a  reason: collision with other inner class name */
    public interface C0004a {
        void onSDKInvoked(boolean z11);
    }

    public a(C0004a aVar) {
        this.f34174a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        InstabugSDKLogger.d("IBG-Core", "SDK invoked broadcast received");
        if (intent.getExtras() != null) {
            this.f34174a.onSDKInvoked(intent.getExtras().getBoolean("SDK invoking state"));
        }
    }
}
