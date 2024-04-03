package com.talabat.core.tracking.data.events.rewards;

import android.content.Context;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.LoggedInHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsDefaultAttributes;", "Lcom/talabat/core/tracking/data/events/rewards/RedeemPointsAttributes;", "talabatGTM", "Ltracking/gtm/TalabatGTM$Companion;", "(Ltracking/gtm/TalabatGTM$Companion;)V", "getAttributes", "", "", "", "redeemEventParams", "Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams;", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemPointsDefaultAttributes implements RedeemPointsAttributes {
    @NotNull
    private final TalabatGTM.Companion talabatGTM;

    public RedeemPointsDefaultAttributes() {
        this((TalabatGTM.Companion) null, 1, (DefaultConstructorMarker) null);
    }

    public RedeemPointsDefaultAttributes(@NotNull TalabatGTM.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "talabatGTM");
        this.talabatGTM = companion;
    }

    @NotNull
    public Map<String, Object> getAttributes(@NotNull RedeemEventParams redeemEventParams) {
        boolean z11;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(redeemEventParams, "redeemEventParams");
        Pair[] pairArr = new Pair[14];
        boolean z12 = false;
        pairArr[0] = TuplesKt.to("redeemOption", redeemEventParams.getTitle());
        pairArr[1] = TuplesKt.to("userOnlinePaymentMethods", "credit:" + this.talabatGTM.getTalabatCreditBalance() + ", rewardpoints:" + redeemEventParams.getPoints());
        pairArr[2] = TuplesKt.to("locationCountry", TalabatAdjust.getSelectedCountryIso());
        pairArr[3] = TuplesKt.to("locationAddress", TalabatGTM.Companion.getLocationAddress$default(this.talabatGTM, (Context) null, 1, (Object) null));
        String str3 = GlobalDataModel.SelectedCityName;
        if (str3 == null || str3.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str4 = "N/A";
        if (z11) {
            str = str4;
        } else {
            str = GlobalDataModel.SelectedCityName;
        }
        pairArr[4] = TuplesKt.to("locationCity", str);
        pairArr[5] = TuplesKt.to("locationLat", this.talabatGTM.getLocationLatitude());
        pairArr[6] = TuplesKt.to("locationLon", this.talabatGTM.getLocationLongitude());
        pairArr[7] = TuplesKt.to("locationArea", String.valueOf(GlobalDataModel.SelectedAreaId));
        pairArr[8] = TuplesKt.to("userTimeStamp", this.talabatGTM.getCurrentTime());
        String screenName = redeemEventParams.getScreenName();
        if (screenName == null || screenName.length() == 0) {
            z12 = true;
        }
        if (!z12) {
            str4 = redeemEventParams.getScreenName();
        }
        pairArr[9] = TuplesKt.to("screenName", str4);
        pairArr[10] = TuplesKt.to("screenType", redeemEventParams.getScreenType().getType());
        if (LoggedInHelper.isLoggedIn()) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        pairArr[11] = TuplesKt.to("userLoggedIn", str2);
        pairArr[12] = TuplesKt.to("userId", this.talabatGTM.getUserId());
        pairArr[13] = TuplesKt.to("offerVoucherId", redeemEventParams.getOfferVoucherId());
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemPointsDefaultAttributes(TalabatGTM.Companion companion, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TalabatGTM.Companion : companion);
    }
}
