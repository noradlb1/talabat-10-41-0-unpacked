package com.talabat.growth.databinding;

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
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.talabat.growth.R;

public final class FragLoyaltyFaqBinding implements ViewBinding {
    @NonNull
    public final RecyclerView faqRecyclerView;
    @NonNull
    public final DSNavigationBar getHelpListDSNavigationBar;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView titleViewMoreTitleTextView;

    private FragLoyaltyFaqBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull DSNavigationBar dSNavigationBar, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.faqRecyclerView = recyclerView;
        this.getHelpListDSNavigationBar = dSNavigationBar;
        this.titleViewMoreTitleTextView = textView;
    }

    @NonNull
    public static FragLoyaltyFaqBinding bind(@NonNull View view) {
        int i11 = R.id.faqRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.getHelpListDSNavigationBar;
            DSNavigationBar dSNavigationBar = (DSNavigationBar) ViewBindings.findChildViewById(view, i11);
            if (dSNavigationBar != null) {
                i11 = R.id.titleViewMoreTitleTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    return new FragLoyaltyFaqBinding((LinearLayout) view, recyclerView, dSNavigationBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragLoyaltyFaqBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyFaqBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_faq, viewGroup, false);
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
