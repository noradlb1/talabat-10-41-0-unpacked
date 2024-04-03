package coil.intercept;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.bitmap.BitmapPool;
import coil.bitmap.BitmapReferenceCounter;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.decode.DrawableDecoderService;
import coil.decode.Options;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.memory.RealMemoryCache;
import coil.memory.RequestService;
import coil.memory.StrongMemoryCache;
import coil.request.ImageRequest;
import coil.request.Parameters;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Extensions;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SystemCallbacks;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001ABO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J;\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHHø\u0001\u0000¢\u0006\u0004\b \u0010!J5\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b(JG\u0010)\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fHHø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020%H\u0002J/\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b9J*\u0010:\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020=H\u0002J*\u0010>\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010?\u001a\u0004\u0018\u00010#2\u0006\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "registry", "Lcoil/ComponentRegistry;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "requestService", "Lcoil/memory/RequestService;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ComponentRegistry;Lcoil/bitmap/BitmapPool;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/memory/StrongMemoryCache;Lcoil/memory/MemoryCacheService;Lcoil/memory/RequestService;Lcoil/util/SystemCallbacks;Lcoil/decode/DrawableDecoderService;Lcoil/util/Logger;)V", "applyTransformations", "Lcoil/fetch/DrawableResult;", "result", "request", "Lcoil/request/ImageRequest;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "eventListener", "Lcoil/EventListener;", "applyTransformations$coil_base_release", "(Lcoil/fetch/DrawableResult;Lcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/decode/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeMemoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "data", "", "fetcher", "Lcoil/fetch/Fetcher;", "computeMemoryCacheKey$coil_base_release", "execute", "type", "", "(Ljava/lang/Object;Lcoil/fetch/Fetcher;Lcoil/request/ImageRequest;ILcoil/size/Size;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateData", "", "isCachedValueValid", "", "cacheKey", "cacheValue", "Lcoil/memory/RealMemoryCache$Value;", "isCachedValueValid$coil_base_release", "isSizeValid", "validateDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "writeToMemoryCache", "key", "isSampled", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EngineInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "EngineInterceptor";
    /* access modifiers changed from: private */
    @NotNull
    public final BitmapPool bitmapPool;
    /* access modifiers changed from: private */
    @NotNull
    public final DrawableDecoderService drawableDecoder;
    /* access modifiers changed from: private */
    @Nullable
    public final Logger logger;
    @NotNull
    private final MemoryCacheService memoryCacheService;
    /* access modifiers changed from: private */
    @NotNull
    public final BitmapReferenceCounter referenceCounter;
    /* access modifiers changed from: private */
    @NotNull
    public final ComponentRegistry registry;
    /* access modifiers changed from: private */
    @NotNull
    public final RequestService requestService;
    @NotNull
    private final StrongMemoryCache strongMemoryCache;
    /* access modifiers changed from: private */
    @NotNull
    public final SystemCallbacks systemCallbacks;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/intercept/EngineInterceptor$Companion;", "", "()V", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EngineInterceptor(@NotNull ComponentRegistry componentRegistry, @NotNull BitmapPool bitmapPool2, @NotNull BitmapReferenceCounter bitmapReferenceCounter, @NotNull StrongMemoryCache strongMemoryCache2, @NotNull MemoryCacheService memoryCacheService2, @NotNull RequestService requestService2, @NotNull SystemCallbacks systemCallbacks2, @NotNull DrawableDecoderService drawableDecoderService, @Nullable Logger logger2) {
        Intrinsics.checkNotNullParameter(componentRegistry, "registry");
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(strongMemoryCache2, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(memoryCacheService2, "memoryCacheService");
        Intrinsics.checkNotNullParameter(requestService2, "requestService");
        Intrinsics.checkNotNullParameter(systemCallbacks2, "systemCallbacks");
        Intrinsics.checkNotNullParameter(drawableDecoderService, "drawableDecoder");
        this.registry = componentRegistry;
        this.bitmapPool = bitmapPool2;
        this.referenceCounter = bitmapReferenceCounter;
        this.strongMemoryCache = strongMemoryCache2;
        this.memoryCacheService = memoryCacheService2;
        this.requestService = requestService2;
        this.systemCallbacks = systemCallbacks2;
        this.drawableDecoder = drawableDecoderService;
        this.logger = logger2;
    }

    @VisibleForTesting
    private final Object applyTransformations$coil_base_release$$forInline(DrawableResult drawableResult, ImageRequest imageRequest, Size size, Options options, EventListener eventListener, Continuation<? super DrawableResult> continuation) {
        Bitmap bitmap;
        ImageRequest imageRequest2 = imageRequest;
        EventListener eventListener2 = eventListener;
        List<Transformation> transformations = imageRequest.getTransformations();
        if (transformations.isEmpty()) {
            return drawableResult;
        }
        if (drawableResult.getDrawable() instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawableResult.getDrawable()).getBitmap();
            Bitmap.Config[] configArr = RequestService.VALID_TRANSFORMATION_CONFIGS;
            Intrinsics.checkNotNullExpressionValue(bitmap, "resultBitmap");
            if (!ArraysKt___ArraysKt.contains((T[]) configArr, Bitmaps.getSafeConfig(bitmap))) {
                Logger access$getLogger$p = this.logger;
                if (access$getLogger$p != null && access$getLogger$p.getLevel() <= 4) {
                    access$getLogger$p.log(TAG, 4, "Converting bitmap with config " + Bitmaps.getSafeConfig(bitmap) + " to apply transformations: " + transformations, (Throwable) null);
                }
                bitmap = this.drawableDecoder.convert(drawableResult.getDrawable(), options.getConfig(), size, options.getScale(), options.getAllowInexactSize());
            }
        } else if (imageRequest.getAllowConversionToBitmap()) {
            Logger access$getLogger$p2 = this.logger;
            if (access$getLogger$p2 != null && access$getLogger$p2.getLevel() <= 4) {
                access$getLogger$p2.log(TAG, 4, "Converting drawable of type " + drawableResult.getDrawable().getClass().getCanonicalName() + " to apply transformations: " + transformations, (Throwable) null);
            }
            bitmap = this.drawableDecoder.convert(drawableResult.getDrawable(), options.getConfig(), size, options.getScale(), options.getAllowInexactSize());
        } else {
            Logger access$getLogger$p3 = this.logger;
            if (access$getLogger$p3 != null && access$getLogger$p3.getLevel() <= 4) {
                access$getLogger$p3.log(TAG, 4, Intrinsics.stringPlus("allowConversionToBitmap=false, skipping transformations for type ", drawableResult.getDrawable().getClass().getCanonicalName()), (Throwable) null);
            }
            return drawableResult;
        }
        Intrinsics.checkNotNullExpressionValue(bitmap, "input");
        eventListener2.transformStart(imageRequest2, bitmap);
        if (transformations.size() - 1 < 0) {
            Intrinsics.checkNotNullExpressionValue(bitmap, "output");
            eventListener2.transformEnd(imageRequest2, bitmap);
            Resources resources = imageRequest.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            return DrawableResult.copy$default(drawableResult, new BitmapDrawable(resources, bitmap), false, (DataSource) null, 6, (Object) null);
        }
        BitmapPool access$getBitmapPool$p = this.bitmapPool;
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        InlineMarker.mark(3);
        InlineMarker.mark(0);
        Object transform = transformations.get(0).transform(access$getBitmapPool$p, bitmap, size, (Continuation<? super Bitmap>) null);
        InlineMarker.mark(1);
        Bitmap bitmap2 = (Bitmap) transform;
        InlineMarker.mark(3);
        throw null;
    }

    private final Object execute(Object obj, Fetcher<Object> fetcher, ImageRequest imageRequest, int i11, Size size, EventListener eventListener, Continuation<? super DrawableResult> continuation) {
        Options options = this.requestService.options(imageRequest, size, this.systemCallbacks.isOnline());
        eventListener.fetchStart(imageRequest, fetcher, options);
        BitmapPool access$getBitmapPool$p = this.bitmapPool;
        InlineMarker.mark(0);
        Object fetch = fetcher.fetch(access$getBitmapPool$p, obj, size, options, continuation);
        InlineMarker.mark(1);
        FetchResult fetchResult = (FetchResult) fetch;
        eventListener.fetchEnd(imageRequest, fetcher, options, fetchResult);
        if (fetchResult instanceof SourceResult) {
            try {
                InlineMarker.mark(3);
                throw null;
            } catch (Throwable th2) {
                Extensions.closeQuietly(((SourceResult) fetchResult).getSource());
                throw th2;
            }
        } else if (fetchResult instanceof DrawableResult) {
            DrawableResult drawableResult = (DrawableResult) fetchResult;
            InlineMarker.mark(3);
            throw null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void invalidateData(Object obj) {
        if (obj instanceof BitmapDrawable) {
            BitmapReferenceCounter bitmapReferenceCounter = this.referenceCounter;
            Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
            if (bitmap != null) {
                bitmapReferenceCounter.setValid(bitmap, false);
            }
        } else if (obj instanceof Bitmap) {
            this.referenceCounter.setValid((Bitmap) obj, false);
        }
    }

    private final boolean isSizeValid(MemoryCache.Key key, RealMemoryCache.Value value, ImageRequest imageRequest, Size size) {
        MemoryCache.Key.Complex complex;
        Size size2;
        int i11;
        int i12;
        String str;
        boolean z11;
        boolean z12;
        MemoryCache.Key key2 = key;
        Size size3 = size;
        if (size3 instanceof OriginalSize) {
            if (!value.isSampled()) {
                return true;
            }
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 3) {
                logger2.log(TAG, 3, imageRequest.getData() + ": Requested original size, but cached image is sampled.", (Throwable) null);
            }
            return false;
        } else if (!(size3 instanceof PixelSize)) {
            return true;
        } else {
            if (key2 instanceof MemoryCache.Key.Complex) {
                complex = (MemoryCache.Key.Complex) key2;
            } else {
                complex = null;
            }
            if (complex == null) {
                size2 = null;
            } else {
                size2 = complex.getSize();
            }
            if (size2 instanceof PixelSize) {
                PixelSize pixelSize = (PixelSize) size2;
                i11 = pixelSize.getWidth();
                i12 = pixelSize.getHeight();
            } else {
                if (!Intrinsics.areEqual((Object) size2, (Object) OriginalSize.INSTANCE) && size2 != null) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    Bitmap bitmap = value.getBitmap();
                    i11 = bitmap.getWidth();
                    i12 = bitmap.getHeight();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            PixelSize pixelSize2 = (PixelSize) size3;
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i11, i12, pixelSize2.getWidth(), pixelSize2.getHeight(), imageRequest.getScale());
            boolean allowInexactSize = Requests.getAllowInexactSize(imageRequest);
            if (allowInexactSize) {
                double coerceAtMost = RangesKt___RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
                int width = pixelSize2.getWidth();
                str = TAG;
                if (Math.abs(((double) width) - (((double) i11) * coerceAtMost)) <= 1.0d || Math.abs(((double) pixelSize2.getHeight()) - (coerceAtMost * ((double) i12))) <= 1.0d) {
                    return true;
                }
            } else {
                str = TAG;
                if (Math.abs(pixelSize2.getWidth() - i11) <= 1 && Math.abs(pixelSize2.getHeight() - i12) <= 1) {
                    return true;
                }
            }
            if (computeSizeMultiplier == 1.0d) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 || allowInexactSize) {
                String str2 = str;
                if (computeSizeMultiplier <= 1.0d || !value.isSampled()) {
                    return true;
                }
                Logger logger3 = this.logger;
                if (logger3 == null || logger3.getLevel() > 3) {
                    return false;
                }
                logger3.log(str2, 3, imageRequest.getData() + ": Cached image's request size (" + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12 + ") is smaller than the requested size (" + pixelSize2.getWidth() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + pixelSize2.getHeight() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + imageRequest.getScale() + ").", (Throwable) null);
                return false;
            }
            Logger logger4 = this.logger;
            if (logger4 == null || logger4.getLevel() > 3) {
                return false;
            }
            logger4.log(str, 3, imageRequest.getData() + ": Cached image's request size (" + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12 + ") does not exactly match the requested size (" + pixelSize2.getWidth() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + pixelSize2.getHeight() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + imageRequest.getScale() + ").", (Throwable) null);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void validateDrawable(Drawable drawable) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) drawable;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        if (bitmap != null) {
            this.referenceCounter.setValid(bitmap, true);
            this.referenceCounter.increment(bitmap);
        }
    }

    /* access modifiers changed from: private */
    public final boolean writeToMemoryCache(ImageRequest imageRequest, MemoryCache.Key key, Drawable drawable, boolean z11) {
        BitmapDrawable bitmapDrawable;
        if (imageRequest.getMemoryCachePolicy().getWriteEnabled() && key != null) {
            Bitmap bitmap = null;
            if (drawable instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) drawable;
            } else {
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null) {
                bitmap = bitmapDrawable.getBitmap();
            }
            if (bitmap != null) {
                this.strongMemoryCache.set(key, bitmap, z11);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object applyTransformations$coil_base_release(@org.jetbrains.annotations.NotNull coil.fetch.DrawableResult r19, @org.jetbrains.annotations.NotNull coil.request.ImageRequest r20, @org.jetbrains.annotations.NotNull coil.size.Size r21, @org.jetbrains.annotations.NotNull coil.decode.Options r22, @org.jetbrains.annotations.NotNull coil.EventListener r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil.fetch.DrawableResult> r24) {
        /*
            r18 = this;
            r0 = r24
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$applyTransformations$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            coil.intercept.EngineInterceptor$applyTransformations$1 r1 = (coil.intercept.EngineInterceptor$applyTransformations$1) r1
            int r2 = r1.f39728r
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f39728r = r2
            r2 = r18
            goto L_0x001e
        L_0x0017:
            coil.intercept.EngineInterceptor$applyTransformations$1 r1 = new coil.intercept.EngineInterceptor$applyTransformations$1
            r2 = r18
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.f39726p
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.f39728r
            r5 = 1
            if (r4 == 0) goto L_0x005f
            if (r4 != r5) goto L_0x0057
            int r4 = r1.f39725o
            int r6 = r1.f39724n
            java.lang.Object r7 = r1.f39723m
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.f39722l
            coil.EventListener r8 = (coil.EventListener) r8
            java.lang.Object r9 = r1.f39721k
            coil.size.Size r9 = (coil.size.Size) r9
            java.lang.Object r10 = r1.f39720j
            coil.request.ImageRequest r10 = (coil.request.ImageRequest) r10
            java.lang.Object r11 = r1.f39719i
            coil.fetch.DrawableResult r11 = (coil.fetch.DrawableResult) r11
            java.lang.Object r12 = r1.f39718h
            coil.intercept.EngineInterceptor r12 = (coil.intercept.EngineInterceptor) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r13 = r6
            r6 = r10
            r10 = r7
            r7 = r8
            r17 = r3
            r3 = r1
            r1 = r9
            r9 = r4
            r4 = r17
            goto L_0x017d
        L_0x0057:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.List r0 = r20.getTransformations()
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x006d
            return r19
        L_0x006d:
            android.graphics.drawable.Drawable r4 = r19.getDrawable()
            boolean r4 = r4 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r6 = " to apply transformations: "
            r7 = 0
            r8 = 4
            java.lang.String r9 = "EngineInterceptor"
            if (r4 == 0) goto L_0x00de
            android.graphics.drawable.Drawable r4 = r19.getDrawable()
            android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
            android.graphics.Bitmap r4 = r4.getBitmap()
            android.graphics.Bitmap$Config[] r10 = coil.memory.RequestService.VALID_TRANSFORMATION_CONFIGS
            java.lang.String r11 = "resultBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            android.graphics.Bitmap$Config r11 = coil.util.Bitmaps.getSafeConfig(r4)
            boolean r10 = kotlin.collections.ArraysKt___ArraysKt.contains((T[]) r10, r11)
            if (r10 == 0) goto L_0x0098
            goto L_0x0131
        L_0x0098:
            coil.util.Logger r10 = r18.logger
            if (r10 != 0) goto L_0x009f
            goto L_0x00c3
        L_0x009f:
            int r11 = r10.getLevel()
            if (r11 > r8) goto L_0x00c3
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Converting bitmap with config "
            r11.append(r12)
            android.graphics.Bitmap$Config r4 = coil.util.Bitmaps.getSafeConfig(r4)
            r11.append(r4)
            r11.append(r6)
            r11.append(r0)
            java.lang.String r4 = r11.toString()
            r10.log(r9, r8, r4, r7)
        L_0x00c3:
            coil.decode.DrawableDecoderService r11 = r18.drawableDecoder
            android.graphics.drawable.Drawable r12 = r19.getDrawable()
            android.graphics.Bitmap$Config r13 = r22.getConfig()
            coil.size.Scale r15 = r22.getScale()
            boolean r16 = r22.getAllowInexactSize()
            r14 = r21
            android.graphics.Bitmap r4 = r11.convert(r12, r13, r14, r15, r16)
            goto L_0x0131
        L_0x00de:
            boolean r4 = r20.getAllowConversionToBitmap()
            if (r4 == 0) goto L_0x01bf
            coil.util.Logger r4 = r18.logger
            if (r4 != 0) goto L_0x00eb
            goto L_0x0117
        L_0x00eb:
            int r10 = r4.getLevel()
            if (r10 > r8) goto L_0x0117
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Converting drawable of type "
            r10.append(r11)
            android.graphics.drawable.Drawable r11 = r19.getDrawable()
            java.lang.Class r11 = r11.getClass()
            java.lang.String r11 = r11.getCanonicalName()
            r10.append(r11)
            r10.append(r6)
            r10.append(r0)
            java.lang.String r6 = r10.toString()
            r4.log(r9, r8, r6, r7)
        L_0x0117:
            coil.decode.DrawableDecoderService r10 = r18.drawableDecoder
            android.graphics.drawable.Drawable r11 = r19.getDrawable()
            android.graphics.Bitmap$Config r12 = r22.getConfig()
            coil.size.Scale r14 = r22.getScale()
            boolean r15 = r22.getAllowInexactSize()
            r13 = r21
            android.graphics.Bitmap r4 = r10.convert(r11, r12, r13, r14, r15)
        L_0x0131:
            java.lang.String r6 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r6 = r20
            r7 = r23
            r7.transformStart(r6, r4)
            int r8 = r0.size()
            int r8 = r8 + -1
            if (r8 < 0) goto L_0x018e
            r9 = 0
            r10 = r0
            r12 = r2
            r11 = r9
            r0 = r19
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r21
        L_0x0151:
            int r13 = r11 + 1
            java.lang.Object r11 = r10.get(r11)
            coil.transform.Transformation r11 = (coil.transform.Transformation) r11
            coil.bitmap.BitmapPool r14 = r12.bitmapPool
            java.lang.String r15 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r15)
            r3.f39718h = r12
            r3.f39719i = r0
            r3.f39720j = r6
            r3.f39721k = r1
            r3.f39722l = r7
            r3.f39723m = r10
            r3.f39724n = r13
            r3.f39725o = r9
            r3.f39728r = r5
            java.lang.Object r8 = r11.transform(r14, r8, r1, r3)
            if (r8 != r4) goto L_0x017b
            return r4
        L_0x017b:
            r11 = r0
            r0 = r8
        L_0x017d:
            r8 = r0
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            kotlin.coroutines.CoroutineContext r0 = r3.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r0)
            if (r13 <= r9) goto L_0x018b
            r4 = r8
            goto L_0x0190
        L_0x018b:
            r0 = r11
            r11 = r13
            goto L_0x0151
        L_0x018e:
            r11 = r19
        L_0x0190:
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r7.transformEnd(r6, r4)
            android.content.Context r0 = r6.getContext()
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r1 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            r1.<init>(r0, r4)
            r0 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r19 = r11
            r20 = r1
            r21 = r0
            r22 = r3
            r23 = r4
            r24 = r5
            coil.fetch.DrawableResult r0 = coil.fetch.DrawableResult.copy$default(r19, r20, r21, r22, r23, r24)
            return r0
        L_0x01bf:
            coil.util.Logger r0 = r18.logger
            if (r0 != 0) goto L_0x01c6
            goto L_0x01e1
        L_0x01c6:
            int r1 = r0.getLevel()
            if (r1 > r8) goto L_0x01e1
            android.graphics.drawable.Drawable r1 = r19.getDrawable()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r3 = "allowConversionToBitmap=false, skipping transformations for type "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            r0.log(r9, r8, r1, r7)
        L_0x01e1:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.applyTransformations$coil_base_release(coil.fetch.DrawableResult, coil.request.ImageRequest, coil.size.Size, coil.decode.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @VisibleForTesting
    @Nullable
    public final MemoryCache.Key computeMemoryCacheKey$coil_base_release(@NotNull ImageRequest imageRequest, @NotNull Object obj, @NotNull Fetcher<Object> fetcher, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        String key = fetcher.key(obj);
        if (key == null) {
            return null;
        }
        if (imageRequest.getTransformations().isEmpty()) {
            MemoryCache.Key.Companion companion = MemoryCache.Key.Companion;
            return new MemoryCache.Key.Complex(key, CollectionsKt__CollectionsKt.emptyList(), (Size) null, imageRequest.getParameters().cacheKeys());
        }
        MemoryCache.Key.Companion companion2 = MemoryCache.Key.Companion;
        List<Transformation> transformations = imageRequest.getTransformations();
        Parameters parameters = imageRequest.getParameters();
        ArrayList arrayList = new ArrayList(transformations.size());
        int size2 = transformations.size() - 1;
        if (size2 >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                arrayList.add(transformations.get(i11).key());
                if (i12 > size2) {
                    break;
                }
                i11 = i12;
            }
        }
        return new MemoryCache.Key.Complex(key, arrayList, size, parameters.cacheKeys());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: coil.intercept.EngineInterceptor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object intercept(@org.jetbrains.annotations.NotNull coil.intercept.Interceptor.Chain r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil.request.ImageResult> r21) {
        /*
            r19 = this;
            r12 = r19
            r13 = r20
            r0 = r21
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$intercept$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            coil.intercept.EngineInterceptor$intercept$1 r1 = (coil.intercept.EngineInterceptor$intercept$1) r1
            int r2 = r1.f39733l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0019
            int r2 = r2 - r3
            r1.f39733l = r2
            goto L_0x001e
        L_0x0019:
            coil.intercept.EngineInterceptor$intercept$1 r1 = new coil.intercept.EngineInterceptor$intercept$1
            r1.<init>(r12, r0)
        L_0x001e:
            r0 = r1
            java.lang.Object r1 = r0.f39731j
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39733l
            r15 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r15) goto L_0x003e
            java.lang.Object r2 = r0.f39730i
            coil.intercept.Interceptor$Chain r2 = (coil.intercept.Interceptor.Chain) r2
            java.lang.Object r0 = r0.f39729h
            r3 = r0
            coil.intercept.EngineInterceptor r3 = (coil.intercept.EngineInterceptor) r3
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x003a }
            goto L_0x00f8
        L_0x003a:
            r0 = move-exception
            r13 = r2
            goto L_0x0107
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r1)
            boolean r1 = r13 instanceof coil.intercept.RealInterceptorChain     // Catch:{ all -> 0x0105 }
            if (r1 == 0) goto L_0x00f9
            coil.request.ImageRequest r3 = r20.getRequest()     // Catch:{ all -> 0x0105 }
            android.content.Context r1 = r3.getContext()     // Catch:{ all -> 0x0105 }
            java.lang.Object r2 = r3.getData()     // Catch:{ all -> 0x0105 }
            coil.size.Size r8 = r20.getSize()     // Catch:{ all -> 0x0105 }
            r4 = r13
            coil.intercept.RealInterceptorChain r4 = (coil.intercept.RealInterceptorChain) r4     // Catch:{ all -> 0x0105 }
            coil.EventListener r9 = r4.getEventListener()     // Catch:{ all -> 0x0105 }
            r9.mapStart(r3, r2)     // Catch:{ all -> 0x0105 }
            coil.ComponentRegistry r4 = r12.registry     // Catch:{ all -> 0x0105 }
            java.lang.Object r5 = coil.util.ComponentRegistries.mapData(r4, r2)     // Catch:{ all -> 0x0105 }
            r9.mapEnd(r3, r5)     // Catch:{ all -> 0x0105 }
            coil.fetch.Fetcher r2 = coil.util.Requests.fetcher(r3, r5)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x007c
            coil.ComponentRegistry r2 = r12.registry     // Catch:{ all -> 0x0105 }
            coil.fetch.Fetcher r2 = coil.util.ComponentRegistries.requireFetcher(r2, r5)     // Catch:{ all -> 0x0105 }
        L_0x007c:
            r6 = r2
            coil.memory.MemoryCache$Key r2 = r3.getMemoryCacheKey()     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x0087
            coil.memory.MemoryCache$Key r2 = r12.computeMemoryCacheKey$coil_base_release(r3, r5, r6, r8)     // Catch:{ all -> 0x0105 }
        L_0x0087:
            r10 = r2
            coil.request.CachePolicy r2 = r3.getMemoryCachePolicy()     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.getReadEnabled()     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x0099
            coil.memory.MemoryCacheService r2 = r12.memoryCacheService     // Catch:{ all -> 0x0105 }
            coil.memory.RealMemoryCache$Value r2 = r2.get(r10)     // Catch:{ all -> 0x0105 }
            goto L_0x009a
        L_0x0099:
            r2 = 0
        L_0x009a:
            r4 = r2
            if (r4 == 0) goto L_0x00d1
            boolean r2 = r12.isCachedValueValid$coil_base_release(r10, r4, r3, r8)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x00d1
            coil.request.SuccessResult r0 = new coil.request.SuccessResult     // Catch:{ all -> 0x0105 }
            android.graphics.Bitmap r2 = r4.getBitmap()     // Catch:{ all -> 0x0105 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ all -> 0x0105 }
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0105 }
            r5.<init>(r1, r2)     // Catch:{ all -> 0x0105 }
            coil.request.ImageResult$Metadata r1 = new coil.request.ImageResult$Metadata     // Catch:{ all -> 0x0105 }
            boolean r2 = r4.isSampled()     // Catch:{ all -> 0x0105 }
            coil.decode.DataSource r4 = coil.decode.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x0105 }
            r6 = r13
            coil.intercept.RealInterceptorChain r6 = (coil.intercept.RealInterceptorChain) r6     // Catch:{ all -> 0x0105 }
            android.graphics.Bitmap r6 = r6.getCached()     // Catch:{ all -> 0x0105 }
            if (r6 == 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r15 = 0
        L_0x00ca:
            r1.<init>(r10, r2, r4, r15)     // Catch:{ all -> 0x0105 }
            r0.<init>(r5, r3, r1)     // Catch:{ all -> 0x0105 }
            return r0
        L_0x00d1:
            kotlinx.coroutines.CoroutineDispatcher r11 = r3.getDispatcher()     // Catch:{ all -> 0x0105 }
            coil.intercept.EngineInterceptor$intercept$2 r7 = new coil.intercept.EngineInterceptor$intercept$2     // Catch:{ all -> 0x0105 }
            r16 = 0
            r1 = r7
            r2 = r19
            r17 = r7
            r7 = r20
            r18 = r11
            r11 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0105 }
            r0.f39729h = r12     // Catch:{ all -> 0x0105 }
            r0.f39730i = r13     // Catch:{ all -> 0x0105 }
            r0.f39733l = r15     // Catch:{ all -> 0x0105 }
            r2 = r17
            r1 = r18
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r2, r0)     // Catch:{ all -> 0x0105 }
            if (r1 != r14) goto L_0x00f8
            return r14
        L_0x00f8:
            return r1
        L_0x00f9:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0105 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0105 }
            r1.<init>(r0)     // Catch:{ all -> 0x0105 }
            throw r1     // Catch:{ all -> 0x0105 }
        L_0x0105:
            r0 = move-exception
            r3 = r12
        L_0x0107:
            boolean r1 = r0 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x0116
            coil.memory.RequestService r1 = r3.requestService
            coil.request.ImageRequest r2 = r13.getRequest()
            coil.request.ErrorResult r0 = r1.errorResult(r2, r0)
            return r0
        L_0x0116:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.intercept(coil.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @VisibleForTesting
    public final boolean isCachedValueValid$coil_base_release(@Nullable MemoryCache.Key key, @NotNull RealMemoryCache.Value value, @NotNull ImageRequest imageRequest, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(value, "cacheValue");
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        if (!isSizeValid(key, value, imageRequest, size)) {
            return false;
        }
        if (this.requestService.isConfigValidForHardware(imageRequest, Bitmaps.getSafeConfig(value.getBitmap()))) {
            return true;
        }
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 3) {
            logger2.log(TAG, 3, imageRequest.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", (Throwable) null);
        }
        return false;
    }
}
