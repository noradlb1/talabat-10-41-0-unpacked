package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.serjltt.moshi.adapters.FallbackEnum;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardError;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PAY_BNPL_CARD_DELETION_ERROR", "NONE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@FallbackEnum(name = "NONE")
public enum WalletDeleteCardError {
    PAY_BNPL_CARD_DELETION_ERROR("PAY-BNPL-CARD-DELETION-ERROR"),
    NONE("");
    
    @NotNull
    private final String value;

    private WalletDeleteCardError(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
