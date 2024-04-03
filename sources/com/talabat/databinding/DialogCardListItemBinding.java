package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;

public final class DialogCardListItemBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView cardExpiryDate;
    @NonNull
    public final TalabatTextView expiresInText;
    @NonNull
    public final LinearLayout expiryLayout;
    @NonNull
    public final ImageView itemIcon;
    @NonNull
    public final RelativeLayout itemLayout;
    @NonNull
    public final TalabatRadioButton itemRadio;
    @NonNull
    public final TalabatTextView itemTxt;
    @NonNull
    private final RelativeLayout rootView;

    private DialogCardListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatRadioButton talabatRadioButton, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = relativeLayout;
        this.cardExpiryDate = talabatTextView;
        this.expiresInText = talabatTextView2;
        this.expiryLayout = linearLayout;
        this.itemIcon = imageView;
        this.itemLayout = relativeLayout2;
        this.itemRadio = talabatRadioButton;
        this.itemTxt = talabatTextView3;
    }

    @NonNull
    public static DialogCardListItemBinding bind(@NonNull View view) {
        int i11 = R.id.card_expiry_date;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.card_expiry_date);
        if (talabatTextView != null) {
            i11 = R.id.expires_in_text;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.expires_in_text);
            if (talabatTextView2 != null) {
                i11 = R.id.expiry_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.expiry_layout);
                if (linearLayout != null) {
                    i11 = R.id.item_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.item_icon);
                    if (imageView != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i11 = R.id.item_radio;
                        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.item_radio);
                        if (talabatRadioButton != null) {
                            i11 = R.id.item_txt;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_txt);
                            if (talabatTextView3 != null) {
                                return new DialogCardListItemBinding(relativeLayout, talabatTextView, talabatTextView2, linearLayout, imageView, relativeLayout, talabatRadioButton, talabatTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DialogCardListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogCardListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.dialog_card_list_item, viewGroup, false);
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
