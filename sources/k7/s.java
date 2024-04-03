package k7;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import java.util.UUID;

public final /* synthetic */ class s implements ExoMediaDrm.Provider {
    public final ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
        return FrameworkMediaDrm.lambda$static$0(uuid);
    }
}
