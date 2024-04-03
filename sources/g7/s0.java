package g7;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

public final /* synthetic */ class s0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return new MediaItem.RequestMetadata.Builder().setMediaUri((Uri) bundle.getParcelable(MediaItem.RequestMetadata.FIELD_MEDIA_URI)).setSearchQuery(bundle.getString(MediaItem.RequestMetadata.FIELD_SEARCH_QUERY)).setExtras(bundle.getBundle(MediaItem.RequestMetadata.FIELD_EXTRAS)).build();
    }
}
