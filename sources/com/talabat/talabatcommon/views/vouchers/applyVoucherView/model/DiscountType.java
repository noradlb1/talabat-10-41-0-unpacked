package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PERCENTAGE", "FLAT", "DELIVERY_PERCENTAGE", "FLAT_DELIVERY", "NONE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum DiscountType {
    PERCENTAGE("percentage"),
    FLAT(Param.FLAT),
    DELIVERY_PERCENTAGE("delivery_percentage"),
    FLAT_DELIVERY("delivery_flat"),
    NONE("");
    
    @NotNull
    private final String value;

    private DiscountType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
