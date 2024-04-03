package com.deliveryhero.customerchat.telephony.domain.voipAnalytics;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;", "", "(Ljava/lang/String;I)V", "toString", "", "Success", "Failure", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum CallRegistrationStatus {
    Success,
    Failure;

    @NotNull
    public String toString() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }
}
