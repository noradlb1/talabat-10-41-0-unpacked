package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import com.talabat.homescreen.network.UrlConstantsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VOUCHER", "REDEEM_OPTION", "NONE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum VoucherType {
    VOUCHER(UrlConstantsKt.HEADER_VOUCHER),
    REDEEM_OPTION("redeem_option"),
    NONE("");
    
    @NotNull
    private final String value;

    private VoucherType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
