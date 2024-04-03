package m8;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;

public final /* synthetic */ class c {
    public static long a(ContentMetadata contentMetadata) {
        return contentMetadata.get(ContentMetadata.KEY_CONTENT_LENGTH, -1);
    }

    @Nullable
    public static Uri b(ContentMetadata contentMetadata) {
        String str = contentMetadata.get(ContentMetadata.KEY_REDIRECTED_URI, (String) null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }
}
