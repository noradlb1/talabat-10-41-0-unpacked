package com.talabat.core.experiment.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/core/experiment/domain/FWFAttributes;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "AREA_ID", "VERTICAL_ID", "LOCATION_COUNTRY", "PILOT_TARGETING_ID", "USER_LOGGED_IN", "VENDOR_ID", "com_talabat_core_experiment_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum FWFAttributes {
    AREA_ID("areaId"),
    VERTICAL_ID("verticalId"),
    LOCATION_COUNTRY("locationCountry"),
    PILOT_TARGETING_ID("pilotTargetingId"),
    USER_LOGGED_IN("userLoggedIn"),
    VENDOR_ID("vendorid");
    
    @NotNull
    private final String key;

    private FWFAttributes(String str) {
        this.key = str;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
