package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class GemMultipleRestBinding implements ViewBinding {
    @NonNull
    public final FrameLayout frameLayoutRecyclerViewContainer;
    @NonNull
    public final ImageView gemLogo;
    @NonNull
    public final FrameLayout gemView;
    @NonNull
    public final ImageView imageViewClose;
    @NonNull
    public final RelativeLayout mainLayout;
    @NonNull
    public final RecyclerView recyclerViewRestaurants;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView sandTimer;
    @NonNull
    public final TextView talabatTextView10;
    @NonNull
    public final TextView talabatTextView13;
    @NonNull
    public final TextView talabatTextView14;
    @NonNull
    public final LinearLayout textLayout;
    @NonNull
    public final TextView textViewSubTitle;
    @NonNull
    public final TextView textViewTopTitle;
    @NonNull
    public final LinearLayout tier1Content;
    @NonNull
    public final TextView tier1Currency;
    @NonNull
    public final TextView tier1Disc;
    @NonNull
    public final TextView tier1Offer;
    @NonNull
    public final LinearLayout tier2Content;
    @NonNull
    public final TextView tier2Currency;
    @NonNull
    public final TextView tier2Disc;
    @NonNull
    public final TextView tier2Offer;
    @NonNull
    public final LinearLayout tier3Content;
    @NonNull
    public final TextView tier3Currency;
    @NonNull
    public final TextView tier3Disc;
    @NonNull
    public final TextView tier3Offer;
    @NonNull
    public final LinearLayout tier4Content;
    @NonNull
    public final TextView tier4Currency;
    @NonNull
    public final TextView tier4Disc;
    @NonNull
    public final TextView tier4Offer;
    @NonNull
    public final LinearLayout tierHolder;
    @NonNull
    public final TextView timeTextView;
    @NonNull
    public final LinearLayout timerContainer;

    private GemMultipleRestBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull LinearLayout linearLayout2, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull LinearLayout linearLayout3, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull LinearLayout linearLayout4, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull LinearLayout linearLayout5, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull TextView textView17, @NonNull LinearLayout linearLayout6, @NonNull TextView textView18, @NonNull LinearLayout linearLayout7) {
        this.rootView = relativeLayout;
        this.frameLayoutRecyclerViewContainer = frameLayout;
        this.gemLogo = imageView;
        this.gemView = frameLayout2;
        this.imageViewClose = imageView2;
        this.mainLayout = relativeLayout2;
        this.recyclerViewRestaurants = recyclerView;
        this.sandTimer = imageView3;
        this.talabatTextView10 = textView;
        this.talabatTextView13 = textView2;
        this.talabatTextView14 = textView3;
        this.textLayout = linearLayout;
        this.textViewSubTitle = textView4;
        this.textViewTopTitle = textView5;
        this.tier1Content = linearLayout2;
        this.tier1Currency = textView6;
        this.tier1Disc = textView7;
        this.tier1Offer = textView8;
        this.tier2Content = linearLayout3;
        this.tier2Currency = textView9;
        this.tier2Disc = textView10;
        this.tier2Offer = textView11;
        this.tier3Content = linearLayout4;
        this.tier3Currency = textView12;
        this.tier3Disc = textView13;
        this.tier3Offer = textView14;
        this.tier4Content = linearLayout5;
        this.tier4Currency = textView15;
        this.tier4Disc = textView16;
        this.tier4Offer = textView17;
        this.tierHolder = linearLayout6;
        this.timeTextView = textView18;
        this.timerContainer = linearLayout7;
    }

    @NonNull
    public static GemMultipleRestBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.frameLayout_recyclerViewContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.frameLayout_recyclerViewContainer);
        if (frameLayout != null) {
            i11 = R.id.gem_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.gem_logo);
            if (imageView != null) {
                i11 = R.id.gem_view;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.gem_view);
                if (frameLayout2 != null) {
                    i11 = R.id.imageView_close;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_close);
                    if (imageView2 != null) {
                        i11 = R.id.main_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.main_layout);
                        if (relativeLayout != null) {
                            i11 = R.id.recyclerView_restaurants;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_restaurants);
                            if (recyclerView != null) {
                                i11 = R.id.sand_timer;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.sand_timer);
                                if (imageView3 != null) {
                                    i11 = R.id.talabatTextView10;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView10);
                                    if (textView != null) {
                                        i11 = R.id.talabatTextView13;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView13);
                                        if (textView2 != null) {
                                            i11 = R.id.talabatTextView14;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView14);
                                            if (textView3 != null) {
                                                i11 = R.id.text_layout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.text_layout);
                                                if (linearLayout != null) {
                                                    i11 = R.id.textView_subTitle;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_subTitle);
                                                    if (textView4 != null) {
                                                        i11 = R.id.textView_topTitle;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_topTitle);
                                                        if (textView5 != null) {
                                                            i11 = R.id.tier1_content;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier1_content);
                                                            if (linearLayout2 != null) {
                                                                i11 = R.id.tier1_currency;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier1_currency);
                                                                if (textView6 != null) {
                                                                    i11 = R.id.tier1_disc;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier1_disc);
                                                                    if (textView7 != null) {
                                                                        i11 = R.id.tier1_offer;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier1_offer);
                                                                        if (textView8 != null) {
                                                                            i11 = R.id.tier2_content;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier2_content);
                                                                            if (linearLayout3 != null) {
                                                                                i11 = R.id.tier2_currency;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier2_currency);
                                                                                if (textView9 != null) {
                                                                                    i11 = R.id.tier2_disc;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier2_disc);
                                                                                    if (textView10 != null) {
                                                                                        i11 = R.id.tier2_offer;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier2_offer);
                                                                                        if (textView11 != null) {
                                                                                            i11 = R.id.tier3_content;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier3_content);
                                                                                            if (linearLayout4 != null) {
                                                                                                i11 = R.id.tier3_currency;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier3_currency);
                                                                                                if (textView12 != null) {
                                                                                                    i11 = R.id.tier3_disc;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier3_disc);
                                                                                                    if (textView13 != null) {
                                                                                                        i11 = R.id.tier3_offer;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier3_offer);
                                                                                                        if (textView14 != null) {
                                                                                                            i11 = R.id.tier4_content;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier4_content);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i11 = R.id.tier4_currency;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier4_currency);
                                                                                                                if (textView15 != null) {
                                                                                                                    i11 = R.id.tier4_disc;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier4_disc);
                                                                                                                    if (textView16 != null) {
                                                                                                                        i11 = R.id.tier4_offer;
                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, R.id.tier4_offer);
                                                                                                                        if (textView17 != null) {
                                                                                                                            i11 = R.id.tier_holder;
                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tier_holder);
                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                i11 = R.id.time_text_view;
                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, R.id.time_text_view);
                                                                                                                                if (textView18 != null) {
                                                                                                                                    i11 = R.id.timerContainer;
                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.timerContainer);
                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                        return new GemMultipleRestBinding((RelativeLayout) view2, frameLayout, imageView, frameLayout2, imageView2, relativeLayout, recyclerView, imageView3, textView, textView2, textView3, linearLayout, textView4, textView5, linearLayout2, textView6, textView7, textView8, linearLayout3, textView9, textView10, textView11, linearLayout4, textView12, textView13, textView14, linearLayout5, textView15, textView16, textView17, linearLayout6, textView18, linearLayout7);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GemMultipleRestBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GemMultipleRestBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gem_multiple_rest, viewGroup, false);
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
