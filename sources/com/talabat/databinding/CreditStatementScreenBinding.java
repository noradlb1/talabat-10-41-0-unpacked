package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CreditStatementScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final RecyclerView creditList;
    @NonNull
    public final CardView deliveryAddressView;
    @NonNull
    public final RelativeLayout headerCredit;
    @NonNull
    public final RelativeLayout loadingLayout;
    @NonNull
    public final ImageView noTransactionsImage;
    @NonNull
    public final LinearLayout noTransactionsView;
    @NonNull
    public final TalabatTextView remainingCreditAmount;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final FrameLayout separator;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;

    private CreditStatementScreenBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull RecyclerView recyclerView, @NonNull CardView cardView, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull FrameLayout frameLayout, @NonNull TalabatTextView talabatTextView2, @NonNull Toolbar toolbar2) {
        this.rootView = linearLayout;
        this.back = imageButton;
        this.creditList = recyclerView;
        this.deliveryAddressView = cardView;
        this.headerCredit = relativeLayout;
        this.loadingLayout = relativeLayout2;
        this.noTransactionsImage = imageView;
        this.noTransactionsView = linearLayout2;
        this.remainingCreditAmount = talabatTextView;
        this.separator = frameLayout;
        this.title = talabatTextView2;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static CreditStatementScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (imageButton != null) {
            i11 = R.id.credit_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.credit_list);
            if (recyclerView != null) {
                i11 = R.id.delivery_address_view;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.delivery_address_view);
                if (cardView != null) {
                    i11 = R.id.header_credit;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.header_credit);
                    if (relativeLayout != null) {
                        i11 = R.id.loading_layout;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.loading_layout);
                        if (relativeLayout2 != null) {
                            i11 = R.id.no_transactions_image;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.no_transactions_image);
                            if (imageView != null) {
                                i11 = R.id.no_transactions_view;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.no_transactions_view);
                                if (linearLayout != null) {
                                    i11 = R.id.remaining_credit_amount;
                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.remaining_credit_amount);
                                    if (talabatTextView != null) {
                                        i11 = R.id.separator;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.separator);
                                        if (frameLayout != null) {
                                            i11 = R.id.title;
                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                                            if (talabatTextView2 != null) {
                                                i11 = R.id.toolbar;
                                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                if (toolbar2 != null) {
                                                    return new CreditStatementScreenBinding((LinearLayout) view, imageButton, recyclerView, cardView, relativeLayout, relativeLayout2, imageView, linearLayout, talabatTextView, frameLayout, talabatTextView2, toolbar2);
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
    public static CreditStatementScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CreditStatementScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.credit_statement_screen, viewGroup, false);
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
