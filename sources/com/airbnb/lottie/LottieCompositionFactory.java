package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.deliveryhero.chatui.data.datasource.ImageFileProviderImpl;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import g3.e;
import g3.f;
import g3.g;
import g3.h;
import g3.i;
import g3.j;
import g3.k;
import g3.l;
import g3.m;
import g3.n;
import g3.o;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.json.JSONObject;

@Instrumented
public class LottieCompositionFactory {
    private static final byte[] MAGIC = {80, TarConstants.LF_GNUTYPE_LONGLINK, 3, 4};
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    private LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> cache(@Nullable String str, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            lottieComposition = LottieCompositionCache.getInstance().get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask<>(new i(lottieComposition));
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.addListener(new j(str, atomicBoolean));
            lottieTask.addFailureListener(new k(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                taskCache.put(str, lottieTask);
            }
        }
        return lottieTask;
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        L.networkCache(context).clear();
    }

    @Nullable
    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset next : lottieComposition.getImages().values()) {
            if (next.getFileName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, @Nullable String str) {
        return cache(str, new h(jSONObject, str));
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, @Nullable String str) {
        return cache(str, new m(inputStream, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, @Nullable String str) {
        return cache(str, new e(jsonReader, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, @Nullable String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, @Nullable String str, boolean z11) {
        try {
            LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, parse);
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
            if (z11) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult;
        } catch (Exception e11) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e11);
            if (z11) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult2;
        } catch (Throwable th2) {
            if (z11) {
                Utils.closeQuietly(jsonReader);
            }
            throw th2;
        }
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, @Nullable String str2) {
        return cache(str2, new l(str, str2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonStringSync(String str, @Nullable String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source((InputStream) new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, @Nullable String str) {
        return fromJsonStringSync(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i11) {
        return fromRawRes(context, i11, rawResCacheKey(context, i11));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i11) {
        return fromRawResSync(context, i11, rawResCacheKey(context, i11));
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, @Nullable String str) {
        return cache(str, new n(zipInputStream, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name2 = nextEntry.getName();
                if (name2.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).getValue();
                } else {
                    if (!name2.contains(".png") && !name2.contains(".webp") && !name2.contains(ImageFileProviderImpl.IMAGE_SUFFIX)) {
                        if (!name2.contains(".jpeg")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name2.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactoryInstrumentation.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                }
            }
            for (Map.Entry next : lottieComposition.getImages().entrySet()) {
                if (((LottieImageAsset) next.getValue()).getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + ((LottieImageAsset) next.getValue()).getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b11 : MAGIC) {
                if (peek.readByte() != b11) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        } catch (Exception e11) {
            Logger.error("Failed to check zip file header", e11);
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$10(String str, AtomicBoolean atomicBoolean, Throwable th2) {
        taskCache.remove(str);
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$cache$8(LottieComposition lottieComposition) throws Exception {
        return new LottieResult(lottieComposition);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$9(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        taskCache.remove(str);
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromRawRes$2(WeakReference weakReference, Context context, int i11, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i11, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromUrl$0(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (!(str2 == null || fetchSync.getValue() == null)) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    private static String rawResCacheKey(Context context, @RawRes int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(isNightMode(context) ? "_night_" : "_day_");
        sb2.append(i11);
        return sb2.toString();
    }

    public static void setMaxCacheSize(int i11) {
        LottieCompositionCache.getInstance().resize(i11);
    }

    @WorkerThread
    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str, boolean z11) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z11) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i11, @Nullable String str) {
        return cache(str, new f(new WeakReference(context), context.getApplicationContext(), i11, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i11, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i11)));
            if (isZipCompressed(buffer).booleanValue()) {
                return fromZipStreamSync(new ZipInputStream(buffer.inputStream()), str);
            }
            return fromJsonInputStreamSync(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str, @Nullable String str2) {
        return cache(str2, new g(context, str, str2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, @Nullable String str2) {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (!(str2 == null || fetchSync.getValue() == null)) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str, @Nullable String str2) {
        return cache(str2, new o(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip")) {
                if (!str.endsWith(".lottie")) {
                    return fromJsonInputStreamSync(context.getAssets().open(str), str2);
                }
            }
            return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }
}
