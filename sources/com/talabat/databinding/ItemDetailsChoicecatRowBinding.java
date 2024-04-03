package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemDetailsChoicecatRowBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout choiceLayout;
    @NonNull
    public final ImageView itemDetailsRightArrow;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView tvItemdetailCategoryName;
    @NonNull
    public final TalabatTextView tvSelectedChoices;

    private ItemDetailsChoicecatRowBinding(@NonNull CardView cardView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = cardView;
        this.choiceLayout = relativeLayout;
        this.itemDetailsRightArrow = imageView;
        this.tvItemdetailCategoryName = talabatTextView;
        this.tvSelectedChoices = talabatTextView2;
    }

    @NonNull
    public static ItemDetailsChoicecatRowBinding bind(@NonNull View view) {
        int i11 = R.id.choice_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.choice_layout);
        if (relativeLayout != null) {
            i11 = R.id.item_details_right_arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.item_details_right_arrow);
            if (imageView != null) {
                i11 = R.id.tv_itemdetail_category_name;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_itemdetail_category_name);
                if (talabatTextView != null) {
                    i11 = R.id.tv_selected_choices;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_selected_choices);
                    if (talabatTextView2 != null) {
                        return new ItemDetailsChoicecatRowBinding((CardView) view, relativeLayout, imageView, talabatTextView, talabatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemDetailsChoicecatRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemDetailsChoicecatRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_details_choicecat_row, viewGroup, false);
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
