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

public final class UserAccountItemBinding implements ViewBinding {
    @NonNull
    public final AVLoadingIndicatorView creditBalLoading;
    @NonNull
    public final TextView notificationBuble;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView sideMenuHeaderIcon;
    @NonNull
    public final TextView sideMenuHeaderTitle;
    @NonNull
    public final ConstraintLayout sideMenuHeaderView;
    @NonNull
    public final FrameLayout sideMenuSelector;
    @NonNull
    public final TextView talabatCreditBal;
    @NonNull
    public final DSTag talabatCreditIncompleteWarning;

    private UserAccountItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AVLoadingIndicatorView aVLoadingIndicatorView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout, @NonNull TextView textView3, @NonNull DSTag dSTag) {
        this.rootView = constraintLayout;
        this.creditBalLoading = aVLoadingIndicatorView;
        this.notificationBuble = textView;
        this.sideMenuHeaderIcon = imageView;
        this.sideMenuHeaderTitle = textView2;
        this.sideMenuHeaderView = constraintLayout2;
        this.sideMenuSelector = frameLayout;
        this.talabatCreditBal = textView3;
        this.talabatCreditIncompleteWarning = dSTag;
    }

    @NonNull
    public static UserAccountItemBinding bind(@NonNull View view) {
        int i11 = R.id.credit_bal_loading;
        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(view, R.id.credit_bal_loading);
        if (aVLoadingIndicatorView != null) {
            i11 = R.id.notification_buble;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.notification_buble);
            if (textView != null) {
                i11 = R.id.side_menu_header_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_header_icon);
                if (imageView != null) {
                    i11 = R.id.side_menu_header_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.side_menu_header_title);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i11 = R.id.side_menu_selector;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.side_menu_selector);
                        if (frameLayout != null) {
                            i11 = R.id.talabat_credit_bal;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.talabat_credit_bal);
                            if (textView3 != null) {
                                i11 = R.id.talabat_credit_incomplete_warning;
                                DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view, R.id.talabat_credit_incomplete_warning);
                                if (dSTag != null) {
                                    return new UserAccountItemBinding(constraintLayout, aVLoadingIndicatorView, textView, imageView, textView2, constraintLayout, frameLayout, textView3, dSTag);
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
    public static UserAccountItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UserAccountItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.user_account_item, viewGroup, false);
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
