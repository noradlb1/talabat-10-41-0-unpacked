package com.talabat.darkstores.view;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import buisnessmodels.Cart;
import buisnessmodels.McdMapTempAddress;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.AddAddressScreen2;
import com.talabat.AddressList;
import com.talabat.CheckOutScreen;
import com.talabat.LoginScreen;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.darkstores.presenter.DarkstoresBridgePresenter;
import com.talabat.darkstores.presenter.IDarkstoresBridgePresenter;
import com.talabat.di.darkstores.DaggerDarkstoresBridgeActivityComponent;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.helpers.CustomDialog;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observabilityNew.squads.nfv.NFVEventType;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.userandlocation.ComplianceUserStatusActions;
import com.talabat.talabatnavigation.verticalsSquad.VerticalsNavigatorActions;
import com.talabat.user.address.di.AddressesDependencyProvider;
import datamodels.Restaurant;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sj.a;
import tracking.AppTracker;
import tracking.ScreenNames;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J6\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<JX\u0010A\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020<JX\u0010F\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020<J\"\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010KH\u0014J\b\u0010L\u001a\u000203H\u0016J\u0012\u0010M\u001a\u0002032\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u000203H\u0016J\u0006\u0010Q\u001a\u000203J&\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010T\u001a\u00020<J6\u0010U\u001a\u0002032\u0006\u0010;\u001a\u00020<2\u0006\u0010B\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010T\u001a\u00020<2\u0006\u0010V\u001a\u00020<J.\u0010W\u001a\u0002032\u0006\u0010;\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010T\u001a\u00020<2\u0006\u0010X\u001a\u00020<JJ\u0010Y\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010Z\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010[\u001a\u00020<2\u0006\u0010\\\u001a\u00020<H\u0002J\u0017\u0010]\u001a\u0002032\b\u0010^\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0002\u0010_J\u001e\u0010`\u001a\u0002032\u0006\u0010a\u001a\u0002072\u0006\u0010b\u001a\u0002072\u0006\u0010c\u001a\u000207J\b\u0010d\u001a\u000203H\u0002J\b\u0010e\u001a\u000203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006f"}, d2 = {"Lcom/talabat/darkstores/view/DarkstoresBridgeActivity;", "Lcom/talabat/helpers/TalabatBase;", "()V", "ADDRESS_PAGE", "", "LOGIN_PAGE", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "setAppVersionProvider", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "discoveryConfigurationRepository", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "getDiscoveryConfigurationRepository", "()Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "setDiscoveryConfigurationRepository", "(Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;)V", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mDarkstoresBridgePresenter", "Lcom/talabat/darkstores/presenter/IDarkstoresBridgePresenter;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "progressDialog", "Lcom/talabat/helpers/CustomDialog;", "getProgressDialog", "()Lcom/talabat/helpers/CustomDialog;", "setProgressDialog", "(Lcom/talabat/helpers/CustomDialog;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "destroyPresenter", "", "getPresenter", "Llibrary/talabat/mvp/IGlobalPresenter;", "getScreenName", "", "isMapCompulsory", "address", "Lcom/talabat/domain/address/Address;", "isMapcompulsory", "", "isNewAddressCreationFromCart", "newAddress", "isNineCookiesTrackingEnabled", "isTalabatDeliveryAvailable", "mapFirstRedirect", "isFromCartFlow", "isGrlRes", "IsAddAddressEnabledCheckout", "isRedirectToCheckout", "mapFirstUpdateAddressRedirect", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onItemsAddedToCart", "onRedirectToAddressSelection", "isRestaurantNeedMap", "isGrlEnabledRes", "onRedirectToCheckOut", "isAddAddressEnabledCheckout", "onRedirectToLogin", "isFromMapFirstFLow", "redirectAddAddressScreen", "addreessCeation", "isGlrEnabedRestaurant", "isNewAddressCreationGlrFlow", "showProgress", "show", "(Ljava/lang/Boolean;)V", "showUserVerificationView", "firstName", "lastName", "dateOfBirth", "startLoading", "stopLoading", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DarkstoresBridgeActivity extends TalabatBase {
    private final int ADDRESS_PAGE = 300;
    private final int LOGIN_PAGE = 200;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public AppVersionProvider appVersionProvider;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public DiscoveryConfigurationRepository discoveryConfigurationRepository;
    @Inject
    public LocationConfigurationRepository locationConfigRepository;
    @Nullable
    private IDarkstoresBridgePresenter mDarkstoresBridgePresenter;
    @Inject
    public IObservabilityManager observabilityManager;
    @Nullable
    private CustomDialog progressDialog;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    /* access modifiers changed from: private */
    /* renamed from: isMapCompulsory$lambda-2  reason: not valid java name */
    public static final void m10106isMapCompulsory$lambda2(DarkstoresBridgeActivity darkstoresBridgeActivity, Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(darkstoresBridgeActivity, "this$0");
        Intrinsics.checkNotNullParameter(address, "$address");
        darkstoresBridgeActivity.redirectAddAddressScreen(address, z11, z12, z13, z14, z15, false, false);
    }

    private final void redirectAddAddressScreen(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        String str;
        stopLodingPopup();
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            if (!(McdMapTempAddress.getInstance().getSelectedGrlTempAddress() == null || address == null)) {
                Address selectedGrlTempAddress = McdMapTempAddress.getInstance().getSelectedGrlTempAddress();
                Intrinsics.checkNotNull(selectedGrlTempAddress);
                address = AddressesKt.merge(address, selectedGrlTempAddress);
            }
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            if (!(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() == null || address == null)) {
                Address selectedMcdBlockTempAddress = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
                Intrinsics.checkNotNull(selectedMcdBlockTempAddress);
                address = AddressesKt.merge(address, selectedMcdBlockTempAddress);
            }
        } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            address = null;
        } else if (!(McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress() == null || address == null)) {
            Address selectedMcdLatLangTempAddress = McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress();
            Intrinsics.checkNotNull(selectedMcdLatLangTempAddress);
            address = AddressesKt.merge(address, selectedMcdLatLangTempAddress);
        }
        Intent intent = new Intent(this, AddAddressScreen2.class);
        intent.putExtra("noAreaChange", true);
        intent.putExtra("from", "Cart Screen");
        if (address != null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) address);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) address);
            }
            Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(mergedAddress)");
        } else {
            str = "";
        }
        intent.putExtra("address", str);
        intent.putExtra("value", str);
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z14);
        intent.putExtra("isAddressFromCartOrderFlow", true);
        intent.putExtra("isNewAddressFromCartOrderFlow", z12);
        intent.putExtra("newaddressCreation", z13);
        intent.putExtra("nineCookiesEnabled", z14);
        intent.putExtra("talabatDeliveryAvailable", z15);
        intent.putExtra("isGlrEnabledRes", z16);
        intent.putExtra("isNewAddressCreationFromGrlFlow", z17);
        intent.putExtra("isFromMcdAddressFlow", z16);
        if (z16) {
            intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        }
        startActivityForResult(intent, this.ADDRESS_PAGE);
    }

    private final void showProgress(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            startLoading();
        } else {
            stopLoading();
        }
    }

    private final void startLoading() {
        try {
            if (this.progressDialog == null && !isFinishing()) {
                this.progressDialog = new CustomDialog(this);
            }
            CustomDialog customDialog = this.progressDialog;
            if (customDialog != null) {
                customDialog.show();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private final void stopLoading() {
        try {
            CustomDialog customDialog = this.progressDialog;
            if (customDialog != null && customDialog.isShowing() && !isFinishing() && !isDestroyed()) {
                customDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void destroyPresenter() {
        this.mDarkstoresBridgePresenter = null;
    }

    @NotNull
    public final AppVersionProvider getAppVersionProvider() {
        AppVersionProvider appVersionProvider2 = this.appVersionProvider;
        if (appVersionProvider2 != null) {
            return appVersionProvider2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appVersionProvider");
        return null;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final DiscoveryConfigurationRepository getDiscoveryConfigurationRepository() {
        DiscoveryConfigurationRepository discoveryConfigurationRepository2 = this.discoveryConfigurationRepository;
        if (discoveryConfigurationRepository2 != null) {
            return discoveryConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("discoveryConfigurationRepository");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigRepository() {
        LocationConfigurationRepository locationConfigurationRepository = this.locationConfigRepository;
        if (locationConfigurationRepository != null) {
            return locationConfigurationRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigRepository");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public IGlobalPresenter getPresenter() {
        IDarkstoresBridgePresenter iDarkstoresBridgePresenter = this.mDarkstoresBridgePresenter;
        if (iDarkstoresBridgePresenter != null) {
            return iDarkstoresBridgePresenter;
        }
        throw new NullPointerException("null cannot be cast to non-null type library.talabat.mvp.IGlobalPresenter");
    }

    @Nullable
    public final CustomDialog getProgressDialog() {
        return this.progressDialog;
    }

    @NotNull
    public String getScreenName() {
        return "";
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    public final void isMapCompulsory(@NotNull Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        String str;
        String str2;
        Address address2 = address;
        Intrinsics.checkNotNullParameter(address2, "address");
        if (!z11) {
            redirectAddAddressScreen(address, z11, z12, z13, z14, z15, false, false);
        } else if (!z12 || !z13) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((int) R.string.delivery_popup_title);
            if (TalabatUtils.isNullOrEmpty(address2.profileName)) {
                str = GlobalDataModel.SelectedAreaName;
            } else {
                str = address2.profileName + "(" + GlobalDataModel.SelectedAreaName + ")";
            }
            String str3 = str;
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
                String string = getString(R.string.force_map_message);
                Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…string.force_map_message)");
                Intrinsics.checkNotNullExpressionValue(str3, "name");
                str2 = StringsKt__StringsJVMKt.replace$default(string, "#", str3, false, 4, (Object) null);
            } else {
                str2 = getString(R.string.force_map_message);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(com.talabat.lo…string.force_map_message)");
            }
            builder.setMessage((CharSequence) str2);
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new a(this, address, z11, z12, z13, z14, z15));
            builder.show();
        } else {
            redirectAddAddressScreen(address, z11, z12, z13, z14, z15, false, false);
        }
    }

    public final void mapFirstRedirect(@Nullable Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19) {
        IDarkstoresBridgePresenter iDarkstoresBridgePresenter;
        Address address2 = address;
        boolean z21 = z12;
        boolean z22 = z14;
        boolean z23 = z17;
        stopLodingPopup();
        GlobalDataModel.GEO_CORDINATES.polyGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
        if (z19) {
            onRedirectToCheckOut(z11, z16, z14, z15, z17, z19);
        } else if (GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION != GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW) {
            Intent intent = new Intent(this, AddAddressScreen2.class);
            intent.putExtra("noAreaChange", true);
            intent.putExtra("from", "Cart Screen");
            boolean z24 = z13;
            intent.putExtra("isNewAddressFromCartOrderFlow", z13);
            intent.putExtra("newaddressCreation", z12);
            intent.putExtra("isUpdateNowSelected", false);
            intent.putExtra("isFromHomeScreenMap", true);
            intent.putExtra("address", "");
            intent.putExtra("value", "");
            boolean z25 = z11;
            intent.putExtra("map_compulsory", z11);
            intent.putExtra("nineCookiesEnabled", z14);
            intent.putExtra("isAddressFromCartOrderFlow", true);
            intent.putExtra("isNewAddressFromCartOrderFlow", z12);
            intent.putExtra("nineCookiesEnabled", z14);
            boolean z26 = z15;
            intent.putExtra("talabatDeliveryAvailable", z15);
            intent.putExtra("isGlrEnabledRes", z23);
            intent.putExtra("isNewAddressCreationFromGrlFlow", z12);
            intent.putExtra("isFromMcdAddressFlow", z23);
            startActivityForResult(intent, this.ADDRESS_PAGE);
        } else if (address2 != null && (iDarkstoresBridgePresenter = this.mDarkstoresBridgePresenter) != null) {
            iDarkstoresBridgePresenter.updateAddressWithGoogleApi(address);
        }
    }

    public final void mapFirstUpdateAddressRedirect(@Nullable Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19) {
        String str;
        stopLodingPopup();
        GlobalDataModel.GEO_CORDINATES.polyGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
        HomeMapTemp.INSTANCE.updateAddressNotSaved(true);
        Intent intent = new Intent(this, AddAddressScreen2.class);
        intent.putExtra("noAreaChange", true);
        intent.putExtra("from", "Cart Screen");
        if (GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION != GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW || address == null) {
            str = "";
        } else {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) address);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) address);
            }
            Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(address)");
            intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            intent.putExtra("isUpdateNowSelected", true);
        }
        intent.putExtra("isFromHomeScreenMap", true);
        intent.putExtra("address", str);
        intent.putExtra("value", str);
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z14);
        intent.putExtra("isAddressFromCartOrderFlow", true);
        intent.putExtra("isNewAddressFromCartOrderFlow", z12);
        intent.putExtra("nineCookiesEnabled", z14);
        intent.putExtra("talabatDeliveryAvailable", z15);
        intent.putExtra("isGlrEnabledRes", z17);
        intent.putExtra("isNewAddressCreationFromGrlFlow", z12);
        intent.putExtra("isFromMcdAddressFlow", z17);
        intent.putExtra("isFromMcdAddressFlow", z17);
        intent.putExtra(GlobalConstants.HOME_SCREEN_MAP.SHOW_ADDRESS_CONFIRMATION, true);
        startActivityForResult(intent, this.ADDRESS_PAGE);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        boolean z11;
        boolean z12;
        boolean z13;
        super.onActivityResult(i11, i12, intent);
        if (i11 == this.LOGIN_PAGE) {
            if (i12 == -1) {
                Restaurant restaurant = Cart.getInstance().getRestaurant();
                if (restaurant == null) {
                    restaurant = GlobalDataModel.SELECTED.restaurant;
                }
                Restaurant restaurant2 = restaurant;
                IDarkstoresBridgePresenter iDarkstoresBridgePresenter = this.mDarkstoresBridgePresenter;
                if (iDarkstoresBridgePresenter != null) {
                    Intrinsics.checkNotNullExpressionValue(restaurant2, "restaurant");
                    IDarkstoresBridgePresenter.DefaultImpls.onCheckoutClicked$default(iDarkstoresBridgePresenter, restaurant2, true, false, true, false, false, 32, (Object) null);
                }
            }
        } else if (i11 == this.ADDRESS_PAGE) {
            if (i12 == -1) {
                if (intent != null) {
                    boolean booleanExtra = intent.getBooleanExtra("isAddressFromCartOrderFlow", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("nineCookiesEnabled", false);
                    z11 = intent.getBooleanExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_IGNORE, false);
                    z13 = booleanExtra;
                    z12 = booleanExtra2;
                } else {
                    z13 = false;
                    z12 = false;
                    z11 = false;
                }
                Restaurant restaurant3 = Cart.getInstance().getRestaurant();
                if (restaurant3 == null) {
                    restaurant3 = GlobalDataModel.SELECTED.restaurant;
                }
                Restaurant restaurant4 = restaurant3;
                IDarkstoresBridgePresenter iDarkstoresBridgePresenter2 = this.mDarkstoresBridgePresenter;
                if (iDarkstoresBridgePresenter2 != null) {
                    Intrinsics.checkNotNullExpressionValue(restaurant4, "restaurant");
                    IDarkstoresBridgePresenter.DefaultImpls.onCheckoutClicked$default(iDarkstoresBridgePresenter2, restaurant4, z13, z12, z11, false, false, 32, (Object) null);
                }
            }
        } else if (i11 == 500 && i12 == -1) {
            Restaurant restaurant5 = Cart.getInstance().getRestaurant();
            if (restaurant5 == null) {
                restaurant5 = GlobalDataModel.SELECTED.restaurant;
            }
            Restaurant restaurant6 = restaurant5;
            IDarkstoresBridgePresenter iDarkstoresBridgePresenter3 = this.mDarkstoresBridgePresenter;
            if (iDarkstoresBridgePresenter3 != null) {
                Intrinsics.checkNotNullExpressionValue(restaurant6, "restaurant");
                iDarkstoresBridgePresenter3.onCheckoutClicked(restaurant6, true, false, true, false, true);
            }
        }
        if (i12 == 0) {
            finish();
        }
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        Object obj;
        String str;
        Object obj2;
        Bundle extras;
        String str2;
        Bundle extras2;
        DaggerDarkstoresBridgeActivityComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_darkstores_bridge);
        Unit unit = null;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            Intent intent = getIntent();
            if (intent == null || (extras2 = intent.getExtras()) == null) {
                str2 = null;
            } else {
                str2 = extras2.getString(VerticalsNavigatorActions.EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT);
            }
            Class cls = Restaurant.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str2, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str2, cls);
            }
        } catch (Exception unused) {
            obj = null;
        }
        AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
        DarkstoresBridgePresenter darkstoresBridgePresenter = new DarkstoresBridgePresenter(this, addressesDependencyProvider.provideCustomerAddressesRepository(getTalabatFeatureFlag()), addressesDependencyProvider.provideCustomerRepository(this), getAppVersionProvider(), getConfigurationLocalRepository(), getDiscoveryConfigurationRepository(), getLocationConfigRepository(), (Cart) null, 128, (DefaultConstructorMarker) null);
        this.mDarkstoresBridgePresenter = darkstoresBridgePresenter;
        Restaurant restaurant = (Restaurant) obj;
        if (restaurant != null) {
            darkstoresBridgePresenter.checkIfBackupNeeded(restaurant);
        }
        Intent intent2 = getIntent();
        if (intent2 == null || (extras = intent2.getExtras()) == null) {
            str = null;
        } else {
            str = extras.getString(VerticalsNavigatorActions.EXTRA_VERTICALS_DARKSTORES_BRIDGE);
        }
        if (str != null) {
            Gson gson2 = UniversalGson.INSTANCE.gson;
            Class cls2 = ExitPointData.class;
            if (!(gson2 instanceof Gson)) {
                obj2 = gson2.fromJson(str, cls2);
            } else {
                obj2 = GsonInstrumentation.fromJson(gson2, str, cls2);
            }
            ExitPointData exitPointData = (ExitPointData) obj2;
            IDarkstoresBridgePresenter iDarkstoresBridgePresenter = this.mDarkstoresBridgePresenter;
            if (iDarkstoresBridgePresenter != null) {
                ((DarkstoresBridgePresenter) iDarkstoresBridgePresenter).setExitPointData(exitPointData);
                IDarkstoresBridgePresenter iDarkstoresBridgePresenter2 = this.mDarkstoresBridgePresenter;
                if (iDarkstoresBridgePresenter2 != null) {
                    ((DarkstoresBridgePresenter) iDarkstoresBridgePresenter2).prepareCart();
                    unit = Unit.INSTANCE;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.presenter.DarkstoresBridgePresenter");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.presenter.DarkstoresBridgePresenter");
            }
        }
        if (unit == null) {
            onError();
        }
        startLodingPopup();
    }

    public void onError() {
    }

    public final void onItemsAddedToCart() {
        ExitPointData exitPointData;
        String str;
        try {
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            if (restaurant == null) {
                restaurant = GlobalDataModel.SELECTED.restaurant;
            }
            Restaurant restaurant2 = restaurant;
            IDarkstoresBridgePresenter iDarkstoresBridgePresenter = this.mDarkstoresBridgePresenter;
            if (iDarkstoresBridgePresenter != null) {
                Intrinsics.checkNotNullExpressionValue(restaurant2, "restaurant");
                IDarkstoresBridgePresenter.DefaultImpls.onCheckoutClicked$default(iDarkstoresBridgePresenter, restaurant2, true, false, true, false, false, 32, (Object) null);
            }
        } catch (Exception e11) {
            IDarkstoresBridgePresenter iDarkstoresBridgePresenter2 = this.mDarkstoresBridgePresenter;
            if (!(iDarkstoresBridgePresenter2 instanceof DarkstoresBridgePresenter)) {
                exitPointData = null;
            } else if (iDarkstoresBridgePresenter2 != null) {
                exitPointData = ((DarkstoresBridgePresenter) iDarkstoresBridgePresenter2).getExitPointData();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.presenter.DarkstoresBridgePresenter");
            }
            IObservabilityManager observabilityManager2 = getObservabilityManager();
            String name2 = NFVEventType.MobileUnexpectedScenariosQC.name();
            Pair[] pairArr = new Pair[2];
            String message = e11.getMessage();
            if (message == null) {
                message = "Something went wrong while navigating to checkout on DarkStoresBridgeActivity";
            }
            pairArr[0] = TuplesKt.to("error_message", message);
            if (exitPointData == null || (str = exitPointData.getCartId()) == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.to("cartID", str);
            observabilityManager2.trackEvent("darkstore_checkout_navigation", name2, (Map<String, String>) MapsKt__MapsKt.mapOf(pairArr));
        }
    }

    public final void onRedirectToAddressSelection(boolean z11, boolean z12, boolean z13, boolean z14) {
        stopLodingPopup();
        Intent intent = new Intent(this, AddressList.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFORSELECTION, true);
        intent.putExtra(GlobalConstants.FORCE_MAP.RESTAURANT_TRACK_ENFORCE_MAP, z11);
        intent.putExtra("isAddressFromCartOrderFlow", true);
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z12);
        intent.putExtra("talabatDeliveryAvailable", z13);
        intent.putExtra("isGlrEnabledRes", z14);
        startActivityForResult(intent, this.ADDRESS_PAGE);
    }

    public final void onRedirectToCheckOut(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        Intent intent = new Intent(this, CheckOutScreen.class);
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            restaurant = GlobalDataModel.SELECTED.restaurant;
        }
        AppTracker.onCheckoutClicked(this, Cart.getInstance(), AppTracker.getRestaurantId(restaurant), Cart.getInstance().getCartCount(), getScreenName(), ScreenNames.getScreenType(getScreenName()));
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z13);
        intent.putExtra("isAddressFromCartOrderFlow", z12);
        intent.putExtra("talabatDeliveryAvailable", z14);
        intent.putExtra("isGlrEnabledRes", z15);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_FROM_MCD_NEW_ADDRESS_CHECKOUT, z16);
        startActivity(intent);
        finish();
    }

    public final void onRedirectToLogin(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        String str;
        String json;
        String json2;
        stopLodingPopup();
        Intent intent = new Intent(this, LoginScreen.class);
        intent.putExtra("from", "Cart Screen");
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z12);
        intent.putExtra("talabatDeliveryAvailable", z13);
        intent.putExtra("isGlrEnabledRes", z14);
        intent.putExtra("isFromHomeScreenMap", z15);
        if (z14) {
            if (!TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    Gson gson = UniversalGson.INSTANCE.gson;
                    Address selectedMcdBlockTempAddress = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
                    if (!(gson instanceof Gson)) {
                        json2 = gson.toJson((Object) selectedMcdBlockTempAddress);
                    } else {
                        json2 = GsonInstrumentation.toJson(gson, (Object) selectedMcdBlockTempAddress);
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(McdMapTempAd…ectedMcdBlockTempAddress)");
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    Gson gson2 = UniversalGson.INSTANCE.gson;
                    Address selectedMcdLatLangTempAddress = McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress();
                    if (!(gson2 instanceof Gson)) {
                        json = gson2.toJson((Object) selectedMcdLatLangTempAddress);
                    } else {
                        json = GsonInstrumentation.toJson(gson2, (Object) selectedMcdLatLangTempAddress);
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(McdMapTempAd…tedMcdLatLangTempAddress)");
                }
                intent.putExtra("value", str);
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            } else if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
                Gson gson3 = UniversalGson.INSTANCE.gson;
                Address selectedGrlTempAddress = McdMapTempAddress.getInstance().getSelectedGrlTempAddress();
                if (!(gson3 instanceof Gson)) {
                    str = gson3.toJson((Object) selectedGrlTempAddress);
                } else {
                    str = GsonInstrumentation.toJson(gson3, (Object) selectedGrlTempAddress);
                }
                Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(McdMapTempAd…).selectedGrlTempAddress)");
                intent.putExtra("value", str);
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            }
            str = "";
            intent.putExtra("value", str);
            intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        }
        startActivityForResult(intent, this.LOGIN_PAGE);
    }

    public final void setAppVersionProvider(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "<set-?>");
        this.appVersionProvider = appVersionProvider2;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setDiscoveryConfigurationRepository(@NotNull DiscoveryConfigurationRepository discoveryConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(discoveryConfigurationRepository2, "<set-?>");
        this.discoveryConfigurationRepository = discoveryConfigurationRepository2;
    }

    public final void setLocationConfigRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "<set-?>");
        this.locationConfigRepository = locationConfigurationRepository;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setProgressDialog(@Nullable CustomDialog customDialog) {
        this.progressDialog = customDialog;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void showUserVerificationView(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
        NavigatorModelForResult createOpenScreenModelForResult = ComplianceUserStatusActions.INSTANCE.createOpenScreenModelForResult(500);
        createOpenScreenModelForResult.setInit(new DarkstoresBridgeActivity$showUserVerificationView$1(str, str2, str3));
        Navigator.Companion.navigate((Activity) this, createOpenScreenModelForResult);
    }
}
