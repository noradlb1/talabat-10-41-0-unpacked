package com.talabat.darkstores.feature.observability;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/observability/PerformanceAttribute;", "", "()V", "TimeToLoad", "Lcom/talabat/darkstores/feature/observability/PerformanceAttribute$TimeToLoad;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PerformanceAttribute {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/observability/PerformanceAttribute$TimeToLoad;", "Lcom/talabat/darkstores/feature/observability/PerformanceAttribute;", "loadTime", "", "(J)V", "getLoadTime", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TimeToLoad extends PerformanceAttribute {
        private final long loadTime;

        public TimeToLoad(long j11) {
            super((DefaultConstructorMarker) null);
            this.loadTime = j11;
        }

        public static /* synthetic */ TimeToLoad copy$default(TimeToLoad timeToLoad, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = timeToLoad.loadTime;
            }
            return timeToLoad.copy(j11);
        }

        public final long component1() {
            return this.loadTime;
        }

        @NotNull
        public final TimeToLoad copy(long j11) {
            return new TimeToLoad(j11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimeToLoad) && this.loadTime == ((TimeToLoad) obj).loadTime;
        }

        public final long getLoadTime() {
            return this.loadTime;
        }

        public int hashCode() {
            return a.a(this.loadTime);
        }

        @NotNull
        public String toString() {
            long j11 = this.loadTime;
            return "TimeToLoad(loadTime=" + j11 + ")";
        }
    }

    private PerformanceAttribute() {
    }

    public /* synthetic */ PerformanceAttribute(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
