package coil.util;

import android.app.ActivityManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.StatFs;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.bitmap.BitmapReferenceCounter;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import coil.memory.TargetDelegate;
import coil.request.ImageResult;
import coil.request.Parameters;
import coil.size.Scale;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import com.facebook.internal.NativeProtocol;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import f3.a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010J\u001a\u00020&H\u0000\u001a\u0016\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0NH\u0000\u001a\f\u0010O\u001a\u00020P*\u00020QH\u0000\u001a\u0017\u0010R\u001a\u00020P*\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UH\b\u001a\u0017\u0010R\u001a\u00020P*\u00020S2\b\u0010V\u001a\u0004\u0018\u00010\u001eH\b\u001a\u0018\u0010W\u001a\u0004\u0018\u00010\u0014*\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u001d\u0010Z\u001a\u00020[*\u00020\\2\u0006\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020_H\n\u001a3\u0010Z\u001a\u00020[*\u00020\\2\u0006\u0010]\u001a\u00020\u00142\f\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a2\u0006\u0010c\u001a\u00020d2\u0006\u0010^\u001a\u00020_H\n\u001a$\u0010e\u001a\u00020P*\u00020f2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020P0hH\bø\u0001\u0000\u001a\u000e\u0010i\u001a\u00020_*\u0004\u0018\u00010_H\u0000\u001a\u0016\u0010i\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000\u001a\u001f\u0010j\u001a\u00020P*\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010k\u001a\u00020&H\b\"\u001c\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001f\u0010\t\u001a\u00020\n*\u00020\u000b8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u001f\u0010\u0010\u001a\u00020\n*\u00020\u000b8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0014*\u00020\u00198@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0019\u0010!\u001a\u00020\u001d*\u00020\"8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0019\u0010%\u001a\u00020&*\u00020'8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010(\"\u0019\u0010)\u001a\u00020&*\u00020*8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010+\"\u0018\u0010,\u001a\u00020&*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-\"\u0019\u0010.\u001a\u00020/*\u0002008À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\",\u00105\u001a\u0004\u0018\u000104*\u0002062\b\u00103\u001a\u0004\u0018\u0001048@@@X\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\"\u0018\u0010;\u001a\u00020\u001d*\u00020<8@X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0018\u0010?\u001a\u00020@*\u00020'8@X\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B\"\u0018\u0010C\u001a\u00020D*\u00020E8@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G\"\u0018\u0010H\u001a\u00020\u001d*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\bI\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u0006l"}, d2 = {"EMPTY_HEADERS", "Lokhttp3/Headers;", "kotlin.jvm.PlatformType", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "blockCountCompat", "", "Landroid/os/StatFs;", "getBlockCountCompat$annotations", "(Landroid/os/StatFs;)V", "getBlockCountCompat", "(Landroid/os/StatFs;)J", "blockSizeCompat", "getBlockSizeCompat$annotations", "getBlockSizeCompat", "emoji", "", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "firstPathSegment", "Landroid/net/Uri;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "height", "", "Landroid/graphics/drawable/Drawable;", "getHeight", "(Landroid/graphics/drawable/Drawable;)I", "identityHashCode", "", "getIdentityHashCode", "(Ljava/lang/Object;)I", "isAttachedToWindowCompat", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "isLowRamDeviceCompat", "Landroid/app/ActivityManager;", "(Landroid/app/ActivityManager;)Z", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "job", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "value", "Lcoil/request/ImageResult$Metadata;", "metadata", "Lcoil/memory/TargetDelegate;", "getMetadata", "(Lcoil/memory/TargetDelegate;)Lcoil/request/ImageResult$Metadata;", "setMetadata", "(Lcoil/memory/TargetDelegate;Lcoil/request/ImageResult$Metadata;)V", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "requestManager", "Lcoil/memory/ViewTargetRequestManager;", "getRequestManager", "(Landroid/view/View;)Lcoil/memory/ViewTargetRequestManager;", "scale", "Lcoil/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "width", "getWidth", "isMainThread", "lazyCallFactory", "Lokhttp3/Call$Factory;", "initializer", "Lkotlin/Function0;", "closeQuietly", "", "Ljava/io/Closeable;", "decrement", "Lcoil/bitmap/BitmapReferenceCounter;", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "getMimeTypeFromUrl", "Landroid/webkit/MimeTypeMap;", "url", "invoke", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/MemoryCache$Key$Companion;", "base", "parameters", "Lcoil/request/Parameters;", "transformations", "", "Lcoil/transform/Transformation;", "size", "Lcoil/size/Size;", "loop", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "Lkotlin/Function1;", "orEmpty", "setValid", "isValid", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Extensions")
/* renamed from: coil.util.-Extensions  reason: invalid class name */
public final class Extensions {
    private static final Headers EMPTY_HEADERS = new Headers.Builder().build();
    @Nullable
    private static final ColorSpace NULL_COLOR_SPACE = null;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: coil.util.-Extensions$WhenMappings */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DataSource.values().length];
            iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            iArr[DataSource.MEMORY.ordinal()] = 2;
            iArr[DataSource.DISK.ordinal()] = 3;
            iArr[DataSource.NETWORK.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception unused) {
        }
    }

    public static final void decrement(@NotNull BitmapReferenceCounter bitmapReferenceCounter, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "<this>");
        if (bitmap != null) {
            bitmapReferenceCounter.decrement(bitmap);
        }
    }

    public static final long getBlockCountCompat(@NotNull StatFs statFs) {
        Intrinsics.checkNotNullParameter(statFs, "<this>");
        return statFs.getBlockCountLong();
    }

    public static /* synthetic */ void getBlockCountCompat$annotations(StatFs statFs) {
    }

    public static final long getBlockSizeCompat(@NotNull StatFs statFs) {
        Intrinsics.checkNotNullParameter(statFs, "<this>");
        return statFs.getBlockSizeLong();
    }

    public static /* synthetic */ void getBlockSizeCompat$annotations(StatFs statFs) {
    }

    public static final Headers getEMPTY_HEADERS() {
        return EMPTY_HEADERS;
    }

    @NotNull
    public static final String getEmoji(@NotNull DataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return Emoji.BRAIN;
        }
        if (i11 == 3) {
            return Emoji.FLOPPY;
        }
        if (i11 == 4) {
            return Emoji.CLOUD;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public static final String getFirstPathSegment(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments");
        return (String) CollectionsKt___CollectionsKt.firstOrNull(pathSegments);
    }

    public static final int getHeight(@NotNull Drawable drawable) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Integer num = null;
        if (drawable instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) drawable;
        } else {
            bitmapDrawable = null;
        }
        if (!(bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null)) {
            num = Integer.valueOf(bitmap.getHeight());
        }
        if (num == null) {
            return drawable.getIntrinsicHeight();
        }
        return num.intValue();
    }

    public static final int getIdentityHashCode(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return System.identityHashCode(obj);
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        CoroutineContext.Element element = coroutineContext.get(Job.Key);
        Intrinsics.checkNotNull(element);
        return (Job) element;
    }

    @Nullable
    public static final ImageResult.Metadata getMetadata(@NotNull TargetDelegate targetDelegate) {
        ViewTarget viewTarget;
        View view;
        Intrinsics.checkNotNullParameter(targetDelegate, "<this>");
        Target target = targetDelegate.getTarget();
        if (target instanceof ViewTarget) {
            viewTarget = (ViewTarget) target;
        } else {
            viewTarget = null;
        }
        if (viewTarget == null || (view = viewTarget.getView()) == null) {
            return null;
        }
        return getRequestManager(view).getMetadata();
    }

    @Nullable
    public static final String getMimeTypeFromUrl(@NotNull MimeTypeMap mimeTypeMap, @Nullable String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(mimeTypeMap, "<this>");
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt__StringsKt.substringAfterLast(StringsKt__StringsKt.substringAfterLast$default(StringsKt__StringsKt.substringBeforeLast$default(StringsKt__StringsKt.substringBeforeLast$default(str, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), '.', ""));
    }

    @Nullable
    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final int getNightMode(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        return configuration.uiMode & 48;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: coil.memory.ViewTargetRequestManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final coil.memory.ViewTargetRequestManager getRequestManager(@org.jetbrains.annotations.NotNull android.view.View r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = coil.base.R.id.coil_request_manager
            java.lang.Object r1 = r4.getTag(r0)
            boolean r2 = r1 instanceof coil.memory.ViewTargetRequestManager
            r3 = 0
            if (r2 == 0) goto L_0x0013
            coil.memory.ViewTargetRequestManager r1 = (coil.memory.ViewTargetRequestManager) r1
            goto L_0x0014
        L_0x0013:
            r1 = r3
        L_0x0014:
            if (r1 != 0) goto L_0x0036
            monitor-enter(r4)
            java.lang.Object r1 = r4.getTag(r0)     // Catch:{ all -> 0x0033 }
            boolean r2 = r1 instanceof coil.memory.ViewTargetRequestManager     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0022
            r3 = r1
            coil.memory.ViewTargetRequestManager r3 = (coil.memory.ViewTargetRequestManager) r3     // Catch:{ all -> 0x0033 }
        L_0x0022:
            if (r3 != 0) goto L_0x0030
            coil.memory.ViewTargetRequestManager r1 = new coil.memory.ViewTargetRequestManager     // Catch:{ all -> 0x0033 }
            r1.<init>()     // Catch:{ all -> 0x0033 }
            r4.addOnAttachStateChangeListener(r1)     // Catch:{ all -> 0x0033 }
            r4.setTag(r0, r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0031
        L_0x0030:
            r1 = r3
        L_0x0031:
            monitor-exit(r4)
            goto L_0x0036
        L_0x0033:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Extensions.getRequestManager(android.view.View):coil.memory.ViewTargetRequestManager");
    }

    @NotNull
    public static final Scale getScale(@NotNull ImageView imageView) {
        int i11;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        ImageView.ScaleType scaleType = imageView.getScaleType();
        if (scaleType == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        }
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final int getWidth(@NotNull Drawable drawable) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Integer num = null;
        if (drawable instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) drawable;
        } else {
            bitmapDrawable = null;
        }
        if (!(bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null)) {
            num = Integer.valueOf(bitmap.getWidth());
        }
        if (num == null) {
            return drawable.getIntrinsicWidth();
        }
        return num.intValue();
    }

    @NotNull
    public static final MemoryCache.Key invoke(@NotNull MemoryCache.Key.Companion companion, @NotNull String str, @NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new MemoryCache.Key.Complex(str, CollectionsKt__CollectionsKt.emptyList(), (Size) null, parameters.cacheKeys());
    }

    public static final boolean isAttachedToWindowCompat(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ViewCompat.isAttachedToWindow(view);
    }

    public static final boolean isLowRamDeviceCompat(@NotNull ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(activityManager, "<this>");
        if (activityManager.isLowRamDevice()) {
            return true;
        }
        return false;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper());
    }

    public static final boolean isVector(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        if ((drawable instanceof VectorDrawableCompat) || (drawable instanceof VectorDrawable)) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Call.Factory lazyCallFactory(@NotNull Function0<? extends Call.Factory> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new a(LazyKt__LazyJVMKt.lazy(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: lazyCallFactory$lambda-3  reason: not valid java name */
    public static final Call m9134lazyCallFactory$lambda3(Lazy lazy, Request request) {
        Intrinsics.checkNotNullParameter(lazy, "$lazy");
        Call.Factory factory = (Call.Factory) lazy.getValue();
        if (!(factory instanceof OkHttpClient)) {
            return factory.newCall(request);
        }
        return OkHttp3Instrumentation.newCall((OkHttpClient) factory, request);
    }

    public static final void loop(@NotNull AtomicInteger atomicInteger, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        while (true) {
            function1.invoke(Integer.valueOf(atomicInteger.get()));
        }
    }

    public static final Headers orEmpty(@Nullable Headers headers) {
        return headers == null ? EMPTY_HEADERS : headers;
    }

    public static final void setMetadata(@NotNull TargetDelegate targetDelegate, @Nullable ImageResult.Metadata metadata) {
        ViewTarget viewTarget;
        Intrinsics.checkNotNullParameter(targetDelegate, "<this>");
        Target target = targetDelegate.getTarget();
        View view = null;
        if (target instanceof ViewTarget) {
            viewTarget = (ViewTarget) target;
        } else {
            viewTarget = null;
        }
        if (viewTarget != null) {
            view = viewTarget.getView();
        }
        if (view != null) {
            getRequestManager(view).setMetadata(metadata);
        }
    }

    public static final void setValid(@NotNull BitmapReferenceCounter bitmapReferenceCounter, @Nullable Bitmap bitmap, boolean z11) {
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "<this>");
        if (bitmap != null) {
            bitmapReferenceCounter.setValid(bitmap, z11);
        }
    }

    public static final void decrement(@NotNull BitmapReferenceCounter bitmapReferenceCounter, @Nullable Drawable drawable) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "<this>");
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmapReferenceCounter.decrement(bitmap);
        }
    }

    @NotNull
    public static final Parameters orEmpty(@Nullable Parameters parameters) {
        return parameters == null ? Parameters.EMPTY : parameters;
    }

    @NotNull
    public static final MemoryCache.Key invoke(@NotNull MemoryCache.Key.Companion companion, @NotNull String str, @NotNull List<? extends Transformation> list, @NotNull Size size, @NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
        Intrinsics.checkNotNullParameter(list, "transformations");
        Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size() - 1;
        if (size2 >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                arrayList.add(((Transformation) list.get(i11)).key());
                if (i12 > size2) {
                    break;
                }
                i11 = i12;
            }
        }
        return new MemoryCache.Key.Complex(str, arrayList, size, parameters.cacheKeys());
    }
}
