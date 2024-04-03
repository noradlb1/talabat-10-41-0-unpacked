package com.talabat.talabatcore.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcore/platform/NetworkHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isConnected", "", "()Z", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkHandler {
    @NotNull
    private final Context context;

    @Inject
    public NetworkHandler(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @SuppressLint({"MissingPermission"})
    public final boolean isConnected() {
        Object systemService = this.context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
