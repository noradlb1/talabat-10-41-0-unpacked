package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class FreeItemBinding implements ViewBinding {
    @NonNull
    public final ImageView imageNotAvailable;
    @NonNull
    public final TalabatTextView itemDescription;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final NetworkImageView menuImage;
    @NonNull
    public final RelativeLayout menuItemImageHolder;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final RelativeLayout rootView;

    private FreeItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull NetworkImageView networkImageView, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar2) {
        this.rootView = relativeLayout;
        this.imageNotAvailable = imageView;
        this.itemDescription = talabatTextView;
        this.itemName = talabatTextView2;
        this.menuImage = networkImageView;
        this.menuItemImageHolder = relativeLayout2;
        this.progressBar = progressBar2;
    }

    @NonNull
    public static FreeItemBinding bind(@NonNull View view) {
        int i11 = R.id.image_not_available;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.image_not_available);
        if (imageView != null) {
            i11 = R.id.item_description;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_description);
            if (talabatTextView != null) {
                i11 = R.id.item_name;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_name);
                if (talabatTextView2 != null) {
                    i11 = R.id.menu_image;
                    NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view, R.id.menu_image);
                    if (networkImageView != null) {
                        i11 = R.id.menu_item_image_holder;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.menu_item_image_holder);
                        if (relativeLayout != null) {
                            i11 = R.id.progressBar;
                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                            if (progressBar2 != null) {
                                return new FreeItemBinding((RelativeLayout) view, imageView, talabatTextView, talabatTextView2, networkImageView, relativeLayout, progressBar2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FreeItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FreeItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.free_item, viewGroup, false);
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
