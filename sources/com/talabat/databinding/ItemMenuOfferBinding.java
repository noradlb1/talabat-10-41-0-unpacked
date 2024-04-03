package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemMenuOfferBinding implements ViewBinding {
    @NonNull
    public final ImageView civItemImage;
    @NonNull
    public final FrameLayout flImage;
    @NonNull
    public final LinearLayout llContainer;
    @NonNull
    public final ProgressBar progress;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvDesc;
    @NonNull
    public final TalabatTextView tvItemName;
    @NonNull
    public final TalabatTextView tvSelect;

    private ItemMenuOfferBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = cardView;
        this.civItemImage = imageView;
        this.flImage = frameLayout;
        this.llContainer = linearLayout;
        this.progress = progressBar;
        this.tvDesc = textView;
        this.tvItemName = talabatTextView;
        this.tvSelect = talabatTextView2;
    }

    @NonNull
    public static ItemMenuOfferBinding bind(@NonNull View view) {
        int i11 = R.id.civ_item_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.civ_item_image);
        if (imageView != null) {
            i11 = R.id.fl_image;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.fl_image);
            if (frameLayout != null) {
                i11 = R.id.ll_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_container);
                if (linearLayout != null) {
                    i11 = R.id.progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress);
                    if (progressBar != null) {
                        i11 = R.id.tv_desc;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_desc);
                        if (textView != null) {
                            i11 = R.id.tv_item_name;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_item_name);
                            if (talabatTextView != null) {
                                i11 = R.id.tv_select;
                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_select);
                                if (talabatTextView2 != null) {
                                    return new ItemMenuOfferBinding((CardView) view, imageView, frameLayout, linearLayout, progressBar, textView, talabatTextView, talabatTextView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemMenuOfferBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemMenuOfferBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_menu_offer, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
