package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.marshmallow.TalabatTag;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class FragLoyaltyBurnOptionsDetailsBinding implements ViewBinding {
    @NonNull
    public final TextView burnDetailsAvailablePointsTextView;
    @NonNull
    public final ImageButton burnDetailsBackButton;
    @NonNull
    public final LinearLayout burnDetailsCurrentPointsLinearLayout;
    @NonNull
    public final TextView burnDetailsDetailTextView;
    @NonNull
    public final TalabatImageView burnDetailsIconImageView;
    @NonNull
    public final TalabatImageView burnDetailsImageView;
    @NonNull
    public final TextView burnDetailsItemPointsTextView;
    @NonNull
    public final TextView burnDetailsNeededPointsTextView;
    @NonNull
    public final DSPrimaryButton burnDetailsRedeemButton;
    @NonNull
    public final CardView burnDetailsRedeemLinearLayout;
    @NonNull
    public final TalabatTag burnDetailsTagView;
    @NonNull
    public final TextView burnDetailsTitleTextView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final Toolbar toolbar;

    private FragLoyaltyBurnOptionsDetailsBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TalabatImageView talabatImageView, @NonNull TalabatImageView talabatImageView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull CardView cardView, @NonNull TalabatTag talabatTag, @NonNull TextView textView5, @NonNull Toolbar toolbar2) {
        this.rootView = relativeLayout;
        this.burnDetailsAvailablePointsTextView = textView;
        this.burnDetailsBackButton = imageButton;
        this.burnDetailsCurrentPointsLinearLayout = linearLayout;
        this.burnDetailsDetailTextView = textView2;
        this.burnDetailsIconImageView = talabatImageView;
        this.burnDetailsImageView = talabatImageView2;
        this.burnDetailsItemPointsTextView = textView3;
        this.burnDetailsNeededPointsTextView = textView4;
        this.burnDetailsRedeemButton = dSPrimaryButton;
        this.burnDetailsRedeemLinearLayout = cardView;
        this.burnDetailsTagView = talabatTag;
        this.burnDetailsTitleTextView = textView5;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static FragLoyaltyBurnOptionsDetailsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.burnDetailsAvailablePointsTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
        if (textView != null) {
            i11 = R.id.burnDetailsBackButton;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, i11);
            if (imageButton != null) {
                i11 = R.id.burnDetailsCurrentPointsLinearLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                if (linearLayout != null) {
                    i11 = R.id.burnDetailsDetailTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                    if (textView2 != null) {
                        i11 = R.id.burnDetailsIconImageView;
                        TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view2, i11);
                        if (talabatImageView != null) {
                            i11 = R.id.burnDetailsImageView;
                            TalabatImageView talabatImageView2 = (TalabatImageView) ViewBindings.findChildViewById(view2, i11);
                            if (talabatImageView2 != null) {
                                i11 = R.id.burnDetailsItemPointsTextView;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                if (textView3 != null) {
                                    i11 = R.id.burnDetailsNeededPointsTextView;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                    if (textView4 != null) {
                                        i11 = R.id.burnDetailsRedeemButton;
                                        DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view2, i11);
                                        if (dSPrimaryButton != null) {
                                            i11 = R.id.burnDetailsRedeemLinearLayout;
                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, i11);
                                            if (cardView != null) {
                                                i11 = R.id.burnDetailsTagView;
                                                TalabatTag talabatTag = (TalabatTag) ViewBindings.findChildViewById(view2, i11);
                                                if (talabatTag != null) {
                                                    i11 = R.id.burnDetailsTitleTextView;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView5 != null) {
                                                        i11 = R.id.toolbar;
                                                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, i11);
                                                        if (toolbar2 != null) {
                                                            return new FragLoyaltyBurnOptionsDetailsBinding((RelativeLayout) view2, textView, imageButton, linearLayout, textView2, talabatImageView, talabatImageView2, textView3, textView4, dSPrimaryButton, cardView, talabatTag, textView5, toolbar2);
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
    public static FragLoyaltyBurnOptionsDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyBurnOptionsDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_burn_options_details, viewGroup, false);
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
