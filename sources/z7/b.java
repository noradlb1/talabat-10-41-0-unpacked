package z7;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.DownloadHelper;

public final /* synthetic */ class b implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrmSessionManager f35579a;

    public /* synthetic */ b(DrmSessionManager drmSessionManager) {
        this.f35579a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return DownloadHelper.lambda$createMediaSourceInternal$6(this.f35579a, mediaItem);
    }
}
