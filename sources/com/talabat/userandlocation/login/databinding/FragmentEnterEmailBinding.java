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
import com.designsystem.ds_input_field.DSTextField;
import com.talabat.userandlocation.login.R;

public final class FragmentEnterEmailBinding implements ViewBinding {
    @NonNull
    public final CardView bottomCard;
    @NonNull
    public final DSPrimaryButton btnNext;
    @NonNull
    public final ConstraintLayout contentContainer;
    @NonNull
    public final DSTextField edtEmail;
    @NonNull
    public final DSHeaderView headerView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final TextView txtHeading1;
    @NonNull
    public final TextView txtHeading2;

    private FragmentEnterEmailBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull ConstraintLayout constraintLayout2, @NonNull DSTextField dSTextField, @NonNull DSHeaderView dSHeaderView, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.bottomCard = cardView;
        this.btnNext = dSPrimaryButton;
        this.contentContainer = constraintLayout2;
        this.edtEmail = dSTextField;
        this.headerView = dSHeaderView;
        this.scrollView = nestedScrollView;
        this.txtHeading1 = textView;
        this.txtHeading2 = textView2;
    }

    @NonNull
    public static FragmentEnterEmailBinding bind(@NonNull View view) {
        int i11 = R.id.bottomCard;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
        if (cardView != null) {
            i11 = R.id.btnNext;
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
            if (dSPrimaryButton != null) {
                i11 = R.id.contentContainer;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                if (constraintLayout != null) {
                    i11 = R.id.edtEmail;
                    DSTextField dSTextField = (DSTextField) ViewBindings.findChildViewById(view, i11);
                    if (dSTextField != null) {
                        i11 = R.id.headerView;
                        DSHeaderView dSHeaderView = (DSHeaderView) ViewBindings.findChildViewById(view, i11);
                        if (dSHeaderView != null) {
                            i11 = R.id.scrollView;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i11);
                            if (nestedScrollView != null) {
                                i11 = R.id.txtHeading1;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView != null) {
                                    i11 = R.id.txtHeading2;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView2 != null) {
                                        return new FragmentEnterEmailBinding((ConstraintLayout) view, cardView, dSPrimaryButton, constraintLayout, dSTextField, dSHeaderView, nestedScrollView, textView, textView2);
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
    public static FragmentEnterEmailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentEnterEmailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_email, viewGroup, false);
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
