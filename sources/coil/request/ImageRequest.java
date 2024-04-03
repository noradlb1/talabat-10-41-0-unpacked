package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil.annotation.ExperimentalCoilApi;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.request.ImageResult;
import coil.request.Parameters;
import coil.size.DisplaySizeResolver;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.ViewSizeResolver;
import coil.target.ImageViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Contexts;
import coil.util.Extensions;
import coil.util.Requests;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import n.e;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0004\u0001\u0001BË\u0002\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u001c\u0010\u000e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00101\u001a\u00020/\u0012\b\u00102\u001a\u0004\u0018\u000103\u0012\b\u00104\u001a\u0004\u0018\u000105\u0012\b\u00106\u001a\u0004\u0018\u000103\u0012\b\u00107\u001a\u0004\u0018\u000105\u0012\b\u00108\u001a\u0004\u0018\u000103\u0012\b\u00109\u001a\u0004\u0018\u000105\u0012\u0006\u0010:\u001a\u00020;\u0012\u0006\u0010<\u001a\u00020=¢\u0006\u0002\u0010>J\u0013\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010{\u001a\u000203H\u0016J\u0012\u0010|\u001a\u00020}2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010~\u001a\u00020H\u0016R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010+\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010,\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u00100\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010U\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0010\u00107\u001a\u0004\u0018\u000105X\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u000103X\u0004¢\u0006\u0004\n\u0002\u0010XR\u0013\u0010Y\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\bZ\u0010WR\u0010\u00109\u001a\u0004\u0018\u000105X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u000103X\u0004¢\u0006\u0004\n\u0002\u0010XR'\u0010\u000e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\be\u0010RR\u0011\u00101\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\bf\u0010RR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0013\u0010i\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\bj\u0010WR\u0010\u00104\u001a\u0004\u0018\u000105X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bk\u0010dR\u0012\u00102\u001a\u0004\u0018\u000103X\u0004¢\u0006\u0004\n\u0002\u0010XR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0011\u0010-\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\bn\u0010@R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bw\u0010x¨\u0006\u0001"}, d2 = {"Lcoil/request/ImageRequest;", "", "context", "Landroid/content/Context;", "data", "target", "Lcoil/target/Target;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "placeholderMemoryCacheKey", "colorSpace", "Landroid/graphics/ColorSpace;", "fetcher", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "decoder", "Lcoil/decode/Decoder;", "transformations", "", "Lcoil/transform/Transformation;", "headers", "Lokhttp3/Headers;", "parameters", "Lcoil/request/Parameters;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowConversionToBitmap", "", "allowHardware", "allowRgb565", "premultipliedAlpha", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderResId", "", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "defined", "Lcoil/request/DefinedRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$Key;Landroid/graphics/ColorSpace;Lkotlin/Pair;Lcoil/decode/Decoder;Ljava/util/List;Lokhttp3/Headers;Lcoil/request/Parameters;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "getAllowConversionToBitmap", "()Z", "getAllowHardware", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getDecoder", "()Lcoil/decode/Decoder;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "error", "getError", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "fallback", "getFallback", "getFetcher", "()Lkotlin/Pair;", "getHeaders", "()Lokhttp3/Headers;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "placeholder", "getPlaceholder", "getPlaceholderMemoryCacheKey", "getPrecision", "()Lcoil/size/Precision;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTarget", "()Lcoil/target/Target;", "getTransformations", "()Ljava/util/List;", "getTransition", "()Lcoil/transition/Transition;", "equals", "other", "hashCode", "newBuilder", "Lcoil/request/ImageRequest$Builder;", "toString", "", "Builder", "Listener", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageRequest {
    private final boolean allowConversionToBitmap;
    private final boolean allowHardware;
    private final boolean allowRgb565;
    @NotNull
    private final Bitmap.Config bitmapConfig;
    @Nullable
    private final ColorSpace colorSpace;
    @NotNull
    private final Context context;
    @NotNull
    private final Object data;
    @Nullable
    private final Decoder decoder;
    @NotNull
    private final DefaultRequestOptions defaults;
    @NotNull
    private final DefinedRequestOptions defined;
    @NotNull
    private final CachePolicy diskCachePolicy;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @Nullable
    public final Drawable errorDrawable;
    /* access modifiers changed from: private */
    @Nullable
    public final Integer errorResId;
    /* access modifiers changed from: private */
    @Nullable
    public final Drawable fallbackDrawable;
    /* access modifiers changed from: private */
    @Nullable
    public final Integer fallbackResId;
    @Nullable
    private final Pair<Fetcher<?>, Class<?>> fetcher;
    @NotNull
    private final Headers headers;
    @NotNull
    private final Lifecycle lifecycle;
    @Nullable
    private final Listener listener;
    @Nullable
    private final MemoryCache.Key memoryCacheKey;
    @NotNull
    private final CachePolicy memoryCachePolicy;
    @NotNull
    private final CachePolicy networkCachePolicy;
    @NotNull
    private final Parameters parameters;
    /* access modifiers changed from: private */
    @Nullable
    public final Drawable placeholderDrawable;
    @Nullable
    private final MemoryCache.Key placeholderMemoryCacheKey;
    /* access modifiers changed from: private */
    @Nullable
    public final Integer placeholderResId;
    @NotNull
    private final Precision precision;
    private final boolean premultipliedAlpha;
    @NotNull
    private final Scale scale;
    @NotNull
    private final SizeResolver sizeResolver;
    @Nullable
    private final Target target;
    @NotNull
    private final List<Transformation> transformations;
    @NotNull
    private final Transition transition;

    @Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u000eJ\u0006\u0010K\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\tJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001dJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010O\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010O\u001a\u00020\u00002\b\b\u0001\u0010Q\u001a\u00020\u001dJ\u0010\u0010R\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010R\u001a\u00020\u00002\b\b\u0001\u0010Q\u001a\u00020\u001dJ#\u0010!\u001a\u00020\u0000\"\n\b\u0000\u0010S\u0018\u0001*\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002HS0#H\bJ.\u0010!\u001a\u00020\u0000\"\b\b\u0000\u0010S*\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002HS0#2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002HS0$H\u0001J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020UJ\u0010\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010'\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010WJÊ\u0001\u0010)\u001a\u00020\u00002#\b\u0006\u0010X\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020[0Y2#\b\u0006\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020[0Y28\b\u0006\u0010]\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110_¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020[0^28\b\u0006\u0010a\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110b¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020[0^H\bø\u0001\u0000J\u0010\u0010)\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u00002\b\u0010d\u001a\u0004\u0018\u00010,J\u0010\u0010+\u001a\u00020\u00002\b\u0010d\u001a\u0004\u0018\u00010GJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0017J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020eJ\u0010\u0010f\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010f\u001a\u00020\u00002\b\b\u0001\u0010Q\u001a\u00020\u001dJ\u0010\u00102\u001a\u00020\u00002\b\u0010d\u001a\u0004\u0018\u00010,J\u0010\u00102\u001a\u00020\u00002\b\u0010d\u001a\u0004\u0018\u00010GJ\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010d\u001a\u00020GJ\b\u0010i\u001a\u00020[H\u0002J\b\u0010j\u001a\u00020[H\u0002J\b\u0010k\u001a\u00020(H\u0002J\b\u0010l\u001a\u000209H\u0002J\b\u0010m\u001a\u00020;H\u0002J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u000209J\u0016\u0010n\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ&\u0010o\u001a\u00020\u00002\u0006\u0010d\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010GH\u0007J\u000e\u0010q\u001a\u00020\u00002\u0006\u0010q\u001a\u00020rJ\u000e\u0010q\u001a\u00020\u00002\u0006\u0010s\u001a\u00020;J\u0010\u0010q\u001a\u00020\u00002\b\b\u0001\u0010q\u001a\u00020\u001dJ\u001a\u0010q\u001a\u00020\u00002\b\b\u0001\u0010t\u001a\u00020\u001d2\b\b\u0001\u0010u\u001a\u00020\u001dJ\u0010>\u001a\u00020\u00002%\b\u0006\u0010X\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020[0Y2%\b\u0006\u0010]\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020[0Y2#\b\u0006\u0010a\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bZ\u0012\b\bF\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020[0YH\bø\u0001\u0000J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010w\u001a\u00020xJ\u0010\u0010>\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010?J\u001f\u0010@\u001a\u00020\u00002\u0012\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0y\"\u00020B¢\u0006\u0002\u0010zJ\u0014\u0010@\u001a\u00020\u00002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0010\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u00020DH\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u001eR$\u0010!\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\b\u0012\u0006\u0012\u0002\b\u00030$\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006{"}, d2 = {"Lcoil/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "request", "Lcoil/request/ImageRequest;", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", "allowConversionToBitmap", "", "allowHardware", "Ljava/lang/Boolean;", "allowRgb565", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "data", "decoder", "Lcoil/decode/Decoder;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCachePolicy", "Lcoil/request/CachePolicy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "", "Ljava/lang/Integer;", "fallbackDrawable", "fallbackResId", "fetcher", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "headers", "Lokhttp3/Headers$Builder;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "memoryCachePolicy", "networkCachePolicy", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderDrawable", "placeholderMemoryCacheKey", "placeholderResId", "precision", "Lcoil/size/Precision;", "premultipliedAlpha", "resolvedLifecycle", "resolvedScale", "Lcoil/size/Scale;", "resolvedSizeResolver", "Lcoil/size/SizeResolver;", "scale", "sizeResolver", "target", "Lcoil/target/Target;", "transformations", "", "Lcoil/transform/Transformation;", "transition", "Lcoil/transition/Transition;", "addHeader", "name", "", "value", "enable", "config", "build", "crossfade", "durationMillis", "policy", "error", "drawable", "drawableResId", "fallback", "T", "type", "Lokhttp3/Headers;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "onCancel", "onError", "Lkotlin/Function2;", "", "throwable", "onSuccess", "Lcoil/request/ImageResult$Metadata;", "metadata", "key", "Lcoil/request/Parameters;", "placeholder", "removeHeader", "removeParameter", "resetResolvedScale", "resetResolvedValues", "resolveLifecycle", "resolveScale", "resolveSizeResolver", "setHeader", "setParameter", "cacheKey", "size", "Lcoil/size/Size;", "resolver", "width", "height", "result", "imageView", "Landroid/widget/ImageView;", "", "([Lcoil/transform/Transformation;)Lcoil/request/ImageRequest$Builder;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean allowConversionToBitmap;
        @Nullable
        private Boolean allowHardware;
        @Nullable
        private Boolean allowRgb565;
        @Nullable
        private Bitmap.Config bitmapConfig;
        @Nullable
        private ColorSpace colorSpace;
        @NotNull
        private final Context context;
        @Nullable
        private Object data;
        @Nullable
        private Decoder decoder;
        @NotNull
        private DefaultRequestOptions defaults;
        @Nullable
        private CachePolicy diskCachePolicy;
        @Nullable
        private CoroutineDispatcher dispatcher;
        @Nullable
        private Drawable errorDrawable;
        @Nullable
        @DrawableRes
        private Integer errorResId;
        @Nullable
        private Drawable fallbackDrawable;
        @Nullable
        @DrawableRes
        private Integer fallbackResId;
        @Nullable
        private Pair<? extends Fetcher<?>, ? extends Class<?>> fetcher;
        @Nullable
        private Headers.Builder headers;
        @Nullable
        private Lifecycle lifecycle;
        @Nullable
        private Listener listener;
        @Nullable
        private MemoryCache.Key memoryCacheKey;
        @Nullable
        private CachePolicy memoryCachePolicy;
        @Nullable
        private CachePolicy networkCachePolicy;
        @Nullable
        private Parameters.Builder parameters;
        @Nullable
        private Drawable placeholderDrawable;
        @Nullable
        private MemoryCache.Key placeholderMemoryCacheKey;
        @Nullable
        @DrawableRes
        private Integer placeholderResId;
        @Nullable
        private Precision precision;
        private boolean premultipliedAlpha;
        @Nullable
        private Lifecycle resolvedLifecycle;
        @Nullable
        private Scale resolvedScale;
        @Nullable
        private SizeResolver resolvedSizeResolver;
        @Nullable
        private Scale scale;
        @Nullable
        private SizeResolver sizeResolver;
        @Nullable
        private Target target;
        @NotNull
        private List<? extends Transformation> transformations;
        @Nullable
        private Transition transition;

        public Builder(@NotNull Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
            this.defaults = DefaultRequestOptions.INSTANCE;
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.placeholderMemoryCacheKey = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = null;
            }
            this.fetcher = null;
            this.decoder = null;
            this.transformations = CollectionsKt__CollectionsKt.emptyList();
            this.headers = null;
            this.parameters = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.dispatcher = null;
            this.transition = null;
            this.precision = null;
            this.bitmapConfig = null;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.allowConversionToBitmap = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Builder(@NotNull ImageRequest imageRequest) {
            this(imageRequest, (Context) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(imageRequest, "request");
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                function1 = ImageRequest$Builder$listener$1.INSTANCE;
            }
            if ((i11 & 2) != 0) {
                function12 = ImageRequest$Builder$listener$2.INSTANCE;
            }
            if ((i11 & 4) != 0) {
                function2 = ImageRequest$Builder$listener$3.INSTANCE;
            }
            if ((i11 & 8) != 0) {
                function22 = ImageRequest$Builder$listener$4.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onCancel");
            Intrinsics.checkNotNullParameter(function2, "onError");
            Intrinsics.checkNotNullParameter(function22, "onSuccess");
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Context context2;
            Target target2 = this.target;
            if (target2 instanceof ViewTarget) {
                context2 = ((ViewTarget) target2).getView().getContext();
            } else {
                context2 = this.context;
            }
            Lifecycle lifecycle2 = Contexts.getLifecycle(context2);
            if (lifecycle2 == null) {
                return GlobalLifecycle.INSTANCE;
            }
            return lifecycle2;
        }

        private final Scale resolveScale() {
            SizeResolver sizeResolver2 = this.sizeResolver;
            if (sizeResolver2 instanceof ViewSizeResolver) {
                View view = ((ViewSizeResolver) sizeResolver2).getView();
                if (view instanceof ImageView) {
                    return Extensions.getScale((ImageView) view);
                }
            }
            Target target2 = this.target;
            if (target2 instanceof ViewTarget) {
                View view2 = ((ViewTarget) target2).getView();
                if (view2 instanceof ImageView) {
                    return Extensions.getScale((ImageView) view2);
                }
            }
            return Scale.FILL;
        }

        private final SizeResolver resolveSizeResolver() {
            boolean z11;
            Target target2 = this.target;
            if (!(target2 instanceof ViewTarget)) {
                return new DisplaySizeResolver(this.context);
            }
            View view = ((ViewTarget) target2).getView();
            if (view instanceof ImageView) {
                ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
                if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return SizeResolver.Companion.create(OriginalSize.INSTANCE);
                }
            }
            return ViewSizeResolver.Companion.create$default(ViewSizeResolver.Companion, view, false, 2, (Object) null);
        }

        public static /* synthetic */ Builder setParameter$default(Builder builder, String str, Object obj, String str2, int i11, Object obj2) {
            if ((i11 & 4) != 0) {
                str2 = obj == null ? null : obj.toString();
            }
            return builder.setParameter(str, obj, str2);
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function12, Function1 function13, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                function1 = ImageRequest$Builder$target$1.INSTANCE;
            }
            if ((i11 & 2) != 0) {
                function12 = ImageRequest$Builder$target$2.INSTANCE;
            }
            if ((i11 & 4) != 0) {
                function13 = ImageRequest$Builder$target$3.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onError");
            Intrinsics.checkNotNullParameter(function13, "onSuccess");
            return builder.target((Target) new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        @NotNull
        public final Builder addHeader(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Headers.Builder builder = this.headers;
            if (builder == null) {
                builder = new Headers.Builder();
            }
            this.headers = builder.add(str, str2);
            return this;
        }

        @NotNull
        public final Builder allowConversionToBitmap(boolean z11) {
            this.allowConversionToBitmap = z11;
            return this;
        }

        @NotNull
        public final Builder allowHardware(boolean z11) {
            this.allowHardware = Boolean.valueOf(z11);
            return this;
        }

        @NotNull
        public final Builder allowRgb565(boolean z11) {
            this.allowRgb565 = Boolean.valueOf(z11);
            return this;
        }

        @NotNull
        public final Builder bitmapConfig(@NotNull Bitmap.Config config) {
            Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.bitmapConfig = config;
            return this;
        }

        @NotNull
        public final ImageRequest build() {
            Headers headers2;
            boolean z11;
            boolean z12;
            Context context2 = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target2 = this.target;
            Listener listener2 = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
            ColorSpace colorSpace2 = this.colorSpace;
            Pair<? extends Fetcher<?>, ? extends Class<?>> pair = this.fetcher;
            Decoder decoder2 = this.decoder;
            List<? extends Transformation> list = this.transformations;
            Headers.Builder builder = this.headers;
            Parameters parameters2 = null;
            if (builder == null) {
                headers2 = null;
            } else {
                headers2 = builder.build();
            }
            Headers orEmpty = Extensions.orEmpty(headers2);
            Parameters.Builder builder2 = this.parameters;
            if (builder2 != null) {
                parameters2 = builder2.build();
            }
            Parameters orEmpty2 = Extensions.orEmpty(parameters2);
            Lifecycle lifecycle2 = this.lifecycle;
            if (lifecycle2 == null && (lifecycle2 = this.resolvedLifecycle) == null) {
                lifecycle2 = resolveLifecycle();
            }
            Lifecycle lifecycle3 = lifecycle2;
            SizeResolver sizeResolver2 = this.sizeResolver;
            if (sizeResolver2 == null && (sizeResolver2 = this.resolvedSizeResolver) == null) {
                sizeResolver2 = resolveSizeResolver();
            }
            SizeResolver sizeResolver3 = sizeResolver2;
            Scale scale2 = this.scale;
            if (scale2 == null && (scale2 = this.resolvedScale) == null) {
                scale2 = resolveScale();
            }
            Scale scale3 = scale2;
            CoroutineDispatcher coroutineDispatcher = this.dispatcher;
            if (coroutineDispatcher == null) {
                coroutineDispatcher = this.defaults.getDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            Transition transition2 = this.transition;
            if (transition2 == null) {
                transition2 = this.defaults.getTransition();
            }
            Transition transition3 = transition2;
            Precision precision2 = this.precision;
            if (precision2 == null) {
                precision2 = this.defaults.getPrecision();
            }
            Precision precision3 = precision2;
            Bitmap.Config config = this.bitmapConfig;
            if (config == null) {
                config = this.defaults.getBitmapConfig();
            }
            Bitmap.Config config2 = config;
            boolean z13 = this.allowConversionToBitmap;
            Boolean bool = this.allowHardware;
            if (bool == null) {
                z11 = this.defaults.getAllowHardware();
            } else {
                z11 = bool.booleanValue();
            }
            boolean z14 = z11;
            Boolean bool2 = this.allowRgb565;
            if (bool2 == null) {
                z12 = this.defaults.getAllowRgb565();
            } else {
                z12 = bool2.booleanValue();
            }
            boolean z15 = z12;
            boolean z16 = this.premultipliedAlpha;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            DefinedRequestOptions definedRequestOptions = r35;
            boolean z17 = z13;
            Lifecycle lifecycle4 = lifecycle3;
            Parameters parameters3 = orEmpty2;
            List<? extends Transformation> list2 = list;
            Decoder decoder3 = decoder2;
            Pair<? extends Fetcher<?>, ? extends Class<?>> pair2 = pair;
            ColorSpace colorSpace3 = colorSpace2;
            MemoryCache.Key key3 = key2;
            MemoryCache.Key key4 = key;
            Listener listener3 = listener2;
            DefinedRequestOptions definedRequestOptions2 = new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.dispatcher, this.transition, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy);
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            Intrinsics.checkNotNullExpressionValue(orEmpty, "orEmpty()");
            return new ImageRequest(context2, obj2, target2, listener3, key4, key3, colorSpace3, pair2, decoder3, list2, orEmpty, parameters3, lifecycle4, sizeResolver3, scale3, coroutineDispatcher2, transition3, precision3, config2, z17, z14, z15, z16, cachePolicy2, cachePolicy4, cachePolicy6, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, definedRequestOptions, defaultRequestOptions, (DefaultConstructorMarker) null);
        }

        @RequiresApi(26)
        @NotNull
        public final Builder colorSpace(@NotNull ColorSpace colorSpace2) {
            Intrinsics.checkNotNullParameter(colorSpace2, "colorSpace");
            this.colorSpace = colorSpace2;
            return this;
        }

        @NotNull
        public final Builder crossfade(boolean z11) {
            return crossfade(z11 ? 100 : 0);
        }

        @NotNull
        public final Builder data(@Nullable Object obj) {
            this.data = obj;
            return this;
        }

        @NotNull
        public final Builder decoder(@NotNull Decoder decoder2) {
            Intrinsics.checkNotNullParameter(decoder2, "decoder");
            this.decoder = decoder2;
            return this;
        }

        @NotNull
        public final Builder defaults(@NotNull DefaultRequestOptions defaultRequestOptions) {
            Intrinsics.checkNotNullParameter(defaultRequestOptions, RemoteConfigComponent.DEFAULTS_FILE_NAME);
            this.defaults = defaultRequestOptions;
            resetResolvedScale();
            return this;
        }

        @NotNull
        public final Builder diskCachePolicy(@NotNull CachePolicy cachePolicy) {
            Intrinsics.checkNotNullParameter(cachePolicy, "policy");
            this.diskCachePolicy = cachePolicy;
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull CoroutineDispatcher coroutineDispatcher) {
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
            this.dispatcher = coroutineDispatcher;
            return this;
        }

        @NotNull
        public final Builder error(@DrawableRes int i11) {
            this.errorResId = Integer.valueOf(i11);
            this.errorDrawable = null;
            return this;
        }

        @NotNull
        public final Builder fallback(@DrawableRes int i11) {
            this.fallbackResId = Integer.valueOf(i11);
            this.fallbackDrawable = null;
            return this;
        }

        public final /* synthetic */ <T> Builder fetcher(Fetcher<T> fetcher2) {
            Intrinsics.checkNotNullParameter(fetcher2, "fetcher");
            Intrinsics.reifiedOperationMarker(4, "T");
            return fetcher(fetcher2, Object.class);
        }

        @NotNull
        public final Builder headers(@NotNull Headers headers2) {
            Intrinsics.checkNotNullParameter(headers2, InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
            this.headers = headers2.newBuilder();
            return this;
        }

        @NotNull
        public final Builder lifecycle(@Nullable LifecycleOwner lifecycleOwner) {
            return lifecycle(lifecycleOwner == null ? null : lifecycleOwner.getLifecycle());
        }

        @NotNull
        public final Builder listener(@NotNull Function1<? super ImageRequest, Unit> function1, @NotNull Function1<? super ImageRequest, Unit> function12, @NotNull Function2<? super ImageRequest, ? super Throwable, Unit> function2, @NotNull Function2<? super ImageRequest, ? super ImageResult.Metadata, Unit> function22) {
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onCancel");
            Intrinsics.checkNotNullParameter(function2, "onError");
            Intrinsics.checkNotNullParameter(function22, "onSuccess");
            return listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        @NotNull
        public final Builder memoryCacheKey(@Nullable String str) {
            return memoryCacheKey(str == null ? null : MemoryCache.Key.Companion.create(str));
        }

        @NotNull
        public final Builder memoryCachePolicy(@NotNull CachePolicy cachePolicy) {
            Intrinsics.checkNotNullParameter(cachePolicy, "policy");
            this.memoryCachePolicy = cachePolicy;
            return this;
        }

        @NotNull
        public final Builder networkCachePolicy(@NotNull CachePolicy cachePolicy) {
            Intrinsics.checkNotNullParameter(cachePolicy, "policy");
            this.networkCachePolicy = cachePolicy;
            return this;
        }

        @NotNull
        public final Builder parameters(@NotNull Parameters parameters2) {
            Intrinsics.checkNotNullParameter(parameters2, "parameters");
            this.parameters = parameters2.newBuilder();
            return this;
        }

        @NotNull
        public final Builder placeholder(@DrawableRes int i11) {
            this.placeholderResId = Integer.valueOf(i11);
            this.placeholderDrawable = null;
            return this;
        }

        @NotNull
        public final Builder placeholderMemoryCacheKey(@Nullable String str) {
            return placeholderMemoryCacheKey(str == null ? null : MemoryCache.Key.Companion.create(str));
        }

        @NotNull
        public final Builder precision(@NotNull Precision precision2) {
            Intrinsics.checkNotNullParameter(precision2, "precision");
            this.precision = precision2;
            return this;
        }

        @NotNull
        public final Builder premultipliedAlpha(boolean z11) {
            this.premultipliedAlpha = z11;
            return this;
        }

        @NotNull
        public final Builder removeHeader(@NotNull String str) {
            Headers.Builder builder;
            Intrinsics.checkNotNullParameter(str, "name");
            Headers.Builder builder2 = this.headers;
            if (builder2 == null) {
                builder = null;
            } else {
                builder = builder2.removeAll(str);
            }
            this.headers = builder;
            return this;
        }

        @NotNull
        public final Builder removeParameter(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            Parameters.Builder builder = this.parameters;
            if (builder != null) {
                builder.remove(str);
            }
            return this;
        }

        @NotNull
        public final Builder scale(@NotNull Scale scale2) {
            Intrinsics.checkNotNullParameter(scale2, "scale");
            this.scale = scale2;
            return this;
        }

        @NotNull
        public final Builder setHeader(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Headers.Builder builder = this.headers;
            if (builder == null) {
                builder = new Headers.Builder();
            }
            this.headers = builder.set(str, str2);
            return this;
        }

        @NotNull
        @JvmOverloads
        public final Builder setParameter(@NotNull String str, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(str, "key");
            return setParameter$default(this, str, obj, (String) null, 4, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final Builder setParameter(@NotNull String str, @Nullable Object obj, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Parameters.Builder builder = this.parameters;
            if (builder == null) {
                builder = new Parameters.Builder();
            }
            builder.set(str, obj, str2);
            Unit unit = Unit.INSTANCE;
            this.parameters = builder;
            return this;
        }

        @NotNull
        public final Builder size(@Px int i11) {
            return size(i11, i11);
        }

        @NotNull
        public final Builder target(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            return target((Target) new ImageViewTarget(imageView));
        }

        @NotNull
        public final Builder transformations(@NotNull Transformation... transformationArr) {
            Intrinsics.checkNotNullParameter(transformationArr, "transformations");
            return transformations((List<? extends Transformation>) ArraysKt___ArraysKt.toList((T[]) transformationArr));
        }

        @NotNull
        @ExperimentalCoilApi
        public final Builder transition(@NotNull Transition transition2) {
            Intrinsics.checkNotNullParameter(transition2, "transition");
            this.transition = transition2;
            return this;
        }

        @NotNull
        public final Builder crossfade(int i11) {
            return transition(i11 > 0 ? new CrossfadeTransition(i11, false, 2, (DefaultConstructorMarker) null) : Transition.NONE);
        }

        @NotNull
        @PublishedApi
        public final <T> Builder fetcher(@NotNull Fetcher<T> fetcher2, @NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(fetcher2, "fetcher");
            Intrinsics.checkNotNullParameter(cls, "type");
            this.fetcher = TuplesKt.to(fetcher2, cls);
            return this;
        }

        @NotNull
        public final Builder lifecycle(@Nullable Lifecycle lifecycle2) {
            this.lifecycle = lifecycle2;
            return this;
        }

        @NotNull
        public final Builder listener(@Nullable Listener listener2) {
            this.listener = listener2;
            return this;
        }

        @NotNull
        public final Builder memoryCacheKey(@Nullable MemoryCache.Key key) {
            this.memoryCacheKey = key;
            return this;
        }

        @NotNull
        public final Builder placeholderMemoryCacheKey(@Nullable MemoryCache.Key key) {
            this.placeholderMemoryCacheKey = key;
            return this;
        }

        @NotNull
        public final Builder size(@Px int i11, @Px int i12) {
            return size((Size) new PixelSize(i11, i12));
        }

        @NotNull
        public final Builder target(@NotNull Function1<? super Drawable, Unit> function1, @NotNull Function1<? super Drawable, Unit> function12, @NotNull Function1<? super Drawable, Unit> function13) {
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onError");
            Intrinsics.checkNotNullParameter(function13, "onSuccess");
            return target((Target) new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        @NotNull
        public final Builder transformations(@NotNull List<? extends Transformation> list) {
            Intrinsics.checkNotNullParameter(list, "transformations");
            this.transformations = CollectionsKt___CollectionsKt.toList(list);
            return this;
        }

        @NotNull
        public final Builder error(@Nullable Drawable drawable) {
            this.errorDrawable = drawable;
            this.errorResId = 0;
            return this;
        }

        @NotNull
        public final Builder fallback(@Nullable Drawable drawable) {
            this.fallbackDrawable = drawable;
            this.fallbackResId = 0;
            return this;
        }

        @NotNull
        public final Builder placeholder(@Nullable Drawable drawable) {
            this.placeholderDrawable = drawable;
            this.placeholderResId = 0;
            return this;
        }

        @NotNull
        public final Builder size(@NotNull Size size) {
            Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
            return size(SizeResolver.Companion.create(size));
        }

        @NotNull
        public final Builder target(@Nullable Target target2) {
            this.target = target2;
            resetResolvedValues();
            return this;
        }

        @NotNull
        public final Builder size(@NotNull SizeResolver sizeResolver2) {
            Intrinsics.checkNotNullParameter(sizeResolver2, "resolver");
            this.sizeResolver = sizeResolver2;
            resetResolvedValues();
            return this;
        }

        @JvmOverloads
        public Builder(@NotNull ImageRequest imageRequest, @NotNull Context context2) {
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = imageRequest.getColorSpace();
            }
            this.fetcher = imageRequest.getFetcher();
            this.decoder = imageRequest.getDecoder();
            this.transformations = imageRequest.getTransformations();
            this.headers = imageRequest.getHeaders().newBuilder();
            this.parameters = imageRequest.getParameters().newBuilder();
            this.lifecycle = imageRequest.getDefined().getLifecycle();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            this.dispatcher = imageRequest.getDefined().getDispatcher();
            this.transition = imageRequest.getDefined().getTransition();
            this.precision = imageRequest.getDefined().getPrecision();
            this.bitmapConfig = imageRequest.getDefined().getBitmapConfig();
            this.allowHardware = imageRequest.getDefined().getAllowHardware();
            this.allowRgb565 = imageRequest.getDefined().getAllowRgb565();
            this.premultipliedAlpha = imageRequest.getPremultipliedAlpha();
            this.allowConversionToBitmap = imageRequest.getAllowConversionToBitmap();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.placeholderResId = imageRequest.placeholderResId;
            this.placeholderDrawable = imageRequest.placeholderDrawable;
            this.errorResId = imageRequest.errorResId;
            this.errorDrawable = imageRequest.errorDrawable;
            this.fallbackResId = imageRequest.fallbackResId;
            this.fallbackDrawable = imageRequest.fallbackDrawable;
            if (imageRequest.getContext() == context2) {
                this.resolvedLifecycle = imageRequest.getLifecycle();
                this.resolvedSizeResolver = imageRequest.getSizeResolver();
                this.resolvedScale = imageRequest.getScale();
                return;
            }
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ImageRequest imageRequest, Context context2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i11 & 2) != 0 ? imageRequest.getContext() : context2);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0017¨\u0006\r"}, d2 = {"Lcoil/request/ImageRequest$Listener;", "", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Listener {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public static final class DefaultImpls {
            @MainThread
            public static void onCancel(@NotNull Listener listener, @NotNull ImageRequest imageRequest) {
                Intrinsics.checkNotNullParameter(listener, "this");
                Intrinsics.checkNotNullParameter(imageRequest, "request");
            }

            @MainThread
            public static void onError(@NotNull Listener listener, @NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(listener, "this");
                Intrinsics.checkNotNullParameter(imageRequest, "request");
                Intrinsics.checkNotNullParameter(th2, "throwable");
            }

            @MainThread
            public static void onStart(@NotNull Listener listener, @NotNull ImageRequest imageRequest) {
                Intrinsics.checkNotNullParameter(listener, "this");
                Intrinsics.checkNotNullParameter(imageRequest, "request");
            }

            @MainThread
            public static void onSuccess(@NotNull Listener listener, @NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata) {
                Intrinsics.checkNotNullParameter(listener, "this");
                Intrinsics.checkNotNullParameter(imageRequest, "request");
                Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
            }
        }

        @MainThread
        void onCancel(@NotNull ImageRequest imageRequest);

        @MainThread
        void onError(@NotNull ImageRequest imageRequest, @NotNull Throwable th2);

        @MainThread
        void onStart(@NotNull ImageRequest imageRequest);

        @MainThread
        void onSuccess(@NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata);
    }

    private ImageRequest(Context context2, Object obj, Target target2, Listener listener2, MemoryCache.Key key, MemoryCache.Key key2, ColorSpace colorSpace2, Pair<? extends Fetcher<?>, ? extends Class<?>> pair, Decoder decoder2, List<? extends Transformation> list, Headers headers2, Parameters parameters2, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, boolean z11, boolean z12, boolean z13, boolean z14, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context2;
        this.data = obj;
        this.target = target2;
        this.listener = listener2;
        this.memoryCacheKey = key;
        this.placeholderMemoryCacheKey = key2;
        this.colorSpace = colorSpace2;
        this.fetcher = pair;
        this.decoder = decoder2;
        this.transformations = list;
        this.headers = headers2;
        this.parameters = parameters2;
        this.lifecycle = lifecycle2;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.dispatcher = coroutineDispatcher;
        this.transition = transition2;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowConversionToBitmap = z11;
        this.allowHardware = z12;
        this.allowRgb565 = z13;
        this.premultipliedAlpha = z14;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public /* synthetic */ ImageRequest(Context context2, Object obj, Target target2, Listener listener2, MemoryCache.Key key, MemoryCache.Key key2, ColorSpace colorSpace2, Pair pair, Decoder decoder2, List list, Headers headers2, Parameters parameters2, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, boolean z11, boolean z12, boolean z13, boolean z14, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, target2, listener2, key, key2, colorSpace2, pair, decoder2, list, headers2, parameters2, lifecycle2, sizeResolver2, scale2, coroutineDispatcher, transition2, precision2, config, z11, z12, z13, z14, cachePolicy, cachePolicy2, cachePolicy3, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            context2 = imageRequest.context;
        }
        return imageRequest.newBuilder(context2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (!Intrinsics.areEqual((Object) this.context, (Object) imageRequest.context) || !Intrinsics.areEqual(this.data, imageRequest.data) || !Intrinsics.areEqual((Object) this.target, (Object) imageRequest.target) || !Intrinsics.areEqual((Object) this.listener, (Object) imageRequest.listener) || !Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) imageRequest.memoryCacheKey) || !Intrinsics.areEqual((Object) this.placeholderMemoryCacheKey, (Object) imageRequest.placeholderMemoryCacheKey) || ((Build.VERSION.SDK_INT >= 26 && !Intrinsics.areEqual((Object) this.colorSpace, (Object) imageRequest.colorSpace)) || !Intrinsics.areEqual((Object) this.fetcher, (Object) imageRequest.fetcher) || !Intrinsics.areEqual((Object) this.decoder, (Object) imageRequest.decoder) || !Intrinsics.areEqual((Object) this.transformations, (Object) imageRequest.transformations) || !Intrinsics.areEqual((Object) this.headers, (Object) imageRequest.headers) || !Intrinsics.areEqual((Object) this.parameters, (Object) imageRequest.parameters) || !Intrinsics.areEqual((Object) this.lifecycle, (Object) imageRequest.lifecycle) || !Intrinsics.areEqual((Object) this.sizeResolver, (Object) imageRequest.sizeResolver) || this.scale != imageRequest.scale || !Intrinsics.areEqual((Object) this.dispatcher, (Object) imageRequest.dispatcher) || !Intrinsics.areEqual((Object) this.transition, (Object) imageRequest.transition) || this.precision != imageRequest.precision || this.bitmapConfig != imageRequest.bitmapConfig || this.allowConversionToBitmap != imageRequest.allowConversionToBitmap || this.allowHardware != imageRequest.allowHardware || this.allowRgb565 != imageRequest.allowRgb565 || this.premultipliedAlpha != imageRequest.premultipliedAlpha || this.memoryCachePolicy != imageRequest.memoryCachePolicy || this.diskCachePolicy != imageRequest.diskCachePolicy || this.networkCachePolicy != imageRequest.networkCachePolicy || !Intrinsics.areEqual((Object) this.placeholderResId, (Object) imageRequest.placeholderResId) || !Intrinsics.areEqual((Object) this.placeholderDrawable, (Object) imageRequest.placeholderDrawable) || !Intrinsics.areEqual((Object) this.errorResId, (Object) imageRequest.errorResId) || !Intrinsics.areEqual((Object) this.errorDrawable, (Object) imageRequest.errorDrawable) || !Intrinsics.areEqual((Object) this.fallbackResId, (Object) imageRequest.fallbackResId) || !Intrinsics.areEqual((Object) this.fallbackDrawable, (Object) imageRequest.fallbackDrawable) || !Intrinsics.areEqual((Object) this.defined, (Object) imageRequest.defined) || !Intrinsics.areEqual((Object) this.defaults, (Object) imageRequest.defaults))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    @NotNull
    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    @Nullable
    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final Decoder getDecoder() {
        return this.decoder;
    }

    @NotNull
    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    @NotNull
    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    @NotNull
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    @NotNull
    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Nullable
    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    @Nullable
    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    @Nullable
    public final Pair<Fetcher<?>, Class<?>> getFetcher() {
        return this.fetcher;
    }

    @NotNull
    public final Headers getHeaders() {
        return this.headers;
    }

    @NotNull
    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    @Nullable
    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    @NotNull
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    @NotNull
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    @NotNull
    public final Parameters getParameters() {
        return this.parameters;
    }

    @Nullable
    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    @Nullable
    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    @NotNull
    public final Precision getPrecision() {
        return this.precision;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    @NotNull
    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    @Nullable
    public final Target getTarget() {
        return this.target;
    }

    @NotNull
    public final List<Transformation> getTransformations() {
        return this.transformations;
    }

    @NotNull
    public final Transition getTransition() {
        return this.transition;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int hashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target2 = this.target;
        int i24 = 0;
        if (target2 == null) {
            i11 = 0;
        } else {
            i11 = target2.hashCode();
        }
        int i25 = (hashCode + i11) * 31;
        Listener listener2 = this.listener;
        if (listener2 == null) {
            i12 = 0;
        } else {
            i12 = listener2.hashCode();
        }
        int i26 = (i25 + i12) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        if (key == null) {
            i13 = 0;
        } else {
            i13 = key.hashCode();
        }
        int i27 = (i26 + i13) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        if (key2 == null) {
            i14 = 0;
        } else {
            i14 = key2.hashCode();
        }
        int i28 = (i27 + i14) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        if (colorSpace2 == null) {
            i15 = 0;
        } else {
            i15 = colorSpace2.hashCode();
        }
        int i29 = (i28 + i15) * 31;
        Pair<Fetcher<?>, Class<?>> pair = this.fetcher;
        if (pair == null) {
            i16 = 0;
        } else {
            i16 = pair.hashCode();
        }
        int i31 = (i29 + i16) * 31;
        Decoder decoder2 = this.decoder;
        if (decoder2 == null) {
            i17 = 0;
        } else {
            i17 = decoder2.hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((i31 + i17) * 31) + this.transformations.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.dispatcher.hashCode()) * 31) + this.transition.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.bitmapConfig.hashCode()) * 31) + e.a(this.allowConversionToBitmap)) * 31) + e.a(this.allowHardware)) * 31) + e.a(this.allowRgb565)) * 31) + e.a(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31;
        Integer num = this.placeholderResId;
        if (num == null) {
            i18 = 0;
        } else {
            i18 = num.intValue();
        }
        int i32 = (hashCode2 + i18) * 31;
        Drawable drawable = this.placeholderDrawable;
        if (drawable == null) {
            i19 = 0;
        } else {
            i19 = drawable.hashCode();
        }
        int i33 = (i32 + i19) * 31;
        Integer num2 = this.errorResId;
        if (num2 == null) {
            i21 = 0;
        } else {
            i21 = num2.intValue();
        }
        int i34 = (i33 + i21) * 31;
        Drawable drawable2 = this.errorDrawable;
        if (drawable2 == null) {
            i22 = 0;
        } else {
            i22 = drawable2.hashCode();
        }
        int i35 = (i34 + i22) * 31;
        Integer num3 = this.fallbackResId;
        if (num3 == null) {
            i23 = 0;
        } else {
            i23 = num3.intValue();
        }
        int i36 = (i35 + i23) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        if (drawable3 != null) {
            i24 = drawable3.hashCode();
        }
        return ((((i36 + i24) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    @NotNull
    @JvmOverloads
    public final Builder newBuilder() {
        return newBuilder$default(this, (Context) null, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final Builder newBuilder(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        return new Builder(this, context2);
    }

    @NotNull
    public String toString() {
        return "ImageRequest(context=" + this.context + ", data=" + this.data + ", target=" + this.target + ", listener=" + this.listener + ", memoryCacheKey=" + this.memoryCacheKey + ", placeholderMemoryCacheKey=" + this.placeholderMemoryCacheKey + ", colorSpace=" + this.colorSpace + ", fetcher=" + this.fetcher + ", decoder=" + this.decoder + ", transformations=" + this.transformations + ", headers=" + this.headers + ", parameters=" + this.parameters + ", lifecycle=" + this.lifecycle + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", dispatcher=" + this.dispatcher + ", transition=" + this.transition + ", precision=" + this.precision + ", bitmapConfig=" + this.bitmapConfig + ", allowConversionToBitmap=" + this.allowConversionToBitmap + ", allowHardware=" + this.allowHardware + ", allowRgb565=" + this.allowRgb565 + ", premultipliedAlpha=" + this.premultipliedAlpha + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", placeholderResId=" + this.placeholderResId + ", placeholderDrawable=" + this.placeholderDrawable + ", errorResId=" + this.errorResId + ", errorDrawable=" + this.errorDrawable + ", fallbackResId=" + this.fallbackResId + ", fallbackDrawable=" + this.fallbackDrawable + ", defined=" + this.defined + ", defaults=" + this.defaults + ')';
    }
}
