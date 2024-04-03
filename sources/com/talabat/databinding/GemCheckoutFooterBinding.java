package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GemCheckoutFooterBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView deductionAmountFour;
    @NonNull
    public final TalabatTextView deductionAmountOne;
    @NonNull
    public final TalabatTextView deductionAmountThree;
    @NonNull
    public final TalabatTextView deductionAmountTwo;
    @NonNull
    public final LinearLayout gemLayoutFour;
    @NonNull
    public final LinearLayout gemLayoutOne;
    @NonNull
    public final LinearLayout gemLayoutThree;
    @NonNull
    public final LinearLayout gemLayoutTwo;
    @NonNull
    public final LinearLayout mainView;
    @NonNull
    public final TalabatTextView offerAmountFour;
    @NonNull
    public final TalabatTextView offerAmountOne;
    @NonNull
    public final TalabatTextView offerAmountThree;
    @NonNull
    public final TalabatTextView offerAmountTwo;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView sandTimer;
    @NonNull
    public final LinearLayout tier1Content;
    @NonNull
    public final LinearLayout tier2Content;
    @NonNull
    public final LinearLayout tier3Content;
    @NonNull
    public final LinearLayout tier4Content;
    @NonNull
    public final LinearLayout tierContainer;
    @NonNull
    public final TalabatTextView timerText;

    private GemCheckoutFooterBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout6, @NonNull LinearLayout linearLayout7, @NonNull LinearLayout linearLayout8, @NonNull LinearLayout linearLayout9, @NonNull LinearLayout linearLayout10, @NonNull TalabatTextView talabatTextView9) {
        this.rootView = relativeLayout;
        this.deductionAmountFour = talabatTextView;
        this.deductionAmountOne = talabatTextView2;
        this.deductionAmountThree = talabatTextView3;
        this.deductionAmountTwo = talabatTextView4;
        this.gemLayoutFour = linearLayout;
        this.gemLayoutOne = linearLayout2;
        this.gemLayoutThree = linearLayout3;
        this.gemLayoutTwo = linearLayout4;
        this.mainView = linearLayout5;
        this.offerAmountFour = talabatTextView5;
        this.offerAmountOne = talabatTextView6;
        this.offerAmountThree = talabatTextView7;
        this.offerAmountTwo = talabatTextView8;
        this.sandTimer = imageView;
        this.tier1Content = linearLayout6;
        this.tier2Content = linearLayout7;
        this.tier3Content = linearLayout8;
        this.tier4Content = linearLayout9;
        this.tierContainer = linearLayout10;
        this.timerText = talabatTextView9;
    }

    @NonNull
    public static GemCheckoutFooterBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.deduction_amount_four;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.deduction_amount_four);
        if (talabatTextView != null) {
            i11 = R.id.deduction_amount_one;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.deduction_amount_one);
            if (talabatTextView2 != null) {
                i11 = R.id.deduction_amount_three;
                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.deduction_amount_three);
                if (talabatTextView3 != null) {
                    i11 = R.id.deduction_amount_two;
                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.deduction_amount_two);
                    if (talabatTextView4 != null) {
                        i11 = R.id.gem_layout_four;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_layout_four);
                        if (linearLayout != null) {
                            i11 = R.id.gem_layout_one;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_layout_one);
                            if (linearLayout2 != null) {
                                i11 = R.id.gem_layout_three;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_layout_three);
                                if (linearLayout3 != null) {
                                    i11 = R.id.gem_layout_two;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_layout_two);
                                    if (linearLayout4 != null) {
                                        i11 = R.id.main_view;
                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.main_view);
                                        if (linearLayout5 != null) {
                                            i11 = R.id.offer_amount_four;
                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.offer_amount_four);
                                            if (talabatTextView5 != null) {
                                                i11 = R.id.offer_amount_one;
                                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.offer_amount_one);
                                                if (talabatTextView6 != null) {
                                                    i11 = R.id.offer_amount_three;
                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.offer_amount_three);
                                                    if (talabatTextView7 != null) {
                                                        i11 = R.id.offer_amount_two;
                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.offer_amount_two);
                                                        if (talabatTextView8 != null) {
                                                            i11 = R.id.sand_timer;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.sand_timer);
                                                            if (imageView != null) {
                                                                i11 = R.id.tier1_content;
                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier1_content);
                                                                if (linearLayout6 != null) {
                                                                    i11 = R.id.tier2_content;
                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier2_content);
                                                                    if (linearLayout7 != null) {
                                                                        i11 = R.id.tier3_content;
                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier3_content);
                                                                        if (linearLayout8 != null) {
                                                                            i11 = R.id.tier4_content;
                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier4_content);
                                                                            if (linearLayout9 != null) {
                                                                                i11 = R.id.tier_container;
                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier_container);
                                                                                if (linearLayout10 != null) {
                                                                                    i11 = R.id.timer_text;
                                                                                    TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.timer_text);
                                                                                    if (talabatTextView9 != null) {
                                                                                        return new GemCheckoutFooterBinding((RelativeLayout) view2, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, talabatTextView5, talabatTextView6, talabatTextView7, talabatTextView8, imageView, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, talabatTextView9);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GemCheckoutFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GemCheckoutFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gem_checkout_footer, viewGroup, false);
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
