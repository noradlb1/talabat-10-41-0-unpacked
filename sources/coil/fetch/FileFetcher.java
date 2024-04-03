package coil.fetch;

import android.webkit.MimeTypeMap;
import coil.bitmap.BitmapPool;
import coil.decode.DataSource;
import coil.decode.Options;
import coil.fetch.Fetcher;
import coil.size.Size;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcoil/fetch/FileFetcher;", "Lcoil/fetch/Fetcher;", "Ljava/io/File;", "addLastModifiedToFileCacheKey", "", "(Z)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Ljava/io/File;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FileFetcher implements Fetcher<File> {
    private final boolean addLastModifiedToFileCacheKey;

    public FileFetcher(boolean z11) {
        this.addLastModifiedToFileCacheKey = z11;
    }

    public boolean handles(@NotNull File file) {
        return Fetcher.DefaultImpls.handles(this, file);
    }

    @Nullable
    public Object fetch(@NotNull BitmapPool bitmapPool, @NotNull File file, @NotNull Size size, @NotNull Options options, @NotNull Continuation<? super FetchResult> continuation) {
        return new SourceResult(Okio.buffer(Okio.source(file)), MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt__UtilsKt.getExtension(file)), DataSource.DISK);
    }

    @NotNull
    public String key(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "data");
        if (this.addLastModifiedToFileCacheKey) {
            return file.getPath() + AbstractJsonLexerKt.COLON + file.lastModified();
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "data.path");
        return path;
    }
}
