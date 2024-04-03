package com.talabat.feature.pharmacy.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.pharmacy.presentation.R;

public final class ItemPrescriptionEstimatedArrivalBinding implements ViewBinding {
    @NonNull
    public final ImageView navigate;
    @NonNull
    public final TextView presEstimatedTime;
    @NonNull
    public final TextView presStatus;
    @NonNull
    public final ConstraintLayout prescriptionTrackingContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView timeIcon;

    private ItemPrescriptionEstimatedArrivalBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView2) {
        this.rootView = constraintLayout;
        this.navigate = imageView;
        this.presEstimatedTime = textView;
        this.presStatus = textView2;
        this.prescriptionTrackingContainer = constraintLayout2;
        this.timeIcon = imageView2;
    }

    @NonNull
    public static ItemPrescriptionEstimatedArrivalBinding bind(@NonNull View view) {
        int i11 = R.id.navigate;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.pres_estimated_time;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.pres_status;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R.id.time_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView2 != null) {
                        return new ItemPrescriptionEstimatedArrivalBinding(constraintLayout, imageView, textView, textView2, constraintLayout, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemPrescriptionEstimatedArrivalBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemPrescriptionEstimatedArrivalBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_prescription_estimated_arrival, viewGroup, false);
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
