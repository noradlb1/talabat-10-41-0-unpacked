package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = new Object();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, Object> f37628a = new HashMap();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Set<Class<? extends Initializer<?>>> f37629b = new HashSet();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Context f37630c;

    public AppInitializer(@NonNull Context context) {
        this.f37630c = context.getApplicationContext();
    }

    @NonNull
    private <T> T doInitialize(@NonNull Class<? extends Initializer<?>> cls, @NonNull Set<Class<?>> set) {
        T t11;
        if (Trace.isEnabled()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f37628a.containsKey(cls)) {
                set.add(cls);
                Initializer initializer = (Initializer) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends Initializer<?>>> dependencies = initializer.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class next : dependencies) {
                        if (!this.f37628a.containsKey(next)) {
                            doInitialize(next, set);
                        }
                    }
                }
                t11 = initializer.create(this.f37630c);
                set.remove(cls);
                this.f37628a.put(cls, t11);
            } else {
                t11 = this.f37628a.get(cls);
            }
            Trace.endSection();
            return t11;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    @NonNull
    public static AppInitializer getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new AppInitializer(context);
                }
            }
        }
        return sInstance;
    }

    public void a() {
        try {
            Trace.beginSection(SECTION_NAME);
            b(this.f37630c.getPackageManager().getProviderInfo(new ComponentName(this.f37630c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            Trace.endSection();
        } catch (PackageManager.NameNotFoundException e11) {
            throw new StartupException((Throwable) e11);
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public void b(@Nullable Bundle bundle) {
        String string = this.f37630c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.f37629b.add(cls);
                        }
                    }
                }
                for (Class<? extends Initializer<?>> doInitialize : this.f37629b) {
                    doInitialize(doInitialize, hashSet);
                }
            } catch (ClassNotFoundException e11) {
                throw new StartupException((Throwable) e11);
            }
        }
    }

    @NonNull
    public <T> T c(@NonNull Class<? extends Initializer<?>> cls) {
        T t11;
        synchronized (sLock) {
            t11 = this.f37628a.get(cls);
            if (t11 == null) {
                t11 = doInitialize(cls, new HashSet());
            }
        }
        return t11;
    }

    @NonNull
    public <T> T initializeComponent(@NonNull Class<? extends Initializer<T>> cls) {
        return c(cls);
    }

    public boolean isEagerlyInitialized(@NonNull Class<? extends Initializer<?>> cls) {
        return this.f37629b.contains(cls);
    }
}
