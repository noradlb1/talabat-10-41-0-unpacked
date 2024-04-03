package com.checkout.logging;

import androidx.annotation.RestrictTo;
import com.checkout.logging.model.LoggingEvent;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/checkout/logging/EventLoggerProvider;", "", "()V", "eventLogger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "getEventLogger", "()Lcom/checkout/logging/Logger;", "eventLogger$delegate", "Lkotlin/Lazy;", "provide", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class EventLoggerProvider {
    @NotNull
    public static final EventLoggerProvider INSTANCE = new EventLoggerProvider();
    @NotNull
    private static final Lazy eventLogger$delegate = LazyKt__LazyJVMKt.lazy(EventLoggerProvider$eventLogger$2.INSTANCE);

    private EventLoggerProvider() {
    }

    private final Logger<LoggingEvent> getEventLogger() {
        return (Logger) eventLogger$delegate.getValue();
    }

    @NotNull
    public final Logger<LoggingEvent> provide() {
        return getEventLogger();
    }
}
