package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresItemHomeSearchViewBinding implements ViewBinding {
    @NonNull
    public final LinearLayout headerTitleSearch;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout searchBottomView;

    private DarkstoresItemHomeSearchViewBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.headerTitleSearch = linearLayout2;
        this.searchBottomView = linearLayout3;
    }

    @NonNull
    public static DarkstoresItemHomeSearchViewBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.search_bottom_view;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout2 != null) {
            return new DarkstoresItemHomeSearchViewBinding(linearLayout, linearLayout, linearLayout2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeSearchViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeSearchViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_search_view, viewGroup, false);
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
