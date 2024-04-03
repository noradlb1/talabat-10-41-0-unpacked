package com.talabat.observability.tracker;

import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.EventType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"NO_TIME_MILLIS", "", "TRACK_EVENT_END_TIMESTAMP", "", "TRACK_EVENT_PAGE_NAME", "TRACK_EVENT_START_TIMESTAMP", "TRACK_EVENT_TIME_IN_MILLIS", "TimeTracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "getTimeTracker", "()Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "TimeTracker$delegate", "Lkotlin/Lazy;", "trackEvent", "", "id", "", "timeTracking", "Lcom/talabat/observability/tracker/TimeTrackingData;", "calculateTimeInMillis", "(Lcom/talabat/observability/tracker/TimeTrackingData;)Ljava/lang/Long;", "com_talabat_NewArchi_Observability_Observability"}, k = 2, mv = {1, 6, 0}, xi = 48)
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
    @NotNull
    private static final Lazy TimeTracker$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, TimeTrackerKt$TimeTracker$2.INSTANCE);

    private static final Long calculateTimeInMillis(TimeTrackingData timeTrackingData) {
        Long endTimestamp = timeTrackingData.getEndTimestamp();
        if (endTimestamp == null) {
            return null;
        }
        long longValue = endTimestamp.longValue();
        Long startTimestamp = timeTrackingData.getStartTimestamp();
        return Long.valueOf(longValue - (startTimestamp != null ? startTimestamp.longValue() : 0));
    }

    @NotNull
    public static final TimeTrackerImplementation getTimeTracker() {
        return (TimeTrackerImplementation) TimeTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void trackEvent(Object obj, TimeTrackingData timeTrackingData) {
        Long l11;
        Long l12;
        String obj2 = obj.toString();
        String name2 = EventType.TimeTracking.name();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(TRACK_EVENT_PAGE_NAME, obj.toString());
        Long l13 = null;
        if (timeTrackingData != null) {
            l11 = timeTrackingData.getStartTimestamp();
        } else {
            l11 = null;
        }
        pairArr[1] = TuplesKt.to(TRACK_EVENT_START_TIMESTAMP, String.valueOf(l11));
        if (timeTrackingData != null) {
            l12 = timeTrackingData.getEndTimestamp();
        } else {
            l12 = null;
        }
        pairArr[2] = TuplesKt.to(TRACK_EVENT_END_TIMESTAMP, String.valueOf(l12));
        if (timeTrackingData != null) {
            l13 = calculateTimeInMillis(timeTrackingData);
        }
        pairArr[3] = TuplesKt.to(TRACK_EVENT_TIME_IN_MILLIS, String.valueOf(l13));
        ObservabilityManager.trackEvent(obj2, name2, (Map<String, String>) MapsKt__MapsKt.mapOf(pairArr));
    }
}
