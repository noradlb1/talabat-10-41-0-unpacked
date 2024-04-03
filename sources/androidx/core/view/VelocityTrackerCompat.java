package androidx.core.view;

import android.view.VelocityTracker;

@Deprecated
public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i11) {
        return velocityTracker.getXVelocity(i11);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i11) {
        return velocityTracker.getYVelocity(i11);
    }
}
