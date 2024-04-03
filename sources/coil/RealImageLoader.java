package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.EventListener;
import coil.ImageLoader;
import coil.bitmap.BitmapPool;
import coil.bitmap.BitmapReferenceCounter;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.decode.DrawableDecoderService;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.HttpUrlFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.map.FileUriMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.DelegateService;
import coil.memory.MemoryCacheService;
import coil.memory.RealMemoryCache;
import coil.memory.RequestService;
import coil.memory.TargetDelegate;
import coil.memory.ViewTargetRequestManager;
import coil.request.BaseTargetDisposable;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.request.ViewTargetDisposable;
import coil.size.Size;
import coil.target.ViewTarget;
import coil.util.Extensions;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.File;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ]2\u00020\u0001:\u0001]BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\u0019\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0002\u0010?J;\u0010@\u001a\u00020>2\u0006\u0010;\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HHHø\u0001\u0000¢\u0006\u0002\u0010IJ!\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020<2\u0006\u0010A\u001a\u00020BH@ø\u0001\u0000¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\u0018\u0010O\u001a\u00020P2\u0006\u0010;\u001a\u00020<2\u0006\u0010G\u001a\u00020HH\u0002J)\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010G\u001a\u00020HHHø\u0001\u0000¢\u0006\u0002\u0010VJ)\u0010W\u001a\u00020P2\u0006\u0010R\u001a\u00020X2\u0006\u0010T\u001a\u00020U2\u0006\u0010G\u001a\u00020HHHø\u0001\u0000¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020P2\u0006\u0010[\u001a\u00020BJ\b\u0010\\\u001a\u00020PH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006^"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "memoryCache", "Lcoil/memory/RealMemoryCache;", "callFactory", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "options", "Lcoil/util/ImageLoaderOptions;", "logger", "Lcoil/util/Logger;", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lcoil/bitmap/BitmapPool;Lcoil/memory/RealMemoryCache;Lokhttp3/Call$Factory;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "getCallFactory", "()Lokhttp3/Call$Factory;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "getContext", "()Landroid/content/Context;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "delegateService", "Lcoil/memory/DelegateService;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "interceptors", "", "Lcoil/intercept/Interceptor;", "isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getLogger", "()Lcoil/util/Logger;", "getMemoryCache", "()Lcoil/memory/RealMemoryCache;", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "registry", "requestService", "Lcoil/memory/RequestService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeChain", "type", "", "size", "Lcoil/size/Size;", "cached", "Landroid/graphics/Bitmap;", "eventListener", "Lcoil/EventListener;", "(Lcoil/request/ImageRequest;ILcoil/size/Size;Landroid/graphics/Bitmap;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "onCancel", "", "onError", "result", "Lcoil/request/ErrorResult;", "targetDelegate", "Lcoil/memory/TargetDelegate;", "(Lcoil/request/ErrorResult;Lcoil/memory/TargetDelegate;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSuccess", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lcoil/memory/TargetDelegate;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTrimMemory", "level", "shutdown", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealImageLoader implements ImageLoader {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "RealImageLoader";
    @NotNull
    private final BitmapPool bitmapPool;
    @NotNull
    private final Call.Factory callFactory;
    @NotNull
    private final ComponentRegistry componentRegistry;
    @NotNull
    private final Context context;
    @NotNull
    private final DefaultRequestOptions defaults;
    @NotNull
    private final DelegateService delegateService;
    @NotNull
    private final DrawableDecoderService drawableDecoder;
    @NotNull
    private final EventListener.Factory eventListenerFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final List<Interceptor> interceptors;
    @NotNull
    private final AtomicBoolean isShutdown;
    @Nullable
    private final Logger logger;
    @NotNull
    private final RealMemoryCache memoryCache;
    @NotNull
    private final MemoryCacheService memoryCacheService;
    @NotNull
    private final ImageLoaderOptions options;
    @NotNull
    private final ComponentRegistry registry;
    @NotNull
    private final RequestService requestService;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)));
    @NotNull
    private final SystemCallbacks systemCallbacks;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/RealImageLoader$Companion;", "", "()V", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RealImageLoader(@NotNull Context context2, @NotNull DefaultRequestOptions defaultRequestOptions, @NotNull BitmapPool bitmapPool2, @NotNull RealMemoryCache realMemoryCache, @NotNull Call.Factory factory, @NotNull EventListener.Factory factory2, @NotNull ComponentRegistry componentRegistry2, @NotNull ImageLoaderOptions imageLoaderOptions, @Nullable Logger logger2) {
        Context context3 = context2;
        DefaultRequestOptions defaultRequestOptions2 = defaultRequestOptions;
        BitmapPool bitmapPool3 = bitmapPool2;
        RealMemoryCache realMemoryCache2 = realMemoryCache;
        Call.Factory factory3 = factory;
        EventListener.Factory factory4 = factory2;
        ComponentRegistry componentRegistry3 = componentRegistry2;
        ImageLoaderOptions imageLoaderOptions2 = imageLoaderOptions;
        Logger logger3 = logger2;
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(defaultRequestOptions2, RemoteConfigComponent.DEFAULTS_FILE_NAME);
        Intrinsics.checkNotNullParameter(bitmapPool3, "bitmapPool");
        Intrinsics.checkNotNullParameter(realMemoryCache2, "memoryCache");
        Intrinsics.checkNotNullParameter(factory3, "callFactory");
        Intrinsics.checkNotNullParameter(factory4, "eventListenerFactory");
        Intrinsics.checkNotNullParameter(componentRegistry3, "componentRegistry");
        Intrinsics.checkNotNullParameter(imageLoaderOptions2, "options");
        this.context = context3;
        this.defaults = defaultRequestOptions2;
        this.bitmapPool = bitmapPool3;
        this.memoryCache = realMemoryCache2;
        this.callFactory = factory3;
        this.eventListenerFactory = factory4;
        this.componentRegistry = componentRegistry3;
        this.options = imageLoaderOptions2;
        this.logger = logger3;
        this.delegateService = new DelegateService(this, getMemoryCache().getReferenceCounter(), logger3);
        MemoryCacheService memoryCacheService2 = new MemoryCacheService(getMemoryCache().getReferenceCounter(), getMemoryCache().getStrongMemoryCache(), getMemoryCache().getWeakMemoryCache());
        this.memoryCacheService = memoryCacheService2;
        RequestService requestService2 = new RequestService(logger3);
        this.requestService = requestService2;
        DrawableDecoderService drawableDecoderService = new DrawableDecoderService(getBitmapPool());
        this.drawableDecoder = drawableDecoderService;
        SystemCallbacks systemCallbacks2 = new SystemCallbacks(this, context3, imageLoaderOptions.getNetworkObserverEnabled());
        this.systemCallbacks = systemCallbacks2;
        Class<Uri> cls = Uri.class;
        ComponentRegistry build = componentRegistry2.newBuilder().add(new StringMapper(), String.class).add(new FileUriMapper(), cls).add(new ResourceUriMapper(context3), cls).add(new ResourceIntMapper(context3), Integer.class).add(new HttpUriFetcher(factory3), cls).add(new HttpUrlFetcher(factory3), HttpUrl.class).add(new FileFetcher(imageLoaderOptions.getAddLastModifiedToFileCacheKey()), File.class).add(new AssetUriFetcher(context3), cls).add(new ContentUriFetcher(context3), cls).add(new ResourceUriFetcher(context3, drawableDecoderService), cls).add(new DrawableFetcher(drawableDecoderService), Drawable.class).add(new BitmapFetcher(), Bitmap.class).add((Decoder) new BitmapFactoryDecoder(context3)).build();
        this.registry = build;
        this.interceptors = CollectionsKt___CollectionsKt.plus(build.getInterceptors$coil_base_release(), new EngineInterceptor(build, getBitmapPool(), getMemoryCache().getReferenceCounter(), getMemoryCache().getStrongMemoryCache(), memoryCacheService2, requestService2, systemCallbacks2, drawableDecoderService, logger3));
        this.isShutdown = new AtomicBoolean(false);
    }

    private final Object executeChain(ImageRequest imageRequest, int i11, Size size, Bitmap bitmap, EventListener eventListener, Continuation<? super ImageResult> continuation) {
        ImageRequest imageRequest2 = imageRequest;
        Continuation<? super ImageResult> continuation2 = continuation;
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(imageRequest, i11, this.interceptors, 0, imageRequest, size, bitmap, eventListener);
        if (getOptions().getLaunchInterceptorChainOnMainThread()) {
            InlineMarker.mark(0);
            Object proceed = realInterceptorChain.proceed(imageRequest, continuation2);
            InlineMarker.mark(1);
            return proceed;
        }
        CoroutineDispatcher dispatcher = imageRequest.getDispatcher();
        RealImageLoader$executeChain$2 realImageLoader$executeChain$2 = new RealImageLoader$executeChain$2(realInterceptorChain, imageRequest, (Continuation<? super RealImageLoader$executeChain$2>) null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(dispatcher, realImageLoader$executeChain$2, continuation2);
        InlineMarker.mark(1);
        return withContext;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v15, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: coil.memory.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: coil.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v33, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: coil.memory.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: coil.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: coil.RealImageLoader} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r11 = (coil.request.ImageResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02bf, code lost:
        if ((r11 instanceof coil.request.SuccessResult) == false) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02c1, code lost:
        r2 = (coil.request.SuccessResult) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r5 = r2.getRequest();
        r0 = r2.getMetadata();
        r10 = r0.getDataSource();
        r1 = r9.getLogger();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02d4, code lost:
        r16 = " - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02d6, code lost:
        if (r1 != null) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02d8, code lost:
        r17 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02df, code lost:
        r17 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02e2, code lost:
        if (r1.getLevel() > 4) goto L_0x0311;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r1.log(TAG, 4, coil.util.Extensions.getEmoji(r10) + " Successful (" + r10.name() + ") - " + r5.getData(), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0311, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0313, code lost:
        coil.util.Extensions.setMetadata(r13, r0);
        r3.f39680h = r9;
        r3.f39681i = r15;
        r3.f39682j = r14;
        r3.f39683k = r13;
        r3.f39684l = r12;
        r3.f39685m = r11;
        r3.f39686n = r9;
        r3.f39687o = r2;
        r3.f39688p = r5;
        r3.f39689q = r0;
        r3.f39693u = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0331, code lost:
        if (r13.success(r2, r3) != r4) goto L_0x0334;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0333, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0334, code lost:
        r1 = r9;
        r10 = r15;
        r9 = r2;
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        r15.onSuccess(r5, r0);
        r2 = r5.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0343, code lost:
        if (r2 != null) goto L_0x0346;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0346, code lost:
        r2.onSuccess(r5, r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        r0 = r11.getMemoryCache().getReferenceCounter();
        r2 = r9.getDrawable();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0357, code lost:
        if (r2 == null) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x035b, code lost:
        if ((r2 instanceof android.graphics.drawable.BitmapDrawable) == false) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x035d, code lost:
        r2 = ((android.graphics.drawable.BitmapDrawable) r2).getBitmap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0363, code lost:
        if (r2 != null) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0366, code lost:
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0.decrement(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x036d, code lost:
        r11 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0371, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0372, code lost:
        r5 = r13;
        r13 = r14;
        r9 = r15;
        r6 = r17;
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x037a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x037b, code lost:
        r12 = r13;
        r13 = r14;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0380, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0382, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0384, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0385, code lost:
        r16 = " - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0387, code lost:
        r17 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0389, code lost:
        r1 = r9;
        r11 = r1;
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03a7, code lost:
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.decrement(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b6, code lost:
        r16 = " - ";
        r17 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03bc, code lost:
        if ((r11 instanceof coil.request.ErrorResult) == false) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03be, code lost:
        r5 = (coil.request.ErrorResult) r11;
        r0 = r5.getRequest();
        r1 = r9.getLogger();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03c9, code lost:
        if (r1 != null) goto L_0x03cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03cb, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03d4, code lost:
        if (r1.getLevel() > 4) goto L_0x0404;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03d6, code lost:
        r2 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03db, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        r2.append(r6);
        r2.append(r0.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03e7, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        r2.append(r7);
        r2.append(r5.getThrowable());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03f7, code lost:
        r16 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        r1.log(TAG, 4, r2.toString(), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0400, code lost:
        r16 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0404, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0406, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0409, code lost:
        coil.util.Extensions.setMetadata(r13, (coil.request.ImageResult.Metadata) null);
        r3.f39680h = r9;
        r3.f39681i = r15;
        r3.f39682j = r14;
        r3.f39683k = r13;
        r3.f39684l = r12;
        r3.f39685m = r11;
        r3.f39686n = r5;
        r3.f39687o = r0;
        r3.f39693u = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0423, code lost:
        if (r13.error(r5, r3) != r4) goto L_0x0426;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0425, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0426, code lost:
        r14.onError(r0, r5.getThrowable());
        r1 = r0.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0431, code lost:
        if (r1 != null) goto L_0x0434;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0434, code lost:
        r1.onError(r0, r5.getThrowable());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x043e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0441, code lost:
        r12.complete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0444, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0445, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0446, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x044a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x044b, code lost:
        r16 = " - ";
        r6 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0450, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0451, code lost:
        r16 = " - ";
        r6 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
        r1 = r9.getMemoryCache().getReferenceCounter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x045c, code lost:
        if (r10 != null) goto L_0x045e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x045e, code lost:
        r1.decrement(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0461, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0462, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0464, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0465, code lost:
        r16 = " - ";
        r6 = "🚨 Failed - ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0468, code lost:
        r1 = r9;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0481, code lost:
        r0 = r1.requestService.errorResult(r15, r0);
        r2 = r0.getRequest();
        r1 = r1.getLogger();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x048f, code lost:
        if (r1 != null) goto L_0x0493;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0498, code lost:
        if (r1.getLevel() <= 4) goto L_0x049a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x049a, code lost:
        r1.log(TAG, 4, r6 + r2.getData() + r16 + r0.getThrowable(), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04be, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04c1, code lost:
        coil.util.Extensions.setMetadata(r13, (coil.request.ImageResult.Metadata) null);
        r3.f39680h = r9;
        r3.f39681i = r5;
        r3.f39682j = r0;
        r3.f39683k = r2;
        r3.f39684l = null;
        r3.f39685m = null;
        r3.f39686n = null;
        r3.f39687o = null;
        r3.f39688p = null;
        r3.f39689q = null;
        r3.f39693u = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04e0, code lost:
        if (r13.error(r0, r3) == r4) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04e2, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x04e3, code lost:
        r4 = r0;
        r0 = r2;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04e6, code lost:
        r3.onError(r0, r4.getThrowable());
        r1 = r0.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04f1, code lost:
        if (r1 == null) goto L_0x04f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x04f4, code lost:
        r1.onError(r0, r4.getThrowable());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04fd, code lost:
        r5.complete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0500, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        r1.onCancel(r15, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0504, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.ResultKt.throwOnFailure(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014d, code lost:
        r16 = " - ";
        r6 = "🚨 Failed - ";
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d0, code lost:
        r2 = r5;
        r5 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r10 = r9.memoryCacheService.get(r15.getPlaceholderMemoryCacheKey());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e7, code lost:
        if (r10 != null) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e9, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01eb, code lost:
        r10 = r10.getBitmap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        coil.util.Extensions.setMetadata(r13, (coil.request.ImageResult.Metadata) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f3, code lost:
        if (r10 != null) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f5, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f7, code lost:
        r11 = r15.getContext().getResources();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "context.resources");
        r12 = new android.graphics.drawable.BitmapDrawable(r11, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0209, code lost:
        if (r12 != null) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x020b, code lost:
        r12 = r15.getPlaceholder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x020f, code lost:
        r13.start(r12, r10);
        r5.onStart(r15);
        r11 = r15.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0219, code lost:
        if (r11 != null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x021c, code lost:
        r11.onStart(r15);
        r11 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r11 = r9.getMemoryCache().getReferenceCounter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0229, code lost:
        if (r10 == null) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x022b, code lost:
        r11.decrement(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022e, code lost:
        r5.resolveSizeStart(r15);
        r11 = r15.getSizeResolver();
        r3.f39680h = r9;
        r3.f39681i = r15;
        r3.f39682j = r5;
        r3.f39683k = r13;
        r3.f39684l = r2;
        r3.f39685m = r10;
        r3.f39690r = r0;
        r3.f39693u = 2;
        r11 = r11.size(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x024a, code lost:
        if (r11 != r4) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x024c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x024d, code lost:
        r18 = r0;
        r23 = r10;
        r25 = r5;
        r5 = r2;
        r2 = r11;
        r11 = r9;
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r0 = (coil.size.Size) r2;
        r9.resolveSizeEnd(r15, r0);
        r16 = new coil.intercept.RealInterceptorChain(r15, r18, access$getInterceptors$p(r11), 0, r15, r0, r23, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x027b, code lost:
        if (r11.getOptions().getLaunchInterceptorChainOnMainThread() == false) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x027d, code lost:
        r3.f39680h = r11;
        r3.f39681i = r15;
        r3.f39682j = r9;
        r3.f39683k = r13;
        r3.f39684l = r5;
        r3.f39685m = null;
        r3.f39693u = 3;
        r2 = r16.proceed(r15, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0291, code lost:
        if (r2 != r4) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0293, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0294, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0295, code lost:
        r12 = r5;
        r14 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0299, code lost:
        r0 = r15.getDispatcher();
        r10 = new coil.RealImageLoader$executeChain$2(r16, r15, (kotlin.coroutines.Continuation<? super coil.RealImageLoader$executeChain$2>) null);
        r3.f39680h = r11;
        r3.f39681i = r15;
        r3.f39682j = r9;
        r3.f39683k = r13;
        r3.f39684l = r5;
        r3.f39685m = null;
        r3.f39693u = 4;
        r2 = kotlinx.coroutines.BuildersKt.withContext(r0, r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b7, code lost:
        if (r2 != r4) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02b9, code lost:
        return r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03a6 A[Catch:{ all -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03a7 A[Catch:{ all -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0481 A[Catch:{ all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0501 A[SYNTHETIC, Splitter:B:236:0x0501] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object executeMain(coil.request.ImageRequest r27, int r28, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r29) {
        /*
            r26 = this;
            r1 = r26
            r0 = r28
            r2 = r29
            boolean r3 = r2 instanceof coil.RealImageLoader$executeMain$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            coil.RealImageLoader$executeMain$1 r3 = (coil.RealImageLoader$executeMain$1) r3
            int r4 = r3.f39693u
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f39693u = r4
            goto L_0x001e
        L_0x0019:
            coil.RealImageLoader$executeMain$1 r3 = new coil.RealImageLoader$executeMain$1
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f39691s
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f39693u
            java.lang.String r6 = " - "
            java.lang.String r7 = "🚨 Failed - "
            java.lang.String r8 = "RealImageLoader"
            switch(r5) {
                case 0: goto L_0x0153;
                case 1: goto L_0x012f;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00c7;
                case 5: goto L_0x0081;
                case 6: goto L_0x0050;
                case 7: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            java.lang.Object r0 = r3.f39683k
            coil.request.ImageRequest r0 = (coil.request.ImageRequest) r0
            java.lang.Object r4 = r3.f39682j
            coil.request.ErrorResult r4 = (coil.request.ErrorResult) r4
            java.lang.Object r5 = r3.f39681i
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r3 = r3.f39680h
            coil.EventListener r3 = (coil.EventListener) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x004d }
            goto L_0x04e6
        L_0x004d:
            r0 = move-exception
            goto L_0x0505
        L_0x0050:
            java.lang.Object r0 = r3.f39687o
            coil.request.ImageRequest r0 = (coil.request.ImageRequest) r0
            java.lang.Object r5 = r3.f39686n
            coil.request.ErrorResult r5 = (coil.request.ErrorResult) r5
            java.lang.Object r11 = r3.f39685m
            coil.request.ImageResult r11 = (coil.request.ImageResult) r11
            java.lang.Object r12 = r3.f39684l
            coil.memory.RequestDelegate r12 = (coil.memory.RequestDelegate) r12
            java.lang.Object r13 = r3.f39683k
            coil.memory.TargetDelegate r13 = (coil.memory.TargetDelegate) r13
            java.lang.Object r14 = r3.f39682j
            coil.EventListener r14 = (coil.EventListener) r14
            java.lang.Object r15 = r3.f39681i
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15
            java.lang.Object r9 = r3.f39680h
            coil.RealImageLoader r9 = (coil.RealImageLoader) r9
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0078 }
            r16 = r6
            r6 = r7
            goto L_0x0426
        L_0x0078:
            r0 = move-exception
            r16 = r6
            r6 = r7
        L_0x007c:
            r1 = r9
            r5 = r12
            r9 = r14
            goto L_0x047d
        L_0x0081:
            java.lang.Object r0 = r3.f39689q
            coil.request.ImageResult$Metadata r0 = (coil.request.ImageResult.Metadata) r0
            java.lang.Object r5 = r3.f39688p
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            java.lang.Object r9 = r3.f39687o
            coil.request.SuccessResult r9 = (coil.request.SuccessResult) r9
            java.lang.Object r11 = r3.f39686n
            coil.RealImageLoader r11 = (coil.RealImageLoader) r11
            java.lang.Object r12 = r3.f39685m
            coil.request.ImageResult r12 = (coil.request.ImageResult) r12
            java.lang.Object r13 = r3.f39684l
            coil.memory.RequestDelegate r13 = (coil.memory.RequestDelegate) r13
            java.lang.Object r14 = r3.f39683k
            coil.memory.TargetDelegate r14 = (coil.memory.TargetDelegate) r14
            java.lang.Object r15 = r3.f39682j
            coil.EventListener r15 = (coil.EventListener) r15
            java.lang.Object r10 = r3.f39681i
            coil.request.ImageRequest r10 = (coil.request.ImageRequest) r10
            r27 = r0
            java.lang.Object r0 = r3.f39680h
            r16 = r0
            coil.RealImageLoader r16 = (coil.RealImageLoader) r16
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x00ba }
            r0 = r27
            r17 = r7
            r1 = r16
            r16 = r6
            goto L_0x033c
        L_0x00ba:
            r0 = move-exception
            r17 = r7
            r12 = r13
            r13 = r14
            r14 = r15
            r1 = r16
            r16 = r6
        L_0x00c4:
            r15 = r10
            goto L_0x038c
        L_0x00c7:
            java.lang.Object r0 = r3.f39684l
            r5 = r0
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r0 = r3.f39683k
            r13 = r0
            coil.memory.TargetDelegate r13 = (coil.memory.TargetDelegate) r13
            java.lang.Object r0 = r3.f39682j
            r9 = r0
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r0 = r3.f39681i
            r15 = r0
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15
            java.lang.Object r0 = r3.f39680h
            r10 = r0
            coil.RealImageLoader r10 = (coil.RealImageLoader) r10
        L_0x00e0:
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x014c }
            goto L_0x0295
        L_0x00e5:
            java.lang.Object r0 = r3.f39684l
            r5 = r0
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r0 = r3.f39683k
            r13 = r0
            coil.memory.TargetDelegate r13 = (coil.memory.TargetDelegate) r13
            java.lang.Object r0 = r3.f39682j
            r9 = r0
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r0 = r3.f39681i
            r15 = r0
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15
            java.lang.Object r0 = r3.f39680h
            r10 = r0
            coil.RealImageLoader r10 = (coil.RealImageLoader) r10
            goto L_0x00e0
        L_0x00ff:
            int r0 = r3.f39690r
            java.lang.Object r5 = r3.f39685m
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            java.lang.Object r9 = r3.f39684l
            coil.memory.RequestDelegate r9 = (coil.memory.RequestDelegate) r9
            java.lang.Object r10 = r3.f39683k
            r13 = r10
            coil.memory.TargetDelegate r13 = (coil.memory.TargetDelegate) r13
            java.lang.Object r10 = r3.f39682j
            coil.EventListener r10 = (coil.EventListener) r10
            java.lang.Object r11 = r3.f39681i
            r15 = r11
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15
            java.lang.Object r11 = r3.f39680h
            coil.RealImageLoader r11 = (coil.RealImageLoader) r11
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0126 }
            r18 = r0
            r23 = r5
            r5 = r9
            r9 = r10
            goto L_0x0258
        L_0x0126:
            r0 = move-exception
            r16 = r6
            r6 = r7
            r5 = r9
            r9 = r10
        L_0x012c:
            r1 = r11
            goto L_0x047d
        L_0x012f:
            int r0 = r3.f39690r
            java.lang.Object r5 = r3.f39684l
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r9 = r3.f39683k
            r13 = r9
            coil.memory.TargetDelegate r13 = (coil.memory.TargetDelegate) r13
            java.lang.Object r9 = r3.f39682j
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r10 = r3.f39681i
            r15 = r10
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15
            java.lang.Object r10 = r3.f39680h
            coil.RealImageLoader r10 = (coil.RealImageLoader) r10
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x014c }
            goto L_0x01d0
        L_0x014c:
            r0 = move-exception
            r16 = r6
            r6 = r7
            r1 = r10
            goto L_0x047d
        L_0x0153:
            kotlin.ResultKt.throwOnFailure(r2)
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.isShutdown
            boolean r2 = r2.get()
            r5 = 1
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x0509
            r2 = r27
            r9 = 0
            coil.request.ImageRequest$Builder r2 = coil.request.ImageRequest.newBuilder$default(r2, r9, r5, r9)
            coil.request.DefaultRequestOptions r9 = r26.getDefaults()
            coil.request.ImageRequest$Builder r2 = r2.defaults(r9)
            coil.request.ImageRequest r15 = r2.build()
            coil.EventListener$Factory r2 = r26.getEventListenerFactory()
            coil.EventListener r9 = r2.create(r15)
            coil.memory.DelegateService r2 = r1.delegateService
            coil.target.Target r10 = r15.getTarget()
            coil.memory.TargetDelegate r13 = r2.createTargetDelegate(r10, r0, r9)
            coil.memory.DelegateService r2 = r1.delegateService
            kotlin.coroutines.CoroutineContext r10 = r3.getContext()
            kotlinx.coroutines.Job$Key r11 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
            coil.memory.RequestDelegate r2 = r2.createRequestDelegate(r15, r13, r10)
            java.lang.Object r10 = r15.getData()     // Catch:{ all -> 0x0476 }
            coil.request.NullRequestData r11 = coil.request.NullRequestData.INSTANCE     // Catch:{ all -> 0x0476 }
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0476 }
            if (r10 != 0) goto L_0x046b
            if (r0 != 0) goto L_0x01db
            androidx.lifecycle.Lifecycle r10 = r15.getLifecycle()     // Catch:{ all -> 0x01d4 }
            androidx.lifecycle.Lifecycle$State r11 = r10.getCurrentState()     // Catch:{ all -> 0x01d4 }
            androidx.lifecycle.Lifecycle$State r12 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ all -> 0x01d4 }
            boolean r11 = r11.isAtLeast(r12)     // Catch:{ all -> 0x01d4 }
            if (r11 == 0) goto L_0x01b9
            goto L_0x01db
        L_0x01b9:
            r3.f39680h = r1     // Catch:{ all -> 0x01d4 }
            r3.f39681i = r15     // Catch:{ all -> 0x01d4 }
            r3.f39682j = r9     // Catch:{ all -> 0x01d4 }
            r3.f39683k = r13     // Catch:{ all -> 0x01d4 }
            r3.f39684l = r2     // Catch:{ all -> 0x01d4 }
            r3.f39690r = r0     // Catch:{ all -> 0x01d4 }
            r3.f39693u = r5     // Catch:{ all -> 0x01d4 }
            java.lang.Object r5 = coil.util.Lifecycles.observeStarted(r10, r3)     // Catch:{ all -> 0x01d4 }
            if (r5 != r4) goto L_0x01ce
            return r4
        L_0x01ce:
            r10 = r1
            r5 = r2
        L_0x01d0:
            r2 = r5
            r5 = r9
            r9 = r10
            goto L_0x01dd
        L_0x01d4:
            r0 = move-exception
            r5 = r2
            r16 = r6
            r6 = r7
            goto L_0x047d
        L_0x01db:
            r5 = r9
            r9 = r1
        L_0x01dd:
            coil.memory.MemoryCacheService r10 = r9.memoryCacheService     // Catch:{ all -> 0x0464 }
            coil.memory.MemoryCache$Key r11 = r15.getPlaceholderMemoryCacheKey()     // Catch:{ all -> 0x0464 }
            coil.memory.RealMemoryCache$Value r10 = r10.get(r11)     // Catch:{ all -> 0x0464 }
            if (r10 != 0) goto L_0x01eb
            r10 = 0
            goto L_0x01ef
        L_0x01eb:
            android.graphics.Bitmap r10 = r10.getBitmap()     // Catch:{ all -> 0x0464 }
        L_0x01ef:
            r11 = 0
            coil.util.Extensions.setMetadata(r13, r11)     // Catch:{ all -> 0x0450 }
            if (r10 != 0) goto L_0x01f7
            r12 = 0
            goto L_0x0209
        L_0x01f7:
            android.content.Context r11 = r15.getContext()     // Catch:{ all -> 0x0450 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ all -> 0x0450 }
            java.lang.String r12 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ all -> 0x0450 }
            android.graphics.drawable.BitmapDrawable r12 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0450 }
            r12.<init>(r11, r10)     // Catch:{ all -> 0x0450 }
        L_0x0209:
            if (r12 != 0) goto L_0x020f
            android.graphics.drawable.Drawable r12 = r15.getPlaceholder()     // Catch:{ all -> 0x0450 }
        L_0x020f:
            r13.start(r12, r10)     // Catch:{ all -> 0x0450 }
            r5.onStart(r15)     // Catch:{ all -> 0x0450 }
            coil.request.ImageRequest$Listener r11 = r15.getListener()     // Catch:{ all -> 0x0450 }
            if (r11 != 0) goto L_0x021c
            goto L_0x0221
        L_0x021c:
            r11.onStart(r15)     // Catch:{ all -> 0x0450 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0450 }
        L_0x0221:
            coil.memory.RealMemoryCache r11 = r9.getMemoryCache()     // Catch:{ all -> 0x0464 }
            coil.bitmap.BitmapReferenceCounter r11 = r11.getReferenceCounter()     // Catch:{ all -> 0x0464 }
            if (r10 == 0) goto L_0x022e
            r11.decrement(r10)     // Catch:{ all -> 0x0464 }
        L_0x022e:
            r5.resolveSizeStart(r15)     // Catch:{ all -> 0x0464 }
            coil.size.SizeResolver r11 = r15.getSizeResolver()     // Catch:{ all -> 0x0464 }
            r3.f39680h = r9     // Catch:{ all -> 0x0464 }
            r3.f39681i = r15     // Catch:{ all -> 0x0464 }
            r3.f39682j = r5     // Catch:{ all -> 0x0464 }
            r3.f39683k = r13     // Catch:{ all -> 0x0464 }
            r3.f39684l = r2     // Catch:{ all -> 0x0464 }
            r3.f39685m = r10     // Catch:{ all -> 0x0464 }
            r3.f39690r = r0     // Catch:{ all -> 0x0464 }
            r12 = 2
            r3.f39693u = r12     // Catch:{ all -> 0x0464 }
            java.lang.Object r11 = r11.size(r3)     // Catch:{ all -> 0x0464 }
            if (r11 != r4) goto L_0x024d
            return r4
        L_0x024d:
            r18 = r0
            r23 = r10
            r25 = r5
            r5 = r2
            r2 = r11
            r11 = r9
            r9 = r25
        L_0x0258:
            r0 = r2
            coil.size.Size r0 = (coil.size.Size) r0     // Catch:{ all -> 0x044a }
            r9.resolveSizeEnd(r15, r0)     // Catch:{ all -> 0x044a }
            coil.intercept.RealInterceptorChain r2 = new coil.intercept.RealInterceptorChain     // Catch:{ all -> 0x044a }
            java.util.List r19 = r11.interceptors     // Catch:{ all -> 0x044a }
            r20 = 0
            r16 = r2
            r17 = r15
            r21 = r15
            r22 = r0
            r24 = r9
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x044a }
            coil.util.ImageLoaderOptions r0 = r11.getOptions()     // Catch:{ all -> 0x044a }
            boolean r0 = r0.getLaunchInterceptorChainOnMainThread()     // Catch:{ all -> 0x044a }
            if (r0 == 0) goto L_0x0299
            r3.f39680h = r11     // Catch:{ all -> 0x044a }
            r3.f39681i = r15     // Catch:{ all -> 0x044a }
            r3.f39682j = r9     // Catch:{ all -> 0x044a }
            r3.f39683k = r13     // Catch:{ all -> 0x044a }
            r3.f39684l = r5     // Catch:{ all -> 0x044a }
            r10 = 0
            r3.f39685m = r10     // Catch:{ all -> 0x044a }
            r0 = 3
            r3.f39693u = r0     // Catch:{ all -> 0x044a }
            java.lang.Object r2 = r2.proceed(r15, r3)     // Catch:{ all -> 0x044a }
            if (r2 != r4) goto L_0x0294
            return r4
        L_0x0294:
            r10 = r11
        L_0x0295:
            r12 = r5
            r14 = r9
            r9 = r10
            goto L_0x02ba
        L_0x0299:
            kotlinx.coroutines.CoroutineDispatcher r0 = r15.getDispatcher()     // Catch:{ all -> 0x044a }
            coil.RealImageLoader$executeChain$2 r10 = new coil.RealImageLoader$executeChain$2     // Catch:{ all -> 0x044a }
            r12 = 0
            r10.<init>(r2, r15, r12)     // Catch:{ all -> 0x044a }
            r3.f39680h = r11     // Catch:{ all -> 0x044a }
            r3.f39681i = r15     // Catch:{ all -> 0x044a }
            r3.f39682j = r9     // Catch:{ all -> 0x044a }
            r3.f39683k = r13     // Catch:{ all -> 0x044a }
            r3.f39684l = r5     // Catch:{ all -> 0x044a }
            r2 = 0
            r3.f39685m = r2     // Catch:{ all -> 0x044a }
            r2 = 4
            r3.f39693u = r2     // Catch:{ all -> 0x044a }
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r0, r10, r3)     // Catch:{ all -> 0x044a }
            if (r2 != r4) goto L_0x0294
            return r4
        L_0x02ba:
            r11 = r2
            coil.request.ImageResult r11 = (coil.request.ImageResult) r11     // Catch:{ all -> 0x0078 }
            boolean r0 = r11 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x03b6
            r2 = r11
            coil.request.SuccessResult r2 = (coil.request.SuccessResult) r2     // Catch:{ all -> 0x0078 }
            coil.request.ImageRequest r5 = r2.getRequest()     // Catch:{ all -> 0x0384 }
            coil.request.ImageResult$Metadata r0 = r2.getMetadata()     // Catch:{ all -> 0x0384 }
            coil.decode.DataSource r10 = r0.getDataSource()     // Catch:{ all -> 0x0384 }
            coil.util.Logger r1 = r9.getLogger()     // Catch:{ all -> 0x0384 }
            r16 = r6
            if (r1 != 0) goto L_0x02db
            r17 = r7
            goto L_0x0313
        L_0x02db:
            int r6 = r1.getLevel()     // Catch:{ all -> 0x0382 }
            r17 = r7
            r7 = 4
            if (r6 > r7) goto L_0x0311
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0380 }
            r6.<init>()     // Catch:{ all -> 0x0380 }
            java.lang.String r7 = coil.util.Extensions.getEmoji(r10)     // Catch:{ all -> 0x0380 }
            r6.append(r7)     // Catch:{ all -> 0x0380 }
            java.lang.String r7 = " Successful ("
            r6.append(r7)     // Catch:{ all -> 0x0380 }
            java.lang.String r7 = r10.name()     // Catch:{ all -> 0x0380 }
            r6.append(r7)     // Catch:{ all -> 0x0380 }
            java.lang.String r7 = ") - "
            r6.append(r7)     // Catch:{ all -> 0x0380 }
            java.lang.Object r7 = r5.getData()     // Catch:{ all -> 0x0380 }
            r6.append(r7)     // Catch:{ all -> 0x0380 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0380 }
            r7 = 4
            r10 = 0
            r1.log(r8, r7, r6, r10)     // Catch:{ all -> 0x0380 }
        L_0x0311:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0380 }
        L_0x0313:
            coil.util.Extensions.setMetadata(r13, r0)     // Catch:{ all -> 0x0380 }
            r3.f39680h = r9     // Catch:{ all -> 0x0380 }
            r3.f39681i = r15     // Catch:{ all -> 0x0380 }
            r3.f39682j = r14     // Catch:{ all -> 0x0380 }
            r3.f39683k = r13     // Catch:{ all -> 0x0380 }
            r3.f39684l = r12     // Catch:{ all -> 0x0380 }
            r3.f39685m = r11     // Catch:{ all -> 0x0380 }
            r3.f39686n = r9     // Catch:{ all -> 0x0380 }
            r3.f39687o = r2     // Catch:{ all -> 0x0380 }
            r3.f39688p = r5     // Catch:{ all -> 0x0380 }
            r3.f39689q = r0     // Catch:{ all -> 0x0380 }
            r1 = 5
            r3.f39693u = r1     // Catch:{ all -> 0x0380 }
            java.lang.Object r1 = r13.success(r2, r3)     // Catch:{ all -> 0x0380 }
            if (r1 != r4) goto L_0x0334
            return r4
        L_0x0334:
            r1 = r9
            r10 = r15
            r9 = r2
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r1
        L_0x033c:
            r15.onSuccess(r5, r0)     // Catch:{ all -> 0x037a }
            coil.request.ImageRequest$Listener r2 = r5.getListener()     // Catch:{ all -> 0x037a }
            if (r2 != 0) goto L_0x0346
            goto L_0x034b
        L_0x0346:
            r2.onSuccess(r5, r0)     // Catch:{ all -> 0x037a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x037a }
        L_0x034b:
            coil.memory.RealMemoryCache r0 = r11.getMemoryCache()     // Catch:{ all -> 0x0371 }
            coil.bitmap.BitmapReferenceCounter r0 = r0.getReferenceCounter()     // Catch:{ all -> 0x0371 }
            android.graphics.drawable.Drawable r2 = r9.getDrawable()     // Catch:{ all -> 0x0371 }
            if (r2 == 0) goto L_0x036d
            boolean r5 = r2 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0371 }
            if (r5 == 0) goto L_0x036d
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2     // Catch:{ all -> 0x0371 }
            android.graphics.Bitmap r2 = r2.getBitmap()     // Catch:{ all -> 0x0371 }
            if (r2 != 0) goto L_0x0366
            goto L_0x036d
        L_0x0366:
            boolean r0 = r0.decrement(r2)     // Catch:{ all -> 0x0371 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x0371 }
        L_0x036d:
            r11 = r12
            r12 = r13
            goto L_0x0441
        L_0x0371:
            r0 = move-exception
            r5 = r13
            r13 = r14
            r9 = r15
            r6 = r17
            r15 = r10
            goto L_0x047d
        L_0x037a:
            r0 = move-exception
            r12 = r13
            r13 = r14
            r14 = r15
            goto L_0x00c4
        L_0x0380:
            r0 = move-exception
            goto L_0x0389
        L_0x0382:
            r0 = move-exception
            goto L_0x0387
        L_0x0384:
            r0 = move-exception
            r16 = r6
        L_0x0387:
            r17 = r7
        L_0x0389:
            r1 = r9
            r11 = r1
            r9 = r2
        L_0x038c:
            coil.memory.RealMemoryCache r2 = r11.getMemoryCache()     // Catch:{ all -> 0x03af }
            coil.bitmap.BitmapReferenceCounter r2 = r2.getReferenceCounter()     // Catch:{ all -> 0x03af }
            android.graphics.drawable.Drawable r5 = r9.getDrawable()     // Catch:{ all -> 0x03af }
            if (r5 == 0) goto L_0x03ae
            boolean r6 = r5 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x03af }
            if (r6 == 0) goto L_0x03ae
            android.graphics.drawable.BitmapDrawable r5 = (android.graphics.drawable.BitmapDrawable) r5     // Catch:{ all -> 0x03af }
            android.graphics.Bitmap r5 = r5.getBitmap()     // Catch:{ all -> 0x03af }
            if (r5 != 0) goto L_0x03a7
            goto L_0x03ae
        L_0x03a7:
            boolean r2 = r2.decrement(r5)     // Catch:{ all -> 0x03af }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch:{ all -> 0x03af }
        L_0x03ae:
            throw r0     // Catch:{ all -> 0x03af }
        L_0x03af:
            r0 = move-exception
            r5 = r12
            r9 = r14
            r6 = r17
            goto L_0x047d
        L_0x03b6:
            r16 = r6
            r17 = r7
            boolean r0 = r11 instanceof coil.request.ErrorResult     // Catch:{ all -> 0x0445 }
            if (r0 == 0) goto L_0x0441
            r5 = r11
            coil.request.ErrorResult r5 = (coil.request.ErrorResult) r5     // Catch:{ all -> 0x0445 }
            coil.request.ImageRequest r0 = r5.getRequest()     // Catch:{ all -> 0x0445 }
            coil.util.Logger r1 = r9.getLogger()     // Catch:{ all -> 0x0445 }
            if (r1 != 0) goto L_0x03cf
            r6 = r17
        L_0x03cd:
            r1 = 0
            goto L_0x0409
        L_0x03cf:
            int r2 = r1.getLevel()     // Catch:{ all -> 0x0445 }
            r6 = 4
            if (r2 > r6) goto L_0x0404
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0445 }
            r2.<init>()     // Catch:{ all -> 0x0445 }
            r6 = r17
            r2.append(r6)     // Catch:{ all -> 0x043e }
            java.lang.Object r7 = r0.getData()     // Catch:{ all -> 0x043e }
            r2.append(r7)     // Catch:{ all -> 0x043e }
            r7 = r16
            r2.append(r7)     // Catch:{ all -> 0x03ff }
            java.lang.Throwable r10 = r5.getThrowable()     // Catch:{ all -> 0x03ff }
            r2.append(r10)     // Catch:{ all -> 0x03ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03ff }
            r16 = r7
            r7 = 0
            r10 = 4
            r1.log(r8, r10, r2, r7)     // Catch:{ all -> 0x043e }
            goto L_0x0406
        L_0x03ff:
            r0 = move-exception
            r16 = r7
            goto L_0x007c
        L_0x0404:
            r6 = r17
        L_0x0406:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x043e }
            goto L_0x03cd
        L_0x0409:
            coil.util.Extensions.setMetadata(r13, r1)     // Catch:{ all -> 0x043e }
            r3.f39680h = r9     // Catch:{ all -> 0x043e }
            r3.f39681i = r15     // Catch:{ all -> 0x043e }
            r3.f39682j = r14     // Catch:{ all -> 0x043e }
            r3.f39683k = r13     // Catch:{ all -> 0x043e }
            r3.f39684l = r12     // Catch:{ all -> 0x043e }
            r3.f39685m = r11     // Catch:{ all -> 0x043e }
            r3.f39686n = r5     // Catch:{ all -> 0x043e }
            r3.f39687o = r0     // Catch:{ all -> 0x043e }
            r1 = 6
            r3.f39693u = r1     // Catch:{ all -> 0x043e }
            java.lang.Object r1 = r13.error(r5, r3)     // Catch:{ all -> 0x043e }
            if (r1 != r4) goto L_0x0426
            return r4
        L_0x0426:
            java.lang.Throwable r1 = r5.getThrowable()     // Catch:{ all -> 0x043e }
            r14.onError(r0, r1)     // Catch:{ all -> 0x043e }
            coil.request.ImageRequest$Listener r1 = r0.getListener()     // Catch:{ all -> 0x043e }
            if (r1 != 0) goto L_0x0434
            goto L_0x0441
        L_0x0434:
            java.lang.Throwable r2 = r5.getThrowable()     // Catch:{ all -> 0x043e }
            r1.onError(r0, r2)     // Catch:{ all -> 0x043e }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x043e }
            goto L_0x0441
        L_0x043e:
            r0 = move-exception
            goto L_0x007c
        L_0x0441:
            r12.complete()
            return r11
        L_0x0445:
            r0 = move-exception
            r6 = r17
            goto L_0x007c
        L_0x044a:
            r0 = move-exception
            r16 = r6
            r6 = r7
            goto L_0x012c
        L_0x0450:
            r0 = move-exception
            r16 = r6
            r6 = r7
            coil.memory.RealMemoryCache r1 = r9.getMemoryCache()     // Catch:{ all -> 0x0462 }
            coil.bitmap.BitmapReferenceCounter r1 = r1.getReferenceCounter()     // Catch:{ all -> 0x0462 }
            if (r10 == 0) goto L_0x0461
            r1.decrement(r10)     // Catch:{ all -> 0x0462 }
        L_0x0461:
            throw r0     // Catch:{ all -> 0x0462 }
        L_0x0462:
            r0 = move-exception
            goto L_0x0468
        L_0x0464:
            r0 = move-exception
            r16 = r6
            r6 = r7
        L_0x0468:
            r1 = r9
            r9 = r5
            goto L_0x047c
        L_0x046b:
            r16 = r6
            r6 = r7
            coil.request.NullRequestDataException r0 = new coil.request.NullRequestDataException     // Catch:{ all -> 0x0474 }
            r0.<init>()     // Catch:{ all -> 0x0474 }
            throw r0     // Catch:{ all -> 0x0474 }
        L_0x0474:
            r0 = move-exception
            goto L_0x047a
        L_0x0476:
            r0 = move-exception
            r16 = r6
            r6 = r7
        L_0x047a:
            r1 = r26
        L_0x047c:
            r5 = r2
        L_0x047d:
            boolean r2 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x0501
            coil.memory.RequestService r2 = r1.requestService     // Catch:{ all -> 0x004d }
            coil.request.ErrorResult r0 = r2.errorResult(r15, r0)     // Catch:{ all -> 0x004d }
            coil.request.ImageRequest r2 = r0.getRequest()     // Catch:{ all -> 0x004d }
            coil.util.Logger r1 = r1.getLogger()     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0493
        L_0x0491:
            r1 = 0
            goto L_0x04c1
        L_0x0493:
            int r7 = r1.getLevel()     // Catch:{ all -> 0x004d }
            r10 = 4
            if (r7 > r10) goto L_0x04be
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r7.<init>()     // Catch:{ all -> 0x004d }
            r7.append(r6)     // Catch:{ all -> 0x004d }
            java.lang.Object r6 = r2.getData()     // Catch:{ all -> 0x004d }
            r7.append(r6)     // Catch:{ all -> 0x004d }
            r6 = r16
            r7.append(r6)     // Catch:{ all -> 0x004d }
            java.lang.Throwable r6 = r0.getThrowable()     // Catch:{ all -> 0x004d }
            r7.append(r6)     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x004d }
            r7 = 4
            r10 = 0
            r1.log(r8, r7, r6, r10)     // Catch:{ all -> 0x004d }
        L_0x04be:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004d }
            goto L_0x0491
        L_0x04c1:
            coil.util.Extensions.setMetadata(r13, r1)     // Catch:{ all -> 0x004d }
            r3.f39680h = r9     // Catch:{ all -> 0x004d }
            r3.f39681i = r5     // Catch:{ all -> 0x004d }
            r3.f39682j = r0     // Catch:{ all -> 0x004d }
            r3.f39683k = r2     // Catch:{ all -> 0x004d }
            r1 = 0
            r3.f39684l = r1     // Catch:{ all -> 0x004d }
            r3.f39685m = r1     // Catch:{ all -> 0x004d }
            r3.f39686n = r1     // Catch:{ all -> 0x004d }
            r3.f39687o = r1     // Catch:{ all -> 0x004d }
            r3.f39688p = r1     // Catch:{ all -> 0x004d }
            r3.f39689q = r1     // Catch:{ all -> 0x004d }
            r1 = 7
            r3.f39693u = r1     // Catch:{ all -> 0x004d }
            java.lang.Object r1 = r13.error(r0, r3)     // Catch:{ all -> 0x004d }
            if (r1 != r4) goto L_0x04e3
            return r4
        L_0x04e3:
            r4 = r0
            r0 = r2
            r3 = r9
        L_0x04e6:
            java.lang.Throwable r1 = r4.getThrowable()     // Catch:{ all -> 0x004d }
            r3.onError(r0, r1)     // Catch:{ all -> 0x004d }
            coil.request.ImageRequest$Listener r1 = r0.getListener()     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x04f4
            goto L_0x04fd
        L_0x04f4:
            java.lang.Throwable r2 = r4.getThrowable()     // Catch:{ all -> 0x004d }
            r1.onError(r0, r2)     // Catch:{ all -> 0x004d }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004d }
        L_0x04fd:
            r5.complete()
            return r4
        L_0x0501:
            r1.onCancel(r15, r9)     // Catch:{ all -> 0x004d }
            throw r0     // Catch:{ all -> 0x004d }
        L_0x0505:
            r5.complete()
            throw r0
        L_0x0509:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "The image loader is shutdown."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.executeMain(coil.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 4) {
            logger2.log(TAG, 4, Intrinsics.stringPlus("🏗  Cancelled - ", imageRequest.getData()), (Throwable) null);
        }
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    private final Object onError(ErrorResult errorResult, TargetDelegate targetDelegate, EventListener eventListener, Continuation<? super Unit> continuation) {
        ImageRequest request = errorResult.getRequest();
        Logger logger2 = getLogger();
        if (logger2 != null && logger2.getLevel() <= 4) {
            logger2.log(TAG, 4, "🚨 Failed - " + request.getData() + " - " + errorResult.getThrowable(), (Throwable) null);
        }
        Extensions.setMetadata(targetDelegate, (ImageResult.Metadata) null);
        InlineMarker.mark(0);
        targetDelegate.error(errorResult, continuation);
        InlineMarker.mark(1);
        eventListener.onError(request, errorResult.getThrowable());
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, errorResult.getThrowable());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: finally extract failed */
    private final Object onSuccess(SuccessResult successResult, TargetDelegate targetDelegate, EventListener eventListener, Continuation<? super Unit> continuation) {
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            ImageRequest request = successResult.getRequest();
            ImageResult.Metadata metadata = successResult.getMetadata();
            DataSource dataSource = metadata.getDataSource();
            Logger logger2 = getLogger();
            if (logger2 != null) {
                if (logger2.getLevel() <= 4) {
                    logger2.log(TAG, 4, Extensions.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), (Throwable) null);
                }
            }
            Extensions.setMetadata(targetDelegate, metadata);
            InlineMarker.mark(0);
            targetDelegate.success(successResult, continuation);
            InlineMarker.mark(1);
            eventListener.onSuccess(request, metadata);
            ImageRequest.Listener listener = request.getListener();
            if (listener != null) {
                listener.onSuccess(request, metadata);
            }
            InlineMarker.finallyStart(1);
            BitmapReferenceCounter referenceCounter = getMemoryCache().getReferenceCounter();
            Drawable drawable = successResult.getDrawable();
            if (!(drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap2 = ((BitmapDrawable) drawable).getBitmap()) == null)) {
                referenceCounter.decrement(bitmap2);
            }
            InlineMarker.finallyEnd(1);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            BitmapReferenceCounter referenceCounter2 = getMemoryCache().getReferenceCounter();
            Drawable drawable2 = successResult.getDrawable();
            if (!(drawable2 == null || !(drawable2 instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable2).getBitmap()) == null)) {
                referenceCounter2.decrement(bitmap);
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    @NotNull
    public Disposable enqueue(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RealImageLoader$enqueue$job$1(this, imageRequest, (Continuation<? super RealImageLoader$enqueue$job$1>) null), 3, (Object) null);
        if (imageRequest.getTarget() instanceof ViewTarget) {
            return new ViewTargetDisposable(Extensions.getRequestManager(((ViewTarget) imageRequest.getTarget()).getView()).setCurrentRequestJob(launch$default), (ViewTarget) imageRequest.getTarget());
        }
        return new BaseTargetDisposable(launch$default);
    }

    @Nullable
    public Object execute(@NotNull ImageRequest imageRequest, @NotNull Continuation<? super ImageResult> continuation) {
        if (imageRequest.getTarget() instanceof ViewTarget) {
            ViewTargetRequestManager requestManager = Extensions.getRequestManager(((ViewTarget) imageRequest.getTarget()).getView());
            CoroutineContext.Element element = continuation.getContext().get(Job.Key);
            Intrinsics.checkNotNull(element);
            requestManager.setCurrentRequestJob((Job) element);
        }
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new RealImageLoader$execute$2(this, imageRequest, (Continuation<? super RealImageLoader$execute$2>) null), continuation);
    }

    @NotNull
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    @NotNull
    public final Call.Factory getCallFactory() {
        return this.callFactory;
    }

    @NotNull
    public final ComponentRegistry getComponentRegistry() {
        return this.componentRegistry;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    @NotNull
    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Nullable
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final ImageLoaderOptions getOptions() {
        return this.options;
    }

    @NotNull
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this);
    }

    public final void onTrimMemory(int i11) {
        getMemoryCache().getStrongMemoryCache().trimMemory(i11);
        getMemoryCache().getWeakMemoryCache().trimMemory(i11);
        getBitmapPool().trimMemory(i11);
    }

    public void shutdown() {
        if (!this.isShutdown.getAndSet(true)) {
            CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
            this.systemCallbacks.shutdown();
            getMemoryCache().clear();
            getBitmapPool().clear();
        }
    }

    @NotNull
    public RealMemoryCache getMemoryCache() {
        return this.memoryCache;
    }
}
