package tracking.gtm;

import android.content.Context;
import android.os.Bundle;
import buisnessmodels.Cart;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplOrderPaymentFailureEventKt;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"redeemOpenScreenEvent", "", "Ltracking/gtm/TalabatGTM$Companion;", "context", "Landroid/content/Context;", "ScreenName", "", "customerInfo", "Ldatamodels/CustomerInfo;", "points", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GTMLoyaltyEXTKt {
    public static final void redeemOpenScreenEvent(@NotNull TalabatGTM.Companion companion, @NotNull Context context, @Nullable String str, @Nullable CustomerInfo customerInfo, @NotNull String str2) {
        boolean z11;
        String str3;
        boolean z12;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, Param.POINTS);
        Bundle bundle = new Bundle();
        bundle.putString("locationCountry", TalabatAdjust.getSelectedCountryIso());
        bundle.putString("locationAddress", companion.getLocationAddress(context));
        String str6 = GlobalDataModel.SelectedCityName;
        boolean z13 = false;
        if (str6 == null || str6.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str3 = "N/A";
        } else {
            str3 = GlobalDataModel.SelectedCityName;
        }
        bundle.putString("locationCity", str3);
        bundle.putString("locationLat", companion.getLocationLatitude());
        bundle.putString("locationLon", companion.getLocationLongitude());
        bundle.putString("locationArea", String.valueOf(GlobalDataModel.SelectedAreaId));
        bundle.putString(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_DELIVERY_ADDRESS_STATUS, "N/A");
        String str7 = "false";
        if (str7.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            str4 = "N/A";
        } else {
            str4 = str7;
        }
        bundle.putString("subscribedUser", str4);
        bundle.putString("subscriptionType", "N/A");
        bundle.putString("subscriptionStartDate", "N/A");
        bundle.putString("subscriptionEndDate", "N/A");
        if (str == null || str.length() == 0) {
            z13 = true;
        }
        if (z13) {
            str = "N/A";
        }
        bundle.putString("screenName", str);
        bundle.putString("screenType", "reward");
        if (LoggedInHelper.isLoggedIn()) {
            str5 = "true";
        } else {
            str5 = str7;
        }
        bundle.putString("userLoggedIn", str5);
        bundle.putString("userId", companion.getUserId());
        bundle.putString("cartValue", String.valueOf(Cart.getInstance().getCartSubTotal()));
        bundle.putString("userTimeStamp", companion.getCurrentTime());
        if (!Cart.getInstance().hasItems()) {
            str7 = "true";
        }
        bundle.putString(ShopDetailsLoadedEvent.CART_EMPTY, str7);
        bundle.putString(ConstantsKt.SELECTED_LANGUAGE, TalabatAdjust.gtmLanguageSelected(GlobalDataModel.SelectedLanguage));
        bundle.putString("userOnlinePaymentMethods", "credit:" + companion.getTalabatCreditBalance() + ", rewardpoints:" + str2);
        TalabatFirebase.Companion.dispatchEvent(context, "screen_opened", bundle);
    }
}
