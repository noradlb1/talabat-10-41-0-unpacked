package tracking.gtm;

import android.content.Context;
import android.os.Bundle;
import buisnessmodels.FilterEngine;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplOrderPaymentFailureEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatFirebase;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Ltracking/gtm/GTMTLife;", "", "()V", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GTMTLife {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006Jv\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJF\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006JF\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006JF\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006JV\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006JN\u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006Jv\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006Jv\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u0001\u0010#\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006JL\u0010&\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J<\u0010'\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¨\u0006("}, d2 = {"Ltracking/gtm/GTMTLife$Companion;", "", "()V", "createBasicBundle", "Landroid/os/Bundle;", "screenName", "", "screenType", "onTLifeCheckoutLoaded", "", "cuisineString", "vendorName", "branchId", "branches", "rating", "ratingCount", "offersSize", "offerName", "orderPaymentMethodDefault", "orderPaymentMethod", "payAmount", "coupon", "couponValue", "shopOffersSelected", "onTLifeListLoaded", "shopQuantityTotal", "", "onTLifeOfferDetailsLoaded", "onTLifeScanQRClickedFromHome", "onTLifeScanQRClickedFromOfferDetails", "onTLifeScanQRFailed", "errorMessage", "onTLifeScanQRSuccessful", "onTLifeTransactionClicked", "onTLifeTransactionFailed", "onTLifeTransactionSuccess", "transactionRevenue", "rewardPoints", "addRestaurantBundle", "addRestaurantPaymentBundle", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bundle addRestaurantBundle(Bundle bundle, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            bundle.putString("shopCategoryList", str);
            bundle.putString("shopSponsoring", "false");
            bundle.putString("chainName", str2);
            bundle.putString("chainId", str3);
            bundle.putString("chainShops", str4);
            bundle.putString("shopType", StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
            bundle.putString(ShopDetailsLoadedEvent.SHOP_RATING_QUALITY, str5);
            bundle.putString(ShopDetailsLoadedEvent.SHOP_RATING_QUANTITY, str6);
            bundle.putString("shopWithOffer", str7);
            bundle.putString("shopOfferType", str8);
            return bundle;
        }

        private final Bundle addRestaurantPaymentBundle(Bundle bundle, String str, String str2, String str3, String str4, String str5, String str6) {
            bundle.putString(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT, str);
            bundle.putString("orderPaymentMethod", str2);
            bundle.putString("currencyCode", TalabatAdjust.getSelectedCurrencyCode());
            bundle.putString("payAmount", str3);
            bundle.putString("coupon", str4);
            bundle.putString(GrowthTrackerConstants.COUPON_VALUE, str5);
            bundle.putString(ConstantsKt.LOADED_SHOP_OFFERS_SELECTED, str6);
            return bundle;
        }

        public static /* synthetic */ Bundle createBasicBundle$default(Companion companion, String str, String str2, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str2 = "life";
            }
            return companion.createBasicBundle(str, str2);
        }

        @NotNull
        public final Bundle createBasicBundle(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            Bundle bundle = new Bundle();
            TalabatGTM.Companion companion = TalabatGTM.Companion;
            bundle.putString("locationAddress", TalabatGTM.Companion.getLocationAddress$default(companion, (Context) null, 1, (Object) null));
            bundle.putString("locationLat", companion.getLocationLatitude());
            bundle.putString("locationLon", companion.getLocationLongitude());
            String str3 = GlobalDataModel.SelectedCityName;
            if (str3 == null) {
                str3 = "N/A";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "GlobalDataModel.SelectedCityName ?: \"N/A\"");
            }
            bundle.putString("locationCity", str3);
            bundle.putString("locationArea", String.valueOf(GlobalDataModel.SelectedAreaId));
            bundle.putString("locationCountry", TalabatAdjust.getSelectedCountryIso());
            bundle.putString(com.talabat.core.tracking.data.constant.ConstantsKt.SELECTED_LANGUAGE, TalabatAdjust.gtmLanguageSelected(GlobalDataModel.SelectedLanguage));
            bundle.putString("userId", companion.getUserId());
            bundle.putString("userTimeStamp", companion.getCurrentTime());
            bundle.putString("screenName", str);
            bundle.putString("screenType", str2);
            return bundle;
        }

        public final void onTLifeCheckoutLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
            String str15 = str;
            Intrinsics.checkNotNullParameter(str15, "cuisineString");
            String str16 = str2;
            Intrinsics.checkNotNullParameter(str16, "vendorName");
            String str17 = str3;
            Intrinsics.checkNotNullParameter(str17, "branchId");
            String str18 = str4;
            Intrinsics.checkNotNullParameter(str18, "branches");
            String str19 = str5;
            Intrinsics.checkNotNullParameter(str19, FilterEngine.DEEPLINKSORT.RATING);
            String str20 = str6;
            Intrinsics.checkNotNullParameter(str20, "ratingCount");
            String str21 = str7;
            Intrinsics.checkNotNullParameter(str21, "offersSize");
            String str22 = str8;
            Intrinsics.checkNotNullParameter(str22, "offerName");
            Intrinsics.checkNotNullParameter(str9, BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT);
            Intrinsics.checkNotNullParameter(str10, "orderPaymentMethod");
            Intrinsics.checkNotNullParameter(str11, "payAmount");
            Intrinsics.checkNotNullParameter(str12, "coupon");
            Intrinsics.checkNotNullParameter(str13, GrowthTrackerConstants.COUPON_VALUE);
            Intrinsics.checkNotNullParameter(str14, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_checkout_loaded", addRestaurantPaymentBundle(addRestaurantBundle(createBasicBundle$default(this, "life_checkout.loaded", (String) null, 2, (Object) null), str15, str16, str17, str18, str19, str20, str21, str22), str9, str10, str11, str12, str13, str14), 1, (Object) null);
        }

        public final void onTLifeListLoaded(int i11) {
            Bundle createBasicBundle$default = createBasicBundle$default(this, "life_merchant_list", (String) null, 2, (Object) null);
            createBasicBundle$default.putInt(ConstantsKt.LOADED_SHOP_QUANTITY_TOTAL, i11);
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_list_loaded", createBasicBundle$default, 1, (Object) null);
        }

        public final void onTLifeOfferDetailsLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "cuisineString");
            Intrinsics.checkNotNullParameter(str2, "vendorName");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "branches");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, FilterEngine.DEEPLINKSORT.RATING);
            String str11 = str6;
            Intrinsics.checkNotNullParameter(str11, "ratingCount");
            Intrinsics.checkNotNullParameter(str7, "offersSize");
            String str12 = str8;
            Intrinsics.checkNotNullParameter(str12, "offerName");
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_details_loaded", addRestaurantBundle(createBasicBundle$default(this, "life_merchant_list", (String) null, 2, (Object) null), str, str2, str3, str9, str10, str11, "TRUE", str12), 1, (Object) null);
        }

        public final void onTLifeScanQRClickedFromHome(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "cuisineString");
            Intrinsics.checkNotNullParameter(str2, "vendorName");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "branches");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, FilterEngine.DEEPLINKSORT.RATING);
            String str11 = str6;
            Intrinsics.checkNotNullParameter(str11, "ratingCount");
            Intrinsics.checkNotNullParameter(str7, "offersSize");
            String str12 = str8;
            Intrinsics.checkNotNullParameter(str12, "offerName");
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_scan_clicked", addRestaurantBundle(createBasicBundle("home", "home"), str, str2, str3, str9, str10, str11, "TRUE", str12), 1, (Object) null);
        }

        public final void onTLifeScanQRClickedFromOfferDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "cuisineString");
            Intrinsics.checkNotNullParameter(str2, "vendorName");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "branches");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, FilterEngine.DEEPLINKSORT.RATING);
            String str11 = str6;
            Intrinsics.checkNotNullParameter(str11, "ratingCount");
            Intrinsics.checkNotNullParameter(str7, "offersSize");
            String str12 = str8;
            Intrinsics.checkNotNullParameter(str12, "offerName");
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_scan_clicked", addRestaurantBundle(createBasicBundle$default(this, "life_merchant_details", (String) null, 2, (Object) null), str, str2, str3, str9, str10, str11, "TRUE", str12), 1, (Object) null);
        }

        public final void onTLifeScanQRFailed(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10) {
            String str11 = str;
            String str12 = str10;
            Intrinsics.checkNotNullParameter(str, "screenName");
            String str13 = str2;
            Intrinsics.checkNotNullParameter(str13, "cuisineString");
            String str14 = str3;
            Intrinsics.checkNotNullParameter(str14, "vendorName");
            String str15 = str4;
            Intrinsics.checkNotNullParameter(str15, "branchId");
            String str16 = str5;
            Intrinsics.checkNotNullParameter(str16, "branches");
            String str17 = str6;
            Intrinsics.checkNotNullParameter(str17, FilterEngine.DEEPLINKSORT.RATING);
            String str18 = str7;
            Intrinsics.checkNotNullParameter(str18, "ratingCount");
            String str19 = str8;
            Intrinsics.checkNotNullParameter(str19, "offersSize");
            String str20 = str9;
            Intrinsics.checkNotNullParameter(str20, "offerName");
            Intrinsics.checkNotNullParameter(str12, "errorMessage");
            Bundle addRestaurantBundle = addRestaurantBundle(createBasicBundle$default(this, str, (String) null, 2, (Object) null), str13, str14, str15, str16, str17, str18, str19, str20);
            addRestaurantBundle.putString("errorMessage", str12);
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_scan_failed", addRestaurantBundle, 1, (Object) null);
        }

        public final void onTLifeScanQRSuccessful(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            String str10 = str;
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "cuisineString");
            String str11 = str3;
            Intrinsics.checkNotNullParameter(str11, "vendorName");
            String str12 = str4;
            Intrinsics.checkNotNullParameter(str12, "branchId");
            String str13 = str5;
            Intrinsics.checkNotNullParameter(str13, "branches");
            String str14 = str6;
            Intrinsics.checkNotNullParameter(str14, FilterEngine.DEEPLINKSORT.RATING);
            String str15 = str7;
            Intrinsics.checkNotNullParameter(str15, "ratingCount");
            String str16 = str8;
            Intrinsics.checkNotNullParameter(str16, "offersSize");
            String str17 = str9;
            Intrinsics.checkNotNullParameter(str17, "offerName");
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_scan_successful", addRestaurantBundle(createBasicBundle$default(this, str, (String) null, 2, (Object) null), str2, str11, str12, str13, str14, str15, str16, str17), 1, (Object) null);
        }

        public final void onTLifeTransactionClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
            String str15 = str;
            Intrinsics.checkNotNullParameter(str15, "cuisineString");
            String str16 = str2;
            Intrinsics.checkNotNullParameter(str16, "vendorName");
            String str17 = str3;
            Intrinsics.checkNotNullParameter(str17, "branchId");
            String str18 = str4;
            Intrinsics.checkNotNullParameter(str18, "branches");
            String str19 = str5;
            Intrinsics.checkNotNullParameter(str19, FilterEngine.DEEPLINKSORT.RATING);
            String str20 = str6;
            Intrinsics.checkNotNullParameter(str20, "ratingCount");
            String str21 = str7;
            Intrinsics.checkNotNullParameter(str21, "offersSize");
            String str22 = str8;
            Intrinsics.checkNotNullParameter(str22, "offerName");
            Intrinsics.checkNotNullParameter(str9, BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT);
            Intrinsics.checkNotNullParameter(str10, "orderPaymentMethod");
            Intrinsics.checkNotNullParameter(str11, "payAmount");
            Intrinsics.checkNotNullParameter(str12, "coupon");
            Intrinsics.checkNotNullParameter(str13, GrowthTrackerConstants.COUPON_VALUE);
            Intrinsics.checkNotNullParameter(str14, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_transaction_clicked", addRestaurantPaymentBundle(addRestaurantBundle(createBasicBundle$default(this, "life_checkout", (String) null, 2, (Object) null), str15, str16, str17, str18, str19, str20, str21, str22), str9, str10, str11, str12, str13, str14), 1, (Object) null);
        }

        public final void onTLifeTransactionFailed(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
            String str15 = str;
            Intrinsics.checkNotNullParameter(str15, "cuisineString");
            String str16 = str2;
            Intrinsics.checkNotNullParameter(str16, "vendorName");
            String str17 = str3;
            Intrinsics.checkNotNullParameter(str17, "branchId");
            String str18 = str4;
            Intrinsics.checkNotNullParameter(str18, "branches");
            String str19 = str5;
            Intrinsics.checkNotNullParameter(str19, FilterEngine.DEEPLINKSORT.RATING);
            String str20 = str6;
            Intrinsics.checkNotNullParameter(str20, "ratingCount");
            String str21 = str7;
            Intrinsics.checkNotNullParameter(str21, "offersSize");
            String str22 = str8;
            Intrinsics.checkNotNullParameter(str22, "offerName");
            Intrinsics.checkNotNullParameter(str9, BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT);
            Intrinsics.checkNotNullParameter(str10, "orderPaymentMethod");
            Intrinsics.checkNotNullParameter(str11, "payAmount");
            Intrinsics.checkNotNullParameter(str12, "coupon");
            Intrinsics.checkNotNullParameter(str13, GrowthTrackerConstants.COUPON_VALUE);
            Intrinsics.checkNotNullParameter(str14, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_transaction_failed", addRestaurantPaymentBundle(addRestaurantBundle(createBasicBundle$default(this, "life_checkout", (String) null, 2, (Object) null), str15, str16, str17, str18, str19, str20, str21, str22), str9, str10, str11, str12, str13, str14), 1, (Object) null);
        }

        public final void onTLifeTransactionSuccess(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16) {
            String str17 = str15;
            String str18 = str16;
            Intrinsics.checkNotNullParameter(str, "cuisineString");
            String str19 = str2;
            Intrinsics.checkNotNullParameter(str19, "vendorName");
            String str20 = str3;
            Intrinsics.checkNotNullParameter(str20, "branchId");
            String str21 = str4;
            Intrinsics.checkNotNullParameter(str21, "branches");
            String str22 = str5;
            Intrinsics.checkNotNullParameter(str22, FilterEngine.DEEPLINKSORT.RATING);
            String str23 = str6;
            Intrinsics.checkNotNullParameter(str23, "ratingCount");
            String str24 = str7;
            Intrinsics.checkNotNullParameter(str24, "offersSize");
            String str25 = str8;
            Intrinsics.checkNotNullParameter(str25, "offerName");
            Intrinsics.checkNotNullParameter(str9, BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT);
            Intrinsics.checkNotNullParameter(str10, "orderPaymentMethod");
            Intrinsics.checkNotNullParameter(str11, "payAmount");
            Intrinsics.checkNotNullParameter(str12, "coupon");
            Intrinsics.checkNotNullParameter(str13, GrowthTrackerConstants.COUPON_VALUE);
            Intrinsics.checkNotNullParameter(str14, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            Intrinsics.checkNotNullParameter(str17, "transactionRevenue");
            Intrinsics.checkNotNullParameter(str18, "rewardPoints");
            Bundle addRestaurantPaymentBundle = addRestaurantPaymentBundle(addRestaurantBundle(createBasicBundle$default(this, "life_checkout", (String) null, 2, (Object) null), str, str19, str20, str21, str22, str23, str24, str25), str9, str10, str11, str12, str13, str14);
            addRestaurantPaymentBundle.putString("transactionRevenue", str17);
            addRestaurantPaymentBundle.putString("rewardPoints", str18);
            TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, "life_transaction_success", addRestaurantPaymentBundle, 1, (Object) null);
        }
    }
}
