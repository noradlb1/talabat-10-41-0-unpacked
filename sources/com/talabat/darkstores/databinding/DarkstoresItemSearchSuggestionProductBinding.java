package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ProductItemView;

public final class DarkstoresItemSearchSuggestionProductBinding implements ViewBinding {
    @NonNull
    public final ProductItemView productItemView;
    @NonNull
    private final ProductItemView rootView;

    private DarkstoresItemSearchSuggestionProductBinding(@NonNull ProductItemView productItemView2, @NonNull ProductItemView productItemView3) {
        this.rootView = productItemView2;
        this.productItemView = productItemView3;
    }

    @NonNull
    public static DarkstoresItemSearchSuggestionProductBinding bind(@NonNull View view) {
        if (view != null) {
            ProductItemView productItemView2 = (ProductItemView) view;
            return new DarkstoresItemSearchSuggestionProductBinding(productItemView2, productItemView2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSearchSuggestionProductBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSearchSuggestionProductBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_search_suggestion_product, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ProductItemView getRoot() {
        return this.rootView;
    }
}
