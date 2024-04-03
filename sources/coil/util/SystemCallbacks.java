package coil.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.VisibleForTesting;
import coil.RealImageLoader;
import coil.network.NetworkObserver;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0019R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u00040\r8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcoil/util/SystemCallbacks;", "Landroid/content/ComponentCallbacks2;", "Lcoil/network/NetworkObserver$Listener;", "imageLoader", "Lcoil/RealImageLoader;", "context", "Landroid/content/Context;", "isNetworkObserverEnabled", "", "(Lcoil/RealImageLoader;Landroid/content/Context;Z)V", "_isOnline", "_isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getImageLoader$coil_base_release$annotations", "()V", "getImageLoader$coil_base_release", "()Ljava/lang/ref/WeakReference;", "isOnline", "()Z", "isShutdown", "networkObserver", "Lcoil/network/NetworkObserver;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onConnectivityChange", "onLowMemory", "onTrimMemory", "level", "", "shutdown", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SystemCallbacks implements ComponentCallbacks2, NetworkObserver.Listener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String OFFLINE = "OFFLINE";
    @NotNull
    private static final String ONLINE = "ONLINE";
    @NotNull
    private static final String TAG = "NetworkObserver";
    private volatile boolean _isOnline;
    @NotNull
    private final AtomicBoolean _isShutdown = new AtomicBoolean(false);
    @NotNull
    private final Context context;
    @NotNull
    private final WeakReference<RealImageLoader> imageLoader;
    @NotNull
    private final NetworkObserver networkObserver;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcoil/util/SystemCallbacks$Companion;", "", "()V", "OFFLINE", "", "ONLINE", "TAG", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SystemCallbacks(@NotNull RealImageLoader realImageLoader, @NotNull Context context2, boolean z11) {
        Intrinsics.checkNotNullParameter(realImageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.imageLoader = new WeakReference<>(realImageLoader);
        NetworkObserver invoke = NetworkObserver.Companion.invoke(context2, z11, this, realImageLoader.getLogger());
        this.networkObserver = invoke;
        this._isOnline = invoke.isOnline();
        context2.registerComponentCallbacks(this);
    }

    @VisibleForTesting
    public static /* synthetic */ void getImageLoader$coil_base_release$annotations() {
    }

    @NotNull
    public final WeakReference<RealImageLoader> getImageLoader$coil_base_release() {
        return this.imageLoader;
    }

    public final boolean isOnline() {
        return this._isOnline;
    }

    public final boolean isShutdown() {
        return this._isShutdown.get();
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        if (this.imageLoader.get() == null) {
            shutdown();
        }
    }

    public void onConnectivityChange(boolean z11) {
        String str;
        RealImageLoader realImageLoader = this.imageLoader.get();
        if (realImageLoader == null) {
            shutdown();
            return;
        }
        this._isOnline = z11;
        Logger logger = realImageLoader.getLogger();
        if (logger != null && logger.getLevel() <= 4) {
            if (z11) {
                str = ONLINE;
            } else {
                str = OFFLINE;
            }
            logger.log(TAG, 4, str, (Throwable) null);
        }
    }

    public void onLowMemory() {
        onTrimMemory(80);
    }

    public void onTrimMemory(int i11) {
        Unit unit;
        RealImageLoader realImageLoader = this.imageLoader.get();
        if (realImageLoader == null) {
            unit = null;
        } else {
            realImageLoader.onTrimMemory(i11);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            shutdown();
        }
    }

    public final void shutdown() {
        if (!this._isShutdown.getAndSet(true)) {
            this.context.unregisterComponentCallbacks(this);
            this.networkObserver.shutdown();
        }
    }
}
