package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0007\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020 H\u0017R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "componentCallbackMap", "", "Landroid/app/Activity;", "Landroid/content/ComponentCallbacks;", "extensionCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "windowListenerRegisteredContexts", "Landroid/os/IBinder;", "getWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "onWindowLayoutChangeListenerAdded", "", "onWindowLayoutChangeListenerRemoved", "register", "windowToken", "registerConfigurationChangeListener", "setExtensionCallback", "unregisterComponentCallback", "validateExtensionInterface", "", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarCompat implements ExtensionInterfaceCompat {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "SidecarCompat";
    @NotNull
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    /* access modifiers changed from: private */
    @Nullable
    public ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    @Nullable
    private final SidecarInterface sidecar;
    /* access modifiers changed from: private */
    @NotNull
    public final SidecarAdapter sidecarAdapter;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<IBinder, Activity> windowListenerRegisteredContexts;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "()V", "TAG", "", "sidecarVersion", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "getActivityWindowToken", "Landroid/os/IBinder;", "activity", "Landroid/app/Activity;", "getActivityWindowToken$window_release", "getSidecarCompat", "Landroidx/window/sidecar/SidecarInterface;", "context", "Landroid/content/Context;", "getSidecarCompat$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final IBinder getActivityWindowToken$window_release(@Nullable Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        @Nullable
        public final SidecarInterface getSidecarCompat$window_release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        @Nullable
        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (!TextUtils.isEmpty(apiVersion)) {
                    return Version.Companion.parse(apiVersion);
                }
                return null;
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "onWindowLayoutChanged", "", "activity", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        @NotNull
        @GuardedBy("mLock")
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo = new WeakHashMap<>();
        @NotNull
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        @NotNull
        private final ReentrantLock lock = new ReentrantLock();

        public DistinctElementCallback(@NotNull ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            Intrinsics.checkNotNullParameter(extensionCallbackInterface, "callbackInterface");
            this.callbackInterface = extensionCallbackInterface;
        }

        public void onWindowLayoutChanged(@NotNull Activity activity, @NotNull WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!Intrinsics.areEqual((Object) windowLayoutInfo, (Object) this.activityWindowLayoutInfo.get(activity))) {
                    WindowLayoutInfo put = this.activityWindowLayoutInfo.put(activity, windowLayoutInfo);
                    reentrantLock.unlock();
                    this.callbackInterface.onWindowLayoutChanged(activity, windowLayoutInfo);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/os/IBinder;", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "onDeviceStateChanged", "", "newDeviceState", "onWindowLayoutChanged", "token", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        @NotNull
        private final SidecarInterface.SidecarCallback callbackInterface;
        @Nullable
        @GuardedBy("lock")
        private SidecarDeviceState lastDeviceState;
        @NotNull
        private final ReentrantLock lock = new ReentrantLock();
        @NotNull
        @GuardedBy("mLock")
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo = new WeakHashMap<>();
        @NotNull
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(@NotNull SidecarAdapter sidecarAdapter2, @NotNull SidecarInterface.SidecarCallback sidecarCallback) {
            Intrinsics.checkNotNullParameter(sidecarAdapter2, "sidecarAdapter");
            Intrinsics.checkNotNullParameter(sidecarCallback, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter2;
            this.callbackInterface = sidecarCallback;
        }

        public void onDeviceStateChanged(@NotNull SidecarDeviceState sidecarDeviceState) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, sidecarDeviceState)) {
                    this.lastDeviceState = sidecarDeviceState;
                    this.callbackInterface.onDeviceStateChanged(sidecarDeviceState);
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(@NotNull IBinder iBinder, @NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            Intrinsics.checkNotNullParameter(iBinder, LegacyTokenLocalDataSourceImpl.KEY);
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "newLayout");
            synchronized (this.lock) {
                if (!this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(iBinder), sidecarWindowLayoutInfo)) {
                    SidecarWindowLayoutInfo put = this.mActivityWindowLayoutInfo.put(iBinder, sidecarWindowLayoutInfo);
                    this.callbackInterface.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "sidecarCompat", "Landroidx/window/layout/SidecarCompat;", "activity", "Landroid/app/Activity;", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        @NotNull
        private final WeakReference<Activity> activityWeakReference;
        @NotNull
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(@NotNull SidecarCompat sidecarCompat2, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(sidecarCompat2, "sidecarCompat");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.sidecarCompat = sidecarCompat2;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity != null && activityWindowToken$window_release != null) {
                this.sidecarCompat.register(activityWindowToken$window_release, activity);
            }
        }

        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "this$0");
            this.this$0 = sidecarCompat;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(@NotNull SidecarDeviceState sidecarDeviceState) {
            SidecarInterface sidecar;
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "newDeviceState");
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : this.this$0.windowListenerRegisteredContexts.values()) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (!(activityWindowToken$window_release == null || (sidecar = sidecarCompat.getSidecar()) == null)) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = sidecarCompat.extensionCallback;
                if (access$getExtensionCallback$p != null) {
                    access$getExtensionCallback$p.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(@NotNull IBinder iBinder, @NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            SidecarDeviceState sidecarDeviceState;
            Intrinsics.checkNotNullParameter(iBinder, "windowToken");
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(iBinder);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter access$getSidecarAdapter$p = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            if (sidecar == null) {
                sidecarDeviceState = null;
            } else {
                sidecarDeviceState = sidecar.getDeviceState();
            }
            if (sidecarDeviceState == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = access$getSidecarAdapter$p.translate(sidecarWindowLayoutInfo, sidecarDeviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = this.this$0.extensionCallback;
            if (access$getExtensionCallback$p != null) {
                access$getExtensionCallback$p.onWindowLayoutChanged(activity, translate);
            }
        }
    }

    @VisibleForTesting
    public SidecarCompat(@VisibleForTesting @Nullable SidecarInterface sidecarInterface, @NotNull SidecarAdapter sidecarAdapter2) {
        Intrinsics.checkNotNullParameter(sidecarAdapter2, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter2;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, activity);
            this.componentCallbackMap.put(activity, sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
            activity.registerComponentCallbacks(sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    @Nullable
    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    @NotNull
    @VisibleForTesting
    public final WindowLayoutInfo getWindowLayoutInfo(@NotNull Activity activity) {
        SidecarWindowLayoutInfo sidecarWindowLayoutInfo;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(CollectionsKt__CollectionsKt.emptyList());
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarDeviceState sidecarDeviceState = null;
        if (sidecarInterface == null) {
            sidecarWindowLayoutInfo = null;
        } else {
            sidecarWindowLayoutInfo = sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        }
        SidecarAdapter sidecarAdapter2 = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarDeviceState = sidecarInterface2.getDeviceState();
        }
        if (sidecarDeviceState == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter2.translate(sidecarWindowLayoutInfo, sidecarDeviceState);
    }

    public void onWindowLayoutChangeListenerAdded(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
    }

    public void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity) {
        boolean z11;
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            SidecarInterface sidecarInterface2 = this.sidecar;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
            }
            unregisterComponentCallback(activity);
            if (this.windowListenerRegisteredContexts.size() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
            if (z11 && (sidecarInterface = this.sidecar) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    public final void register(@NotNull IBinder iBinder, @NotNull Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(iBinder, "windowToken");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.windowListenerRegisteredContexts.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    public void setExtensionCallback(@NotNull ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        Intrinsics.checkNotNullParameter(extensionCallbackInterface, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:60|61|62|63|71|72|73|74|75|(4:77|(2:80|81)|79|98)(2:82|83)) */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r0v3, types: [int] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x010d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007e A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b2 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013c A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014e A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0166 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0172 A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017e A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018a A[Catch:{ NoSuchFieldError -> 0x00bb, all -> 0x0196 }] */
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validateExtensionInterface() {
        /*
            r8 = this;
            r0 = 0
            androidx.window.sidecar.SidecarInterface r1 = r8.sidecar     // Catch:{ all -> 0x0196 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0009
        L_0x0007:
            r1 = r3
            goto L_0x001c
        L_0x0009:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r4 = "setSidecarCallback"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x0196 }
            java.lang.Class<androidx.window.sidecar.SidecarInterface$SidecarCallback> r6 = androidx.window.sidecar.SidecarInterface.SidecarCallback.class
            r5[r0] = r6     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch:{ all -> 0x0196 }
        L_0x001c:
            if (r1 != 0) goto L_0x0020
            r1 = r3
            goto L_0x0024
        L_0x0020:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x0196 }
        L_0x0024:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x0196 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x0196 }
            if (r4 == 0) goto L_0x018a
            androidx.window.sidecar.SidecarInterface r1 = r8.sidecar     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            r1.getDeviceState()     // Catch:{ all -> 0x0196 }
        L_0x0034:
            androidx.window.sidecar.SidecarInterface r1 = r8.sidecar     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r1.onDeviceStateListenersChanged(r2)     // Catch:{ all -> 0x0196 }
        L_0x003c:
            androidx.window.sidecar.SidecarInterface r1 = r8.sidecar     // Catch:{ all -> 0x0196 }
            java.lang.Class<android.os.IBinder> r4 = android.os.IBinder.class
            if (r1 != 0) goto L_0x0044
        L_0x0042:
            r1 = r3
            goto L_0x0055
        L_0x0044:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x004b
            goto L_0x0042
        L_0x004b:
            java.lang.String r5 = "getWindowLayoutInfo"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0196 }
            r6[r0] = r4     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
        L_0x0055:
            if (r1 != 0) goto L_0x0059
            r1 = r3
            goto L_0x005d
        L_0x0059:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x0196 }
        L_0x005d:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r5 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)     // Catch:{ all -> 0x0196 }
            if (r5 == 0) goto L_0x017e
            androidx.window.sidecar.SidecarInterface r1 = r8.sidecar     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x006b
        L_0x0069:
            r1 = r3
            goto L_0x007c
        L_0x006b:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x0072
            goto L_0x0069
        L_0x0072:
            java.lang.String r5 = "onWindowLayoutChangeListenerAdded"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0196 }
            r6[r0] = r4     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
        L_0x007c:
            if (r1 != 0) goto L_0x0080
            r1 = r3
            goto L_0x0084
        L_0x0080:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x0196 }
        L_0x0084:
            java.lang.Class r5 = java.lang.Void.TYPE     // Catch:{ all -> 0x0196 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)     // Catch:{ all -> 0x0196 }
            if (r5 == 0) goto L_0x0172
            androidx.window.sidecar.SidecarInterface r1 = r8.sidecar     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x0092
        L_0x0090:
            r1 = r3
            goto L_0x00a3
        L_0x0092:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0196 }
            if (r1 != 0) goto L_0x0099
            goto L_0x0090
        L_0x0099:
            java.lang.String r5 = "onWindowLayoutChangeListenerRemoved"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0196 }
            r6[r0] = r4     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
        L_0x00a3:
            if (r1 != 0) goto L_0x00a6
            goto L_0x00aa
        L_0x00a6:
            java.lang.Class r3 = r1.getReturnType()     // Catch:{ all -> 0x0196 }
        L_0x00aa:
            java.lang.Class r1 = java.lang.Void.TYPE     // Catch:{ all -> 0x0196 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)     // Catch:{ all -> 0x0196 }
            if (r1 == 0) goto L_0x0166
            androidx.window.sidecar.SidecarDeviceState r1 = new androidx.window.sidecar.SidecarDeviceState     // Catch:{ all -> 0x0196 }
            r1.<init>()     // Catch:{ all -> 0x0196 }
            r3 = 3
            r1.posture = r3     // Catch:{ NoSuchFieldError -> 0x00bb }
            goto L_0x00ee
        L_0x00bb:
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "setPosture"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0196 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0196 }
            r6[r0] = r7     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0196 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r5[r0] = r6     // Catch:{ all -> 0x0196 }
            r4.invoke(r1, r5)     // Catch:{ all -> 0x0196 }
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "getPosture"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x0196 }
            java.lang.Object r1 = r4.invoke(r1, r5)     // Catch:{ all -> 0x0196 }
            if (r1 == 0) goto L_0x015e
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0196 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0196 }
            if (r1 != r3) goto L_0x0156
        L_0x00ee:
            androidx.window.sidecar.SidecarDisplayFeature r1 = new androidx.window.sidecar.SidecarDisplayFeature     // Catch:{ all -> 0x0196 }
            r1.<init>()     // Catch:{ all -> 0x0196 }
            android.graphics.Rect r3 = r1.getRect()     // Catch:{ all -> 0x0196 }
            java.lang.String r4 = "displayFeature.rect"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0196 }
            r1.setRect(r3)     // Catch:{ all -> 0x0196 }
            r1.getType()     // Catch:{ all -> 0x0196 }
            r1.setType(r2)     // Catch:{ all -> 0x0196 }
            androidx.window.sidecar.SidecarWindowLayoutInfo r3 = new androidx.window.sidecar.SidecarWindowLayoutInfo     // Catch:{ all -> 0x0196 }
            r3.<init>()     // Catch:{ all -> 0x0196 }
            java.util.List r0 = r3.displayFeatures     // Catch:{ NoSuchFieldError -> 0x010d }
            goto L_0x0144
        L_0x010d:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0196 }
            r4.<init>()     // Catch:{ all -> 0x0196 }
            r4.add(r1)     // Catch:{ all -> 0x0196 }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r1 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "setDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0196 }
            java.lang.Class<java.util.List> r7 = java.util.List.class
            r6[r0] = r7     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0196 }
            r5[r0] = r4     // Catch:{ all -> 0x0196 }
            r1.invoke(r3, r5)     // Catch:{ all -> 0x0196 }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r1 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "getDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0196 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r6)     // Catch:{ all -> 0x0196 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x0196 }
            java.lang.Object r1 = r1.invoke(r3, r5)     // Catch:{ all -> 0x0196 }
            if (r1 == 0) goto L_0x014e
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0196 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)     // Catch:{ all -> 0x0196 }
            if (r1 == 0) goto L_0x0146
        L_0x0144:
            r0 = r2
            goto L_0x0196
        L_0x0146:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "Invalid display feature getter/setter"
            r1.<init>(r2)     // Catch:{ all -> 0x0196 }
            throw r1     // Catch:{ all -> 0x0196 }
        L_0x014e:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r1.<init>(r2)     // Catch:{ all -> 0x0196 }
            throw r1     // Catch:{ all -> 0x0196 }
        L_0x0156:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "Invalid device posture getter/setter"
            r1.<init>(r2)     // Catch:{ all -> 0x0196 }
            throw r1     // Catch:{ all -> 0x0196 }
        L_0x015e:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Int"
            r1.<init>(r2)     // Catch:{ all -> 0x0196 }
            throw r1     // Catch:{ all -> 0x0196 }
        L_0x0166:
            java.lang.NoSuchMethodException r1 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)     // Catch:{ all -> 0x0196 }
            r1.<init>(r2)     // Catch:{ all -> 0x0196 }
            throw r1     // Catch:{ all -> 0x0196 }
        L_0x0172:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0196 }
            java.lang.String r3 = "Illegal return type for 'onWindowLayoutChangeListenerAdded': "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)     // Catch:{ all -> 0x0196 }
            r2.<init>(r1)     // Catch:{ all -> 0x0196 }
            throw r2     // Catch:{ all -> 0x0196 }
        L_0x017e:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0196 }
            java.lang.String r3 = "Illegal return type for 'getWindowLayoutInfo': "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)     // Catch:{ all -> 0x0196 }
            r2.<init>(r1)     // Catch:{ all -> 0x0196 }
            throw r2     // Catch:{ all -> 0x0196 }
        L_0x018a:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0196 }
            java.lang.String r3 = "Illegal return type for 'setSidecarCallback': "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)     // Catch:{ all -> 0x0196 }
            r2.<init>(r1)     // Catch:{ all -> 0x0196 }
            throw r2     // Catch:{ all -> 0x0196 }
        L_0x0196:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SidecarCompat(@NotNull Context context) {
        this(Companion.getSidecarCompat$window_release(context), new SidecarAdapter((SpecificationComputer.VerificationMode) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
