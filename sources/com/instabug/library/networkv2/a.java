package com.instabug.library.networkv2;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.RequiresApi;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(21)
public final class a extends ConnectivityManager.NetworkCallback {
    public void onAvailable(@NotNull Network network) {
        Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
        super.onAvailable(network);
        InstabugSDKLogger.v("IBG-Core", "network connection available");
        c.a(network);
    }

    public void onLost(@NotNull Network network) {
        Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
        super.onLost(network);
        InstabugSDKLogger.v("IBG-Core", "network connection lost");
        c.b(network);
    }
}
