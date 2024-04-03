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
import com.talabat.TalabatTextView;

public final class SavedAddressListItemBinding implements ViewBinding {
    @NonNull
    public final LinearLayout addressContainer;
    @NonNull
    public final TalabatTextView addressTitle;
    @NonNull
    public final RelativeLayout container;
    @NonNull
    public final ImageView itemImg;
    @NonNull
    public final TalabatTextView outOfDelivery;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView selectedAddTick;
    @NonNull
    public final TalabatTextView txtAddressDescription;

    private SavedAddressListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = relativeLayout;
        this.addressContainer = linearLayout;
        this.addressTitle = talabatTextView;
        this.container = relativeLayout2;
        this.itemImg = imageView;
        this.outOfDelivery = talabatTextView2;
        this.selectedAddTick = imageView2;
        this.txtAddressDescription = talabatTextView3;
    }

    @NonNull
    public static SavedAddressListItemBinding bind(@NonNull View view) {
        int i11 = R.id.address_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.address_container);
        if (linearLayout != null) {
            i11 = R.id.address_title;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.address_title);
            if (talabatTextView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i11 = R.id.item_img;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.item_img);
                if (imageView != null) {
                    i11 = R.id.out_of_delivery;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.out_of_delivery);
                    if (talabatTextView2 != null) {
                        i11 = R.id.selected_add_tick;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.selected_add_tick);
                        if (imageView2 != null) {
                            i11 = R.id.txtAddressDescription;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAddressDescription);
                            if (talabatTextView3 != null) {
                                return new SavedAddressListItemBinding(relativeLayout, linearLayout, talabatTextView, relativeLayout, imageView, talabatTextView2, imageView2, talabatTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SavedAddressListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SavedAddressListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.saved_address_list_item, viewGroup, false);
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
