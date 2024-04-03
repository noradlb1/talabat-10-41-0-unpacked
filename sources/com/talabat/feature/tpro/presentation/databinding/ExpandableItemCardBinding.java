package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ExpandableItemCardBinding implements ViewBinding {
    @NonNull
    public final LinearLayout containerSeeHow;
    @NonNull
    public final RecyclerView expandableListItems;
    @NonNull
    public final ImageView ivSeeHow;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvCardContent;
    @NonNull
    public final TextView tvCardHeader;
    @NonNull
    public final TextView tvCardHeaderName;
    @NonNull
    public final TextView tvCardSeeHow;

    private ExpandableItemCardBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = cardView;
        this.containerSeeHow = linearLayout;
        this.expandableListItems = recyclerView;
        this.ivSeeHow = imageView;
        this.tvCardContent = textView;
        this.tvCardHeader = textView2;
        this.tvCardHeaderName = textView3;
        this.tvCardSeeHow = textView4;
    }

    @NonNull
    public static ExpandableItemCardBinding bind(@NonNull View view) {
        int i11 = R.id.container_see_how;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.expandable_list_items;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                i11 = R.id.iv_see_how;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.tv_card_content;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tv_card_header;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.tv_card_header_name;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                i11 = R.id.tv_card_see_how;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView4 != null) {
                                    return new ExpandableItemCardBinding((CardView) view, linearLayout, recyclerView, imageView, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ExpandableItemCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ExpandableItemCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.expandable_item_card, viewGroup, false);
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
