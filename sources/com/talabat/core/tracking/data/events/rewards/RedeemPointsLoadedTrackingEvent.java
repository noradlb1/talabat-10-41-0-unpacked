package com.talabat.core.tracking.data.events.rewards;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsLoadedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "redeemEventParams", "Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams;", "burnOptionId", "", "channel", "channelPosition", "", "voucherPosition", "redeemPointsAttributes", "Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsAttributes;", "(Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsAttributes;)V", "Ljava/lang/Integer;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemPointsLoadedTrackingEvent extends TalabatEvent {
    @NotNull
    private final String burnOptionId;
    @Nullable
    private final String channel;
    @Nullable
    private final Integer channelPosition;
    @NotNull
    private final RedeemEventParams redeemEventParams;
    @NotNull
    private final RedeemPointsAttributes redeemPointsAttributes;
    @Nullable
    private final Integer voucherPosition;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemPointsLoadedTrackingEvent(RedeemEventParams redeemEventParams2, String str, String str2, Integer num, Integer num2, RedeemPointsAttributes redeemPointsAttributes2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(redeemEventParams2, str, str2, num, num2, (i11 & 32) != 0 ? new RedeemPointsDefaultAttributes((TalabatGTM.Companion) null, 1, (DefaultConstructorMarker) null) : redeemPointsAttributes2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        int i11;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[4];
        int i12 = 0;
        pairArr[0] = TuplesKt.to("offerVoucherId", this.burnOptionId);
        String str = this.channel;
        if (str == null) {
            str = "N/A";
        }
        pairArr[1] = TuplesKt.to("channel", str);
        Integer num = this.channelPosition;
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        pairArr[2] = TuplesKt.to("channelPosition", Integer.valueOf(i11));
        Integer num2 = this.voucherPosition;
        if (num2 != null) {
            i12 = num2.intValue();
        }
        pairArr[3] = TuplesKt.to("voucherPosition", Integer.valueOf(i12));
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pairArr), (Map) this.redeemPointsAttributes.getAttributes(this.redeemEventParams));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rewards";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "redeem_points_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public RedeemPointsLoadedTrackingEvent(@NotNull RedeemEventParams redeemEventParams2, @NotNull String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @NotNull RedeemPointsAttributes redeemPointsAttributes2) {
        Intrinsics.checkNotNullParameter(redeemEventParams2, "redeemEventParams");
        Intrinsics.checkNotNullParameter(str, "burnOptionId");
        Intrinsics.checkNotNullParameter(redeemPointsAttributes2, "redeemPointsAttributes");
        this.redeemEventParams = redeemEventParams2;
        this.burnOptionId = str;
        this.channel = str2;
        this.channelPosition = num;
        this.voucherPosition = num2;
        this.redeemPointsAttributes = redeemPointsAttributes2;
    }
}
