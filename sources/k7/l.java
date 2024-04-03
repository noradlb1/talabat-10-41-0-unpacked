package k7;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;

public final /* synthetic */ class l {
    static {
        DrmSessionManager drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
    }

    public static DrmSessionManager.DrmSessionReference a(DrmSessionManager drmSessionManager, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionManager.DrmSessionReference.EMPTY;
    }

    public static void b(DrmSessionManager drmSessionManager) {
    }

    public static void c(DrmSessionManager drmSessionManager) {
    }

    @Deprecated
    public static DrmSessionManager d() {
        return DrmSessionManager.DRM_UNSUPPORTED;
    }
}
