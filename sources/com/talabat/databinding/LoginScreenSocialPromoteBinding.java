package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView;
import com.talabat.helpers.TalabatNestedScrollView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class LoginScreenSocialPromoteBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final LoginInfoContainerBinding defaultLoginInfoView;
    @NonNull
    public final Button expressCheckout;
    @NonNull
    public final LoginLifecycleVoucherView lifeCycleVoucherLoginInfoView;
    @NonNull
    public final LinearLayout llLoginMainContainer;
    @NonNull
    public final LinearLayout llLoginSocialContainer;
    @NonNull
    public final LinearLayout llLoginWithEmailContainer;
    @NonNull
    public final ViewStub loginButtonsStub;
    @NonNull
    public final TalabatNestedScrollView loginScrollView;
    @NonNull
    public final LinearLayout loginWithMobile;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private LoginScreenSocialPromoteBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull LoginInfoContainerBinding loginInfoContainerBinding, @NonNull Button button, @NonNull LoginLifecycleVoucherView loginLifecycleVoucherView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ViewStub viewStub, @NonNull TalabatNestedScrollView talabatNestedScrollView, @NonNull LinearLayout linearLayout5, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.defaultLoginInfoView = loginInfoContainerBinding;
        this.expressCheckout = button;
        this.lifeCycleVoucherLoginInfoView = loginLifecycleVoucherView;
        this.llLoginMainContainer = linearLayout2;
        this.llLoginSocialContainer = linearLayout3;
        this.llLoginWithEmailContainer = linearLayout4;
        this.loginButtonsStub = viewStub;
        this.loginScrollView = talabatNestedScrollView;
        this.loginWithMobile = linearLayout5;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static LoginScreenSocialPromoteBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.defaultLoginInfoView;
            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.defaultLoginInfoView);
            if (findChildViewById != null) {
                LoginInfoContainerBinding bind = LoginInfoContainerBinding.bind(findChildViewById);
                i11 = R.id.express_checkout;
                Button button = (Button) ViewBindings.findChildViewById(view2, R.id.express_checkout);
                if (button != null) {
                    i11 = R.id.lifeCycleVoucherLoginInfoView;
                    LoginLifecycleVoucherView loginLifecycleVoucherView = (LoginLifecycleVoucherView) ViewBindings.findChildViewById(view2, R.id.lifeCycleVoucherLoginInfoView);
                    if (loginLifecycleVoucherView != null) {
                        i11 = R.id.ll_login_main_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_login_main_container);
                        if (linearLayout != null) {
                            i11 = R.id.ll_login_social_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_login_social_container);
                            if (linearLayout2 != null) {
                                i11 = R.id.ll_login_with_email_container;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_login_with_email_container);
                                if (linearLayout3 != null) {
                                    i11 = R.id.login_buttons_stub;
                                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view2, R.id.login_buttons_stub);
                                    if (viewStub != null) {
                                        i11 = R.id.loginScrollView;
                                        TalabatNestedScrollView talabatNestedScrollView = (TalabatNestedScrollView) ViewBindings.findChildViewById(view2, R.id.loginScrollView);
                                        if (talabatNestedScrollView != null) {
                                            i11 = R.id.login_with_mobile;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.login_with_mobile);
                                            if (linearLayout4 != null) {
                                                i11 = R.id.title;
                                                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                if (talabatToolBarTextView != null) {
                                                    i11 = R.id.toolbar;
                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                    if (talabatToolBar != null) {
                                                        return new LoginScreenSocialPromoteBinding((LinearLayout) view2, talabatToolBarImageButton, bind, button, loginLifecycleVoucherView, linearLayout, linearLayout2, linearLayout3, viewStub, talabatNestedScrollView, linearLayout4, talabatToolBarTextView, talabatToolBar);
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
    public static LoginScreenSocialPromoteBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginScreenSocialPromoteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_screen_social_promote, viewGroup, false);
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
