package com.instabug.crash.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.commons.b;
import com.instabug.commons.configurations.a;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.crash.configurations.c;
import com.instabug.crash.settings.f;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f46399a = new d();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f46400b = LazyKt__LazyJVMKt.lazy(c.f46398a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f46401c = LazyKt__LazyJVMKt.lazy(a.f46397a);

    private d() {
    }

    @NotNull
    public static final c b() {
        return (c) f46401c.getValue();
    }

    @NotNull
    public static final b c() {
        return CommonsLocator.INSTANCE.getDetectorsListenersRegistry();
    }

    /* access modifiers changed from: private */
    public final SharedPreferences d() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return CoreServiceLocator.getInstabugSharedPreferences(applicationContext, "instabug_crash");
    }

    @NotNull
    public static final List e() {
        return (List) f46400b.getValue();
    }

    @JvmStatic
    @NotNull
    public static final a a() {
        return new com.instabug.crash.configurations.b();
    }

    @NotNull
    public final f a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new f(context);
    }

    @NotNull
    public final PreferencesProperty a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "keyValue");
        return new b((String) pair.getFirst(), pair.getSecond());
    }
}
