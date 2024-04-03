package coil.request;

import android.graphics.Bitmap;
import androidx.lifecycle.Lifecycle;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.SizeResolver;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0017J\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcoil/request/DefinedRequestOptions;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPrecision", "()Lcoil/size/Precision;", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTransition", "()Lcoil/transition/Transition;", "copy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)Lcoil/request/DefinedRequestOptions;", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefinedRequestOptions {
    @Nullable
    private final Boolean allowHardware;
    @Nullable
    private final Boolean allowRgb565;
    @Nullable
    private final Bitmap.Config bitmapConfig;
    @Nullable
    private final CachePolicy diskCachePolicy;
    @Nullable
    private final CoroutineDispatcher dispatcher;
    @Nullable
    private final Lifecycle lifecycle;
    @Nullable
    private final CachePolicy memoryCachePolicy;
    @Nullable
    private final CachePolicy networkCachePolicy;
    @Nullable
    private final Precision precision;
    @Nullable
    private final Scale scale;
    @Nullable
    private final SizeResolver sizeResolver;
    @Nullable
    private final Transition transition;

    public DefinedRequestOptions(@Nullable Lifecycle lifecycle2, @Nullable SizeResolver sizeResolver2, @Nullable Scale scale2, @Nullable CoroutineDispatcher coroutineDispatcher, @Nullable Transition transition2, @Nullable Precision precision2, @Nullable Bitmap.Config config, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable CachePolicy cachePolicy, @Nullable CachePolicy cachePolicy2, @Nullable CachePolicy cachePolicy3) {
        this.lifecycle = lifecycle2;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.dispatcher = coroutineDispatcher;
        this.transition = transition2;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowHardware = bool;
        this.allowRgb565 = bool2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    public static /* synthetic */ DefinedRequestOptions copy$default(DefinedRequestOptions definedRequestOptions, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i11, Object obj) {
        DefinedRequestOptions definedRequestOptions2 = definedRequestOptions;
        int i12 = i11;
        return definedRequestOptions.copy((i12 & 1) != 0 ? definedRequestOptions2.lifecycle : lifecycle2, (i12 & 2) != 0 ? definedRequestOptions2.sizeResolver : sizeResolver2, (i12 & 4) != 0 ? definedRequestOptions2.scale : scale2, (i12 & 8) != 0 ? definedRequestOptions2.dispatcher : coroutineDispatcher, (i12 & 16) != 0 ? definedRequestOptions2.transition : transition2, (i12 & 32) != 0 ? definedRequestOptions2.precision : precision2, (i12 & 64) != 0 ? definedRequestOptions2.bitmapConfig : config, (i12 & 128) != 0 ? definedRequestOptions2.allowHardware : bool, (i12 & 256) != 0 ? definedRequestOptions2.allowRgb565 : bool2, (i12 & 512) != 0 ? definedRequestOptions2.memoryCachePolicy : cachePolicy, (i12 & 1024) != 0 ? definedRequestOptions2.diskCachePolicy : cachePolicy2, (i12 & 2048) != 0 ? definedRequestOptions2.networkCachePolicy : cachePolicy3);
    }

    @NotNull
    public final DefinedRequestOptions copy(@Nullable Lifecycle lifecycle2, @Nullable SizeResolver sizeResolver2, @Nullable Scale scale2, @Nullable CoroutineDispatcher coroutineDispatcher, @Nullable Transition transition2, @Nullable Precision precision2, @Nullable Bitmap.Config config, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable CachePolicy cachePolicy, @Nullable CachePolicy cachePolicy2, @Nullable CachePolicy cachePolicy3) {
        return new DefinedRequestOptions(lifecycle2, sizeResolver2, scale2, coroutineDispatcher, transition2, precision2, config, bool, bool2, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefinedRequestOptions) {
            DefinedRequestOptions definedRequestOptions = (DefinedRequestOptions) obj;
            if (!Intrinsics.areEqual((Object) this.lifecycle, (Object) definedRequestOptions.lifecycle) || !Intrinsics.areEqual((Object) this.sizeResolver, (Object) definedRequestOptions.sizeResolver) || this.scale != definedRequestOptions.scale || !Intrinsics.areEqual((Object) this.dispatcher, (Object) definedRequestOptions.dispatcher) || !Intrinsics.areEqual((Object) this.transition, (Object) definedRequestOptions.transition) || this.precision != definedRequestOptions.precision || this.bitmapConfig != definedRequestOptions.bitmapConfig || !Intrinsics.areEqual((Object) this.allowHardware, (Object) definedRequestOptions.allowHardware) || !Intrinsics.areEqual((Object) this.allowRgb565, (Object) definedRequestOptions.allowRgb565) || this.memoryCachePolicy != definedRequestOptions.memoryCachePolicy || this.diskCachePolicy != definedRequestOptions.diskCachePolicy || this.networkCachePolicy != definedRequestOptions.networkCachePolicy) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final Boolean getAllowHardware() {
        return this.allowHardware;
    }

    @Nullable
    public final Boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    @Nullable
    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    @Nullable
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    @Nullable
    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Nullable
    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    @Nullable
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    @Nullable
    public final Precision getPrecision() {
        return this.precision;
    }

    @Nullable
    public final Scale getScale() {
        return this.scale;
    }

    @Nullable
    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    @Nullable
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
        Lifecycle lifecycle2 = this.lifecycle;
        int i23 = 0;
        if (lifecycle2 == null) {
            i11 = 0;
        } else {
            i11 = lifecycle2.hashCode();
        }
        int i24 = i11 * 31;
        SizeResolver sizeResolver2 = this.sizeResolver;
        if (sizeResolver2 == null) {
            i12 = 0;
        } else {
            i12 = sizeResolver2.hashCode();
        }
        int i25 = (i24 + i12) * 31;
        Scale scale2 = this.scale;
        if (scale2 == null) {
            i13 = 0;
        } else {
            i13 = scale2.hashCode();
        }
        int i26 = (i25 + i13) * 31;
        CoroutineDispatcher coroutineDispatcher = this.dispatcher;
        if (coroutineDispatcher == null) {
            i14 = 0;
        } else {
            i14 = coroutineDispatcher.hashCode();
        }
        int i27 = (i26 + i14) * 31;
        Transition transition2 = this.transition;
        if (transition2 == null) {
            i15 = 0;
        } else {
            i15 = transition2.hashCode();
        }
        int i28 = (i27 + i15) * 31;
        Precision precision2 = this.precision;
        if (precision2 == null) {
            i16 = 0;
        } else {
            i16 = precision2.hashCode();
        }
        int i29 = (i28 + i16) * 31;
        Bitmap.Config config = this.bitmapConfig;
        if (config == null) {
            i17 = 0;
        } else {
            i17 = config.hashCode();
        }
        int i31 = (i29 + i17) * 31;
        Boolean bool = this.allowHardware;
        if (bool == null) {
            i18 = 0;
        } else {
            i18 = bool.hashCode();
        }
        int i32 = (i31 + i18) * 31;
        Boolean bool2 = this.allowRgb565;
        if (bool2 == null) {
            i19 = 0;
        } else {
            i19 = bool2.hashCode();
        }
        int i33 = (i32 + i19) * 31;
        CachePolicy cachePolicy = this.memoryCachePolicy;
        if (cachePolicy == null) {
            i21 = 0;
        } else {
            i21 = cachePolicy.hashCode();
        }
        int i34 = (i33 + i21) * 31;
        CachePolicy cachePolicy2 = this.diskCachePolicy;
        if (cachePolicy2 == null) {
            i22 = 0;
        } else {
            i22 = cachePolicy2.hashCode();
        }
        int i35 = (i34 + i22) * 31;
        CachePolicy cachePolicy3 = this.networkCachePolicy;
        if (cachePolicy3 != null) {
            i23 = cachePolicy3.hashCode();
        }
        return i35 + i23;
    }

    @NotNull
    public String toString() {
        return "DefinedRequestOptions(lifecycle=" + this.lifecycle + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", dispatcher=" + this.dispatcher + ", transition=" + this.transition + ", precision=" + this.precision + ", bitmapConfig=" + this.bitmapConfig + ", allowHardware=" + this.allowHardware + ", allowRgb565=" + this.allowRgb565 + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ')';
    }
}
