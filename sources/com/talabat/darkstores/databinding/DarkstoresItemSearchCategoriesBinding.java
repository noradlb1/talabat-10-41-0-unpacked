package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemSearchCategoriesBinding implements ViewBinding {
    @NonNull
    private final RecyclerView rootView;
    @NonNull
    public final RecyclerView searchCategories;

    private DarkstoresItemSearchCategoriesBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.searchCategories = recyclerView2;
    }

    @NonNull
    public static DarkstoresItemSearchCategoriesBinding bind(@NonNull View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new DarkstoresItemSearchCategoriesBinding(recyclerView, recyclerView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSearchCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSearchCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_search_categories, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RecyclerView getRoot() {
        return this.rootView;
    }
}
