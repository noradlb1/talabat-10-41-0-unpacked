package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class QuickfindrestaurantsItemBinding implements ViewBinding {
    @NonNull
    public final LinearLayout convertView;
    @NonNull
    public final ViewPreOrderLabelBinding layoutPreOrder;
    @NonNull
    public final NetworkImageView restaurantLogo;
    @NonNull
    public final TalabatTextView restaurantName;
    @NonNull
    private final LinearLayout rootView;

    private QuickfindrestaurantsItemBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ViewPreOrderLabelBinding viewPreOrderLabelBinding, @NonNull NetworkImageView networkImageView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = linearLayout;
        this.convertView = linearLayout2;
        this.layoutPreOrder = viewPreOrderLabelBinding;
        this.restaurantLogo = networkImageView;
        this.restaurantName = talabatTextView;
    }

    @NonNull
    public static QuickfindrestaurantsItemBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.layout_preOrder;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.layout_preOrder);
        if (findChildViewById != null) {
            ViewPreOrderLabelBinding bind = ViewPreOrderLabelBinding.bind(findChildViewById);
            i11 = R.id.restaurant_logo;
            NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view, R.id.restaurant_logo);
            if (networkImageView != null) {
                i11 = R.id.restaurant_name;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.restaurant_name);
                if (talabatTextView != null) {
                    return new QuickfindrestaurantsItemBinding(linearLayout, linearLayout, bind, networkImageView, talabatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static QuickfindrestaurantsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static QuickfindrestaurantsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.quickfindrestaurants_item, viewGroup, false);
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
