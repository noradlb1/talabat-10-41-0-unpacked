package com.talabat.splash.core.platform;

import android.content.Context;
import android.net.NetworkInfo;
import com.talabat.splash.core.extension.ContextKt;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/splash/core/platform/NetworkHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isConnected", "", "()Ljava/lang/Boolean;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkHandler {
    @NotNull
    private final Context context;

    @Inject
    public NetworkHandler(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Nullable
    public final Boolean isConnected() {
        NetworkInfo networkInfo = ContextKt.getNetworkInfo(this.context);
        if (networkInfo != null) {
            return Boolean.valueOf(networkInfo.isConnected());
        }
        return null;
    }
}
