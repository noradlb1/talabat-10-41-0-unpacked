package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresItemCategoryTileAllNewBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout categoryImgContainer;
    @NonNull
    public final ImageView imageView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textView;

    private DarkstoresItemCategoryTileAllNewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.categoryImgContainer = relativeLayout;
        this.imageView = imageView2;
        this.textView = textView2;
    }

    @NonNull
    public static DarkstoresItemCategoryTileAllNewBinding bind(@NonNull View view) {
        int i11 = R.id.category_img_container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
        if (relativeLayout != null) {
            i11 = R.id.imageView;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.textView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new DarkstoresItemCategoryTileAllNewBinding((ConstraintLayout) view, relativeLayout, imageView2, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemCategoryTileAllNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemCategoryTileAllNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_category_tile_all_new, viewGroup, false);
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
