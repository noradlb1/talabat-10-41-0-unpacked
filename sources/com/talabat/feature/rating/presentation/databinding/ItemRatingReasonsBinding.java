package com.talabat.feature.rating.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.rating.presentation.R;

public final class ItemRatingReasonsBinding implements ViewBinding {
    @NonNull
    public final TextView chipView;
    @NonNull
    private final ConstraintLayout rootView;

    private ItemRatingReasonsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.chipView = textView;
    }

    @NonNull
    public static ItemRatingReasonsBinding bind(@NonNull View view) {
        int i11 = R.id.chipView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            return new ItemRatingReasonsBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemRatingReasonsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemRatingReasonsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_rating_reasons, viewGroup, false);
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
