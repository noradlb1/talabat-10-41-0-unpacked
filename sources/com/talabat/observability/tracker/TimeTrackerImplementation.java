package com.talabat.observability.tracker;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001BK\b\u0000\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004`\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "", "timesCache", "Ljava/util/HashMap;", "Lcom/talabat/observability/tracker/TimeTrackingData;", "Lkotlin/collections/HashMap;", "trackEvent", "Lkotlin/Function2;", "", "(Ljava/util/HashMap;Lkotlin/jvm/functions/Function2;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "startTracking", "id", "timestamp", "", "stopTracking", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeTrackerImplementation {
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final HashMap<Object, TimeTrackingData> timesCache;
    @NotNull
    private final Function2<Object, TimeTrackingData, Unit> trackEvent;

    public TimeTrackerImplementation() {
        this((HashMap) null, (Function2) null, 3, (DefaultConstructorMarker) null);
    }

    public TimeTrackerImplementation(@NotNull HashMap<Object, TimeTrackingData> hashMap, @NotNull Function2<Object, ? super TimeTrackingData, Unit> function2) {
        Intrinsics.checkNotNullParameter(hashMap, "timesCache");
        Intrinsics.checkNotNullParameter(function2, AnalyticsMethodChannel.TRACK_METHOD_CALL_FLUTTER_EVENT);
        this.timesCache = hashMap;
        this.trackEvent = function2;
        this.lock = new ReentrantLock();
    }

    public static /* synthetic */ void startTracking$default(TimeTrackerImplementation timeTrackerImplementation, Object obj, long j11, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            j11 = System.currentTimeMillis();
        }
        timeTrackerImplementation.startTracking(obj, j11);
    }

    public static /* synthetic */ void stopTracking$default(TimeTrackerImplementation timeTrackerImplementation, Object obj, long j11, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            j11 = System.currentTimeMillis();
        }
        timeTrackerImplementation.stopTracking(obj, j11);
    }

    @JvmOverloads
    public final void startTracking(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "id");
        startTracking$default(this, obj, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final void startTracking(@NotNull Object obj, long j11) {
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

    @JvmOverloads
    public final void stopTracking(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "id");
        stopTracking$default(this, obj, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final void stopTracking(@NotNull Object obj, long j11) {
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
                        this.trackEvent.invoke(obj, copy$default);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeTrackerImplementation(HashMap hashMap, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : hashMap, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function2);
    }
}
