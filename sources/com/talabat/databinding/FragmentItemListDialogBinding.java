package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class FragmentItemListDialogBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView bottomSheetTitle;
    @NonNull
    public final ImageView closeCategories;
    @NonNull
    public final LinearLayout closeCategoriesView;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final RecyclerView list;
    @NonNull
    private final RelativeLayout rootView;

    private FragmentItemListDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.bottomSheetTitle = talabatTextView;
        this.closeCategories = imageView;
        this.closeCategoriesView = linearLayout;
        this.contentView = relativeLayout2;
        this.list = recyclerView;
    }

    @NonNull
    public static FragmentItemListDialogBinding bind(@NonNull View view) {
        int i11 = R.id.bottom_sheet_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.bottom_sheet_title);
        if (talabatTextView != null) {
            i11 = R.id.close_categories;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_categories);
            if (imageView != null) {
                i11 = R.id.close_categories_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.close_categories_view);
                if (linearLayout != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i11 = R.id.list;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.list);
                    if (recyclerView != null) {
                        return new FragmentItemListDialogBinding(relativeLayout, talabatTextView, imageView, linearLayout, relativeLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentItemListDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentItemListDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_item_list_dialog, viewGroup, false);
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
