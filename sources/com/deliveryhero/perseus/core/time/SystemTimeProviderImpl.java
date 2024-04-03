package com.deliveryhero.perseus.core.time;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/core/time/SystemTimeProviderImpl;", "Lcom/deliveryhero/perseus/core/time/TimeProvider;", "()V", "getCurrentTime", "Ljava/util/Calendar;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemTimeProviderImpl implements TimeProvider {
    @NotNull
    public Calendar getCurrentTime() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }
}
