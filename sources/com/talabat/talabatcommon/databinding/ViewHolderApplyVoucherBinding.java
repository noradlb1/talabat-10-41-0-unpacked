package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewHolderApplyVoucherBinding implements ViewBinding {
    @NonNull
    public final TextView applyVoucherViewHolderApplied;
    @NonNull
    public final TextView applyVoucherViewHolderApplyButton;
    @NonNull
    public final RelativeLayout applyVoucherViewHolderButtonRelativeLayout;
    @NonNull
    public final ImageView applyVoucherViewHolderOfferImageView;
    @NonNull
    public final TextView applyVoucherViewHolderRedeemButton;
    @NonNull
    public final TextView applyVoucherViewHolderRemoveButton;
    @NonNull
    public final TextView applyVoucherViewHolderSubTitleTextView;
    @NonNull
    public final TextView applyVoucherViewHolderTitleTextView;
    @NonNull
    private final RelativeLayout rootView;

    private ViewHolderApplyVoucherBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.rootView = relativeLayout;
        this.applyVoucherViewHolderApplied = textView;
        this.applyVoucherViewHolderApplyButton = textView2;
        this.applyVoucherViewHolderButtonRelativeLayout = relativeLayout2;
        this.applyVoucherViewHolderOfferImageView = imageView;
        this.applyVoucherViewHolderRedeemButton = textView3;
        this.applyVoucherViewHolderRemoveButton = textView4;
        this.applyVoucherViewHolderSubTitleTextView = textView5;
        this.applyVoucherViewHolderTitleTextView = textView6;
    }

    @NonNull
    public static ViewHolderApplyVoucherBinding bind(@NonNull View view) {
        int i11 = R.id.applyVoucherViewHolderApplied;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.applyVoucherViewHolderApplyButton;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.applyVoucherViewHolderButtonRelativeLayout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                if (relativeLayout != null) {
                    i11 = R.id.applyVoucherViewHolderOfferImageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.applyVoucherViewHolderRedeemButton;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.applyVoucherViewHolderRemoveButton;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView4 != null) {
                                i11 = R.id.applyVoucherViewHolderSubTitleTextView;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView5 != null) {
                                    i11 = R.id.applyVoucherViewHolderTitleTextView;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView6 != null) {
                                        return new ViewHolderApplyVoucherBinding((RelativeLayout) view, textView, textView2, relativeLayout, imageView, textView3, textView4, textView5, textView6);
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
    public static ViewHolderApplyVoucherBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderApplyVoucherBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_apply_voucher, viewGroup, false);
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
