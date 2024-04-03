package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.talabat.R;
import com.talabat.ScrollPreventedTalabatTextView;
import com.talabat.TalabatTextView;
import com.talabat.fees.ServiceFeeView;
import com.talabat.fees.SmallOrderFeeView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class ActivityGetCardTokenEnBinding implements ViewBinding {
    @NonNull
    public final TextView amountTransaction;
    @NonNull
    public final ViewBenefitAddCardDeflectionBinding benefitAddCardDeflection;
    @NonNull
    public final ConstraintLayout benefitNotificationContainer;
    @NonNull
    public final TextView benefitNotificationTextView;
    @NonNull
    public final ImageView binDiscountIcon;
    @NonNull
    public final TalabatTextView binVoucherText;
    @NonNull
    public final RelativeLayout binVoucherView;
    @NonNull
    public final LinearLayout buttonLayout;
    @NonNull
    public final TalabatStrokeButton cancel;
    @NonNull
    public final TextView cardNumErrorTV;
    @NonNull
    public final EditText cardNumberET;
    @NonNull
    public final TextInputLayout cardNumberIL;
    @NonNull
    public final ImageView cartTypeIV;
    @NonNull
    public final TextView cent;
    @NonNull
    public final ImageView closeBottomSheet;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final RelativeLayout couponDiscountLayout;
    @NonNull
    public final TalabatTextView couponDiscountValue;
    @NonNull
    public final TalabatTextView creditCardPaymentAmount;
    @NonNull
    public final EditText cvvET;
    @NonNull
    public final TextView cvvErrorTV;
    @NonNull
    public final RelativeLayout cvvExpError;
    @NonNull
    public final TextInputLayout cvvIL;
    @NonNull
    public final ImageView cvvIcon;
    @NonNull
    public final TalabatTextView deliveryChargesText;
    @NonNull
    public final TalabatTextView deliveryChargesValue;
    @NonNull
    public final RelativeLayout dicountVoucherLayout;
    @NonNull
    public final TalabatTextView discountVoucherValue;
    @NonNull
    public final ImageView errorIcon;
    @NonNull
    public final LinearLayout expiryDateContainer;
    @NonNull
    public final EditText expiryDateET;
    @NonNull
    public final TextView expiryDateErrorTV;
    @NonNull
    public final TextInputLayout expiryDateIL;
    @NonNull
    public final GemCheckoutDiscountView gemCheckoutDiscountView;
    @NonNull
    public final RelativeLayout gemDiscountView;
    @NonNull
    public final FrameLayout gemDiscountViewLayout;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final TalabatTextView gemOfferPrice;
    @NonNull
    public final TalabatTextView gemOfferText;
    @NonNull
    public final TalabatFillButton generateToken;
    @NonNull
    public final TalabatTextView grandTotalValue;
    @NonNull
    public final EditText holderNameET;
    @NonNull
    public final TextInputLayout holderNameIL;
    @NonNull
    public final LinearLayout moreSecurityContainer;
    @NonNull
    public final FrameLayout moreSecurityContainerSeprator;
    @NonNull
    public final TalabatTextView muncipalityChargesText;
    @NonNull
    public final TalabatTextView muncipalityChargesValue;
    @NonNull
    public final RelativeLayout muncipalityChargesView;
    @NonNull
    public final LinearLayout nonBenefitBinInputContainer;
    @NonNull
    public final LinearLayout normalFlowView;
    @NonNull
    public final TalabatTextView oldDeliveryCharges;
    @NonNull
    public final RelativeLayout parentLayout;
    @NonNull
    public final RelativeLayout payByCreditCardView;
    @NonNull
    public final ScrollPreventedTalabatTextView paymentTerms;
    @NonNull
    public final RelativeLayout progressLayout;
    @NonNull
    public final ViewQpayAddCardDeflectionBinding qpayAddCardDeflection;
    @NonNull
    public final TalabatTextView remainingPayAmount;
    @NonNull
    public final RelativeLayout remainingToPayView;
    @NonNull
    public final RelativeLayout rememberMeRL;
    @NonNull
    public final ToggleButton rememberMeTB;
    @NonNull
    public final RelativeLayout restaurantDeliveryChargesView;
    @NonNull
    public final TalabatTextView riderTipChargesText;
    @NonNull
    public final RelativeLayout riderTipChargesView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout securityInfoContainer;
    @NonNull
    public final ServiceFeeView serviceFeeView;
    @NonNull
    public final SmallOrderFeeView smallOrderFeeView;
    @NonNull
    public final CardView subContentView;
    @NonNull
    public final TalabatTextView subtotalValue;
    @NonNull
    public final LinearLayout talabatCreditFlowView;
    @NonNull
    public final TalabatTextView talabatCreditGrandTotalValue;
    @NonNull
    public final TalabatTextView talabatCreditPaymentAmount;
    @NonNull
    public final RelativeLayout talabatDeliveryVoucherDiscountLayout;
    @NonNull
    public final TalabatTextView talabatDeliveryVoucherDiscountValue;
    @NonNull
    public final RelativeLayout termsLayout;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final TalabatTextView touristTaxText;
    @NonNull
    public final TalabatTextView touristTaxValue;
    @NonNull
    public final RelativeLayout touristTaxView;
    @NonNull
    public final TalabatTextView voucherDiscount;

    private ActivityGetCardTokenEnBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ViewBenefitAddCardDeflectionBinding viewBenefitAddCardDeflectionBinding, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull TextView textView3, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout, @NonNull ImageView imageView2, @NonNull TextView textView4, @NonNull ImageView imageView3, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull EditText editText2, @NonNull TextView textView5, @NonNull RelativeLayout relativeLayout5, @NonNull TextInputLayout textInputLayout2, @NonNull ImageView imageView4, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull RelativeLayout relativeLayout6, @NonNull TalabatTextView talabatTextView6, @NonNull ImageView imageView5, @NonNull LinearLayout linearLayout2, @NonNull EditText editText3, @NonNull TextView textView6, @NonNull TextInputLayout textInputLayout3, @NonNull GemCheckoutDiscountView gemCheckoutDiscountView2, @NonNull RelativeLayout relativeLayout7, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout8, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView9, @NonNull EditText editText4, @NonNull TextInputLayout textInputLayout4, @NonNull LinearLayout linearLayout3, @NonNull FrameLayout frameLayout2, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView11, @NonNull RelativeLayout relativeLayout9, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView12, @NonNull RelativeLayout relativeLayout10, @NonNull RelativeLayout relativeLayout11, @NonNull ScrollPreventedTalabatTextView scrollPreventedTalabatTextView, @NonNull RelativeLayout relativeLayout12, @NonNull ViewQpayAddCardDeflectionBinding viewQpayAddCardDeflectionBinding, @NonNull TalabatTextView talabatTextView13, @NonNull RelativeLayout relativeLayout13, @NonNull RelativeLayout relativeLayout14, @NonNull ToggleButton toggleButton, @NonNull RelativeLayout relativeLayout15, @NonNull TalabatTextView talabatTextView14, @NonNull RelativeLayout relativeLayout16, @NonNull RelativeLayout relativeLayout17, @NonNull ServiceFeeView serviceFeeView2, @NonNull SmallOrderFeeView smallOrderFeeView2, @NonNull CardView cardView, @NonNull TalabatTextView talabatTextView15, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView16, @NonNull TalabatTextView talabatTextView17, @NonNull RelativeLayout relativeLayout18, @NonNull TalabatTextView talabatTextView18, @NonNull RelativeLayout relativeLayout19, @NonNull TalabatTextView talabatTextView19, @NonNull TalabatTextView talabatTextView20, @NonNull TalabatTextView talabatTextView21, @NonNull RelativeLayout relativeLayout20, @NonNull TalabatTextView talabatTextView22) {
        this.rootView = relativeLayout;
        this.amountTransaction = textView;
        this.benefitAddCardDeflection = viewBenefitAddCardDeflectionBinding;
        this.benefitNotificationContainer = constraintLayout;
        this.benefitNotificationTextView = textView2;
        this.binDiscountIcon = imageView;
        this.binVoucherText = talabatTextView;
        this.binVoucherView = relativeLayout2;
        this.buttonLayout = linearLayout;
        this.cancel = talabatStrokeButton;
        this.cardNumErrorTV = textView3;
        this.cardNumberET = editText;
        this.cardNumberIL = textInputLayout;
        this.cartTypeIV = imageView2;
        this.cent = textView4;
        this.closeBottomSheet = imageView3;
        this.contentView = relativeLayout3;
        this.couponDiscountLayout = relativeLayout4;
        this.couponDiscountValue = talabatTextView2;
        this.creditCardPaymentAmount = talabatTextView3;
        this.cvvET = editText2;
        this.cvvErrorTV = textView5;
        this.cvvExpError = relativeLayout5;
        this.cvvIL = textInputLayout2;
        this.cvvIcon = imageView4;
        this.deliveryChargesText = talabatTextView4;
        this.deliveryChargesValue = talabatTextView5;
        this.dicountVoucherLayout = relativeLayout6;
        this.discountVoucherValue = talabatTextView6;
        this.errorIcon = imageView5;
        this.expiryDateContainer = linearLayout2;
        this.expiryDateET = editText3;
        this.expiryDateErrorTV = textView6;
        this.expiryDateIL = textInputLayout3;
        this.gemCheckoutDiscountView = gemCheckoutDiscountView2;
        this.gemDiscountView = relativeLayout7;
        this.gemDiscountViewLayout = frameLayout;
        this.gemFooterView = relativeLayout8;
        this.gemOfferPrice = talabatTextView7;
        this.gemOfferText = talabatTextView8;
        this.generateToken = talabatFillButton;
        this.grandTotalValue = talabatTextView9;
        this.holderNameET = editText4;
        this.holderNameIL = textInputLayout4;
        this.moreSecurityContainer = linearLayout3;
        this.moreSecurityContainerSeprator = frameLayout2;
        this.muncipalityChargesText = talabatTextView10;
        this.muncipalityChargesValue = talabatTextView11;
        this.muncipalityChargesView = relativeLayout9;
        this.nonBenefitBinInputContainer = linearLayout4;
        this.normalFlowView = linearLayout5;
        this.oldDeliveryCharges = talabatTextView12;
        this.parentLayout = relativeLayout10;
        this.payByCreditCardView = relativeLayout11;
        this.paymentTerms = scrollPreventedTalabatTextView;
        this.progressLayout = relativeLayout12;
        this.qpayAddCardDeflection = viewQpayAddCardDeflectionBinding;
        this.remainingPayAmount = talabatTextView13;
        this.remainingToPayView = relativeLayout13;
        this.rememberMeRL = relativeLayout14;
        this.rememberMeTB = toggleButton;
        this.restaurantDeliveryChargesView = relativeLayout15;
        this.riderTipChargesText = talabatTextView14;
        this.riderTipChargesView = relativeLayout16;
        this.securityInfoContainer = relativeLayout17;
        this.serviceFeeView = serviceFeeView2;
        this.smallOrderFeeView = smallOrderFeeView2;
        this.subContentView = cardView;
        this.subtotalValue = talabatTextView15;
        this.talabatCreditFlowView = linearLayout6;
        this.talabatCreditGrandTotalValue = talabatTextView16;
        this.talabatCreditPaymentAmount = talabatTextView17;
        this.talabatDeliveryVoucherDiscountLayout = relativeLayout18;
        this.talabatDeliveryVoucherDiscountValue = talabatTextView18;
        this.termsLayout = relativeLayout19;
        this.title = talabatTextView19;
        this.touristTaxText = talabatTextView20;
        this.touristTaxValue = talabatTextView21;
        this.touristTaxView = relativeLayout20;
        this.voucherDiscount = talabatTextView22;
    }

    @NonNull
    public static ActivityGetCardTokenEnBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.amount_transaction;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.amount_transaction);
        if (textView != null) {
            i11 = R.id.benefit_add_card_deflection;
            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.benefit_add_card_deflection);
            if (findChildViewById != null) {
                ViewBenefitAddCardDeflectionBinding bind = ViewBenefitAddCardDeflectionBinding.bind(findChildViewById);
                i11 = R.id.benefit_notification_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.benefit_notification_container);
                if (constraintLayout != null) {
                    i11 = R.id.benefit_notification_text_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.benefit_notification_text_view);
                    if (textView2 != null) {
                        i11 = R.id.bin_discount_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.bin_discount_icon);
                        if (imageView != null) {
                            i11 = R.id.bin_voucher_text;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bin_voucher_text);
                            if (talabatTextView != null) {
                                i11 = R.id.bin_voucher_View;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bin_voucher_View);
                                if (relativeLayout != null) {
                                    i11 = R.id.button_layout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.button_layout);
                                    if (linearLayout != null) {
                                        i11 = R.id.cancel;
                                        TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.cancel);
                                        if (talabatStrokeButton != null) {
                                            i11 = R.id.cardNumErrorTV;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.cardNumErrorTV);
                                            if (textView3 != null) {
                                                i11 = R.id.cardNumberET;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.cardNumberET);
                                                if (editText != null) {
                                                    i11 = R.id.cardNumberIL;
                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.cardNumberIL);
                                                    if (textInputLayout != null) {
                                                        i11 = R.id.cartTypeIV;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.cartTypeIV);
                                                        if (imageView2 != null) {
                                                            i11 = R.id.cent;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.cent);
                                                            if (textView4 != null) {
                                                                i11 = R.id.close_bottom_sheet;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_bottom_sheet);
                                                                if (imageView3 != null) {
                                                                    i11 = R.id.content_view;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.content_view);
                                                                    if (relativeLayout2 != null) {
                                                                        i11 = R.id.coupon_discount_layout;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.coupon_discount_layout);
                                                                        if (relativeLayout3 != null) {
                                                                            i11 = R.id.coupon_discount_value;
                                                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.coupon_discount_value);
                                                                            if (talabatTextView2 != null) {
                                                                                i11 = R.id.credit_card_payment_amount;
                                                                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.credit_card_payment_amount);
                                                                                if (talabatTextView3 != null) {
                                                                                    i11 = R.id.cvvET;
                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view2, R.id.cvvET);
                                                                                    if (editText2 != null) {
                                                                                        i11 = R.id.cvvErrorTV;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.cvvErrorTV);
                                                                                        if (textView5 != null) {
                                                                                            i11 = R.id.cvv_exp_error;
                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cvv_exp_error);
                                                                                            if (relativeLayout4 != null) {
                                                                                                i11 = R.id.cvvIL;
                                                                                                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.cvvIL);
                                                                                                if (textInputLayout2 != null) {
                                                                                                    i11 = R.id.cvv_icon;
                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.cvv_icon);
                                                                                                    if (imageView4 != null) {
                                                                                                        i11 = R.id.delivery_charges_text;
                                                                                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_charges_text);
                                                                                                        if (talabatTextView4 != null) {
                                                                                                            i11 = R.id.delivery_charges_value;
                                                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_charges_value);
                                                                                                            if (talabatTextView5 != null) {
                                                                                                                i11 = R.id.dicount_voucher_layout;
                                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.dicount_voucher_layout);
                                                                                                                if (relativeLayout5 != null) {
                                                                                                                    i11 = R.id.discount_voucher_value;
                                                                                                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.discount_voucher_value);
                                                                                                                    if (talabatTextView6 != null) {
                                                                                                                        i11 = R.id.error_icon;
                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.error_icon);
                                                                                                                        if (imageView5 != null) {
                                                                                                                            i11 = R.id.expiry_date_container;
                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.expiry_date_container);
                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                i11 = R.id.expiryDateET;
                                                                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(view2, R.id.expiryDateET);
                                                                                                                                if (editText3 != null) {
                                                                                                                                    i11 = R.id.expiryDateErrorTV;
                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.expiryDateErrorTV);
                                                                                                                                    if (textView6 != null) {
                                                                                                                                        i11 = R.id.expiryDateIL;
                                                                                                                                        TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.expiryDateIL);
                                                                                                                                        if (textInputLayout3 != null) {
                                                                                                                                            i11 = R.id.gemCheckoutDiscountView;
                                                                                                                                            GemCheckoutDiscountView gemCheckoutDiscountView2 = (GemCheckoutDiscountView) ViewBindings.findChildViewById(view2, R.id.gemCheckoutDiscountView);
                                                                                                                                            if (gemCheckoutDiscountView2 != null) {
                                                                                                                                                i11 = R.id.gem_discount_view;
                                                                                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_discount_view);
                                                                                                                                                if (relativeLayout6 != null) {
                                                                                                                                                    i11 = R.id.gem_discount_view_layout;
                                                                                                                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.gem_discount_view_layout);
                                                                                                                                                    if (frameLayout != null) {
                                                                                                                                                        i11 = R.id.gem_footer_view;
                                                                                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                                                                                                                                        if (relativeLayout7 != null) {
                                                                                                                                                            i11 = R.id.gem_offer_price;
                                                                                                                                                            TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_offer_price);
                                                                                                                                                            if (talabatTextView7 != null) {
                                                                                                                                                                i11 = R.id.gem_offer_text;
                                                                                                                                                                TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_offer_text);
                                                                                                                                                                if (talabatTextView8 != null) {
                                                                                                                                                                    i11 = R.id.generate_token;
                                                                                                                                                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.generate_token);
                                                                                                                                                                    if (talabatFillButton != null) {
                                                                                                                                                                        i11 = R.id.grand_total_value;
                                                                                                                                                                        TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.grand_total_value);
                                                                                                                                                                        if (talabatTextView9 != null) {
                                                                                                                                                                            i11 = R.id.holderNameET;
                                                                                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view2, R.id.holderNameET);
                                                                                                                                                                            if (editText4 != null) {
                                                                                                                                                                                i11 = R.id.holderNameIL;
                                                                                                                                                                                TextInputLayout textInputLayout4 = (TextInputLayout) ViewBindings.findChildViewById(view2, R.id.holderNameIL);
                                                                                                                                                                                if (textInputLayout4 != null) {
                                                                                                                                                                                    i11 = R.id.more_security_container;
                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.more_security_container);
                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                        i11 = R.id.more_security_container_seprator;
                                                                                                                                                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.more_security_container_seprator);
                                                                                                                                                                                        if (frameLayout2 != null) {
                                                                                                                                                                                            i11 = R.id.muncipality_charges_text;
                                                                                                                                                                                            TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_text);
                                                                                                                                                                                            if (talabatTextView10 != null) {
                                                                                                                                                                                                i11 = R.id.muncipality_charges_value;
                                                                                                                                                                                                TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_value);
                                                                                                                                                                                                if (talabatTextView11 != null) {
                                                                                                                                                                                                    i11 = R.id.muncipality_charges_view;
                                                                                                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.muncipality_charges_view);
                                                                                                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                                                                                                        i11 = R.id.non_benefit_bin_input_container;
                                                                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.non_benefit_bin_input_container);
                                                                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                                                                            i11 = R.id.normal_flow_view;
                                                                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.normal_flow_view);
                                                                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                                                                i11 = R.id.old_delivery_charges;
                                                                                                                                                                                                                TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.old_delivery_charges);
                                                                                                                                                                                                                if (talabatTextView12 != null) {
                                                                                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) view2;
                                                                                                                                                                                                                    i11 = R.id.pay_by_credit_card_view;
                                                                                                                                                                                                                    RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pay_by_credit_card_view);
                                                                                                                                                                                                                    if (relativeLayout10 != null) {
                                                                                                                                                                                                                        i11 = R.id.payment_terms;
                                                                                                                                                                                                                        ScrollPreventedTalabatTextView scrollPreventedTalabatTextView = (ScrollPreventedTalabatTextView) ViewBindings.findChildViewById(view2, R.id.payment_terms);
                                                                                                                                                                                                                        if (scrollPreventedTalabatTextView != null) {
                                                                                                                                                                                                                            i11 = R.id.progress_layout;
                                                                                                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.progress_layout);
                                                                                                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                                                                                                i11 = R.id.qpay_add_card_deflection;
                                                                                                                                                                                                                                View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.qpay_add_card_deflection);
                                                                                                                                                                                                                                if (findChildViewById2 != null) {
                                                                                                                                                                                                                                    ViewQpayAddCardDeflectionBinding bind2 = ViewQpayAddCardDeflectionBinding.bind(findChildViewById2);
                                                                                                                                                                                                                                    i11 = R.id.remaining_pay_amount;
                                                                                                                                                                                                                                    TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.remaining_pay_amount);
                                                                                                                                                                                                                                    if (talabatTextView13 != null) {
                                                                                                                                                                                                                                        i11 = R.id.remaining_to_pay_view;
                                                                                                                                                                                                                                        RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.remaining_to_pay_view);
                                                                                                                                                                                                                                        if (relativeLayout12 != null) {
                                                                                                                                                                                                                                            i11 = R.id.rememberMeRL;
                                                                                                                                                                                                                                            RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rememberMeRL);
                                                                                                                                                                                                                                            if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                i11 = R.id.rememberMeTB;
                                                                                                                                                                                                                                                ToggleButton toggleButton = (ToggleButton) ViewBindings.findChildViewById(view2, R.id.rememberMeTB);
                                                                                                                                                                                                                                                if (toggleButton != null) {
                                                                                                                                                                                                                                                    i11 = R.id.restaurant_delivery_charges_view;
                                                                                                                                                                                                                                                    RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.restaurant_delivery_charges_view);
                                                                                                                                                                                                                                                    if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                        i11 = R.id.rider_tip_charges_text;
                                                                                                                                                                                                                                                        TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rider_tip_charges_text);
                                                                                                                                                                                                                                                        if (talabatTextView14 != null) {
                                                                                                                                                                                                                                                            i11 = R.id.rider_tip_charges_view;
                                                                                                                                                                                                                                                            RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rider_tip_charges_view);
                                                                                                                                                                                                                                                            if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                i11 = R.id.security_info_container;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.security_info_container);
                                                                                                                                                                                                                                                                if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                    i11 = R.id.service_fee_view;
                                                                                                                                                                                                                                                                    ServiceFeeView serviceFeeView2 = (ServiceFeeView) ViewBindings.findChildViewById(view2, R.id.service_fee_view);
                                                                                                                                                                                                                                                                    if (serviceFeeView2 != null) {
                                                                                                                                                                                                                                                                        i11 = R.id.small_order_fee_view;
                                                                                                                                                                                                                                                                        SmallOrderFeeView smallOrderFeeView2 = (SmallOrderFeeView) ViewBindings.findChildViewById(view2, R.id.small_order_fee_view);
                                                                                                                                                                                                                                                                        if (smallOrderFeeView2 != null) {
                                                                                                                                                                                                                                                                            i11 = R.id.sub_content_view;
                                                                                                                                                                                                                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.sub_content_view);
                                                                                                                                                                                                                                                                            if (cardView != null) {
                                                                                                                                                                                                                                                                                i11 = R.id.subtotal_value;
                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.subtotal_value);
                                                                                                                                                                                                                                                                                if (talabatTextView15 != null) {
                                                                                                                                                                                                                                                                                    i11 = R.id.talabat_credit_flow_view;
                                                                                                                                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.talabat_credit_flow_view);
                                                                                                                                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                                                                                                                                        i11 = R.id.talabat_credit_grand_total_value;
                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_grand_total_value);
                                                                                                                                                                                                                                                                                        if (talabatTextView16 != null) {
                                                                                                                                                                                                                                                                                            i11 = R.id.talabat_credit_payment_amount;
                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_payment_amount);
                                                                                                                                                                                                                                                                                            if (talabatTextView17 != null) {
                                                                                                                                                                                                                                                                                                i11 = R.id.talabat_delivery_voucher_discount_layout;
                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_delivery_voucher_discount_layout);
                                                                                                                                                                                                                                                                                                if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                                    i11 = R.id.talabat_delivery_voucher_discount_value;
                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_delivery_voucher_discount_value);
                                                                                                                                                                                                                                                                                                    if (talabatTextView18 != null) {
                                                                                                                                                                                                                                                                                                        i11 = R.id.terms_layout;
                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.terms_layout);
                                                                                                                                                                                                                                                                                                        if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                            i11 = R.id.title;
                                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                                                                                                            if (talabatTextView19 != null) {
                                                                                                                                                                                                                                                                                                                i11 = R.id.tourist_tax_text;
                                                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView20 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tourist_tax_text);
                                                                                                                                                                                                                                                                                                                if (talabatTextView20 != null) {
                                                                                                                                                                                                                                                                                                                    i11 = R.id.tourist_tax_value;
                                                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView21 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tourist_tax_value);
                                                                                                                                                                                                                                                                                                                    if (talabatTextView21 != null) {
                                                                                                                                                                                                                                                                                                                        i11 = R.id.tourist_tax_view;
                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.tourist_tax_view);
                                                                                                                                                                                                                                                                                                                        if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                            i11 = R.id.voucher_discount;
                                                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView22 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.voucher_discount);
                                                                                                                                                                                                                                                                                                                            if (talabatTextView22 != null) {
                                                                                                                                                                                                                                                                                                                                return new ActivityGetCardTokenEnBinding(relativeLayout9, textView, bind, constraintLayout, textView2, imageView, talabatTextView, relativeLayout, linearLayout, talabatStrokeButton, textView3, editText, textInputLayout, imageView2, textView4, imageView3, relativeLayout2, relativeLayout3, talabatTextView2, talabatTextView3, editText2, textView5, relativeLayout4, textInputLayout2, imageView4, talabatTextView4, talabatTextView5, relativeLayout5, talabatTextView6, imageView5, linearLayout2, editText3, textView6, textInputLayout3, gemCheckoutDiscountView2, relativeLayout6, frameLayout, relativeLayout7, talabatTextView7, talabatTextView8, talabatFillButton, talabatTextView9, editText4, textInputLayout4, linearLayout3, frameLayout2, talabatTextView10, talabatTextView11, relativeLayout8, linearLayout4, linearLayout5, talabatTextView12, relativeLayout9, relativeLayout10, scrollPreventedTalabatTextView, relativeLayout11, bind2, talabatTextView13, relativeLayout12, relativeLayout13, toggleButton, relativeLayout14, talabatTextView14, relativeLayout15, relativeLayout16, serviceFeeView2, smallOrderFeeView2, cardView, talabatTextView15, linearLayout6, talabatTextView16, talabatTextView17, relativeLayout17, talabatTextView18, relativeLayout18, talabatTextView19, talabatTextView20, talabatTextView21, relativeLayout19, talabatTextView22);
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityGetCardTokenEnBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityGetCardTokenEnBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_get_card_token_en, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
