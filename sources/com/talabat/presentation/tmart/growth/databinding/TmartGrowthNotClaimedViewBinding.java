package com.talabat.presentation.tmart.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.presentation.tmart.growth.R;

public final class TmartGrowthNotClaimedViewBinding implements ViewBinding {
    @NonNull
    public final TextView claimButton;
    @NonNull
    public final Guideline guidelineStart;
    @NonNull
    public final ImageView image;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private TmartGrowthNotClaimedViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = view;
        this.claimButton = textView;
        this.guidelineStart = guideline;
        this.image = imageView;
        this.subtitle = textView2;
        this.title = textView3;
    }

    @NonNull
    public static TmartGrowthNotClaimedViewBinding bind(@NonNull View view) {
        int i11 = R.id.claim_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.guideline_start;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
            if (guideline != null) {
                i11 = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.subtitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            return new TmartGrowthNotClaimedViewBinding(view, textView, guideline, imageView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TmartGrowthNotClaimedViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tmart_growth_not_claimed_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
