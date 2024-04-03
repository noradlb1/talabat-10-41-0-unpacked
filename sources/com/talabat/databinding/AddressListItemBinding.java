package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class AddressListItemBinding implements ViewBinding {
    @NonNull
    public final LinearLayout addressLayoutView;
    @NonNull
    public final LinearLayout addressListDeleteView;
    @NonNull
    public final LinearLayout addressListEditView;
    @NonNull
    public final TalabatTextView outOfDelivery;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView txtAdditionalDirections;
    @NonNull
    public final TalabatTextView txtAddresMobile;
    @NonNull
    public final TalabatTextView txtAddresPhone;
    @NonNull
    public final TalabatTextView txtAddressAreaname;
    @NonNull
    public final TalabatTextView txtAddressDescription;
    @NonNull
    public final TalabatTextView txtAddressProfileName;

    private AddressListItemBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7) {
        this.rootView = cardView;
        this.addressLayoutView = linearLayout;
        this.addressListDeleteView = linearLayout2;
        this.addressListEditView = linearLayout3;
        this.outOfDelivery = talabatTextView;
        this.txtAdditionalDirections = talabatTextView2;
        this.txtAddresMobile = talabatTextView3;
        this.txtAddresPhone = talabatTextView4;
        this.txtAddressAreaname = talabatTextView5;
        this.txtAddressDescription = talabatTextView6;
        this.txtAddressProfileName = talabatTextView7;
    }

    @NonNull
    public static AddressListItemBinding bind(@NonNull View view) {
        int i11 = R.id.address_layout_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.address_layout_view);
        if (linearLayout != null) {
            i11 = R.id.address_list_delete_view;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.address_list_delete_view);
            if (linearLayout2 != null) {
                i11 = R.id.address_list_edit_view;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.address_list_edit_view);
                if (linearLayout3 != null) {
                    i11 = R.id.out_of_delivery;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.out_of_delivery);
                    if (talabatTextView != null) {
                        i11 = R.id.txtAdditionalDirections;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAdditionalDirections);
                        if (talabatTextView2 != null) {
                            i11 = R.id.txtAddresMobile;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAddresMobile);
                            if (talabatTextView3 != null) {
                                i11 = R.id.txtAddresPhone;
                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAddresPhone);
                                if (talabatTextView4 != null) {
                                    i11 = R.id.txtAddressAreaname;
                                    TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAddressAreaname);
                                    if (talabatTextView5 != null) {
                                        i11 = R.id.txtAddressDescription;
                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAddressDescription);
                                        if (talabatTextView6 != null) {
                                            i11 = R.id.txtAddressProfileName;
                                            TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtAddressProfileName);
                                            if (talabatTextView7 != null) {
                                                return new AddressListItemBinding((CardView) view, linearLayout, linearLayout2, linearLayout3, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5, talabatTextView6, talabatTextView7);
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
    public static AddressListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AddressListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.address_list_item, viewGroup, false);
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
