package com.talabat.userandlocation.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSSocialButton;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView;
import com.talabat.userandlocation.login.R;

public final class LayoutLoginOptionsBinding implements ViewBinding {
    @NonNull
    public final DSSocialButton btnLoginWithEmail;
    @NonNull
    public final DSSocialButton btnLoginWithFacebook;
    @NonNull
    public final DSSocialButton btnLoginWithGoogle;
    @NonNull
    public final ConstraintLayout containerImageAndDescription;
    @NonNull
    public final ConstraintLayout containerLoginOptions;
    @NonNull
    public final ConstraintLayout containerTitleDescription;
    @NonNull
    public final ImageView imageLogo;
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final LoginLifecycleVoucherView lifeCycleVoucherLoginInfoView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textLogoText;
    @NonNull
    public final TextView txtDescription;
    @NonNull
    public final TextView txtTitle;

    private LayoutLoginOptionsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSSocialButton dSSocialButton, @NonNull DSSocialButton dSSocialButton2, @NonNull DSSocialButton dSSocialButton3, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LoginLifecycleVoucherView loginLifecycleVoucherView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.btnLoginWithEmail = dSSocialButton;
        this.btnLoginWithFacebook = dSSocialButton2;
        this.btnLoginWithGoogle = dSSocialButton3;
        this.containerImageAndDescription = constraintLayout2;
        this.containerLoginOptions = constraintLayout3;
        this.containerTitleDescription = constraintLayout4;
        this.imageLogo = imageView2;
        this.imageView = imageView3;
        this.lifeCycleVoucherLoginInfoView = loginLifecycleVoucherView;
        this.textLogoText = textView;
        this.txtDescription = textView2;
        this.txtTitle = textView3;
    }

    @NonNull
    public static LayoutLoginOptionsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.btnLoginWithEmail;
        DSSocialButton dSSocialButton = (DSSocialButton) ViewBindings.findChildViewById(view2, i11);
        if (dSSocialButton != null) {
            i11 = R.id.btnLoginWithFacebook;
            DSSocialButton dSSocialButton2 = (DSSocialButton) ViewBindings.findChildViewById(view2, i11);
            if (dSSocialButton2 != null) {
                i11 = R.id.btnLoginWithGoogle;
                DSSocialButton dSSocialButton3 = (DSSocialButton) ViewBindings.findChildViewById(view2, i11);
                if (dSSocialButton3 != null) {
                    i11 = R.id.containerImageAndDescription;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                    if (constraintLayout != null) {
                        i11 = R.id.containerLoginOptions;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                        if (constraintLayout2 != null) {
                            i11 = R.id.containerTitleDescription;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                            if (constraintLayout3 != null) {
                                i11 = R.id.imageLogo;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                if (imageView2 != null) {
                                    i11 = R.id.imageView;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                    if (imageView3 != null) {
                                        i11 = R.id.lifeCycleVoucherLoginInfoView;
                                        LoginLifecycleVoucherView loginLifecycleVoucherView = (LoginLifecycleVoucherView) ViewBindings.findChildViewById(view2, i11);
                                        if (loginLifecycleVoucherView != null) {
                                            i11 = R.id.textLogoText;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
                                            if (textView != null) {
                                                i11 = R.id.txtDescription;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                if (textView2 != null) {
                                                    i11 = R.id.txtTitle;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView3 != null) {
                                                        return new LayoutLoginOptionsBinding((ConstraintLayout) view2, dSSocialButton, dSSocialButton2, dSSocialButton3, constraintLayout, constraintLayout2, constraintLayout3, imageView2, imageView3, loginLifecycleVoucherView, textView, textView2, textView3);
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
    public static LayoutLoginOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutLoginOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_login_options, viewGroup, false);
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
