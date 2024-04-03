package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    @GuardedBy("Glide.class")
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    @GuardedBy("this")
    @Nullable
    private BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    @GuardedBy("managers")
    private final List<RequestManager> managers = new ArrayList();
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory = MemoryCategory.NORMAL;
    private final Registry registry;
    private final RequestManagerRetriever requestManagerRetriever;

    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    public Glide(@NonNull Context context, @NonNull Engine engine2, @NonNull MemoryCache memoryCache2, @NonNull BitmapPool bitmapPool2, @NonNull ArrayPool arrayPool2, @NonNull RequestManagerRetriever requestManagerRetriever2, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory2, int i11, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, GlideExperiments glideExperiments) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Registry registry2;
        Context context2 = context;
        BitmapPool bitmapPool3 = bitmapPool2;
        ArrayPool arrayPool3 = arrayPool2;
        this.engine = engine2;
        this.bitmapPool = bitmapPool3;
        this.arrayPool = arrayPool3;
        this.memoryCache = memoryCache2;
        this.requestManagerRetriever = requestManagerRetriever2;
        this.connectivityMonitorFactory = connectivityMonitorFactory2;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry3 = new Registry();
        this.registry = registry3;
        registry3.register((ImageHeaderParser) new DefaultImageHeaderParser());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 27) {
            registry3.register((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> imageHeaderParsers = registry3.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, imageHeaderParsers, bitmapPool3, arrayPool3);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel = VideoDecoder.parcel(bitmapPool2);
        Downsampler downsampler = new Downsampler(registry3.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool3, arrayPool3);
        if (!glideExperiments.isEnabled(GlideBuilder.EnableImageDecoderForBitmaps.class) || i12 < 28) {
            resourceDecoder = new ByteBufferBitmapDecoder(downsampler);
            resourceDecoder2 = new StreamBitmapDecoder(downsampler, arrayPool3);
        } else {
            resourceDecoder2 = new InputStreamBitmapImageDecoderResourceDecoder();
            resourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        int i13 = i12;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool3);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory2 = assetFileDescriptorFactory;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        ResourceLoader.UriFactory uriFactory2 = uriFactory;
        Class<ByteBuffer> cls = ByteBuffer.class;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory2 = fileDescriptorFactory;
        ResourceLoader.StreamFactory streamFactory2 = streamFactory;
        Class<InputStream> cls2 = InputStream.class;
        ResourceDrawableDecoder resourceDrawableDecoder2 = resourceDrawableDecoder;
        Class<Bitmap> cls3 = Bitmap.class;
        registry3.append(cls, new ByteBufferEncoder()).append(cls2, new StreamEncoder(arrayPool3)).append(Registry.BUCKET_BITMAP, cls, cls3, resourceDecoder).append(Registry.BUCKET_BITMAP, cls2, cls3, resourceDecoder2);
        Class<ParcelFileDescriptor> cls4 = ParcelFileDescriptor.class;
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry3.append(Registry.BUCKET_BITMAP, cls4, cls3, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        Registry registry4 = registry3;
        Class<AssetFileDescriptor> cls5 = AssetFileDescriptor.class;
        Class<AssetFileDescriptor> cls6 = cls5;
        Class<BitmapDrawable> cls7 = BitmapDrawable.class;
        Registry append = registry3.append(Registry.BUCKET_BITMAP, cls4, cls3, parcel).append(Registry.BUCKET_BITMAP, cls5, cls3, VideoDecoder.asset(bitmapPool2)).append(cls3, cls3, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, cls3, cls3, new UnitBitmapDecoder()).append(cls3, bitmapEncoder).append(Registry.BUCKET_BITMAP_DRAWABLE, cls, cls7, new BitmapDrawableDecoder(resources, resourceDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, cls2, cls7, new BitmapDrawableDecoder(resources, resourceDecoder2)).append(Registry.BUCKET_BITMAP_DRAWABLE, cls4, cls7, new BitmapDrawableDecoder(resources, parcel)).append(cls7, new BitmapDrawableEncoder(bitmapPool3, bitmapEncoder));
        Class<ParcelFileDescriptor> cls8 = cls4;
        ArrayPool arrayPool4 = arrayPool2;
        Class<GifDrawable> cls9 = GifDrawable.class;
        Class<GifDecoder> cls10 = GifDecoder.class;
        Registry append2 = append.append(Registry.BUCKET_GIF, cls2, cls9, new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool4)).append(Registry.BUCKET_GIF, cls, cls9, byteBufferGifDecoder).append(cls9, new GifDrawableEncoder()).append(cls10, cls10, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, cls10, cls3, new GifFrameResourceDecoder(bitmapPool3));
        Class<Uri> cls11 = Uri.class;
        Class<Drawable> cls12 = Drawable.class;
        ResourceDrawableDecoder resourceDrawableDecoder3 = resourceDrawableDecoder2;
        Class<File> cls13 = File.class;
        append2.append(cls11, cls12, resourceDrawableDecoder3).append(cls11, cls3, new ResourceBitmapDecoder(resourceDrawableDecoder3, bitmapPool3)).register((DataRewinder.Factory<?>) new ByteBufferRewinder.Factory()).append(cls13, cls, new ByteBufferFileLoader.Factory()).append(cls13, cls2, new FileLoader.StreamFactory()).append(cls13, cls13, new FileDecoder()).append(cls13, cls8, new FileLoader.FileDescriptorFactory()).append(cls13, cls13, UnitModelLoader.Factory.getInstance()).register((DataRewinder.Factory<?>) new InputStreamRewinder.Factory(arrayPool4));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry2 = registry4;
            registry2.register((DataRewinder.Factory<?>) new ParcelFileDescriptorRewinder.Factory());
        } else {
            registry2 = registry4;
        }
        Class cls14 = Integer.TYPE;
        ResourceLoader.StreamFactory streamFactory3 = streamFactory2;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory3 = fileDescriptorFactory2;
        Class<GifDrawable> cls15 = cls9;
        Class<Integer> cls16 = Integer.class;
        Registry append3 = registry2.append(cls14, cls2, streamFactory3).append(cls14, cls8, fileDescriptorFactory3).append(cls16, cls2, streamFactory3).append(cls16, cls8, fileDescriptorFactory3);
        ResourceLoader.UriFactory uriFactory3 = uriFactory2;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory3 = assetFileDescriptorFactory2;
        Class<AssetFileDescriptor> cls17 = cls6;
        Class<String> cls18 = String.class;
        Context context3 = context;
        append3.append(cls16, cls11, uriFactory3).append(cls14, cls17, assetFileDescriptorFactory3).append(cls16, cls17, assetFileDescriptorFactory3).append(cls14, cls11, uriFactory3).append(cls18, cls2, new DataUrlLoader.StreamFactory()).append(cls11, cls2, new DataUrlLoader.StreamFactory()).append(cls18, cls2, new StringLoader.StreamFactory()).append(cls18, cls8, new StringLoader.FileDescriptorFactory()).append(cls18, cls17, new StringLoader.AssetFileDescriptorFactory()).append(cls11, cls2, new AssetUriLoader.StreamFactory(context.getAssets())).append(cls11, cls8, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(cls11, cls2, new MediaStoreImageThumbLoader.Factory(context3)).append(cls11, cls2, new MediaStoreVideoThumbLoader.Factory(context3));
        if (i13 >= 29) {
            registry2.append(cls11, cls2, new QMediaStoreUriLoader.InputStreamFactory(context3));
            registry2.append(cls11, cls8, new QMediaStoreUriLoader.FileDescriptorFactory(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<GlideUrl> cls19 = GlideUrl.class;
        Class<byte[]> cls20 = byte[].class;
        Registry register = registry2.append(cls11, cls2, new UriLoader.StreamFactory(contentResolver2)).append(cls11, cls8, new UriLoader.FileDescriptorFactory(contentResolver2)).append(cls11, cls17, new UriLoader.AssetFileDescriptorFactory(contentResolver2)).append(cls11, cls2, new UrlUriLoader.StreamFactory()).append(URL.class, cls2, new UrlLoader.StreamFactory()).append(cls11, cls13, new MediaStoreFileLoader.Factory(context3)).append(cls19, cls2, new HttpGlideUrlLoader.Factory()).append(cls20, cls, new ByteArrayLoader.ByteBufferFactory()).append(cls20, cls2, new ByteArrayLoader.StreamFactory()).append(cls11, cls11, UnitModelLoader.Factory.getInstance()).append(cls12, cls12, UnitModelLoader.Factory.getInstance()).append(cls12, cls12, new UnitDrawableDecoder()).register(cls3, cls7, new BitmapDrawableTranscoder(resources));
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        register.register(cls3, cls20, bitmapBytesTranscoder2).register(cls12, cls20, new DrawableBytesTranscoder(bitmapPool2, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).register(cls15, cls20, gifDrawableBytesTranscoder2);
        ResourceDecoder<ByteBuffer, Bitmap> byteBuffer = VideoDecoder.byteBuffer(bitmapPool2);
        registry2.append(cls, cls3, byteBuffer);
        registry2.append(cls, cls7, new BitmapDrawableDecoder(resources, byteBuffer));
        this.glideContext = new GlideContext(context, arrayPool2, registry2, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine2, glideExperiments, i11);
    }

    @GuardedBy("Glide.class")
    private static void checkAndInitializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!isInitializing) {
            isInitializing = true;
            initializeGlide(context, generatedAppGlideModule);
            isInitializing = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @VisibleForTesting
    public static void enableHardwareBitmaps() {
        HardwareConfigState.getInstance().unblockHardwareBitmaps();
    }

    @NonNull
    public static Glide get(@NonNull Context context) {
        if (glide == null) {
            GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (Glide.class) {
                if (glide == null) {
                    checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                }
            }
        }
        return glide;
    }

    @Nullable
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context) {
        try {
            return GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (InstantiationException e11) {
            throwIncorrectGlideModule(e11);
        } catch (IllegalAccessException e12) {
            throwIncorrectGlideModule(e12);
        } catch (NoSuchMethodException e13) {
            throwIncorrectGlideModule(e13);
        } catch (InvocationTargetException e14) {
            throwIncorrectGlideModule(e14);
        }
        return null;
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @NonNull
    private static RequestManagerRetriever getRetriever(@Nullable Context context) {
        Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide2) {
        synchronized (Glide.class) {
            if (glide != null) {
                tearDown();
            }
            glide = glide2;
        }
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new GlideBuilder(), generatedAppGlideModule);
    }

    @VisibleForTesting
    public static void tearDown() {
        synchronized (Glide.class) {
            if (glide != null) {
                glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                glide.engine.shutdown();
            }
            glide = null;
        }
    }

    private static void throwIncorrectGlideModule(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static RequestManager with(@NonNull Context context) {
        return getRetriever(context).get(context);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    @NonNull
    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    @NonNull
    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        clearMemory();
    }

    public void onTrimMemory(int i11) {
        trimMemory(i11);
    }

    public synchronized void preFillBitmapPool(@NonNull PreFillType.Builder... builderArr) {
        if (this.bitmapPreFiller == null) {
            this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, (DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT));
        }
        this.bitmapPreFiller.preFill(builderArr);
    }

    public void registerRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            if (!this.managers.contains(requestManager)) {
                this.managers.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public boolean removeFromManagers(@NonNull Target<?> target) {
        synchronized (this.managers) {
            for (RequestManager untrack : this.managers) {
                if (untrack.untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory memoryCategory2) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory2.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory2.getMultiplier());
        MemoryCategory memoryCategory3 = this.memoryCategory;
        this.memoryCategory = memoryCategory2;
        return memoryCategory3;
    }

    public void trimMemory(int i11) {
        Util.assertMainThread();
        synchronized (this.managers) {
            for (RequestManager onTrimMemory : this.managers) {
                onTrimMemory.onTrimMemory(i11);
            }
        }
        this.memoryCache.trimMemory(i11);
        this.bitmapPool.trimMemory(i11);
        this.arrayPool.trimMemory(i11);
    }

    public void unregisterRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            if (this.managers.contains(requestManager)) {
                this.managers.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.isDirectory() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @NonNull GlideBuilder glideBuilder, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            emptyList = new ManifestParser(applicationContext).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            Set<Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (excludedModuleClasses.contains(next.getClass())) {
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AppGlideModule excludes manifest GlideModule: ");
                        sb2.append(next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            for (GlideModule glideModule : emptyList) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Discovered GlideModule from manifest: ");
                sb3.append(glideModule.getClass());
            }
        }
        glideBuilder.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        for (GlideModule applyOptions : emptyList) {
            applyOptions.applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        Glide build = glideBuilder.build(applicationContext);
        for (GlideModule next2 : emptyList) {
            try {
                next2.registerComponents(applicationContext, build, build.registry);
            } catch (AbstractMethodError e11) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e11);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, build, build.registry);
        }
        applicationContext.registerComponentCallbacks(build);
        glide = build;
    }

    @NonNull
    public static RequestManager with(@NonNull Activity activity) {
        return getRetriever(activity).get(activity);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (Glide.class) {
            if (glide != null) {
                tearDown();
            }
            initializeGlide(context, glideBuilder, annotationGeneratedGlideModules);
        }
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static RequestManager with(@NonNull View view) {
        return getRetriever(view.getContext()).get(view);
    }
}
