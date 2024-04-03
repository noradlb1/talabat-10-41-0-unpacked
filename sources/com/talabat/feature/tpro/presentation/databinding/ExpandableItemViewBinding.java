package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ExpandableItemViewBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvPrimary;
    @NonNull
    public final TextView tvSecondary;
    @NonNull
    public final TextView tvSubtitle;

    private ExpandableItemViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.tvPrimary = textView;
        this.tvSecondary = textView2;
        this.tvSubtitle = textView3;
    }

    @NonNull
    public static ExpandableItemViewBinding bind(@NonNull View view) {
        int i11 = R.id.tv_primary;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.tv_secondary;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.tv_subtitle;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    return new ExpandableItemViewBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ExpandableItemViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ExpandableItemViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.expandable_item_view, viewGroup, false);
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
