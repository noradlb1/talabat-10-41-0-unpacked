package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewQpayAddCardDeflectionBinding implements ViewBinding {
    @NonNull
    public final TextView benefitDeflectionHeader;
    @NonNull
    public final TextView benefitDeflectionInfo1;
    @NonNull
    public final TextView qpayDeflectionInfo2;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewQpayAddCardDeflectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.benefitDeflectionHeader = textView;
        this.benefitDeflectionInfo1 = textView2;
        this.qpayDeflectionInfo2 = textView3;
    }

    @NonNull
    public static ViewQpayAddCardDeflectionBinding bind(@NonNull View view) {
        int i11 = R.id.benefit_deflection_header;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.benefit_deflection_header);
        if (textView != null) {
            i11 = R.id.benefit_deflection_info1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.benefit_deflection_info1);
            if (textView2 != null) {
                i11 = R.id.qpay_deflection_info2;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qpay_deflection_info2);
                if (textView3 != null) {
                    return new ViewQpayAddCardDeflectionBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewQpayAddCardDeflectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewQpayAddCardDeflectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_qpay_add_card_deflection, viewGroup, false);
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
