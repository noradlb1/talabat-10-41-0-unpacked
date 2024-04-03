package com.talabat.databinding;

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
import com.talabat.R;

public final class ItemRestuarantListQuickFilterBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewIcon;
    @NonNull
    public final CardView linearLayoutContainer;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView textViewName;

    private ItemRestuarantListQuickFilterBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull CardView cardView2, @NonNull TextView textView) {
        this.rootView = cardView;
        this.imageViewIcon = imageView;
        this.linearLayoutContainer = cardView2;
        this.textViewName = textView;
    }

    @NonNull
    public static ItemRestuarantListQuickFilterBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_icon);
        if (imageView != null) {
            CardView cardView = (CardView) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_name);
            if (textView != null) {
                return new ItemRestuarantListQuickFilterBinding(cardView, imageView, cardView, textView);
            }
            i11 = R.id.textView_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemRestuarantListQuickFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemRestuarantListQuickFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_restuarant_list_quick_filter, viewGroup, false);
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
