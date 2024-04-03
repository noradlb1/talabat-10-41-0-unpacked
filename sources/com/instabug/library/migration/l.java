package com.instabug.library.migration;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class l extends AbstractMigration {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f51494a;

    public l() {
        super("user_attributes_migration");
    }

    public void doAfterMigration() {
        SettingsManager.getInstance().setCurrentSDKVersion("11.7.0");
    }

    public void doPreMigration() {
    }

    public int getMigrationVersion() {
        return 1;
    }

    public void initialize(@NonNull Context context) {
        this.f51494a = new WeakReference(context);
    }

    public Observable migrate() {
        return Observable.create(new k(this));
    }

    public boolean shouldMigrate() {
        boolean z11;
        if (UserAttributesCacheManager.getAll() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        InstabugSDKLogger.v("IBG-Core", "Checking if old cache is existing and it's returning " + z11);
        return z11;
    }

    /* access modifiers changed from: private */
    public void a() {
        HashMap<String, String> all = UserAttributesCacheManager.getAll();
        if (all != null) {
            for (Map.Entry next : all.entrySet()) {
                UserAttributeCacheManager.insert((String) next.getKey(), (String) next.getValue());
            }
        }
        Cache cache = CacheManager.getInstance().getCache(UserAttributesCacheManager.USER_ATTRIBUTES_MEMORY_CACHE_KEY);
        if (cache != null) {
            CacheManager.getInstance().deleteCache(cache.getId());
        }
        Cache cache2 = CacheManager.getInstance().getCache(UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_KEY);
        if (cache2 != null) {
            CacheManager.getInstance().deleteCache(cache2.getId());
            CacheManager.getInstance().invalidateCache(cache2);
        }
    }
}
