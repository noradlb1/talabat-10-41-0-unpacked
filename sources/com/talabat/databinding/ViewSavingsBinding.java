package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ViewSavingsBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView freeDeliveryMore;
    @NonNull
    public final TalabatTextView freeDeliverySavingsText;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout savingsView;

    private ViewSavingsBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.freeDeliveryMore = talabatTextView;
        this.freeDeliverySavingsText = talabatTextView2;
        this.savingsView = linearLayout2;
    }

    @NonNull
    public static ViewSavingsBinding bind(@NonNull View view) {
        int i11 = R.id.free_delivery_more;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_delivery_more);
        if (talabatTextView != null) {
            i11 = R.id.free_delivery_savings_text;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_delivery_savings_text);
            if (talabatTextView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new ViewSavingsBinding(linearLayout, talabatTextView, talabatTextView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewSavingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewSavingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_savings, viewGroup, false);
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
