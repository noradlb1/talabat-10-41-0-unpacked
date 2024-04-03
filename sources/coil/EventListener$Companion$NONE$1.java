package coil;

import android.graphics.Bitmap;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import coil.EventListener;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.Options;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Size;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil/EventListener$Companion$NONE$1", "Lcoil/EventListener;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventListener$Companion$NONE$1 implements EventListener {
    @WorkerThread
    public void decodeEnd(@NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options, @NotNull DecodeResult decodeResult) {
        EventListener.DefaultImpls.decodeEnd(this, imageRequest, decoder, options, decodeResult);
    }

    @WorkerThread
    public void decodeStart(@NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options) {
        EventListener.DefaultImpls.decodeStart(this, imageRequest, decoder, options);
    }

    @WorkerThread
    public void fetchEnd(@NotNull ImageRequest imageRequest, @NotNull Fetcher<?> fetcher, @NotNull Options options, @NotNull FetchResult fetchResult) {
        EventListener.DefaultImpls.fetchEnd(this, imageRequest, fetcher, options, fetchResult);
    }

    @WorkerThread
    public void fetchStart(@NotNull ImageRequest imageRequest, @NotNull Fetcher<?> fetcher, @NotNull Options options) {
        EventListener.DefaultImpls.fetchStart(this, imageRequest, fetcher, options);
    }

    @AnyThread
    public void mapEnd(@NotNull ImageRequest imageRequest, @NotNull Object obj) {
        EventListener.DefaultImpls.mapEnd(this, imageRequest, obj);
    }

    @AnyThread
    public void mapStart(@NotNull ImageRequest imageRequest, @NotNull Object obj) {
        EventListener.DefaultImpls.mapStart(this, imageRequest, obj);
    }

    @MainThread
    public void onCancel(@NotNull ImageRequest imageRequest) {
        EventListener.DefaultImpls.onCancel(this, imageRequest);
    }

    @MainThread
    public void onError(@NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
        EventListener.DefaultImpls.onError(this, imageRequest, th2);
    }

    @MainThread
    public void onStart(@NotNull ImageRequest imageRequest) {
        EventListener.DefaultImpls.onStart(this, imageRequest);
    }

    @MainThread
    public void onSuccess(@NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata) {
        EventListener.DefaultImpls.onSuccess(this, imageRequest, metadata);
    }

    @MainThread
    public void resolveSizeEnd(@NotNull ImageRequest imageRequest, @NotNull Size size) {
        EventListener.DefaultImpls.resolveSizeEnd(this, imageRequest, size);
    }

    @MainThread
    public void resolveSizeStart(@NotNull ImageRequest imageRequest) {
        EventListener.DefaultImpls.resolveSizeStart(this, imageRequest);
    }

    @WorkerThread
    public void transformEnd(@NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap) {
        EventListener.DefaultImpls.transformEnd(this, imageRequest, bitmap);
    }

    @WorkerThread
    public void transformStart(@NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap) {
        EventListener.DefaultImpls.transformStart(this, imageRequest, bitmap);
    }

    @MainThread
    public void transitionEnd(@NotNull ImageRequest imageRequest) {
        EventListener.DefaultImpls.transitionEnd(this, imageRequest);
    }

    @MainThread
    public void transitionStart(@NotNull ImageRequest imageRequest) {
        EventListener.DefaultImpls.transitionStart(this, imageRequest);
    }
}
