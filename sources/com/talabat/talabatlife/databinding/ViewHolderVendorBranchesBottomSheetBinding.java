package com.talabat.talabatlife.databinding;

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
import com.talabat.talabatlife.R;

public final class ViewHolderVendorBranchesBottomSheetBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView vendorBranchesDistanceTextView;
    @NonNull
    public final ImageView vendorBranchesIconImageView;
    @NonNull
    public final LinearLayout vendorBranchesRootLinearLayout;
    @NonNull
    public final TextView vendorBranchesSubTitleTextView;
    @NonNull
    public final TextView vendorBranchesTitleTextView;

    private ViewHolderVendorBranchesBottomSheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.vendorBranchesDistanceTextView = textView;
        this.vendorBranchesIconImageView = imageView;
        this.vendorBranchesRootLinearLayout = linearLayout2;
        this.vendorBranchesSubTitleTextView = textView2;
        this.vendorBranchesTitleTextView = textView3;
    }

    @NonNull
    public static ViewHolderVendorBranchesBottomSheetBinding bind(@NonNull View view) {
        int i11 = R.id.vendorBranchesDistanceTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.vendorBranchesIconImageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R.id.vendorBranchesSubTitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.vendorBranchesTitleTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        return new ViewHolderVendorBranchesBottomSheetBinding(linearLayout, textView, imageView, linearLayout, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderVendorBranchesBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderVendorBranchesBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_vendor_branches_bottom_sheet, viewGroup, false);
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
