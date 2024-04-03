package com.checkout.eventlogger.domain.model;

import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/checkout/eventlogger/domain/model/Event;", "Lkotlin/Any;", "Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "getMonitoringLevel", "()Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "monitoringLevel", "", "", "", "getProperties", "()Ljava/util/Map;", "properties", "Ljava/util/Date;", "getTime", "()Ljava/util/Date;", "time", "getTypeIdentifier", "()Ljava/lang/String;", "typeIdentifier", "logger_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public interface Event {
    @NotNull
    MonitoringLevel getMonitoringLevel();

    @NotNull
    Map<String, Object> getProperties();

    @NotNull
    Date getTime();

    @NotNull
    String getTypeIdentifier();
}
