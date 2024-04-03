package com.talabat.core.tracking.data.events.rewards;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsCompletedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "redeemEventParams", "Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams;", "creditAmountAdd", "", "redeemPointsAttributes", "Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsAttributes;", "(Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams;Ljava/lang/Float;Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsAttributes;)V", "Ljava/lang/Float;", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemPointsCompletedTrackingEvent extends TalabatEvent {
    @Nullable
    private final Float creditAmountAdd;
    @NotNull
    private final RedeemEventParams redeemEventParams;
    @NotNull
    private final RedeemPointsAttributes redeemPointsAttributes;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemPointsCompletedTrackingEvent(RedeemEventParams redeemEventParams2, Float f11, RedeemPointsAttributes redeemPointsAttributes2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(redeemEventParams2, f11, (i11 & 4) != 0 ? new RedeemPointsDefaultAttributes((TalabatGTM.Companion) null, 1, (DefaultConstructorMarker) null) : redeemPointsAttributes2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(TuplesKt.to("creditAmountAdd", String.valueOf(this.creditAmountAdd)), TuplesKt.to("currencyCode", TalabatAdjust.getSelectedCurrencyCode())), (Map) this.redeemPointsAttributes.getAttributes(this.redeemEventParams));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rewards";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "redeem_points_completed";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public RedeemPointsCompletedTrackingEvent(@NotNull RedeemEventParams redeemEventParams2, @Nullable Float f11, @NotNull RedeemPointsAttributes redeemPointsAttributes2) {
        Intrinsics.checkNotNullParameter(redeemEventParams2, "redeemEventParams");
        Intrinsics.checkNotNullParameter(redeemPointsAttributes2, "redeemPointsAttributes");
        this.redeemEventParams = redeemEventParams2;
        this.creditAmountAdd = f11;
        this.redeemPointsAttributes = redeemPointsAttributes2;
    }
}
