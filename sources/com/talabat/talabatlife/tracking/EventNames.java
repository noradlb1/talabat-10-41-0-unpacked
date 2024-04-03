package com.talabat.talabatlife.tracking;

import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/talabatlife/tracking/EventNames;", "", "eventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "WAIT_LIST_CLICKED", "ON_BOARDING_SCREEN_LOADED", "SUBSCRIPTION_CLICKED", "SUBSCRIPTION_ATTEMPTED", "SUBSCRIPTION_COMPLETED", "SUBSCRIPTION_FAILED", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EventNames {
    WAIT_LIST_CLICKED("life_waitlist_clicked"),
    ON_BOARDING_SCREEN_LOADED("life_onboarding_loaded"),
    SUBSCRIPTION_CLICKED("subscription_clicked"),
    SUBSCRIPTION_ATTEMPTED(TProEvent.NAME_SUBSCRIPTION_ATTEMPTED),
    SUBSCRIPTION_COMPLETED(TProEvent.NAME_SUBSCRIPTION_COMPLETED),
    SUBSCRIPTION_FAILED(TProEvent.NAME_SUBSCRIPTION_FAILED);
    
    @NotNull
    private final String eventName;

    private EventNames(String str) {
        this.eventName = str;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }
}
