package tracking;

import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustInstance;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Ltracking/AdjustWrapperImpl;", "Ltracking/AdjustWrapper;", "tracker", "Lcom/adjust/sdk/AdjustInstance;", "(Lcom/adjust/sdk/AdjustInstance;)V", "getTracker", "()Lcom/adjust/sdk/AdjustInstance;", "trackEvent", "", "event", "Lcom/adjust/sdk/AdjustEvent;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Should be cleaned once migration to Flutter is done")
public final class AdjustWrapperImpl implements AdjustWrapper {
    @NotNull
    private final AdjustInstance tracker;

    public AdjustWrapperImpl(@NotNull AdjustInstance adjustInstance) {
        Intrinsics.checkNotNullParameter(adjustInstance, "tracker");
        this.tracker = adjustInstance;
    }

    @NotNull
    public final AdjustInstance getTracker() {
        return this.tracker;
    }

    public void trackEvent(@NotNull AdjustEvent adjustEvent) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        this.tracker.trackEvent(adjustEvent);
    }
}
