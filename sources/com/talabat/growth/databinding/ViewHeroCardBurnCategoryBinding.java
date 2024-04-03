package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class ViewHeroCardBurnCategoryBinding implements ViewBinding {
    @NonNull
    public final CardView categoryHeroImageRelativeLayout;
    @NonNull
    public final TalabatImageView categoryHeroImageView;
    @NonNull
    public final TextView categoryHeroPointTextView;
    @NonNull
    public final TextView categoryHeroTitleTextView;
    @NonNull
    public final TextView categoryHeroViewAllTextView;
    @NonNull
    private final LinearLayout rootView;

    private ViewHeroCardBurnCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull CardView cardView, @NonNull TalabatImageView talabatImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.categoryHeroImageRelativeLayout = cardView;
        this.categoryHeroImageView = talabatImageView;
        this.categoryHeroPointTextView = textView;
        this.categoryHeroTitleTextView = textView2;
        this.categoryHeroViewAllTextView = textView3;
    }

    @NonNull
    public static ViewHeroCardBurnCategoryBinding bind(@NonNull View view) {
        int i11 = R.id.categoryHeroImageRelativeLayout;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
        if (cardView != null) {
            i11 = R.id.categoryHeroImageView;
            TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
            if (talabatImageView != null) {
                i11 = R.id.categoryHeroPointTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.categoryHeroTitleTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.categoryHeroViewAllTextView;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            return new ViewHeroCardBurnCategoryBinding((LinearLayout) view, cardView, talabatImageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHeroCardBurnCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHeroCardBurnCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_hero_card_burn_category, viewGroup, false);
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
