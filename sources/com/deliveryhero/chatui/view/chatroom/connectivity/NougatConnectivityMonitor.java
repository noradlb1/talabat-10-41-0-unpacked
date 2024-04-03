package com.deliveryhero.chatui.view.chatroom.connectivity;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0006\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/connectivity/NougatConnectivityMonitor;", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor;", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "networkCallback", "com/deliveryhero/chatui/view/chatroom/connectivity/NougatConnectivityMonitor$networkCallback$1", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/NougatConnectivityMonitor$networkCallback$1;", "startListening", "", "callback", "Lkotlin/Function1;", "", "stopListening", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@TargetApi(24)
public final class NougatConnectivityMonitor extends ConnectivityMonitor {
    @NotNull
    private final NougatConnectivityMonitor$networkCallback$1 networkCallback = new NougatConnectivityMonitor$networkCallback$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NougatConnectivityMonitor(@NotNull ConnectivityManager connectivityManager) {
        super(connectivityManager, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
    }

    public void startListening(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        e(function1);
        boolean d11 = d();
        a().invoke(Boolean.valueOf(d11));
        f(d11);
        b().registerDefaultNetworkCallback(this.networkCallback);
    }

    public void stopListening() {
        b().unregisterNetworkCallback(this.networkCallback);
        e(NougatConnectivityMonitor$stopListening$1.INSTANCE);
        f(false);
    }
}
