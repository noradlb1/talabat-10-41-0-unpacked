package com.talabat.feature.ridertips.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/ridertips/data/tracking/events/DisclaimerClicked;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "disclaimerType", "", "(Ljava/lang/String;)V", "getDisclaimerType", "()Ljava/lang/String;", "setDisclaimerType", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DisclaimerClicked extends TalabatEvent {
    @Nullable
    private String disclaimerType;

    public DisclaimerClicked(@Nullable String str) {
        this.disclaimerType = str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to(FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE, this.disclaimerType));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "riderTip";
    }

    @Nullable
    public final String getDisclaimerType() {
        return this.disclaimerType;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_DISCLAIMER_CLICKED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public final void setDisclaimerType(@Nullable String str) {
        this.disclaimerType = str;
    }
}
