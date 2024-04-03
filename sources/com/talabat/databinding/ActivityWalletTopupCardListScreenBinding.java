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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ActivityWalletTopupCardListScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final RecyclerView creditCardList;
    @NonNull
    public final ConstraintLayout header;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final ConstraintLayout rootView;
    @NonNull
    private final ConstraintLayout rootView_;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final WalletEmptyResponseViewBinding walletEmptyView;

    private ActivityWalletTopupCardListScreenBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout2, @NonNull ProgressBar progressBar2, @NonNull ConstraintLayout constraintLayout3, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull Toolbar toolbar2, @NonNull WalletEmptyResponseViewBinding walletEmptyResponseViewBinding) {
        this.rootView_ = constraintLayout;
        this.back = imageButton;
        this.creditCardList = recyclerView;
        this.header = constraintLayout2;
        this.progressBar = progressBar2;
        this.rootView = constraintLayout3;
        this.talabatToolbar = relativeLayout;
        this.title = talabatTextView;
        this.toolbar = toolbar2;
        this.walletEmptyView = walletEmptyResponseViewBinding;
    }

    @NonNull
    public static ActivityWalletTopupCardListScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (imageButton != null) {
            i11 = R.id.credit_card_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.credit_card_list);
            if (recyclerView != null) {
                i11 = R.id.header;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.header);
                if (constraintLayout != null) {
                    i11 = R.id.progress_bar;
                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
                    if (progressBar2 != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i11 = R.id.talabat_toolbar;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_toolbar);
                        if (relativeLayout != null) {
                            i11 = R.id.title;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (talabatTextView != null) {
                                i11 = R.id.toolbar;
                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (toolbar2 != null) {
                                    i11 = R.id.wallet_empty_view;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.wallet_empty_view);
                                    if (findChildViewById != null) {
                                        return new ActivityWalletTopupCardListScreenBinding(constraintLayout2, imageButton, recyclerView, constraintLayout, progressBar2, constraintLayout2, relativeLayout, talabatTextView, toolbar2, WalletEmptyResponseViewBinding.bind(findChildViewById));
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
    public static ActivityWalletTopupCardListScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWalletTopupCardListScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_topup_card_list_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }
}
