package com.talabat.feature.fees.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import com.talabat.feature.fees.domain.IFeesTracker;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/fees/data/tracking/FeesTracker;", "Lcom/talabat/feature/fees/domain/IFeesTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "shopId", "", "(Lcom/talabat/core/tracking/domain/TalabatTracker;I)V", "onContinueOrderClicked", "", "screenName", "", "onDeliveryFeeInfoClicked", "onGeneralFeesInfoClicked", "onReadMoreExternalInfoClicked", "onServiceFeeInfoClicked", "onSmallOrderFeeInfoClicked", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesTracker implements IFeesTracker {
    private final int shopId;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public FeesTracker(@NotNull TalabatTracker talabatTracker2, @Named("branchId") int i11) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
        this.shopId = i11;
    }

    public void onContinueOrderClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.talabatTracker.track(new ZeroDeliveryFee(str));
    }

    public void onDeliveryFeeInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.talabatTracker.track(new InfoClicked("deliveryFeeInfo", str, this.shopId));
    }

    public void onGeneralFeesInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.talabatTracker.track(new InfoClicked("generalFeesInfo", str, this.shopId));
    }

    public void onReadMoreExternalInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.talabatTracker.track(new InfoClicked(FeeTrackingConstantsKt.DISCLAIMER_GENERAL_FEES_EXTERNAL, str, this.shopId));
    }

    public void onServiceFeeInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.talabatTracker.track(new InfoClicked("serviceFeeInfo", str, this.shopId));
    }

    public void onSmallOrderFeeInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.talabatTracker.track(new InfoClicked("smallOrderFeeInfo", str, this.shopId));
    }
}
