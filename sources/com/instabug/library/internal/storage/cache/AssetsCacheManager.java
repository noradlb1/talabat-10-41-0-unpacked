package com.instabug.library.internal.storage.cache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.Nullable;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.service.e;
import com.instabug.library.util.InstabugSDKLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
public class AssetsCacheManager {
    private static final String ASSETS_MEMORY_CACHE_KEY = "assets_memory_cache";
    private static final Map<String, b> currentDownloadingFiles = new ConcurrentHashMap();

    public interface OnDownloadFinished {
        void onFailed(Throwable th2);

        void onSuccess(AssetEntity assetEntity);
    }

    public static class b {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public AssetEntity f51024a;

        /* renamed from: b  reason: collision with root package name */
        public List f51025b = new ArrayList();

        public b a(AssetEntity assetEntity) {
            this.f51024a = assetEntity;
            return this;
        }

        public List b() {
            return this.f51025b;
        }

        public b a(List list) {
            this.f51025b = list;
            return this;
        }

        @Nullable
        public AssetEntity a() {
            return this.f51024a;
        }
    }

    public static void addAssetEntity(@Nullable AssetEntity assetEntity) {
        a cache = getCache();
        if (cache != null && assetEntity != null) {
            cache.put(assetEntity.getKey(), assetEntity);
        }
    }

    public static void cleanUpCache(Context context) {
        Cache cache;
        if (CacheManager.getInstance().cacheExists(ASSETS_MEMORY_CACHE_KEY) && (cache = CacheManager.getInstance().getCache(ASSETS_MEMORY_CACHE_KEY)) != null) {
            cache.invalidate();
        }
        clearRedundantFiles(context);
    }

    public static void clearRedundantFiles(Context context) {
        try {
            File[] listFiles = getCacheDirectory(context).listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while cleaning up cache directory", e11);
        }
    }

    public static AssetEntity createEmptyEntity(Context context, String str, AssetEntity.AssetType assetType) {
        return new AssetEntity(String.valueOf(str.hashCode()), assetType, str, new File(getCacheDirectory(context), String.valueOf(str.hashCode())));
    }

    public static void downloadAssetEntity(AssetEntity assetEntity, OnDownloadFinished onDownloadFinished) {
        if (assetEntity != null && onDownloadFinished != null) {
            b bVar = new b();
            bVar.a(assetEntity);
            List b11 = bVar.b();
            b11.add(new WeakReference(onDownloadFinished));
            bVar.a(b11);
            AssetEntity a11 = bVar.a();
            if (a11 != null) {
                currentDownloadingFiles.put(a11.getKey(), bVar);
            }
            e.a().a(assetEntity, new a(assetEntity));
        }
    }

    public static void getAssetEntity(AssetEntity assetEntity, OnDownloadFinished onDownloadFinished) {
        AssetEntity assetEntity2;
        a cache = getCache();
        if (cache != null) {
            assetEntity2 = (AssetEntity) cache.get(assetEntity.getKey());
        } else {
            assetEntity2 = null;
        }
        if (assetEntity2 != null && assetEntity2.getFile() != null && assetEntity2.getFile().exists()) {
            InstabugSDKLogger.v("IBG-Core", "Get file from cache");
            onDownloadFinished.onSuccess(assetEntity2);
        } else if (isDownloading(assetEntity.getKey())) {
            InstabugSDKLogger.v("IBG-Core", "File currently downloading, wait download to finish");
            waitDownloadToFinish(assetEntity, onDownloadFinished);
        } else {
            InstabugSDKLogger.v("IBG-Core", "File not exist download it");
            downloadAssetEntity(assetEntity, onDownloadFinished);
        }
    }

    @Nullable
    public static a getCache() {
        if (!CacheManager.getInstance().cacheExists(ASSETS_MEMORY_CACHE_KEY)) {
            InstabugSDKLogger.v("IBG-Core", "In-memory assets cache not found, create it");
            CacheManager.getInstance().addCache(new a(ASSETS_MEMORY_CACHE_KEY));
            InstabugSDKLogger.v("IBG-Core", "In-memory assets created successfully");
        }
        InstabugSDKLogger.v("IBG-Core", "In-memory assets cache found");
        return (a) CacheManager.getInstance().getCache(ASSETS_MEMORY_CACHE_KEY);
    }

    public static File getCacheDirectory(Context context) {
        String str;
        if (!Environment.getExternalStorageState().equals("mounted") || context.getExternalCacheDir() == null) {
            str = context.getCacheDir().getAbsolutePath();
        } else {
            str = context.getExternalCacheDir().getPath();
        }
        File file = new File(str + "/instabug/assetCache");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    public static boolean isDownloading(String str) {
        return currentDownloadingFiles.get(str) != null;
    }

    public static void notifyDownloadFailed(AssetEntity assetEntity, Throwable th2) {
        OnDownloadFinished onDownloadFinished;
        b bVar = currentDownloadingFiles.get(assetEntity.getKey());
        if (bVar != null) {
            for (WeakReference weakReference : bVar.b()) {
                if (!(weakReference == null || (onDownloadFinished = (OnDownloadFinished) weakReference.get()) == null)) {
                    onDownloadFinished.onFailed(th2);
                    currentDownloadingFiles.remove(assetEntity.getKey());
                }
            }
        }
    }

    public static void notifyDownloadFinishedSuccessfully(@Nullable AssetEntity assetEntity) {
        b bVar;
        OnDownloadFinished onDownloadFinished;
        if (assetEntity != null && (bVar = currentDownloadingFiles.get(assetEntity.getKey())) != null) {
            for (WeakReference weakReference : bVar.b()) {
                if (!(weakReference == null || (onDownloadFinished = (OnDownloadFinished) weakReference.get()) == null)) {
                    onDownloadFinished.onSuccess(assetEntity);
                    currentDownloadingFiles.remove(assetEntity.getKey());
                }
            }
        }
    }

    public static void waitDownloadToFinish(AssetEntity assetEntity, OnDownloadFinished onDownloadFinished) {
        b bVar = currentDownloadingFiles.get(assetEntity.getKey());
        if (bVar != null) {
            List b11 = bVar.b();
            b11.add(new WeakReference(onDownloadFinished));
            bVar.a(b11);
        }
    }

    public class a implements Request.Callbacks {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetEntity f51023a;

        public a(AssetEntity assetEntity) {
            this.f51023a = assetEntity;
        }

        /* renamed from: a */
        public void onSucceeded(@Nullable AssetEntity assetEntity) {
            if (assetEntity != null) {
                AssetsCacheManager.addAssetEntity(assetEntity);
                AssetsCacheManager.notifyDownloadFinishedSuccessfully(assetEntity);
            }
        }

        /* renamed from: a */
        public void onFailed(Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "downloading asset entity got error: ", th2);
            AssetsCacheManager.notifyDownloadFailed(this.f51023a, th2);
        }
    }
}
