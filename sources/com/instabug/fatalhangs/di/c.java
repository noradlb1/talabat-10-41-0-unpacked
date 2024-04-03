package com.instabug.fatalhangs.di;

import android.content.Context;
import android.os.Looper;
import com.instabug.commons.configurations.a;
import com.instabug.fatalhangs.configuration.d;
import com.instabug.fatalhangs.sync.b;
import com.instabug.fatalhangs.sync.i;
import com.instabug.library.Instabug;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f46466a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map f46467b = new LinkedHashMap();
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f46468c = LazyKt__LazyJVMKt.lazy(b.f46465a);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f46469d = LazyKt__LazyJVMKt.lazy(a.f46464a);

    private c() {
    }

    private final void a(String str, Object obj) {
        f46467b.put(str, new WeakReference(obj));
    }

    private final Object b(String str) {
        Map map = f46467b;
        if (map.containsKey(str) && map.get(str) != null) {
            Object obj = map.get(str);
            Intrinsics.checkNotNull(obj);
            if (((WeakReference) obj).get() != null) {
                Object obj2 = map.get(str);
                Intrinsics.checkNotNull(obj2);
                return ((WeakReference) obj2).get();
            }
        }
        return null;
    }

    @NotNull
    public final a c() {
        return (a) f46469d.getValue();
    }

    @NotNull
    public final d d() {
        return (d) f46468c.getValue();
    }

    @NotNull
    public final synchronized b e() {
        Object b11;
        String obj = Reflection.getOrCreateKotlinClass(b.class).toString();
        b11 = b(obj);
        if (b11 == null) {
            b11 = new i();
            a(obj, b11);
        }
        return (b) b11;
    }

    @Nullable
    public final ThreadPoolExecutor f() {
        return PoolProvider.getInstance().getIOExecutor();
    }

    @NotNull
    public final NetworkManager g() {
        return new NetworkManager();
    }

    public final int h() {
        return 100;
    }

    @NotNull
    public final InstabugInternalTrackingDelegate i() {
        InstabugInternalTrackingDelegate instance = InstabugInternalTrackingDelegate.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @Nullable
    public final Context a() {
        return Instabug.getApplicationContext();
    }

    @NotNull
    public final Thread a(@NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        return new com.instabug.fatalhangs.i(function1, (Looper) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final File a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return new File(str);
    }

    @NotNull
    public final com.instabug.fatalhangs.cache.a b() {
        String obj = Reflection.getOrCreateKotlinClass(com.instabug.fatalhangs.cache.a.class).toString();
        Object b11 = b(obj);
        if (b11 == null) {
            b11 = new com.instabug.fatalhangs.cache.b();
            a(obj, b11);
        }
        return (com.instabug.fatalhangs.cache.a) b11;
    }
}
