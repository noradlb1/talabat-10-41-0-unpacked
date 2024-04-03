package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_selection_indicator.DSSelectionIndicator;
import com.talabat.talabatcommon.R;

public final class TabItemWithTagBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final DSSelectionIndicator tabSelectionIndicator;
    @NonNull
    public final TextView tabText;
    @NonNull
    public final CardView tagContainer;
    @NonNull
    public final ImageView tagIv;
    @NonNull
    public final TextView tagTv;

    private TabItemWithTagBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSSelectionIndicator dSSelectionIndicator, @NonNull TextView textView, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.tabSelectionIndicator = dSSelectionIndicator;
        this.tabText = textView;
        this.tagContainer = cardView;
        this.tagIv = imageView;
        this.tagTv = textView2;
    }

    @NonNull
    public static TabItemWithTagBinding bind(@NonNull View view) {
        int i11 = R.id.tabSelectionIndicator;
        DSSelectionIndicator dSSelectionIndicator = (DSSelectionIndicator) ViewBindings.findChildViewById(view, i11);
        if (dSSelectionIndicator != null) {
            i11 = R.id.tabText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tagContainer;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
                if (cardView != null) {
                    i11 = R.id.tagIv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.tagTv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            return new TabItemWithTagBinding((ConstraintLayout) view, dSSelectionIndicator, textView, cardView, imageView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TabItemWithTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TabItemWithTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.tab_item_with_tag, viewGroup, false);
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
