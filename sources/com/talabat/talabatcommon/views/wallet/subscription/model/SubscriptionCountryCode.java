package com.talabat.talabatcommon.views.wallet.subscription.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCountryCode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "KWT_ISO_CODE", "KSA_ISO_CODE", "BHR_ISO_CODE", "UAE_ISO_CODE", "OMN_ISO_CODE", "QAT_ISO_CODE", "LBN_ISO_CODE", "JOR_ISO_CODE", "EGP_ISO_CODE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SubscriptionCountryCode {
    KWT_ISO_CODE("KWT"),
    KSA_ISO_CODE("SAU"),
    BHR_ISO_CODE("BHR"),
    UAE_ISO_CODE("ARE"),
    OMN_ISO_CODE("OMN"),
    QAT_ISO_CODE("QAT"),
    LBN_ISO_CODE("LBN"),
    JOR_ISO_CODE("JOR"),
    EGP_ISO_CODE("EGY");
    
    @NotNull
    private final String value;

    private SubscriptionCountryCode(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
