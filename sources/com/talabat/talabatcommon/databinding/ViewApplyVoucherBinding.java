package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.AddVoucherCodeView;
import com.talabat.talabatcommon.views.vouchers.lifecycle.BasketLifecycleVoucherView;

public final class ViewApplyVoucherBinding implements ViewBinding {
    @NonNull
    public final AddVoucherCodeView addVoucherCodeView;
    @NonNull
    public final TextView applyVoucherViewAddCodeTextView;
    @NonNull
    public final TextView applyVoucherViewDescriptionTextView;
    @NonNull
    public final TextView applyVoucherViewTitleTextView;
    @NonNull
    public final ViewPager applyVoucherViewViewPager;
    @NonNull
    public final BasketLifecycleVoucherView basketLifecycleVoucherView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final LinearLayout voucherView;

    private ViewApplyVoucherBinding(@NonNull RelativeLayout relativeLayout, @NonNull AddVoucherCodeView addVoucherCodeView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ViewPager viewPager, @NonNull BasketLifecycleVoucherView basketLifecycleVoucherView2, @NonNull LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.addVoucherCodeView = addVoucherCodeView2;
        this.applyVoucherViewAddCodeTextView = textView;
        this.applyVoucherViewDescriptionTextView = textView2;
        this.applyVoucherViewTitleTextView = textView3;
        this.applyVoucherViewViewPager = viewPager;
        this.basketLifecycleVoucherView = basketLifecycleVoucherView2;
        this.voucherView = linearLayout;
    }

    @NonNull
    public static ViewApplyVoucherBinding bind(@NonNull View view) {
        int i11 = R.id.addVoucherCodeView;
        AddVoucherCodeView addVoucherCodeView2 = (AddVoucherCodeView) ViewBindings.findChildViewById(view, i11);
        if (addVoucherCodeView2 != null) {
            i11 = R.id.applyVoucherViewAddCodeTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.applyVoucherViewDescriptionTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.applyVoucherViewTitleTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.applyVoucherViewViewPager;
                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i11);
                        if (viewPager != null) {
                            i11 = R.id.basketLifecycleVoucherView;
                            BasketLifecycleVoucherView basketLifecycleVoucherView2 = (BasketLifecycleVoucherView) ViewBindings.findChildViewById(view, i11);
                            if (basketLifecycleVoucherView2 != null) {
                                i11 = R.id.voucherView;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                if (linearLayout != null) {
                                    return new ViewApplyVoucherBinding((RelativeLayout) view, addVoucherCodeView2, textView, textView2, textView3, viewPager, basketLifecycleVoucherView2, linearLayout);
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
    public static ViewApplyVoucherBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewApplyVoucherBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_apply_voucher, viewGroup, false);
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
