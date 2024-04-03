package com.talabat.core.observabilityNew.domain.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/common/UserAction;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TAP", "LONG_TAP", "BACK_PRESS", "APP_OPEN", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum UserAction {
    TAP("tap"),
    LONG_TAP("long_tap"),
    BACK_PRESS("back_press"),
    APP_OPEN("app_opened");
    
    @NotNull
    private final String value;

    private UserAction(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
