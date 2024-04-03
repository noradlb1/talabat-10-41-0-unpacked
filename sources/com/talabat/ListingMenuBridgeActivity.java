package com.talabat;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.GEMEngine;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.di.listingmenubridge.DaggerListingMenuBridgeActivityComponent;
import com.talabat.domain.address.Address;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import datamodels.MenuItem;
import datamodels.Restaurant;
import java.util.HashMap;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import library.talabat.mvp.listingmenubridge.IListingMenuBridgePresenter;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgePresenter;
import library.talabat.mvp.listingmenubridge.ListingMenuBridgeView;
import library.talabat.mvp.listingmenubridge.menuitemchecker.GetItemPresenter;
import library.talabat.mvp.listingmenubridge.menuitemchecker.MenuCheckerImpl;
import library.talabat.mvp.listingmenubridge.menuitemchecker.MenuItemInjector;
import library.talabat.mvp.listingmenubridge.menuitemchecker.SearchItemListener;
import library.talabat.mvp.menu_search.MenuSearchInteractor;
import library.talabat.mvp.menu_search.MenuSearchListener;
import org.jetbrains.annotations.NotNull;
import tracking.observability.di.VendorInfoAPIObservabilityProvider;
import ue.r9;
import ue.s9;

public class ListingMenuBridgeActivity extends TalabatBase implements ListingMenuBridgeView {
    private static final int INFORMAP_SELECTION = 40;
    private static final String INVALID_ITEM_ID = "-1";
    public static final String ITEMID = "itemId";
    private static final int MCD_BLOCK_SELECTION = 41;
    private static final int MCD_LAT_LANG_SELECTION = 42;
    private int branchId;
    private boolean grlEnabled = false;

    /* renamed from: i  reason: collision with root package name */
    public IListingMenuBridgePresenter f54273i;

    /* renamed from: j  reason: collision with root package name */
    public String f54274j = "N/A";

    /* renamed from: k  reason: collision with root package name */
    public String f54275k = "N/A";
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public AppVersionProvider f54276l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public IObservabilityManager f54277m;
    private boolean mIsDarkStore;
    private boolean mIsMigrated = false;
    private boolean mShouldSuppressVendorStatusAlert = false;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public Navigator f54278n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ITalabatFeatureFlag f54279o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public DeepLinkNavigator f54280p;

    private void clearCartFromDarkstores() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return;
        }
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            Cart.getInstance().clearCartFromDarkstores(this);
        }
    }

    private void inject() {
        DaggerListingMenuBridgeActivityComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$navigateToQCommerce$0(boolean z11) {
        if (z11) {
            finish();
        } else if (this.mIsDarkStore) {
            this.f54273i.getDarkstoreInfo();
        } else if (this.mIsMigrated) {
            this.f54273i.getMigratedVendorInfo(this.branchId);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onEmptyMenuReceived$1(DialogInterface dialogInterface, int i11) {
        finish();
        dialogInterface.dismiss();
    }

    private void navigateToQCommerce() {
        int i11;
        String str;
        String stringExtra = getIntent().getStringExtra("itemId");
        if (TalabatUtils.isNullOrEmpty(stringExtra) || stringExtra.equals(INVALID_ITEM_ID)) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        int i12 = i11;
        if (!this.f54275k.equals("N/A")) {
            str = this.f54275k;
        } else {
            str = GlobalDataModel.ShopClickOrigin;
        }
        DarkstoresDelegate.Companion.tryNavigateUsingDeeplink(this, this.branchId, i12, stringExtra, (String) null, str, GlobalDataModel.ShopClickOrigin, new s9(this));
    }

    private void setSelectedRestaurantId() {
        if (GlobalDataModel.SELECTED.getRestaurant() != null) {
            this.f54273i.setBranchIdForSelectedRestaurant(GlobalDataModel.SELECTED.getRestaurant().branchId);
            return;
        }
        throw new IllegalStateException("Listing Menu Bridge Acivtity Selected Restaurant cant be null");
    }

    public void darkstoreError() {
        stopLodingPopup();
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
        finish();
    }

    public void darkstoreSuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData) {
        stopLodingPopup();
        clearCartFromDarkstores();
        v(restaurant, getIntent().getStringExtra("itemId"), darkstoresTrackingData);
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return this.f54273i;
    }

    public String getScreenName() {
        return "";
    }

    public void mcdServerError() {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void navigateToFlutterMenu(int i11, String str, boolean z11) {
        int intExtra = getIntent().getIntExtra("itemId", -1);
        MenuNavigatorController.INSTANCE.navigateToMenu(this, new MenuNavigatorModel(i11, str, GlobalDataModel.ShopClickOrigin, Boolean.valueOf(z11), Integer.valueOf(intExtra)), this.f54279o, this.f54280p, this.f54278n);
        finish();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        int i13 = 0;
        if (i11 == 40) {
            if (i12 == -1) {
                if (intent != null) {
                    i13 = intent.getIntExtra(GlobalConstants.INFOR_MAP.TB_BRANCH_ID_MENU, -1);
                }
                if (i13 > 0) {
                    this.f54273i.setBranchIdForSelectedRestaurant(i13);
                } else {
                    setSelectedRestaurantId();
                }
            } else {
                finish();
            }
        } else if (i11 == 41) {
            if (i12 == -1) {
                if (intent != null) {
                    i13 = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                }
                if (i13 > 0) {
                    this.f54273i.setBranchIdForSelectedRestaurant(i13);
                } else {
                    setSelectedRestaurantId();
                }
            } else {
                finish();
            }
        } else if (i11 != 42) {
        } else {
            if (i12 == -1) {
                if (intent != null) {
                    i13 = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                }
                if (i13 > 0) {
                    this.f54273i.setBranchIdForSelectedRestaurant(i13);
                } else {
                    setSelectedRestaurantId();
                }
            } else {
                finish();
            }
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        stopLodingPopup();
        finish();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_listing_menu_bridge);
        AppVersionProvider appVersionProvider = this.f54276l;
        this.f54273i = new ListingMenuBridgePresenter(appVersionProvider, this, TalabatExperiment.INSTANCE, VendorInfoAPIObservabilityProvider.INSTANCE.provideVendorInfoAPIObservability(this.f54277m, appVersionProvider));
        Cart.getInstance().clearCartWhenChangedDeliveryMode(GlobalDataModel.SELECTED.getRestaurant(), this);
        if (getIntent().hasExtra(OPNavigatorActions.ARG_SEARCH_TERM)) {
            this.f54274j = getIntent().getStringExtra(OPNavigatorActions.ARG_SEARCH_TERM);
        }
        if (getIntent().hasExtra(NavigationMethodChannel.ARG_EVENT_ORIGIN)) {
            this.f54275k = getIntent().getStringExtra(NavigationMethodChannel.ARG_EVENT_ORIGIN);
        }
        if (getIntent().hasExtra(OPNavigatorActions.ARG_GRL_SHOP)) {
            this.grlEnabled = getIntent().getBooleanExtra(OPNavigatorActions.ARG_GRL_SHOP, false);
        }
        if (this.grlEnabled) {
            this.f54273i.mcdMapDecisionMakerHandler(GlobalDataModel.SELECTED.restaurant);
        } else if (getIntent().hasExtra(OPNavigatorActions.ARG_BRANCH_ID)) {
            this.branchId = getIntent().getIntExtra(OPNavigatorActions.ARG_BRANCH_ID, -1);
            this.mIsDarkStore = getIntent().getBooleanExtra(OPNavigatorActions.ARG_IS_DARK_STORE, false);
            this.mIsMigrated = getIntent().getBooleanExtra(OPNavigatorActions.ARG_IS_MIGRATED, false);
            this.mShouldSuppressVendorStatusAlert = getIntent().getBooleanExtra(OPNavigatorActions.ARG_SHOULD_SUPPRESS_VENDOR_STATUS_ALERT, false);
            startLodingPopup();
            if (this.mIsDarkStore || this.mIsMigrated) {
                startLoadingPopup();
                navigateToQCommerce();
                return;
            }
            Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
            if (restaurant != null) {
                this.f54273i.setSelectedRestaurant(restaurant);
                return;
            }
            ObservabilityManager.trackUnExpectedScenario("Restaurant null in listingmenubridge onCreate", new HashMap());
            finish();
        }
    }

    public void onDataError() {
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
        super.onDataError();
    }

    public void onEmptyMenuReceived(String str) {
        stopLodingPopup();
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = getString(R.string.the_restaurant);
        }
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setMessage((CharSequence) getResources().getString(R.string.restaurant_has_no_menu).replace("###", str)).setCancelable(false).setNeutralButton((CharSequence) getString(R.string.ok_btn), (DialogInterface.OnClickListener) new r9(this)).show();
    }

    public void onError() {
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        ChoiceLoader.startChoiceLoader(this.f54276l);
        Cart instance = Cart.getInstance();
        if (menuItemsResponseModel != null && instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || menuItemsResponseModel.restaurant == null)) {
            GEMEngine.getInstance().supressCouponsAndPromotion(menuItemsResponseModel.restaurant);
            GlobalDataModel.GEMCONSTANTS.menuRestaurantId = menuItemsResponseModel.restaurant.f13872id;
            if (GEMEngine.getInstance().shouldClearCart()) {
                Cart.getInstance().clearCart(this);
            }
        }
        String stringExtra = getIntent().getStringExtra("from");
        if (TalabatUtils.isNullOrEmpty(stringExtra) || !stringExtra.equals("SEARCH_SCREEN")) {
            u(0);
            return;
        }
        int intExtra = getIntent().getIntExtra("itemId", 0);
        if (intExtra > 0) {
            int intExtra2 = getIntent().getIntExtra(OPNavigatorActions.ARG_BRANCH_ID, 0);
            String stringExtra2 = getIntent().getStringExtra("searchTerm");
            if (new MenuCheckerImpl(GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection).isItemAvailableInMenu(intExtra)) {
                u(0);
                return;
            }
            GetItemPresenter getItemPresenter = new GetItemPresenter(new MenuSearchInteractor(this.f54276l, (MenuSearchListener) null), new SearchItemListener() {
                public void onItemInfoLoaded(@NotNull MenuItem menuItem) {
                    new MenuItemInjector(GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection).injectMenuItem(menuItem);
                    ListingMenuBridgeActivity.this.u(menuItem.f13861id);
                }

                public void onItemNotAvailable() {
                    ListingMenuBridgeActivity.this.u(0);
                }
            });
            StringBuilder sb2 = new StringBuilder();
            sb2.append(intExtra2);
            getItemPresenter.getSearchItem(stringExtra2, sb2.toString());
            return;
        }
        u(0);
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        ChoiceLoader.startChoiceLoader(this.f54276l);
        Cart instance = Cart.getInstance();
        if (menuItemsResponseModel != null && instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || menuItemsResponseModel.restaurant == null)) {
            GEMEngine.getInstance().supressCouponsAndPromotion(menuItemsResponseModel.restaurant);
            GlobalDataModel.GEMCONSTANTS.menuRestaurantId = menuItemsResponseModel.restaurant.f13872id;
            if (GEMEngine.getInstance().shouldClearCart()) {
                Cart.getInstance().clearCart(this);
            }
        }
        stopLodingPopup();
        if (menuItemsResponseModel.restaurant != null) {
            Intent intent = new Intent(this, RestaurantMenuScreenR.class);
            intent.putExtras(getIntent());
            if (intent.hasExtra("searchTerm")) {
                intent.removeExtra("searchTerm");
            }
            intent.addFlags(65536);
            intent.addFlags(335544320);
            startActivity(intent);
        } else {
            onDataError();
        }
        finish();
    }

    public void onMigratedVendorInfoReceived(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData) {
        stopLodingPopup();
        clearCartFromDarkstores();
        v(restaurant, getIntent().getStringExtra("itemId"), darkstoresTrackingData);
    }

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
        finish();
    }

    public void showAlert(int i11, String str, boolean z11) {
        String str2;
        String str3;
        String str4;
        if (i11 == 800) {
            String string = getString(R.string.restaurant_closed);
            if (z11) {
                str3 = getString(R.string.tgo_bsy_close_msg).replace(RichContentLoadTimeRecorder.DELIMETER, str);
            } else {
                str3 = getString(R.string.we_are_sorry_message).replace(RichContentLoadTimeRecorder.DELIMETER, str).replace("**", string);
            }
            if (z11) {
                str4 = getString(R.string.bsy_close_tgo_alert_title);
            } else {
                str4 = getString(R.string.restaurant) + " " + string;
            }
            if (z11) {
                str2 = getString(R.string.continue_to_restaurant);
            } else {
                str2 = getString(R.string.continue_to_restaurant);
            }
        } else {
            String string2 = getString(R.string.restaurant_busy);
            str3 = getString(R.string.we_are_sorry_message).replace(RichContentLoadTimeRecorder.DELIMETER, str).replace("**", string2);
            str2 = getString(R.string.continue_to_restaurant);
            str4 = getString(R.string.restaurant) + " " + string2;
        }
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((CharSequence) str4).setMessage((CharSequence) str3).setPositiveButton((CharSequence) str2, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ListingMenuBridgeActivity.this.f54273i.userContinuing();
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ListingMenuBridgeActivity.this.stopLodingPopup();
                ListingMenuBridgeActivity.this.finish();
            }
        }).show();
    }

    public void showInforMap(int i11, String str) {
        stopLodingPopup();
        Intent intent = new Intent(this, InforMapScreen.class);
        intent.putExtra(GlobalConstants.INFOR_MAP.INFORMAP_SELECTED_AREA_ID, i11);
        intent.putExtra(GlobalConstants.INFOR_MAP.RESTAURANT_NAME, str);
        startActivityForResult(intent, 40);
    }

    public void showMcdGoogleMap(int i11, String str, Address address, int i12) {
        stopLodingPopup();
        Intent intent = new Intent(this, MapsActivity.class);
        if (address != null && address.latitude > 0.0d && address.longitude > 0.0d) {
            intent.putExtra("location", "" + address.latitude + "," + address.longitude);
        }
        intent.putExtra("userSelectedAreaId", GlobalDataModel.SelectedAreaId);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_FLOW, true);
        intent.putExtra("noAreaChange", true);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_RESTAURANT_ID, i12);
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            startActivityForResult(intent, 41);
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            startActivityForResult(intent, 42);
        }
    }

    public void showMenuWithGlrID(String str, Restaurant restaurant, int i11) {
        this.f54273i.getBranchIdFromGrl(new InforMapRequest(str, i11, true));
    }

    public void showMenuWithMcdStores(Restaurant restaurant, int i11, Address address) {
        startLodingPopup();
        this.f54273i.getMcdBranchIdFromBlockorLatLng(new McdBranchRequest(address, restaurant.f13872id));
    }

    public void startLoadingPopup() {
        startLodingPopup();
    }

    public void u(int i11) {
        stopLodingPopup();
        Intent intent = new Intent(this, GroceryMenuScreen.class);
        intent.putExtras(getIntent());
        intent.putExtra(OPNavigatorActions.ARG_SEARCH_TERM, this.f54274j);
        if (intent.hasExtra("searchTerm")) {
            intent.removeExtra("searchTerm");
        }
        if (i11 > 0) {
            intent.putExtra("itemId", i11);
        }
        startActivity(intent);
        finish();
    }

    public void v(Restaurant restaurant, String str, DarkstoresTrackingData darkstoresTrackingData) {
        if (TalabatUtils.isNullOrEmpty(str) || str.equals(INVALID_ITEM_ID)) {
            DarkstoresDelegate.Companion.onDarkstoresClicked(this, restaurant, -1, "", false, this.mShouldSuppressVendorStatusAlert, true, DarkstoresDelegate.DSClickOrigin.ORIGIN_HOME, "", "", this.f54274j, this.f54275k, darkstoresTrackingData);
            return;
        }
        DarkstoresDelegate.Companion.onDarkstoresClicked(this, restaurant, 1, str, false, this.mShouldSuppressVendorStatusAlert, true, DarkstoresDelegate.DSClickOrigin.ORIGIN_HOME, "", "", this.f54274j, this.f54275k, darkstoresTrackingData);
    }
}
