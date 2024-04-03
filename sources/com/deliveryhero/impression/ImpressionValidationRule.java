package com.deliveryhero.impression;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/deliveryhero/impression/ImpressionValidationRule;", "", "visibleDurationThresholdMs", "", "visibleAreaThresholdPercent", "", "(JI)V", "isDurationSufficient", "", "timeAdded", "timeRemoved", "isVisibilitySufficient", "percentage", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImpressionValidationRule {
    public static final int $stable = 0;
    private final int visibleAreaThresholdPercent;
    private final long visibleDurationThresholdMs;

    public ImpressionValidationRule() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public ImpressionValidationRule(long j11, int i11) {
        this.visibleDurationThresholdMs = j11;
        this.visibleAreaThresholdPercent = i11;
    }

    public final boolean isDurationSufficient(long j11, long j12) {
        return j12 - j11 >= this.visibleDurationThresholdMs;
    }

    public final boolean isVisibilitySufficient(int i11) {
        return i11 >= this.visibleAreaThresholdPercent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImpressionValidationRule(long j11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 1000 : j11, (i12 & 2) != 0 ? 50 : i11);
    }
}
