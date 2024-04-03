package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.product.views.ProductExtendedInfoView;

public final class BottomProductExtendedInfoViewBinding implements ViewBinding {
    @NonNull
    public final ProductExtendedInfoView productExtendedInfo;
    @NonNull
    private final View rootView;

    private BottomProductExtendedInfoViewBinding(@NonNull View view, @NonNull ProductExtendedInfoView productExtendedInfoView) {
        this.rootView = view;
        this.productExtendedInfo = productExtendedInfoView;
    }

    @NonNull
    public static BottomProductExtendedInfoViewBinding bind(@NonNull View view) {
        int i11 = R.id.productExtendedInfo;
        ProductExtendedInfoView productExtendedInfoView = (ProductExtendedInfoView) ViewBindings.findChildViewById(view, i11);
        if (productExtendedInfoView != null) {
            return new BottomProductExtendedInfoViewBinding(view, productExtendedInfoView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BottomProductExtendedInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.bottom_product_extended_info_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
