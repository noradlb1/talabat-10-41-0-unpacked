package com.talabat.core.observabilityNew.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/ITimeTracker;", "", "startTracking", "", "id", "timestamp", "", "stopTracking", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITimeTracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void startTracking$default(ITimeTracker iTimeTracker, Object obj, long j11, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 2) != 0) {
                    j11 = System.currentTimeMillis();
                }
                iTimeTracker.startTracking(obj, j11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTracking");
        }

        public static /* synthetic */ void stopTracking$default(ITimeTracker iTimeTracker, Object obj, long j11, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 2) != 0) {
                    j11 = System.currentTimeMillis();
                }
                iTimeTracker.stopTracking(obj, j11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopTracking");
        }
    }

    void startTracking(@NotNull Object obj, long j11);

    void stopTracking(@NotNull Object obj, long j11);
}
