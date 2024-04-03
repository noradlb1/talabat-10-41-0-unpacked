package com.checkout.threedsecure.logging;

import androidx.annotation.RestrictTo;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.logging.utils.HashMapExtensionKt;
import com.checkout.logging.utils.LoggingAttributesKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J9\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J3\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/checkout/threedsecure/logging/ThreeDSEventLogger;", "Lcom/checkout/threedsecure/logging/ThreeDSLogger;", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "(Lcom/checkout/logging/Logger;)V", "logCompletedEvent", "", "success", "", "token", "", "error", "", "logEvent", "eventType", "Lcom/checkout/threedsecure/logging/ThreeDSEventType;", "(Lcom/checkout/threedsecure/logging/ThreeDSEventType;Ljava/lang/Boolean;Ljava/lang/Throwable;Ljava/lang/String;)V", "logLoadedEvent", "logPresentedEvent", "provideLoggingEvent", "(Lcom/checkout/threedsecure/logging/ThreeDSEventType;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/checkout/logging/model/LoggingEvent;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThreeDSEventLogger implements ThreeDSLogger {
    @NotNull
    private final Logger<LoggingEvent> logger;

    public ThreeDSEventLogger(@NotNull Logger<LoggingEvent> logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
    }

    private final void logEvent(ThreeDSEventType threeDSEventType, Boolean bool, Throwable th2, String str) {
        this.logger.log(provideLoggingEvent(threeDSEventType, bool, str, th2));
    }

    public static /* synthetic */ void logEvent$default(ThreeDSEventLogger threeDSEventLogger, ThreeDSEventType threeDSEventType, Boolean bool, Throwable th2, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bool = null;
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        threeDSEventLogger.logEvent(threeDSEventType, bool, th2, str);
    }

    private final LoggingEvent provideLoggingEvent(ThreeDSEventType threeDSEventType, Boolean bool, String str, Throwable th2) {
        MonitoringLevel monitoringLevel;
        HashMap hashMap = new HashMap();
        if (bool != null) {
            hashMap.put("success", Boolean.valueOf(bool.booleanValue()));
        }
        if (str != null) {
            hashMap.put(LoggingAttributesKt.TOKEN_ID, str);
        }
        if (th2 != null) {
            HashMapExtensionKt.putErrorAttributes(hashMap, th2);
        }
        if (th2 == null) {
            monitoringLevel = MonitoringLevel.INFO;
        } else {
            monitoringLevel = MonitoringLevel.ERROR;
        }
        return new LoggingEvent(threeDSEventType, monitoringLevel, hashMap);
    }

    public void logCompletedEvent(boolean z11, @Nullable String str, @Nullable Throwable th2) {
        logEvent(ThreeDSEventType.COMPLETED, Boolean.valueOf(z11), th2, str);
    }

    public void logLoadedEvent(boolean z11, @Nullable Throwable th2) {
        logEvent$default(this, ThreeDSEventType.LOADED, Boolean.valueOf(z11), th2, (String) null, 8, (Object) null);
    }

    public void logPresentedEvent() {
        logEvent$default(this, ThreeDSEventType.PRESENTED, (Boolean) null, (Throwable) null, (String) null, 14, (Object) null);
    }
}
