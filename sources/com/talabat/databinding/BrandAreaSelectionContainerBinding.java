package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class BrandAreaSelectionContainerBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout brandingBranchView;
    @NonNull
    public final TalabatTextView brandingChooseArea;
    @NonNull
    public final ImageView brandingChooseAreaImage;
    @NonNull
    public final TalabatTextView brandingChooseCity;
    @NonNull
    public final ImageView brandingChooseCityImage;
    @NonNull
    public final RelativeLayout brandingInsideArea;
    @NonNull
    public final RelativeLayout brandingInsideCityView;
    @NonNull
    public final ImageButton brandingMapbuttonArea;
    @NonNull
    public final ImageButton brandingMapbuttonCity;
    @NonNull
    public final RelativeLayout brandingViewArea;
    @NonNull
    public final RelativeLayout brandingViewCity;
    @NonNull
    public final TalabatFillButton btnShowMenu;
    @NonNull
    public final TalabatTextView chooseBranch;
    @NonNull
    public final ImageView chooseBranchImage;
    @NonNull
    public final ImageView imageView7;
    @NonNull
    public final RelativeLayout normalAreaSelectionContainer;
    @NonNull
    private final RelativeLayout rootView;

    private BrandAreaSelectionContainerBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull RelativeLayout relativeLayout5, @NonNull RelativeLayout relativeLayout6, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView3, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull RelativeLayout relativeLayout7) {
        this.rootView = relativeLayout;
        this.brandingBranchView = relativeLayout2;
        this.brandingChooseArea = talabatTextView;
        this.brandingChooseAreaImage = imageView;
        this.brandingChooseCity = talabatTextView2;
        this.brandingChooseCityImage = imageView2;
        this.brandingInsideArea = relativeLayout3;
        this.brandingInsideCityView = relativeLayout4;
        this.brandingMapbuttonArea = imageButton;
        this.brandingMapbuttonCity = imageButton2;
        this.brandingViewArea = relativeLayout5;
        this.brandingViewCity = relativeLayout6;
        this.btnShowMenu = talabatFillButton;
        this.chooseBranch = talabatTextView3;
        this.chooseBranchImage = imageView3;
        this.imageView7 = imageView4;
        this.normalAreaSelectionContainer = relativeLayout7;
    }

    @NonNull
    public static BrandAreaSelectionContainerBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.branding_branch_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.branding_branch_view);
        if (relativeLayout != null) {
            i11 = R.id.branding_choose_area;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.branding_choose_area);
            if (talabatTextView != null) {
                i11 = R.id.branding_choose_area_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.branding_choose_area_image);
                if (imageView != null) {
                    i11 = R.id.branding_choose_city;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.branding_choose_city);
                    if (talabatTextView2 != null) {
                        i11 = R.id.branding_choose_city_image;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.branding_choose_city_image);
                        if (imageView2 != null) {
                            i11 = R.id.branding_inside_area;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.branding_inside_area);
                            if (relativeLayout2 != null) {
                                i11 = R.id.branding_inside_city_view;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.branding_inside_city_view);
                                if (relativeLayout3 != null) {
                                    i11 = R.id.branding_mapbutton_area;
                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.branding_mapbutton_area);
                                    if (imageButton != null) {
                                        i11 = R.id.branding_mapbutton_city;
                                        ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.branding_mapbutton_city);
                                        if (imageButton2 != null) {
                                            i11 = R.id.branding_view_area;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.branding_view_area);
                                            if (relativeLayout4 != null) {
                                                i11 = R.id.branding_view_city;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.branding_view_city);
                                                if (relativeLayout5 != null) {
                                                    i11 = R.id.btnShowMenu;
                                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.btnShowMenu);
                                                    if (talabatFillButton != null) {
                                                        i11 = R.id.choose_branch;
                                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.choose_branch);
                                                        if (talabatTextView3 != null) {
                                                            i11 = R.id.choose_branch_image;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.choose_branch_image);
                                                            if (imageView3 != null) {
                                                                i11 = R.id.imageView7;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView7);
                                                                if (imageView4 != null) {
                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) view2;
                                                                    return new BrandAreaSelectionContainerBinding(relativeLayout6, relativeLayout, talabatTextView, imageView, talabatTextView2, imageView2, relativeLayout2, relativeLayout3, imageButton, imageButton2, relativeLayout4, relativeLayout5, talabatFillButton, talabatTextView3, imageView3, imageView4, relativeLayout6);
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
    public static BrandAreaSelectionContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BrandAreaSelectionContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.brand_area_selection_container, viewGroup, false);
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
