package library.talabat.mvp.restaurantssearch;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.ItemSearchResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.RestaurantSearchResponse;
import android.os.Handler;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import buisnessmodels.McdMapTempAddress;
import com.android.volley.VolleyError;
import com.google.android.gms.common.util.ArrayUtils;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;
import datamodels.RestaurantsSearchWrapperClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.restaurantlistrefactor.IMenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public class RestaurantsSearchPresenter implements IRestaurantsSearchPresenter, RestaurantsSearchListener, MenuApiListener {
    /* access modifiers changed from: private */
    public static final String TAG = "RestaurantsSearchPresenter";

    /* renamed from: a  reason: collision with root package name */
    public Restaurant f26856a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferencesManager f26857b;

    /* renamed from: c  reason: collision with root package name */
    public FromScreen f26858c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<RestaurantSearchResponse> f26859d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RestaurantSearchResponse> f26860e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26861f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26862g;

    /* renamed from: h  reason: collision with root package name */
    public int f26863h = 0;
    private Handler mInstantSearchHandler = new Handler();
    /* access modifiers changed from: private */
    public IRestaurantsSearchInteractor mInteractor;
    private IMenuApiInteractor mMenuApiInteractor;
    /* access modifiers changed from: private */
    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    private IRestaurantsSearchView mView;

    public enum FromScreen {
        list,
        collection,
        grocery
    }

    public RestaurantsSearchPresenter(AppVersionProvider appVersionProvider, IRestaurantsSearchView iRestaurantsSearchView, SharedPreferencesManager sharedPreferencesManager, boolean z11) {
        this.mView = iRestaurantsSearchView;
        this.f26861f = z11;
        this.f26857b = sharedPreferencesManager;
        this.mInteractor = new RestaurantsSearchInteractor(this);
        this.mMenuApiInteractor = new MenuApiInteractor(appVersionProvider);
    }

    private ArrayList<RestaurantsSearchWrapperClass> buildResultsWrapperClasses(ArrayList<RestaurantSearchResponse> arrayList, ArrayList<RestaurantSearchResponse> arrayList2, ArrayList<RestaurantSearchResponse> arrayList3, ArrayList<RestaurantSearchResponse> arrayList4, ArrayList<RestaurantSearchResponse> arrayList5, ArrayList<RestaurantSearchResponse> arrayList6, boolean z11) {
        int i11;
        int i12;
        ArrayList<RestaurantsSearchWrapperClass> arrayList7 = new ArrayList<>();
        int i13 = 0;
        if (arrayList != null) {
            i11 = arrayList.size();
        } else {
            i11 = 0;
        }
        if (arrayList2 != null) {
            i12 = arrayList2.size();
        } else {
            i12 = 0;
        }
        int i14 = i11 + i12;
        if (arrayList3 != null) {
            i13 = arrayList3.size();
        }
        int i15 = i14 + i13;
        if (i15 > 0) {
            if (z11) {
                arrayList7.add(new RestaurantsSearchWrapperClass((Restaurant) null, (ArrayList<ItemSearchResponse>) null, i15 + "", 0, 2));
            }
            if (arrayList != null) {
                Iterator<RestaurantSearchResponse> it = arrayList.iterator();
                while (it.hasNext()) {
                    RestaurantSearchResponse next = it.next();
                    arrayList7.add(new RestaurantsSearchWrapperClass(next.restaurant, (ArrayList<ItemSearchResponse>) null, (String) null, next.itemCount, 0));
                }
            }
            if (arrayList2 != null) {
                Iterator<RestaurantSearchResponse> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    RestaurantSearchResponse next2 = it2.next();
                    arrayList7.add(new RestaurantsSearchWrapperClass(next2.restaurant, (ArrayList<ItemSearchResponse>) null, (String) null, next2.itemCount, 0));
                }
            }
            if (arrayList3 != null) {
                Iterator<RestaurantSearchResponse> it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    RestaurantSearchResponse next3 = it3.next();
                    arrayList7.add(new RestaurantsSearchWrapperClass(next3.restaurant, (ArrayList<ItemSearchResponse>) null, (String) null, next3.itemCount, 0));
                }
            }
        }
        int size = arrayList4.size() + arrayList5.size() + arrayList6.size();
        if (size > 0) {
            if (z11) {
                arrayList7.add(new RestaurantsSearchWrapperClass((Restaurant) null, (ArrayList<ItemSearchResponse>) null, size + "", 0, 3));
            }
            this.f26863h = arrayList7.size() - 1;
            Iterator<RestaurantSearchResponse> it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                RestaurantSearchResponse next4 = it4.next();
                arrayList7.add(new RestaurantsSearchWrapperClass(next4.restaurant, next4.menuItems, (String) null, next4.itemCount, 1));
            }
            Iterator<RestaurantSearchResponse> it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                RestaurantSearchResponse next5 = it5.next();
                arrayList7.add(new RestaurantsSearchWrapperClass(next5.restaurant, next5.menuItems, (String) null, next5.itemCount, 1));
            }
            Iterator<RestaurantSearchResponse> it6 = arrayList6.iterator();
            while (it6.hasNext()) {
                RestaurantSearchResponse next6 = it6.next();
                arrayList7.add(new RestaurantsSearchWrapperClass(next6.restaurant, next6.menuItems, (String) null, next6.itemCount, 1));
            }
        }
        return arrayList7;
    }

    private ArrayList<String> getTabs(ArrayList<RestaurantSearchResponse> arrayList, ArrayList<RestaurantSearchResponse> arrayList2) {
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (arrayList.size() > 0) {
            arrayList3.add("Restaurants");
        }
        if (arrayList2.size() > 0) {
            arrayList3.add("Dishes");
        }
        return arrayList3;
    }

    private ArrayList<Restaurant> searchRestaurantsLocally(String str) {
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        Iterator<Restaurant> it = this.mRestaurants.iterator();
        while (it.hasNext()) {
            Restaurant next = it.next();
            if (next.getName().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() <= 0) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator<Restaurant> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Restaurant next2 = it2.next();
            int i11 = next2.statusType;
            if (i11 == 1) {
                arrayList4.add(next2);
            } else if (i11 == 2 || i11 == 4) {
                arrayList3.add(next2);
            } else {
                arrayList2.add(next2);
            }
        }
        ArrayList<Restaurant> arrayList5 = new ArrayList<>();
        arrayList5.addAll(arrayList2);
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        return arrayList5;
    }

    private void setRestaurants() {
        FilterEngine filterEngine;
        ArrayList<Restaurant> arrayList;
        FilterEngine filterEngine2;
        FromScreen fromScreen = this.f26858c;
        if (fromScreen == FromScreen.collection) {
            if (this.f26861f || (filterEngine2 = GlobalDataModel.collectionFilterEngine) == null || !filterEngine2.isAnyKindOfCollectionFilterApplied()) {
                this.mRestaurants = GlobalDataModel.collectionRestaurants;
                return;
            }
            ArrayList<Restaurant> filterRestaurants = GlobalDataModel.collectionFilterEngine.filterRestaurants(GlobalDataModel.collectionSearchRestaurants);
            this.mRestaurants = filterRestaurants;
            GlobalDataModel.collectionFilterEngine.sortRestaurant(filterRestaurants);
        } else if (fromScreen == FromScreen.grocery) {
            List<Restaurant> list = GlobalDataModel.groceryRestaurants;
            if (list != null) {
                arrayList = (ArrayList) list;
            } else {
                arrayList = new ArrayList<>();
            }
            this.mRestaurants = arrayList;
        } else if (this.f26861f || (filterEngine = GlobalDataModel.filterEngine) == null || !filterEngine.isAnyKindOfFilterApplied()) {
            Restaurant[] restaurantArr = GlobalDataModel.restaurants;
            if (restaurantArr == null) {
                restaurantArr = new Restaurant[0];
            }
            this.mRestaurants = ArrayUtils.toArrayList(restaurantArr);
        } else {
            ArrayList<Restaurant> filterRestaurants2 = GlobalDataModel.filterEngine.filterRestaurants(ArrayUtils.toArrayList(GlobalDataModel.restaurants));
            this.mRestaurants = filterRestaurants2;
            GlobalDataModel.filterEngine.sortRestaurant(filterRestaurants2);
        }
    }

    public void cancelSearch() {
        if (this.mInteractor != null) {
            Handler handler = this.mInstantSearchHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.mInteractor.unregister();
        }
    }

    public void clearRecentSearch() {
        this.f26857b.saveRecentSearchKeyTerms(new ArrayList());
        this.mView.hideRecentSearch();
    }

    public void getBranchIdFromGrl(InforMapRequest inforMapRequest) {
        this.mMenuApiInteractor.getBranchIdFromGrl(this, inforMapRequest);
    }

    public int getDishesHeaderPosition() {
        return this.f26863h;
    }

    public void getItemPosition(ItemSearchResponse itemSearchResponse) {
    }

    public int getItemsCount() {
        ArrayList<RestaurantSearchResponse> arrayList = this.f26860e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void getMcdBranchIdFromBlockorLatLng(McdBranchRequest mcdBranchRequest) {
        this.mMenuApiInteractor.getBranchIdFromBlockorLatLang(this, mcdBranchRequest);
    }

    public void getRecentSearch() {
        Handler handler = this.mInstantSearchHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        ArrayList<String> recentSearchKeyTerms = this.f26857b.getRecentSearchKeyTerms();
        this.mView.hideNoResult();
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.hideInstanceSearch();
        this.mView.hideTrending();
        this.mView.hideSuggestionSearch();
        if (recentSearchKeyTerms == null || recentSearchKeyTerms.size() <= 0) {
            this.mView.hideRecentSearch();
        } else {
            this.mView.showRecentSearch(recentSearchKeyTerms);
        }
    }

    public int getRestaurantsCount() {
        ArrayList<RestaurantSearchResponse> arrayList = this.f26859d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void grlBranchIdFailed() {
    }

    public void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse) {
        Restaurant restaurant = this.f26856a;
        restaurant.branchId = inforMapAddressResponse.talabatResBranchId;
        setSelectedRestaurant(restaurant);
    }

    public void hideAllViews() {
        this.mView.hideNoResult();
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.hideInstanceSearch();
        this.mView.hideRecentSearch();
    }

    public void logNetworkError(String str) {
    }

    public void mcdBranchFailed() {
        this.mView.mcdServerError();
    }

    public void mcdBranchReceived(McdStoresResponse mcdStoresResponse) {
        if (mcdStoresResponse == null) {
            return;
        }
        if (mcdStoresResponse.result.statusCode == 0) {
            this.f26856a.branchId = mcdStoresResponse.tlbBranchId;
            if (mcdStoresResponse.address != null) {
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempBlockAddress(mcdStoresResponse.address);
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempLatLangAddress(mcdStoresResponse.address);
                }
            }
            setSelectedRestaurant(this.f26856a);
            return;
        }
        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, "", (Address) null, this.f26856a.f13872id);
    }

    public void mcdMapDecisionMakerHandler(Restaurant restaurant) {
        this.f26856a = restaurant;
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        if (TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) {
            Customer instance = Customer.getInstance();
            if (instance.isLoggedIn()) {
                Address selectedCustomerAddress = instance.getSelectedCustomerAddress();
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (selectedCustomerAddress == null) {
                        Cart instance2 = Cart.getInstance();
                        if (!instance2.hasItems()) {
                            this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                        } else if (!instance2.getRestaurant().isGlrEnabled || instance2.getInforMapAddress() == null) {
                            this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                        } else if (TalabatUtils.isNullOrEmpty(instance2.getInforMapAddress().grl)) {
                            this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                        } else {
                            this.mView.showMenuWithGlrID(instance2.getInforMapAddress().grl, restaurant, GlobalDataModel.SelectedAreaId);
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                        Cart instance3 = Cart.getInstance();
                        if (instance3.hasItems()) {
                            if (!instance3.getRestaurant().isGlrEnabled || instance3.getInforMapAddress() == null) {
                                if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.grl)) {
                                    this.mView.showMenuWithGlrID(selectedCustomerAddress.grl, restaurant, selectedCustomerAddress.areaId);
                                } else {
                                    this.mView.showInforMap(selectedCustomerAddress.areaId, restaurant.f13873name);
                                }
                            } else if (TalabatUtils.isNullOrEmpty(instance3.getInforMapAddress().grl)) {
                                this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                            } else {
                                this.mView.showMenuWithGlrID(instance3.getInforMapAddress().grl, restaurant, GlobalDataModel.SelectedAreaId);
                            }
                        } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.grl)) {
                            this.mView.showMenuWithGlrID(selectedCustomerAddress.grl, restaurant, selectedCustomerAddress.areaId);
                        } else {
                            this.mView.showInforMap(selectedCustomerAddress.areaId, restaurant.f13873name);
                        }
                    } else {
                        this.mView.showInforMap(selectedCustomerAddress.areaId, restaurant.f13873name);
                    }
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (selectedCustomerAddress == null) {
                        Cart instance4 = Cart.getInstance();
                        if (!instance4.hasItems()) {
                            this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (!instance4.getRestaurant().isGlrEnabled || instance4.getMcdBhBlockAddress() == null) {
                            this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (TalabatUtils.isNullOrEmpty(instance4.getMcdBhBlockAddress().block)) {
                            this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance4.getMcdBhBlockAddress(), restaurant.f13872id);
                        } else {
                            this.mView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance4.getMcdBhBlockAddress());
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                        Cart instance5 = Cart.getInstance();
                        if (instance5.hasItems()) {
                            if (!instance5.getRestaurant().isGlrEnabled || instance5.getMcdBhBlockAddress() == null) {
                                if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                                    this.mView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                                } else {
                                    this.mView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                                }
                            } else if (TalabatUtils.isNullOrEmpty(instance5.getMcdBhBlockAddress().block)) {
                                this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance5.getMcdBhBlockAddress(), restaurant.f13872id);
                            } else {
                                this.mView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance5.getMcdBhBlockAddress());
                            }
                        } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                            this.mView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                        } else {
                            this.mView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                        }
                    } else {
                        this.mView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                    }
                } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
                } else {
                    if (selectedCustomerAddress == null) {
                        Cart instance6 = Cart.getInstance();
                        if (!instance6.hasItems()) {
                            this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (!instance6.getRestaurant().isGlrEnabled || instance6.getMcdLatLangAddress() == null) {
                            this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                        } else if (TalabatUtils.isNullOrEmptyLatLng(instance6.getMcdLatLangAddress().latitude, instance6.getMcdLatLangAddress().longitude)) {
                            this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance6.getMcdLatLangAddress(), restaurant.f13872id);
                        } else {
                            this.mView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance6.getMcdLatLangAddress());
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                        Cart instance7 = Cart.getInstance();
                        if (instance7.hasItems()) {
                            if (!instance7.getRestaurant().isGlrEnabled || instance7.getMcdLatLangAddress() == null) {
                                if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                                    this.mView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                                } else {
                                    this.mView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                                }
                            } else if (TalabatUtils.isNullOrEmptyLatLng(instance7.getMcdLatLangAddress().latitude, instance7.getMcdLatLangAddress().longitude)) {
                                this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance7.getMcdLatLangAddress(), restaurant.f13872id);
                            } else {
                                this.mView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance7.getMcdLatLangAddress());
                            }
                        } else if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                            this.mView.showMenuWithMcdStores(restaurant, selectedCustomerAddress.areaId, selectedCustomerAddress);
                        } else {
                            this.mView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                        }
                    } else {
                        this.mView.showMcdGoogleMap(selectedCustomerAddress.areaId, restaurant.f13873name, selectedCustomerAddress, restaurant.f13872id);
                    }
                }
            } else {
                Cart instance8 = Cart.getInstance();
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (!instance8.hasItems()) {
                        this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                    } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getInforMapAddress() == null) {
                        this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                    } else if (TalabatUtils.isNullOrEmpty(instance8.getInforMapAddress().grl)) {
                        this.mView.showInforMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name);
                    } else {
                        this.mView.showMenuWithGlrID(instance8.getInforMapAddress().grl, restaurant, GlobalDataModel.SelectedAreaId);
                    }
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (!instance8.hasItems()) {
                        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getMcdBhBlockAddress() == null) {
                        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (TalabatUtils.isNullOrEmpty(instance8.getMcdBhBlockAddress().block)) {
                        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance8.getMcdBhBlockAddress(), restaurant.f13872id);
                    } else {
                        this.mView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance8.getMcdBhBlockAddress());
                    }
                } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
                } else {
                    if (!instance8.hasItems()) {
                        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (!instance8.getRestaurant().isGlrEnabled || instance8.getMcdLatLangAddress() == null) {
                        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, (Address) null, restaurant.f13872id);
                    } else if (TalabatUtils.isNullOrEmptyLatLng(instance8.getMcdLatLangAddress().latitude, instance8.getMcdLatLangAddress().longitude)) {
                        this.mView.showMcdGoogleMap(GlobalDataModel.SelectedAreaId, restaurant.f13873name, instance8.getMcdLatLangAddress(), restaurant.f13872id);
                    } else {
                        this.mView.showMenuWithMcdStores(restaurant, GlobalDataModel.SelectedAreaId, instance8.getMcdLatLangAddress());
                    }
                }
            }
        } else {
            setSelectedRestaurant(restaurant);
        }
    }

    public void onDataError() {
    }

    public void onDestroy() {
        IRestaurantsSearchInteractor iRestaurantsSearchInteractor = this.mInteractor;
        if (iRestaurantsSearchInteractor != null) {
            iRestaurantsSearchInteractor.unregister();
        }
    }

    public void onEmptyMenuReceived(String str) {
        this.mView.onEmptyMenuReceived(str);
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        this.mView.onGroceryMenuLoadingCompleted(menuItemsResponseModel);
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        this.mView.onMenuLoadingCompleted(menuItemsResponseModel);
    }

    public void onNetworkError() {
        this.mView.onNetworkError();
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.hideNoResult();
        this.mView.hideRecentSearch();
        this.mView.hideTrending();
        this.mView.hideInstanceSearch();
        this.mView.hideSuggestionSearch();
    }

    public void onRequestError() {
        IRestaurantsSearchView iRestaurantsSearchView = this.mView;
        if (iRestaurantsSearchView != null) {
            iRestaurantsSearchView.onRequestError();
        }
    }

    public void onServerError() {
        this.mView.onServerError();
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void performInstanceSearch(String str) {
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.hideRecentSearch();
        this.mView.hideTrending();
        this.mView.hideInstanceSearch();
        this.mView.hideNoResult();
        this.mView.hideSuggestionSearch();
        this.mView.showInstanceResult(searchRestaurantsLocally(str), str);
    }

    public void performSuggestionsSearch(final String str, final String str2) {
        this.f26862g = true;
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.hideRecentSearch();
        this.mView.hideTrending();
        this.mView.hideInstanceSearch();
        this.mView.hideNoResult();
        this.mView.hideSuggestionSearch();
        this.mView.hideDishesSuggestionSearch();
        ArrayList<Restaurant> searchRestaurantsLocally = searchRestaurantsLocally(str);
        if (searchRestaurantsLocally.size() > 0) {
            if (searchRestaurantsLocally.size() > 5) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < 5; i11++) {
                    arrayList.add(searchRestaurantsLocally.get(i11));
                }
                this.mView.showRestaurantsSuggestionsSearch(str, arrayList, true);
            } else {
                this.mView.showRestaurantsSuggestionsSearch(str, searchRestaurantsLocally, false);
            }
            this.mView.showSuggestionSearch();
            this.mView.hideLoading();
            this.mView.hideNoResult();
        } else {
            this.mView.hideRestaurantsSuggestionSearch();
            this.mView.hideNoResult();
            this.mView.showLoading();
        }
        this.mInstantSearchHandler.removeCallbacksAndMessages((Object) null);
        if (str.length() >= 2) {
            this.mInstantSearchHandler.postDelayed(new Runnable() {
                public void run() {
                    StringBuilder sb2 = new StringBuilder();
                    if (RestaurantsSearchPresenter.this.mRestaurants != null) {
                        Iterator it = RestaurantsSearchPresenter.this.mRestaurants.iterator();
                        while (it.hasNext()) {
                            Restaurant restaurant = (Restaurant) it.next();
                            if (sb2.length() == 0) {
                                sb2.append(restaurant.getBranchId());
                            } else {
                                sb2.append(",");
                                sb2.append(restaurant.getBranchId());
                            }
                        }
                        String unused = RestaurantsSearchPresenter.TAG;
                        if (RestaurantsSearchPresenter.this.mInteractor != null) {
                            RestaurantsSearchPresenter.this.mInteractor.searchForRestaurants(sb2.toString(), str, str2, false);
                        }
                    }
                }
            }, 500);
        }
    }

    public void resultReceived(ArrayList<RestaurantSearchResponse> arrayList, String str, boolean z11) {
        String str2 = str;
        this.f26859d = new ArrayList<>();
        this.f26860e = new ArrayList<>();
        ArrayList<Restaurant> arrayList2 = this.mRestaurants;
        if (arrayList2 != null) {
            Iterator<Restaurant> it = arrayList2.iterator();
            while (it.hasNext()) {
                Restaurant next = it.next();
                if (next.getName().toLowerCase().trim().contains(str.toLowerCase().trim())) {
                    RestaurantSearchResponse restaurantSearchResponse = new RestaurantSearchResponse();
                    restaurantSearchResponse.restaurant = next;
                    this.f26859d.add(restaurantSearchResponse);
                }
            }
        }
        Iterator<RestaurantSearchResponse> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            RestaurantSearchResponse next2 = it2.next();
            Iterator<Restaurant> it3 = this.mRestaurants.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Restaurant next3 = it3.next();
                if (next3.getBranchId() == next2.branchId) {
                    next2.restaurant = next3;
                    break;
                }
            }
        }
        Iterator<RestaurantSearchResponse> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            RestaurantSearchResponse next4 = it4.next();
            ArrayList<ItemSearchResponse> arrayList3 = next4.menuItems;
            if (arrayList3 != null && arrayList3.size() > 0) {
                this.f26860e.add(next4);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        Iterator<RestaurantSearchResponse> it5 = this.f26859d.iterator();
        while (it5.hasNext()) {
            RestaurantSearchResponse next5 = it5.next();
            int i11 = next5.restaurant.statusType;
            if (i11 == 2 || i11 == 4) {
                arrayList5.add(next5);
            } else if (i11 == 1) {
                arrayList6.add(next5);
            } else {
                arrayList4.add(next5);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        Iterator<RestaurantSearchResponse> it6 = this.f26860e.iterator();
        while (it6.hasNext()) {
            RestaurantSearchResponse next6 = it6.next();
            int i12 = next6.restaurant.statusType;
            if (i12 == 2 || i12 == 4) {
                arrayList8.add(next6);
            } else if (i12 == 1) {
                arrayList9.add(next6);
            } else {
                arrayList7.add(next6);
            }
        }
        if (this.f26862g) {
            ArrayList<RestaurantsSearchWrapperClass> buildResultsWrapperClasses = buildResultsWrapperClasses((ArrayList<RestaurantSearchResponse>) null, (ArrayList<RestaurantSearchResponse>) null, (ArrayList<RestaurantSearchResponse>) null, arrayList7, arrayList8, arrayList9, false);
            if (buildResultsWrapperClasses == null || buildResultsWrapperClasses.size() <= 0) {
                this.mView.hideDishesSuggestionSearch();
                return;
            }
            ArrayList arrayList10 = new ArrayList();
            if (buildResultsWrapperClasses.size() > 5) {
                for (int i13 = 0; i13 < 5; i13++) {
                    arrayList10.add(buildResultsWrapperClasses.get(i13));
                }
                this.mView.showDishesSuggestionsSearch(arrayList10, str2, true);
                return;
            }
            this.mView.showDishesSuggestionsSearch(buildResultsWrapperClasses, str2, false);
            return;
        }
        Handler handler = this.mInstantSearchHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (this.f26859d.size() > 0 || this.f26860e.size() > 0) {
            this.mView.showList(buildResultsWrapperClasses(arrayList4, arrayList5, arrayList6, arrayList7, arrayList8, arrayList9, true), str2);
            this.mView.initTabLayout();
            if (this.f26859d.size() > 0) {
                this.mView.addRestaurantTab();
            }
            if (this.f26860e.size() > 0) {
                this.mView.addDishTab();
                if (z11) {
                    this.mView.selectDishTab();
                }
            }
            this.mView.hideLoading();
            this.mView.hideNoResult();
            this.mView.hideRecentSearch();
            this.mView.hideTrending();
            this.mView.hideInstanceSearch();
            this.mView.hideSuggestionSearch();
            return;
        }
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.showNoResult();
        this.mView.hideRecentSearch();
        this.mView.hideTrending();
        this.mView.hideInstanceSearch();
        this.mView.hideSuggestionSearch();
    }

    public void saveSearchTerm(String str) {
        ArrayList<String> recentSearchKeyTerms = this.f26857b.getRecentSearchKeyTerms();
        if (recentSearchKeyTerms == null) {
            recentSearchKeyTerms = new ArrayList<>();
        }
        for (int i11 = 0; i11 < recentSearchKeyTerms.size(); i11++) {
            if (recentSearchKeyTerms.get(i11).equalsIgnoreCase(str)) {
                recentSearchKeyTerms.remove(i11);
            }
        }
        recentSearchKeyTerms.add(0, str);
        if (recentSearchKeyTerms.size() > 5) {
            recentSearchKeyTerms.remove(recentSearchKeyTerms.size() - 1);
        }
        this.f26857b.saveRecentSearchKeyTerms(recentSearchKeyTerms);
    }

    public void searchBySearchTerm(String str, String str2, boolean z11) {
        this.mView.hideNoResult();
        this.mView.hideList();
        this.mView.hideRecentSearch();
        this.mView.hideTrending();
        this.mView.showLoading();
        this.mView.hideSuggestionSearch();
        this.mView.hideInstanceSearch();
        this.f26862g = false;
        Handler handler = this.mInstantSearchHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList<Restaurant> arrayList = this.mRestaurants;
        if (arrayList != null) {
            Iterator<Restaurant> it = arrayList.iterator();
            while (it.hasNext()) {
                Restaurant next = it.next();
                if (sb2.length() == 0) {
                    sb2.append(next.getBranchId());
                } else {
                    sb2.append(",");
                    sb2.append(next.getBranchId());
                }
            }
            IRestaurantsSearchInteractor iRestaurantsSearchInteractor = this.mInteractor;
            if (iRestaurantsSearchInteractor != null) {
                iRestaurantsSearchInteractor.searchForRestaurants(sb2.toString(), str, str2, z11);
                return;
            }
            return;
        }
        this.mView.hideList();
        this.mView.hideLoading();
        this.mView.hideRecentSearch();
        this.mView.hideTrending();
        this.mView.hideInstanceSearch();
        this.mView.showNoResult();
    }

    public void setBranchIdForSelectedRestaurant(int i11) {
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        restaurant.branchId = i11;
        setSelectedRestaurant(restaurant);
    }

    public void setFrom(FromScreen fromScreen) {
        this.f26858c = fromScreen;
        setRestaurants();
    }

    public void setSelectedRestaurant(Restaurant restaurant) {
        this.f26856a = restaurant;
        int i11 = restaurant.statusType;
        if (i11 == 0 || i11 == 5) {
            userContinuing();
        } else if (i11 == 1) {
            this.mView.showAlert(800, restaurant.getName(), restaurant.isTalabatGo);
        } else {
            this.mView.showAlert(801, restaurant.getName(), restaurant.isTalabatGo);
        }
    }

    public void userContinuing() {
        Cart instance = Cart.getInstance();
        GlobalDataModel.SELECTED.updateRestaurant(this.f26856a);
        if (instance.getRestaurant() != null) {
            Restaurant restaurant = this.f26856a;
            if (!(restaurant == null || restaurant.f13872id == instance.getRestaurant().f13872id)) {
                GlobalDataModel.BIN.handled = false;
            }
        } else {
            GlobalDataModel.BIN.handled = false;
        }
        this.mView.startLoadingPopup();
        Restaurant restaurant2 = this.f26856a;
        if (restaurant2 == null || restaurant2.shopType != 1) {
            this.mMenuApiInteractor.getRestaurantMenu(this, restaurant2);
            return;
        }
        GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
        this.mMenuApiInteractor.getGroceryMenu(this, this.f26856a);
    }
}
