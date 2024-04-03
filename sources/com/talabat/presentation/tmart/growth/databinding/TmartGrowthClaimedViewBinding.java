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

public final class TmartGrowthClaimedViewBinding implements ViewBinding {
    @NonNull
    public final ImageView endIcon;
    @NonNull
    public final Guideline guidelineEnd;
    @NonNull
    public final Guideline guidelineStart;
    @NonNull
    private final View rootView;
    @NonNull
    public final ImageView startIcon;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private TmartGrowthClaimedViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = view;
        this.endIcon = imageView;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.startIcon = imageView2;
        this.subtitle = textView;
        this.title = textView2;
    }

    @NonNull
    public static TmartGrowthClaimedViewBinding bind(@NonNull View view) {
        int i11 = R.id.end_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.guideline_end;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
            if (guideline != null) {
                i11 = R.id.guideline_start;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i11);
                if (guideline2 != null) {
                    i11 = R.id.start_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView2 != null) {
                        i11 = R.id.subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                return new TmartGrowthClaimedViewBinding(view, imageView, guideline, guideline2, imageView2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TmartGrowthClaimedViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tmart_growth_claimed_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
