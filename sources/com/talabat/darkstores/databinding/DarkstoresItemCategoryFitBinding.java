package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresItemCategoryFitBinding implements ViewBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView imageView;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView textView;

    private DarkstoresItemCategoryFitBinding(@NonNull CardView cardView2, @NonNull CardView cardView3, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.rootView = cardView2;
        this.cardView = cardView3;
        this.imageView = imageView2;
        this.textView = textView2;
    }

    @NonNull
    public static DarkstoresItemCategoryFitBinding bind(@NonNull View view) {
        CardView cardView2 = (CardView) view;
        int i11 = R.id.imageView;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView2 != null) {
            i11 = R.id.textView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                return new DarkstoresItemCategoryFitBinding(cardView2, cardView2, imageView2, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemCategoryFitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemCategoryFitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_category_fit, viewGroup, false);
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
