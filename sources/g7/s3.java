package g7;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;

public final /* synthetic */ class s3 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return TrackGroup.CREATOR.fromBundle((Bundle) Assertions.checkNotNull(bundle.getBundle(Tracks.Group.FIELD_TRACK_GROUP)));
    }
}
