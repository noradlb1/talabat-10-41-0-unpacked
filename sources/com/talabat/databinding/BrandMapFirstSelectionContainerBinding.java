package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class BrandMapFirstSelectionContainerBinding implements ViewBinding {
    @NonNull
    public final ImageView arrowFill;
    @NonNull
    public final RelativeLayout brandingBranchViewMf;
    @NonNull
    public final ImageView brandingChooseAreaImageMf;
    @NonNull
    public final TalabatTextView brandingChooseAreaMf;
    @NonNull
    public final RelativeLayout brandingInsideAreaMf;
    @NonNull
    public final RelativeLayout brandingViewAreaMf;
    @NonNull
    public final TalabatFillButton btnShowMenuMf;
    @NonNull
    public final ImageView chooseBranchImageMf;
    @NonNull
    public final TalabatTextView chooseBranchMf;
    @NonNull
    public final RelativeLayout mapFirstSelectionContinaer;
    @NonNull
    private final RelativeLayout rootView;

    private BrandMapFirstSelectionContainerBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatFillButton talabatFillButton, @NonNull ImageView imageView3, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout5) {
        this.rootView = relativeLayout;
        this.arrowFill = imageView;
        this.brandingBranchViewMf = relativeLayout2;
        this.brandingChooseAreaImageMf = imageView2;
        this.brandingChooseAreaMf = talabatTextView;
        this.brandingInsideAreaMf = relativeLayout3;
        this.brandingViewAreaMf = relativeLayout4;
        this.btnShowMenuMf = talabatFillButton;
        this.chooseBranchImageMf = imageView3;
        this.chooseBranchMf = talabatTextView2;
        this.mapFirstSelectionContinaer = relativeLayout5;
    }

    @NonNull
    public static BrandMapFirstSelectionContainerBinding bind(@NonNull View view) {
        int i11 = R.id.arrow_fill;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.arrow_fill);
        if (imageView != null) {
            i11 = R.id.branding_branch_view_mf;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.branding_branch_view_mf);
            if (relativeLayout != null) {
                i11 = R.id.branding_choose_area_image_mf;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.branding_choose_area_image_mf);
                if (imageView2 != null) {
                    i11 = R.id.branding_choose_area_mf;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.branding_choose_area_mf);
                    if (talabatTextView != null) {
                        i11 = R.id.branding_inside_area_mf;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.branding_inside_area_mf);
                        if (relativeLayout2 != null) {
                            i11 = R.id.branding_view_area_mf;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.branding_view_area_mf);
                            if (relativeLayout3 != null) {
                                i11 = R.id.btnShowMenu_mf;
                                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.btnShowMenu_mf);
                                if (talabatFillButton != null) {
                                    i11 = R.id.choose_branch_image_mf;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.choose_branch_image_mf);
                                    if (imageView3 != null) {
                                        i11 = R.id.choose_branch_mf;
                                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.choose_branch_mf);
                                        if (talabatTextView2 != null) {
                                            RelativeLayout relativeLayout4 = (RelativeLayout) view;
                                            return new BrandMapFirstSelectionContainerBinding(relativeLayout4, imageView, relativeLayout, imageView2, talabatTextView, relativeLayout2, relativeLayout3, talabatFillButton, imageView3, talabatTextView2, relativeLayout4);
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
    public static BrandMapFirstSelectionContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BrandMapFirstSelectionContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.brand_map_first_selection_container, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
