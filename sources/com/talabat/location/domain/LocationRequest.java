package com.talabat.location.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u001aR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/talabat/location/domain/LocationRequest;", "", "fastestInterval", "", "getFastestInterval", "()J", "setFastestInterval", "(J)V", "interval", "getInterval", "setInterval", "maxWaitTime", "getMaxWaitTime", "setMaxWaitTime", "numUpdates", "", "getNumUpdates", "()I", "setNumUpdates", "(I)V", "priority", "Lcom/talabat/location/domain/LocationRequest$Priority;", "getPriority", "()Lcom/talabat/location/domain/LocationRequest$Priority;", "setPriority", "(Lcom/talabat/location/domain/LocationRequest$Priority;)V", "Priority", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationRequest {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/location/domain/LocationRequest$Priority;", "", "(Ljava/lang/String;I)V", "PRIORITY_HIGH_ACCURACY", "PRIORITY_BALANCED_POWER_ACCURACY", "PRIORITY_LOW_POWER", "PRIORITY_NO_POWER", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Priority {
        PRIORITY_HIGH_ACCURACY,
        PRIORITY_BALANCED_POWER_ACCURACY,
        PRIORITY_LOW_POWER,
        PRIORITY_NO_POWER
    }

    long getFastestInterval();

    long getInterval();

    long getMaxWaitTime();

    int getNumUpdates();

    @NotNull
    Priority getPriority();

    void setFastestInterval(long j11);

    void setInterval(long j11);

    void setMaxWaitTime(long j11);

    void setNumUpdates(int i11);

    void setPriority(@NotNull Priority priority);
}
