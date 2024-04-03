package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.core.time.SystemTimeProviderImpl;
import com.deliveryhero.perseus.core.time.TimeProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/di/TimeModule;", "", "()V", "systemClock", "Lcom/deliveryhero/perseus/core/time/TimeProvider;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeModule {
    @NotNull
    public static final TimeModule INSTANCE = new TimeModule();

    private TimeModule() {
    }

    @NotNull
    public final TimeProvider systemClock() {
        return new SystemTimeProviderImpl();
    }
}
