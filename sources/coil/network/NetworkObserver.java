package coil.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.MainThread;
import androidx.core.content.ContextCompat;
import coil.util.Logger;
import coil.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bJ\b\u0010\u0005\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\t"}, d2 = {"Lcoil/network/NetworkObserver;", "", "isOnline", "", "()Z", "shutdown", "", "Companion", "Listener", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface NetworkObserver {
    @NotNull
    public static final Companion Companion = Companion.f39786a;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcoil/network/NetworkObserver$Companion;", "", "()V", "TAG", "", "invoke", "Lcoil/network/NetworkObserver;", "context", "Landroid/content/Context;", "isEnabled", "", "listener", "Lcoil/network/NetworkObserver$Listener;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final String TAG = "NetworkObserver";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39786a = new Companion();

        private Companion() {
        }

        @NotNull
        public final NetworkObserver invoke(@NotNull Context context, boolean z11, @NotNull Listener listener, @Nullable Logger logger) {
            boolean z12;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            if (!z11) {
                return EmptyNetworkObserver.INSTANCE;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
            if (connectivityManager != null) {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    try {
                        return new NetworkObserverApi21(connectivityManager, listener);
                    } catch (Exception e11) {
                        if (logger != null) {
                            Logs.log(logger, TAG, new RuntimeException("Failed to register network observer.", e11));
                        }
                        return EmptyNetworkObserver.INSTANCE;
                    }
                }
            }
            if (logger != null && logger.getLevel() <= 5) {
                logger.log(TAG, 5, "Unable to register network observer.", (Throwable) null);
            }
            return EmptyNetworkObserver.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcoil/network/NetworkObserver$Listener;", "", "onConnectivityChange", "", "isOnline", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Listener {
        @MainThread
        void onConnectivityChange(boolean z11);
    }

    boolean isOnline();

    void shutdown();
}
