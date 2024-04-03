package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class GemAlertBinding implements ViewBinding {
    @NonNull
    public final ImageView gemLogo;
    @NonNull
    public final LinearLayout gemOfferView;
    @NonNull
    public final LinearLayout gemView;
    @NonNull
    public final ImageView imageViewClose;
    @NonNull
    public final TalabatTextView leaveofferButton;
    @NonNull
    public final TalabatTextView mainTextTitle;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView sandTimerTimedOut;
    @NonNull
    public final TalabatFillButton stillInterested;
    @NonNull
    public final TalabatTextView talabatTextView11;
    @NonNull
    public final LinearLayout textLayout;
    @NonNull
    public final LinearLayout tier1Content;
    @NonNull
    public final TalabatTextView tier1Currency;
    @NonNull
    public final TalabatTextView tier1Disc;
    @NonNull
    public final TalabatTextView tier1Offer;
    @NonNull
    public final LinearLayout tier2Content;
    @NonNull
    public final TalabatTextView tier2Currency;
    @NonNull
    public final TalabatTextView tier2Disc;
    @NonNull
    public final TalabatTextView tier2Offer;
    @NonNull
    public final LinearLayout tier3Content;
    @NonNull
    public final TalabatTextView tier3Currency;
    @NonNull
    public final TalabatTextView tier3Disc;
    @NonNull
    public final TalabatTextView tier3Offer;
    @NonNull
    public final LinearLayout tier4Content;
    @NonNull
    public final TalabatTextView tier4Currency;
    @NonNull
    public final TalabatTextView tier4Disc;
    @NonNull
    public final TalabatTextView tier4Offer;
    @NonNull
    public final LinearLayout tierContainer;
    @NonNull
    public final TalabatTextView timeOutMsgTxt;
    @NonNull
    public final TalabatTextView timeTextView;
    @NonNull
    public final LinearLayout timeoutMain;

    private GemAlertBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView3, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9, @NonNull LinearLayout linearLayout7, @NonNull TalabatTextView talabatTextView10, @NonNull TalabatTextView talabatTextView12, @NonNull TalabatTextView talabatTextView13, @NonNull LinearLayout linearLayout8, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull TalabatTextView talabatTextView16, @NonNull LinearLayout linearLayout9, @NonNull TalabatTextView talabatTextView17, @NonNull TalabatTextView talabatTextView18, @NonNull LinearLayout linearLayout10) {
        this.rootView = linearLayout;
        this.gemLogo = imageView;
        this.gemOfferView = linearLayout2;
        this.gemView = linearLayout3;
        this.imageViewClose = imageView2;
        this.leaveofferButton = talabatTextView;
        this.mainTextTitle = talabatTextView2;
        this.sandTimerTimedOut = imageView3;
        this.stillInterested = talabatFillButton;
        this.talabatTextView11 = talabatTextView3;
        this.textLayout = linearLayout4;
        this.tier1Content = linearLayout5;
        this.tier1Currency = talabatTextView4;
        this.tier1Disc = talabatTextView5;
        this.tier1Offer = talabatTextView6;
        this.tier2Content = linearLayout6;
        this.tier2Currency = talabatTextView7;
        this.tier2Disc = talabatTextView8;
        this.tier2Offer = talabatTextView9;
        this.tier3Content = linearLayout7;
        this.tier3Currency = talabatTextView10;
        this.tier3Disc = talabatTextView12;
        this.tier3Offer = talabatTextView13;
        this.tier4Content = linearLayout8;
        this.tier4Currency = talabatTextView14;
        this.tier4Disc = talabatTextView15;
        this.tier4Offer = talabatTextView16;
        this.tierContainer = linearLayout9;
        this.timeOutMsgTxt = talabatTextView17;
        this.timeTextView = talabatTextView18;
        this.timeoutMain = linearLayout10;
    }

    @NonNull
    public static GemAlertBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.gem_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.gem_logo);
        if (imageView != null) {
            i11 = R.id.gem_offer_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_offer_view);
            if (linearLayout != null) {
                i11 = R.id.gem_view;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.gem_view);
                if (linearLayout2 != null) {
                    i11 = R.id.imageView_close;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_close);
                    if (imageView2 != null) {
                        i11 = R.id.leaveoffer_button;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.leaveoffer_button);
                        if (talabatTextView != null) {
                            i11 = R.id.main_text_title;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.main_text_title);
                            if (talabatTextView2 != null) {
                                i11 = R.id.sand_timer_timed_out;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.sand_timer_timed_out);
                                if (imageView3 != null) {
                                    i11 = R.id.still_interested;
                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.still_interested);
                                    if (talabatFillButton != null) {
                                        i11 = R.id.talabatTextView11;
                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView11);
                                        if (talabatTextView3 != null) {
                                            i11 = R.id.text_layout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.text_layout);
                                            if (linearLayout3 != null) {
                                                i11 = R.id.tier1_content;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier1_content);
                                                if (linearLayout4 != null) {
                                                    i11 = R.id.tier1_currency;
                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier1_currency);
                                                    if (talabatTextView4 != null) {
                                                        i11 = R.id.tier1_disc;
                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier1_disc);
                                                        if (talabatTextView5 != null) {
                                                            i11 = R.id.tier1_offer;
                                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier1_offer);
                                                            if (talabatTextView6 != null) {
                                                                i11 = R.id.tier2_content;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier2_content);
                                                                if (linearLayout5 != null) {
                                                                    i11 = R.id.tier2_currency;
                                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier2_currency);
                                                                    if (talabatTextView7 != null) {
                                                                        i11 = R.id.tier2_disc;
                                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier2_disc);
                                                                        if (talabatTextView8 != null) {
                                                                            i11 = R.id.tier2_offer;
                                                                            TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier2_offer);
                                                                            if (talabatTextView9 != null) {
                                                                                i11 = R.id.tier3_content;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier3_content);
                                                                                if (linearLayout6 != null) {
                                                                                    i11 = R.id.tier3_currency;
                                                                                    TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier3_currency);
                                                                                    if (talabatTextView10 != null) {
                                                                                        i11 = R.id.tier3_disc;
                                                                                        TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier3_disc);
                                                                                        if (talabatTextView12 != null) {
                                                                                            i11 = R.id.tier3_offer;
                                                                                            TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier3_offer);
                                                                                            if (talabatTextView13 != null) {
                                                                                                i11 = R.id.tier4_content;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier4_content);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i11 = R.id.tier4_currency;
                                                                                                    TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier4_currency);
                                                                                                    if (talabatTextView14 != null) {
                                                                                                        i11 = R.id.tier4_disc;
                                                                                                        TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier4_disc);
                                                                                                        if (talabatTextView15 != null) {
                                                                                                            i11 = R.id.tier4_offer;
                                                                                                            TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tier4_offer);
                                                                                                            if (talabatTextView16 != null) {
                                                                                                                i11 = R.id.tier_container;
                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier_container);
                                                                                                                if (linearLayout8 != null) {
                                                                                                                    i11 = R.id.time_out_msg_txt;
                                                                                                                    TalabatTextView talabatTextView17 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.time_out_msg_txt);
                                                                                                                    if (talabatTextView17 != null) {
                                                                                                                        i11 = R.id.time_text_view;
                                                                                                                        TalabatTextView talabatTextView18 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.time_text_view);
                                                                                                                        if (talabatTextView18 != null) {
                                                                                                                            i11 = R.id.timeout_main;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.timeout_main);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                return new GemAlertBinding((LinearLayout) view2, imageView, linearLayout, linearLayout2, imageView2, talabatTextView, talabatTextView2, imageView3, talabatFillButton, talabatTextView3, linearLayout3, linearLayout4, talabatTextView4, talabatTextView5, talabatTextView6, linearLayout5, talabatTextView7, talabatTextView8, talabatTextView9, linearLayout6, talabatTextView10, talabatTextView12, talabatTextView13, linearLayout7, talabatTextView14, talabatTextView15, talabatTextView16, linearLayout8, talabatTextView17, talabatTextView18, linearLayout9);
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
    public static GemAlertBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GemAlertBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gem_alert, viewGroup, false);
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
