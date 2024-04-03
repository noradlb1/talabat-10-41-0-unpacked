package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class RestaurantlistheaderBinding implements ViewBinding {
    @NonNull
    public final ImageButton cardViewBtn;
    @NonNull
    public final ImageButton listViewBtn;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView title;
    @NonNull
    public final LinearLayout toggleContainer;

    private RestaurantlistheaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull TextView textView, @NonNull LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.cardViewBtn = imageButton;
        this.listViewBtn = imageButton2;
        this.title = textView;
        this.toggleContainer = linearLayout;
    }

    @NonNull
    public static RestaurantlistheaderBinding bind(@NonNull View view) {
        int i11 = R.id.cardViewBtn;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.cardViewBtn);
        if (imageButton != null) {
            i11 = R.id.listViewBtn;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.listViewBtn);
            if (imageButton2 != null) {
                i11 = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                if (textView != null) {
                    i11 = R.id.toggleContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.toggleContainer);
                    if (linearLayout != null) {
                        return new RestaurantlistheaderBinding((ConstraintLayout) view, imageButton, imageButton2, textView, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RestaurantlistheaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RestaurantlistheaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.restaurantlistheader, viewGroup, false);
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
