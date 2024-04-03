package com.instabug.apm.util.powermanagement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.core.InstabugCore;

@RequiresApi(api = 21)
public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final a f45592a = com.instabug.apm.di.a.f();

    /* renamed from: b  reason: collision with root package name */
    private b f45593b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45594c;

    public c(b bVar) {
        this.f45593b = bVar;
    }

    public void a(@NonNull Context context) {
        a aVar;
        String str;
        try {
            if (this.f45594c) {
                aVar = this.f45592a;
                str = "PowerSaveModeBroadcast is already registered. Skipping re-registering";
            } else {
                context.registerReceiver(this, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
                this.f45594c = true;
                a aVar2 = this.f45592a;
                str = "PowerSaveModeReceiver registered on " + context.toString();
                aVar = aVar2;
            }
            aVar.g(str);
        } catch (Exception e11) {
            this.f45592a.g("Error: " + e11.getMessage() + "While registering power saver mode receiver");
        }
    }

    public void b(@NonNull Context context) {
        String str;
        a aVar;
        try {
            if (this.f45594c) {
                context.unregisterReceiver(this);
                this.f45594c = false;
                aVar = this.f45592a;
                str = "PowerSaveModeReceiver unregistered from " + context.toString();
            } else {
                aVar = this.f45592a;
                str = "PowerSaveModeBroadcast is not registered. Skipping unregistering";
            }
            aVar.g(str);
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "unregister PowerSaveModeBroadcast got error");
        }
    }

    public void onReceive(Context context, Intent intent) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            this.f45593b.a(powerManager.isPowerSaveMode());
        }
    }
}
