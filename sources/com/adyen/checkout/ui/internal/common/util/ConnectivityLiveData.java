package com.adyen.checkout.ui.internal.common.util;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public class ConnectivityLiveData extends LiveData<NetworkInfo> {
    private final Application mApplication;
    private ConnectivityManager mConnectivityManager;
    private final BroadcastReceiver mConnectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            ConnectivityLiveData.this.updateNetworkInfo();
        }
    };

    public ConnectivityLiveData(@NonNull Application application) {
        this.mApplication = application;
    }

    /* access modifiers changed from: private */
    public void updateNetworkInfo() {
        NetworkInfo networkInfo;
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) this.mApplication.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        setValue(networkInfo);
    }

    public void e() {
        super.e();
        updateNetworkInfo();
        this.mApplication.registerReceiver(this.mConnectivityReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
    }

    public void f() {
        super.f();
        this.mApplication.unregisterReceiver(this.mConnectivityReceiver);
    }
}
