package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarLinearLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class PurcahaseTalabatCreditBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatTextView buyCreditAmount;
    @NonNull
    public final TalabatFillButton buyCreditButton;
    @NonNull
    public final ImageButton buyCreditMinus;
    @NonNull
    public final ImageButton buyCreditPlus;
    @NonNull
    public final NestedScrollView contentView;
    @NonNull
    public final LinearLayout increaseQty;
    @NonNull
    public final LinearLayout increaseQtyPlus;
    @NonNull
    public final RelativeLayout loadingLayout;
    @NonNull
    public final LinearLayout purchaseCreditContentView;
    @NonNull
    private final TalabatToolBarLinearLayoutContainer rootView;
    @NonNull
    public final TalabatTextView talabatCreditDescription;
    @NonNull
    public final TalabatTextView talabatCreditTerms;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private PurcahaseTalabatCreditBinding(@NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatFillButton talabatFillButton, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = talabatToolBarLinearLayoutContainer;
        this.back = talabatToolBarImageButton;
        this.buyCreditAmount = talabatTextView;
        this.buyCreditButton = talabatFillButton;
        this.buyCreditMinus = imageButton;
        this.buyCreditPlus = imageButton2;
        this.contentView = nestedScrollView;
        this.increaseQty = linearLayout;
        this.increaseQtyPlus = linearLayout2;
        this.loadingLayout = relativeLayout;
        this.purchaseCreditContentView = linearLayout3;
        this.talabatCreditDescription = talabatTextView2;
        this.talabatCreditTerms = talabatTextView3;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static PurcahaseTalabatCreditBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.buy_credit_amount;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.buy_credit_amount);
            if (talabatTextView != null) {
                i11 = R.id.buy_credit_button;
                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.buy_credit_button);
                if (talabatFillButton != null) {
                    i11 = R.id.buy_credit_minus;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.buy_credit_minus);
                    if (imageButton != null) {
                        i11 = R.id.buy_credit_plus;
                        ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.buy_credit_plus);
                        if (imageButton2 != null) {
                            i11 = R.id.content_view;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.content_view);
                            if (nestedScrollView != null) {
                                i11 = R.id.increase_qty;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.increase_qty);
                                if (linearLayout != null) {
                                    i11 = R.id.increase_qty_plus;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.increase_qty_plus);
                                    if (linearLayout2 != null) {
                                        i11 = R.id.loading_layout;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.loading_layout);
                                        if (relativeLayout != null) {
                                            i11 = R.id.purchase_credit_content_view;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.purchase_credit_content_view);
                                            if (linearLayout3 != null) {
                                                i11 = R.id.talabat_credit_description;
                                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_description);
                                                if (talabatTextView2 != null) {
                                                    i11 = R.id.talabat_credit_terms;
                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabat_credit_terms);
                                                    if (talabatTextView3 != null) {
                                                        i11 = R.id.title;
                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                        if (talabatToolBarTextView != null) {
                                                            i11 = R.id.toolbar;
                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                            if (talabatToolBar != null) {
                                                                return new PurcahaseTalabatCreditBinding((TalabatToolBarLinearLayoutContainer) view2, talabatToolBarImageButton, talabatTextView, talabatFillButton, imageButton, imageButton2, nestedScrollView, linearLayout, linearLayout2, relativeLayout, linearLayout3, talabatTextView2, talabatTextView3, talabatToolBarTextView, talabatToolBar);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PurcahaseTalabatCreditBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PurcahaseTalabatCreditBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.purcahase_talabat_credit, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarLinearLayoutContainer getRoot() {
        return this.rootView;
    }
}
