package library.talabat.mvp.checkout;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.BIN.BinTokenResponse;
import JsonModels.Response.Cashback.CashbackRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.VisaCheckoutResponse.DecryptionResponse;
import JsonModels.Response.VisaCheckoutResponse.PurchaseResponse;
import android.content.Context;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.domain.address.Address;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.helpers.Talabat;
import datamodels.OrderDetails;
import java.util.ArrayList;
import java.util.List;

public interface CheckoutView extends Talabat {

    public interface PLACEORDERERRORCODES {
        public static final int COUPONNOTAVAILABLE = 60;
        public static final int DOESNTALLOWMIX = 63;
        public static final int GEM_EXPIRED = 707;
        public static final int INVALID_GEM_DISCOUNT = 801;
        public static final int ITEMNOTAVAILECODE1 = 1;
        public static final int ITEMNOTAVAILECODE2 = 2;
        public static final int ITEMNOTAVAILECODE3 = 3;
        public static final int PROMOTIONNOTAVAILABLE = 61;
        public static final int VOCHERNOTAVAILABLE = 62;
        public static final int VOUCHERNOTAVAILABLEFORCASH = 64;
    }

    void applyBinVoucherViews(float f11, String str, float f12);

    void doNotExpectBin();

    void enableTalabatCreditCashbackView();

    void fetchCurrentLocation();

    Context getContext();

    void getCvvForSavedCard(boolean z11);

    boolean getDarkStoreStatus();

    String getDeliveryTime();

    String getFirstName();

    String getLastName();

    String getNormalVoucherText();

    String getSelectedCardName();

    void hideBinAvailableNotification();

    void hideLoader();

    void hideRiderTipCharges();

    void hideRiderTipView();

    void hideShowCurreAwareness();

    void hideTProSubscriptionBanner(Boolean bool);

    void hideTalabatCreditView();

    void initRiderTipView();

    boolean isBinDiscountApplied();

    boolean isContactlessEnabled();

    void makePaymentForPlaceOrder();

    void onBinNotAvailable(String str);

    void onBinTokenRecieved(BinTokenResponse[] binTokenResponseArr);

    void onBinVoucherAvailable(BinResponse binResponse);

    void onCallCheckoutDotCom(String str, boolean z11, PlaceOrderRequestModel placeOrderRequestModel, boolean z12, boolean z13, String str2);

    void onCashbackResponseError();

    void onCashbackResponseReceived(CashbackRM cashbackRM);

    void onCheckoutDotComRecurringFailed(String str);

    void onDataDecrypted(DecryptionResponse decryptionResponse);

    void onDataDecryptionFailed(String str);

    void onDeliveryTimesLoaded(ArrayList<String> arrayList);

    void onDeliveryTimesNotavailable();

    void onEmptyMenuReceived(String str);

    void onLocationChanged();

    void onLoyaltyVoucherInfoReceived(LoyaltyVoucherRM loyaltyVoucherRM);

    void onMinimumOrderConditionForBINFailed(String str);

    void onNullResponseReceived();

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onOrderSucess(PlaceOrderResponse placeOrderResponse);

    void onParallelBinAvailable(boolean z11);

    void onPaymentMethodSelected(int i11);

    void onPlaceOrderLocalValidataionPassed();

    void onPostDatedSelectionChanged(boolean z11);

    void onRedirectToAddressList();

    void onRedirectToCartPage();

    void onRedirectToEditAddress(Address address);

    void onRedirectToPaymentErrorForVisa(String str);

    void onRedirectToRestaurantList();

    void onRequestError();

    void onServerError();

    void onSuccessfulRecurringCheckoutDotCom();

    void onUpdateBNPLCartBinVoucher();

    void onValidationError(int i11, int i12, boolean z11);

    void populateUserSelctedCreditCardView(boolean z11, TokenisationCreditCard tokenisationCreditCard);

    void redirectToPaymentWebViewForVisaCheckout(PurchaseResponse purchaseResponse);

    void removeCashPayment();

    void setAddressView(Address address);

    void setAddressViewMap(Address address);

    void setAltTextDeliveryCharges(String str);

    void setAltTextMuncipalityTax(String str);

    void setAltTextTouristTax(String str);

    void setChangeAddressBtn(boolean z11, boolean z12);

    void setDeliveryCharges(String str, String str2);

    void setDescalimer(String str);

    void setFreeDeliveryReturn(String str, TProOrderStatus tProOrderStatus);

    void setGemOfferCharge();

    void setMuncipalityTaxView(String str);

    void setPaymentView(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i11, boolean z16, boolean z17, boolean z18);

    void setPostDateOrderLayout(boolean z11);

    void setRestaurantName(String str);

    void setTotalAmount();

    void setTouristTaxView(String str);

    void setVoucherView();

    void showCashView();

    void showCurrentLocationAwareness();

    void showNonCancelableProgress();

    void showRiderTipCharges(String str);

    void showRiderTipView();

    void showSubscriptionErrorDialog();

    void showTalabatCreditView();

    void showVoucherBottomSheet();

    void stopNonCancelableLoading();

    void stopScreenTrace();

    void updateAddressMobileNumber(String str);

    void updateDeliverySlots(List<DeliverySlotContent> list);

    void updateSaveTipStatus();
}
