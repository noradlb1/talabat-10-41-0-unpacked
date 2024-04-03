package com.integration;

import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import datamodels.CustomerInfo;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAdjust;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/integration/IntegrationGlobalDataModel;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationGlobalDataModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Instrumented
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\fJ\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\u001eJ\u0006\u0010(\u001a\u00020\fJ\u0018\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ\u0010\u0010/\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u000201J\u0006\u00103\u001a\u00020\fJ\u0006\u00104\u001a\u00020\fJ\b\u00105\u001a\u0004\u0018\u00010\fJ\u0006\u00106\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\fJ\u0006\u0010:\u001a\u00020\fJ\u0006\u0010;\u001a\u00020\fJ\u001c\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0@J \u0010A\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\bJ\b\u0010D\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010E\u001a\u0004\u0018\u00010\fJ\u0006\u0010F\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\fJ\b\u0010G\u001a\u00020\bH\u0007J\u0006\u0010H\u001a\u00020\fJ\u0006\u0010I\u001a\u00020\fJ\u0006\u0010J\u001a\u00020KJ\u0006\u0010L\u001a\u00020KJ\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\fJ\u0010\u0010O\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010P\u001a\u00020\u0004J\u0006\u0010Q\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000e¨\u0006R"}, d2 = {"Lcom/integration/IntegrationGlobalDataModel$Companion;", "", "()V", "cartHasItems", "", "getCartHasItems", "()Z", "cartItemsCount", "", "getCartItemsCount", "()I", "customerAddressDescription", "", "getCustomerAddressDescription", "()Ljava/lang/String;", "homeMapSavedLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "getHomeMapSavedLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "selectedAreaId", "getSelectedAreaId", "selectedCityId", "getSelectedCityId", "selectedCityName", "getSelectedCityName", "tempStreetName", "getTempStreetName", "amexCardPayfortTypeString", "baseImageUrl", "clearTalabatCart", "", "context", "Landroid/content/Context;", "customerHasAddress", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "customerID", "customerName", "dinersClubCardPayfortTypeString", "disablePromotionsWidget", "discoverCardPayfortTypeString", "getAreaCenterLatLng", "areaId", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getCustomerSavedLatitude", "getCustomerSavedLongitude", "getFormattedAmountWithCurrency", "price", "", "getFormattedAmountWithoutCurrency", "getPerseusClientId", "getPerseusSessionId", "getRoutingEnabledPublicKey", "isArabic", "isKurdish", "isLoggedIn", "jcbCardPayfortTypeString", "maestroCardPayfortTypeString", "masterCardPayfortTypeString", "saveMoreTileVerticalIds", "sharedPreferencesManager", "Llibrary/talabat/SharedPreferencesManager;", "verticalIds", "", "saveVertical", "deepLink", "verticalId", "selectedAddressName", "selectedAreaName", "selectedAreaNameListNaviagtion", "selectedCountryCode", "selectedCountryIsoCode", "selectedLanguage", "selectedLocationLatitude", "", "selectedLocationLongitude", "setGlobalRestaurantModel", "vednorJson", "setHomeMapRedirect", "shouldShowPromotionsWidget", "visaCardPayfortTypeString", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String amexCardPayfortTypeString() {
            return "AMEX";
        }

        @NotNull
        public final String baseImageUrl() {
            String str = GlobalDataModel.imageBaseUrl;
            return str == null ? "" : str;
        }

        public final void clearTalabatCart(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            if (restaurant == null) {
                return;
            }
            if (restaurant.isDarkStore || restaurant.isMigrated) {
                Cart.getInstance().clearCartFromDarkstores(context);
            }
        }

        public final boolean customerHasAddress(@NotNull Country country) {
            Intrinsics.checkNotNullParameter(country, "selectedCountry");
            return Customer.getInstance().hasAddresses(country);
        }

        @NotNull
        public final String customerID() {
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            String num = customerInfo != null ? Integer.valueOf(customerInfo.f13850id).toString() : null;
            return num == null ? "" : num;
        }

        @NotNull
        public final String customerName() {
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            String fistName = customerInfo != null ? customerInfo.getFistName() : null;
            return fistName == null ? "" : fistName;
        }

        @NotNull
        public final String dinersClubCardPayfortTypeString() {
            return GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_DINERSCLUB;
        }

        public final void disablePromotionsWidget() {
            GlobalDataModel.SHOULD_SHOW_PROMO_WIDGET = false;
        }

        @NotNull
        public final String discoverCardPayfortTypeString() {
            return "DISCOVER";
        }

        @Nullable
        public final LatLng getAreaCenterLatLng(int i11, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            return HomeMapUtils.INSTANCE.areaCenterLatLg(i11, locationConfigurationRepository);
        }

        public final boolean getCartHasItems() {
            return Cart.getInstance().hasItems();
        }

        public final int getCartItemsCount() {
            return Cart.getInstance().getCartCount();
        }

        @Nullable
        public final String getCustomerAddressDescription() {
            boolean z11;
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            if (selectedCustomerAddress == null) {
                return null;
            }
            if (GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
                z11 = true;
            } else {
                z11 = false;
            }
            return AddressesKt.description(selectedCustomerAddress, z11);
        }

        @NotNull
        public final String getCustomerSavedLatitude() {
            String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
            return latitude == null ? "" : latitude;
        }

        @NotNull
        public final String getCustomerSavedLongitude() {
            String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
            return longitude == null ? "" : longitude;
        }

        @Nullable
        public final String getFormattedAmountWithCurrency(float f11) {
            return TalabatFormatter.getInstance().getFormattedCurrency(f11, true);
        }

        @Nullable
        public final String getFormattedAmountWithoutCurrency(float f11) {
            return TalabatFormatter.getInstance().getFormattedCurrency(f11, false);
        }

        @Nullable
        public final LatLng getHomeMapSavedLatLng() {
            return HomeMapTemp.INSTANCE.getHomeMapSavedLatLng();
        }

        @NotNull
        public final String getPerseusClientId() {
            String myClientId$default = TalabatPerseus.Companion.getMyClientId$default(TalabatPerseus.Companion, (Context) null, 1, (Object) null);
            return myClientId$default == null ? "" : myClientId$default;
        }

        @NotNull
        public final String getPerseusSessionId() {
            String mySessionId = TalabatPerseus.Companion.getMySessionId();
            return mySessionId == null ? "" : mySessionId;
        }

        @Nullable
        public final String getRoutingEnabledPublicKey() {
            return GlobalDataModel.CHECKOUTDOTCOM.routingEnabledPublicKey;
        }

        public final int getSelectedAreaId() {
            return GlobalDataModel.SelectedAreaId;
        }

        public final int getSelectedCityId() {
            return GlobalDataModel.SelectedCityId;
        }

        @Nullable
        public final String getSelectedCityName() {
            return GlobalDataModel.SelectedCityName;
        }

        @Nullable
        public final String getTempStreetName() {
            return HomeMapTemp.INSTANCE.getHomeMapStreetName();
        }

        public final boolean isArabic() {
            return Intrinsics.areEqual((Object) GlobalDataModel.SelectedLanguage, (Object) GlobalConstants.ARABIC);
        }

        public final boolean isKurdish() {
            if (Intrinsics.areEqual((Object) GlobalDataModel.SelectedLanguage, (Object) GlobalConstants.KURDISH_BADINI) || Intrinsics.areEqual((Object) GlobalDataModel.SelectedLanguage, (Object) GlobalConstants.KURDISH_SORANI)) {
                return true;
            }
            return false;
        }

        public final boolean isLoggedIn() {
            return Customer.getInstance().isLoggedIn();
        }

        @NotNull
        public final String jcbCardPayfortTypeString() {
            return GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_JCB;
        }

        @NotNull
        public final String maestroCardPayfortTypeString() {
            return GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_MAESTRO;
        }

        @NotNull
        public final String masterCardPayfortTypeString() {
            return "MASTERCARD";
        }

        public final void saveMoreTileVerticalIds(@NotNull SharedPreferencesManager sharedPreferencesManager, @NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(sharedPreferencesManager, "sharedPreferencesManager");
            Intrinsics.checkNotNullParameter(list, "verticalIds");
            sharedPreferencesManager.saveMoreTileVerticalId(list);
        }

        public final void saveVertical(@Nullable Context context, @NotNull String str, int i11) {
            Intrinsics.checkNotNullParameter(str, "deepLink");
            if (context == null) {
                return;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "")) {
                SharedPreferencesManager.getInstance(context).saveFavVerical(GlobalConstants.VerticalTypes.RESTAURANT, 0);
            } else {
                SharedPreferencesManager.getInstance(context).saveFavVerical(str, i11);
            }
        }

        @Nullable
        public final String selectedAddressName() {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            if (selectedCustomerAddress != null) {
                return selectedCustomerAddress.profileName;
            }
            return null;
        }

        public final int selectedAreaId() {
            return GlobalDataModel.SelectedAreaId;
        }

        @Nullable
        public final String selectedAreaName() {
            return GlobalDataModel.SelectedAreaName;
        }

        @NotNull
        public final String selectedAreaNameListNaviagtion() {
            String str = GlobalDataModel.SelectedAreaName;
            if (str == null) {
                str = null;
            }
            return str == null ? "" : str;
        }

        @NotNull
        public final String selectedCountry() {
            String str = GlobalDataModel.SelectedCountryName;
            return str == null ? "" : str;
        }

        @Deprecated(message = "Will be removed due to getting rid of static configs", replaceWith = @ReplaceWith(expression = "customerHasAddress(selectedCountry)", imports = {"com.talabat.configuration.country.Country"}))
        public final int selectedCountryCode() {
            return GlobalDataModel.SelectedCountryId;
        }

        @NotNull
        public final String selectedCountryIsoCode() {
            String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
            Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
            return selectedCountryIso;
        }

        @NotNull
        public final String selectedLanguage() {
            String str = GlobalDataModel.SelectedLanguage;
            return str == null ? "en-US" : str;
        }

        public final double selectedLocationLatitude() {
            return GlobalDataModel.RECENT_LATLONG.getLatitude();
        }

        public final double selectedLocationLongitude() {
            return GlobalDataModel.RECENT_LATLONG.getLongitude();
        }

        public final void setGlobalRestaurantModel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "vednorJson");
            GlobalDataModel.SELECTED.updateRestaurant((Restaurant) GsonInstrumentation.fromJson(new Gson(), str, Restaurant.class));
        }

        public final void setHomeMapRedirect(@Nullable Context context) {
            HomeMapTemp.INSTANCE.setHomeEnabledHomeMapRedirectEnabled(context);
        }

        public final boolean shouldShowPromotionsWidget() {
            return GlobalDataModel.SHOULD_SHOW_PROMO_WIDGET;
        }

        @NotNull
        public final String visaCardPayfortTypeString() {
            return "VISA";
        }
    }
}
