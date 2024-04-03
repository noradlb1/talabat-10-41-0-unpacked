package com.talabat.splash.core.extension;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00028\u0000HÂ\u0003¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u000b\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/talabat/splash/core/extension/Event;", "T", "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "<set-?>", "", "hasBeenHandled", "getHasBeenHandled", "()Z", "component1", "()Ljava/lang/Object;", "copy", "(Ljava/lang/Object;)Lcom/talabat/splash/core/extension/Event;", "equals", "other", "getContentIfNotHandledOrReturnNull", "hashCode", "", "peekContent", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Event<T> {
    private final T content;
    private boolean hasBeenHandled;

    public Event(T t11) {
        this.content = t11;
    }

    private final T component1() {
        return this.content;
    }

    public static /* synthetic */ Event copy$default(Event event, T t11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            t11 = event.content;
        }
        return event.copy(t11);
    }

    @NotNull
    public final Event<T> copy(T t11) {
        return new Event<>(t11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Event) && Intrinsics.areEqual((Object) this.content, (Object) ((Event) obj).content);
    }

    @Nullable
    public final T getContentIfNotHandledOrReturnNull() {
        if (this.hasBeenHandled) {
            return null;
        }
        this.hasBeenHandled = true;
        return this.content;
    }

    public final boolean getHasBeenHandled() {
        return this.hasBeenHandled;
    }

    public int hashCode() {
        T t11 = this.content;
        if (t11 == null) {
            return 0;
        }
        return t11.hashCode();
    }

    public final T peekContent() {
        return this.content;
    }

    @NotNull
    public String toString() {
        T t11 = this.content;
        return "Event(content=" + t11 + ")";
    }
}
