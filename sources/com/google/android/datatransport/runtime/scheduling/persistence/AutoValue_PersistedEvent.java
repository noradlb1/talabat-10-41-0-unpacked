package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

final class AutoValue_PersistedEvent extends PersistedEvent {
    private final EventInternal event;

    /* renamed from: id  reason: collision with root package name */
    private final long f33632id;
    private final TransportContext transportContext;

    public AutoValue_PersistedEvent(long j11, TransportContext transportContext2, EventInternal eventInternal) {
        this.f33632id = j11;
        if (transportContext2 != null) {
            this.transportContext = transportContext2;
            if (eventInternal != null) {
                this.event = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f33632id != persistedEvent.getId() || !this.transportContext.equals(persistedEvent.getTransportContext()) || !this.event.equals(persistedEvent.getEvent())) {
            return false;
        }
        return true;
    }

    public EventInternal getEvent() {
        return this.event;
    }

    public long getId() {
        return this.f33632id;
    }

    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    public int hashCode() {
        long j11 = this.f33632id;
        return ((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003) ^ this.event.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f33632id + ", transportContext=" + this.transportContext + ", event=" + this.event + "}";
    }
}
