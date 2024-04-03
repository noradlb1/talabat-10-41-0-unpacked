package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private static final String TAG = "ConnectivityMonitor";
    private final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
        public void onReceive(@NonNull Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z11 = defaultConnectivityMonitor.isConnected;
            defaultConnectivityMonitor.isConnected = defaultConnectivityMonitor.isConnected(context);
            if (z11 != DefaultConnectivityMonitor.this.isConnected) {
                if (Log.isLoggable(DefaultConnectivityMonitor.TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("connectivity changed, isConnected: ");
                    sb2.append(DefaultConnectivityMonitor.this.isConnected);
                }
                DefaultConnectivityMonitor defaultConnectivityMonitor2 = DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.listener.onConnectivityChanged(defaultConnectivityMonitor2.isConnected);
            }
        }
    };
    private final Context context;
    boolean isConnected;
    private boolean isRegistered;
    final ConnectivityMonitor.ConnectivityListener listener;

    public DefaultConnectivityMonitor(@NonNull Context context2, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context2.getApplicationContext();
        this.listener = connectivityListener;
    }

    private void register() {
        if (!this.isRegistered) {
            this.isConnected = isConnected(this.context);
            try {
                this.context.registerReceiver(this.connectivityReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
                this.isRegistered = true;
            } catch (SecurityException e11) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Failed to register", e11);
                }
            }
        }
    }

    private void unregister() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean isConnected(@NonNull Context context2) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context2.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException e11) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to determine connectivity status when connectivity changed", e11);
            }
            return true;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        register();
    }

    public void onStop() {
        unregister();
    }
}
