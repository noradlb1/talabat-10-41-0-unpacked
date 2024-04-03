package coil;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\bJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nHHø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\r\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcoil/Coil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Landroid/content/Context;", "newImageLoader", "reset", "", "reset$coil_singleton_release", "setImageLoader", "factory", "coil-singleton_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Coil {
    @NotNull
    public static final Coil INSTANCE = new Coil();
    @Nullable
    private static ImageLoader imageLoader;
    @Nullable
    private static ImageLoaderFactory imageLoaderFactory;

    private Coil() {
    }

    @JvmStatic
    @NotNull
    public static final Disposable enqueue(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        return imageLoader(imageRequest.getContext()).enqueue(imageRequest);
    }

    @JvmStatic
    @Nullable
    public static final Object execute(@NotNull ImageRequest imageRequest, @NotNull Continuation<? super ImageResult> continuation) {
        return imageLoader(imageRequest.getContext()).execute(imageRequest, continuation);
    }

    @JvmStatic
    private static final Object execute$$forInline(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        ImageLoader imageLoader2 = imageLoader(imageRequest.getContext());
        InlineMarker.mark(0);
        Object execute = imageLoader2.execute(imageRequest, continuation);
        InlineMarker.mark(1);
        return execute;
    }

    @JvmStatic
    @NotNull
    public static final ImageLoader imageLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageLoader imageLoader2 = imageLoader;
        if (imageLoader2 == null) {
            return INSTANCE.newImageLoader(context);
        }
        return imageLoader2;
    }

    private final synchronized ImageLoader newImageLoader(Context context) {
        ImageLoader imageLoader2;
        ImageLoaderFactory imageLoaderFactory2;
        ImageLoader newImageLoader;
        ImageLoader imageLoader3 = imageLoader;
        if (imageLoader3 != null) {
            return imageLoader3;
        }
        ImageLoaderFactory imageLoaderFactory3 = imageLoaderFactory;
        if (imageLoaderFactory3 == null) {
            imageLoader2 = null;
        } else {
            imageLoader2 = imageLoaderFactory3.newImageLoader();
        }
        if (imageLoader2 == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof ImageLoaderFactory) {
                imageLoaderFactory2 = (ImageLoaderFactory) applicationContext;
            } else {
                imageLoaderFactory2 = null;
            }
            if (imageLoaderFactory2 == null) {
                newImageLoader = null;
            } else {
                newImageLoader = imageLoaderFactory2.newImageLoader();
            }
            if (imageLoader2 == null) {
                imageLoader2 = ImageLoader.Companion.create(context);
            }
        }
        imageLoaderFactory = null;
        imageLoader = imageLoader2;
        return imageLoader2;
    }

    @JvmStatic
    public static final synchronized void setImageLoader(@NotNull ImageLoader imageLoader2) {
        synchronized (Coil.class) {
            Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
            imageLoaderFactory = null;
            imageLoader = imageLoader2;
        }
    }

    @VisibleForTesting
    public final synchronized void reset$coil_singleton_release() {
        imageLoader = null;
        imageLoaderFactory = null;
    }

    @JvmStatic
    public static final synchronized void setImageLoader(@NotNull ImageLoaderFactory imageLoaderFactory2) {
        synchronized (Coil.class) {
            Intrinsics.checkNotNullParameter(imageLoaderFactory2, "factory");
            imageLoaderFactory = imageLoaderFactory2;
            imageLoader = null;
        }
    }
}
