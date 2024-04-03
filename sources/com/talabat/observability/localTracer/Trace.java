package com.talabat.observability.localTracer;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/talabat/observability/localTracer/Trace;", "", "pointOfInterest", "", "sectionOfInterest", "(Ljava/lang/String;Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "<set-?>", "endTime", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getPointOfInterest", "()Ljava/lang/String;", "getSectionOfInterest", "startTime", "getStartTime", "start", "", "stop", "Companion", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Trace {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private Long endTime;
    @NotNull
    private final ReentrantLock lock = new ReentrantLock();
    @NotNull
    private String pointOfInterest;
    @NotNull
    private String sectionOfInterest;
    @Nullable
    private Long startTime;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/observability/localTracer/Trace$Companion;", "", "()V", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Trace(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Param.POINT_OF_INTEREST);
        Intrinsics.checkNotNullParameter(str2, "sectionOfInterest");
        this.sectionOfInterest = str2;
        this.pointOfInterest = str;
    }

    public final long getDuration() {
        long j11;
        this.lock.lock();
        try {
            Long l11 = this.endTime;
            long j12 = 0;
            if (l11 != null) {
                j11 = l11.longValue();
            } else {
                j11 = 0;
            }
            Long l12 = this.startTime;
            if (l12 != null) {
                j12 = l12.longValue();
            }
            return j11 - j12;
        } finally {
            this.lock.unlock();
        }
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getPointOfInterest() {
        return this.pointOfInterest;
    }

    @NotNull
    public final String getSectionOfInterest() {
        return this.sectionOfInterest;
    }

    @Nullable
    public final Long getStartTime() {
        return this.startTime;
    }

    public final void start() {
        boolean z11;
        this.lock.lock();
        try {
            if (this.startTime != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                this.startTime = Long.valueOf(System.currentTimeMillis());
                this.lock.unlock();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public final void stop() {
        boolean z11;
        this.lock.lock();
        try {
            if (this.endTime != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                this.endTime = Long.valueOf(System.currentTimeMillis());
                this.lock.unlock();
            }
        } finally {
            this.lock.unlock();
        }
    }
}
