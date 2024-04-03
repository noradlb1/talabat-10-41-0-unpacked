package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.annotation.ExperimentalCoilApi;
import coil.bitmap.BitmapPool;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import coil.request.CachePolicy;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Precision;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Contexts;
import coil.util.Extensions;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.Utils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcoil/ImageLoader;", "", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "defaults", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "memoryCache", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "shutdown", "", "Builder", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ImageLoader {
    @NotNull
    public static final Companion Companion = Companion.f39666a;

    @Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010!\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0)J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0011J%\u0010\u0010\u001a\u00020\u00002\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,¢\u0006\u0002\b/H\bø\u0001\u0000J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u00108\u001a\u00020\u00002\b\b\u0001\u0010;\u001a\u000202J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0015J\u0010\u0010@\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010@\u001a\u00020\u00002\b\b\u0001\u0010;\u001a\u000202J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020BJ\u000e\u0010C\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010D\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u0014\u0010F\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020G0)J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010H\u001a\u00020\u00002\b\b\u0001\u0010;\u001a\u000202J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010I\u001a\u00020JJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010K\u001a\u00020\u00002\u0006\u0010K\u001a\u00020LH\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006M"}, d2 = {"Lcoil/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageLoader", "Lcoil/RealImageLoader;", "(Lcoil/RealImageLoader;)V", "applicationContext", "availableMemoryPercentage", "", "bitmapPoolPercentage", "bitmapPoolingEnabled", "", "callFactory", "Lokhttp3/Call$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "defaults", "Lcoil/request/DefaultRequestOptions;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "logger", "Lcoil/util/Logger;", "memoryCache", "Lcoil/memory/RealMemoryCache;", "options", "Lcoil/util/ImageLoaderOptions;", "trackWeakReferences", "addLastModifiedToFileCacheKey", "enable", "allowHardware", "allowRgb565", "percent", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "build", "Lcoil/ImageLoader;", "buildDefaultCallFactory", "buildDefaultMemoryCache", "initializer", "Lkotlin/Function0;", "registry", "builder", "Lkotlin/Function1;", "Lcoil/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "crossfade", "durationMillis", "", "diskCachePolicy", "policy", "Lcoil/request/CachePolicy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "error", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "eventListener", "listener", "Lcoil/EventListener;", "factory", "fallback", "launchInterceptorChainOnMainThread", "Lcoil/memory/MemoryCache;", "memoryCachePolicy", "networkCachePolicy", "networkObserverEnabled", "okHttpClient", "Lokhttp3/OkHttpClient;", "placeholder", "precision", "Lcoil/size/Precision;", "transition", "Lcoil/transition/Transition;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        /* access modifiers changed from: private */
        @NotNull
        public final Context applicationContext;
        private double availableMemoryPercentage;
        private double bitmapPoolPercentage;
        private boolean bitmapPoolingEnabled;
        @Nullable
        private Call.Factory callFactory;
        @Nullable
        private ComponentRegistry componentRegistry;
        @NotNull
        private DefaultRequestOptions defaults;
        @Nullable
        private EventListener.Factory eventListenerFactory;
        @Nullable
        private Logger logger;
        @Nullable
        private RealMemoryCache memoryCache;
        @NotNull
        private ImageLoaderOptions options;
        private boolean trackWeakReferences;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
            this.applicationContext = applicationContext2;
            this.defaults = DefaultRequestOptions.INSTANCE;
            this.callFactory = null;
            this.eventListenerFactory = null;
            this.componentRegistry = null;
            this.options = new ImageLoaderOptions(false, false, false, 7, (DefaultConstructorMarker) null);
            this.logger = null;
            this.memoryCache = null;
            Utils utils = Utils.INSTANCE;
            this.availableMemoryPercentage = utils.getDefaultAvailableMemoryPercentage(applicationContext2);
            this.bitmapPoolPercentage = utils.getDefaultBitmapPoolPercentage();
            this.bitmapPoolingEnabled = true;
            this.trackWeakReferences = true;
        }

        private final Call.Factory buildDefaultCallFactory() {
            return Extensions.lazyCallFactory(new ImageLoader$Builder$buildDefaultCallFactory$1(this));
        }

        /* JADX WARNING: type inference failed for: r1v3, types: [coil.bitmap.EmptyBitmapPool] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final coil.memory.RealMemoryCache buildDefaultMemoryCache() {
            /*
                r11 = this;
                coil.util.Utils r0 = coil.util.Utils.INSTANCE
                android.content.Context r1 = r11.applicationContext
                double r2 = r11.availableMemoryPercentage
                long r0 = r0.calculateAvailableMemorySize(r1, r2)
                boolean r2 = r11.bitmapPoolingEnabled
                if (r2 == 0) goto L_0x0011
                double r2 = r11.bitmapPoolPercentage
                goto L_0x0013
            L_0x0011:
                r2 = 0
            L_0x0013:
                double r4 = (double) r0
                double r2 = r2 * r4
                int r5 = (int) r2
                long r2 = (long) r5
                long r0 = r0 - r2
                int r0 = (int) r0
                if (r5 != 0) goto L_0x0021
                coil.bitmap.EmptyBitmapPool r1 = new coil.bitmap.EmptyBitmapPool
                r1.<init>()
                goto L_0x002d
            L_0x0021:
                coil.bitmap.RealBitmapPool r1 = new coil.bitmap.RealBitmapPool
                r6 = 0
                r7 = 0
                coil.util.Logger r8 = r11.logger
                r9 = 6
                r10 = 0
                r4 = r1
                r4.<init>(r5, r6, r7, r8, r9, r10)
            L_0x002d:
                boolean r2 = r11.trackWeakReferences
                if (r2 == 0) goto L_0x0039
                coil.memory.RealWeakMemoryCache r2 = new coil.memory.RealWeakMemoryCache
                coil.util.Logger r3 = r11.logger
                r2.<init>(r3)
                goto L_0x003b
            L_0x0039:
                coil.memory.EmptyWeakMemoryCache r2 = coil.memory.EmptyWeakMemoryCache.INSTANCE
            L_0x003b:
                boolean r3 = r11.bitmapPoolingEnabled
                if (r3 == 0) goto L_0x0047
                coil.bitmap.RealBitmapReferenceCounter r3 = new coil.bitmap.RealBitmapReferenceCounter
                coil.util.Logger r4 = r11.logger
                r3.<init>(r2, r1, r4)
                goto L_0x0049
            L_0x0047:
                coil.bitmap.EmptyBitmapReferenceCounter r3 = coil.bitmap.EmptyBitmapReferenceCounter.INSTANCE
            L_0x0049:
                coil.memory.StrongMemoryCache$Companion r4 = coil.memory.StrongMemoryCache.Companion
                coil.util.Logger r5 = r11.logger
                coil.memory.StrongMemoryCache r0 = r4.invoke(r2, r3, r0, r5)
                coil.memory.RealMemoryCache r4 = new coil.memory.RealMemoryCache
                r4.<init>(r0, r2, r3, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: coil.ImageLoader.Builder.buildDefaultMemoryCache():coil.memory.RealMemoryCache");
        }

        @NotNull
        public final Builder addLastModifiedToFileCacheKey(boolean z11) {
            this.options = ImageLoaderOptions.copy$default(this.options, z11, false, false, 6, (Object) null);
            return this;
        }

        @NotNull
        public final Builder allowHardware(boolean z11) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, z11, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4079, (Object) null);
            return this;
        }

        @NotNull
        public final Builder allowRgb565(boolean z11) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, z11, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4063, (Object) null);
            return this;
        }

        @NotNull
        public final Builder availableMemoryPercentage(@FloatRange(from = 0.0d, to = 1.0d) double d11) {
            boolean z11 = false;
            if (0.0d <= d11 && d11 <= 1.0d) {
                z11 = true;
            }
            if (z11) {
                this.availableMemoryPercentage = d11;
                this.memoryCache = null;
                return this;
            }
            throw new IllegalArgumentException("Percent must be in the range [0.0, 1.0].".toString());
        }

        @NotNull
        public final Builder bitmapConfig(@NotNull Bitmap.Config config) {
            Bitmap.Config config2 = config;
            Intrinsics.checkNotNullParameter(config2, "bitmapConfig");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, config2, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4087, (Object) null);
            return this;
        }

        @NotNull
        public final Builder bitmapPoolPercentage(@FloatRange(from = 0.0d, to = 1.0d) double d11) {
            boolean z11 = false;
            if (0.0d <= d11 && d11 <= 1.0d) {
                z11 = true;
            }
            if (z11) {
                this.bitmapPoolPercentage = d11;
                this.memoryCache = null;
                return this;
            }
            throw new IllegalArgumentException("Percent must be in the range [0.0, 1.0].".toString());
        }

        @NotNull
        public final Builder bitmapPoolingEnabled(boolean z11) {
            this.bitmapPoolingEnabled = z11;
            this.memoryCache = null;
            return this;
        }

        @NotNull
        public final ImageLoader build() {
            RealMemoryCache realMemoryCache = this.memoryCache;
            if (realMemoryCache == null) {
                realMemoryCache = buildDefaultMemoryCache();
            }
            RealMemoryCache realMemoryCache2 = realMemoryCache;
            Context context = this.applicationContext;
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            BitmapPool bitmapPool = realMemoryCache2.getBitmapPool();
            Call.Factory factory = this.callFactory;
            if (factory == null) {
                factory = buildDefaultCallFactory();
            }
            Call.Factory factory2 = factory;
            EventListener.Factory factory3 = this.eventListenerFactory;
            if (factory3 == null) {
                factory3 = EventListener.Factory.NONE;
            }
            EventListener.Factory factory4 = factory3;
            ComponentRegistry componentRegistry2 = this.componentRegistry;
            if (componentRegistry2 == null) {
                componentRegistry2 = new ComponentRegistry();
            }
            return new RealImageLoader(context, defaultRequestOptions, bitmapPool, realMemoryCache2, factory2, factory4, componentRegistry2, this.options, this.logger);
        }

        @NotNull
        public final Builder callFactory(@NotNull Call.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "callFactory");
            this.callFactory = factory;
            return this;
        }

        public final /* synthetic */ Builder componentRegistry(Function1<? super ComponentRegistry.Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            function1.invoke(builder);
            return componentRegistry(builder.build());
        }

        @NotNull
        public final Builder crossfade(boolean z11) {
            return crossfade(z11 ? 100 : 0);
        }

        @NotNull
        public final Builder diskCachePolicy(@NotNull CachePolicy cachePolicy) {
            CachePolicy cachePolicy2 = cachePolicy;
            Intrinsics.checkNotNullParameter(cachePolicy2, "policy");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, cachePolicy2, (CachePolicy) null, 3071, (Object) null);
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull CoroutineDispatcher coroutineDispatcher) {
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            Intrinsics.checkNotNullParameter(coroutineDispatcher2, "dispatcher");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, coroutineDispatcher2, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4094, (Object) null);
            return this;
        }

        @NotNull
        public final Builder error(@DrawableRes int i11) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, Contexts.getDrawableCompat(this.applicationContext, i11), (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3967, (Object) null);
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            return eventListener(EventListener.Factory.Companion.create(eventListener));
        }

        @NotNull
        public final Builder fallback(@DrawableRes int i11) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, Contexts.getDrawableCompat(this.applicationContext, i11), (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3839, (Object) null);
            return this;
        }

        @NotNull
        public final Builder launchInterceptorChainOnMainThread(boolean z11) {
            this.options = ImageLoaderOptions.copy$default(this.options, false, z11, false, 5, (Object) null);
            return this;
        }

        @NotNull
        public final Builder logger(@Nullable Logger logger2) {
            this.logger = logger2;
            return this;
        }

        @NotNull
        public final Builder memoryCache(@NotNull MemoryCache memoryCache2) {
            Intrinsics.checkNotNullParameter(memoryCache2, "memoryCache");
            if (memoryCache2 instanceof RealMemoryCache) {
                this.memoryCache = (RealMemoryCache) memoryCache2;
                return this;
            }
            throw new IllegalArgumentException("Custom memory cache implementations are currently not supported.".toString());
        }

        @NotNull
        public final Builder memoryCachePolicy(@NotNull CachePolicy cachePolicy) {
            CachePolicy cachePolicy2 = cachePolicy;
            Intrinsics.checkNotNullParameter(cachePolicy2, "policy");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, cachePolicy2, (CachePolicy) null, (CachePolicy) null, 3583, (Object) null);
            return this;
        }

        @NotNull
        public final Builder networkCachePolicy(@NotNull CachePolicy cachePolicy) {
            CachePolicy cachePolicy2 = cachePolicy;
            Intrinsics.checkNotNullParameter(cachePolicy2, "policy");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, cachePolicy2, 2047, (Object) null);
            return this;
        }

        @NotNull
        public final Builder networkObserverEnabled(boolean z11) {
            this.options = ImageLoaderOptions.copy$default(this.options, false, false, z11, 3, (Object) null);
            return this;
        }

        @NotNull
        public final Builder okHttpClient(@NotNull OkHttpClient okHttpClient) {
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            return callFactory((Call.Factory) okHttpClient);
        }

        @NotNull
        public final Builder placeholder(@DrawableRes int i11) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, Contexts.getDrawableCompat(this.applicationContext, i11), (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4031, (Object) null);
            return this;
        }

        @NotNull
        public final Builder precision(@NotNull Precision precision) {
            Precision precision2 = precision;
            Intrinsics.checkNotNullParameter(precision2, "precision");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, precision2, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4091, (Object) null);
            return this;
        }

        @NotNull
        public final Builder trackWeakReferences(boolean z11) {
            this.trackWeakReferences = z11;
            this.memoryCache = null;
            return this;
        }

        @NotNull
        @ExperimentalCoilApi
        public final Builder transition(@NotNull Transition transition) {
            Transition transition2 = transition;
            Intrinsics.checkNotNullParameter(transition2, "transition");
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, transition2, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4093, (Object) null);
            return this;
        }

        @NotNull
        public final Builder callFactory(@NotNull Function0<? extends Call.Factory> function0) {
            Intrinsics.checkNotNullParameter(function0, "initializer");
            this.callFactory = Extensions.lazyCallFactory(function0);
            return this;
        }

        @NotNull
        public final Builder componentRegistry(@NotNull ComponentRegistry componentRegistry2) {
            Intrinsics.checkNotNullParameter(componentRegistry2, "registry");
            this.componentRegistry = componentRegistry2;
            return this;
        }

        @NotNull
        public final Builder crossfade(int i11) {
            return transition(i11 > 0 ? new CrossfadeTransition(i11, false, 2, (DefaultConstructorMarker) null) : Transition.NONE);
        }

        @NotNull
        public final Builder error(@Nullable Drawable drawable) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, drawable, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3967, (Object) null);
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "factory");
            this.eventListenerFactory = factory;
            return this;
        }

        @NotNull
        public final Builder fallback(@Nullable Drawable drawable) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, drawable, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3839, (Object) null);
            return this;
        }

        @NotNull
        public final Builder okHttpClient(@NotNull Function0<? extends OkHttpClient> function0) {
            Intrinsics.checkNotNullParameter(function0, "initializer");
            return callFactory((Function0<? extends Call.Factory>) function0);
        }

        @NotNull
        public final Builder placeholder(@Nullable Drawable drawable) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, drawable, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4031, (Object) null);
            return this;
        }

        public Builder(@NotNull RealImageLoader realImageLoader) {
            Intrinsics.checkNotNullParameter(realImageLoader, "imageLoader");
            Context applicationContext2 = realImageLoader.getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "imageLoader.context.applicationContext");
            this.applicationContext = applicationContext2;
            this.defaults = realImageLoader.getDefaults();
            this.callFactory = realImageLoader.getCallFactory();
            this.eventListenerFactory = realImageLoader.getEventListenerFactory();
            this.componentRegistry = realImageLoader.getComponentRegistry();
            this.options = realImageLoader.getOptions();
            this.logger = realImageLoader.getLogger();
            this.memoryCache = realImageLoader.getMemoryCache();
            Utils utils = Utils.INSTANCE;
            this.availableMemoryPercentage = utils.getDefaultAvailableMemoryPercentage(applicationContext2);
            this.bitmapPoolPercentage = utils.getDefaultBitmapPoolPercentage();
            this.bitmapPoolingEnabled = true;
            this.trackWeakReferences = true;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcoil/ImageLoader$Companion;", "", "()V", "invoke", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "create", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39666a = new Companion();

        private Companion() {
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "create")
        public final ImageLoader create(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context).build();
        }
    }

    @NotNull
    Disposable enqueue(@NotNull ImageRequest imageRequest);

    @Nullable
    Object execute(@NotNull ImageRequest imageRequest, @NotNull Continuation<? super ImageResult> continuation);

    @NotNull
    BitmapPool getBitmapPool();

    @NotNull
    DefaultRequestOptions getDefaults();

    @NotNull
    MemoryCache getMemoryCache();

    @NotNull
    Builder newBuilder();

    void shutdown();
}
