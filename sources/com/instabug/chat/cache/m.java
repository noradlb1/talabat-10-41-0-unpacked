package com.instabug.chat.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.chat.model.k;
import com.instabug.chat.model.o;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static m f46006a;

    private m() {
        CacheManager.getInstance().addCache(new InMemoryCache("read_queue_memory_cache_key"));
    }

    private void a(String str) {
        Cache cache = CacheManager.getInstance().getCache("read_queue_memory_cache_key");
        if (cache != null) {
            cache.delete(str);
        }
    }

    public static m b() {
        if (f46006a == null) {
            f46006a = new m();
        }
        return f46006a;
    }

    public static void d() {
        Cache cache = CacheManager.getInstance().getCache("read_queue_memory_cache_key");
        Cache cache2 = CacheManager.getInstance().getCache("read_queue_disk_cache_key");
        if (cache != null && cache2 != null) {
            InstabugSDKLogger.d("IBG-BR", "Saving In-memory cache to disk, no. of items to save is " + cache.getValues());
            CacheManager.getInstance().migrateCache(cache, cache2, new l());
        }
    }

    @VisibleForTesting
    public o a(@NonNull k kVar) {
        o oVar = new o();
        oVar.a(kVar.d());
        oVar.b(kVar.f());
        oVar.a(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds());
        return oVar;
    }

    public List a() {
        Cache cache = CacheManager.getInstance().getCache("read_queue_memory_cache_key");
        return cache != null ? cache.getValues() : new ArrayList();
    }

    public void a(o oVar) {
        InstabugSDKLogger.v("IBG-BR", "Adding message to read queue in-memory cache");
        Cache cache = CacheManager.getInstance().getCache("read_queue_memory_cache_key");
        if (cache != null && oVar != null && oVar.a() != null) {
            cache.put(oVar.a(), oVar);
            InstabugSDKLogger.v("IBG-BR", "Added message to read queue in-memory cache " + cache.size());
        }
    }

    public void a(List list) {
        for (o oVar : a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                o oVar2 = (o) it.next();
                if (!(oVar.a() == null || !oVar.a().equals(oVar2.a()) || oVar.b() == null || !oVar.b().equals(oVar2.b()) || oVar2.a() == null)) {
                    a(oVar2.a());
                }
            }
        }
    }

    public void b(@NonNull k kVar) {
        a(a(kVar));
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (o oVar : a()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("chat_number", (Object) oVar.a());
                jSONObject.put("message_id", (Object) oVar.b());
                jSONObject.put("read_at", oVar.c());
                jSONArray.put((Object) jSONObject);
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-BR", "Error: " + e11.getMessage() + " occurred while getting read messages");
            }
        }
        return jSONArray;
    }
}
