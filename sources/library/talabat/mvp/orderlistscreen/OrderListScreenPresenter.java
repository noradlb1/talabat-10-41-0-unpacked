package library.talabat.mvp.orderlistscreen;

import JsonModels.OrderListPagingResponse;
import JsonModels.ReorderResponse;
import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.OrderListPagingRM;
import androidx.annotation.NonNull;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.McdMapTempAddress;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.domain.address.Address;
import com.talabat.helpers.DateUtils;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CartMenuItem;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.OrderInfoPaging;
import datamodels.ReorderItem;
import datamodels.ReorderItemChoice;
import datamodels.ReorderItemMissingModel;
import datamodels.ReorderItemStatus;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;

public class OrderListScreenPresenter implements IOrderListScreenPresenter, OrderListScreenListener {
    static final String EXPERIMENT_CONTROL = "Control";
    static final String EXPERIMENT_VARIATION_1 = "Variation1";
    private static final int INITIAL_PAGE_NUMBER = 1;
    private static final String NO_ITEM_REORDER_SCENARIO_NO_RESTAURANT = "No items bottomsheet: In orderlistScreenPresenter, shop not available";
    private static final String REORDER_NOTIFICATION_API_ERROR = "Reorder Notification: In orderlistScreenPresenter, isReOrderModified is false, but reason list is available";
    private DateUtils dateUtils;
    private IOrderListScreenInteractor interactor;
    private long lastFetchTime = 0;
    @Nullable
    public Function2<? super String, ? super String, Unit> onGroceryReorderInfoReceived = null;
    private String orderId;
    private OrderListScreenView orderListScreenView;
    private boolean reOrderGrlEnabled;
    private String reOrderResName;
    private ReorderItem[] reoderitems;
    private int reorderRestaurantId = -1;
    private Restaurant selectedRestaurant;
    private final ITalabatExperiment talabatExperiment;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public OrderListScreenPresenter(AppVersionProvider appVersionProvider, OrderListScreenView orderListScreenView2, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment) {
        this.orderListScreenView = orderListScreenView2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.talabatExperiment = iTalabatExperiment;
        this.interactor = new OrderListScreenInteractor(appVersionProvider, this);
        this.dateUtils = new DateUtils();
    }

    private void fetchOrderListIfTimeElapsedSinceLastFetchGreaterThanFifteenSeconds() {
        if (timeElapsedSinceLastFetchTimeGreaterThanFifteenSeconds()) {
            fetchOrdersList();
        } else {
            LogManager.debug("Not calling api again as orders list was fetched less than 15 seconds.");
        }
    }

    private String getChoicesString(ArrayList<ReorderItemChoice> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ReorderItemChoice> it = arrayList.iterator();
        while (it.hasNext()) {
            ReorderItemChoice next = it.next();
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(next.itemName);
        }
        return sb2.toString();
    }

    private void handleReorderResponse(Cart cart, ReorderResponse reorderResponse, Restaurant restaurant) {
        if (cart.hasItems()) {
            this.orderListScreenView.showCartClearAlert();
            return;
        }
        cart.setRestaurant(restaurant, this.orderListScreenView.getContext());
        List<ReorderItemStatus> list = reorderResponse.itemStatus;
        if (list != null && !list.isEmpty() && this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_REORDER_NOTIFICATION, false)) {
            if (!reorderResponse.isReOrderModified) {
                ObservabilityManager.trackUnExpectedScenario(REORDER_NOTIFICATION_API_ERROR, new HashMap());
            }
            cart.setReorderItemMissingModel(new ReorderItemMissingModel(reorderResponse.isReOrderModified, reorderResponse.itemStatus));
        }
        loadCart(cart, reorderResponse.items);
        if (reorderResponse.hasCartId()) {
            this.orderListScreenView.onReorderCartReceivedNavigateToFlutterCartScreen(this.selectedRestaurant, reorderResponse.cartId);
        } else {
            this.orderListScreenView.onReorderCartReceived(this.selectedRestaurant);
        }
    }

    private void informMapDecisionMakerHandler(int i11) {
        Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            if (selectedCustomerAddress == null) {
                this.orderListScreenView.showMap(i11, this.reOrderResName);
            } else if (TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                this.orderListScreenView.showMap(i11, this.reOrderResName);
            } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.getGrlId())) {
                InforMapRequest inforMapRequest = new InforMapRequest(selectedCustomerAddress.grl, GlobalDataModel.SelectedAreaId, true);
                inforMapRequest.setRestaurantId(this.reorderRestaurantId);
                this.interactor.getBranchIdForReorderCart(inforMapRequest);
            } else {
                this.orderListScreenView.showMap(i11, this.reOrderResName);
            }
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            if (selectedCustomerAddress == null) {
                this.orderListScreenView.showGoogleMapMcd(i11, this.reOrderResName, this.reorderRestaurantId, (Address) null);
            } else if (TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                this.orderListScreenView.showGoogleMapMcd(i11, this.reOrderResName, this.reorderRestaurantId, selectedCustomerAddress);
            } else if (!TalabatUtils.isNullOrEmpty(selectedCustomerAddress.block)) {
                this.orderListScreenView.getBranchIdForReOrderCart(this.reorderRestaurantId, i11, selectedCustomerAddress);
            } else {
                this.orderListScreenView.showGoogleMapMcd(i11, this.reOrderResName, this.reorderRestaurantId, selectedCustomerAddress);
            }
        } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
        } else {
            if (selectedCustomerAddress == null) {
                this.orderListScreenView.showGoogleMapMcd(i11, this.reOrderResName, this.reorderRestaurantId, (Address) null);
            } else if (TalabatUtils.isNullOrEmpty(selectedCustomerAddress.f58343id)) {
                this.orderListScreenView.showGoogleMapMcd(i11, this.reOrderResName, this.reorderRestaurantId, selectedCustomerAddress);
            } else if (!TalabatUtils.isNullOrEmptyLatLng(selectedCustomerAddress.latitude, selectedCustomerAddress.longitude)) {
                this.orderListScreenView.getBranchIdForReOrderCart(this.reorderRestaurantId, i11, selectedCustomerAddress);
            } else {
                this.orderListScreenView.showGoogleMapMcd(i11, this.reOrderResName, this.reorderRestaurantId, selectedCustomerAddress);
            }
        }
    }

    private boolean isNeedLoadDeliverableAddress() {
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            if (!instance.isLoggedIn() || !instance.hasAddresses()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isUserLoggedIn() {
        return Customer.getInstance().isLoggedIn();
    }

    private void loadCart(Cart cart, ReorderItem[] reorderItemArr) {
        String str;
        for (ReorderItem reorderItem : reorderItemArr) {
            CartMenuItem createWith = CartMenuItem.createWith(reorderItem);
            cart.addItem(createWith, this.orderListScreenView.getContext());
            ArrayList<ReorderItemChoice> arrayList = reorderItem.lstItemsChoice;
            if (arrayList != null) {
                arrayList.size();
            }
            ArrayList<ReorderItemChoice> arrayList2 = reorderItem.lstItemsChoice;
            if (arrayList2 != null) {
                str = getChoicesString(arrayList2);
            } else {
                str = "";
            }
            AppTracker.onItemAddedToCart(this.orderListScreenView.getContext(), Cart.getInstance().getRestaurant(), createWith, AppTracker.getRestaurantId(this.selectedRestaurant), AppTracker.getRestaurantName(this.selectedRestaurant), ScreenNames.SCREEN_TYPE_REORDER, str, 0, 0, ScreenNames.getScreenType(this.orderListScreenView.getScreenName()), this.orderListScreenView.getScreenName());
        }
    }

    private Long timeElapsedSinceLastFetchTime() {
        return Long.valueOf(this.dateUtils.currentTimeInMillis() - this.lastFetchTime);
    }

    private boolean timeElapsedSinceLastFetchTimeGreaterThanFifteenSeconds() {
        return timeElapsedSinceLastFetchTime().longValue() > TimeUnit.MILLISECONDS.convert(15, TimeUnit.SECONDS);
    }

    private void updateLastFetchTime() {
        this.lastFetchTime = this.dateUtils.currentTimeInMillis();
    }

    public void fetchGroceryReorderSwimlaneInfo(boolean z11, int i11, @NonNull Function2<? super String, ? super String, Unit> function2) {
        this.onGroceryReorderInfoReceived = function2;
        this.interactor.getGroceryBuyAgainSwimlaneInfo(z11, i11);
    }

    public void fetchOrdersList(int i11) {
        if (timeElapsedSinceLastFetchTimeGreaterThanFifteenSeconds()) {
            this.interactor.getOrderList(i11);
        } else {
            LogManager.debug("Not calling api again as orders list was fetched less than 15 seconds.");
        }
    }

    public void getMcdBranchIdFromBlock(McdBranchRequest mcdBranchRequest) {
        this.interactor.getBranchIdGrl(mcdBranchRequest);
    }

    public void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse) {
        this.interactor.getGrlReorderCart(this.orderId, GlobalDataModel.SelectedAreaId, inforMapAddressResponse.talabatResBranchId);
    }

    public void grlBranchIdfailed() {
    }

    public boolean isGroceryOrder(OrderInfoPaging orderInfoPaging) {
        return orderInfoPaging.isDarkStore || orderInfoPaging.isMigrated;
    }

    public boolean isReOderMapFirstEnabled(boolean z11) {
        return !z11;
    }

    public void loadReOrderCartFromMap(int i11, String str) {
        this.orderListScreenView.startLodingPopup();
        this.interactor.getReorderCart(str, i11);
    }

    public void loadReorderCartWithGrl(int i11, int i12) {
        this.interactor.getGrlReorderCart(this.orderId, i11, i12);
    }

    public void mcdBhBranchFailed() {
        this.orderListScreenView.mcdServerError();
    }

    public void mcdBranchReceived(int i11, McdStoresResponse mcdStoresResponse) {
        if (mcdStoresResponse == null) {
            return;
        }
        if (mcdStoresResponse.result.statusCode == 0) {
            if (mcdStoresResponse.address != null) {
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempBlockAddress(mcdStoresResponse.address);
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    McdMapTempAddress.getInstance().setSelectedTempLatLangAddress(mcdStoresResponse.address);
                }
            }
            this.interactor.getGrlReorderCart(this.orderId, mcdStoresResponse.address.areaId, mcdStoresResponse.tlbBranchId);
            return;
        }
        OrderListScreenView orderListScreenView2 = this.orderListScreenView;
        Address address = mcdStoresResponse.address;
        orderListScreenView2.showGoogleMapMcd(address.areaId, this.reOrderResName, this.reorderRestaurantId, address);
    }

    public void noOrdersFound() {
        this.orderListScreenView.noOrdersFound();
    }

    public void onAttach() {
        if (isUserLoggedIn()) {
            fetchOrderListIfTimeElapsedSinceLastFetchGreaterThanFifteenSeconds();
        } else {
            this.orderListScreenView.showLoggedOutUserView();
        }
    }

    public void onDataError() {
        this.orderListScreenView.onDataError();
    }

    public void onDestroy() {
        this.orderListScreenView = null;
        IOrderListScreenInteractor iOrderListScreenInteractor = this.interactor;
        if (iOrderListScreenInteractor != null) {
            iOrderListScreenInteractor.unregister();
        }
        this.interactor = null;
    }

    public void onGroceryOrderAgainInfoReceived(String str, String str2, String str3) {
        Function2<? super String, ? super String, Unit> function2 = this.onGroceryReorderInfoReceived;
        if (function2 != null) {
            function2.invoke(str2, str3);
            this.onGroceryReorderInfoReceived = null;
        }
    }

    public void onNetworkError() {
        this.orderListScreenView.onNetworkError();
    }

    public void onOrderDetailsRecieved(OrderDetails orderDetails) {
        this.orderListScreenView.onOrderDetailsReceived(orderDetails);
    }

    public void onOrdersListRecieved(OrderListPagingRM orderListPagingRM) {
        updateLastFetchTime();
        OrderListScreenView orderListScreenView2 = this.orderListScreenView;
        OrderListPagingResponse orderListPagingResponse = orderListPagingRM.result;
        orderListScreenView2.onOrderListLoaded(orderListPagingResponse.orders, orderListPagingResponse.totalPages, orderListPagingResponse.totalRecords, orderListPagingRM.timestamp);
    }

    public void onReorderAreasRecieved(DeliveryArea[] deliveryAreaArr) {
        this.orderListScreenView.stopLodingPopup();
        this.orderListScreenView.onRedirectToAreaSelection(deliveryAreaArr);
    }

    public void onReorderItemRecieved(ReorderResponse reorderResponse) {
        GlobalDataModel.PARALLELBIN.reset();
        if (reorderResponse.hasShop() && reorderResponse.hasItems()) {
            this.selectedRestaurant = reorderResponse.restaurant;
            this.reoderitems = reorderResponse.items;
            handleReorderResponse(Cart.getInstance(), reorderResponse, this.selectedRestaurant);
        } else if (!reorderResponse.hasShop() || reorderResponse.hasItems()) {
            ObservabilityManager.trackUnExpectedScenario(NO_ITEM_REORDER_SCENARIO_NO_RESTAURANT, new HashMap());
            this.orderListScreenView.showCartLoadingError(reorderResponse.err, false, (Restaurant) null);
        } else {
            this.orderListScreenView.showCartLoadingError(reorderResponse.err, this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_NO_ITEMS_BOTTOMSHEET, false), reorderResponse.restaurant);
        }
    }

    public void onResBasedDeliverAddressLoaded(Address[] addressArr) {
        Address[] addressArr2 = addressArr;
        if (addressArr2 == null) {
            this.orderListScreenView.redirectToHomeMapScreenFromReorder(true, "", true, this.orderId, this.reorderRestaurantId, this.reOrderResName);
        } else if (addressArr2.length > 0) {
            this.orderListScreenView.redirectToChooseSavedAddressScreenFromReorder(Customer.getInstance().getSelectedCustomerAddress(), this.orderId, this.reorderRestaurantId, this.reOrderResName);
        } else {
            this.orderListScreenView.redirectToHomeMapScreenFromReorder(true, "", true, this.orderId, this.reorderRestaurantId, this.reOrderResName);
        }
    }

    public void onResCompleted() {
        this.orderListScreenView.stopLodingPopup();
    }

    public void onResponseError() {
        this.orderListScreenView.stopLodingPopup();
    }

    public void onServerError(VolleyError volleyError) {
        this.orderListScreenView.onServerError(volleyError);
    }

    public void proceedReorderClearingCart() {
        Cart instance = Cart.getInstance();
        instance.clearCart(this.orderListScreenView.getContext());
        instance.setRestaurant(this.selectedRestaurant, this.orderListScreenView.getContext());
        loadCart(instance, this.reoderitems);
        this.orderListScreenView.onReorderCartReceived(this.selectedRestaurant);
    }

    public void reorder(int i11, String str, boolean z11, String str2, int i12) {
        this.orderId = str;
        this.reorderRestaurantId = i11;
        this.reOrderGrlEnabled = z11;
        this.reOrderResName = str2;
        if (!isReOderMapFirstEnabled(z11)) {
            this.interactor.getReorderAreas(str);
        } else if (isNeedLoadDeliverableAddress()) {
            this.orderListScreenView.startLodingPopup();
            this.interactor.getAddressBasedDeliveryArea(new DeliverAddressRequest(i11, GlobalDataModel.SelectedCountryId, 0.0d, 0.0d, 0));
        } else {
            this.orderListScreenView.redirectToHomeMapScreenFromReorder(true, "", true, str, this.reorderRestaurantId, this.reOrderResName);
        }
    }

    public void reorderAreaSelected(int i11) {
        boolean z11 = false;
        if ((TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) && this.reOrderGrlEnabled && i11 > 0) {
            DeliveryArea[] deliveryAreaArr = GlobalDataModel.restaurantDeliveryAreas;
            int length = deliveryAreaArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                DeliveryArea deliveryArea = deliveryAreaArr[i12];
                if (deliveryArea.f13835id == i11) {
                    z11 = deliveryArea.isGlrEnabled;
                    break;
                }
                i12++;
            }
        }
        if ((TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) && z11 && this.reOrderGrlEnabled) {
            informMapDecisionMakerHandler(i11);
        } else {
            this.interactor.getReorderCart(this.orderId, i11);
        }
    }

    public void reorderGrocery(@NonNull String str, boolean z11) {
    }

    public boolean shouldEnableGroceryReorder() {
        return this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_ENABLE_REORDER_DARKSTORES, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1");
    }

    public void showOrderDetails(String str) {
        this.interactor.getOrderDetails(str);
    }

    private void fetchOrdersList() {
        this.orderListScreenView.hideLoggedOutUserView();
        this.orderListScreenView.showLoading();
        fetchOrdersList(1);
    }

    public OrderListScreenPresenter(OrderListScreenView orderListScreenView2, IOrderListScreenInteractor iOrderListScreenInteractor, DateUtils dateUtils2, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment) {
        this.orderListScreenView = orderListScreenView2;
        this.interactor = iOrderListScreenInteractor;
        this.dateUtils = dateUtils2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.talabatExperiment = iTalabatExperiment;
    }
}
