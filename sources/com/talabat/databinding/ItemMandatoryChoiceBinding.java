package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemMandatoryChoiceBinding implements ViewBinding {
    @NonNull
    public final ImageView imageArrow;
    @NonNull
    public final LinearLayout linearLayoutHeaderContainer;
    @NonNull
    public final RecyclerView recyclerViewRequiredChoices;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView sectionName;
    @NonNull
    public final TalabatTextView textCategoryHint;
    @NonNull
    public final TalabatTextView tvSelectionCriteria;

    private ItemMandatoryChoiceBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = linearLayout;
        this.imageArrow = imageView;
        this.linearLayoutHeaderContainer = linearLayout2;
        this.recyclerViewRequiredChoices = recyclerView;
        this.sectionName = talabatTextView;
        this.textCategoryHint = talabatTextView2;
        this.tvSelectionCriteria = talabatTextView3;
    }

    @NonNull
    public static ItemMandatoryChoiceBinding bind(@NonNull View view) {
        int i11 = R.id.image_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.image_arrow);
        if (imageView != null) {
            i11 = R.id.linearLayout_headerContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout_headerContainer);
            if (linearLayout != null) {
                i11 = R.id.recyclerView_requiredChoices;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView_requiredChoices);
                if (recyclerView != null) {
                    i11 = R.id.sectionName;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.sectionName);
                    if (talabatTextView != null) {
                        i11 = R.id.text_categoryHint;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.text_categoryHint);
                        if (talabatTextView2 != null) {
                            i11 = R.id.tv_selection_criteria;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_selection_criteria);
                            if (talabatTextView3 != null) {
                                return new ItemMandatoryChoiceBinding((LinearLayout) view, imageView, linearLayout, recyclerView, talabatTextView, talabatTextView2, talabatTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemMandatoryChoiceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemMandatoryChoiceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_mandatory_choice, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
