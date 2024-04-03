package com.checkout.logging;

import com.checkout.BuildConfig;
import com.checkout.eventlogger.CheckoutEventLogger;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/checkout/logging/EventLogger;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class EventLoggerProvider$eventLogger$2 extends Lambda implements Function0<EventLogger> {
    public static final EventLoggerProvider$eventLogger$2 INSTANCE = new EventLoggerProvider$eventLogger$2();

    public EventLoggerProvider$eventLogger$2() {
        super(0);
    }

    @NotNull
    public final EventLogger invoke() {
        CheckoutEventLogger checkoutEventLogger = new CheckoutEventLogger(BuildConfig.PRODUCT_NAME);
        Boolean bool = BuildConfig.DEFAULT_LOGCAT_MONITORING_ENABLED;
        Intrinsics.checkNotNullExpressionValue(bool, "DEFAULT_LOGCAT_MONITORING_ENABLED");
        if (bool.booleanValue()) {
            checkoutEventLogger.enableLocalProcessor(MonitoringLevel.DEBUG);
        }
        return new EventLogger(checkoutEventLogger);
    }
}
