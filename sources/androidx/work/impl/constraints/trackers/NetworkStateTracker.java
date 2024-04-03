package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {

    /* renamed from: d  reason: collision with root package name */
    public static final String f38055d = Logger.tagWithPrefix("NetworkStateTracker");
    private NetworkStateBroadcastReceiver mBroadcastReceiver;
    private final ConnectivityManager mConnectivityManager = ((ConnectivityManager) this.f38051b.getSystemService("connectivity"));
    @RequiresApi(24)
    private NetworkStateCallback mNetworkCallback;

    public class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        public NetworkStateBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                Logger.get().debug(NetworkStateTracker.f38055d, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.setState(networkStateTracker.a());
            }
        }
    }

    @RequiresApi(24)
    public class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        public NetworkStateCallback() {
        }

        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            Logger.get().debug(NetworkStateTracker.f38055d, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.a());
        }

        public void onLost(@NonNull Network network) {
            Logger.get().debug(NetworkStateTracker.f38055d, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.a());
        }
    }

    public NetworkStateTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        if (isNetworkCallbackSupported()) {
            this.mNetworkCallback = new NetworkStateCallback();
        } else {
            this.mBroadcastReceiver = new NetworkStateBroadcastReceiver();
        }
    }

    private static boolean isNetworkCallbackSupported() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public NetworkState a() {
        boolean z11;
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        boolean z12 = true;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean b11 = b();
        boolean isActiveNetworkMetered = ConnectivityManagerCompat.isActiveNetworkMetered(this.mConnectivityManager);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z12 = false;
        }
        return new NetworkState(z11, b11, isActiveNetworkMetered, z12);
    }

    @VisibleForTesting
    public boolean b() {
        try {
            NetworkCapabilities networkCapabilities = this.mConnectivityManager.getNetworkCapabilities(this.mConnectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (SecurityException e11) {
            Logger.get().error(f38055d, "Unable to validate active network", e11);
            return false;
        }
    }

    public void startTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(f38055d, "Registering network callback", new Throwable[0]);
                this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException | SecurityException e11) {
                Logger.get().error(f38055d, "Received exception while registering network callback", e11);
            }
        } else {
            Logger.get().debug(f38055d, "Registering broadcast receiver", new Throwable[0]);
            this.f38051b.registerReceiver(this.mBroadcastReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
    }

    public void stopTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(f38055d, "Unregistering network callback", new Throwable[0]);
                this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException | SecurityException e11) {
                Logger.get().error(f38055d, "Received exception while unregistering network callback", e11);
            }
        } else {
            Logger.get().debug(f38055d, "Unregistering broadcast receiver", new Throwable[0]);
            this.f38051b.unregisterReceiver(this.mBroadcastReceiver);
        }
    }

    public NetworkState getInitialState() {
        return a();
    }
}
