package coil;

import android.graphics.Bitmap;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.Options;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Size;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import z2.b;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 (2\u00020\u0001:\u0002()J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0017J$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0014H\u0017J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0017J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020$H\u0017J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020$H\u0017J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006*"}, d2 = {"Lcoil/EventListener;", "Lcoil/request/ImageRequest$Listener;", "decodeEnd", "", "request", "Lcoil/request/ImageRequest;", "decoder", "Lcoil/decode/Decoder;", "options", "Lcoil/decode/Options;", "result", "Lcoil/decode/DecodeResult;", "decodeStart", "fetchEnd", "fetcher", "Lcoil/fetch/Fetcher;", "Lcoil/fetch/FetchResult;", "fetchStart", "mapEnd", "output", "", "mapStart", "input", "onCancel", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "resolveSizeEnd", "size", "Lcoil/size/Size;", "resolveSizeStart", "transformEnd", "Landroid/graphics/Bitmap;", "transformStart", "transitionEnd", "transitionStart", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface EventListener extends ImageRequest.Listener {
    @NotNull
    public static final Companion Companion = Companion.f39663a;
    @NotNull
    @JvmField
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil/EventListener$Companion;", "", "()V", "NONE", "Lcoil/EventListener;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39663a = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        @WorkerThread
        public static void decodeEnd(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options, @NotNull DecodeResult decodeResult) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(decodeResult, "result");
        }

        @WorkerThread
        public static void decodeStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            Intrinsics.checkNotNullParameter(options, "options");
        }

        @WorkerThread
        public static void fetchEnd(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Fetcher<?> fetcher, @NotNull Options options, @NotNull FetchResult fetchResult) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(fetchResult, "result");
        }

        @WorkerThread
        public static void fetchStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Fetcher<?> fetcher, @NotNull Options options) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.checkNotNullParameter(options, "options");
        }

        @AnyThread
        public static void mapEnd(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(obj, "output");
        }

        @AnyThread
        public static void mapStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(obj, "input");
        }

        @MainThread
        public static void onCancel(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
        }

        @MainThread
        public static void onError(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(th2, "throwable");
        }

        @MainThread
        public static void onStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
        }

        @MainThread
        public static void onSuccess(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
        }

        @MainThread
        public static void resolveSizeEnd(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Size size) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
        }

        @MainThread
        public static void resolveSizeStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
        }

        @WorkerThread
        public static void transformEnd(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(bitmap, "output");
        }

        @WorkerThread
        public static void transformStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
            Intrinsics.checkNotNullParameter(bitmap, "input");
        }

        @MainThread
        public static void transitionEnd(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
        }

        @MainThread
        public static void transitionStart(@NotNull EventListener eventListener, @NotNull ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(eventListener, "this");
            Intrinsics.checkNotNullParameter(imageRequest, "request");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcoil/EventListener$Factory;", "", "create", "Lcoil/EventListener;", "request", "Lcoil/request/ImageRequest;", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Factory {
        @NotNull
        public static final Companion Companion;
        @NotNull
        @JvmField
        public static final Factory NONE;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\bR\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\t"}, d2 = {"Lcoil/EventListener$Factory$Companion;", "", "()V", "NONE", "Lcoil/EventListener$Factory;", "invoke", "listener", "Lcoil/EventListener;", "create", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f39664a = new Companion();

            private Companion() {
            }

            /* access modifiers changed from: private */
            /* renamed from: invoke$lambda-0  reason: not valid java name */
            public static final EventListener m9131invoke$lambda0(EventListener eventListener, ImageRequest imageRequest) {
                Intrinsics.checkNotNullParameter(eventListener, "$listener");
                Intrinsics.checkNotNullParameter(imageRequest, "it");
                return eventListener;
            }

            @JvmStatic
            @NotNull
            @JvmName(name = "create")
            public final Factory create(@NotNull EventListener eventListener) {
                Intrinsics.checkNotNullParameter(eventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                return new b(eventListener);
            }
        }

        static {
            Companion companion = Companion.f39664a;
            Companion = companion;
            NONE = companion.create(EventListener.NONE);
        }

        @NotNull
        EventListener create(@NotNull ImageRequest imageRequest);
    }

    @WorkerThread
    void decodeEnd(@NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options, @NotNull DecodeResult decodeResult);

    @WorkerThread
    void decodeStart(@NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options);

    @WorkerThread
    void fetchEnd(@NotNull ImageRequest imageRequest, @NotNull Fetcher<?> fetcher, @NotNull Options options, @NotNull FetchResult fetchResult);

    @WorkerThread
    void fetchStart(@NotNull ImageRequest imageRequest, @NotNull Fetcher<?> fetcher, @NotNull Options options);

    @AnyThread
    void mapEnd(@NotNull ImageRequest imageRequest, @NotNull Object obj);

    @AnyThread
    void mapStart(@NotNull ImageRequest imageRequest, @NotNull Object obj);

    @MainThread
    void onCancel(@NotNull ImageRequest imageRequest);

    @MainThread
    void onError(@NotNull ImageRequest imageRequest, @NotNull Throwable th2);

    @MainThread
    void onStart(@NotNull ImageRequest imageRequest);

    @MainThread
    void onSuccess(@NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata);

    @MainThread
    void resolveSizeEnd(@NotNull ImageRequest imageRequest, @NotNull Size size);

    @MainThread
    void resolveSizeStart(@NotNull ImageRequest imageRequest);

    @WorkerThread
    void transformEnd(@NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap);

    @WorkerThread
    void transformStart(@NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap);

    @MainThread
    void transitionEnd(@NotNull ImageRequest imageRequest);

    @MainThread
    void transitionStart(@NotNull ImageRequest imageRequest);
}
