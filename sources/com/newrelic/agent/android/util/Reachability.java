package com.newrelic.agent.android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Reachability {
    private static final int REACHABILITY_TIMEOUT = 500;

    @SuppressLint({"NewApi"})
    public static boolean hasReachableNetworkConnection(Context context, String str) {
        boolean z11;
        Socket socket;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    z11 = activeNetworkInfo.isConnectedOrConnecting();
                } else {
                    z11 = false;
                }
                if (z11 && str != null) {
                    socket = new Socket();
                    socket.connect(new InetSocketAddress(str, 443), 500);
                    socket.close();
                }
            } else {
                z11 = true;
            }
            return z11;
        } catch (Exception unused) {
            return false;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
