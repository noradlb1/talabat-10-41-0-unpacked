package com.talabat.feature.pharmacy.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.pharmacy.presentation.R;

public final class ItemPrescriptionCardBinding implements ViewBinding {
    @NonNull
    public final TextView btnPrescription;
    @NonNull
    public final LinearLayoutCompat deliveryContainer;
    @NonNull
    public final TextView deliveryFeeAndTime;
    @NonNull
    public final TextView deliveryWorkingHours;
    @NonNull
    public final TextView presDescription;
    @NonNull
    public final ImageView presVendorImage;
    @NonNull
    public final CardView presVendorImageCont;
    @NonNull
    public final ImageView presVendorLogo;
    @NonNull
    public final ConstraintLayout prescriptionCardContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final LinearLayoutCompat timeContainer;
    @NonNull
    public final TextView title;

    private ItemPrescriptionCardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView, @NonNull CardView cardView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull TextView textView5) {
        this.rootView = constraintLayout;
        this.btnPrescription = textView;
        this.deliveryContainer = linearLayoutCompat;
        this.deliveryFeeAndTime = textView2;
        this.deliveryWorkingHours = textView3;
        this.presDescription = textView4;
        this.presVendorImage = imageView;
        this.presVendorImageCont = cardView;
        this.presVendorLogo = imageView2;
        this.prescriptionCardContainer = constraintLayout2;
        this.timeContainer = linearLayoutCompat2;
        this.title = textView5;
    }

    @NonNull
    public static ItemPrescriptionCardBinding bind(@NonNull View view) {
        int i11 = R.id.btn_prescription;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.delivery_container;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R.id.delivery_fee_and_time;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.delivery_working_hours;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.pres_description;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView4 != null) {
                            i11 = R.id.pres_vendor_image;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView != null) {
                                i11 = R.id.pres_vendor_image_cont;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
                                if (cardView != null) {
                                    i11 = R.id.pres_vendorLogo;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                    if (imageView2 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i11 = R.id.time_container;
                                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i11);
                                        if (linearLayoutCompat2 != null) {
                                            i11 = R.id.title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView5 != null) {
                                                return new ItemPrescriptionCardBinding(constraintLayout, textView, linearLayoutCompat, textView2, textView3, textView4, imageView, cardView, imageView2, constraintLayout, linearLayoutCompat2, textView5);
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
    public static ItemPrescriptionCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemPrescriptionCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_prescription_card, viewGroup, false);
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
