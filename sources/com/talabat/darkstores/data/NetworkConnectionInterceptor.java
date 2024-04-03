package com.talabat.darkstores.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.talabat.localization.R;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/data/NetworkConnectionInterceptor;", "Lokhttp3/Interceptor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isConnected", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkConnectionInterceptor implements Interceptor {
    @NotNull
    private final Lazy connectivityManager$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new NetworkConnectionInterceptor$connectivityManager$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;

    @Inject
    public NetworkConnectionInterceptor(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager$delegate.getValue();
    }

    private final boolean isConnected() {
        NetworkInfo activeNetworkInfo = getConnectivityManager().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (isConnected()) {
            return chain.proceed(chain.request());
        }
        throw new NetworkConnectionException(this.context.getString(R.string.no_internet_connection_error));
    }
}
