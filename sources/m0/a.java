package m0;

import androidx.compose.ui.platform.AccessibilityManager;

public final /* synthetic */ class a {
    public static /* synthetic */ long a(AccessibilityManager accessibilityManager, long j11, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if (obj == null) {
            return accessibilityManager.calculateRecommendedTimeoutMillis(j11, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12, (i11 & 8) != 0 ? false : z13);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateRecommendedTimeoutMillis");
    }
}
