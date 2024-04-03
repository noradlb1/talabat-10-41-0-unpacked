package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.homescreen.widget.AspectRatioCardView;
import com.talabat.homescreen.widget.HomeActionLayout;

public final class PreviousOrderListItemBinding implements ViewBinding {
    @NonNull
    public final TextView previousFirstItem;
    @NonNull
    public final TextView previousMoreItem;
    @NonNull
    public final TextView previousPrice;
    @NonNull
    public final HomeActionLayout previousReorder;
    @NonNull
    private final AspectRatioCardView rootView;

    private PreviousOrderListItemBinding(@NonNull AspectRatioCardView aspectRatioCardView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull HomeActionLayout homeActionLayout) {
        this.rootView = aspectRatioCardView;
        this.previousFirstItem = textView;
        this.previousMoreItem = textView2;
        this.previousPrice = textView3;
        this.previousReorder = homeActionLayout;
    }

    @NonNull
    public static PreviousOrderListItemBinding bind(@NonNull View view) {
        int i11 = R.id.previous_first_item;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.previous_first_item);
        if (textView != null) {
            i11 = R.id.previous_more_item;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.previous_more_item);
            if (textView2 != null) {
                i11 = R.id.previous_price;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.previous_price);
                if (textView3 != null) {
                    i11 = R.id.previous_reorder;
                    HomeActionLayout homeActionLayout = (HomeActionLayout) ViewBindings.findChildViewById(view, R.id.previous_reorder);
                    if (homeActionLayout != null) {
                        return new PreviousOrderListItemBinding((AspectRatioCardView) view, textView, textView2, textView3, homeActionLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PreviousOrderListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PreviousOrderListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.previous_order_list_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public AspectRatioCardView getRoot() {
        return this.rootView;
    }
}
