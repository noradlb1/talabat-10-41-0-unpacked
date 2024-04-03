package com.talabat.userandlocation.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_header.DSHeaderView;
import com.designsystem.ds_input_field.DSPasswordField;
import com.designsystem.ds_text_link.DSTextLink;
import com.talabat.userandlocation.login.R;

public final class FragmentEnterPasswordBinding implements ViewBinding {
    @NonNull
    public final CardView bottomCard;
    @NonNull
    public final DSPrimaryButton btnLogIn;
    @NonNull
    public final ConstraintLayout contentContainer;
    @NonNull
    public final DSPasswordField edtPassword;
    @NonNull
    public final DSHeaderView headerView;
    @NonNull
    public final ConstraintLayout parentLayout;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final TextView txtEmail;
    @NonNull
    public final DSTextLink txtForgotPassword;
    @NonNull
    public final TextView txtHeading1;
    @NonNull
    public final TextView txtHeading2;

    private FragmentEnterPasswordBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull ConstraintLayout constraintLayout2, @NonNull DSPasswordField dSPasswordField, @NonNull DSHeaderView dSHeaderView, @NonNull ConstraintLayout constraintLayout3, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull DSTextLink dSTextLink, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.bottomCard = cardView;
        this.btnLogIn = dSPrimaryButton;
        this.contentContainer = constraintLayout2;
        this.edtPassword = dSPasswordField;
        this.headerView = dSHeaderView;
        this.parentLayout = constraintLayout3;
        this.scrollView = nestedScrollView;
        this.txtEmail = textView;
        this.txtForgotPassword = dSTextLink;
        this.txtHeading1 = textView2;
        this.txtHeading2 = textView3;
    }

    @NonNull
    public static FragmentEnterPasswordBinding bind(@NonNull View view) {
        int i11 = R.id.bottomCard;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
        if (cardView != null) {
            i11 = R.id.btnLogIn;
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
            if (dSPrimaryButton != null) {
                i11 = R.id.contentContainer;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                if (constraintLayout != null) {
                    i11 = R.id.edtPassword;
                    DSPasswordField dSPasswordField = (DSPasswordField) ViewBindings.findChildViewById(view, i11);
                    if (dSPasswordField != null) {
                        i11 = R.id.headerView;
                        DSHeaderView dSHeaderView = (DSHeaderView) ViewBindings.findChildViewById(view, i11);
                        if (dSHeaderView != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i11 = R.id.scrollView;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i11);
                            if (nestedScrollView != null) {
                                i11 = R.id.txtEmail;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView != null) {
                                    i11 = R.id.txtForgotPassword;
                                    DSTextLink dSTextLink = (DSTextLink) ViewBindings.findChildViewById(view, i11);
                                    if (dSTextLink != null) {
                                        i11 = R.id.txtHeading1;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView2 != null) {
                                            i11 = R.id.txtHeading2;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView3 != null) {
                                                return new FragmentEnterPasswordBinding(constraintLayout2, cardView, dSPrimaryButton, constraintLayout, dSPasswordField, dSHeaderView, constraintLayout2, nestedScrollView, textView, dSTextLink, textView2, textView3);
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
    public static FragmentEnterPasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentEnterPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_password, viewGroup, false);
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
