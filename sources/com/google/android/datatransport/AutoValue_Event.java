package com.google.android.datatransport;

import androidx.annotation.Nullable;

final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final T payload;
    private final Priority priority;

    public AutoValue_Event(@Nullable Integer num, T t11, Priority priority2) {
        this.code = num;
        if (t11 != null) {
            this.payload = t11;
            if (priority2 != null) {
                this.priority = priority2;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Integer getCode() {
        return this.code;
    }

    public T getPayload() {
        return this.payload;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public int hashCode() {
        int i11;
        Integer num = this.code;
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.hashCode();
        }
        return ((((i11 ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + "}";
    }
}
