package library.talabat.mvp.branding;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.RestGeoAddressBranchInfo;
import JsonModels.RestGeoAddressResult;
import JsonModels.ReviewWithRatingModel;
import JsonModels.parser.UniversalGson;
import android.location.Location;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.McdMapTempAddress;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Area;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.RatingSection;
import datamodels.Restaurant;
import datamodels.RestaurantReviewPaging;
import library.talabat.mvp.homemap.HomeMapTemp;
import tracking.AppTracker;

@Instrumented
public class BrandingPresenter implements IBrandingPresenter, BrandingListener {
    private int branchId = 0;
    private BrandingView brandingView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private Address custbrandAddress;
    private DeliveryArea[] deliveryAreas;
    private int franchiseloadedAreaId = 0;
    private int groupId = 0;
    private IBrandingInteractor iBrandingInteractor;
    boolean isBranchDeselected = false;
    private boolean isFranchiseButtonPressed = false;
    private boolean isFranchiseLoaded = false;
    private boolean isFranchiseRestaurant = false;
    private boolean isGrlEnabledArea;
    private boolean isLoadMenuRequestSent = false;
    boolean isMapFirstEnabled;
    private final LocationConfigurationRepository locationConfigRepository;
    private boolean menuLoadCompleted = false;
    private long menuLoadedTimeStamp;
    private int menuPreloadedBranchId;
    private int pageNumber;
    private long prelaodMillis = 60000;
    private RatingSection ratingSection;
    private boolean refreshAddressView = false;
    private RestaurantReviewPaging[] restaurantReviews;
    private ReviewWithRatingModel reviewWithRatingModel;
    boolean selectedAreaisInDeliveyArea = false;
    private boolean showMenuButtonPressed = false;
    final ITalabatExperiment talabatExperiment;

    public BrandingPresenter(AppVersionProvider appVersionProvider, BrandingView brandingView2, ITalabatExperiment iTalabatExperiment, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository) {
        this.brandingView = brandingView2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.iBrandingInteractor = new BrandingInteractor(appVersionProvider, this);
        setCustomerBrandAddress();
        getBranchLocalAddress();
        this.groupId = GlobalDataModel.SELECTED.restaurant.groupId;
        boolean isMapFirstEnabled2 = isMapFirstEnabled();
        this.isMapFirstEnabled = isMapFirstEnabled2;
        brandingView2.locationSelectionView(isMapFirstEnabled2);
        this.talabatExperiment = iTalabatExperiment;
        if (this.groupId > 0) {
            if (getBranchCount(GlobalDataModel.SelectedAreaId) > 1) {
                this.isFranchiseRestaurant = true;
                brandingView2.setRestaurantFranchise(true);
                brandingView2.updateResGrpId(this.groupId);
            } else {
                GlobalDataModel.SELECTED.restaurant.branchId = getBranchId(GlobalDataModel.SelectedAreaId);
            }
        }
        brandingView2.branchVisibility(this.isFranchiseRestaurant);
    }

    private void brandDeliverHere(RestGeoAddressResult restGeoAddressResult) {
        Address address = restGeoAddressResult.reverseAddress;
        if (address != null && !TalabatUtils.isNullOrEmpty(address.geoAddressTitle)) {
            this.brandingView.stopLodingPopup();
            this.brandingView.showBrandNotDeliverHere(restGeoAddressResult.reverseAddress.geoAddressTitle);
        }
    }

    private void callMenuApiIfNotMigrated(int i11) {
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        if (GlobalDataModel.SELECTED.restaurant.shopType == 1) {
            GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
            IBrandingInteractor iBrandingInteractor2 = this.iBrandingInteractor;
            iBrandingInteractor2.getGroceryMenu(i11 + "");
            return;
        }
        MenuResponseMapper.INSTANCE.clear();
        IBrandingInteractor iBrandingInteractor3 = this.iBrandingInteractor;
        iBrandingInteractor3.getRestaurantInfoOnly(i11 + "");
        IBrandingInteractor iBrandingInteractor4 = this.iBrandingInteractor;
        iBrandingInteractor4.getRestaurantMenuOnly(i11 + "", GlobalDataModel.SELECTED.getRestaurant().getName());
    }

    private void getBranchLocalAddress() {
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            this.custbrandAddress = null;
            if (instance.isLoggedIn()) {
                this.custbrandAddress = instance.getBrandLocalAddress();
            }
        }
    }

    private void getGeoLoactionBasedBranchId(RestGeoReverseCodingRequest restGeoReverseCodingRequest) {
        this.iBrandingInteractor.reverseGeoCodingBasedRestaurant(restGeoReverseCodingRequest);
    }

    private String getLocChooseBranch() {
        if (Customer.getInstance().isLoggedIn()) {
            Address address = this.custbrandAddress;
            if (address != null) {
                if (address.latitude <= 0.0d || address.longitude <= 0.0d) {
                    return "";
                }
                return "" + this.custbrandAddress.latitude + "," + this.custbrandAddress.longitude;
            } else if (!isTempHomeMpaAddressAvail()) {
                return "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                sb2.append(homeMapTemp.getHomeMapSavedLatLng().latitude);
                sb2.append(",");
                sb2.append(homeMapTemp.getHomeMapSavedLatLng().longitude);
                return sb2.toString();
            }
        } else if (!isTempHomeMpaAddressAvail()) {
            return "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            HomeMapTemp homeMapTemp2 = HomeMapTemp.INSTANCE;
            sb3.append(homeMapTemp2.getHomeMapSavedLatLng().latitude);
            sb3.append(",");
            sb3.append(homeMapTemp2.getHomeMapSavedLatLng().longitude);
            return sb3.toString();
        }
    }

    private void informMapDecisionMakerHandler() {
        Customer instance = Customer.getInstance();
        if (instance.isLoggedIn()) {
            Address selectedCustomerAddress = instance.getSelectedCustomerAddress();
            if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (selectedCustomerAddress == null) {
                    Cart instance2 = Cart.getInstance();
                    if (!instance2.hasItems()) {
                        BrandingView brandingView2 = this.brandingView;
                        int i11 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
                        brandingView2.showInforMap(i11, restaurant.f13872id, restaurant.f13873name);
                    } else if (!instance2.getRestaurant().isGlrEnabled || instance2.getInforMapAddress() == null) {
                        BrandingView brandingView3 = this.brandingView;
                        int i12 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                        brandingView3.showInforMap(i12, restaurant2.f13872id, restaurant2.f13873name);
                    } else if (TalabatUtils.isNullOrEmpty(instance2.getInforMapAddress().getGrlId())) {
                        BrandingView brandingView4 = this.brandingView;
                        int i13 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant3 = GlobalDataModel.SELECTED.restaurant;
                        brandingView4.showInforMap(i13, restaurant3.f13872id, restaurant3.f13873name);
                    } else {
                        this.brandingView.showMenuWithGlrID(instance2.getInforMapAddress().grl, GlobalDataModel.SELECTED.restaurant, instance2.getInforMapAddress().areaId);
                    }
                } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                    Cart instance3 = Cart.getInstance();
                    if (instance3.hasItems()) {
                        if (!instance3.getRestaurant().isGlrEnabled || instance3.getInforMapAddress() == null) {
                            if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.getGrlId())) {
                                this.brandingView.showMenuWithGlrID(selectedCustomerAddress.grl, GlobalDataModel.SELECTED.restaurant, selectedCustomerAddress.areaId);
                                return;
                            }
                            BrandingView brandingView5 = this.brandingView;
                            int i14 = selectedCustomerAddress.areaId;
                            Restaurant restaurant4 = GlobalDataModel.SELECTED.restaurant;
                            brandingView5.showInforMap(i14, restaurant4.f13872id, restaurant4.f13873name);
                        } else if (TalabatUtils.isNullOrEmpty(instance3.getInforMapAddress().grl)) {
                            BrandingView brandingView6 = this.brandingView;
                            int i15 = GlobalDataModel.SelectedAreaId;
                            Restaurant restaurant5 = GlobalDataModel.SELECTED.restaurant;
                            brandingView6.showInforMap(i15, restaurant5.f13872id, restaurant5.f13873name);
                        } else {
                            this.brandingView.showMenuWithGlrID(instance3.getInforMapAddress().grl, GlobalDataModel.SELECTED.restaurant, instance3.getInforMapAddress().areaId);
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.getGrlId())) {
                        this.brandingView.showMenuWithGlrID(selectedCustomerAddress.grl, GlobalDataModel.SELECTED.restaurant, selectedCustomerAddress.areaId);
                    } else {
                        BrandingView brandingView7 = this.brandingView;
                        int i16 = selectedCustomerAddress.areaId;
                        Restaurant restaurant6 = GlobalDataModel.SELECTED.restaurant;
                        brandingView7.showInforMap(i16, restaurant6.f13872id, restaurant6.f13873name);
                    }
                } else {
                    BrandingView brandingView8 = this.brandingView;
                    int i17 = selectedCustomerAddress.areaId;
                    Restaurant restaurant7 = GlobalDataModel.SELECTED.restaurant;
                    brandingView8.showInforMap(i17, restaurant7.f13872id, restaurant7.f13873name);
                }
            } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                if (selectedCustomerAddress == null) {
                    Cart instance4 = Cart.getInstance();
                    if (!instance4.hasItems()) {
                        BrandingView brandingView9 = this.brandingView;
                        int i18 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant8 = GlobalDataModel.SELECTED.restaurant;
                        brandingView9.showMcdGoogleMap(i18, restaurant8.f13873name, (Address) null, restaurant8.f13872id);
                    } else if (!instance4.getRestaurant().isGlrEnabled || instance4.getMcdBhBlockAddress() == null) {
                        BrandingView brandingView10 = this.brandingView;
                        int i19 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant9 = GlobalDataModel.SELECTED.restaurant;
                        brandingView10.showMcdGoogleMap(i19, restaurant9.f13873name, (Address) null, restaurant9.f13872id);
                    } else if (TalabatUtils.isNullOrEmpty(instance4.getMcdBhBlockAddress().block)) {
                        this.brandingView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, GlobalDataModel.SELECTED.restaurant.f13873name, instance4.getMcdBhBlockAddress(), GlobalDataModel.SELECTED.restaurant.f13872id);
                    } else {
                        this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, instance4.getMcdBhBlockAddress().areaId, instance4.getMcdBhBlockAddress());
                    }
                } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                    Cart instance5 = Cart.getInstance();
                    if (instance5.hasItems()) {
                        if (!instance5.getRestaurant().isGlrEnabled || instance5.getMcdBhBlockAddress() == null) {
                            if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                                this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                                return;
                            }
                            BrandingView brandingView11 = this.brandingView;
                            int i21 = selectedCustomerAddress.areaId;
                            Restaurant restaurant10 = GlobalDataModel.SELECTED.restaurant;
                            brandingView11.showMcdGoogleMap(i21, restaurant10.f13873name, selectedCustomerAddress, restaurant10.f13872id);
                        } else if (TalabatUtils.isNullOrEmpty(instance5.getMcdBhBlockAddress().block)) {
                            BrandingView brandingView12 = this.brandingView;
                            int i22 = GlobalDataModel.SelectedAreaId;
                            Restaurant restaurant11 = GlobalDataModel.SELECTED.restaurant;
                            brandingView12.showMcdGoogleMap(i22, restaurant11.f13873name, selectedCustomerAddress, restaurant11.f13872id);
                        } else {
                            this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, instance5.getMcdBhBlockAddress().areaId, instance5.getMcdBhBlockAddress());
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                        this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                    } else {
                        BrandingView brandingView13 = this.brandingView;
                        int i23 = selectedCustomerAddress.areaId;
                        Restaurant restaurant12 = GlobalDataModel.SELECTED.restaurant;
                        brandingView13.showMcdGoogleMap(i23, restaurant12.f13873name, selectedCustomerAddress, restaurant12.f13872id);
                    }
                } else {
                    BrandingView brandingView14 = this.brandingView;
                    int i24 = selectedCustomerAddress.areaId;
                    Restaurant restaurant13 = GlobalDataModel.SELECTED.restaurant;
                    brandingView14.showMcdGoogleMap(i24, restaurant13.f13873name, selectedCustomerAddress, restaurant13.f13872id);
                }
            } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            } else {
                if (selectedCustomerAddress == null) {
                    Cart instance6 = Cart.getInstance();
                    if (!instance6.hasItems()) {
                        BrandingView brandingView15 = this.brandingView;
                        int i25 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant14 = GlobalDataModel.SELECTED.restaurant;
                        brandingView15.showMcdGoogleMap(i25, restaurant14.f13873name, (Address) null, restaurant14.f13872id);
                    } else if (!instance6.getRestaurant().isGlrEnabled || instance6.getMcdLatLangAddress() == null) {
                        BrandingView brandingView16 = this.brandingView;
                        int i26 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant15 = GlobalDataModel.SELECTED.restaurant;
                        brandingView16.showMcdGoogleMap(i26, restaurant15.f13873name, (Address) null, restaurant15.f13872id);
                    } else if (TalabatUtils.isNullOrEmptyLatLng(instance6.getMcdLatLangAddress().latitude, instance6.getMcdLatLangAddress().longitude)) {
                        this.brandingView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, GlobalDataModel.SELECTED.restaurant.f13873name, instance6.getMcdLatLangAddress(), GlobalDataModel.SELECTED.restaurant.f13872id);
                    } else {
                        this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, instance6.getMcdLatLangAddress().areaId, instance6.getMcdLatLangAddress());
                    }
                } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                    Cart instance7 = Cart.getInstance();
                    if (instance7.hasItems()) {
                        if (!instance7.getRestaurant().isGlrEnabled || instance7.getMcdLatLangAddress() == null) {
                            if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                                this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                                return;
                            }
                            BrandingView brandingView17 = this.brandingView;
                            int i27 = selectedCustomerAddress.areaId;
                            Restaurant restaurant16 = GlobalDataModel.SELECTED.restaurant;
                            brandingView17.showMcdGoogleMap(i27, restaurant16.f13873name, selectedCustomerAddress, restaurant16.f13872id);
                        } else if (TalabatUtils.isNullOrEmptyLatLng(instance7.getMcdLatLangAddress().latitude, instance7.getMcdLatLangAddress().longitude)) {
                            BrandingView brandingView18 = this.brandingView;
                            int i28 = GlobalDataModel.SelectedAreaId;
                            Restaurant restaurant17 = GlobalDataModel.SELECTED.restaurant;
                            brandingView18.showMcdGoogleMap(i28, restaurant17.f13873name, selectedCustomerAddress, restaurant17.f13872id);
                        } else {
                            this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, instance7.getMcdLatLangAddress().areaId, instance7.getMcdLatLangAddress());
                        }
                    } else if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                        this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                    } else {
                        BrandingView brandingView19 = this.brandingView;
                        int i29 = selectedCustomerAddress.areaId;
                        Restaurant restaurant18 = GlobalDataModel.SELECTED.restaurant;
                        brandingView19.showMcdGoogleMap(i29, restaurant18.f13873name, selectedCustomerAddress, restaurant18.f13872id);
                    }
                } else {
                    BrandingView brandingView20 = this.brandingView;
                    int i31 = selectedCustomerAddress.areaId;
                    Restaurant restaurant19 = GlobalDataModel.SELECTED.restaurant;
                    brandingView20.showMcdGoogleMap(i31, restaurant19.f13873name, selectedCustomerAddress, restaurant19.f13872id);
                }
            }
        } else {
            Cart instance8 = Cart.getInstance();
            if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (!instance8.hasItems()) {
                    BrandingView brandingView21 = this.brandingView;
                    int i32 = GlobalDataModel.SelectedAreaId;
                    Restaurant restaurant20 = GlobalDataModel.SELECTED.restaurant;
                    brandingView21.showInforMap(i32, restaurant20.f13872id, restaurant20.f13873name);
                } else if (instance8.getRestaurant().isGlrEnabled && instance8.getInforMapAddress() != null) {
                    if (TalabatUtils.isNullOrEmpty(instance8.getInforMapAddress().getGrlId())) {
                        BrandingView brandingView22 = this.brandingView;
                        int i33 = GlobalDataModel.SelectedAreaId;
                        Restaurant restaurant21 = GlobalDataModel.SELECTED.restaurant;
                        brandingView22.showInforMap(i33, restaurant21.f13872id, restaurant21.f13873name);
                        return;
                    }
                    this.brandingView.showMenuWithGlrID(instance8.getInforMapAddress().grl, GlobalDataModel.SELECTED.restaurant, instance8.getInforMapAddress().areaId);
                }
            } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                if (!instance8.hasItems()) {
                    this.brandingView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, GlobalDataModel.SELECTED.restaurant.f13873name, instance8.getMcdBhBlockAddress(), GlobalDataModel.SELECTED.restaurant.f13872id);
                } else if (instance8.getRestaurant().isGlrEnabled && instance8.getMcdBhBlockAddress() != null) {
                    if (TalabatUtils.isNullOrEmpty(instance8.getMcdBhBlockAddress().block)) {
                        this.brandingView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, GlobalDataModel.SELECTED.restaurant.f13873name, instance8.getMcdBhBlockAddress(), GlobalDataModel.SELECTED.restaurant.f13872id);
                    } else {
                        this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, instance8.getMcdBhBlockAddress().areaId, instance8.getMcdBhBlockAddress());
                    }
                }
            } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            } else {
                if (!instance8.hasItems()) {
                    BrandingView brandingView23 = this.brandingView;
                    int i34 = GlobalDataModel.SelectedAreaId;
                    Restaurant restaurant22 = GlobalDataModel.SELECTED.restaurant;
                    brandingView23.showMcdGoogleMap(i34, restaurant22.f13873name, (Address) null, restaurant22.f13872id);
                } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getMcdLatLangAddress() == null) {
                    BrandingView brandingView24 = this.brandingView;
                    int i35 = GlobalDataModel.SelectedAreaId;
                    Restaurant restaurant23 = GlobalDataModel.SELECTED.restaurant;
                    brandingView24.showMcdGoogleMap(i35, restaurant23.f13873name, (Address) null, restaurant23.f13872id);
                } else if (TalabatUtils.isNullOrEmptyLatLng(instance8.getMcdLatLangAddress().latitude, instance8.getMcdLatLangAddress().longitude)) {
                    this.brandingView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, GlobalDataModel.SELECTED.restaurant.f13873name, instance8.getMcdLatLangAddress(), GlobalDataModel.SELECTED.restaurant.f13872id);
                } else {
                    this.brandingView.showMenuWithMcdStores(GlobalDataModel.SELECTED.restaurant, instance8.getMcdLatLangAddress().areaId, instance8.getMcdLatLangAddress());
                }
            }
        }
    }

    private boolean isAreaInDeliveryAreas(int i11) {
        for (DeliveryArea deliveryArea : GlobalDataModel.restaurantDeliveryAreas) {
            if (deliveryArea.f13835id == i11) {
                return true;
            }
        }
        return false;
    }

    private boolean isTempHomeMpaAddressAvail() {
        if (GlobalDataModel.SelectedAreaId <= 0 || HomeMapTemp.INSTANCE.getHomeMapSavedLatLng() == null) {
            return false;
        }
        return true;
    }

    private void loadMenuOrHomeMap() {
        boolean z11 = false;
        if (isTempHomeMpaAddressAvail()) {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            homeMapTemp.setHomeMapRedirect(false, this.brandingView.getContext());
            double d11 = homeMapTemp.getHomeMapSavedLatLng().latitude;
            double d12 = homeMapTemp.getHomeMapSavedLatLng().longitude;
            Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
            menuLoadingDecesionHandler(d11, d12, restaurant.f13872id, restaurant.branchId);
            return;
        }
        BrandingView brandingView2 = this.brandingView;
        if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName) || GlobalDataModel.SelectedAreaId > 0) {
            z11 = true;
        }
        brandingView2.redirectoHomeMapScreen(z11, "", Boolean.valueOf(!this.selectedAreaisInDeliveyArea));
    }

    private void menuLoadingDecesionHandler(double d11, double d12, int i11, int i12) {
        if (this.isFranchiseRestaurant) {
            int branchId2 = getBranchId(GlobalDataModel.SELECTED.restaurant);
            if (branchId2 <= 0) {
                this.brandingView.onValidationError(25);
            } else if (this.isBranchDeselected) {
                this.brandingView.onValidationError(25);
            } else {
                loadMenuScreen(branchId2);
            }
        } else {
            this.showMenuButtonPressed = true;
            this.brandingView.startLodingPopup();
            getGeoLoactionBasedBranchId(new RestGeoReverseCodingRequest(i11, this.configurationLocalRepository.selectedCountry().getCountryId(), d12, d11, i12));
        }
    }

    private void resetCustomerBrandAddress() {
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            this.custbrandAddress = null;
            instance.resetBrandLocalAddress();
        }
    }

    private void setCustomerBrandAddress() {
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            if (instance.isLoggedIn() && instance.hasAddresses(this.configurationLocalRepository.selectedCountry()) && instance.getSelectedCustomerAddress() != null) {
                instance.setBrandScreenLocalAddress();
            }
        }
    }

    public void ShowMcdBhMenu(int i11) {
        if (i11 > 0) {
            this.isLoadMenuRequestSent = true;
            this.menuLoadCompleted = false;
            this.showMenuButtonPressed = true;
            GlobalDataModel.MENU.doNotLoad = true;
            if (ChoiceLoader.getInstance() != null) {
                ChoiceLoader.stopChoiceLoader();
            }
            callMenuApi(i11);
        }
    }

    public void areaButtonClicked() {
        if (isMapFirstEnabled()) {
            boolean z11 = true;
            if (Customer.getInstance() != null) {
                Customer instance = Customer.getInstance();
                if (!instance.isLoggedIn()) {
                    this.brandingView.redirectoHomeMapScreen(false, "", Boolean.valueOf(true ^ this.selectedAreaisInDeliveyArea));
                } else if (instance.hasAddresses(this.configurationLocalRepository.selectedCountry())) {
                    this.brandingView.redirectoChooseSavedAddressScreen(instance.getSelectedCustomerAddress());
                } else {
                    this.brandingView.redirectoHomeMapScreen(false, "", Boolean.valueOf(true ^ this.selectedAreaisInDeliveyArea));
                }
            } else if (this.selectedAreaisInDeliveyArea) {
                BrandingView brandingView2 = this.brandingView;
                if (TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName) && GlobalDataModel.SelectedAreaId <= 0) {
                    z11 = false;
                }
                brandingView2.redirectoHomeMapScreen(z11, "", Boolean.FALSE);
            } else {
                this.brandingView.redirectoHomeMapScreen(false, "", Boolean.TRUE);
            }
        } else {
            this.brandingView.onRedirectToAreaScreen();
        }
    }

    public void areaSelected() {
        if ((TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) && GlobalDataModel.SELECTED.restaurant.isGlrEnabled && GlobalDataModel.SelectedAreaId > 0) {
            DeliveryArea[] deliveryAreaArr = GlobalDataModel.restaurantDeliveryAreas;
            int length = deliveryAreaArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                DeliveryArea deliveryArea = deliveryAreaArr[i11];
                if (deliveryArea.f13835id == GlobalDataModel.SelectedAreaId) {
                    this.isGrlEnabledArea = deliveryArea.isGlrEnabled;
                    break;
                }
                i11++;
            }
        }
        if (Customer.getInstance().isLoggedIn()) {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            AppTracker.onAreaSelected(this.brandingView.getContext(), GlobalDataModel.SelectedAreaName, "" + GlobalDataModel.SelectedAreaId);
            if (selectedCustomerAddress == null || selectedCustomerAddress.areaId != GlobalDataModel.SelectedAreaId) {
                Customer.getInstance().deselectCustomerAddress(this.brandingView.getContext());
                this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
            } else {
                this.brandingView.setArea(selectedCustomerAddress.profileName + " (" + selectedCustomerAddress.areaName + ")", false, this.selectedAreaisInDeliveyArea);
            }
        } else {
            this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
        }
        if (this.groupId > 0) {
            if (getBranchCount(GlobalDataModel.SelectedAreaId) > 1) {
                this.isFranchiseRestaurant = true;
                this.brandingView.setRestaurantFranchise(true);
            } else {
                GlobalDataModel.SELECTED.restaurant.branchId = getBranchId(GlobalDataModel.SelectedAreaId);
            }
        }
        if (this.isFranchiseRestaurant) {
            this.brandingView.branchVisibility(true);
            this.isFranchiseLoaded = false;
            this.iBrandingInteractor.getRestaurantFranchase(this.groupId, GlobalDataModel.SelectedAreaId);
        }
        this.prelaodMillis = 0;
    }

    public void branchButtionClicked(int i11) {
        if (!this.isMapFirstEnabled) {
            int i12 = GlobalDataModel.SelectedAreaId;
            if (i12 > 0) {
                this.isFranchiseButtonPressed = true;
                if (!this.isFranchiseLoaded || this.franchiseloadedAreaId != i12) {
                    this.brandingView.startLodingPopup();
                    this.isFranchiseLoaded = false;
                    this.iBrandingInteractor.getRestaurantFranchase(this.groupId, GlobalDataModel.SelectedAreaId);
                    return;
                }
                this.brandingView.onRedirectToFranchiseScreen();
                return;
            }
            this.brandingView.onValidationError(15);
        } else if (!TalabatUtils.isNullOrEmpty(getLocChooseBranch())) {
            this.brandingView.redirectFranchiseSelection(getLocChooseBranch(), i11);
        } else {
            this.brandingView.redirectoHomeMapScreen(false, "", Boolean.valueOf(!this.selectedAreaisInDeliveyArea));
        }
    }

    public void branchDeslected(boolean z11) {
        this.isBranchDeselected = z11;
    }

    public void branchSelected() {
        boolean z11;
        int i11;
        this.brandingView.setBranch(GlobalDataModel.SELECTED.restaurant.f13873name);
        if (this.groupId <= 0 || getBranchCount(GlobalDataModel.SelectedAreaId) <= 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.isFranchiseRestaurant = z11;
        if (this.groupId > 0) {
            i11 = getBranchId(GlobalDataModel.SELECTED.restaurant);
        } else {
            i11 = getBranchId(GlobalDataModel.SelectedAreaId);
        }
        this.isLoadMenuRequestSent = true;
        this.menuLoadCompleted = false;
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        callMenuApi(i11);
    }

    @VisibleForTesting
    public void callMenuApi(int i11) {
        if (GlobalDataModel.SELECTED.getRestaurant().shopType == 0) {
            this.brandingView.stopLodingPopup();
            this.brandingView.navigateToFlutterMenu(i11, GlobalDataModel.SELECTED.getRestaurant().deliveryMode(), GlobalDataModel.SELECTED.getRestaurant().isProRestaurant);
            return;
        }
        this.iBrandingInteractor.checkIfMigratedVendor(i11);
    }

    public boolean checkIsFranchiseRes() {
        if (getBranchCount(GlobalDataModel.SelectedAreaId) > 1) {
            this.isFranchiseRestaurant = true;
            this.brandingView.setRestaurantFranchise(true);
        }
        return this.isFranchiseRestaurant;
    }

    public void checkSelectedAddressDeliverable(Address[] addressArr) {
        boolean z11;
        if (this.custbrandAddress != null) {
            int length = addressArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = true;
                    break;
                }
                Address address = addressArr[i11];
                if (this.custbrandAddress.f58343id.equals(address.f58343id)) {
                    z11 = address.isDeliverable;
                    break;
                }
                i11++;
            }
            if (!z11) {
                resetCustomerBrandAddress();
            }
            this.brandingView.selectedAddressDeliverable(z11);
        } else if (GlobalDataModel.SelectedAreaId > 0) {
            this.brandingView.selectedAreaDeliverable(this.selectedAreaisInDeliveyArea);
        }
        if (this.refreshAddressView) {
            setUplocationView(this.isFranchiseRestaurant, false);
            this.refreshAddressView = false;
        }
    }

    public void cityButtonClicked() {
        this.brandingView.onRedirectToCityScreen();
    }

    public void citySelected() {
        this.isFranchiseButtonPressed = false;
        this.brandingView.setCity(GlobalDataModel.SelectedCityName);
        TalabatUtils.resetAreaSelection(this.brandingView.getContext());
        this.brandingView.setArea("", false, this.selectedAreaisInDeliveyArea);
        this.brandingView.setBranch("");
    }

    public int getBranchCount(int i11) {
        for (DeliveryArea deliveryArea : GlobalDataModel.restaurantDeliveryAreas) {
            if (deliveryArea.getId() == i11) {
                return deliveryArea.branchCount;
            }
        }
        return 0;
    }

    public int getBranchId(int i11) {
        for (DeliveryArea deliveryArea : GlobalDataModel.restaurantDeliveryAreas) {
            if (deliveryArea.getId() == i11) {
                return deliveryArea.branchId;
            }
        }
        return -1;
    }

    public void getGrlBasedBrach(InforMapRequest inforMapRequest) {
        this.iBrandingInteractor.getGrlBranchId(inforMapRequest);
    }

    public void getMcdBranchIdFromBlockorLatLng(McdBranchRequest mcdBranchRequest) {
        this.iBrandingInteractor.getBranchIdFromBlockorLatLang(mcdBranchRequest);
    }

    public void gpsToAddressResult(String str, Address address, Area area, City city) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.brandingView.gpsToAddressResultRecieved(str, address, area, city);
        } else if ((address != null && isAreaInDeliveryAreas(address.areaId)) || (area != null && isAreaInDeliveryAreas(area.f13835id))) {
            this.brandingView.gpsToAddressResultRecieved(str, address, area, city);
        } else if (area != null) {
            this.brandingView.showSelectedAreaNotDeliveringPopup(area.areaName);
        }
    }

    public void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse) {
        if (inforMapAddressResponse.talabatResBranchId > 0) {
            this.isLoadMenuRequestSent = true;
            this.menuLoadCompleted = false;
            this.showMenuButtonPressed = true;
            GlobalDataModel.MENU.doNotLoad = true;
            if (ChoiceLoader.getInstance() != null) {
                ChoiceLoader.stopChoiceLoader();
            }
            callMenuApi(inforMapAddressResponse.talabatResBranchId);
        }
    }

    public void grlBranchIdfailed() {
    }

    public boolean isDataValid() {
        long currentTimeMillis = System.currentTimeMillis() - this.menuLoadedTimeStamp;
        if (currentTimeMillis <= 0 || currentTimeMillis >= this.prelaodMillis) {
            return false;
        }
        return true;
    }

    public boolean isMapFirstEnabled() {
        return !GlobalDataModel.SELECTED.restaurant.isGlrEnabled;
    }

    public void loadFranchiseRestBasedLocation(int i11) {
        loadMenuScreenFromMap(i11);
    }

    @VisibleForTesting
    public void loadMenuScreen(int i11) {
        this.isLoadMenuRequestSent = true;
        this.menuLoadCompleted = false;
        this.showMenuButtonPressed = true;
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        this.brandingView.startLodingPopup();
        callMenuApi(i11);
    }

    public void loadMenuScreenFromMap(int i11) {
        this.isLoadMenuRequestSent = true;
        this.menuLoadCompleted = false;
        this.showMenuButtonPressed = true;
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        if (i11 > 0) {
            loadMenuScreen(i11);
        }
    }

    public void locationRecieved(Location location) {
        this.iBrandingInteractor.gpsToAddress(location.getLatitude(), location.getLongitude());
    }

    public void mcdBranchFailed() {
        this.brandingView.mcdServerError();
    }

    public void mcdBranchReceived(McdStoresResponse mcdStoresResponse) {
        if (mcdStoresResponse == null) {
            return;
        }
        if (mcdStoresResponse.result.statusCode == 0) {
            this.isLoadMenuRequestSent = true;
            this.menuLoadCompleted = false;
            this.showMenuButtonPressed = true;
            if (mcdStoresResponse.address != null) {
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempBlockAddress(mcdStoresResponse.address);
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempLatLangAddress(mcdStoresResponse.address);
                }
            }
            GlobalDataModel.MENU.doNotLoad = true;
            if (ChoiceLoader.getInstance() != null) {
                ChoiceLoader.stopChoiceLoader();
            }
            callMenuApi(mcdStoresResponse.tlbBranchId);
            return;
        }
        this.brandingView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, "", (Address) null, GlobalDataModel.SELECTED.restaurant.f13872id);
    }

    public void onDataError() {
        this.brandingView.onDataError();
    }

    public void onDeselectFranchise(boolean z11) {
        if (z11) {
            this.brandingView.setBranch("");
        }
    }

    public void onDestroy() {
        this.brandingView = null;
        IBrandingInteractor iBrandingInteractor2 = this.iBrandingInteractor;
        if (iBrandingInteractor2 != null) {
            iBrandingInteractor2.unregister();
        }
        this.iBrandingInteractor = null;
    }

    public void onEmptyMenuReceived(String str) {
        this.brandingView.onEmptyMenuReceived(str);
    }

    public void onFrachaseLoadingCompleted(Restaurant[] restaurantArr) {
        this.franchiseloadedAreaId = GlobalDataModel.SelectedAreaId;
        GlobalDataModel.JSON.franchiseRestaurants = restaurantArr;
        this.isFranchiseLoaded = true;
        if (this.isFranchiseButtonPressed) {
            this.isFranchiseButtonPressed = false;
            this.brandingView.onRedirectToFranchiseScreen();
        }
    }

    public void onFrnachisebranchSelected() {
        this.brandingView.branchVisibility(true);
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        MenuItemsResponseModel menuItemsResponseModel2;
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && (menuItemsResponseModel2 = GlobalDataModel.JSON.menuItemsResponseModel) != null && menuItemsResponseModel2.restaurant != null && instance.getRestaurant().f13873name.equals(GlobalDataModel.JSON.menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(GlobalDataModel.JSON.menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.menuLoadCompleted = true;
        if (this.groupId > 0) {
            this.menuPreloadedBranchId = getBranchId(GlobalDataModel.SELECTED.restaurant);
        } else {
            this.menuPreloadedBranchId = getBranchId(GlobalDataModel.SelectedAreaId);
        }
        this.menuLoadedTimeStamp = System.currentTimeMillis();
        if (this.showMenuButtonPressed) {
            this.brandingView.onRedirectToGroceryMenuPage();
            this.showMenuButtonPressed = false;
        }
    }

    public void onMenuLoadingCompleted() {
        MenuItemsResponseModel menuItemsResponseModel;
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && (menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel) != null && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(GlobalDataModel.JSON.menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(GlobalDataModel.JSON.menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.menuLoadCompleted = true;
        if (this.groupId > 0) {
            this.menuPreloadedBranchId = getBranchId(GlobalDataModel.SELECTED.restaurant);
        } else {
            this.menuPreloadedBranchId = getBranchId(GlobalDataModel.SelectedAreaId);
        }
        this.menuLoadedTimeStamp = System.currentTimeMillis();
        if (this.showMenuButtonPressed) {
            this.brandingView.onRedirectToMenuPage();
            this.showMenuButtonPressed = false;
        }
    }

    public void onMigratedInfoSuccess(Restaurant restaurant) {
        this.brandingView.stopLodingPopup();
        this.brandingView.onMigratedVendorLoaded(restaurant);
    }

    public void onNetworkError() {
        this.brandingView.onNetworkError();
    }

    public void onNotMigratedVendor(int i11) {
        callMenuApiIfNotMigrated(i11);
    }

    public void onRequestError() {
        BrandingView brandingView2 = this.brandingView;
        if (brandingView2 != null) {
            brandingView2.onRequestError();
        }
    }

    public void onResCompleted() {
        this.brandingView.stopLodingPopup();
    }

    public void onResponseError() {
        this.brandingView.stopLodingPopup();
    }

    public void onServerError(VolleyError volleyError) {
        this.brandingView.onServerError(volleyError);
    }

    public void resBasereverseGeocodingResult(RestGeoAddressResult restGeoAddressResult) {
        if (restGeoAddressResult != null) {
            RestGeoAddressBranchInfo restGeoAddressBranchInfo = restGeoAddressResult.branchInfo;
            if (restGeoAddressBranchInfo != null) {
                int i11 = restGeoAddressBranchInfo.branchId;
                if (i11 > 0) {
                    callMenuApi(i11);
                } else {
                    brandDeliverHere(restGeoAddressResult);
                }
            } else {
                brandDeliverHere(restGeoAddressResult);
            }
        } else {
            this.brandingView.stopLodingPopup();
        }
    }

    public void setFrachiseBranchName() {
        this.brandingView.setBranch(GlobalDataModel.SELECTED.restaurant.f13873name);
    }

    public void setUpViews(DeliveryArea[] deliveryAreaArr) {
        boolean z11;
        boolean z12;
        String str;
        Address address;
        this.deliveryAreas = deliveryAreaArr;
        if (TalabatUtils.isMapPackageEnabledCountry(this.configurationLocalRepository, this.locationConfigRepository)) {
            this.brandingView.setGpsVisibility(true);
        } else {
            this.brandingView.setGpsVisibility(false);
        }
        this.brandingView.cityVisibility(false);
        this.brandingView.setRestaurantLogo(GlobalDataModel.SELECTED.restaurant.getLogo());
        this.brandingView.setRestaurantName(GlobalDataModel.SELECTED.restaurant.f13873name);
        this.brandingView.setCuisines(GlobalDataModel.SELECTED.restaurant.getCuisineString());
        if (GlobalDataModel.SelectedAreaId > 0) {
            DeliveryArea[] deliveryAreaArr2 = GlobalDataModel.restaurantDeliveryAreas;
            int length = deliveryAreaArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                DeliveryArea deliveryArea = deliveryAreaArr2[i11];
                if (deliveryArea.f13835id == GlobalDataModel.SelectedAreaId) {
                    this.selectedAreaisInDeliveyArea = true;
                    this.isGrlEnabledArea = deliveryArea.isGlrEnabled;
                    break;
                }
                i11++;
            }
            if (!this.selectedAreaisInDeliveyArea && (address = this.custbrandAddress) != null && address.longitude == 0.0d && address.latitude == 0.0d) {
                resetCustomerBrandAddress();
            }
        }
        Country selectedCountry = this.configurationLocalRepository.selectedCountry();
        if (selectedCountry == Country.KSA || selectedCountry == Country.UAE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((TalabatUtils.getDatamodelsSelectedCountry(selectedCountry, this.locationConfigRepository).isCityInAddress || z11) && GlobalDataModel.SelectedCityId > 0) {
            DeliveryArea[] deliveryAreaArr3 = GlobalDataModel.restaurantDeliveryAreas;
            int length2 = deliveryAreaArr3.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    break;
                } else if (deliveryAreaArr3[i12].cityId == GlobalDataModel.SelectedCityId) {
                    z12 = true;
                    break;
                } else {
                    i12++;
                }
            }
        }
        z12 = false;
        String str2 = "";
        if (!z12) {
            GlobalDataModel.SelectedCityId = 0;
            GlobalDataModel.SelectedCityName = str2;
        } else if (GlobalDataModel.SelectedCityId > 0) {
            this.brandingView.setCity(GlobalDataModel.SelectedCityName);
        }
        if (this.isMapFirstEnabled) {
            if (Customer.getInstance().isLoggedIn()) {
                Address address2 = this.custbrandAddress;
                if (address2 != null) {
                    BrandingView brandingView2 = this.brandingView;
                    if (!TalabatUtils.isNullOrEmpty(address2.profileName)) {
                        str2 = this.custbrandAddress.profileName + " (" + this.custbrandAddress.areaName + ")";
                    }
                    brandingView2.setArea(str2, true, this.selectedAreaisInDeliveyArea);
                    return;
                }
                this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
                return;
            }
            this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
        } else if (this.selectedAreaisInDeliveyArea) {
            if (GlobalDataModel.SelectedAreaId > 0) {
                if (Customer.getInstance().isLoggedIn()) {
                    if (!Customer.getInstance().hasAddresses(selectedCountry) || TalabatUtils.isNullOrEmpty(Customer.getInstance().getSelectedCustomerAddressId())) {
                        str = GlobalDataModel.SelectedAreaName;
                    } else {
                        Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
                        if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.profileName)) {
                            str = selectedCustomerAddress.profileName + " (" + selectedCustomerAddress.areaName + ")";
                        } else {
                            str = selectedCustomerAddress.areaName;
                        }
                    }
                    this.brandingView.setArea(str, false, this.selectedAreaisInDeliveyArea);
                } else {
                    this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
                }
            }
            boolean z13 = this.isFranchiseRestaurant;
            if (z13) {
                this.iBrandingInteractor.getRestaurantFranchase(this.groupId, GlobalDataModel.SelectedAreaId);
                return;
            }
            this.isLoadMenuRequestSent = true;
            this.menuLoadCompleted = false;
            if (z13) {
                getBranchId(GlobalDataModel.SELECTED.restaurant);
            } else {
                getBranchId(GlobalDataModel.SelectedAreaId);
            }
        } else {
            GlobalDataModel.SelectedAreaId = 0;
            GlobalDataModel.SelectedAreaName = str2;
        }
    }

    public void setUplocationView(boolean z11, boolean z12) {
        String str;
        getBranchLocalAddress();
        if (Customer.getInstance().isLoggedIn()) {
            Address address = this.custbrandAddress;
            if (address != null) {
                BrandingView brandingView2 = this.brandingView;
                if (TalabatUtils.isNullOrEmpty(address.profileName)) {
                    str = "";
                } else {
                    str = this.custbrandAddress.profileName + " (" + this.custbrandAddress.areaName + ")";
                }
                brandingView2.setArea(str, true, this.selectedAreaisInDeliveyArea);
                if (z12) {
                    Customer.getInstance().updateDeliveryAddress(this.custbrandAddress);
                    return;
                }
                return;
            }
            this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
            return;
        }
        this.brandingView.setArea(GlobalDataModel.SelectedAreaName, false, this.selectedAreaisInDeliveyArea);
    }

    public void showGrlMenu(int i11) {
        this.isLoadMenuRequestSent = true;
        this.menuLoadCompleted = false;
        this.showMenuButtonPressed = true;
        this.brandingView.startLodingPopup();
        if (i11 > 0) {
            GlobalDataModel.MENU.doNotLoad = true;
            if (ChoiceLoader.getInstance() != null) {
                ChoiceLoader.stopChoiceLoader();
            }
            callMenuApi(i11);
        }
    }

    public void showMenu() {
        int i11;
        if (TalabatUtils.getDatamodelsSelectedCountry(this.configurationLocalRepository.selectedCountry(), this.locationConfigRepository).isCityInAddress && GlobalDataModel.SelectedCityId == 0) {
            this.brandingView.onValidationError(20);
        } else if (GlobalDataModel.SelectedAreaId == 0) {
            this.brandingView.onValidationError(15);
        } else if (this.isFranchiseRestaurant && getBranchId(GlobalDataModel.SELECTED.restaurant) <= 0) {
            this.brandingView.onValidationError(25);
        } else if ((TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) && GlobalDataModel.SELECTED.restaurant.isGlrEnabled && this.isGrlEnabledArea) {
            informMapDecisionMakerHandler();
        } else {
            this.showMenuButtonPressed = true;
            if (this.groupId > 0) {
                i11 = getBranchId(GlobalDataModel.SELECTED.restaurant);
            } else {
                i11 = getBranchId(GlobalDataModel.SelectedAreaId);
            }
            this.isLoadMenuRequestSent = true;
            this.menuLoadCompleted = false;
            this.brandingView.startLodingPopup();
            GlobalDataModel.MENU.doNotLoad = true;
            if (ChoiceLoader.getInstance() != null) {
                ChoiceLoader.stopChoiceLoader();
            }
            callMenuApi(i11);
        }
    }

    public void showMenuMf() {
        String str;
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            if (!instance.isLoggedIn()) {
                loadMenuOrHomeMap();
            } else if (!instance.hasAddresses(this.configurationLocalRepository.selectedCountry())) {
                loadMenuOrHomeMap();
            } else if (GlobalDataModel.SelectedAreaId == 0) {
                this.brandingView.redirectoChooseSavedAddressScreen(this.custbrandAddress);
            } else {
                Address address = this.custbrandAddress;
                boolean z11 = false;
                if (address != null) {
                    if (address.latitude <= 0.0d || address.longitude <= 0.0d) {
                        Gson gson = UniversalGson.INSTANCE.gson;
                        BrandingView brandingView2 = this.brandingView;
                        if (!(gson instanceof Gson)) {
                            str = gson.toJson((Object) address);
                        } else {
                            str = GsonInstrumentation.toJson(gson, (Object) address);
                        }
                        brandingView2.redirectoHomeMapScreen(true, str, Boolean.valueOf(!this.selectedAreaisInDeliveyArea));
                        return;
                    }
                    HomeMapTemp.INSTANCE.setHomeMapRedirect(false, this.brandingView.getContext());
                    Address address2 = this.custbrandAddress;
                    double d11 = address2.latitude;
                    double d12 = address2.longitude;
                    Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
                    menuLoadingDecesionHandler(d11, d12, restaurant.f13872id, restaurant.branchId);
                } else if (isTempHomeMpaAddressAvail()) {
                    HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                    homeMapTemp.setHomeMapRedirect(true, this.brandingView.getContext());
                    double d13 = homeMapTemp.getHomeMapSavedLatLng().latitude;
                    double d14 = homeMapTemp.getHomeMapSavedLatLng().longitude;
                    Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                    menuLoadingDecesionHandler(d13, d14, restaurant2.f13872id, restaurant2.branchId);
                } else if (instance.hasAddresses()) {
                    this.brandingView.redirectoChooseSavedAddressScreen((Address) null);
                } else {
                    BrandingView brandingView3 = this.brandingView;
                    if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName) || GlobalDataModel.SelectedAreaId > 0) {
                        z11 = true;
                    }
                    brandingView3.redirectoHomeMapScreen(z11, "", Boolean.valueOf(!this.selectedAreaisInDeliveyArea));
                }
            }
        } else {
            loadMenuOrHomeMap();
        }
    }

    public void updateIsAreaDeliverable() {
        this.selectedAreaisInDeliveyArea = true;
    }

    public void onServerError() {
        this.brandingView.onServerError();
    }

    public int getBranchId(Restaurant restaurant) {
        return restaurant.branchId;
    }
}
