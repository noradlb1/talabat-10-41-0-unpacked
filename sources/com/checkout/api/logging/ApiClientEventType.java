package com.checkout.api.logging;

import com.checkout.logging.LoggingEventType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/checkout/api/logging/ApiClientEventType;", "", "Lcom/checkout/logging/LoggingEventType;", "eventId", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "INITIALIZE", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum ApiClientEventType implements LoggingEventType {
    INITIALIZE("checkout_api_client_initialised");
    
    @NotNull
    private final String eventId;

    private ApiClientEventType(String str) {
        this.eventId = str;
    }

    @NotNull
    public String getEventId() {
        return this.eventId;
    }
}
