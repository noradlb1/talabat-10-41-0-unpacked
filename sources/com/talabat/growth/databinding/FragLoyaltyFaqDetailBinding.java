package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.talabat.growth.R;

public final class FragLoyaltyFaqDetailBinding implements ViewBinding {
    @NonNull
    public final DSNavigationBar getHelpDetailsDSNavigationBar;
    @NonNull
    public final TextView loyaltyFAQDetailAnswerTextView;
    @NonNull
    public final TextView loyaltyFAQDetailQuestionTextView;
    @NonNull
    private final LinearLayout rootView;

    private FragLoyaltyFaqDetailBinding(@NonNull LinearLayout linearLayout, @NonNull DSNavigationBar dSNavigationBar, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.getHelpDetailsDSNavigationBar = dSNavigationBar;
        this.loyaltyFAQDetailAnswerTextView = textView;
        this.loyaltyFAQDetailQuestionTextView = textView2;
    }

    @NonNull
    public static FragLoyaltyFaqDetailBinding bind(@NonNull View view) {
        int i11 = R.id.getHelpDetailsDSNavigationBar;
        DSNavigationBar dSNavigationBar = (DSNavigationBar) ViewBindings.findChildViewById(view, i11);
        if (dSNavigationBar != null) {
            i11 = R.id.loyaltyFAQDetailAnswerTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.loyaltyFAQDetailQuestionTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new FragLoyaltyFaqDetailBinding((LinearLayout) view, dSNavigationBar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragLoyaltyFaqDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyFaqDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_faq_detail, viewGroup, false);
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
