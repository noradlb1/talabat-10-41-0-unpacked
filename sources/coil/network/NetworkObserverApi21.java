package coil.network;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import coil.network.NetworkObserver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(21)
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\f\u0010\u0007\u001a\u00020\b*\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, d2 = {"Lcoil/network/NetworkObserverApi21;", "Lcoil/network/NetworkObserver;", "connectivityManager", "Landroid/net/ConnectivityManager;", "listener", "Lcoil/network/NetworkObserver$Listener;", "(Landroid/net/ConnectivityManager;Lcoil/network/NetworkObserver$Listener;)V", "isOnline", "", "()Z", "networkCallback", "coil/network/NetworkObserverApi21$networkCallback$1", "Lcoil/network/NetworkObserverApi21$networkCallback$1;", "onConnectivityChange", "", "network", "Landroid/net/Network;", "shutdown", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@SuppressLint({"MissingPermission"})
final class NetworkObserverApi21 implements NetworkObserver {
    @NotNull
    private final ConnectivityManager connectivityManager;
    @NotNull
    private final NetworkObserver.Listener listener;
    @NotNull
    private final NetworkObserverApi21$networkCallback$1 networkCallback;

    public NetworkObserverApi21(@NotNull ConnectivityManager connectivityManager2, @NotNull NetworkObserver.Listener listener2) {
        Intrinsics.checkNotNullParameter(connectivityManager2, "connectivityManager");
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.connectivityManager = connectivityManager2;
        this.listener = listener2;
        NetworkObserverApi21$networkCallback$1 networkObserverApi21$networkCallback$1 = new NetworkObserverApi21$networkCallback$1(this);
        this.networkCallback = networkObserverApi21$networkCallback$1;
        connectivityManager2.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), networkObserverApi21$networkCallback$1);
    }

    /* access modifiers changed from: private */
    public final void onConnectivityChange(Network network, boolean z11) {
        boolean z12;
        Network[] allNetworks = this.connectivityManager.getAllNetworks();
        Intrinsics.checkNotNullExpressionValue(allNetworks, "connectivityManager.allNetworks");
        int length = allNetworks.length;
        boolean z13 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            Network network2 = allNetworks[i11];
            if (Intrinsics.areEqual((Object) network2, (Object) network)) {
                z12 = z11;
            } else {
                Intrinsics.checkNotNullExpressionValue(network2, "it");
                z12 = isOnline(network2);
            }
            if (z12) {
                z13 = true;
                break;
            }
            i11++;
        }
        this.listener.onConnectivityChange(z13);
    }

    public boolean isOnline() {
        Network[] allNetworks = this.connectivityManager.getAllNetworks();
        Intrinsics.checkNotNullExpressionValue(allNetworks, "connectivityManager.allNetworks");
        for (Network network : allNetworks) {
            Intrinsics.checkNotNullExpressionValue(network, "it");
            if (isOnline(network)) {
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
        this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
    }

    private final boolean isOnline(Network network) {
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}
