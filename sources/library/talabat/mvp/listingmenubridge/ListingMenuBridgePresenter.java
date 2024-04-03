package library.talabat.mvp.listingmenubridge;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.McdMapTempAddress;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import datamodels.Restaurant;
import java.util.HashMap;
import tracking.observability.VendorInfoAPIObservability;

public class ListingMenuBridgePresenter implements IListingMenuBridgePresenter, ListingMenuBridgeListener {
    private static final String QC_NFV_EXPERIMENT_CONTROL = "Control";
    private static final String QC_NFV_EXPERIMENT_VARIATION1 = "Variation1";

    /* renamed from: a  reason: collision with root package name */
    public Restaurant f26753a;
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public ITalabatExperiment f26754b;
    private IListingMenuBridgeInteractor iListingMenuBridgeInteractor;
    private ListingMenuBridgeView listingMenuBridgeView;

    public ListingMenuBridgePresenter(AppVersionProvider appVersionProvider2, ListingMenuBridgeView listingMenuBridgeView2, ITalabatExperiment iTalabatExperiment, VendorInfoAPIObservability vendorInfoAPIObservability) {
        this.appVersionProvider = appVersionProvider2;
        this.listingMenuBridgeView = listingMenuBridgeView2;
        this.f26754b = iTalabatExperiment;
        this.iListingMenuBridgeInteractor = new ListingMenuBridgeInteractor(appVersionProvider2, vendorInfoAPIObservability, this);
    }

    private boolean isQCNonMigratedVendorNavigationToFlutterMenuEnabled() {
        return "Variation1".equals(this.f26754b.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_NFV_NAVIGATE_TO_FLUTTER_FOOD_MENU, "", TalabatExperimentDataSourceStrategy.FWF));
    }

    public void getBranchIdFromGrl(InforMapRequest inforMapRequest) {
        this.iListingMenuBridgeInteractor.getBranchIdFromGrl(inforMapRequest);
    }

    public void getDarkstoreInfo() {
        this.iListingMenuBridgeInteractor.getDarkstoreInfo();
    }

    public void getMcdBranchIdFromBlockorLatLng(McdBranchRequest mcdBranchRequest) {
        this.iListingMenuBridgeInteractor.getBranchIdFromBlockorLatLang(mcdBranchRequest);
    }

    public void getMigratedVendorInfo(int i11) {
        this.iListingMenuBridgeInteractor.getMigratedVendorInfo(i11);
    }

    public void grlBranchIdFailed() {
    }

    public void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse) {
        Restaurant restaurant = this.f26753a;
        restaurant.branchId = inforMapAddressResponse.talabatResBranchId;
        setSelectedRestaurant(restaurant);
    }

    public void mcdBranchFailed() {
        this.listingMenuBridgeView.mcdServerError();
    }

    public void mcdBranchReceived(McdStoresResponse mcdStoresResponse) {
        if (mcdStoresResponse == null) {
            return;
        }
        if (mcdStoresResponse.result.statusCode == 0) {
            this.f26753a.branchId = mcdStoresResponse.tlbBranchId;
            if (mcdStoresResponse.address != null) {
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempBlockAddress(mcdStoresResponse.address);
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempLatLangAddress(mcdStoresResponse.address);
                }
            }
            setSelectedRestaurant(this.f26753a);
            return;
        }
        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, "", (Address) null, this.f26753a.f13872id);
    }

    public void mcdMapDecisionMakerHandler(Restaurant restaurant) {
        this.f26753a = restaurant;
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        if (TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) {
            Customer instance = Customer.getInstance();
            if (instance.isLoggedIn()) {
                Address selectedCustomerAddress = instance.getSelectedCustomerAddress();
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (selectedCustomerAddress == null) {
                        Cart instance2 = Cart.getInstance();
                        if (!instance2.hasItems()) {
                            this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                        } else if (!instance2.getRestaurant().isGlrEnabled || instance2.getInforMapAddress() == null) {
                            this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                        } else if (TalabatUtils.isNullOrEmpty(instance2.getInforMapAddress().grl)) {
                            this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                        } else {
                            this.listingMenuBridgeView.showMenuWithGlrID(instance2.getInforMapAddress().grl, restaurant, GlobalDataModel.SelectedAreaId);
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                        Cart instance3 = Cart.getInstance();
                        if (instance3.hasItems()) {
                            if (!instance3.getRestaurant().isGlrEnabled || instance3.getInforMapAddress() == null) {
                                if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.grl)) {
                                    this.listingMenuBridgeView.showMenuWithGlrID(selectedCustomerAddress.grl, restaurant, selectedCustomerAddress.areaId);
                                } else {
                                    this.listingMenuBridgeView.showInforMap(selectedCustomerAddress.areaId, restaurant.f13873name);
                                }
                            } else if (TalabatUtils.isNullOrEmpty(instance3.getInforMapAddress().grl)) {
                                this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                            } else {
                                this.listingMenuBridgeView.showMenuWithGlrID(instance3.getInforMapAddress().grl, restaurant, GlobalDataModel.SelectedAreaId);
                            }
                        } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.grl)) {
                            this.listingMenuBridgeView.showMenuWithGlrID(selectedCustomerAddress.grl, restaurant, selectedCustomerAddress.areaId);
                        } else {
                            this.listingMenuBridgeView.showInforMap(selectedCustomerAddress.areaId, restaurant.f13873name);
                        }
                    } else {
                        this.listingMenuBridgeView.showInforMap(selectedCustomerAddress.areaId, restaurant.f13873name);
                    }
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (selectedCustomerAddress == null) {
                        Cart instance4 = Cart.getInstance();
                        if (!instance4.hasItems()) {
                            this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (!instance4.getRestaurant().isGlrEnabled || instance4.getMcdBhBlockAddress() == null) {
                            this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (TalabatUtils.isNullOrEmpty(instance4.getMcdBhBlockAddress().block)) {
                            this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance4.getMcdBhBlockAddress(), restaurant.f13872id);
                        } else {
                            this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance4.getMcdBhBlockAddress());
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                        Cart instance5 = Cart.getInstance();
                        if (instance5.hasItems()) {
                            if (!instance5.getRestaurant().isGlrEnabled || instance5.getMcdBhBlockAddress() == null) {
                                if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                                    this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                                } else {
                                    this.listingMenuBridgeView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                                }
                            } else if (TalabatUtils.isNullOrEmpty(instance5.getMcdBhBlockAddress().block)) {
                                this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance5.getMcdBhBlockAddress(), restaurant.f13872id);
                            } else {
                                this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance5.getMcdBhBlockAddress());
                            }
                        } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                            this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                        } else {
                            this.listingMenuBridgeView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                        }
                    } else {
                        this.listingMenuBridgeView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                    }
                } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
                } else {
                    if (selectedCustomerAddress == null) {
                        Cart instance6 = Cart.getInstance();
                        if (!instance6.hasItems()) {
                            this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (!instance6.getRestaurant().isGlrEnabled || instance6.getMcdLatLangAddress() == null) {
                            this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (TalabatUtils.isNullOrEmptyLatLng(instance6.getMcdLatLangAddress().latitude, instance6.getMcdLatLangAddress().longitude)) {
                            this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance6.getMcdLatLangAddress(), restaurant.f13872id);
                        } else {
                            this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance6.getMcdLatLangAddress());
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                        Cart instance7 = Cart.getInstance();
                        if (instance7.hasItems()) {
                            if (!instance7.getRestaurant().isGlrEnabled || instance7.getMcdLatLangAddress() == null) {
                                if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                                    this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                                } else {
                                    this.listingMenuBridgeView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                                }
                            } else if (TalabatUtils.isNullOrEmptyLatLng(instance7.getMcdLatLangAddress().latitude, instance7.getMcdLatLangAddress().longitude)) {
                                this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance7.getMcdLatLangAddress(), restaurant.f13872id);
                            } else {
                                this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance7.getMcdLatLangAddress());
                            }
                        } else if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                            this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                        } else {
                            this.listingMenuBridgeView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                        }
                    } else {
                        this.listingMenuBridgeView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                    }
                }
            } else {
                Cart instance8 = Cart.getInstance();
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (!instance8.hasItems()) {
                        this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                    } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getInforMapAddress() == null) {
                        this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                    } else if (TalabatUtils.isNullOrEmpty(instance8.getInforMapAddress().grl)) {
                        this.listingMenuBridgeView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                    } else {
                        this.listingMenuBridgeView.showMenuWithGlrID(instance8.getInforMapAddress().grl, restaurant, GlobalDataModel.SelectedAreaId);
                    }
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (!instance8.hasItems()) {
                        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getMcdBhBlockAddress() == null) {
                        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (TalabatUtils.isNullOrEmpty(instance8.getMcdBhBlockAddress().block)) {
                        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance8.getMcdBhBlockAddress(), restaurant.f13872id);
                    } else {
                        this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance8.getMcdBhBlockAddress());
                    }
                } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
                } else {
                    if (!instance8.hasItems()) {
                        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getMcdLatLangAddress() == null) {
                        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (TalabatUtils.isNullOrEmptyLatLng(instance8.getMcdLatLangAddress().latitude, instance8.getMcdLatLangAddress().longitude)) {
                        this.listingMenuBridgeView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance8.getMcdLatLangAddress(), restaurant.f13872id);
                    } else {
                        this.listingMenuBridgeView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance8.getMcdLatLangAddress());
                    }
                }
            }
        }
    }

    public void onDarkStoresEntrySuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData) {
        this.listingMenuBridgeView.darkstoreSuccess(restaurant, darkstoresTrackingData);
    }

    public void onDarkstoreError() {
        this.listingMenuBridgeView.darkstoreError();
    }

    public void onDataError() {
    }

    public void onDestroy() {
        this.listingMenuBridgeView = null;
        if (this.iListingMenuBridgeInteractor != null) {
            this.iListingMenuBridgeInteractor = null;
        }
    }

    public void onEmptyMenuReceived(String str) {
        ListingMenuBridgeView listingMenuBridgeView2 = this.listingMenuBridgeView;
        if (listingMenuBridgeView2 != null) {
            listingMenuBridgeView2.onEmptyMenuReceived(str);
        }
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        ListingMenuBridgeView listingMenuBridgeView2 = this.listingMenuBridgeView;
        if (listingMenuBridgeView2 != null) {
            listingMenuBridgeView2.onGroceryMenuLoadingCompleted(menuItemsResponseModel);
        }
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        ListingMenuBridgeView listingMenuBridgeView2 = this.listingMenuBridgeView;
        if (listingMenuBridgeView2 != null) {
            listingMenuBridgeView2.stopLodingPopup();
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            Cart instance = Cart.getInstance();
            if (instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
                instance.setTgoFreeDeliveryTiers();
            }
            if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || menuItemsResponseModel.restaurant == null)) {
                GEMEngine.getInstance().supressCouponsAndPromotion(menuItemsResponseModel.restaurant);
                GlobalDataModel.GEMCONSTANTS.menuRestaurantId = menuItemsResponseModel.restaurant.f13872id;
                if (GEMEngine.getInstance().shouldClearCart()) {
                    Cart.getInstance().clearCart(this.listingMenuBridgeView.getContext());
                }
            }
            this.listingMenuBridgeView.onMenuLoadingCompleted(menuItemsResponseModel);
        }
    }

    public void onMigratedVendorInfoReceived(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData) {
        ListingMenuBridgeView listingMenuBridgeView2 = this.listingMenuBridgeView;
        if (listingMenuBridgeView2 != null) {
            listingMenuBridgeView2.onMigratedVendorInfoReceived(restaurant, darkstoresTrackingData);
        }
    }

    public void onNetworkError() {
    }

    public void onRequestError() {
        ListingMenuBridgeView listingMenuBridgeView2 = this.listingMenuBridgeView;
        if (listingMenuBridgeView2 != null) {
            listingMenuBridgeView2.onRequestError();
        }
    }

    public void onServerError() {
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void setBranchIdForSelectedRestaurant(int i11) {
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        restaurant.branchId = i11;
        setSelectedRestaurant(restaurant);
    }

    public void setSelectedRestaurant(Restaurant restaurant) {
        if (restaurant != null) {
            this.f26753a = restaurant;
            int i11 = restaurant.statusType;
            if (i11 == 0 || i11 == 5) {
                userContinuing();
            } else if (i11 == 1) {
                this.listingMenuBridgeView.showAlert(800, restaurant.getName(), restaurant.isTalabatGo);
            } else {
                this.listingMenuBridgeView.showAlert(801, restaurant.getName(), restaurant.isTalabatGo);
            }
        } else {
            ObservabilityManager.trackUnExpectedScenario("Restaurant null in listingmenubridge", new HashMap());
        }
    }

    public void userContinuing() {
        GlobalDataModel.SELECTED.updateRestaurant(this.f26753a);
        this.listingMenuBridgeView.startLoadingPopup();
        if (this.f26753a.getMenuType() == 2) {
            GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
            this.iListingMenuBridgeInteractor.getGroceryMenu(this.f26753a.branchId);
        } else if (this.f26753a.shopType == 0 || isQCNonMigratedVendorNavigationToFlutterMenuEnabled()) {
            ListingMenuBridgeView listingMenuBridgeView2 = this.listingMenuBridgeView;
            Restaurant restaurant = this.f26753a;
            listingMenuBridgeView2.navigateToFlutterMenu(restaurant.branchId, restaurant.deliveryMode(), this.f26753a.isProRestaurant);
        } else {
            IListingMenuBridgeInteractor iListingMenuBridgeInteractor2 = this.iListingMenuBridgeInteractor;
            Restaurant restaurant2 = this.f26753a;
            iListingMenuBridgeInteractor2.getRestaurantMenu(restaurant2.branchId, restaurant2.getName());
        }
    }
}
