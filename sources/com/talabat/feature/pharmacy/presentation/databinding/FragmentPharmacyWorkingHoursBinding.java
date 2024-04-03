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

public final class FragmentPharmacyWorkingHoursBinding implements ViewBinding {
    @NonNull
    public final ImageView imgWorkingHours;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView txtWorkingHours;
    @NonNull
    public final TextView txtWorkingHoursDescription;

    private FragmentPharmacyWorkingHoursBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.imgWorkingHours = imageView;
        this.txtWorkingHours = textView;
        this.txtWorkingHoursDescription = textView2;
    }

    @NonNull
    public static FragmentPharmacyWorkingHoursBinding bind(@NonNull View view) {
        int i11 = R.id.img_working_hours;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.txt_working_hours;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.txt_working_hours_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new FragmentPharmacyWorkingHoursBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentPharmacyWorkingHoursBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentPharmacyWorkingHoursBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pharmacy_working_hours, viewGroup, false);
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
