package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ActivityWalletDisplayAllCreditCardsScreenBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appBarLayout2;
    @NonNull
    public final ImageButton back;
    @NonNull
    public final CoordinatorLayout containerAll;
    @NonNull
    public final RecyclerView creditCardList;
    @NonNull
    public final TalabatTextView editTextView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final WalletEmptyResponseViewBinding walletEmptyView;

    private ActivityWalletDisplayAllCreditCardsScreenBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ImageButton imageButton, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull RecyclerView recyclerView, @NonNull TalabatTextView talabatTextView, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView2, @NonNull Toolbar toolbar2, @NonNull WalletEmptyResponseViewBinding walletEmptyResponseViewBinding) {
        this.rootView = coordinatorLayout;
        this.appBarLayout2 = appBarLayout;
        this.back = imageButton;
        this.containerAll = coordinatorLayout2;
        this.creditCardList = recyclerView;
        this.editTextView = talabatTextView;
        this.progressBar = progressBar2;
        this.talabatToolbar = relativeLayout;
        this.title = talabatTextView2;
        this.toolbar = toolbar2;
        this.walletEmptyView = walletEmptyResponseViewBinding;
    }

    @NonNull
    public static ActivityWalletDisplayAllCreditCardsScreenBinding bind(@NonNull View view) {
        int i11 = R.id.appBarLayout2;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout2);
        if (appBarLayout != null) {
            i11 = R.id.back;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back);
            if (imageButton != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                i11 = R.id.credit_card_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.credit_card_list);
                if (recyclerView != null) {
                    i11 = R.id.edit_text_view;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.edit_text_view);
                    if (talabatTextView != null) {
                        i11 = R.id.progressBar;
                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                        if (progressBar2 != null) {
                            i11 = R.id.talabat_toolbar;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_toolbar);
                            if (relativeLayout != null) {
                                i11 = R.id.title;
                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                                if (talabatTextView2 != null) {
                                    i11 = R.id.toolbar;
                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar2 != null) {
                                        i11 = R.id.wallet_empty_view;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.wallet_empty_view);
                                        if (findChildViewById != null) {
                                            return new ActivityWalletDisplayAllCreditCardsScreenBinding(coordinatorLayout, appBarLayout, imageButton, coordinatorLayout, recyclerView, talabatTextView, progressBar2, relativeLayout, talabatTextView2, toolbar2, WalletEmptyResponseViewBinding.bind(findChildViewById));
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
    public static ActivityWalletDisplayAllCreditCardsScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWalletDisplayAllCreditCardsScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_display_all_credit_cards_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
