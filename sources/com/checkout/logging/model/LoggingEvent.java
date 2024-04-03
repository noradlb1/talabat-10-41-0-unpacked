package com.checkout.logging.model;

import androidx.annotation.RestrictTo;
import com.braze.models.FeatureFlag;
import com.checkout.eventlogger.domain.model.Event;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.logging.LoggingEventType;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/checkout/logging/model/LoggingEvent;", "Lcom/checkout/eventlogger/domain/model/Event;", "eventType", "Lcom/checkout/logging/LoggingEventType;", "monitoringLevel", "Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "properties", "", "", "", "(Lcom/checkout/logging/LoggingEventType;Lcom/checkout/eventlogger/domain/model/MonitoringLevel;Ljava/util/Map;)V", "getEventType$checkout_release", "()Lcom/checkout/logging/LoggingEventType;", "getMonitoringLevel", "()Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "getProperties", "()Ljava/util/Map;", "time", "Ljava/util/Date;", "getTime", "()Ljava/util/Date;", "typeIdentifier", "getTypeIdentifier", "()Ljava/lang/String;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class LoggingEvent implements Event {
    @NotNull
    private final LoggingEventType eventType;
    @NotNull
    private final MonitoringLevel monitoringLevel;
    @NotNull
    private final Map<String, Object> properties;
    @NotNull
    private final Date time;
    @NotNull
    private final String typeIdentifier;

    public LoggingEvent(@NotNull LoggingEventType loggingEventType, @NotNull MonitoringLevel monitoringLevel2, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(loggingEventType, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(monitoringLevel2, "monitoringLevel");
        Intrinsics.checkNotNullParameter(map, FeatureFlag.PROPERTIES);
        this.eventType = loggingEventType;
        this.monitoringLevel = monitoringLevel2;
        this.properties = map;
        this.time = new Date();
        this.typeIdentifier = loggingEventType.getEventId();
    }

    @NotNull
    public final LoggingEventType getEventType$checkout_release() {
        return this.eventType;
    }

    @NotNull
    public MonitoringLevel getMonitoringLevel() {
        return this.monitoringLevel;
    }

    @NotNull
    public Map<String, Object> getProperties() {
        return this.properties;
    }

    @NotNull
    public Date getTime() {
        return this.time;
    }

    @NotNull
    public String getTypeIdentifier() {
        return this.typeIdentifier;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoggingEvent(LoggingEventType loggingEventType, MonitoringLevel monitoringLevel2, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(loggingEventType, (i11 & 2) != 0 ? MonitoringLevel.INFO : monitoringLevel2, (i11 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
