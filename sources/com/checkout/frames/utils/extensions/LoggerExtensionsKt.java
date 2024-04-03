package com.checkout.frames.utils.extensions;

import androidx.compose.ui.text.intl.Locale;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.logging.Logger;
import com.checkout.logging.LoggingEventType;
import com.checkout.logging.model.LoggingEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\b\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"LOGGING_LOCALE_KEY", "", "logEvent", "", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "event", "Lcom/checkout/logging/LoggingEventType;", "logEventWithLocale", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LoggerExtensionsKt {
    @NotNull
    public static final String LOGGING_LOCALE_KEY = "locale";

    public static final void logEvent(@NotNull Logger<LoggingEvent> logger, @NotNull LoggingEventType loggingEventType) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(loggingEventType, "event");
        logger.log(new LoggingEvent(loggingEventType, (MonitoringLevel) null, (Map) null, 6, (DefaultConstructorMarker) null));
    }

    public static final void logEventWithLocale(@NotNull Logger<LoggingEvent> logger, @NotNull LoggingEventType loggingEventType) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(loggingEventType, "event");
        Locale.Companion companion = Locale.Companion;
        String language = companion.getCurrent().getLanguage();
        String region = companion.getCurrent().getRegion();
        logger.log(new LoggingEvent(loggingEventType, (MonitoringLevel) null, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("locale", language + JavaConstant.Dynamic.DEFAULT_NAME + region)), 2, (DefaultConstructorMarker) null));
    }
}
