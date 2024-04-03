package com.talabat.darkstores.data.tracking.fees;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\b\u001a4\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"getCheckoutTrackingData", "", "", "deliveryFee", "", "serviceFee", "total", "vendorId", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Ljava/util/Map;", "getFeeInfoTrackingData", "screenName", "disclaimerType", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FeeTrackingUtilsKt {
    @NotNull
    public static final Map<String, String> getCheckoutTrackingData(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str) {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("shopDeliveryFee", String.valueOf(f11)), TuplesKt.to("surchargeValue", String.valueOf(f12)), TuplesKt.to("cartValue", String.valueOf(f13)), TuplesKt.to("shopId", str));
    }

    @NotNull
    public static final Map<String, String> getFeeInfoTrackingData(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Map<String, String> mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenName", str2), TuplesKt.to("shopId", str));
        if (str3 != null) {
            mutableMapOf.put(FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE, str3);
        }
        return mutableMapOf;
    }

    public static /* synthetic */ Map getFeeInfoTrackingData$default(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return getFeeInfoTrackingData(str, str2, str3);
    }
}
