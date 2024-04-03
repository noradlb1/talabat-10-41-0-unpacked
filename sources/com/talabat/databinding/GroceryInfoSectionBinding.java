package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GroceryInfoSectionBinding implements ViewBinding {
    @NonNull
    public final LinearLayout deliveryFeeCol;
    @NonNull
    public final LinearLayout deliveryTimeCol;
    @NonNull
    public final Guideline guideline1;
    @NonNull
    public final Guideline guideline2;
    @NonNull
    public final ConstraintLayout infoRow;
    @NonNull
    public final TalabatTextView infoSectionDeliveryFee;
    @NonNull
    public final TalabatTextView infoSectionDeliveryTime;
    @NonNull
    public final TalabatTextView infoSectionMinOrder;
    @NonNull
    public final LinearLayout minOrderCol;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View verDivider1;
    @NonNull
    public final View verDivider2;

    private GroceryInfoSectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Guideline guideline, @NonNull Guideline guideline3, @NonNull ConstraintLayout constraintLayout2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout3, @NonNull View view, @NonNull View view2) {
        this.rootView = constraintLayout;
        this.deliveryFeeCol = linearLayout;
        this.deliveryTimeCol = linearLayout2;
        this.guideline1 = guideline;
        this.guideline2 = guideline3;
        this.infoRow = constraintLayout2;
        this.infoSectionDeliveryFee = talabatTextView;
        this.infoSectionDeliveryTime = talabatTextView2;
        this.infoSectionMinOrder = talabatTextView3;
        this.minOrderCol = linearLayout3;
        this.verDivider1 = view;
        this.verDivider2 = view2;
    }

    @NonNull
    public static GroceryInfoSectionBinding bind(@NonNull View view) {
        int i11 = R.id.delivery_fee_col;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.delivery_fee_col);
        if (linearLayout != null) {
            i11 = R.id.delivery_time_col;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.delivery_time_col);
            if (linearLayout2 != null) {
                i11 = R.id.guideline1;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline1);
                if (guideline != null) {
                    i11 = R.id.guideline2;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline2);
                    if (guideline3 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i11 = R.id.info_section_delivery_fee;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.info_section_delivery_fee);
                        if (talabatTextView != null) {
                            i11 = R.id.info_section_delivery_time;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.info_section_delivery_time);
                            if (talabatTextView2 != null) {
                                i11 = R.id.info_section_min_order;
                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.info_section_min_order);
                                if (talabatTextView3 != null) {
                                    i11 = R.id.min_order_col;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.min_order_col);
                                    if (linearLayout3 != null) {
                                        i11 = R.id.ver_divider_1;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ver_divider_1);
                                        if (findChildViewById != null) {
                                            i11 = R.id.ver_divider_2;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.ver_divider_2);
                                            if (findChildViewById2 != null) {
                                                return new GroceryInfoSectionBinding(constraintLayout, linearLayout, linearLayout2, guideline, guideline3, constraintLayout, talabatTextView, talabatTextView2, talabatTextView3, linearLayout3, findChildViewById, findChildViewById2);
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
    public static GroceryInfoSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GroceryInfoSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_info_section, viewGroup, false);
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
