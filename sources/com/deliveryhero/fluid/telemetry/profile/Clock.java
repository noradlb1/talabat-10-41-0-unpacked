package com.deliveryhero.fluid.telemetry.profile;

import android.os.SystemClock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/Clock;", "", "()V", "uptimeMillis", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Clock {
    @NotNull
    public static final Clock INSTANCE = new Clock();

    private Clock() {
    }

    public final long uptimeMillis() {
        return SystemClock.elapsedRealtime();
    }
}
