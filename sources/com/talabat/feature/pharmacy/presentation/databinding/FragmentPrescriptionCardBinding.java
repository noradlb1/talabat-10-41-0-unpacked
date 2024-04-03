package com.talabat.feature.pharmacy.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.pharmacy.presentation.R;

public final class FragmentPrescriptionCardBinding implements ViewBinding {
    @NonNull
    public final ItemPrescriptionCardBinding prescriptionCard;
    @NonNull
    public final ItemPrescriptionCardV2Binding prescriptionCardV2;
    @NonNull
    public final ItemPrescriptionEstimatedArrivalBinding prescriptionTrackingCard;
    @NonNull
    private final FrameLayout rootView;

    private FragmentPrescriptionCardBinding(@NonNull FrameLayout frameLayout, @NonNull ItemPrescriptionCardBinding itemPrescriptionCardBinding, @NonNull ItemPrescriptionCardV2Binding itemPrescriptionCardV2Binding, @NonNull ItemPrescriptionEstimatedArrivalBinding itemPrescriptionEstimatedArrivalBinding) {
        this.rootView = frameLayout;
        this.prescriptionCard = itemPrescriptionCardBinding;
        this.prescriptionCardV2 = itemPrescriptionCardV2Binding;
        this.prescriptionTrackingCard = itemPrescriptionEstimatedArrivalBinding;
    }

    @NonNull
    public static FragmentPrescriptionCardBinding bind(@NonNull View view) {
        int i11 = R.id.prescription_card;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            ItemPrescriptionCardBinding bind = ItemPrescriptionCardBinding.bind(findChildViewById);
            int i12 = R.id.prescription_card_v2;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i12);
            if (findChildViewById2 != null) {
                ItemPrescriptionCardV2Binding bind2 = ItemPrescriptionCardV2Binding.bind(findChildViewById2);
                int i13 = R.id.prescription_tracking_card;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i13);
                if (findChildViewById3 != null) {
                    return new FragmentPrescriptionCardBinding((FrameLayout) view, bind, bind2, ItemPrescriptionEstimatedArrivalBinding.bind(findChildViewById3));
                }
                i11 = i13;
            } else {
                i11 = i12;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentPrescriptionCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentPrescriptionCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_prescription_card, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
