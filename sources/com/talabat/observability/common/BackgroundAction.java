package com.talabat.observability.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/observability/common/BackgroundAction;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TRACK_API_POLLING_TICK", "TRACK_AUTH_TOKEN_GOT_NULL", "TRACK_FWF_CACHE_FILL", "START_SEND_BIRD_CHAT", "TRACK_FWF_TRACKING_EVENTS", "MENU_DISCOUNTS_EVENTS", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum BackgroundAction {
    TRACK_API_POLLING_TICK("track_api_polling_tick"),
    TRACK_AUTH_TOKEN_GOT_NULL("track_auth_token_got_null"),
    TRACK_FWF_CACHE_FILL("track_fwf_cache_fill"),
    START_SEND_BIRD_CHAT("start_sendbird_chat"),
    TRACK_FWF_TRACKING_EVENTS("fwf_tracking_events"),
    MENU_DISCOUNTS_EVENTS("menu_discounts_events");
    
    @NotNull
    private final String value;

    private BackgroundAction(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
