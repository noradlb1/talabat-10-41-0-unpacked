package com.instabug.library.networkv2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.e0;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import gd.c;

public class d extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private boolean f51651a;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context) {
        InstabugSDKLogger.v("IBG-Core", "Network state changed");
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null && Instabug.isEnabled()) {
                e0.c().a(context);
                SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.Network.TYPE_NETWORK, SDKCoreEvent.Network.VALUE_ACTIVATED));
                return;
            }
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "Context was null while checking for network info");
    }

    public void b(Context context) {
        context.unregisterReceiver(this);
        this.f51651a = false;
    }

    public void onReceive(Context context, Intent intent) {
        PoolProvider.postIOTask(new c(context));
    }

    public void a(Context context, IntentFilter intentFilter) {
        context.registerReceiver(this, intentFilter);
        this.f51651a = true;
    }

    public boolean a() {
        return this.f51651a;
    }
}
