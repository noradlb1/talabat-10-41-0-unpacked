package coil;

import androidx.annotation.WorkerThread;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"executeBlocking", "Lcoil/request/ImageResult;", "Lcoil/ImageLoader;", "request", "Lcoil/request/ImageRequest;", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "ImageLoaders")
public final class ImageLoaders {
    @NotNull
    @WorkerThread
    public static final ImageResult executeBlocking(@NotNull ImageLoader imageLoader, @NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageLoader, "<this>");
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        return (ImageResult) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ImageLoaders$executeBlocking$1(imageLoader, imageRequest, (Continuation<? super ImageLoaders$executeBlocking$1>) null), 1, (Object) null);
    }
}
