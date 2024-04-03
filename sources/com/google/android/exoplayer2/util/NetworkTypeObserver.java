package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import n8.e;
import n8.h;

public final class NetworkTypeObserver {
    @Nullable
    private static NetworkTypeObserver staticInstance;
    private final CopyOnWriteArrayList<WeakReference<Listener>> listeners = new CopyOnWriteArrayList<>();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    @GuardedBy("networkTypeLock")
    private int networkType = 0;
    private final Object networkTypeLock = new Object();

    @RequiresApi(31)
    public static final class Api31 {

        public static final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
            private final NetworkTypeObserver instance;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.instance = networkTypeObserver;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                boolean z11;
                int a11 = h.a(telephonyDisplayInfo);
                int i11 = 5;
                if (a11 == 3 || a11 == 4 || a11 == 5) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                NetworkTypeObserver networkTypeObserver = this.instance;
                if (z11) {
                    i11 = 10;
                }
                networkTypeObserver.updateNetworkType(i11);
            }
        }

        private Api31() {
        }

        public static void disambiguate4gAnd5gNsa(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) Assertions.checkNotNull((TelephonyManager) context.getSystemService("phone"));
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                networkTypeObserver.updateNetworkType(5);
            }
        }
    }

    public interface Listener {
        void onNetworkTypeChanged(int i11);
    }

    public final class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int access$100 = NetworkTypeObserver.getNetworkTypeFromConnectivityManager(context);
            if (Util.SDK_INT < 31 || access$100 != 5) {
                NetworkTypeObserver.this.updateNetworkType(access$100);
            } else {
                Api31.disambiguate4gAnd5gNsa(context, NetworkTypeObserver.this);
            }
        }
    }

    private NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        context.registerReceiver(new Receiver(), intentFilter);
    }

    public static synchronized NetworkTypeObserver getInstance(Context context) {
        NetworkTypeObserver networkTypeObserver;
        synchronized (NetworkTypeObserver.class) {
            if (staticInstance == null) {
                staticInstance = new NetworkTypeObserver(context);
            }
            networkTypeObserver = staticInstance;
        }
        return networkTypeObserver;
    }

    private static int getMobileNetworkType(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 18:
                return 2;
            case 20:
                if (Util.SDK_INT >= 29) {
                    return 9;
                }
                return 0;
            default:
                return 6;
        }
    }

    /* access modifiers changed from: private */
    public static int getNetworkTypeFromConnectivityManager(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i11 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i11 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type == 6) {
                            return 5;
                        }
                        if (type != 9) {
                            return 8;
                        }
                        return 7;
                    }
                }
                return getMobileNetworkType(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$register$0(Listener listener) {
        listener.onNetworkTypeChanged(getNetworkType());
    }

    private void removeClearedReferences() {
        Iterator<WeakReference<Listener>> it = this.listeners.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (next.get() == null) {
                this.listeners.remove(next);
            }
        }
    }

    @VisibleForTesting
    public static synchronized void resetForTests() {
        synchronized (NetworkTypeObserver.class) {
            staticInstance = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r0.hasNext() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = r0.next();
        r2 = (com.google.android.exoplayer2.util.NetworkTypeObserver.Listener) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r2 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r2.onNetworkTypeChanged(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.listeners.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = r3.listeners.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateNetworkType(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.networkTypeLock
            monitor-enter(r0)
            int r1 = r3.networkType     // Catch:{ all -> 0x0031 }
            if (r1 != r4) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0009:
            r3.networkType = r4     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.google.android.exoplayer2.util.NetworkTypeObserver$Listener>> r0 = r3.listeners
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            com.google.android.exoplayer2.util.NetworkTypeObserver$Listener r2 = (com.google.android.exoplayer2.util.NetworkTypeObserver.Listener) r2
            if (r2 == 0) goto L_0x002a
            r2.onNetworkTypeChanged(r4)
            goto L_0x0012
        L_0x002a:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.google.android.exoplayer2.util.NetworkTypeObserver$Listener>> r2 = r3.listeners
            r2.remove(r1)
            goto L_0x0012
        L_0x0030:
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NetworkTypeObserver.updateNetworkType(int):void");
    }

    public int getNetworkType() {
        int i11;
        synchronized (this.networkTypeLock) {
            i11 = this.networkType;
        }
        return i11;
    }

    public void register(Listener listener) {
        removeClearedReferences();
        this.listeners.add(new WeakReference(listener));
        this.mainHandler.post(new e(this, listener));
    }
}
