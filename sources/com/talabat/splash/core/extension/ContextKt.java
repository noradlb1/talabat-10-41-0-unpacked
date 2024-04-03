package com.talabat.splash.core.extension;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"networkInfo", "Landroid/net/NetworkInfo;", "Landroid/content/Context;", "getNetworkInfo", "(Landroid/content/Context;)Landroid/net/NetworkInfo;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContextKt {
    @Nullable
    public static final NetworkInfo getNetworkInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return ((ConnectivityManager) systemService).getActiveNetworkInfo();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
