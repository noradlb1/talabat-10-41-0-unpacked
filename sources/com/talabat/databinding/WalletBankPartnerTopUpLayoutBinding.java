package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class WalletBankPartnerTopUpLayoutBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView bankPartnerDetails;
    @NonNull
    public final ImageView bankPartnerLogo;
    @NonNull
    public final TalabatTextView bankPartnerTitle;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TableRow tableHeader;
    @NonNull
    public final TableRow tableRow;

    private WalletBankPartnerTopUpLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TableRow tableRow2, @NonNull TableRow tableRow3) {
        this.rootView = constraintLayout;
        this.bankPartnerDetails = talabatTextView;
        this.bankPartnerLogo = imageView;
        this.bankPartnerTitle = talabatTextView2;
        this.container = constraintLayout2;
        this.tableHeader = tableRow2;
        this.tableRow = tableRow3;
    }

    @NonNull
    public static WalletBankPartnerTopUpLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.bank_partner_details;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.bank_partner_details);
        if (talabatTextView != null) {
            i11 = R.id.bank_partner_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bank_partner_logo);
            if (imageView != null) {
                i11 = R.id.bank_partner_title;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.bank_partner_title);
                if (talabatTextView2 != null) {
                    i11 = R.id.container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.container);
                    if (constraintLayout != null) {
                        i11 = R.id.table_header;
                        TableRow tableRow2 = (TableRow) ViewBindings.findChildViewById(view, R.id.table_header);
                        if (tableRow2 != null) {
                            i11 = R.id.table_row;
                            TableRow tableRow3 = (TableRow) ViewBindings.findChildViewById(view, R.id.table_row);
                            if (tableRow3 != null) {
                                return new WalletBankPartnerTopUpLayoutBinding((ConstraintLayout) view, talabatTextView, imageView, talabatTextView2, constraintLayout, tableRow2, tableRow3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static WalletBankPartnerTopUpLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletBankPartnerTopUpLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_bank_partner_top_up_layout, viewGroup, false);
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
