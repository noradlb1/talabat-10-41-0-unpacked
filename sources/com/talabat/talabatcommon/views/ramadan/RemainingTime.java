package com.talabat.talabatcommon.views.ramadan;

import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/ramadan/RemainingTime;", "", "hours", "", "minutes", "(JJ)V", "getHours", "()J", "setHours", "(J)V", "getMinutes", "setMinutes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemainingTime {
    private long hours;
    private long minutes;

    public RemainingTime(long j11, long j12) {
        this.hours = j11;
        this.minutes = j12;
    }

    public static /* synthetic */ RemainingTime copy$default(RemainingTime remainingTime, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = remainingTime.hours;
        }
        if ((i11 & 2) != 0) {
            j12 = remainingTime.minutes;
        }
        return remainingTime.copy(j11, j12);
    }

    public final long component1() {
        return this.hours;
    }

    public final long component2() {
        return this.minutes;
    }

    @NotNull
    public final RemainingTime copy(long j11, long j12) {
        return new RemainingTime(j11, j12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemainingTime)) {
            return false;
        }
        RemainingTime remainingTime = (RemainingTime) obj;
        return this.hours == remainingTime.hours && this.minutes == remainingTime.minutes;
    }

    public final long getHours() {
        return this.hours;
    }

    public final long getMinutes() {
        return this.minutes;
    }

    public int hashCode() {
        return (a.a(this.hours) * 31) + a.a(this.minutes);
    }

    public final void setHours(long j11) {
        this.hours = j11;
    }

    public final void setMinutes(long j11) {
        this.minutes = j11;
    }

    @NotNull
    public String toString() {
        long j11 = this.hours;
        long j12 = this.minutes;
        return "RemainingTime(hours=" + j11 + ", minutes=" + j12 + ")";
    }
}
