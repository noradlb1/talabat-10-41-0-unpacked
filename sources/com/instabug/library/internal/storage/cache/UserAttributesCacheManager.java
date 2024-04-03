package com.instabug.library.internal.storage.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.model.UserAttributes;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.util.HashMap;

public class UserAttributesCacheManager {
    public static final String USER_ATTRIBUTES_CACHE_KEY = "attrs";
    public static final String USER_ATTRIBUTES_DISK_CACHE_FILE_NAME = "/user_attributes.cache";
    public static final String USER_ATTRIBUTES_DISK_CACHE_KEY = "user_attributes_disk_cache";
    public static final String USER_ATTRIBUTES_MEMORY_CACHE_KEY = "user_attributes_memory_cache";

    public class a extends CacheManager.KeyExtractor {
        /* renamed from: a */
        public String extractKey(UserAttributes userAttributes) {
            return UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY;
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f51029b;

        public b(Context context) {
            this.f51029b = context;
        }

        public void run() {
            UserAttributesCacheManager.prepareUserAttributesCache(this.f51029b);
        }
    }

    @Nullable
    public static HashMap<String, String> getAll() {
        UserAttributes userAttributes;
        InMemoryCache<String, UserAttributes> cache = getCache();
        if (cache != null) {
            userAttributes = cache.get(USER_ATTRIBUTES_CACHE_KEY);
        } else {
            userAttributes = null;
        }
        if (userAttributes == null || userAttributes.getMap() == null || userAttributes.getMap().isEmpty()) {
            return null;
        }
        return userAttributes.getMap();
    }

    @Nullable
    public static InMemoryCache<String, UserAttributes> getCache() {
        CacheManager.getInstance().migrateCache(USER_ATTRIBUTES_DISK_CACHE_KEY, USER_ATTRIBUTES_MEMORY_CACHE_KEY, new a());
        return (InMemoryCache) CacheManager.getInstance().getCache(USER_ATTRIBUTES_MEMORY_CACHE_KEY);
    }

    public static void prepareCaches(Context context) {
        PoolProvider.postIOTaskWithCheck(new b(context));
    }

    /* access modifiers changed from: private */
    public static void prepareUserAttributesCache(Context context) {
        InstabugSDKLogger.v("IBG-Core", "Creating UserAttributes disk cache");
        CacheManager.getInstance().addCache(new OnDiskCache(context, USER_ATTRIBUTES_DISK_CACHE_KEY, USER_ATTRIBUTES_DISK_CACHE_FILE_NAME, UserAttributes.class));
    }
}
