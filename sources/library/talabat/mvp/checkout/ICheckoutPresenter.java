package library.talabat.mvp.checkout;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import datamodels.CardInformation;
import datamodels.InvalidItem;
import datamodels.Restaurant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.IGlobalPresenter;

public interface ICheckoutPresenter extends IGlobalPresenter {
    void applyBinVoucher(BinResponse binResponse, String str, boolean z11);

    boolean calculateMOVWithTProOrder(Function1<Boolean, Unit> function1);

    void callCashBackApi(float f11);

    boolean canShowVouchers();

    void checkForBinVoucher(BinRequest binRequest);

    void continueWithAdyenPayment(RecurringPurchaseRequest recurringPurchaseRequest);

    void continueWithCheckoutPayment(RecurringPurchaseRequest recurringPurchaseRequest);

    void currentLoactionAwareness(LatLng latLng);

    void editDeliveryAddress();

    void fetchCurrentLocationAwareness();

    void fetchDarkstoreDeliverySlots();

    String getBinDiscountAmount();

    void getBinOfferDetails(String str);

    void getBinTokens();

    void getDecryptedData(String str, String str2);

    String getDefaultPaymentMethod();

    Address getDeliveryAddress();

    String getFreeDeliveryDiscountAmount();

    boolean getHideAddCardStatus();

    String getLoyaltyDiscount();

    String getLoyaltyVoucherText();

    void getParallelBinData(boolean z11);

    PlaceOrderRequestModel getPlaceOrderRequestModel();

    Float getScheduledDeliveryDiscount();

    int getSelectedPayementMethod();

    void getTProOrderStatus(Function1<? super TProOrderStatus, Unit> function1, boolean z11, boolean z12);

    String getVoucherAmount();

    void handleDeliveryFee(double d11);

    void handleServiceFee(float f11);

    void handleSmallOrderFee(float f11);

    void hideProgress();

    boolean isAnyVoucherAvailable();

    boolean isDarkstoreDeliverySlotsRequestInProgress();

    boolean isDarkstoresScheduledDeliveryEnabled();

    boolean isDarkstoresVouchersEnabled();

    boolean isDeliveryTimingApiCalled();

    boolean isDesignSystemAlert();

    boolean isDesignSystemSimpleCard();

    boolean isFlutterBNPLCheckoutEnabled();

    boolean isFreeDeliveryDiscountFull();

    boolean isFreeDeliveryTypeVoucherApplied();

    boolean isLoyaltyVoucher();

    boolean isNormalVoucher();

    boolean isPickup();

    boolean isTalabatDelVoucher();

    boolean isTalabatDeliveryVoucher();

    boolean isVoucherForOnlinePayment();

    boolean isVoucherStackingEnabled();

    boolean isZeroVoucher();

    void onDeliverySlotClicked();

    void onMobileNumberUpdate(String str);

    void onNewAddressSelected(boolean z11);

    void onOrderNowClicked();

    void onRiderTipClosed();

    void onRiderTipValueChange(Double d11);

    void onViewLoaded();

    void onVisaCheckoutDetailsReceived(String str, String str2);

    boolean onlyBinApplied();

    void payRemainingWithCreditCard();

    void paymentMethodSelected(int i11);

    void paymentSuccessfull();

    void postDateButtonClicked(boolean z11);

    void postSubscriptionPayment(CardInformation cardInformation);

    void prepareForPlacingOrder(boolean z11, boolean z12, boolean z13, String str, String str2, String str3, boolean z14);

    void recalculateAppliedVoucher();

    void recalculateAppliedVoucherIfBinApplied();

    void removeInvalidCoupon(boolean z11);

    void removeInvalidItems(InvalidItem[] invalidItemArr, boolean z11);

    void removeInvalidPromotion(boolean z11);

    void removeInvalidVoucher(boolean z11);

    void removeInvalidVouchers();

    void removeVoucher();

    void sendScheduledDeliveryClickedEvent();

    void sendScheduledDeliveryClosedEvent();

    void sendScheduledDeliveryConfirmedEvent(String str);

    void sendSubscriptionAttemptedEvent();

    void sendSubscriptionCompletedEvent();

    void sendSubscriptionFailedEvent();

    void sendSubscriptionPlanClickedEvent();

    void sendTransactionFailedEvent(String str);

    void setAdditionalPaymentMethod(int i11);

    void setAddress(Address address);

    void setCashBackAvailable(boolean z11);

    void setCvv(String str, boolean z11);

    void setDefaultPaymentMethodForGA(String str);

    void setFromVisaCheckout(boolean z11);

    void setHideAddCardStatus(boolean z11);

    void setPaymentMethod(int i11);

    void setPaymentView(Restaurant restaurant, boolean z11);

    void setPlaceOrderResponse(PlaceOrderResponse placeOrderResponse);

    void setPostDatedOrder(boolean z11);

    void setSelectedPaymentMethodForGA(int i11);

    void setTaxAndDelivery(Boolean bool);

    void setUpViews(boolean z11, boolean z12, boolean z13, boolean z14);

    boolean shouldHideOrderNowForGroceryScheduledDelivery();

    boolean shouldShowPickupConfirmationDialog(boolean z11);

    void showOrderDetails(String str);

    void showProgress();

    void tryMoreRestaurantsClicked();

    void updateBranch(int i11, double d11, double d12);

    void updateLoyaltyInfo(LoyaltyVoucherRM loyaltyVoucherRM);

    void updateMobileNumber(String str);
}
