package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.growth.R;

public final class LoginInfoContainerLifecycleVoucherBinding implements ViewBinding {
    @NonNull
    public final LoginInfoContainerLifecycleVoucherInfoBinding lifeCycleVoucherLoginInfo;
    @NonNull
    public final LoginInfoContainerLifecycleVoucherLoadingBinding lifeCycleVoucherLoginLoading;
    @NonNull
    private final FrameLayout rootView;

    private LoginInfoContainerLifecycleVoucherBinding(@NonNull FrameLayout frameLayout, @NonNull LoginInfoContainerLifecycleVoucherInfoBinding loginInfoContainerLifecycleVoucherInfoBinding, @NonNull LoginInfoContainerLifecycleVoucherLoadingBinding loginInfoContainerLifecycleVoucherLoadingBinding) {
        this.rootView = frameLayout;
        this.lifeCycleVoucherLoginInfo = loginInfoContainerLifecycleVoucherInfoBinding;
        this.lifeCycleVoucherLoginLoading = loginInfoContainerLifecycleVoucherLoadingBinding;
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherBinding bind(@NonNull View view) {
        int i11 = R.id.lifeCycleVoucherLoginInfo;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            LoginInfoContainerLifecycleVoucherInfoBinding bind = LoginInfoContainerLifecycleVoucherInfoBinding.bind(findChildViewById);
            int i12 = R.id.lifeCycleVoucherLoginLoading;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i12);
            if (findChildViewById2 != null) {
                return new LoginInfoContainerLifecycleVoucherBinding((FrameLayout) view, bind, LoginInfoContainerLifecycleVoucherLoadingBinding.bind(findChildViewById2));
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_info_container_lifecycle_voucher, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
