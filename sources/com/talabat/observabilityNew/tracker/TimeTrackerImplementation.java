package com.talabat.observabilityNew.tracker;

import com.talabat.core.observabilityNew.data.di.TimeCacheMap;
import com.talabat.core.observabilityNew.domain.ITimeTracker;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.observabilityNew.ObservabilityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\b\u0001\u0012$\b\u0001\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/observabilityNew/tracker/TimeTrackerImplementation;", "Lcom/talabat/core/observabilityNew/domain/ITimeTracker;", "timesCache", "Ljava/util/HashMap;", "", "Lcom/talabat/observabilityNew/tracker/TimeTrackingData;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "observabilityManager", "Lcom/talabat/observabilityNew/ObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/observabilityNew/ObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/observabilityNew/ObservabilityManager;)V", "startTracking", "", "id", "timestamp", "", "stopTracking", "trackEvent", "timeTracking", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeTrackerImplementation implements ITimeTracker {
    @NotNull
    private final ReentrantLock lock = new ReentrantLock();
    @Inject
    public ObservabilityManager observabilityManager;
    @NotNull
    private final HashMap<Object, TimeTrackingData> timesCache;

    @Inject
    public TimeTrackerImplementation(@NotNull @TimeCacheMap HashMap<Object, TimeTrackingData> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "timesCache");
        this.timesCache = hashMap;
    }

    private final void trackEvent(Object obj, TimeTrackingData timeTrackingData) {
        Long l11;
        Long l12;
        ObservabilityManager observabilityManager2 = getObservabilityManager();
        String obj2 = obj.toString();
        String name2 = EventType.TimeTracking.name();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("pageName", obj.toString());
        Long l13 = null;
        if (timeTrackingData != null) {
            l11 = timeTrackingData.getStartTimestamp();
        } else {
            l11 = null;
        }
        pairArr[1] = TuplesKt.to("startTimeStamp", String.valueOf(l11));
        if (timeTrackingData != null) {
            l12 = timeTrackingData.getEndTimestamp();
        } else {
            l12 = null;
        }
        pairArr[2] = TuplesKt.to("endTimeStamp", String.valueOf(l12));
        if (timeTrackingData != null) {
            l13 = TimeTrackerKt.calculateTimeInMillis(timeTrackingData);
        }
        pairArr[3] = TuplesKt.to("timeInMillis", String.valueOf(l13));
        observabilityManager2.trackEvent(obj2, name2, (Map<String, String>) MapsKt__MapsKt.mapOf(pairArr));
    }

    @NotNull
    public final ObservabilityManager getObservabilityManager() {
        ObservabilityManager observabilityManager2 = this.observabilityManager;
        if (observabilityManager2 != null) {
            return observabilityManager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    public final void setObservabilityManager(@NotNull ObservabilityManager observabilityManager2) {
        Intrinsics.checkNotNullParameter(observabilityManager2, "<set-?>");
        this.observabilityManager = observabilityManager2;
    }

    public void startTracking(@NotNull Object obj, long j11) {
        Intrinsics.checkNotNullParameter(obj, "id");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.timesCache.put(obj, new TimeTrackingData(Long.valueOf(j11), (Long) null, 2, (DefaultConstructorMarker) null));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void stopTracking(@NotNull Object obj, long j11) {
        Object obj2;
        Intrinsics.checkNotNullParameter(obj, "id");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            TimeTrackingData timeTrackingData = this.timesCache.get(obj);
            if (timeTrackingData != null) {
                Intrinsics.checkNotNullExpressionValue(timeTrackingData, "timesCache[id]");
                TimeTrackingData copy$default = TimeTrackingData.copy$default(timeTrackingData, (Long) null, Long.valueOf(j11), 1, (Object) null);
                if (copy$default != null) {
                    this.timesCache.put(obj, copy$default);
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    try {
                        Result.Companion companion = Result.Companion;
                        trackEvent(obj, copy$default);
                        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable r42 = Result.m6332exceptionOrNullimpl(obj2);
                    if (r42 != null) {
                        r42.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
