package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class CreditStatementScreenRBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final RecyclerView creditStatementList;
    @NonNull
    public final LinearLayout creditStatementListContainer;
    @NonNull
    public final LinearLayout headerContainer;
    @NonNull
    public final ImageView noTransactionsImage;
    @NonNull
    public final LinearLayout noTransactionsView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final CardView talCreditStatmentContainer;
    @NonNull
    public final TalabatTextView talaCreditAmntTxt;
    @NonNull
    public final TalabatTextView talaCreditDebitTxt;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private CreditStatementScreenRBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull ProgressBar progressBar2, @NonNull CardView cardView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.back = talabatToolBarImageButton;
        this.creditStatementList = recyclerView;
        this.creditStatementListContainer = linearLayout;
        this.headerContainer = linearLayout2;
        this.noTransactionsImage = imageView;
        this.noTransactionsView = linearLayout3;
        this.progressBar = progressBar2;
        this.talCreditStatmentContainer = cardView;
        this.talaCreditAmntTxt = talabatTextView;
        this.talaCreditDebitTxt = talabatTextView2;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static CreditStatementScreenRBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.credit_statement_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.credit_statement_list);
            if (recyclerView != null) {
                i11 = R.id.credit_statement_list_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.credit_statement_list_container);
                if (linearLayout != null) {
                    i11 = R.id.header_container;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.header_container);
                    if (linearLayout2 != null) {
                        i11 = R.id.no_transactions_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_transactions_image);
                        if (imageView != null) {
                            i11 = R.id.no_transactions_view;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_transactions_view);
                            if (linearLayout3 != null) {
                                i11 = R.id.progress_bar;
                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress_bar);
                                if (progressBar2 != null) {
                                    i11 = R.id.tal_credit_statment_container;
                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.tal_credit_statment_container);
                                    if (cardView != null) {
                                        i11 = R.id.tala_credit_amnt_txt;
                                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tala_credit_amnt_txt);
                                        if (talabatTextView != null) {
                                            i11 = R.id.tala_credit_debit_txt;
                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tala_credit_debit_txt);
                                            if (talabatTextView2 != null) {
                                                i11 = R.id.title;
                                                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                if (talabatToolBarTextView != null) {
                                                    i11 = R.id.toolbar;
                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                    if (talabatToolBar != null) {
                                                        return new CreditStatementScreenRBinding((RelativeLayout) view2, talabatToolBarImageButton, recyclerView, linearLayout, linearLayout2, imageView, linearLayout3, progressBar2, cardView, talabatTextView, talabatTextView2, talabatToolBarTextView, talabatToolBar);
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
    public static CreditStatementScreenRBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CreditStatementScreenRBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.credit_statement_screen_r, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
