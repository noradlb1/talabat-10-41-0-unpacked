package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;

public final class ViewCardListBinding implements ViewBinding {
    @NonNull
    public final DSAlertView alert;
    @NonNull
    public final ImageButton back;
    @NonNull
    public final ConstraintLayout cardListContainer;
    @NonNull
    public final RecyclerView creditCardList;
    @NonNull
    public final ConstraintLayout header;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TextView title;
    @NonNull
    public final Toolbar toolbar;

    private ViewCardListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSAlertView dSAlertView, @NonNull ImageButton imageButton, @NonNull ConstraintLayout constraintLayout2, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout3, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull Toolbar toolbar2) {
        this.rootView = constraintLayout;
        this.alert = dSAlertView;
        this.back = imageButton;
        this.cardListContainer = constraintLayout2;
        this.creditCardList = recyclerView;
        this.header = constraintLayout3;
        this.progressBar = progressBar2;
        this.talabatToolbar = relativeLayout;
        this.title = textView;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static ViewCardListBinding bind(@NonNull View view) {
        int i11 = R.id.alert;
        DSAlertView dSAlertView = (DSAlertView) ViewBindings.findChildViewById(view, i11);
        if (dSAlertView != null) {
            i11 = R.id.back;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
            if (imageButton != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R.id.credit_card_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView != null) {
                    i11 = R.id.header;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                    if (constraintLayout2 != null) {
                        i11 = R.id.progress_bar;
                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                        if (progressBar2 != null) {
                            i11 = R.id.talabat_toolbar;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                            if (relativeLayout != null) {
                                i11 = R.id.title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView != null) {
                                    i11 = R.id.toolbar;
                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
                                    if (toolbar2 != null) {
                                        return new ViewCardListBinding(constraintLayout, dSAlertView, imageButton, constraintLayout, recyclerView, constraintLayout2, progressBar2, relativeLayout, textView, toolbar2);
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
    public static ViewCardListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewCardListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_card_list, viewGroup, false);
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
