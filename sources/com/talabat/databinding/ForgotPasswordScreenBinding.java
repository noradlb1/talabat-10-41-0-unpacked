package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.MobileNumberEditText;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ForgotPasswordScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatFillButton btnSubmitEmail;
    @NonNull
    public final TalabatToolBarImageButton cart;
    @NonNull
    public final TalabatToolBarButton cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final TalabatToolBarButton done;
    @NonNull
    public final MobileNumberEditText eTMobileNumber;
    @NonNull
    public final MaterialEditText eTxtEmail;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private ForgotPasswordScreenBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatToolBarImageButton talabatToolBarImageButton2, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarButton talabatToolBarButton2, @NonNull MobileNumberEditText mobileNumberEditText, @NonNull MaterialEditText materialEditText, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.btnSubmitEmail = talabatFillButton;
        this.cart = talabatToolBarImageButton2;
        this.cartCount = talabatToolBarButton;
        this.cartHolder = relativeLayout;
        this.done = talabatToolBarButton2;
        this.eTMobileNumber = mobileNumberEditText;
        this.eTxtEmail = materialEditText;
        this.talabatToolbar = relativeLayout2;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static ForgotPasswordScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.btnSubmitEmail;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.btnSubmitEmail);
            if (talabatFillButton != null) {
                i11 = R.id.cart;
                TalabatToolBarImageButton talabatToolBarImageButton2 = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.cart);
                if (talabatToolBarImageButton2 != null) {
                    i11 = R.id.cart_count;
                    TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view, R.id.cart_count);
                    if (talabatToolBarButton != null) {
                        i11 = R.id.cart_holder;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.cart_holder);
                        if (relativeLayout != null) {
                            i11 = R.id.done;
                            TalabatToolBarButton talabatToolBarButton2 = (TalabatToolBarButton) ViewBindings.findChildViewById(view, R.id.done);
                            if (talabatToolBarButton2 != null) {
                                i11 = R.id.eTMobileNumber;
                                MobileNumberEditText mobileNumberEditText = (MobileNumberEditText) ViewBindings.findChildViewById(view, R.id.eTMobileNumber);
                                if (mobileNumberEditText != null) {
                                    i11 = R.id.eTxtEmail;
                                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.eTxtEmail);
                                    if (materialEditText != null) {
                                        i11 = R.id.talabat_toolbar;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_toolbar);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.title;
                                            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                                            if (talabatToolBarTextView != null) {
                                                i11 = R.id.toolbar;
                                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                if (talabatToolBar != null) {
                                                    return new ForgotPasswordScreenBinding((LinearLayout) view, talabatToolBarImageButton, talabatFillButton, talabatToolBarImageButton2, talabatToolBarButton, relativeLayout, talabatToolBarButton2, mobileNumberEditText, materialEditText, relativeLayout2, talabatToolBarTextView, talabatToolBar);
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
    public static ForgotPasswordScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ForgotPasswordScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.forgot_password_screen, viewGroup, false);
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
