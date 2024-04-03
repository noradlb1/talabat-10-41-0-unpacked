package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"EVENT_NAME", "", "orDefault", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PromoCodeSubmitFailedEventKt {
    @NotNull
    private static final String EVENT_NAME = "order_coupon_failed";

    /* access modifiers changed from: private */
    public static final String orDefault(String str) {
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            str = null;
        }
        return str == null ? "N/A" : str;
    }
}
