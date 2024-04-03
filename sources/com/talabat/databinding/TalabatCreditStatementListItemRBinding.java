package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class TalabatCreditStatementListItemRBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView creditAmountTxt;
    @NonNull
    public final TalabatTextView creditExpDetailsTxt;
    @NonNull
    public final TalabatTextView creditTotalTxt;
    @NonNull
    public final TalabatTextView dateText;
    @NonNull
    public final LinearLayout dateTimeContainer;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView talCreditStatusTxt;
    @NonNull
    public final TalabatTextView timeText;
    @NonNull
    public final FrameLayout topDivider;

    private TalabatCreditStatementListItemRBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.creditAmountTxt = talabatTextView;
        this.creditExpDetailsTxt = talabatTextView2;
        this.creditTotalTxt = talabatTextView3;
        this.dateText = talabatTextView4;
        this.dateTimeContainer = linearLayout2;
        this.talCreditStatusTxt = talabatTextView5;
        this.timeText = talabatTextView6;
        this.topDivider = frameLayout;
    }

    @NonNull
    public static TalabatCreditStatementListItemRBinding bind(@NonNull View view) {
        int i11 = R.id.credit_amount_txt;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_amount_txt);
        if (talabatTextView != null) {
            i11 = R.id.credit_exp_details_txt;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_exp_details_txt);
            if (talabatTextView2 != null) {
                i11 = R.id.credit_total_txt;
                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.credit_total_txt);
                if (talabatTextView3 != null) {
                    i11 = R.id.date_text;
                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.date_text);
                    if (talabatTextView4 != null) {
                        i11 = R.id.date_time_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.date_time_container);
                        if (linearLayout != null) {
                            i11 = R.id.tal_credit_status_txt;
                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tal_credit_status_txt);
                            if (talabatTextView5 != null) {
                                i11 = R.id.time_text;
                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.time_text);
                                if (talabatTextView6 != null) {
                                    i11 = R.id.top_divider;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.top_divider);
                                    if (frameLayout != null) {
                                        return new TalabatCreditStatementListItemRBinding((LinearLayout) view, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, linearLayout, talabatTextView5, talabatTextView6, frameLayout);
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
    public static TalabatCreditStatementListItemRBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatCreditStatementListItemRBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabat_credit_statement_list_item_r, viewGroup, false);
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
