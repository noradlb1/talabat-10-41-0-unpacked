package com.talabat.feature.pharmacy.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/pharmacy/tracking/PharmacyPrescriptionsEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "chainId", "", "chainName", "(Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "Lcom/talabat/feature/pharmacy/tracking/PrescriptionBannerLoaded;", "Lcom/talabat/feature/pharmacy/tracking/PrescriptionBannerClicked;", "Lcom/talabat/feature/pharmacy/tracking/PrescriptionStatusLoaded;", "Lcom/talabat/feature/pharmacy/tracking/PrescriptionStatusClicked;", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PharmacyPrescriptionsEvent extends TalabatEvent {
    @NotNull
    private final String chainId;
    @NotNull
    private final String chainName;

    private PharmacyPrescriptionsEvent(String str, String str2) {
        this.chainId = str;
        this.chainName = str2;
    }

    public /* synthetic */ PharmacyPrescriptionsEvent(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", "restaurants list"), TuplesKt.to("chainName", this.chainName), TuplesKt.to("chainId", this.chainId));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pharmacy_prescription_feature";
    }
}
