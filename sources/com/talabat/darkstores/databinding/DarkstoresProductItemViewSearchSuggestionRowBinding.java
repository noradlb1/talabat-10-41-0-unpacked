package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ItemsCounter;

public final class DarkstoresProductItemViewSearchSuggestionRowBinding implements ViewBinding {
    @NonNull
    public final ItemsCounter counter;
    @NonNull
    public final ImageView image;
    @NonNull
    public final FrameLayout imageContainerFrameLayout;
    @NonNull
    public final TextView productAgeRestriction;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvOfferBadge;
    @NonNull
    public final TextView tvPreviousPrice;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final TextView tvTitle;

    private DarkstoresProductItemViewSearchSuggestionRowBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ItemsCounter itemsCounter, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.rootView = constraintLayout;
        this.counter = itemsCounter;
        this.image = imageView;
        this.imageContainerFrameLayout = frameLayout;
        this.productAgeRestriction = textView;
        this.tvOfferBadge = textView2;
        this.tvPreviousPrice = textView3;
        this.tvPrice = textView4;
        this.tvTitle = textView5;
    }

    @NonNull
    public static DarkstoresProductItemViewSearchSuggestionRowBinding bind(@NonNull View view) {
        int i11 = R.id.counter;
        ItemsCounter itemsCounter = (ItemsCounter) ViewBindings.findChildViewById(view, i11);
        if (itemsCounter != null) {
            i11 = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.imageContainerFrameLayout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
                if (frameLayout != null) {
                    i11 = R.id.product_age_restriction;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tvOfferBadge;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.tvPreviousPrice;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                i11 = R.id.tvPrice;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView4 != null) {
                                    i11 = R.id.tvTitle;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView5 != null) {
                                        return new DarkstoresProductItemViewSearchSuggestionRowBinding((ConstraintLayout) view, itemsCounter, imageView, frameLayout, textView, textView2, textView3, textView4, textView5);
                                    }
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
    public static DarkstoresProductItemViewSearchSuggestionRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresProductItemViewSearchSuggestionRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_product_item_view_search_suggestion_row, viewGroup, false);
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
