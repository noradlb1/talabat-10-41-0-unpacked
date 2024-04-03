package com.instabug.library.networkv2;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.e0;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import gd.b;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f51645a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final d f51646b = new d();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f51647c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f51648d = LazyKt__LazyJVMKt.lazy(b.f51644a);

    /* renamed from: e  reason: collision with root package name */
    private static boolean f51649e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Set f51650f = new LinkedHashSet();

    private c() {
    }

    @JvmStatic
    @VisibleForTesting
    public static final void b() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            PoolProvider.postIOTask(new b(applicationContext));
        }
        f51649e = true;
    }

    /* access modifiers changed from: private */
    public static final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "$it");
        e0.c().a(context);
        SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.Network.TYPE_NETWORK, SDKCoreEvent.Network.VALUE_ACTIVATED));
    }

    @RequiresApi(21)
    @JvmStatic
    @VisibleForTesting
    public static final void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!f51647c) {
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addCapability(12).build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(build, f51645a.a());
            }
            f51647c = true;
        }
    }

    @JvmStatic
    public static final void e(@Nullable Context context) {
        ConnectivityManager connectivityManager;
        if (context != null) {
            try {
                Object systemService = context.getSystemService("connectivity");
                if (systemService instanceof ConnectivityManager) {
                    connectivityManager = (ConnectivityManager) systemService;
                } else {
                    connectivityManager = null;
                }
                if (connectivityManager != null) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        a(activeNetwork);
                    }
                }
            } catch (SecurityException e11) {
                InstabugSDKLogger.w("IBG-Core", StringsKt__IndentKt.trimIndent("\n            Could not read network state. To enable please add the following line in your AndroidManifest.xml <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\"/>\n            " + e11.getMessage() + "\n            "));
            } catch (Exception e12) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while checking network state", e12);
            }
            d(context);
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final void f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d dVar = f51646b;
        if (!dVar.a()) {
            dVar.a(context, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
    }

    @RequiresApi(21)
    @JvmStatic
    @VisibleForTesting
    public static final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f51647c) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(f51645a.a());
            }
            f51647c = false;
        }
    }

    @JvmStatic
    public static final void h(@Nullable Context context) {
        if (context != null) {
            g(context);
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final void i(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d dVar = f51646b;
        if (dVar.a()) {
            dVar.b(context);
        }
    }

    @NotNull
    public final ConnectivityManager.NetworkCallback a() {
        return (ConnectivityManager.NetworkCallback) f51648d.getValue();
    }

    public final boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f51649e;
    }

    @JvmStatic
    @VisibleForTesting
    public static final void a(@NotNull Network network) {
        Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
        if (!f51649e) {
            b();
        }
        f51650f.add(network);
        f51649e = true;
    }

    @JvmStatic
    @VisibleForTesting
    public static final void b(@NotNull Network network) {
        Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
        Set set = f51650f;
        if (set.contains(network)) {
            set.remove(network);
        }
        if (set.isEmpty()) {
            f51649e = false;
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean b(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (SecurityException e11) {
            InstabugSDKLogger.w("IBG-Core", StringsKt__IndentKt.trimIndent("\n            Could not read network state. To enable please add the following line in your AndroidManifest.xml <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\"/>\n            " + e11.getMessage() + "\n            "));
            return false;
        } catch (Exception e12) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while checking network state", e12);
            return false;
        }
    }
}
