package com.talabat.darkstores.data;

import android.net.ConnectivityManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/net/ConnectivityManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NetworkConnectionInterceptor$connectivityManager$2 extends Lambda implements Function0<ConnectivityManager> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NetworkConnectionInterceptor f56181g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectionInterceptor$connectivityManager$2(NetworkConnectionInterceptor networkConnectionInterceptor) {
        super(0);
        this.f56181g = networkConnectionInterceptor;
    }

    @NotNull
    public final ConnectivityManager invoke() {
        Object systemService = this.f56181g.context.getSystemService("connectivity");
        if (systemService != null) {
            return (ConnectivityManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
