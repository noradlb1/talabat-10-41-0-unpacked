package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresItemProductCartOosPredictedExpirementBinding implements ViewBinding {
    @NonNull
    private final LinearLayoutCompat rootView;
    @NonNull
    public final TextView title;
    @NonNull
    public final AppCompatImageView warningImg;

    private DarkstoresItemProductCartOosPredictedExpirementBinding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView) {
        this.rootView = linearLayoutCompat;
        this.title = textView;
        this.warningImg = appCompatImageView;
    }

    @NonNull
    public static DarkstoresItemProductCartOosPredictedExpirementBinding bind(@NonNull View view) {
        int i11 = R.id.title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.warning_img;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageView != null) {
                return new DarkstoresItemProductCartOosPredictedExpirementBinding((LinearLayoutCompat) view, textView, appCompatImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemProductCartOosPredictedExpirementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemProductCartOosPredictedExpirementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_product_cart_oos_predicted_expirement, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }
}
