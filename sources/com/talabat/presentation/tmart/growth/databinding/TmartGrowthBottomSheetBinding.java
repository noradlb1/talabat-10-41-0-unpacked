package com.talabat.presentation.tmart.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.presentation.tmart.growth.R;

public final class TmartGrowthBottomSheetBinding implements ViewBinding {
    @NonNull
    public final ImageView bigImage;
    @NonNull
    public final TextView dismissButton;
    @NonNull
    public final Guideline guidelineEnd;
    @NonNull
    public final Guideline guidelineStart;
    @NonNull
    public final Group infoGroup;
    @NonNull
    public final ImageView logo;
    @NonNull
    public final TextView primaryButton;
    @NonNull
    public final ProgressBar progress;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView secondaryButton;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final Group successGroup;
    @NonNull
    public final ImageView successIcon;
    @NonNull
    public final TextView successSubtitle;
    @NonNull
    public final TextView successTitle;
    @NonNull
    public final TextView title;
    @NonNull
    public final ConstraintLayout tmartGrowthBottomSheetView;

    private TmartGrowthBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Group group, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull ProgressBar progressBar, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Group group2, @NonNull ImageView imageView3, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.bigImage = imageView;
        this.dismissButton = textView;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.infoGroup = group;
        this.logo = imageView2;
        this.primaryButton = textView2;
        this.progress = progressBar;
        this.secondaryButton = textView3;
        this.subtitle = textView4;
        this.successGroup = group2;
        this.successIcon = imageView3;
        this.successSubtitle = textView5;
        this.successTitle = textView6;
        this.title = textView7;
        this.tmartGrowthBottomSheetView = constraintLayout2;
    }

    @NonNull
    public static TmartGrowthBottomSheetBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.big_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i11);
        if (imageView != null) {
            i11 = R.id.dismiss_button;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
            if (textView != null) {
                i11 = R.id.guideline_end;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i11);
                if (guideline != null) {
                    i11 = R.id.guideline_start;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i11);
                    if (guideline2 != null) {
                        i11 = R.id.info_group;
                        Group group = (Group) ViewBindings.findChildViewById(view2, i11);
                        if (group != null) {
                            i11 = R.id.logo;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                            if (imageView2 != null) {
                                i11 = R.id.primary_button;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                if (textView2 != null) {
                                    i11 = R.id.progress;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, i11);
                                    if (progressBar != null) {
                                        i11 = R.id.secondary_button;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                        if (textView3 != null) {
                                            i11 = R.id.subtitle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                            if (textView4 != null) {
                                                i11 = R.id.success_group;
                                                Group group2 = (Group) ViewBindings.findChildViewById(view2, i11);
                                                if (group2 != null) {
                                                    i11 = R.id.success_icon;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                                    if (imageView3 != null) {
                                                        i11 = R.id.success_subtitle;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                        if (textView5 != null) {
                                                            i11 = R.id.success_title;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                            if (textView6 != null) {
                                                                i11 = R.id.title;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                if (textView7 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                                                                    return new TmartGrowthBottomSheetBinding(constraintLayout, imageView, textView, guideline, guideline2, group, imageView2, textView2, progressBar, textView3, textView4, group2, imageView3, textView5, textView6, textView7, constraintLayout);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
    public static TmartGrowthBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TmartGrowthBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.tmart_growth_bottom_sheet, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
