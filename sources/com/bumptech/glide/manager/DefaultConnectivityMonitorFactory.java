package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;

public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    @NonNull
    public ConnectivityMonitor build(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z11;
        if (ContextCompat.checkSelfPermission(context, NETWORK_PERMISSION) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean isLoggable = Log.isLoggable(TAG, 3);
        if (z11) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
