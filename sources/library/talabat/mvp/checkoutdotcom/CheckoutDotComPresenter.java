package library.talabat.mvp.checkoutdotcom;

import JsonModels.MenuItemsResponseModel;
import JsonModels.PlaceOrderRequestModel;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.PurchaseRequest;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.CheckoutDotComResponse.PurchaseResponse;
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
import tracking.AppTracker;

public class CheckoutDotComPresenter implements ICheckoutDotComPresenter, CheckoutDotComListener {

    /* renamed from: a  reason: collision with root package name */
    public PlaceOrderPresenter f26699a;
    private BinResponse binResponse;
    private CheckoutDotComView checkoutDotComView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private ICheckoutDotComInteractor iCheckoutDotComInteractor;
    private InvalidItem[] invalidItems;
    private boolean isPostDatedOrder = false;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private final PaymentConfigurationRepository paymentConfigurationRepository;

    public CheckoutDotComPresenter(AppVersionProvider appVersionProvider, ConfigurationLocalRepository configurationLocalRepository2, DiscoveryConfigurationRepository discoveryConfigurationRepository, LocationConfigurationRepository locationConfigurationRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, CheckoutDotComView checkoutDotComView2, PlaceOrderView placeOrderView) {
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.checkoutDotComView = checkoutDotComView2;
        this.iCheckoutDotComInteractor = new CheckoutDotComInteractor(appVersionProvider, paymentConfigurationRepository2, this);
        PayProxyManagerPresenter payProxyManagerPresenter = new PayProxyManagerPresenter();
        PlaceOrderPresenter placeOrderPresenter = new PlaceOrderPresenter(placeOrderView, new PlaceOrderInteractor(appVersionProvider, configurationLocalRepository2, discoveryConfigurationRepository, locationConfigurationRepository2, paymentConfigurationRepository2), payProxyManagerPresenter, (ISubscriptionsTracker) null, configurationLocalRepository2, locationConfigurationRepository2);
        this.f26699a = placeOrderPresenter;
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
            this.iCheckoutDotComInteractor.getGroceryMenu(restaurant);
            return;
        }
        MenuResponseMapper.INSTANCE.clear();
        this.iCheckoutDotComInteractor.getRestaurantInfoOnly(restaurant);
        this.iCheckoutDotComInteractor.getRestaurantMenuOnly(restaurant);
    }

    public void applyAvailableBinResponse() {
        BinResponse binResponse2 = this.binResponse;
        if (binResponse2 != null) {
            onBinVoucherAvailable(binResponse2);
        }
    }

    public void checkForBinVoucher(BinRequest binRequest) {
        this.iCheckoutDotComInteractor.checkForBinVoucher(binRequest);
    }

    public void enableButtonOnError() {
        this.checkoutDotComView.enablePayButton();
    }

    public BinResponse getBinResponse() {
        return this.binResponse;
    }

    public void onBinVoucherAvailable(BinResponse binResponse2) {
        this.binResponse = binResponse2;
        this.checkoutDotComView.onBinVoucherAvailable(binResponse2);
    }

    public void onCheckoutDotComFailed(String str) {
        this.checkoutDotComView.onCheckoutDotComFailed(str);
    }

    public void onDataError() {
    }

    public void onDestroy() {
        this.checkoutDotComView = null;
        if (this.iCheckoutDotComInteractor != null) {
            this.iCheckoutDotComInteractor = null;
        }
    }

    public void onEmptyMenuReceived(String str) {
        this.checkoutDotComView.stopLodingPopup();
        this.checkoutDotComView.onEmptyMenuReceived(str);
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && restaurant != null && instance.getRestaurant().f13873name.equals(restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.checkoutDotComView.onRedirectToCartPage();
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.checkoutDotComView.onRedirectToCartPage();
    }

    public void onMinimumOrderConditionFailed(String str, String str2) {
        this.checkoutDotComView.onMinimumOrderConditionForBINFailed(str, str2);
    }

    public void onNetworkError() {
    }

    public void onNullResponseReceived() {
        this.checkoutDotComView.onNullResponseReceived();
    }

    public void onOrderDetailsRecieved(OrderDetails orderDetails) {
        this.checkoutDotComView.onOrderDetailsRecieved(orderDetails);
    }

    public void onRedirectToPaymentWebViewWithCheckoutDotCom(PurchaseResponse purchaseResponse) {
        this.checkoutDotComView.onRedirectToPaymentWebViewWithCheckoutDotCom(purchaseResponse);
    }

    public void onRestaurantListLoaded() {
        this.checkoutDotComView.onRedirectToRestaurantList();
    }

    public void onServerError() {
        this.checkoutDotComView.onServerError();
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onSuccessfulCheckoutDotCom() {
        this.checkoutDotComView.onSuccessfulCheckoutDotCom();
    }

    public void placeOrder(PlaceOrderRequestModel placeOrderRequestModel) {
        try {
            this.f26699a.selectedPayementMethod = 2;
            if (this.checkoutDotComView.isBinApplied()) {
                AppTracker.onBinDiscountApplied(this.checkoutDotComView.getContext(), "newCard", this.checkoutDotComView.getSelectedCardName());
            } else if (Cart.getInstance().binMinimumOrderAmountForTracking > 0.0f) {
                AppTracker.onBinDiscountExcluded(this.checkoutDotComView.getContext(), Cart.getInstance().binMinimumOrderAmountForTracking);
                Cart.getInstance().binMinimumOrderAmountForTracking = 0.0f;
            }
            AppTracker.onGoGreenSelected(this.checkoutDotComView.getContext(), placeOrderRequestModel.isGoGreen);
            this.f26699a.placeOrder(placeOrderRequestModel);
        } catch (JSONException unused) {
        }
    }

    public void proceedPayment(PurchaseRequest purchaseRequest) {
        this.iCheckoutDotComInteractor.proceedPayment(purchaseRequest);
    }

    public void removeInvalidCoupon(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeInvalidSelectedCoupon(!this.isPostDatedOrder);
        if (this.isPostDatedOrder) {
            GlobalDataModel.PLACEORDER.foundInvalidCoupon = true;
            this.checkoutDotComView.onInvalidConditionHandled();
            return;
        }
        this.checkoutDotComView.onRedirectToCartPage();
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
            this.checkoutDotComView.onInvalidConditionHandled();
            return;
        }
        this.checkoutDotComView.onRedirectToCartPage();
    }

    public void removeInvalidVoucher(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeVoucherIfApplied();
        GlobalDataModel.PLACEORDER.foundInvalidVoucher = true;
        Cart.getInstance().recalcualteTotal();
        this.checkoutDotComView.onInvalidConditionHandled();
    }

    public void setUpViews() {
        this.checkoutDotComView.fillViews();
    }

    public void showOrderDetails(String str) {
        this.iCheckoutDotComInteractor.getOrderDetails(str);
    }

    public void tryMoreRestaurantsClicked() {
        if (GlobalDataModel.restaurants == null) {
            this.iCheckoutDotComInteractor.getRestaurants(Cart.getInstance().getCartAreaId(), Cart.getInstance().getCartCityId(), 0);
        } else {
            this.checkoutDotComView.onRedirectToRestaurantList();
        }
    }
}
