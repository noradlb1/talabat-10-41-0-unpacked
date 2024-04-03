package com.instabug.library.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;

public class i extends BroadcastReceiver implements r {

    /* renamed from: a  reason: collision with root package name */
    private final Context f51930a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private q f51931b;

    public i(Context context) {
        this.f51930a = context;
    }

    public void a(@NonNull q qVar) {
        if (this.f51931b == null) {
            this.f51930a.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
        }
        this.f51931b = qVar;
    }

    public void onReceive(Context context, Intent intent) {
        q qVar;
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && (qVar = this.f51931b) != null) {
            qVar.a();
        }
    }

    public void a() {
        if (this.f51931b != null) {
            this.f51931b = null;
            try {
                this.f51930a.unregisterReceiver(this);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "couldn't unregister Screen off receiver", e11);
            }
        }
    }
}
