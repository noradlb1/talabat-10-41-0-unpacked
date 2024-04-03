package com.talabat.feature.ridertips.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.feature.ridertips.data.tracking.events.DisclaimerClicked;
import com.talabat.feature.ridertips.data.tracking.events.RiderTipClicked;
import com.talabat.feature.ridertips.data.tracking.events.RiderTipLoaded;
import com.talabat.feature.ridertips.data.tracking.events.RiderTipOpened;
import com.talabat.feature.ridertips.data.tracking.events.RiderTipRemoved;
import com.talabat.feature.ridertips.data.tracking.events.RiderTipSaved;
import com.talabat.feature.ridertips.data.tracking.events.RiderTipUnsaved;
import com.talabat.feature.ridertips.domain.IRiderTipTracker;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J+\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0011J+\u0010\u0012\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ+\u0010\u0013\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ+\u0010\u0014\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ+\u0010\u0015\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/ridertips/data/tracking/RiderTipTracker;", "Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "shopId", "", "(Lcom/talabat/core/tracking/domain/TalabatTracker;I)V", "disclaimerClicked", "", "onRiderTipClicked", "riderTipValue", "", "tipClickOrigin", "", "screenName", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "onRiderTipLoaded", "(Ljava/lang/Double;Ljava/lang/String;)V", "onRiderTipOpened", "onRiderTipRemoved", "onRiderTipSaved", "onRiderTipUnsaved", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipTracker implements IRiderTipTracker {
    private final int shopId;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public RiderTipTracker(@NotNull TalabatTracker talabatTracker2, @Named("shopId") int i11) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
        this.shopId = i11;
    }

    public void disclaimerClicked() {
        this.talabatTracker.track(new DisclaimerClicked("riderTipInfoSheet"));
    }

    public void onRiderTipClicked(@Nullable Double d11, @Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new RiderTipClicked(d11, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, str2, Integer.valueOf(this.shopId), str));
    }

    public void onRiderTipLoaded(@Nullable Double d11, @Nullable String str) {
        this.talabatTracker.track(new RiderTipLoaded(d11, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, str, Integer.valueOf(this.shopId)));
    }

    public void onRiderTipOpened(@Nullable Double d11, @Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new RiderTipOpened(d11, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, str2, Integer.valueOf(this.shopId), str));
    }

    public void onRiderTipRemoved(@Nullable Double d11, @Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new RiderTipRemoved(d11, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, str2, Integer.valueOf(this.shopId), str));
    }

    public void onRiderTipSaved(@Nullable Double d11, @Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new RiderTipSaved(d11, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, str2, Integer.valueOf(this.shopId), str));
    }

    public void onRiderTipUnsaved(@Nullable Double d11, @Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new RiderTipUnsaved(d11, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, str2, Integer.valueOf(this.shopId), str));
    }
}
