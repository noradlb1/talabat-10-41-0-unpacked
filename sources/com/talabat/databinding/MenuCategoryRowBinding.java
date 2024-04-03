package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class MenuCategoryRowBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView categoryTitle;
    @NonNull
    public final TalabatTextView itemsCount;
    @NonNull
    public final RelativeLayout parentRowView;
    @NonNull
    private final RelativeLayout rootView;

    private MenuCategoryRowBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.categoryTitle = talabatTextView;
        this.itemsCount = talabatTextView2;
        this.parentRowView = relativeLayout2;
    }

    @NonNull
    public static MenuCategoryRowBinding bind(@NonNull View view) {
        int i11 = R.id.category_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.category_title);
        if (talabatTextView != null) {
            i11 = R.id.items_count;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.items_count);
            if (talabatTextView2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new MenuCategoryRowBinding(relativeLayout, talabatTextView, talabatTextView2, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MenuCategoryRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MenuCategoryRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.menu_category_row, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
