package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.wang.avi.AVLoadingIndicatorView;

public final class SideMenuVouchersItemLayoutBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView sideMenuHeaderIcon;
    @NonNull
    public final TextView sideMenuHeaderTitle;
    @NonNull
    public final ConstraintLayout sideMenuHeaderView;
    @NonNull
    public final TextView voucherCount;
    @NonNull
    public final DSTag voucherNotificationTag;
    @NonNull
    public final AVLoadingIndicatorView voucherStateLoading;
    @NonNull
    public final FrameLayout vouchersStateContainer;

    private SideMenuVouchersItemLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull DSTag dSTag, @NonNull AVLoadingIndicatorView aVLoadingIndicatorView, @NonNull FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.sideMenuHeaderIcon = imageView;
        this.sideMenuHeaderTitle = textView;
        this.sideMenuHeaderView = constraintLayout2;
        this.voucherCount = textView2;
        this.voucherNotificationTag = dSTag;
        this.voucherStateLoading = aVLoadingIndicatorView;
        this.vouchersStateContainer = frameLayout;
    }

    @NonNull
    public static SideMenuVouchersItemLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.side_menu_header_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_header_icon);
        if (imageView != null) {
            i11 = R.id.side_menu_header_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.side_menu_header_title);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R.id.voucher_count;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.voucher_count);
                if (textView2 != null) {
                    i11 = R.id.voucher_notification_tag;
                    DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view, R.id.voucher_notification_tag);
                    if (dSTag != null) {
                        i11 = R.id.voucher_state_loading;
                        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(view, R.id.voucher_state_loading);
                        if (aVLoadingIndicatorView != null) {
                            i11 = R.id.vouchers_state_container;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.vouchers_state_container);
                            if (frameLayout != null) {
                                return new SideMenuVouchersItemLayoutBinding(constraintLayout, imageView, textView, constraintLayout, textView2, dSTag, aVLoadingIndicatorView, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SideMenuVouchersItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SideMenuVouchersItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.side_menu_vouchers_item_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
