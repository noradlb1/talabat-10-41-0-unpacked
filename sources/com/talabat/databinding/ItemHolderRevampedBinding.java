package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemHolderRevampedBinding implements ViewBinding {
    @NonNull
    public final MaterialCardView cardSection;
    @NonNull
    public final Flow flow;
    @NonNull
    public final RecyclerView recyclerViewChoices;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout rowParentContainer;
    @NonNull
    public final TalabatTextView sectionName;
    @NonNull
    public final TalabatTextView tvSelectionCriteria;

    private ItemHolderRevampedBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialCardView materialCardView, @NonNull Flow flow2, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = linearLayout;
        this.cardSection = materialCardView;
        this.flow = flow2;
        this.recyclerViewChoices = recyclerView;
        this.rowParentContainer = linearLayout2;
        this.sectionName = talabatTextView;
        this.tvSelectionCriteria = talabatTextView2;
    }

    @NonNull
    public static ItemHolderRevampedBinding bind(@NonNull View view) {
        int i11 = R.id.card_section;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.card_section);
        if (materialCardView != null) {
            i11 = R.id.flow;
            Flow flow2 = (Flow) ViewBindings.findChildViewById(view, R.id.flow);
            if (flow2 != null) {
                i11 = R.id.recyclerView_choices;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView_choices);
                if (recyclerView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i11 = R.id.sectionName;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.sectionName);
                    if (talabatTextView != null) {
                        i11 = R.id.tv_selection_criteria;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_selection_criteria);
                        if (talabatTextView2 != null) {
                            return new ItemHolderRevampedBinding(linearLayout, materialCardView, flow2, recyclerView, linearLayout, talabatTextView, talabatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemHolderRevampedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemHolderRevampedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_holder_revamped, viewGroup, false);
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
