package coil.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import coil.network.NetworkObserver;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"coil/network/NetworkObserverApi14$connectionReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NetworkObserverApi14$connectionReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NetworkObserver.Listener f39787a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkObserverApi14 f39788b;

    public NetworkObserverApi14$connectionReceiver$1(NetworkObserver.Listener listener, NetworkObserverApi14 networkObserverApi14) {
        this.f39787a = listener;
        this.f39788b = networkObserverApi14;
    }

    public void onReceive(@NotNull Context context, @Nullable Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent == null) {
            str = null;
        } else {
            str = intent.getAction();
        }
        if (Intrinsics.areEqual((Object) str, (Object) ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
            this.f39787a.onConnectivityChange(this.f39788b.isOnline());
        }
    }
}
