package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.size.Precision;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import n.e;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0002\u0010\u0015J\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00061"}, d2 = {"Lcoil/request/DefaultRequestOptions;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "placeholder", "Landroid/graphics/drawable/Drawable;", "error", "fallback", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Z", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getError", "()Landroid/graphics/drawable/Drawable;", "getFallback", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPlaceholder", "getPrecision", "()Lcoil/size/Precision;", "getTransition", "()Lcoil/transition/Transition;", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultRequestOptions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final DefaultRequestOptions INSTANCE = new DefaultRequestOptions((CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
    private final boolean allowHardware;
    private final boolean allowRgb565;
    @NotNull
    private final Bitmap.Config bitmapConfig;
    @NotNull
    private final CachePolicy diskCachePolicy;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @Nullable
    private final Drawable error;
    @Nullable
    private final Drawable fallback;
    @NotNull
    private final CachePolicy memoryCachePolicy;
    @NotNull
    private final CachePolicy networkCachePolicy;
    @Nullable
    private final Drawable placeholder;
    @NotNull
    private final Precision precision;
    @NotNull
    private final Transition transition;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/request/DefaultRequestOptions$Companion;", "", "()V", "INSTANCE", "Lcoil/request/DefaultRequestOptions;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultRequestOptions() {
        this((CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
    }

    public DefaultRequestOptions(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Transition transition2, @NotNull Precision precision2, @NotNull Bitmap.Config config, boolean z11, boolean z12, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(transition2, "transition");
        Intrinsics.checkNotNullParameter(precision2, "precision");
        Intrinsics.checkNotNullParameter(config, "bitmapConfig");
        Intrinsics.checkNotNullParameter(cachePolicy, "memoryCachePolicy");
        Intrinsics.checkNotNullParameter(cachePolicy2, "diskCachePolicy");
        Intrinsics.checkNotNullParameter(cachePolicy3, "networkCachePolicy");
        this.dispatcher = coroutineDispatcher;
        this.transition = transition2;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowHardware = z11;
        this.allowRgb565 = z12;
        this.placeholder = drawable;
        this.error = drawable2;
        this.fallback = drawable3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    public static /* synthetic */ DefaultRequestOptions copy$default(DefaultRequestOptions defaultRequestOptions, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, boolean z11, boolean z12, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i11, Object obj) {
        DefaultRequestOptions defaultRequestOptions2 = defaultRequestOptions;
        int i12 = i11;
        return defaultRequestOptions.copy((i12 & 1) != 0 ? defaultRequestOptions2.dispatcher : coroutineDispatcher, (i12 & 2) != 0 ? defaultRequestOptions2.transition : transition2, (i12 & 4) != 0 ? defaultRequestOptions2.precision : precision2, (i12 & 8) != 0 ? defaultRequestOptions2.bitmapConfig : config, (i12 & 16) != 0 ? defaultRequestOptions2.allowHardware : z11, (i12 & 32) != 0 ? defaultRequestOptions2.allowRgb565 : z12, (i12 & 64) != 0 ? defaultRequestOptions2.placeholder : drawable, (i12 & 128) != 0 ? defaultRequestOptions2.error : drawable2, (i12 & 256) != 0 ? defaultRequestOptions2.fallback : drawable3, (i12 & 512) != 0 ? defaultRequestOptions2.memoryCachePolicy : cachePolicy, (i12 & 1024) != 0 ? defaultRequestOptions2.diskCachePolicy : cachePolicy2, (i12 & 2048) != 0 ? defaultRequestOptions2.networkCachePolicy : cachePolicy3);
    }

    @NotNull
    public final DefaultRequestOptions copy(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Transition transition2, @NotNull Precision precision2, @NotNull Bitmap.Config config, boolean z11, boolean z12, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Transition transition3 = transition2;
        Intrinsics.checkNotNullParameter(transition3, "transition");
        Precision precision3 = precision2;
        Intrinsics.checkNotNullParameter(precision3, "precision");
        Bitmap.Config config2 = config;
        Intrinsics.checkNotNullParameter(config2, "bitmapConfig");
        CachePolicy cachePolicy4 = cachePolicy;
        Intrinsics.checkNotNullParameter(cachePolicy4, "memoryCachePolicy");
        CachePolicy cachePolicy5 = cachePolicy2;
        Intrinsics.checkNotNullParameter(cachePolicy5, "diskCachePolicy");
        CachePolicy cachePolicy6 = cachePolicy3;
        Intrinsics.checkNotNullParameter(cachePolicy6, "networkCachePolicy");
        return new DefaultRequestOptions(coroutineDispatcher, transition3, precision3, config2, z11, z12, drawable, drawable2, drawable3, cachePolicy4, cachePolicy5, cachePolicy6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultRequestOptions) {
            DefaultRequestOptions defaultRequestOptions = (DefaultRequestOptions) obj;
            if (Intrinsics.areEqual((Object) this.dispatcher, (Object) defaultRequestOptions.dispatcher) && Intrinsics.areEqual((Object) this.transition, (Object) defaultRequestOptions.transition) && this.precision == defaultRequestOptions.precision && this.bitmapConfig == defaultRequestOptions.bitmapConfig && this.allowHardware == defaultRequestOptions.allowHardware && this.allowRgb565 == defaultRequestOptions.allowRgb565 && Intrinsics.areEqual((Object) this.placeholder, (Object) defaultRequestOptions.placeholder) && Intrinsics.areEqual((Object) this.error, (Object) defaultRequestOptions.error) && Intrinsics.areEqual((Object) this.fallback, (Object) defaultRequestOptions.fallback) && this.memoryCachePolicy == defaultRequestOptions.memoryCachePolicy && this.diskCachePolicy == defaultRequestOptions.diskCachePolicy && this.networkCachePolicy == defaultRequestOptions.networkCachePolicy) {
                return true;
            }
            return false;
        }
        return false;
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
        return this.error;
    }

    @Nullable
    public final Drawable getFallback() {
        return this.fallback;
    }

    @NotNull
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    @NotNull
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    @Nullable
    public final Drawable getPlaceholder() {
        return this.placeholder;
    }

    @NotNull
    public final Precision getPrecision() {
        return this.precision;
    }

    @NotNull
    public final Transition getTransition() {
        return this.transition;
    }

    public int hashCode() {
        int i11;
        int i12;
        int hashCode = ((((((((((this.dispatcher.hashCode() * 31) + this.transition.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.bitmapConfig.hashCode()) * 31) + e.a(this.allowHardware)) * 31) + e.a(this.allowRgb565)) * 31;
        Drawable drawable = this.placeholder;
        int i13 = 0;
        if (drawable == null) {
            i11 = 0;
        } else {
            i11 = drawable.hashCode();
        }
        int i14 = (hashCode + i11) * 31;
        Drawable drawable2 = this.error;
        if (drawable2 == null) {
            i12 = 0;
        } else {
            i12 = drawable2.hashCode();
        }
        int i15 = (i14 + i12) * 31;
        Drawable drawable3 = this.fallback;
        if (drawable3 != null) {
            i13 = drawable3.hashCode();
        }
        return ((((((i15 + i13) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    }

    @NotNull
    public String toString() {
        return "DefaultRequestOptions(dispatcher=" + this.dispatcher + ", transition=" + this.transition + ", precision=" + this.precision + ", bitmapConfig=" + this.bitmapConfig + ", allowHardware=" + this.allowHardware + ", allowRgb565=" + this.allowRgb565 + ", placeholder=" + this.placeholder + ", error=" + this.error + ", fallback=" + this.fallback + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultRequestOptions(kotlinx.coroutines.CoroutineDispatcher r13, coil.transition.Transition r14, coil.size.Precision r15, android.graphics.Bitmap.Config r16, boolean r17, boolean r18, android.graphics.drawable.Drawable r19, android.graphics.drawable.Drawable r20, android.graphics.drawable.Drawable r21, coil.request.CachePolicy r22, coil.request.CachePolicy r23, coil.request.CachePolicy r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            goto L_0x000c
        L_0x000b:
            r1 = r13
        L_0x000c:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0013
            coil.transition.Transition r2 = coil.transition.Transition.NONE
            goto L_0x0014
        L_0x0013:
            r2 = r14
        L_0x0014:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001b
            coil.size.Precision r3 = coil.size.Precision.AUTOMATIC
            goto L_0x001c
        L_0x001b:
            r3 = r15
        L_0x001c:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0027
            coil.util.Utils r4 = coil.util.Utils.INSTANCE
            android.graphics.Bitmap$Config r4 = r4.getDEFAULT_BITMAP_CONFIG()
            goto L_0x0029
        L_0x0027:
            r4 = r16
        L_0x0029:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x002f
            r5 = 1
            goto L_0x0031
        L_0x002f:
            r5 = r17
        L_0x0031:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0037
            r6 = 0
            goto L_0x0039
        L_0x0037:
            r6 = r18
        L_0x0039:
            r7 = r0 & 64
            r8 = 0
            if (r7 == 0) goto L_0x0040
            r7 = r8
            goto L_0x0042
        L_0x0040:
            r7 = r19
        L_0x0042:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0048
            r9 = r8
            goto L_0x004a
        L_0x0048:
            r9 = r20
        L_0x004a:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r8 = r21
        L_0x0051:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0058
            coil.request.CachePolicy r10 = coil.request.CachePolicy.ENABLED
            goto L_0x005a
        L_0x0058:
            r10 = r22
        L_0x005a:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0061
            coil.request.CachePolicy r11 = coil.request.CachePolicy.ENABLED
            goto L_0x0063
        L_0x0061:
            r11 = r23
        L_0x0063:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x006a
            coil.request.CachePolicy r0 = coil.request.CachePolicy.ENABLED
            goto L_0x006c
        L_0x006a:
            r0 = r24
        L_0x006c:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r9
            r22 = r8
            r23 = r10
            r24 = r11
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.request.DefaultRequestOptions.<init>(kotlinx.coroutines.CoroutineDispatcher, coil.transition.Transition, coil.size.Precision, android.graphics.Bitmap$Config, boolean, boolean, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, coil.request.CachePolicy, coil.request.CachePolicy, coil.request.CachePolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
