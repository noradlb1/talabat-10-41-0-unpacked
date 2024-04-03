package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radio_button.DSRadioButton;
import com.talabat.R;

public final class CheckoutOrderTimeSelectorViewBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout clOrderNow;
    @NonNull
    public final RelativeLayout clScheduleLater;
    @NonNull
    public final AppCompatImageView ivOrderNow;
    @NonNull
    public final AppCompatImageView ivScheduleLater;
    @NonNull
    public final LinearLayout llScheduleLater;
    @NonNull
    public final DSRadioButton rbOrderNow;
    @NonNull
    public final DSRadioButton rbScheduleLater;
    @NonNull
    private final View rootView;
    @NonNull
    public final AppCompatTextView tvNew;
    @NonNull
    public final AppCompatTextView tvOrderNow;
    @NonNull
    public final AppCompatTextView tvScheduleLater;
    @NonNull
    public final AppCompatTextView tvScheduleLaterSubtitle;
    @NonNull
    public final AppCompatTextView tvScheduledDeliveryDiscountInfo;
    @NonNull
    public final AppCompatTextView tvScheduledDeliveryDiscountIntro;

    private CheckoutOrderTimeSelectorViewBinding(@NonNull View view, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull DSRadioButton dSRadioButton, @NonNull DSRadioButton dSRadioButton2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6) {
        this.rootView = view;
        this.clOrderNow = relativeLayout;
        this.clScheduleLater = relativeLayout2;
        this.ivOrderNow = appCompatImageView;
        this.ivScheduleLater = appCompatImageView2;
        this.llScheduleLater = linearLayout;
        this.rbOrderNow = dSRadioButton;
        this.rbScheduleLater = dSRadioButton2;
        this.tvNew = appCompatTextView;
        this.tvOrderNow = appCompatTextView2;
        this.tvScheduleLater = appCompatTextView3;
        this.tvScheduleLaterSubtitle = appCompatTextView4;
        this.tvScheduledDeliveryDiscountInfo = appCompatTextView5;
        this.tvScheduledDeliveryDiscountIntro = appCompatTextView6;
    }

    @NonNull
    public static CheckoutOrderTimeSelectorViewBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.clOrderNow;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.clOrderNow);
        if (relativeLayout != null) {
            i11 = R.id.clScheduleLater;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.clScheduleLater);
            if (relativeLayout2 != null) {
                i11 = R.id.ivOrderNow;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, R.id.ivOrderNow);
                if (appCompatImageView != null) {
                    i11 = R.id.ivScheduleLater;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, R.id.ivScheduleLater);
                    if (appCompatImageView2 != null) {
                        i11 = R.id.llScheduleLater;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.llScheduleLater);
                        if (linearLayout != null) {
                            i11 = R.id.rbOrderNow;
                            DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view2, R.id.rbOrderNow);
                            if (dSRadioButton != null) {
                                i11 = R.id.rbScheduleLater;
                                DSRadioButton dSRadioButton2 = (DSRadioButton) ViewBindings.findChildViewById(view2, R.id.rbScheduleLater);
                                if (dSRadioButton2 != null) {
                                    i11 = R.id.tvNew;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, R.id.tvNew);
                                    if (appCompatTextView != null) {
                                        i11 = R.id.tvOrderNow;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, R.id.tvOrderNow);
                                        if (appCompatTextView2 != null) {
                                            i11 = R.id.tvScheduleLater;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view2, R.id.tvScheduleLater);
                                            if (appCompatTextView3 != null) {
                                                i11 = R.id.tvScheduleLaterSubtitle;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view2, R.id.tvScheduleLaterSubtitle);
                                                if (appCompatTextView4 != null) {
                                                    i11 = R.id.tvScheduledDeliveryDiscountInfo;
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(view2, R.id.tvScheduledDeliveryDiscountInfo);
                                                    if (appCompatTextView5 != null) {
                                                        i11 = R.id.tvScheduledDeliveryDiscountIntro;
                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.findChildViewById(view2, R.id.tvScheduledDeliveryDiscountIntro);
                                                        if (appCompatTextView6 != null) {
                                                            return new CheckoutOrderTimeSelectorViewBinding(view, relativeLayout, relativeLayout2, appCompatImageView, appCompatImageView2, linearLayout, dSRadioButton, dSRadioButton2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
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
    public static CheckoutOrderTimeSelectorViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.checkout_order_time_selector_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
