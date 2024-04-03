package com.instabug.apm.util.powermanagement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.instabug.library.core.InstabugCore;

@RequiresApi(api = 16)
public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45589a = com.instabug.apm.di.a.f();

    /* renamed from: b  reason: collision with root package name */
    private b f45590b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45591c;

    public a(b bVar) {
        this.f45590b = bVar;
    }

    public void a(@NonNull Context context) {
        com.instabug.apm.logger.internal.a aVar;
        String str;
        try {
            if (this.f45591c) {
                aVar = this.f45589a;
                str = "BatteryLevelChangeBroadcast is already registered. Skipping re-registering";
            } else {
                context.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                this.f45591c = true;
                com.instabug.apm.logger.internal.a aVar2 = this.f45589a;
                str = "batteryLevelReceiver registered on " + context.toString();
                aVar = aVar2;
            }
            aVar.g(str);
        } catch (Exception e11) {
            this.f45589a.g("Error: " + e11.getMessage() + "While registering battery level receiver");
        }
    }

    public void b(@NonNull Context context) {
        String str;
        com.instabug.apm.logger.internal.a aVar;
        try {
            if (this.f45591c) {
                context.unregisterReceiver(this);
                this.f45591c = false;
                aVar = this.f45589a;
                str = "batteryLevelReceiver unregistered from " + context.toString();
            } else {
                aVar = this.f45589a;
                str = "BatteryLevelChangeBroadcast is not registered. Skipping unregistering";
            }
            aVar.g(str);
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "unregister BatteryLevelChangeBroadcast got error");
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.f45590b.a(intent.getIntExtra("level", 0));
        }
    }
}
