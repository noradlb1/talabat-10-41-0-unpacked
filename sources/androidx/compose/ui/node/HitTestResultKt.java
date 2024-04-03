package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"DistanceAndInLayer", "Landroidx/compose/ui/node/DistanceAndInLayer;", "distance", "", "isInLayer", "", "(FZ)J", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HitTestResultKt {
    /* access modifiers changed from: private */
    public static final long DistanceAndInLayer(float f11, boolean z11) {
        long j11;
        long floatToIntBits = (long) Float.floatToIntBits(f11);
        if (z11) {
            j11 = 1;
        } else {
            j11 = 0;
        }
        return DistanceAndInLayer.m4597constructorimpl((j11 & 4294967295L) | (floatToIntBits << 32));
    }
}
