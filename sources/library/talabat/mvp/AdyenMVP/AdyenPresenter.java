package library.talabat.mvp.AdyenMVP;

import JsonModels.MenuItemsResponseModel;
import JsonModels.PlaceOrderRequestModel;
import JsonModels.Request.AdyenRequestModels.AdyenPurchaseRequest;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Response.AdyenResponse.AdyenPurchaseResponse;
import JsonModels.Response.BIN.BinResponse;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.helpers.GlobalDataModel;
import datamodels.InvalidItem;
import datamodels.OrderDetails;
import datamodels.Restaurant;
import library.talabat.mvp.checkout.checkoutrefactor.PayProxyManagerPresenter;
import library.talabat.mvp.placeorder.PlaceOrderInteractor;
import library.talabat.mvp.placeorder.PlaceOrderPresenter;
import library.talabat.mvp.placeorder.PlaceOrderView;
import org.json.JSONException;

public class AdyenPresenter implements IAdyenPresenter, AdyenListener {

    /* renamed from: a  reason: collision with root package name */
    public PlaceOrderPresenter f26545a;
    private AdyenView adyenView;
    private BinResponse binResponse;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private IAdyenInteractor iAdyenInteractor;
    private InvalidItem[] invalidItems;
    private boolean isPostDatedOrder = false;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    private PlaceOrderView placeOrderView;

    public AdyenPresenter(AppVersionProvider appVersionProvider, ConfigurationLocalRepository configurationLocalRepository2, DiscoveryConfigurationRepository discoveryConfigurationRepository, LocationConfigurationRepository locationConfigurationRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, AdyenView adyenView2, PlaceOrderView placeOrderView2) {
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.placeOrderView = placeOrderView2;
        this.adyenView = adyenView2;
        this.iAdyenInteractor = new AdyenInteractor(this, appVersionProvider);
        PayProxyManagerPresenter payProxyManagerPresenter = new PayProxyManagerPresenter();
        PlaceOrderPresenter placeOrderPresenter = new PlaceOrderPresenter(placeOrderView2, new PlaceOrderInteractor(appVersionProvider, configurationLocalRepository2, discoveryConfigurationRepository, locationConfigurationRepository2, paymentConfigurationRepository2), payProxyManagerPresenter, (ISubscriptionsTracker) null, configurationLocalRepository2, locationConfigurationRepository2);
        this.f26545a = placeOrderPresenter;
        payProxyManagerPresenter.setListener(placeOrderPresenter);
    }

    private void callMenuApi() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        if (restaurant == null) {
            return;
        }
        if (restaurant.shopType == 1) {
            GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
            this.iAdyenInteractor.getGroceryMenu(restaurant);
            return;
        }
        MenuResponseMapper.INSTANCE.clear();
        this.iAdyenInteractor.getRestaurantInfoOnly(restaurant);
        this.iAdyenInteractor.getRestaurantMenuOnly(restaurant);
    }

    public void applyAvailableBinResponse() {
        BinResponse binResponse2 = this.binResponse;
        if (binResponse2 != null) {
            onBinVoucherAvailable(binResponse2);
        }
    }

    public void checkForBinVoucher(BinRequest binRequest) {
        this.iAdyenInteractor.checkForBinVoucher(binRequest);
    }

    public void enableButtonOnError() {
        this.adyenView.enablePayButton();
        this.adyenView.stopProgressBar();
    }

    public BinResponse getBinResponse() {
        return this.binResponse;
    }

    public void onAdyenFailed(String str) {
        this.adyenView.onAdyenFailed(str);
    }

    public void onBinVoucherAvailable(BinResponse binResponse2) {
        this.binResponse = binResponse2;
        this.adyenView.onBinVoucherAvailable(binResponse2);
    }

    public void onDataError() {
    }

    public void onDestroy() {
        this.adyenView = null;
        this.placeOrderView = null;
        if (this.iAdyenInteractor != null) {
            this.iAdyenInteractor = null;
        }
    }

    public void onEmptyMenuReceived(String str) {
        this.adyenView.stopLodingPopup();
        this.adyenView.onEmptyMenuReceived(str);
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Restaurant restaurant;
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && (restaurant = menuItemsResponseModel.restaurant) != null && instance.getRestaurant().f13873name.equals(restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.adyenView.onRedirectToCartPage();
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.adyenView.onRedirectToCartPage();
    }

    public void onMinimumOrderConditionFailed(String str, String str2) {
        this.adyenView.onMinimumOrderConditionForBINFailed(str, str2);
    }

    public void onNetworkError() {
    }

    public void onNullResponseReceived() {
        this.adyenView.onNullResponseReceived();
    }

    public void onOrderDetailsRecieved(OrderDetails orderDetails) {
        this.adyenView.onOrderDetailsRecieved(orderDetails);
    }

    public void onRedirectToPaymentWebViewWithAdyen(AdyenPurchaseResponse adyenPurchaseResponse) {
        this.adyenView.onRedirectToPaymentWebViewWithAdyen(adyenPurchaseResponse);
    }

    public void onRequestError() {
        AdyenView adyenView2 = this.adyenView;
        if (adyenView2 != null) {
            adyenView2.onRequestError();
        }
    }

    public void onRestaurantListLoaded() {
        this.adyenView.onRedirectToRestaurantList();
    }

    public void onServerError() {
        AdyenView adyenView2 = this.adyenView;
        if (adyenView2 != null) {
            adyenView2.onServerError();
        }
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onSuccessfulAdyen() {
        this.adyenView.onSuccessfulAdyen();
    }

    public void placeOrder(PlaceOrderRequestModel placeOrderRequestModel) {
        try {
            PlaceOrderPresenter placeOrderPresenter = this.f26545a;
            placeOrderPresenter.selectedPayementMethod = 2;
            placeOrderPresenter.placeOrder(placeOrderRequestModel);
        } catch (JSONException unused) {
        }
    }

    public void proceedPayment(AdyenPurchaseRequest adyenPurchaseRequest) {
        this.iAdyenInteractor.proceedPayment(adyenPurchaseRequest);
    }

    public void removeInvalidCoupon(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeInvalidSelectedCoupon(!this.isPostDatedOrder);
        if (this.isPostDatedOrder) {
            GlobalDataModel.PLACEORDER.foundInvalidCoupon = true;
            this.adyenView.onInvalidConditionHandled();
            return;
        }
        this.adyenView.onRedirectToCartPage();
    }

    public void removeInvalidItems(boolean z11, InvalidItem[] invalidItemArr) {
        this.isPostDatedOrder = z11;
        this.invalidItems = invalidItemArr;
        Cart.getInstance().removeInvalidItems(this.invalidItems);
        Cart.getInstance().recalcualteTotal();
        callMenuApi();
    }

    public void removeInvalidPromotion(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeInvalidSelectedPromotion(!this.isPostDatedOrder);
        if (this.isPostDatedOrder) {
            GlobalDataModel.PLACEORDER.foundInvalidPromotion = true;
            this.adyenView.onInvalidConditionHandled();
            return;
        }
        this.adyenView.onRedirectToCartPage();
    }

    public void removeInvalidVoucher(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeVoucherIfApplied();
        GlobalDataModel.PLACEORDER.foundInvalidVoucher = true;
        Cart.getInstance().recalcualteTotal();
        this.adyenView.onInvalidConditionHandled();
    }

    public void setUpViews() {
        this.adyenView.fillViews();
    }

    public void showOrderDetails(String str) {
        this.iAdyenInteractor.getOrderDetails(str);
    }

    public void tryMoreRestaurantsClicked() {
        if (GlobalDataModel.restaurants == null) {
            this.iAdyenInteractor.getRestaurants(Cart.getInstance().getCartAreaId(), Cart.getInstance().getCartCityId(), 0);
        } else {
            this.adyenView.onRedirectToRestaurantList();
        }
    }
}
