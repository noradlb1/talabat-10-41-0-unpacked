package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewHolderVoucherBottomSheetItemBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView voucherItemCheckBoxImageView;
    @NonNull
    public final ImageView voucherItemIconImageView;
    @NonNull
    public final TextView voucherItemRedemptionCountTextView;
    @NonNull
    public final TextView voucherItemSubTitleTextView;
    @NonNull
    public final TextView voucherItemTitleTextView;
    @NonNull
    public final LinearLayout voucherOfferRootLinearLayout;

    private ViewHolderVoucherBottomSheetItemBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.voucherItemCheckBoxImageView = imageView;
        this.voucherItemIconImageView = imageView2;
        this.voucherItemRedemptionCountTextView = textView;
        this.voucherItemSubTitleTextView = textView2;
        this.voucherItemTitleTextView = textView3;
        this.voucherOfferRootLinearLayout = linearLayout2;
    }

    @NonNull
    public static ViewHolderVoucherBottomSheetItemBinding bind(@NonNull View view) {
        int i11 = R.id.voucherItemCheckBoxImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.voucherItemIconImageView;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.voucherItemRedemptionCountTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.voucherItemSubTitleTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.voucherItemTitleTextView;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new ViewHolderVoucherBottomSheetItemBinding(linearLayout, imageView, imageView2, textView, textView2, textView3, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderVoucherBottomSheetItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderVoucherBottomSheetItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_voucher_bottom_sheet_item, viewGroup, false);
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
