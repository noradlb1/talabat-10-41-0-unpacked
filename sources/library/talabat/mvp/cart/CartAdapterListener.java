package library.talabat.mvp.cart;

import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import datamodels.Restaurant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public interface CartAdapterListener {
    void closeReorderStatusView();

    boolean disableGeneralRequest(Restaurant restaurant);

    String getBinDiscountAmount();

    String getCartTotalPrice();

    String getCouponDiscountAmount();

    String getDeliveryCharge();

    String getDeliveryChargeText();

    int getDeliveryChargesTextColor();

    String getFreeDeliveryDiscountAmount();

    String getFreeDeliveryReturn();

    String getGemOfferAmount();

    int getGemTextColor();

    String getLoyaltyDiscount();

    String getLoyaltyVoucherText();

    String getMinimumOrderAmount();

    String getMunicipalityTaxAmount();

    String getMunicipalityTaxLabelText();

    boolean getNoCutlerySelection();

    String getNormalVoucherText();

    String getOldDeliveryCharge();

    CharSequence getReorderStatusContent();

    String getSavedGeneralRequest();

    String getSubtotalPrice();

    String getTouristTaxAmount();

    String getTouristTaxLabelText();

    String getVoucherAmount();

    int getVoucherDiscountTextColor();

    String getZeroVoucherText();

    int getZeroVoucherTextColor();

    boolean hasMunicipalityTax();

    boolean hasTouristTax();

    boolean isCouponApplied();

    boolean isFreeDeliveryDiscountFull();

    boolean isFreeDeliveryTypeVoucherApplied();

    boolean isLoyaltyVoucherApplied();

    boolean isMinimumOrderAmountPassed();

    boolean isNormalVoucher();

    boolean isOnlyBinApplied();

    boolean isPickup();

    boolean isTalabatDeliveryVoucher();

    boolean isVoucherApplied();

    boolean isZeroVoucher();

    void notifyItemRemoved(int i11);

    void onAdditionalRequestEdited(String str);

    void removeInvalidVouchers();

    void removeVoucher();

    void setContinueButtonEnabled(boolean z11);

    void setMinimumOrderAmountVisible(boolean z11);

    void setNoCutlerySelection(boolean z11);

    void shouldShowFreeDelivery(Function1<? super TProOrderStatus, Unit> function1);

    boolean shouldShowNoCutlery();

    boolean shouldShowOldDeliveryCharge();
}
