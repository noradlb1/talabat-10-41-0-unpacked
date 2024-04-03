package com.adyen.checkout.ui.internal.common.util;

import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.adyen.checkout.ui.R;
import com.google.android.material.snackbar.Snackbar;

public class ConnectivityDelegate {
    /* access modifiers changed from: private */
    public NetworkInfo mNetworkInfo;
    /* access modifiers changed from: private */
    public final Snackbar mSnackbar;

    public ConnectivityDelegate(@NonNull AppCompatActivity appCompatActivity) {
        this(appCompatActivity, (Observer<NetworkInfo>) null);
    }

    public boolean isConnectedOrConnecting() {
        NetworkInfo networkInfo = this.mNetworkInfo;
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public ConnectivityDelegate(@NonNull AppCompatActivity appCompatActivity, @Nullable Observer<NetworkInfo> observer) {
        this.mSnackbar = Snackbar.make(appCompatActivity.findViewById(16908290), R.string.checkout_error_message_network_unavailable, -2);
        ConnectivityLiveData connectivityLiveData = new ConnectivityLiveData(appCompatActivity.getApplication());
        connectivityLiveData.observe(appCompatActivity, new Observer<NetworkInfo>() {
            public void onChanged(@Nullable NetworkInfo networkInfo) {
                NetworkInfo unused = ConnectivityDelegate.this.mNetworkInfo = networkInfo;
                if (ConnectivityDelegate.this.isConnectedOrConnecting()) {
                    ConnectivityDelegate.this.mSnackbar.dismiss();
                } else {
                    ConnectivityDelegate.this.mSnackbar.show();
                }
            }
        });
        if (observer != null) {
            connectivityLiveData.observe(appCompatActivity, observer);
        }
    }
}
