package com.instabug.library.experiments.di;

import androidx.annotation.Nullable;
import com.instabug.library.experiments.cache.b;
import com.instabug.library.experiments.e;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f34362a = new HashMap();

    @Nullable
    private static Object a(String str) {
        Map map = f34362a;
        if (map.containsKey(str)) {
            return ((WeakReference) map.get(str)).get();
        }
        return null;
    }

    public static synchronized com.instabug.library.experiments.cache.a b() {
        com.instabug.library.experiments.cache.a aVar;
        synchronized (a.class) {
            String name2 = com.instabug.library.experiments.cache.a.class.getName();
            Object a11 = a(name2);
            if (a11 == null) {
                a11 = new b();
                f34362a.put(name2, new WeakReference(a11));
            }
            aVar = (com.instabug.library.experiments.cache.a) a11;
        }
        return aVar;
    }

    public static synchronized com.instabug.library.experiments.a c() {
        com.instabug.library.experiments.a aVar;
        synchronized (a.class) {
            String name2 = com.instabug.library.experiments.a.class.getName();
            Object a11 = a(name2);
            if (a11 == null) {
                a11 = new e();
                f34362a.put(name2, new WeakReference(a11));
            }
            aVar = (com.instabug.library.experiments.a) a11;
        }
        return aVar;
    }

    public static int d() {
        SettingsManager instance = SettingsManager.getInstance();
        if (instance != null) {
            return instance.getExperimentsStoreLimit();
        }
        return 200;
    }

    public static synchronized Executor e() {
        ThreadPoolExecutor backgroundExecutor;
        synchronized (a.class) {
            backgroundExecutor = PoolProvider.getInstance().getBackgroundExecutor();
        }
        return backgroundExecutor;
    }

    public static synchronized DatabaseManager a() {
        DatabaseManager instance;
        synchronized (a.class) {
            instance = DatabaseManager.getInstance();
        }
        return instance;
    }
}
