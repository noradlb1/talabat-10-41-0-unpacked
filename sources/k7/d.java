package k7;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class d {
    public static boolean a(DrmSession drmSession) {
        return false;
    }

    public static void b(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession != drmSession2) {
            if (drmSession2 != null) {
                drmSession2.acquire((DrmSessionEventListener.EventDispatcher) null);
            }
            if (drmSession != null) {
                drmSession.release((DrmSessionEventListener.EventDispatcher) null);
            }
        }
    }
}
