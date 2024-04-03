package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ItemRecommendationHorizntalListBinding implements ViewBinding {
    @NonNull
    public final RecyclerView recyclerViewRecommendationRestaurants;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView swimlaneTitle;

    private ItemRecommendationHorizntalListBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.recyclerViewRecommendationRestaurants = recyclerView;
        this.swimlaneTitle = textView;
    }

    @NonNull
    public static ItemRecommendationHorizntalListBinding bind(@NonNull View view) {
        int i11 = R.id.recyclerView_recommendationRestaurants;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView_recommendationRestaurants);
        if (recyclerView != null) {
            i11 = R.id.swimlaneTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.swimlaneTitle);
            if (textView != null) {
                return new ItemRecommendationHorizntalListBinding((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemRecommendationHorizntalListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemRecommendationHorizntalListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_recommendation_horizntal_list, viewGroup, false);
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
