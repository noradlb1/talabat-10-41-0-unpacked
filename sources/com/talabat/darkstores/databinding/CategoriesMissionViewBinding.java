package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.categories.CategoriesMissionItemView;

public final class CategoriesMissionViewBinding implements ViewBinding {
    @NonNull
    public final CategoriesMissionItemView firstCategoryMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final CategoriesMissionItemView secondCategoryMission;

    private CategoriesMissionViewBinding(@NonNull View view, @NonNull CategoriesMissionItemView categoriesMissionItemView, @NonNull CategoriesMissionItemView categoriesMissionItemView2) {
        this.rootView = view;
        this.firstCategoryMission = categoriesMissionItemView;
        this.secondCategoryMission = categoriesMissionItemView2;
    }

    @NonNull
    public static CategoriesMissionViewBinding bind(@NonNull View view) {
        int i11 = R.id.firstCategoryMission;
        CategoriesMissionItemView categoriesMissionItemView = (CategoriesMissionItemView) ViewBindings.findChildViewById(view, i11);
        if (categoriesMissionItemView != null) {
            i11 = R.id.secondCategoryMission;
            CategoriesMissionItemView categoriesMissionItemView2 = (CategoriesMissionItemView) ViewBindings.findChildViewById(view, i11);
            if (categoriesMissionItemView2 != null) {
                return new CategoriesMissionViewBinding(view, categoriesMissionItemView, categoriesMissionItemView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CategoriesMissionViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.categories_mission_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
