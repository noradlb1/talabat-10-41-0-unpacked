package com.talabat.observabilityNew.tracker;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\bH\u0002¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"NO_TIME_MILLIS", "", "TRACK_EVENT_END_TIMESTAMP", "", "TRACK_EVENT_PAGE_NAME", "TRACK_EVENT_START_TIMESTAMP", "TRACK_EVENT_TIME_IN_MILLIS", "calculateTimeInMillis", "Lcom/talabat/observabilityNew/tracker/TimeTrackingData;", "(Lcom/talabat/observabilityNew/tracker/TimeTrackingData;)Ljava/lang/Long;", "com_talabat_core_observability_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TimeTrackerKt {
    private static final long NO_TIME_MILLIS = 0;
    @NotNull
    private static final String TRACK_EVENT_END_TIMESTAMP = "endTimeStamp";
    @NotNull
    private static final String TRACK_EVENT_PAGE_NAME = "pageName";
    @NotNull
    private static final String TRACK_EVENT_START_TIMESTAMP = "startTimeStamp";
    @NotNull
    private static final String TRACK_EVENT_TIME_IN_MILLIS = "timeInMillis";

    /* access modifiers changed from: private */
    public static final Long calculateTimeInMillis(TimeTrackingData timeTrackingData) {
        Long endTimestamp = timeTrackingData.getEndTimestamp();
        if (endTimestamp == null) {
            return null;
        }
        long longValue = endTimestamp.longValue();
        Long startTimestamp = timeTrackingData.getStartTimestamp();
        return Long.valueOf(longValue - (startTimestamp != null ? startTimestamp.longValue() : 0));
    }
}
