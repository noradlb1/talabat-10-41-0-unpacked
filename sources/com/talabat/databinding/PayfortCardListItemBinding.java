package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;

public final class PayfortCardListItemBinding implements ViewBinding {
    @NonNull
    public final TalabatButton cardEditBtn;
    @NonNull
    public final TalabatTextView cardExpiredLabel;
    @NonNull
    public final TalabatTextView cardExpiryDate;
    @NonNull
    public final TalabatTextView cardHolderName;
    @NonNull
    public final ImageView cardImg;
    @NonNull
    public final TalabatTextView cardNo;
    @NonNull
    public final TalabatRadioButton cardSelector;
    @NonNull
    public final LinearLayout mainContainer;
    @NonNull
    private final CardView rootView;

    private PayfortCardListItemBinding(@NonNull CardView cardView, @NonNull TalabatButton talabatButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatRadioButton talabatRadioButton, @NonNull LinearLayout linearLayout) {
        this.rootView = cardView;
        this.cardEditBtn = talabatButton;
        this.cardExpiredLabel = talabatTextView;
        this.cardExpiryDate = talabatTextView2;
        this.cardHolderName = talabatTextView3;
        this.cardImg = imageView;
        this.cardNo = talabatTextView4;
        this.cardSelector = talabatRadioButton;
        this.mainContainer = linearLayout;
    }

    @NonNull
    public static PayfortCardListItemBinding bind(@NonNull View view) {
        int i11 = R.id.card_edit_btn;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.card_edit_btn);
        if (talabatButton != null) {
            i11 = R.id.card_expired_label;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.card_expired_label);
            if (talabatTextView != null) {
                i11 = R.id.card_expiry_date;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.card_expiry_date);
                if (talabatTextView2 != null) {
                    i11 = R.id.card_holder_name;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.card_holder_name);
                    if (talabatTextView3 != null) {
                        i11 = R.id.card_img;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.card_img);
                        if (imageView != null) {
                            i11 = R.id.card_no;
                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.card_no);
                            if (talabatTextView4 != null) {
                                i11 = R.id.card_selector;
                                TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.card_selector);
                                if (talabatRadioButton != null) {
                                    i11 = R.id.main_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.main_container);
                                    if (linearLayout != null) {
                                        return new PayfortCardListItemBinding((CardView) view, talabatButton, talabatTextView, talabatTextView2, talabatTextView3, imageView, talabatTextView4, talabatRadioButton, linearLayout);
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
    public static PayfortCardListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PayfortCardListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.payfort_card_list_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
