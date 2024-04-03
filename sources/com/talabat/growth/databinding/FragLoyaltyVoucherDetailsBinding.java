package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import com.talabat.growth.ui.loyalty.views.CouponCodeView;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcore.databinding.GenericProgressBarBinding;

public final class FragLoyaltyVoucherDetailsBinding implements ViewBinding {
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView showVoucherCodeHintTextView;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ImageButton voucherDetailsBackButton;
    @NonNull
    public final CouponCodeView voucherDetailsCouponCodeView;
    @NonNull
    public final TextView voucherDetailsDetailTextView;
    @NonNull
    public final CardView voucherDetailsIconCardView;
    @NonNull
    public final TalabatImageView voucherDetailsIconImageView;
    @NonNull
    public final TalabatImageView voucherDetailsImageView;
    @NonNull
    public final CardView voucherDetailsLinearLayout;
    @NonNull
    public final DSPrimaryButton voucherDetailsRedirectionToPartnerButton;
    @NonNull
    public final TalabatTag voucherDetailsTagView;
    @NonNull
    public final TextView voucherDetailsTitleTextView;

    private FragLoyaltyVoucherDetailsBinding(@NonNull RelativeLayout relativeLayout, @NonNull GenericProgressBarBinding genericProgressBarBinding, @NonNull TextView textView, @NonNull Toolbar toolbar2, @NonNull ImageButton imageButton, @NonNull CouponCodeView couponCodeView, @NonNull TextView textView2, @NonNull CardView cardView, @NonNull TalabatImageView talabatImageView, @NonNull TalabatImageView talabatImageView2, @NonNull CardView cardView2, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull TalabatTag talabatTag, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.progressBar = genericProgressBarBinding;
        this.showVoucherCodeHintTextView = textView;
        this.toolbar = toolbar2;
        this.voucherDetailsBackButton = imageButton;
        this.voucherDetailsCouponCodeView = couponCodeView;
        this.voucherDetailsDetailTextView = textView2;
        this.voucherDetailsIconCardView = cardView;
        this.voucherDetailsIconImageView = talabatImageView;
        this.voucherDetailsImageView = talabatImageView2;
        this.voucherDetailsLinearLayout = cardView2;
        this.voucherDetailsRedirectionToPartnerButton = dSPrimaryButton;
        this.voucherDetailsTagView = talabatTag;
        this.voucherDetailsTitleTextView = textView3;
    }

    @NonNull
    public static FragLoyaltyVoucherDetailsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.progress_bar;
        View findChildViewById = ViewBindings.findChildViewById(view2, i11);
        if (findChildViewById != null) {
            GenericProgressBarBinding bind = GenericProgressBarBinding.bind(findChildViewById);
            i11 = R.id.showVoucherCodeHintTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
            if (textView != null) {
                i11 = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, i11);
                if (toolbar2 != null) {
                    i11 = R.id.voucherDetailsBackButton;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, i11);
                    if (imageButton != null) {
                        i11 = R.id.voucherDetailsCouponCodeView;
                        CouponCodeView couponCodeView = (CouponCodeView) ViewBindings.findChildViewById(view2, i11);
                        if (couponCodeView != null) {
                            i11 = R.id.voucherDetailsDetailTextView;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                            if (textView2 != null) {
                                i11 = R.id.voucherDetailsIconCardView;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(view2, i11);
                                if (cardView != null) {
                                    i11 = R.id.voucherDetailsIconImageView;
                                    TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view2, i11);
                                    if (talabatImageView != null) {
                                        i11 = R.id.voucherDetailsImageView;
                                        TalabatImageView talabatImageView2 = (TalabatImageView) ViewBindings.findChildViewById(view2, i11);
                                        if (talabatImageView2 != null) {
                                            i11 = R.id.voucherDetailsLinearLayout;
                                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, i11);
                                            if (cardView2 != null) {
                                                i11 = R.id.voucherDetailsRedirectionToPartnerButton;
                                                DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view2, i11);
                                                if (dSPrimaryButton != null) {
                                                    i11 = R.id.voucherDetailsTagView;
                                                    TalabatTag talabatTag = (TalabatTag) ViewBindings.findChildViewById(view2, i11);
                                                    if (talabatTag != null) {
                                                        i11 = R.id.voucherDetailsTitleTextView;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                        if (textView3 != null) {
                                                            return new FragLoyaltyVoucherDetailsBinding((RelativeLayout) view2, bind, textView, toolbar2, imageButton, couponCodeView, textView2, cardView, talabatImageView, talabatImageView2, cardView2, dSPrimaryButton, talabatTag, textView3);
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
    public static FragLoyaltyVoucherDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyVoucherDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_voucher_details, viewGroup, false);
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
