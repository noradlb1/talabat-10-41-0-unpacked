package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;

public final class WalletCreditCardAllCardsItemLayoutBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView bankPartnerCampaignText;
    @NonNull
    public final TalabatRadioButton cardSelected;
    @NonNull
    public final TextView creditCardExpiryDate;
    @NonNull
    public final ImageView creditCardLogo;
    @NonNull
    public final TextView creditCardName;
    @NonNull
    public final TextView creditCardNumber;
    @NonNull
    public final View divider;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageButton setDefaultIcon;

    private WalletCreditCardAllCardsItemLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatRadioButton talabatRadioButton, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view, @NonNull ImageButton imageButton) {
        this.rootView = constraintLayout;
        this.bankPartnerCampaignText = talabatTextView;
        this.cardSelected = talabatRadioButton;
        this.creditCardExpiryDate = textView;
        this.creditCardLogo = imageView;
        this.creditCardName = textView2;
        this.creditCardNumber = textView3;
        this.divider = view;
        this.setDefaultIcon = imageButton;
    }

    @NonNull
    public static WalletCreditCardAllCardsItemLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.bank_partner_campaign_text;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.bank_partner_campaign_text);
        if (talabatTextView != null) {
            i11 = R.id.card_selected;
            TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.card_selected);
            if (talabatRadioButton != null) {
                i11 = R.id.credit_card_expiry_date;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.credit_card_expiry_date);
                if (textView != null) {
                    i11 = R.id.credit_card_logo;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.credit_card_logo);
                    if (imageView != null) {
                        i11 = R.id.credit_card_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.credit_card_name);
                        if (textView2 != null) {
                            i11 = R.id.credit_card_number;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.credit_card_number);
                            if (textView3 != null) {
                                i11 = R.id.divider;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider);
                                if (findChildViewById != null) {
                                    i11 = R.id.set_default_icon;
                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.set_default_icon);
                                    if (imageButton != null) {
                                        return new WalletCreditCardAllCardsItemLayoutBinding((ConstraintLayout) view, talabatTextView, talabatRadioButton, textView, imageView, textView2, textView3, findChildViewById, imageButton);
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
    public static WalletCreditCardAllCardsItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletCreditCardAllCardsItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_credit_card_all_cards_item_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
