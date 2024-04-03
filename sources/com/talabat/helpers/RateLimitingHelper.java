package com.talabat.helpers;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpers/RateLimitingHelper;", "", "updateThresholdInSeconds", "", "lastFetchTime", "timeUtils", "Lcom/talabat/helpers/TimeUtils;", "(JJLcom/talabat/helpers/TimeUtils;)V", "isUpdateRequired", "", "run", "", "block", "Lkotlin/Function0;", "timeElapsedSinceLastFetchTime", "updateLastFetchTime", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    private final boolean isUpdateRequired() {
        if (timeElapsedSinceLastFetchTime() > TimeUnit.MILLISECONDS.convert(this.updateThresholdInSeconds, TimeUnit.SECONDS)) {
            return true;
        }
        return false;
    }

    private final long timeElapsedSinceLastFetchTime() {
        return this.timeUtils.currentTimeInMillis() - this.lastFetchTime;
    }

    private final void updateLastFetchTime() {
        this.lastFetchTime = this.timeUtils.currentTimeInMillis();
    }

    public final void run(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (isUpdateRequired()) {
            function0.invoke();
            updateLastFetchTime();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RateLimitingHelper(long j11, long j12, TimeUtils timeUtils2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, (i11 & 2) != 0 ? 0 : j12, (i11 & 4) != 0 ? new TimeUtils() : timeUtils2);
    }
}
