package com.deliveryhero.chatui.view.chatroom.connectivity;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/connectivity/LegacyConnectivityMonitor;", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor;", "context", "Landroid/content/Context;", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/content/Context;Landroid/net/ConnectivityManager;)V", "filter", "Landroid/content/IntentFilter;", "receiver", "com/deliveryhero/chatui/view/chatroom/connectivity/LegacyConnectivityMonitor$receiver$1", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/LegacyConnectivityMonitor$receiver$1;", "startListening", "", "callback", "Lkotlin/Function1;", "", "stopListening", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyConnectivityMonitor extends ConnectivityMonitor {
    @NotNull
    private final Context context;
    @NotNull
    private final IntentFilter filter = new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
    @NotNull
    private final LegacyConnectivityMonitor$receiver$1 receiver = new LegacyConnectivityMonitor$receiver$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyConnectivityMonitor(@NotNull Context context2, @NotNull ConnectivityManager connectivityManager) {
        super(connectivityManager, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        this.context = context2;
    }

    public void startListening(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        boolean d11 = d();
        e(function1);
        a().invoke(Boolean.valueOf(d11));
        f(d11);
        this.context.registerReceiver(this.receiver, this.filter);
    }

    public void stopListening() {
        this.context.unregisterReceiver(this.receiver);
        e(LegacyConnectivityMonitor$stopListening$1.INSTANCE);
        f(false);
    }
}
