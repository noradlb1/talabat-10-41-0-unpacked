package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class TproVendorMovBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout layMov;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView tvMov;

    private TproVendorMovBinding(@NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.rootView = view;
        this.layMov = constraintLayout;
        this.tvMov = textView;
    }

    @NonNull
    public static TproVendorMovBinding bind(@NonNull View view) {
        int i11 = R.id.lay_mov;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.tv_mov;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new TproVendorMovBinding(view, constraintLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TproVendorMovBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tpro_vendor_mov, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
