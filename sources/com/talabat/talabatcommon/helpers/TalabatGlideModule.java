package com.talabat.talabatcommon.helpers;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.network.OKHttpBuilder;
import java.io.InputStream;
import java.util.ArrayList;

@GlideModule
public class TalabatGlideModule extends AppGlideModule {
    private int getMemCacheSize(int i11, Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 50000000;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return (int) ((((double) i11) * ((double) memoryInfo.availMem)) / 100.0d);
    }

    public static RequestOptions requestOptions() {
        return (RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).encodeFormat(Bitmap.CompressFormat.PNG)).encodeQuality(100)).format(DecodeFormat.PREFER_ARGB_8888)).signature(new ObjectKey(Long.valueOf(System.currentTimeMillis() / 86400000)))).diskCacheStrategy(DiskCacheStrategy.DATA);
    }

    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        glideBuilder.setDefaultRequestOptions(requestOptions());
        glideBuilder.setMemoryCache(new LruResourceCache((long) getMemCacheSize(8, context)));
        glideBuilder.setDiskCache(new InternalCacheDiskCacheFactory(context, (long) DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE));
        glideBuilder.setBitmapPool(new LruBitmapPool((long) (getMemCacheSize(8, context) / 10)));
    }

    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CitrusAdImageUrlInterceptor());
        try {
            arrayList.add(new QCommerceImageTrackingInterceptor(((FeatureFlagCoreLibApi) ((ApiContainer) context.getApplicationContext()).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag(), NfvObservabilityHandler.INSTANCE));
        } catch (Exception unused) {
        }
        glide.getRegistry().replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(OKHttpBuilder.INSTANCE.getDefaultHttpClient(arrayList, 20)));
    }
}
