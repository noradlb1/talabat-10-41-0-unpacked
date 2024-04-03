package com.deliveryhero.chatui.view.chatroom.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/deliveryhero/chatui/view/chatroom/connectivity/NougatConnectivityMonitor$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NougatConnectivityMonitor$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NougatConnectivityMonitor f29634a;

    public NougatConnectivityMonitor$networkCallback$1(NougatConnectivityMonitor nougatConnectivityMonitor) {
        this.f29634a = nougatConnectivityMonitor;
    }

    public void onAvailable(@NotNull Network network) {
        Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
        super.onAvailable(network);
        if (!this.f29634a.c()) {
            this.f29634a.a().invoke(Boolean.TRUE);
            this.f29634a.f(true);
        }
    }

    public void onLost(@NotNull Network network) {
        Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
        super.onLost(network);
        if (this.f29634a.c()) {
            this.f29634a.a().invoke(Boolean.FALSE);
            this.f29634a.f(false);
        }
    }
}
