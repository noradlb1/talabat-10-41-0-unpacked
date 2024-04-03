package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class CardListDialogBinding implements ViewBinding {
    @NonNull
    public final ImageView closePopupButton;
    @NonNull
    public final TalabatFillButton confirm;
    @NonNull
    public final TalabatTextView headerPayWithString;
    @NonNull
    public final RecyclerView itemsRecyclerView;
    @NonNull
    private final LinearLayout rootView;

    private CardListDialogBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.closePopupButton = imageView;
        this.confirm = talabatFillButton;
        this.headerPayWithString = talabatTextView;
        this.itemsRecyclerView = recyclerView;
    }

    @NonNull
    public static CardListDialogBinding bind(@NonNull View view) {
        int i11 = R.id.close_popup_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_popup_button);
        if (imageView != null) {
            i11 = R.id.confirm;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.confirm);
            if (talabatFillButton != null) {
                i11 = R.id.header_pay_with_string;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.header_pay_with_string);
                if (talabatTextView != null) {
                    i11 = R.id.items_recyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.items_recyclerView);
                    if (recyclerView != null) {
                        return new CardListDialogBinding((LinearLayout) view, imageView, talabatFillButton, talabatTextView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CardListDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CardListDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.card_list_dialog, viewGroup, false);
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
