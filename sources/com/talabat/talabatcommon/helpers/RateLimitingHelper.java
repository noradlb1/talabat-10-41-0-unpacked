package com.talabat.talabatcommon.helpers;

import com.talabat.talabatcommon.utils.TimeUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0003H\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/helpers/RateLimitingHelper;", "", "updateThresholdInSeconds", "", "lastFetchTime", "timeUtils", "Lcom/talabat/talabatcommon/utils/TimeUtils;", "(JJLcom/talabat/talabatcommon/utils/TimeUtils;)V", "isUpdateRequired", "", "timeElapsedSinceLastFetchTime", "updateLastFetchTime", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateLimitingHelper {
    private long lastFetchTime;
    @NotNull
    private final TimeUtils timeUtils;
    private final long updateThresholdInSeconds;

    public RateLimitingHelper(long j11, long j12, @NotNull TimeUtils timeUtils2) {
        Intrinsics.checkNotNullParameter(timeUtils2, "timeUtils");
        this.updateThresholdInSeconds = j11;
        this.lastFetchTime = j12;
        this.timeUtils = timeUtils2;
    }

    private final long timeElapsedSinceLastFetchTime() {
        return this.timeUtils.currentTimeInMillis() - this.lastFetchTime;
    }

    public final boolean isUpdateRequired() {
        if (timeElapsedSinceLastFetchTime() > TimeUnit.MILLISECONDS.convert(this.updateThresholdInSeconds, TimeUnit.SECONDS)) {
            return true;
        }
        return false;
    }

    public final void updateLastFetchTime() {
        this.lastFetchTime = this.timeUtils.currentTimeInMillis();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RateLimitingHelper(long j11, long j12, TimeUtils timeUtils2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, (i11 & 2) != 0 ? 0 : j12, (i11 & 4) != 0 ? new TimeUtils() : timeUtils2);
    }
}
