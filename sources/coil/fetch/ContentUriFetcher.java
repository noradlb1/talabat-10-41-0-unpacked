package coil.fetch;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import coil.bitmap.BitmapPool;
import coil.decode.DataSource;
import coil.decode.Options;
import coil.size.Size;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0001¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcoil/fetch/ContentUriFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/net/Uri;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "isContactPhotoUri", "isContactPhotoUri$coil_base_release", "key", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContentUriFetcher implements Fetcher<Uri> {
    @NotNull
    private final Context context;

    public ContentUriFetcher(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @VisibleForTesting
    public final boolean isContactPhotoUri$coil_base_release(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        if (!Intrinsics.areEqual((Object) uri.getAuthority(), (Object) "com.android.contacts") || !Intrinsics.areEqual((Object) uri.getLastPathSegment(), (Object) "display_photo")) {
            return false;
        }
        return true;
    }

    @Nullable
    public Object fetch(@NotNull BitmapPool bitmapPool, @NotNull Uri uri, @NotNull Size size, @NotNull Options options, @NotNull Continuation<? super FetchResult> continuation) {
        InputStream inputStream;
        if (isContactPhotoUri$coil_base_release(uri)) {
            AssetFileDescriptor openAssetFileDescriptor = this.context.getContentResolver().openAssetFileDescriptor(uri, "r");
            inputStream = openAssetFileDescriptor == null ? null : openAssetFileDescriptor.createInputStream();
            if (inputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + uri + "'.").toString());
            }
        } else {
            inputStream = this.context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                throw new IllegalStateException(("Unable to open '" + uri + "'.").toString());
            }
        }
        return new SourceResult(Okio.buffer(Okio.source(inputStream)), this.context.getContentResolver().getType(uri), DataSource.DISK);
    }

    public boolean handles(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "content");
    }

    @NotNull
    public String key(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "data.toString()");
        return uri2;
    }
}
