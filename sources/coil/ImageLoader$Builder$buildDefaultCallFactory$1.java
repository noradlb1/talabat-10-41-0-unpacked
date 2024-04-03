package coil;

import coil.ImageLoader;
import coil.util.CoilUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokhttp3/Call$Factory;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ImageLoader$Builder$buildDefaultCallFactory$1 extends Lambda implements Function0<Call.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageLoader.Builder f39665g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoader$Builder$buildDefaultCallFactory$1(ImageLoader.Builder builder) {
        super(0);
        this.f39665g = builder;
    }

    @NotNull
    public final Call.Factory invoke() {
        OkHttpClient build = new OkHttpClient.Builder().cache(CoilUtils.createDefaultCache(this.f39665g.applicationContext)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        return build;
    }
}
