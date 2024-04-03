package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_toast.DSToast;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.BottomCartView;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.feature.cart.views.CartProgressView;

public final class DarkstoresActivityMainBinding implements ViewBinding {
    @NonNull
    public final FrameLayout bottomCartContainer;
    @NonNull
    public final BottomCartView bottomCartView;
    @NonNull
    public final LinearLayout bottomContainer;
    @NonNull
    public final CartProgressView cartProgressView;
    @NonNull
    public final LoadingFailedView loadingFailedView;
    @NonNull
    public final ConstraintLayout mainConstraintLayout;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final DSToast toast;

    private DarkstoresActivityMainBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull BottomCartView bottomCartView2, @NonNull LinearLayout linearLayout, @NonNull CartProgressView cartProgressView2, @NonNull LoadingFailedView loadingFailedView2, @NonNull ConstraintLayout constraintLayout2, @NonNull DSToast dSToast) {
        this.rootView = constraintLayout;
        this.bottomCartContainer = frameLayout;
        this.bottomCartView = bottomCartView2;
        this.bottomContainer = linearLayout;
        this.cartProgressView = cartProgressView2;
        this.loadingFailedView = loadingFailedView2;
        this.mainConstraintLayout = constraintLayout2;
        this.toast = dSToast;
    }

    @NonNull
    public static DarkstoresActivityMainBinding bind(@NonNull View view) {
        int i11 = R.id.bottom_cart_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            i11 = R.id.bottom_cart_view;
            BottomCartView bottomCartView2 = (BottomCartView) ViewBindings.findChildViewById(view, i11);
            if (bottomCartView2 != null) {
                i11 = R.id.bottom_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.cartProgressView;
                    CartProgressView cartProgressView2 = (CartProgressView) ViewBindings.findChildViewById(view, i11);
                    if (cartProgressView2 != null) {
                        i11 = R.id.loadingFailedView;
                        LoadingFailedView loadingFailedView2 = (LoadingFailedView) ViewBindings.findChildViewById(view, i11);
                        if (loadingFailedView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i11 = R.id.toast;
                            DSToast dSToast = (DSToast) ViewBindings.findChildViewById(view, i11);
                            if (dSToast != null) {
                                return new DarkstoresActivityMainBinding(constraintLayout, frameLayout, bottomCartView2, linearLayout, cartProgressView2, loadingFailedView2, constraintLayout, dSToast);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_activity_main, viewGroup, false);
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
