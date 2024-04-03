package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.WorkerThread;
import androidx.core.view.ViewCompat;
import coil.decode.Options;
import coil.request.CachePolicy;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcoil/memory/RequestService;", "", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/memory/HardwareBitmapService;", "errorResult", "Lcoil/request/ErrorResult;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "isConfigValidForHardware", "", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isConfigValidForHardwareAllocation", "size", "Lcoil/size/Size;", "isConfigValidForTransformations", "options", "Lcoil/decode/Options;", "isOnline", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RequestService {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = (Build.VERSION.SDK_INT >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888});
    @NotNull
    private final HardwareBitmapService hardwareBitmapService = HardwareBitmapService.Companion.invoke();
    @Nullable
    private final Logger logger;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil/memory/RequestService$Companion;", "", "()V", "VALID_TRANSFORMATION_CONFIGS", "", "Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RequestService(@Nullable Logger logger2) {
        this.logger = logger2;
    }

    @WorkerThread
    private final boolean isConfigValidForHardwareAllocation(ImageRequest imageRequest, Size size) {
        if (!isConfigValidForHardware(imageRequest, imageRequest.getBitmapConfig()) || !this.hardwareBitmapService.allowHardware(size, this.logger)) {
            return false;
        }
        return true;
    }

    private final boolean isConfigValidForTransformations(ImageRequest imageRequest) {
        return imageRequest.getTransformations().isEmpty() || ArraysKt___ArraysKt.contains((T[]) VALID_TRANSFORMATION_CONFIGS, imageRequest.getBitmapConfig());
    }

    @NotNull
    public final ErrorResult errorResult(@NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (th2 instanceof NullRequestDataException) {
            drawable = imageRequest.getFallback();
        } else {
            drawable = imageRequest.getError();
        }
        return new ErrorResult(drawable, imageRequest, th2);
    }

    public final boolean isConfigValidForHardware(@NotNull ImageRequest imageRequest, @NotNull Bitmap.Config config) {
        boolean z11;
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(config, "requestedConfig");
        if (!Bitmaps.isHardware(config)) {
            return true;
        }
        if (!imageRequest.getAllowHardware()) {
            return false;
        }
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (!ViewCompat.isAttachedToWindow(view) || view.isHardwareAccelerated()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    @WorkerThread
    public final Options options(@NotNull ImageRequest imageRequest, @NotNull Size size, boolean z11) {
        boolean z12;
        Bitmap.Config config;
        CachePolicy cachePolicy;
        boolean z13;
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        if (!isConfigValidForTransformations(imageRequest) || !isConfigValidForHardwareAllocation(imageRequest, size)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            config = imageRequest.getBitmapConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap.Config config2 = config;
        if (z11) {
            cachePolicy = imageRequest.getNetworkCachePolicy();
        } else {
            cachePolicy = CachePolicy.DISABLED;
        }
        CachePolicy cachePolicy2 = cachePolicy;
        if (!imageRequest.getAllowRgb565() || !imageRequest.getTransformations().isEmpty() || config2 == Bitmap.Config.ALPHA_8) {
            z13 = false;
        } else {
            z13 = true;
        }
        return new Options(imageRequest.getContext(), config2, imageRequest.getColorSpace(), imageRequest.getScale(), Requests.getAllowInexactSize(imageRequest), z13, imageRequest.getPremultipliedAlpha(), imageRequest.getHeaders(), imageRequest.getParameters(), imageRequest.getMemoryCachePolicy(), imageRequest.getDiskCachePolicy(), cachePolicy2);
    }
}
