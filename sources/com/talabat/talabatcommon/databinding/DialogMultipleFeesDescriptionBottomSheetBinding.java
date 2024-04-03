package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class DialogMultipleFeesDescriptionBottomSheetBinding implements ViewBinding {
    @NonNull
    public final ImageView closeButton;
    @NonNull
    public final RelativeLayout deliveryFeeGroup;
    @NonNull
    public final ImageView deliveryFeeImage;
    @NonNull
    public final TextView deliveryFeeSubtitle;
    @NonNull
    public final TextView deliveryFeeTitle;
    @NonNull
    public final TalabatFillButton gotItButton;
    @NonNull
    public final TextView headerText;
    @NonNull
    public final TalabatStrokeButton readMoreButton;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout serviceFeeGroup;
    @NonNull
    public final ImageView serviceFeeImage;
    @NonNull
    public final TextView serviceFeeSubtitle;
    @NonNull
    public final TextView serviceFeeTitle;
    @NonNull
    public final RelativeLayout smallOrderFeeGroup;
    @NonNull
    public final ImageView smallOrderFeeImage;
    @NonNull
    public final TextView smallOrderFeeSubtitle;
    @NonNull
    public final TextView smallOrderFeeTitle;

    private DialogMultipleFeesDescriptionBottomSheetBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TalabatFillButton talabatFillButton, @NonNull TextView textView3, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView4, @NonNull TextView textView6, @NonNull TextView textView7) {
        this.rootView = linearLayout;
        this.closeButton = imageView;
        this.deliveryFeeGroup = relativeLayout;
        this.deliveryFeeImage = imageView2;
        this.deliveryFeeSubtitle = textView;
        this.deliveryFeeTitle = textView2;
        this.gotItButton = talabatFillButton;
        this.headerText = textView3;
        this.readMoreButton = talabatStrokeButton;
        this.serviceFeeGroup = relativeLayout2;
        this.serviceFeeImage = imageView3;
        this.serviceFeeSubtitle = textView4;
        this.serviceFeeTitle = textView5;
        this.smallOrderFeeGroup = relativeLayout3;
        this.smallOrderFeeImage = imageView4;
        this.smallOrderFeeSubtitle = textView6;
        this.smallOrderFeeTitle = textView7;
    }

    @NonNull
    public static DialogMultipleFeesDescriptionBottomSheetBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.close_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i11);
        if (imageView != null) {
            i11 = R.id.delivery_fee_group;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
            if (relativeLayout != null) {
                i11 = R.id.delivery_fee_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                if (imageView2 != null) {
                    i11 = R.id.delivery_fee_subtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
                    if (textView != null) {
                        i11 = R.id.delivery_fee_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                        if (textView2 != null) {
                            i11 = R.id.got_it_button;
                            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, i11);
                            if (talabatFillButton != null) {
                                i11 = R.id.header_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                if (textView3 != null) {
                                    i11 = R.id.read_more_button;
                                    TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, i11);
                                    if (talabatStrokeButton != null) {
                                        i11 = R.id.service_fee_group;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.service_fee_image;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                            if (imageView3 != null) {
                                                i11 = R.id.service_fee_subtitle;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                if (textView4 != null) {
                                                    i11 = R.id.service_fee_title;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView5 != null) {
                                                        i11 = R.id.small_order_fee_group;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                                                        if (relativeLayout3 != null) {
                                                            i11 = R.id.small_order_fee_image;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                                            if (imageView4 != null) {
                                                                i11 = R.id.small_order_fee_subtitle;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                if (textView6 != null) {
                                                                    i11 = R.id.small_order_fee_title;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                    if (textView7 != null) {
                                                                        return new DialogMultipleFeesDescriptionBottomSheetBinding((LinearLayout) view2, imageView, relativeLayout, imageView2, textView, textView2, talabatFillButton, textView3, talabatStrokeButton, relativeLayout2, imageView3, textView4, textView5, relativeLayout3, imageView4, textView6, textView7);
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
    public static DialogMultipleFeesDescriptionBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogMultipleFeesDescriptionBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.dialog_multiple_fees_description_bottom_sheet, viewGroup, false);
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
