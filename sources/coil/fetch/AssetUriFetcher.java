package coil.fetch;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.bitmap.BitmapPool;
import coil.decode.DataSource;
import coil.decode.Options;
import coil.size.Size;
import coil.util.Extensions;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcoil/fetch/AssetUriFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/net/Uri;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "key", "", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AssetUriFetcher implements Fetcher<Uri> {
    @NotNull
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/fetch/AssetUriFetcher$Companion;", "", "()V", "ASSET_FILE_PATH_ROOT", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AssetUriFetcher(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Nullable
    public Object fetch(@NotNull BitmapPool bitmapPool, @NotNull Uri uri, @NotNull Size size, @NotNull Options options, @NotNull Continuation<? super FetchResult> continuation) {
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "data.pathSegments");
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.drop(pathSegments, 1), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        InputStream open = this.context.getAssets().open(joinToString$default);
        Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(path)");
        BufferedSource buffer = Okio.buffer(Okio.source(open));
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Intrinsics.checkNotNullExpressionValue(singleton, "getSingleton()");
        return new SourceResult(buffer, Extensions.getMimeTypeFromUrl(singleton, joinToString$default), DataSource.DISK);
    }

    public boolean handles(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "file") && Intrinsics.areEqual((Object) Extensions.getFirstPathSegment(uri), (Object) ASSET_FILE_PATH_ROOT);
    }

    @NotNull
    public String key(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "data.toString()");
        return uri2;
    }
}
