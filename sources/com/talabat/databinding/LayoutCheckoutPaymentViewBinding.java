package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;

public final class LayoutCheckoutPaymentViewBinding implements ViewBinding {
    @NonNull
    public final LinearLayout avoidCashContents;
    @NonNull
    public final RelativeLayout avoidCashWarningView;
    @NonNull
    public final ImageView binDiscountIconAll;
    @NonNull
    public final TalabatTextView binOffersText;
    @NonNull
    public final RelativeLayout binOffersView;
    @NonNull
    public final ViewBnplTrackingEnteringPointBinding bnplEnteringPoint;
    @NonNull
    public final ViewBnplCheckoutEnteringPointBinding bnplV1EnteringPoint;
    @NonNull
    public final TalabatTextView cardExpiryDate;
    @NonNull
    public final RecyclerView cardList;
    @NonNull
    public final TalabatRadioButton cash;
    @NonNull
    public final ImageView cashIcon;
    @NonNull
    public final TalabatTextView cashLabelTxt;
    @NonNull
    public final RelativeLayout cashRadioLayout;
    @NonNull
    public final TalabatTextView cashbackAvailableCreditTxt;
    @NonNull
    public final RelativeLayout cashbackFeatureView;
    @NonNull
    public final RelativeLayout cashbackLayout;
    @NonNull
    public final ProgressBar cashbackProgressBar;
    @NonNull
    public final TalabatTextView cashbackText;
    @NonNull
    public final ImageView checkoutIcon;
    @NonNull
    public final LinearLayout checkoutPaymentView;
    @NonNull
    public final TalabatRadioButton checkoutRadio;
    @NonNull
    public final RelativeLayout checkoutRadioLayout;
    @NonNull
    public final TalabatTextView checkoutRadioTxt;
    @NonNull
    public final TalabatRadioButton creditCard;
    @NonNull
    public final TalabatTextView creditCardCardLabelTxt;
    @NonNull
    public final ImageView creditIcon;
    @NonNull
    public final RelativeLayout creditRadioLayout;
    @NonNull
    public final TalabatRadioButton debitCard;
    @NonNull
    public final TalabatTextView debitCardLabelTxt;
    @NonNull
    public final ImageView debitIcon;
    @NonNull
    public final RelativeLayout debitRadioLayout;
    @NonNull
    public final TalabatTextView defaultCreditCardName;
    @NonNull
    public final TalabatRadioButton defaultCreditCardRadioButton;
    @NonNull
    public final ImageView defaultCreditIcon;
    @NonNull
    public final RelativeLayout defaultPaymentOption;
    @NonNull
    public final TalabatTextView disabledCashExplanationText;
    @NonNull
    public final RelativeLayout disabledCashExplanationView;
    @NonNull
    public final TalabatRadioButton disabledDebitCard;
    @NonNull
    public final TalabatTextView disabledDebitCardLabelTxt;
    @NonNull
    public final ImageView disabledDebitIcon;
    @NonNull
    public final TalabatRadioButton disabledQpayDebitCard;
    @NonNull
    public final TalabatTextView disabledQpayDebitCardLabelTxt;
    @NonNull
    public final ImageView disabledQpayDebitIcon;
    @NonNull
    public final LinearLayout expiryLayout;
    @NonNull
    public final RelativeLayout kNetDebitCardLayout;
    @NonNull
    public final TextView kNetFallbackNotificationHeader;
    @NonNull
    public final TextView kNetFallbackNotificationMessage;
    @NonNull
    public final ImageView knetDebitCardIcon;
    @NonNull
    public final TalabatRadioButton knetDebitCardRadio;
    @NonNull
    public final TalabatTextView knetDebitCardText;
    @NonNull
    public final RelativeLayout knetUnavailable;
    @NonNull
    public final ConstraintLayout knetUnavailableMessage;
    @NonNull
    public final RelativeLayout newTalabatCreditSection;
    @NonNull
    public final TalabatTextView parallelBinContent;
    @NonNull
    public final ImageView parallelBinImage;
    @NonNull
    public final ProgressBar parallelBinImageProgressBar;
    @NonNull
    public final RelativeLayout parallelBinImageView;
    @NonNull
    public final TalabatTextView parallelBinMore;
    @NonNull
    public final RelativeLayout parallelBinView;
    @NonNull
    public final LinearLayout paymentOptionsContainer;
    @NonNull
    public final ImageView qpayDebitCardIcon;
    @NonNull
    public final RelativeLayout qpayDebitCardLayout;
    @NonNull
    public final TalabatRadioButton qpayDebitCardRadio;
    @NonNull
    public final TalabatTextView qpayDebitCardText;
    @NonNull
    public final TextView qpayFallbackNotificationHeader;
    @NonNull
    public final TextView qpayFallbackNotificationMessage;
    @NonNull
    public final RelativeLayout qpayUnavailable;
    @NonNull
    public final ConstraintLayout qpayUnavailableMessage;
    @NonNull
    public final LinearLayout radioButtonLayout;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatButton selectedCardChange;
    @NonNull
    public final TalabatRadioButton selectedPayfortCard;
    @NonNull
    public final ImageView selectedPayfortCardImg;
    @NonNull
    public final RelativeLayout selectedPayfortCardLayout;
    @NonNull
    public final TalabatTextView selectedPayfortCardlabelTxt;
    @NonNull
    public final TextView showMorePaymentOptions;
    @NonNull
    public final LinearLayout softPosInfo;
    @NonNull
    public final TalabatRadioButton talabatCredit;
    @NonNull
    public final ImageView talabatCreditIcon;
    @NonNull
    public final TalabatTextView talabatCreditLabelTxt;
    @NonNull
    public final ImageView visaCheckoutIcon;
    @NonNull
    public final TalabatTextView visaCheckoutLabelTxt;
    @NonNull
    public final TalabatRadioButton visaCheckoutRadio;
    @NonNull
    public final RelativeLayout visaCheckoutRadioLayout;
    @NonNull
    public final ProgressBar visaIconProgressBar;
    @NonNull
    public final AppCompatImageView warningImage;

    private LayoutCheckoutPaymentViewBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull ViewBnplTrackingEnteringPointBinding viewBnplTrackingEnteringPointBinding, @NonNull ViewBnplCheckoutEnteringPointBinding viewBnplCheckoutEnteringPointBinding, @NonNull TalabatTextView talabatTextView2, @NonNull RecyclerView recyclerView, @NonNull TalabatRadioButton talabatRadioButton, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView4, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull ProgressBar progressBar, @NonNull TalabatTextView talabatTextView5, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout3, @NonNull TalabatRadioButton talabatRadioButton2, @NonNull RelativeLayout relativeLayout6, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatRadioButton talabatRadioButton3, @NonNull TalabatTextView talabatTextView7, @NonNull ImageView imageView4, @NonNull RelativeLayout relativeLayout7, @NonNull TalabatRadioButton talabatRadioButton4, @NonNull TalabatTextView talabatTextView8, @NonNull ImageView imageView5, @NonNull RelativeLayout relativeLayout8, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatRadioButton talabatRadioButton5, @NonNull ImageView imageView6, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView10, @NonNull RelativeLayout relativeLayout10, @NonNull TalabatRadioButton talabatRadioButton6, @NonNull TalabatTextView talabatTextView11, @NonNull ImageView imageView7, @NonNull TalabatRadioButton talabatRadioButton7, @NonNull TalabatTextView talabatTextView12, @NonNull ImageView imageView8, @NonNull LinearLayout linearLayout4, @NonNull RelativeLayout relativeLayout11, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView9, @NonNull TalabatRadioButton talabatRadioButton8, @NonNull TalabatTextView talabatTextView13, @NonNull RelativeLayout relativeLayout12, @NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout13, @NonNull TalabatTextView talabatTextView14, @NonNull ImageView imageView10, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout14, @NonNull TalabatTextView talabatTextView15, @NonNull RelativeLayout relativeLayout15, @NonNull LinearLayout linearLayout5, @NonNull ImageView imageView11, @NonNull RelativeLayout relativeLayout16, @NonNull TalabatRadioButton talabatRadioButton9, @NonNull TalabatTextView talabatTextView16, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout17, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout6, @NonNull TalabatButton talabatButton, @NonNull TalabatRadioButton talabatRadioButton10, @NonNull ImageView imageView12, @NonNull RelativeLayout relativeLayout18, @NonNull TalabatTextView talabatTextView17, @NonNull TextView textView5, @NonNull LinearLayout linearLayout7, @NonNull TalabatRadioButton talabatRadioButton11, @NonNull ImageView imageView13, @NonNull TalabatTextView talabatTextView18, @NonNull ImageView imageView14, @NonNull TalabatTextView talabatTextView19, @NonNull TalabatRadioButton talabatRadioButton12, @NonNull RelativeLayout relativeLayout19, @NonNull ProgressBar progressBar3, @NonNull AppCompatImageView appCompatImageView) {
        this.rootView = linearLayout;
        this.avoidCashContents = linearLayout2;
        this.avoidCashWarningView = relativeLayout;
        this.binDiscountIconAll = imageView;
        this.binOffersText = talabatTextView;
        this.binOffersView = relativeLayout2;
        this.bnplEnteringPoint = viewBnplTrackingEnteringPointBinding;
        this.bnplV1EnteringPoint = viewBnplCheckoutEnteringPointBinding;
        this.cardExpiryDate = talabatTextView2;
        this.cardList = recyclerView;
        this.cash = talabatRadioButton;
        this.cashIcon = imageView2;
        this.cashLabelTxt = talabatTextView3;
        this.cashRadioLayout = relativeLayout3;
        this.cashbackAvailableCreditTxt = talabatTextView4;
        this.cashbackFeatureView = relativeLayout4;
        this.cashbackLayout = relativeLayout5;
        this.cashbackProgressBar = progressBar;
        this.cashbackText = talabatTextView5;
        this.checkoutIcon = imageView3;
        this.checkoutPaymentView = linearLayout3;
        this.checkoutRadio = talabatRadioButton2;
        this.checkoutRadioLayout = relativeLayout6;
        this.checkoutRadioTxt = talabatTextView6;
        this.creditCard = talabatRadioButton3;
        this.creditCardCardLabelTxt = talabatTextView7;
        this.creditIcon = imageView4;
        this.creditRadioLayout = relativeLayout7;
        this.debitCard = talabatRadioButton4;
        this.debitCardLabelTxt = talabatTextView8;
        this.debitIcon = imageView5;
        this.debitRadioLayout = relativeLayout8;
        this.defaultCreditCardName = talabatTextView9;
        this.defaultCreditCardRadioButton = talabatRadioButton5;
        this.defaultCreditIcon = imageView6;
        this.defaultPaymentOption = relativeLayout9;
        this.disabledCashExplanationText = talabatTextView10;
        this.disabledCashExplanationView = relativeLayout10;
        this.disabledDebitCard = talabatRadioButton6;
        this.disabledDebitCardLabelTxt = talabatTextView11;
        this.disabledDebitIcon = imageView7;
        this.disabledQpayDebitCard = talabatRadioButton7;
        this.disabledQpayDebitCardLabelTxt = talabatTextView12;
        this.disabledQpayDebitIcon = imageView8;
        this.expiryLayout = linearLayout4;
        this.kNetDebitCardLayout = relativeLayout11;
        this.kNetFallbackNotificationHeader = textView;
        this.kNetFallbackNotificationMessage = textView2;
        this.knetDebitCardIcon = imageView9;
        this.knetDebitCardRadio = talabatRadioButton8;
        this.knetDebitCardText = talabatTextView13;
        this.knetUnavailable = relativeLayout12;
        this.knetUnavailableMessage = constraintLayout;
        this.newTalabatCreditSection = relativeLayout13;
        this.parallelBinContent = talabatTextView14;
        this.parallelBinImage = imageView10;
        this.parallelBinImageProgressBar = progressBar2;
        this.parallelBinImageView = relativeLayout14;
        this.parallelBinMore = talabatTextView15;
        this.parallelBinView = relativeLayout15;
        this.paymentOptionsContainer = linearLayout5;
        this.qpayDebitCardIcon = imageView11;
        this.qpayDebitCardLayout = relativeLayout16;
        this.qpayDebitCardRadio = talabatRadioButton9;
        this.qpayDebitCardText = talabatTextView16;
        this.qpayFallbackNotificationHeader = textView3;
        this.qpayFallbackNotificationMessage = textView4;
        this.qpayUnavailable = relativeLayout17;
        this.qpayUnavailableMessage = constraintLayout2;
        this.radioButtonLayout = linearLayout6;
        this.selectedCardChange = talabatButton;
        this.selectedPayfortCard = talabatRadioButton10;
        this.selectedPayfortCardImg = imageView12;
        this.selectedPayfortCardLayout = relativeLayout18;
        this.selectedPayfortCardlabelTxt = talabatTextView17;
        this.showMorePaymentOptions = textView5;
        this.softPosInfo = linearLayout7;
        this.talabatCredit = talabatRadioButton11;
        this.talabatCreditIcon = imageView13;
        this.talabatCreditLabelTxt = talabatTextView18;
        this.visaCheckoutIcon = imageView14;
        this.visaCheckoutLabelTxt = talabatTextView19;
        this.visaCheckoutRadio = talabatRadioButton12;
        this.visaCheckoutRadioLayout = relativeLayout19;
        this.visaIconProgressBar = progressBar3;
        this.warningImage = appCompatImageView;
    }

    @NonNull
    public static LayoutCheckoutPaymentViewBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.avoid_cash_contents;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.avoid_cash_contents);
        if (linearLayout != null) {
            i11 = R.id.avoid_cash_warning_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.avoid_cash_warning_view);
            if (relativeLayout != null) {
                i11 = R.id.bin_discount_icon_all;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.bin_discount_icon_all);
                if (imageView != null) {
                    i11 = R.id.bin_offers_text;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bin_offers_text);
                    if (talabatTextView != null) {
                        i11 = R.id.bin_offers_view;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bin_offers_view);
                        if (relativeLayout2 != null) {
                            i11 = R.id.bnpl_entering_point;
                            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.bnpl_entering_point);
                            if (findChildViewById != null) {
                                ViewBnplTrackingEnteringPointBinding bind = ViewBnplTrackingEnteringPointBinding.bind(findChildViewById);
                                i11 = R.id.bnpl_V1_entering_point;
                                View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.bnpl_V1_entering_point);
                                if (findChildViewById2 != null) {
                                    ViewBnplCheckoutEnteringPointBinding bind2 = ViewBnplCheckoutEnteringPointBinding.bind(findChildViewById2);
                                    i11 = R.id.card_expiry_date;
                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.card_expiry_date);
                                    if (talabatTextView2 != null) {
                                        i11 = R.id.card_list;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.card_list);
                                        if (recyclerView != null) {
                                            i11 = R.id.cash;
                                            TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.cash);
                                            if (talabatRadioButton != null) {
                                                i11 = R.id.cash_icon;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.cash_icon);
                                                if (imageView2 != null) {
                                                    i11 = R.id.cash_label_txt;
                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.cash_label_txt);
                                                    if (talabatTextView3 != null) {
                                                        i11 = R.id.cash_radio_layout;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cash_radio_layout);
                                                        if (relativeLayout3 != null) {
                                                            i11 = R.id.cashback_available_credit_txt;
                                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.cashback_available_credit_txt);
                                                            if (talabatTextView4 != null) {
                                                                i11 = R.id.cashback_feature_view;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cashback_feature_view);
                                                                if (relativeLayout4 != null) {
                                                                    i11 = R.id.cashback_layout;
                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cashback_layout);
                                                                    if (relativeLayout5 != null) {
                                                                        i11 = R.id.cashback_progressBar;
                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.cashback_progressBar);
                                                                        if (progressBar != null) {
                                                                            i11 = R.id.cashback_text;
                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.cashback_text);
                                                                            if (talabatTextView5 != null) {
                                                                                i11 = R.id.checkout_icon;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.checkout_icon);
                                                                                if (imageView3 != null) {
                                                                                    i11 = R.id.checkout_payment_view;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.checkout_payment_view);
                                                                                    if (linearLayout2 != null) {
                                                                                        i11 = R.id.checkout_radio;
                                                                                        TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.checkout_radio);
                                                                                        if (talabatRadioButton2 != null) {
                                                                                            i11 = R.id.checkout_radio_layout;
                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.checkout_radio_layout);
                                                                                            if (relativeLayout6 != null) {
                                                                                                i11 = R.id.checkout_radio_txt;
                                                                                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.checkout_radio_txt);
                                                                                                if (talabatTextView6 != null) {
                                                                                                    i11 = R.id.credit_card;
                                                                                                    TalabatRadioButton talabatRadioButton3 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.credit_card);
                                                                                                    if (talabatRadioButton3 != null) {
                                                                                                        i11 = R.id.credit_card_card_label_txt;
                                                                                                        TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.credit_card_card_label_txt);
                                                                                                        if (talabatTextView7 != null) {
                                                                                                            i11 = R.id.credit_icon;
                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.credit_icon);
                                                                                                            if (imageView4 != null) {
                                                                                                                i11 = R.id.credit_radio_layout;
                                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.credit_radio_layout);
                                                                                                                if (relativeLayout7 != null) {
                                                                                                                    i11 = R.id.debit_card;
                                                                                                                    TalabatRadioButton talabatRadioButton4 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.debit_card);
                                                                                                                    if (talabatRadioButton4 != null) {
                                                                                                                        i11 = R.id.debit_card_label_txt;
                                                                                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.debit_card_label_txt);
                                                                                                                        if (talabatTextView8 != null) {
                                                                                                                            i11 = R.id.debit_icon;
                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.debit_icon);
                                                                                                                            if (imageView5 != null) {
                                                                                                                                i11 = R.id.debit_radio_layout;
                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.debit_radio_layout);
                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                    i11 = R.id.default_credit_card_name;
                                                                                                                                    TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.default_credit_card_name);
                                                                                                                                    if (talabatTextView9 != null) {
                                                                                                                                        i11 = R.id.default_credit_card_radio_button;
                                                                                                                                        TalabatRadioButton talabatRadioButton5 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.default_credit_card_radio_button);
                                                                                                                                        if (talabatRadioButton5 != null) {
                                                                                                                                            i11 = R.id.default_credit_icon;
                                                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.default_credit_icon);
                                                                                                                                            if (imageView6 != null) {
                                                                                                                                                i11 = R.id.default_payment_option;
                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.default_payment_option);
                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                    i11 = R.id.disabled_cash_explanation_text;
                                                                                                                                                    TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.disabled_cash_explanation_text);
                                                                                                                                                    if (talabatTextView10 != null) {
                                                                                                                                                        i11 = R.id.disabled_cash_explanation_view;
                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.disabled_cash_explanation_view);
                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                            i11 = R.id.disabled_debit_card;
                                                                                                                                                            TalabatRadioButton talabatRadioButton6 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.disabled_debit_card);
                                                                                                                                                            if (talabatRadioButton6 != null) {
                                                                                                                                                                i11 = R.id.disabled_debit_card_label_txt;
                                                                                                                                                                TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.disabled_debit_card_label_txt);
                                                                                                                                                                if (talabatTextView11 != null) {
                                                                                                                                                                    i11 = R.id.disabled_debit_icon;
                                                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.disabled_debit_icon);
                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                        i11 = R.id.disabled_qpay_debit_card;
                                                                                                                                                                        TalabatRadioButton talabatRadioButton7 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.disabled_qpay_debit_card);
                                                                                                                                                                        if (talabatRadioButton7 != null) {
                                                                                                                                                                            i11 = R.id.disabled_qpay_debit_card_label_txt;
                                                                                                                                                                            TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.disabled_qpay_debit_card_label_txt);
                                                                                                                                                                            if (talabatTextView12 != null) {
                                                                                                                                                                                i11 = R.id.disabled_qpay_debit_icon;
                                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, R.id.disabled_qpay_debit_icon);
                                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                                    i11 = R.id.expiry_layout;
                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.expiry_layout);
                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                        i11 = R.id.kNet_debit_card_layout;
                                                                                                                                                                                        RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.kNet_debit_card_layout);
                                                                                                                                                                                        if (relativeLayout11 != null) {
                                                                                                                                                                                            i11 = R.id.kNet_fallback_notification_header;
                                                                                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.kNet_fallback_notification_header);
                                                                                                                                                                                            if (textView != null) {
                                                                                                                                                                                                i11 = R.id.kNet_fallback_notification_message;
                                                                                                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.kNet_fallback_notification_message);
                                                                                                                                                                                                if (textView2 != null) {
                                                                                                                                                                                                    i11 = R.id.knet_debit_card_icon;
                                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, R.id.knet_debit_card_icon);
                                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                                        i11 = R.id.knet_debit_card_radio;
                                                                                                                                                                                                        TalabatRadioButton talabatRadioButton8 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.knet_debit_card_radio);
                                                                                                                                                                                                        if (talabatRadioButton8 != null) {
                                                                                                                                                                                                            i11 = R.id.knet_debit_card_text;
                                                                                                                                                                                                            TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.knet_debit_card_text);
                                                                                                                                                                                                            if (talabatTextView13 != null) {
                                                                                                                                                                                                                i11 = R.id.knet_unavailable;
                                                                                                                                                                                                                RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.knet_unavailable);
                                                                                                                                                                                                                if (relativeLayout12 != null) {
                                                                                                                                                                                                                    i11 = R.id.knet_unavailable_message;
                                                                                                                                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.knet_unavailable_message);
                                                                                                                                                                                                                    if (constraintLayout != null) {
                                                                                                                                                                                                                        i11 = R.id.new_talabat_credit_section;
                                                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.new_talabat_credit_section);
                                                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                                                            i11 = R.id.parallel_bin_content;
                                                                                                                                                                                                                            TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_content);
                                                                                                                                                                                                                            if (talabatTextView14 != null) {
                                                                                                                                                                                                                                i11 = R.id.parallel_bin_image;
                                                                                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image);
                                                                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                                                                    i11 = R.id.parallel_bin_image_progressBar;
                                                                                                                                                                                                                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_progressBar);
                                                                                                                                                                                                                                    if (progressBar2 != null) {
                                                                                                                                                                                                                                        i11 = R.id.parallel_bin_image_view;
                                                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_view);
                                                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                                                            i11 = R.id.parallel_bin_more;
                                                                                                                                                                                                                                            TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_more);
                                                                                                                                                                                                                                            if (talabatTextView15 != null) {
                                                                                                                                                                                                                                                i11 = R.id.parallel_bin_view;
                                                                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_view);
                                                                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                    i11 = R.id.payment_options_container;
                                                                                                                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_options_container);
                                                                                                                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                                                                                                                        i11 = R.id.qpay_debit_card_icon;
                                                                                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view2, R.id.qpay_debit_card_icon);
                                                                                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                                                                                            i11 = R.id.qpay_debit_card_layout;
                                                                                                                                                                                                                                                            RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.qpay_debit_card_layout);
                                                                                                                                                                                                                                                            if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                i11 = R.id.qpay_debit_card_radio;
                                                                                                                                                                                                                                                                TalabatRadioButton talabatRadioButton9 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.qpay_debit_card_radio);
                                                                                                                                                                                                                                                                if (talabatRadioButton9 != null) {
                                                                                                                                                                                                                                                                    i11 = R.id.qpay_debit_card_text;
                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.qpay_debit_card_text);
                                                                                                                                                                                                                                                                    if (talabatTextView16 != null) {
                                                                                                                                                                                                                                                                        i11 = R.id.qpay_fallback_notification_header;
                                                                                                                                                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.qpay_fallback_notification_header);
                                                                                                                                                                                                                                                                        if (textView3 != null) {
                                                                                                                                                                                                                                                                            i11 = R.id.qpay_fallback_notification_message;
                                                                                                                                                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.qpay_fallback_notification_message);
                                                                                                                                                                                                                                                                            if (textView4 != null) {
                                                                                                                                                                                                                                                                                i11 = R.id.qpay_unavailable;
                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.qpay_unavailable);
                                                                                                                                                                                                                                                                                if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                    i11 = R.id.qpay_unavailable_message;
                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.qpay_unavailable_message);
                                                                                                                                                                                                                                                                                    if (constraintLayout2 != null) {
                                                                                                                                                                                                                                                                                        i11 = R.id.radioButton_Layout;
                                                                                                                                                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.radioButton_Layout);
                                                                                                                                                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                                                                                                                                                            i11 = R.id.selected_card_change;
                                                                                                                                                                                                                                                                                            TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.selected_card_change);
                                                                                                                                                                                                                                                                                            if (talabatButton != null) {
                                                                                                                                                                                                                                                                                                i11 = R.id.selected_payfort_card;
                                                                                                                                                                                                                                                                                                TalabatRadioButton talabatRadioButton10 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.selected_payfort_card);
                                                                                                                                                                                                                                                                                                if (talabatRadioButton10 != null) {
                                                                                                                                                                                                                                                                                                    i11 = R.id.selected_payfort_card_img;
                                                                                                                                                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view2, R.id.selected_payfort_card_img);
                                                                                                                                                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                                                                                                                                                        i11 = R.id.selected_payfort_card_layout;
                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.selected_payfort_card_layout);
                                                                                                                                                                                                                                                                                                        if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                            i11 = R.id.selected_payfort_cardlabelTxt;
                                                                                                                                                                                                                                                                                                            TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.selected_payfort_cardlabelTxt);
                                                                                                                                                                                                                                                                                                            if (talabatTextView17 != null) {
                                                                                                                                                                                                                                                                                                                i11 = R.id.show_more_payment_options;
                                                                                                                                                                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.show_more_payment_options);
                                                                                                                                                                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                                                                                                                                                                    i11 = R.id.soft_pos_info;
                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.soft_pos_info);
                                                                                                                                                                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                                                                                                                                                                        i11 = R.id.talabat_credit;
                                                                                                                                                                                                                                                                                                                        TalabatRadioButton talabatRadioButton11 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.talabat_credit);
                                                                                                                                                                                                                                                                                                                        if (talabatRadioButton11 != null) {
                                                                                                                                                                                                                                                                                                                            i11 = R.id.talabat_credit_icon;
                                                                                                                                                                                                                                                                                                                            ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_icon);
                                                                                                                                                                                                                                                                                                                            if (imageView13 != null) {
                                                                                                                                                                                                                                                                                                                                i11 = R.id.talabat_credit_label_txt;
                                                                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_label_txt);
                                                                                                                                                                                                                                                                                                                                if (talabatTextView18 != null) {
                                                                                                                                                                                                                                                                                                                                    i11 = R.id.visa_checkout_icon;
                                                                                                                                                                                                                                                                                                                                    ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view2, R.id.visa_checkout_icon);
                                                                                                                                                                                                                                                                                                                                    if (imageView14 != null) {
                                                                                                                                                                                                                                                                                                                                        i11 = R.id.visa_checkout_labelTxt;
                                                                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView19 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.visa_checkout_labelTxt);
                                                                                                                                                                                                                                                                                                                                        if (talabatTextView19 != null) {
                                                                                                                                                                                                                                                                                                                                            i11 = R.id.visa_checkout_radio;
                                                                                                                                                                                                                                                                                                                                            TalabatRadioButton talabatRadioButton12 = (TalabatRadioButton) ViewBindings.findChildViewById(view2, R.id.visa_checkout_radio);
                                                                                                                                                                                                                                                                                                                                            if (talabatRadioButton12 != null) {
                                                                                                                                                                                                                                                                                                                                                i11 = R.id.visa_checkout_radio_layout;
                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.visa_checkout_radio_layout);
                                                                                                                                                                                                                                                                                                                                                if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                    i11 = R.id.visa_icon_progressBar;
                                                                                                                                                                                                                                                                                                                                                    ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.visa_icon_progressBar);
                                                                                                                                                                                                                                                                                                                                                    if (progressBar3 != null) {
                                                                                                                                                                                                                                                                                                                                                        i11 = R.id.warning_image;
                                                                                                                                                                                                                                                                                                                                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, R.id.warning_image);
                                                                                                                                                                                                                                                                                                                                                        if (appCompatImageView != null) {
                                                                                                                                                                                                                                                                                                                                                            return new LayoutCheckoutPaymentViewBinding((LinearLayout) view2, linearLayout, relativeLayout, imageView, talabatTextView, relativeLayout2, bind, bind2, talabatTextView2, recyclerView, talabatRadioButton, imageView2, talabatTextView3, relativeLayout3, talabatTextView4, relativeLayout4, relativeLayout5, progressBar, talabatTextView5, imageView3, linearLayout2, talabatRadioButton2, relativeLayout6, talabatTextView6, talabatRadioButton3, talabatTextView7, imageView4, relativeLayout7, talabatRadioButton4, talabatTextView8, imageView5, relativeLayout8, talabatTextView9, talabatRadioButton5, imageView6, relativeLayout9, talabatTextView10, relativeLayout10, talabatRadioButton6, talabatTextView11, imageView7, talabatRadioButton7, talabatTextView12, imageView8, linearLayout3, relativeLayout11, textView, textView2, imageView9, talabatRadioButton8, talabatTextView13, relativeLayout12, constraintLayout, relativeLayout13, talabatTextView14, imageView10, progressBar2, relativeLayout14, talabatTextView15, relativeLayout15, linearLayout4, imageView11, relativeLayout16, talabatRadioButton9, talabatTextView16, textView3, textView4, relativeLayout17, constraintLayout2, linearLayout5, talabatButton, talabatRadioButton10, imageView12, relativeLayout18, talabatTextView17, textView5, linearLayout6, talabatRadioButton11, imageView13, talabatTextView18, imageView14, talabatTextView19, talabatRadioButton12, relativeLayout19, progressBar3, appCompatImageView);
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
    public static LayoutCheckoutPaymentViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutCheckoutPaymentViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_checkout_payment_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
