package com.deliveryhero.chatui.view.chatroom.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/deliveryhero/chatui/view/chatroom/connectivity/LegacyConnectivityMonitor$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyConnectivityMonitor$receiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LegacyConnectivityMonitor f29633a;

    public LegacyConnectivityMonitor$receiver$1(LegacyConnectivityMonitor legacyConnectivityMonitor) {
        this.f29633a = legacyConnectivityMonitor;
    }

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        boolean d11 = this.f29633a.d();
        if (this.f29633a.c() != d11) {
            this.f29633a.a().invoke(Boolean.valueOf(d11));
            this.f29633a.f(d11);
        }
    }
}
