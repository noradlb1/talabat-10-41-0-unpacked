package tracking;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustInstance;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltracking/AdjustManager;", "", "()V", "adjustWrapper", "Ltracking/AdjustWrapper;", "setAdjustWrapper", "", "trackAdjustEvent", "event", "Lcom/adjust/sdk/AdjustEvent;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Should be cleaned once migration to Flutter is done")
public final class AdjustManager {
    @NotNull
    public static final AdjustManager INSTANCE = new AdjustManager();
    @NotNull
    private static AdjustWrapper adjustWrapper;

    static {
        AdjustInstance defaultInstance = Adjust.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance()");
        adjustWrapper = new AdjustWrapperImpl(defaultInstance);
    }

    private AdjustManager() {
    }

    public final void setAdjustWrapper(@NotNull AdjustWrapper adjustWrapper2) {
        Intrinsics.checkNotNullParameter(adjustWrapper2, "adjustWrapper");
        adjustWrapper = adjustWrapper2;
    }

    public final void trackAdjustEvent(@NotNull AdjustEvent adjustEvent) {
        Intrinsics.checkNotNullParameter(adjustEvent, "event");
        adjustWrapper.trackEvent(adjustEvent);
    }
}
