package coil.request;

import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"coil/request/ImageRequest$Builder$listener$5", "Lcoil/request/ImageRequest$Listener;", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageRequest$Builder$listener$5 implements ImageRequest.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<ImageRequest, Unit> f39790a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<ImageRequest, Unit> f39791b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2<ImageRequest, Throwable, Unit> f39792c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function2<ImageRequest, ImageResult.Metadata, Unit> f39793d;

    public ImageRequest$Builder$listener$5(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super Throwable, Unit> function2, Function2<? super ImageRequest, ? super ImageResult.Metadata, Unit> function22) {
        this.f39790a = function1;
        this.f39791b = function12;
        this.f39792c = function2;
        this.f39793d = function22;
    }

    public void onCancel(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        this.f39791b.invoke(imageRequest);
    }

    public void onError(@NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        this.f39792c.invoke(imageRequest, th2);
    }

    public void onStart(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        this.f39790a.invoke(imageRequest);
    }

    public void onSuccess(@NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
        this.f39793d.invoke(imageRequest, metadata);
    }
}
